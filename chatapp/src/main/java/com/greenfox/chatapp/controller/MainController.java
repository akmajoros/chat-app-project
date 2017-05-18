package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.Log;
import com.greenfox.chatapp.model.UserNames;
import com.greenfox.chatapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
public class MainController {

  @Autowired
  UserRepository repository;

  String chatAppUniqueId;
  String chatAppPeerAddress;

  public MainController() {
    this.chatAppUniqueId = System.getenv("CHAT_APP_UNIQUE_ID");
    this.chatAppPeerAddress = System.getenv("CHAT_APP_PEER_ADDRESS");
  }

  @ExceptionHandler(value = NoHandlerFoundException.class)
  public String notFound() {
    System.out.println("ERROR");
    return "index";
  }

  @RequestMapping(value = "/")
  public String indexPage() {
    String currentLogLevel = System.getenv("CHAT_APP_LOGLEVEL");
    if (currentLogLevel != null && currentLogLevel.equals("INFO")) {
      System.out.println(new Log("INFO", "/", "GET", "stuff"));
    }
    return "index";
  }

  @RequestMapping(value = "/enter")
  public String registerPage() {
    return "enter";
  }

  @PostMapping(value = "/enter")
  public String addNewUser(String username) {
    if (username.equals("")) {
      return "entererror";
    }
    repository.save(new UserNames(username));
    return "redirect:/";
  }
 }
