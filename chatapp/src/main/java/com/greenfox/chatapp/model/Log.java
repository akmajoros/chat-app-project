package com.greenfox.chatapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Log {

  LocalDateTime timestamp;
  String logLevel;
  String path;
  String method;
  String reqData;

  public Log(String logLevel, String path, String method, String reqData) {
    this.timestamp = LocalDateTime.now();
    this.logLevel = logLevel;
    this.path = path;
    this.method = method;
    this.reqData = reqData;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
    return timestamp.format(formatter) + " " + logLevel + " Request " + path + " " + method + " " + reqData;
  }
}
