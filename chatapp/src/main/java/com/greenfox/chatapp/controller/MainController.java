package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.*;
import com.greenfox.chatapp.repo.MessageRepository;
import com.greenfox.chatapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.Timestamp;

@Controller
public class MainController {

  @Autowired
  UserRepository repository;
  @Autowired
  UserNames userNames;
  @Autowired
  MessageRepository messageRepository;
  @Autowired
  ChatMessage chatMessage;
  @Autowired
  Client client;

  RestTemplate restTemplate = new RestTemplate();

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
  public String indexPage(Model model) {
    String currentLogLevel = System.getenv("CHAT_APP_LOGLEVEL");
    if (currentLogLevel != null && currentLogLevel.equals("INFO")) {
      System.out.println(new Log("INFO", "/", "GET", "stuff"));
    }
    model.addAttribute("username", userNames.getUserName());
    model.addAttribute("messages", messageRepository.findAll());
    return "index";
  }

  @RequestMapping(value = "/enter")
  public String registerPage(Model model) {
    model.addAttribute("username", userNames.getUserName());
    return "enter";
  }

  @PostMapping(value = "/enter")
  public String addNewUser(String username) {
    if (username.equals("")) {
      return "entererror";
    }
    userNames.setUserName(username);
    userNames.setId(1l);
    repository.save(userNames);
    return "redirect:/";
  }

  String url = "https://phorv1chatapp.herokuapp.com/api/message/receive";

  @PostMapping(value = "/send")
  public String addMessage(String messages) {
    chatMessage.setId();
    chatMessage.setUsername(userNames.getUserName());
    chatMessage.setText(messages);
    chatMessage.setTimestamp(new Timestamp(System.currentTimeMillis()));
    messageRepository.save(chatMessage);

    client.setId("akmajoros");
    Json json = new Json();
    json.setMessage(chatMessage);
    json.setClient(client);
    restTemplate.postForObject(url, json, Json.class);
    return "redirect:/";
  }
 }
