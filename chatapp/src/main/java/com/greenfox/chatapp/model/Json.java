package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

@Component
public class Json {
  ChatMessage chatMessage;
  Client client;

  public ChatMessage getChatMessage() {
    return chatMessage;
  }

  public void setChatMessage(ChatMessage chatMessage) {
    this.chatMessage = chatMessage;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}
