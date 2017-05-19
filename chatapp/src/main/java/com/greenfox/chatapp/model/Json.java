package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

public class Json {
  ChatMessage message;
  Client client;

  public Json(){

  }

  public ChatMessage getMessage() {
    return message;
  }

  public void setMessage(ChatMessage message) {
    this.message = message;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
