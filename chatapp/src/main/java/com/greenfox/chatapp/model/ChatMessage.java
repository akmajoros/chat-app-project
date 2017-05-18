package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Component
public class ChatMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  String username;
  String newMessage;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getNewMessage() {
    return newMessage;
  }

  public void setNewMessage(String newMessage) {
    this.newMessage = newMessage;
  }

  public void setId(){
    this.id = random();
  }

  private long random() {
    return (1000000+(long)(Math.random() * 9000000));
  }
}
