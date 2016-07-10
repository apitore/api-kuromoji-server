package com.apitore.api.com.atilika.kuromoji.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.atilika.kuromoji.ipadic.neologd.Token;
import com.atilika.kuromoji.ipadic.neologd.Tokenizer;


/**
 * @author Keigo Hattori
 */
@Service
public class KuromojiIpadicNeologdService {

  Tokenizer tokenizer = new Tokenizer();

  public List<Token> tokenize(String text) {
    return tokenizer.tokenize(text);
  }

}
