package com.vvs.sendemail.service;

import com.vvs.sendemail.model.EmailResponse;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
  
  void sendMail(EmailResponse email);
  
}
