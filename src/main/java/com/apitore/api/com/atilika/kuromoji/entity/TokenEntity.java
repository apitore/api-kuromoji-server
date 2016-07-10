package com.apitore.api.com.atilika.kuromoji.entity;

import java.io.Serializable;

import com.atilika.kuromoji.ipadic.Token;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel
@Data
public class TokenEntity implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -3146346822669652297L;

  @ApiModelProperty(required=true, value="Surface")
  private String surface;
  @ApiModelProperty(required=true, value="Position")
  private Integer position;
  @ApiModelProperty(required=true, value="Part of speech level1")
  private String partOfSpeechLevel1;
  @ApiModelProperty(required=true, value="Part of speech level2")
  private String partOfSpeechLevel2;
  @ApiModelProperty(required=true, value="Part of speech level3")
  private String partOfSpeechLevel3;
  @ApiModelProperty(required=true, value="Part of speech level4")
  private String partOfSpeechLevel4;
  @ApiModelProperty(required=true, value="Conjugation type")
  private String conjugationType;
  @ApiModelProperty(required=true, value="Conjugation form")
  private String conjugationForm;
  @ApiModelProperty(required=true, value="Reading")
  private String reading;
  @ApiModelProperty(required=true, value="Base form")
  private String baseForm;
  @ApiModelProperty(required=true, value="Pronunciation")
  private String pronunciation;
  @ApiModelProperty(required=true, value="All features array")
  private String[] allFeaturesArray;
  @ApiModelProperty(required=true, value="Known")
  private Boolean known;
  @ApiModelProperty(required=true, value="All features")
  private String allFeatures;


  /* Constructor */
  public TokenEntity(Token token) {
    this.surface = token.getSurface();
    this.position = token.getPosition();
    this.partOfSpeechLevel1 = token.getPartOfSpeechLevel1();
    this.partOfSpeechLevel2 = token.getPartOfSpeechLevel2();
    this.partOfSpeechLevel3 = token.getPartOfSpeechLevel3();
    this.partOfSpeechLevel4 = token.getPartOfSpeechLevel4();
    this.conjugationType = token.getConjugationType();
    this.conjugationForm = token.getConjugationForm();
    this.reading = token.getReading();
    this.baseForm = token.getBaseForm();
    this.pronunciation = token.getPronunciation();
    this.allFeaturesArray = token.getAllFeaturesArray();
    this.known = token.isKnown();
    this.allFeatures = token.getAllFeatures();
  }

  public TokenEntity(com.atilika.kuromoji.ipadic.neologd.Token token) {
    this.surface = token.getSurface();
    this.position = token.getPosition();
    this.partOfSpeechLevel1 = token.getPartOfSpeechLevel1();
    this.partOfSpeechLevel2 = token.getPartOfSpeechLevel2();
    this.partOfSpeechLevel3 = token.getPartOfSpeechLevel3();
    this.partOfSpeechLevel4 = token.getPartOfSpeechLevel4();
    this.conjugationType = token.getConjugationType();
    this.conjugationForm = token.getConjugationForm();
    this.reading = token.getReading();
    this.baseForm = token.getBaseForm();
    this.pronunciation = token.getPronunciation();
    this.allFeaturesArray = token.getAllFeaturesArray();
    this.known = token.isKnown();
    this.allFeatures = token.getAllFeatures();
  }

}
