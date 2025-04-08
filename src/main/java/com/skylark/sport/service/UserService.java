package com.skylark.sport.service;


import com.skylark.sport.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {


    User save(User user);


    User findByUsername(String name);


    Optional<User> findByEmail(String email);

}
