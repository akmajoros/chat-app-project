package com.greenfox.chatapp.model;

import com.greenfox.chatapp.repo.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class UserNames {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  @Column(unique = true)
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
