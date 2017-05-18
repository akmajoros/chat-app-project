package com.greenfox.chatapp.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Component
public class ChatMessage {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  String username;
  String text;
  Timestamp timestamp;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setId(){
    this.id = random();
  }

  private long random() {
    return (1000000+(long)(Math.random() * 9000000));
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }
}
