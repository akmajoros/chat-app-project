package com.greenfox.chatapp.repo;

import com.greenfox.chatapp.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface UserRepository extends CrudRepository<Users, Long> {
}
