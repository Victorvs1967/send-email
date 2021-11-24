package com.vvs.sendemail.config;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EmailConfig {
  
  @NotNull
  @Value("${spring.mail.host}")
  private String host;
  
  @NotNull
  @Value("${spring.mail.port}")
  private int port;

  @NotNull
  @Value("${spring.mail.username}")
  private String username;

  @NotNull
  @Value("${spring.mail.password}")
  private String password;

}
