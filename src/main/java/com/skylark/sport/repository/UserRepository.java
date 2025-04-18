package com.skylark.sport.repository;

import com.skylark.sport.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {


    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

}
