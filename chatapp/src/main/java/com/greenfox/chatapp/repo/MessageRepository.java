package com.greenfox.chatapp.repo;


import com.greenfox.chatapp.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<ChatMessage, Long> {
}
