package com.skylark.sport.repository;

import com.skylark.sport.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

    List<Coach> findByEmail(String email);

}
