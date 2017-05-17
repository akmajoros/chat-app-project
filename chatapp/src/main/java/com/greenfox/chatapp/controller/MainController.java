package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping(value = "/")
  public String indexPage() {
    String currentLogLevel = System.getenv("CHAT_APP_LOGLEVEL");
    if (currentLogLevel != null && currentLogLevel.equals("INFO")) {
      System.out.println(new Log("INFO", "/", "GET", "stuff"));
    } else {
      System.out.println("No INFO in loglevel variable");
    }
    return "index";
  }
}
