package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

@Component
public class Status {
  String status;

  public void setStatus(String status) {
    this.status = status;
  }
}
