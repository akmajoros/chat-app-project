package com.greenfox.chatapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Log {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String path;
  private String method;
  private Timestamp timestamp;
  private String logLevel;
  private String reqData;

  public Log(){
    this.path = "path";
    this.method = "method";
    this.timestamp = new Timestamp(System.currentTimeMillis());
    this.logLevel = "logLevel";
    this.reqData = "reqData";
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getReqData() {
    return reqData;
  }

  public void setReqData(String reqData) {
    this.reqData = reqData;
  }
}
