package com.greenfox.chatapp.controller;

import java.util.ArrayList;
import java.util.List;

import com.greenfox.chatapp.model.Client;
import com.greenfox.chatapp.model.Json;
import com.greenfox.chatapp.model.Status;
import com.greenfox.chatapp.model.StatusError;
import com.greenfox.chatapp.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainRestController {

  @Autowired
  MessageRepository messageRepository;
  @Autowired
  Status status;
  @Autowired
  StatusError statusError;
  @Autowired
  Client client;


  RestTemplate restTemplate = new RestTemplate();

  String url = "https://phorv1chatapp.herokuapp.com/";

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive")
  public Status receiveMessage(@RequestBody Json json) {

    List<String> errors = new ArrayList<>();

    if (StringUtils.isEmpty(json.getMessage().getText())) {
      errors.add("message.text");
    }
    if (StringUtils.isEmpty(json.getMessage().getUsername())) {
      errors.add("message.username");
    }
    if (StringUtils.isEmpty(json.getMessage().getTimestamp())) {
      errors.add("message.timestamp");
    }
    if (StringUtils.isEmpty(json.getMessage().getId())) {
      errors.add("message.id");
    }
    if (StringUtils.isEmpty(json.getClient().getId())) {
      errors.add("client.id");
    }

    if (errors.size() == 0) {
      messageRepository.save(json.getMessage());
      restTemplate.postForObject(url, json, Status.class);
    }

    status.setStatus("ok");
    statusError.setStatus("error");
    statusError.setMessage(errors);

    if (errors.size() == 0) return status;
    else return statusError;
  }
}
