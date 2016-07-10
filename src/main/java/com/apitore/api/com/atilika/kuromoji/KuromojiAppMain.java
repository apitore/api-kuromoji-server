package com.apitore.api.com.atilika.kuromoji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author Keigo Hattori
 */
@ComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class KuromojiAppMain {

  public static void main(String[] args) {
    SpringApplication.run(KuromojiAppMain.class, args);
  }

}
