package com.skylark.sport.repository;

import com.skylark.sport.entity.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goals, Long> {


    List<Goals> findByCoach_Id(Long coachId);


}
