package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.Json;
import com.greenfox.chatapp.model.Status;
import com.greenfox.chatapp.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainRestController {

  @Autowired
  MessageRepository messageRepository;
  @Autowired
  Status status;


  RestTemplate restTemplate = new RestTemplate();

  String url = "https://phorv1chatapp.herokuapp.com/";

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive")
  public Status receiveMessage(@RequestBody Json json) {

    messageRepository.save(json.getMessage());
    status.setStatus("ok");
    restTemplate.postForObject(url, json, Json.class);

    return status;
  }
}
