package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

public class Json {
  ChatMessage message;
  Client client;

  public Json(){

  }

  public ChatMessage getChatMessage() {
    return message;
  }

  public void setChatMessage(ChatMessage message) {
    this.message = message;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
