package com.greenfox.chatapp.model;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class StatusError extends Status {

  String status;
  String message;

  public void setMessage(List<String> message) {
    this.message = "Missing field(s): ";
    for (String entry : message) {
      this.message += entry + ", ";
    }
    this.message = this.message.substring(0, this.message.length() - 2);
  }

  public StatusError(String message){
    this.status = "error";
    this.message = message;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
