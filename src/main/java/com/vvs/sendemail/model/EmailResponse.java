package com.vvs.sendemail.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailResponse {

  @NotNull
  private String subject;

  @NotNull
  @Email
  private String emailTo;

  @NotNull
  @Min(10)
  private String message;

}
