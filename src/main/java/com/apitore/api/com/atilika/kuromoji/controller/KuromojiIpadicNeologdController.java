package com.apitore.api.com.atilika.kuromoji.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apitore.api.com.atilika.kuromoji.service.KuromojiIpadicNeologdService;
import com.apitore.banana.request.com.atilika.kuromoji.KuromojiRequestEntity;
import com.apitore.banana.response.com.atilika.kuromoji.TokenEntity;
import com.apitore.banana.response.com.atilika.kuromoji.TokenResponseEntity;
import com.apitore.banana.response.com.atilika.kuromoji.TokensResponseEntity;
import com.atilika.kuromoji.ipadic.neologd.Token;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;


/**
 * @author Keigo Hattori
 */
@RestController
@RequestMapping(value = "/kuromoji-ipadic-neologd")
public class KuromojiIpadicNeologdController {

  @Autowired
  KuromojiIpadicNeologdService kuromojiIpadicNeologdService;

  final String NOTES = "Kuromoji IPADIC NEologd dictionary.<BR />"
      + "Response<BR />"
      + "&nbsp; Github: <a href=\"https://github.com/keigohtr/apitore-response-parent/tree/master/kuromoji-response\">kuromoji-response</a><BR />"
      + "&nbsp; Class: com.apitore.banana.response.com.atilika.kuromoji.TokenResponseEntity<BR />";


  @RequestMapping(value="/open/tokenize", method=RequestMethod.GET)
  @ApiIgnore
  public ResponseEntity<TokenResponseEntity> tokenize(
      @RequestParam("text") String text
      ) {

    TokenResponseEntity model = new TokenResponseEntity();
    Long startTime = System.currentTimeMillis();
    List<Token> tokens = kuromojiIpadicNeologdService.tokenize(text);
    List<TokenEntity> rtnTokens = new ArrayList<TokenEntity>();
    for (Token token: tokens) {
      rtnTokens.add(tokenToTokenEntity(token));
    }
    model.setTokens(rtnTokens);
    Long endTime = System.currentTimeMillis();
    Long processTime = endTime-startTime;
    model.setStartTime(startTime.toString());
    model.setEndTime(endTime.toString());
    model.setProcessTime(processTime.toString());
    return new ResponseEntity<TokenResponseEntity>(model,HttpStatus.OK);
  }

  private TokenEntity tokenToTokenEntity(Token token) {
    TokenEntity entity = new TokenEntity();
    entity.setSurface(            token.getSurface());
    entity.setPosition(           token.getPosition());
    entity.setPartOfSpeechLevel1( token.getPartOfSpeechLevel1());
    entity.setPartOfSpeechLevel2( token.getPartOfSpeechLevel2());
    entity.setPartOfSpeechLevel3( token.getPartOfSpeechLevel3());
    entity.setPartOfSpeechLevel4( token.getPartOfSpeechLevel4());
    entity.setConjugationType(    token.getConjugationType());
    entity.setConjugationForm(    token.getConjugationForm());
    entity.setReading(            token.getReading());
    entity.setBaseForm(           token.getBaseForm());
    entity.setPronunciation(      token.getPronunciation());
    entity.setAllFeaturesArray(   token.getAllFeaturesArray());
    entity.setKnown(              token.isKnown());
    entity.setAllFeatures(        token.getAllFeatures());
    return entity;
  }
  /**
   * 公開用API
   * Dummyメソッド
   *
   * @param model
   * @param q
   * @return
   */
  @RequestMapping(value = {"/tokenize"}, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
  @ApiOperation(value="Kuromoji IPADIC NEologd", notes=NOTES)
  public TokenResponseEntity tokenize(
      @ApiParam(value = "Access Token", required = true)
      @RequestParam("access_token")  String access_token,
      @ApiParam(value = "Text [up to 400 characters]", required = true)
      @RequestParam("text")      String text)
  {
    return new TokenResponseEntity();
  }


  /**
   * 実態
   *
   * @param req
   * @return
   */
  @RequestMapping(value="/open/tokenize", method=RequestMethod.POST)
  @ApiIgnore
  public ResponseEntity<TokensResponseEntity> tokenize(
      @RequestBody
      KuromojiRequestEntity req
      ) {

    TokensResponseEntity model = new TokensResponseEntity();
    Long startTime = System.currentTimeMillis();

    List<List<TokenEntity>> lists = new ArrayList<List<TokenEntity>>();
    for (String text: req.getTexts()) {
      List<Token> tokens = kuromojiIpadicNeologdService.tokenize(text);
      List<TokenEntity> rtnTokens = new ArrayList<TokenEntity>();
      for (Token token: tokens) {
        rtnTokens.add(tokenToTokenEntity(token));
      }
      lists.add(rtnTokens);
    }
    model.setTokens(lists);

    Long endTime = System.currentTimeMillis();
    Long processTime = endTime-startTime;
    model.setStartTime(startTime.toString());
    model.setEndTime(endTime.toString());
    model.setProcessTime(processTime.toString());
    return new ResponseEntity<TokensResponseEntity>(model,HttpStatus.OK);
  }
  /**
   * 公開用API
   * Dummyメソッド
   *
   * @param access_token
   * @param req
   * @return
   */
  @RequestMapping(value = {"/tokenize"}, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
  @ApiOperation(value="Kuromoji IPADIC NEologd", notes=NOTES)
  public TokensResponseEntity tokenize(
      @ApiParam(value = "Access Token", required = true)
      @RequestParam("access_token")  String access_token,
      @ApiParam(value = "Input Text", required = true)
      @RequestBody
      KuromojiRequestEntity req)
  {
    return new TokensResponseEntity();
  }

}
