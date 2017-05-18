package com.greenfox.chatapp.repo;

import com.greenfox.chatapp.model.UserNames;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserNames, Long> {
}
