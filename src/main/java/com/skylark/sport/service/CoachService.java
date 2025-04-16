package com.skylark.sport.service;

import com.skylark.sport.entity.Coach;

import java.util.List;

public interface CoachService {

    void saveCoach(Coach coach);

    Coach findCoachById(Long id);

    List<Coach> findAllCoaches();

    void deleteCoachById(Long id);

    Coach findByEmail(String email);
}
