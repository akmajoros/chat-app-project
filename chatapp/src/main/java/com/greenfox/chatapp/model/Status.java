package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

@Component
public class Status {
  public void setStatus(String status) {

    this.status = status;
  }

  String status;

  public Status() {
    this.status = "ok";
  }

  public String getStatus() {
    return status;
  }
}
