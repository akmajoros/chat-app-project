package com.greenfox.chatapp.model;

import com.greenfox.chatapp.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class UserNames {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  String userName;

  public UserNames(){
  }

  public UserNames(String userName){
    this.userName = userName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
