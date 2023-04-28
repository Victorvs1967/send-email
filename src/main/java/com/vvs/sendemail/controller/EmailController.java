package com.vvs.sendemail.controller;

import com.vvs.sendemail.model.EmailResponse;
import com.vvs.sendemail.service.EmailService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

  private final EmailService emailService;

  @PostMapping("/send-email")
  public ResponseEntity<String> sendMail(@RequestBody EmailResponse emailResponse) {

    emailService.sendMail(emailResponse);

    return new ResponseEntity<String>("Email sent successfully!", HttpStatus.OK);
  }

}
