package com.skylark.sport.repository;

import com.skylark.sport.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMapperRespository extends JpaRepository<Activity, Integer> {

}
