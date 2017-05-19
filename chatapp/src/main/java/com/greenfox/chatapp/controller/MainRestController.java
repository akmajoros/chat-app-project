package com.greenfox.chatapp.controller;

import com.greenfox.chatapp.model.Json;
import com.greenfox.chatapp.model.Status;
import com.greenfox.chatapp.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRestController {

  @Autowired
  MessageRepository messageRepository;
  @Autowired
  Status status;

  @CrossOrigin("*")
  @PostMapping(value = "/api/message/receive")
  public Status receivedMessage(@RequestBody Json json){
    System.out.println(json);
    messageRepository.save(json.getMessage());
    status.setStatus("ok");
    return status;
  }
}
