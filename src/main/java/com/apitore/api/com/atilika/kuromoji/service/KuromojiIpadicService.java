package com.apitore.api.com.atilika.kuromoji.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;


/**
 * @author Keigo Hattori
 */
@Service
public class KuromojiIpadicService {

  Tokenizer tokenizer = new Tokenizer();

  public List<Token> tokenize(String text) {
    return tokenizer.tokenize(text);
  }

}
