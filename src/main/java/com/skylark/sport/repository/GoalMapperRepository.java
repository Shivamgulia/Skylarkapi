package com.skylark.sport.repository;

import com.skylark.sport.entity.GoalMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalMapperRepository extends JpaRepository<GoalMapper, Long> {



}
