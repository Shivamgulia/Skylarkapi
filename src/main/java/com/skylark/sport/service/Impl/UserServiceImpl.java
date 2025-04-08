package com.skylark.sport.service.Impl;

import com.skylark.sport.entity.User;
import com.skylark.sport.repository.UserRepository;
import com.skylark.sport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    public UserRepository userRepository;


    @Override
    public User save(User user) {

        User savedUser  = userRepository.save(user);

        return savedUser;
    }

    @Override
    public User findByUsername(String email) {

        Optional<User> user = userRepository.findByEmail(email);



        if(user.isPresent()){

            return user.get();
        }

        return null;

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
