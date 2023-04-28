package com.vvs.sendemail.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.vvs.sendemail.config.EmailConfig;
import com.vvs.sendemail.model.EmailResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

  private final EmailConfig emailConfig;

  @Override
  public void sendMail(EmailResponse email) {

    Properties properties = new Properties();
    properties.put("mail.transport.protocol", "smtp");
    properties.put("mail.smtp.host", emailConfig.getHost());
    properties.put("mail.smtp.port", emailConfig.getPort());
    properties.put("mail.smtp.ssl.enable", emailConfig.getSsl());
    properties.put("mail.smtp.starttls.enable", emailConfig.getTtsl());
    properties.put("mail.smtp.auth", emailConfig.getAuth());

    Session session = Session.getInstance(properties, new Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(emailConfig.getUsername(), emailConfig.getPassword());
      }
    });
    session.setDebug(emailConfig.getDebug());

    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(emailConfig.getUsername()));
      message.addRecipient(RecipientType.TO, new InternetAddress(email.getEmailTo()));
      message.setSubject(email.getSubject());
      message.setContent(email.getMessage(), "text/html");

      System.out.println("sending...");
      Transport.send(message);
      System.out.println("Message sent successfuly...");
    } catch (MessagingException e) {
      e.printStackTrace();
    }
  }
}
