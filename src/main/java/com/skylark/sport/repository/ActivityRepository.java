package com.skylark.sport.repository;

import com.skylark.sport.entity.Activity;
import com.skylark.sport.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findByStudent_Id(Long studentId);

    List<Activity> findByStudent_IdAndMonth(Long studentId, int month);

    List<Activity> findByCoach_Id(Long coachId);

    List<Activity> findByCoach_IdAndMonth(Long coachId, int month);

    @Modifying
    @Transactional
    @Query("UPDATE Activity a SET a.approved = true WHERE a.id = :id")
    int markActivityAsApproved(@Param("id") Long id);

}
