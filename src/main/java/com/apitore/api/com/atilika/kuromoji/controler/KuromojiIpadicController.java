package com.apitore.api.com.atilika.kuromoji.controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apitore.api.com.atilika.kuromoji.entity.TokenEntity;
import com.apitore.api.com.atilika.kuromoji.entity.TokenResponseEntity;
import com.apitore.api.com.atilika.kuromoji.service.KuromojiIpadicService;
import com.atilika.kuromoji.ipadic.Token;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;


/**
 * @author Keigo Hattori
 */
@RestController
@RequestMapping(value = "/kuromoji-ipadic")
public class KuromojiIpadicController {

  @Autowired
  KuromojiIpadicService kuromojiIpadicService;

  @RequestMapping(value="/open/tokenize", method=RequestMethod.GET)
  @ApiIgnore
  public ResponseEntity<Map<String,Object>> tokenize(
      @RequestParam("text") String text
      ) throws IOException {

    Map<String, Object> model = new HashMap<String, Object>();
    Long startTime = System.currentTimeMillis();
    if (text.length()>400) {//FIXME ハードコーディング
      text = text.substring(0, 400);
    }
    List<Token> tokens = kuromojiIpadicService.tokenize(text);
    List<TokenEntity> rtnTokens = new ArrayList<TokenEntity>();
    for (Token token: tokens) {
      rtnTokens.add(new TokenEntity(token));
    }
    model.put("tokens", rtnTokens);
    Long endTime = System.currentTimeMillis();
    Long processTime = endTime-startTime;
    model.put("startTime",startTime.toString());
    model.put("endTime",endTime.toString());
    model.put("processTime",processTime.toString());
    return new ResponseEntity<Map<String,Object>>(model,HttpStatus.OK);
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
  @ApiOperation(value="Kuromoji IPADIC", notes="Kuromoji IPADIC dictionary")
  public TokenResponseEntity tokenize(
      @ApiParam(value = "Access Token", required = true)
      @RequestParam("access_token")  String access_token,
      @ApiParam(value = "Text [up to 400 characters]", required = true)
      @RequestParam("text")      String text)
  {
    return new TokenResponseEntity();
  }

}
