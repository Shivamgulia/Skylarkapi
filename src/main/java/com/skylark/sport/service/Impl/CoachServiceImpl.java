package com.skylark.sport.service.Impl;

import com.skylark.sport.repository.CoachRepository;
import com.skylark.sport.entity.Coach;
import com.skylark.sport.service.CoachService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public void saveCoach(Coach coach) {
        coachRepository.save(coach);
    }

    @Override
    public Coach findCoachById(Long id) {
        return coachRepository.findById(id).orElse(null);
    }

    @Override
    public List<Coach> findAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public void deleteCoachById(Long id) {
        coachRepository.deleteById(id);
    }

    @Override
    public Coach findByEmail(String email) {
        List<Coach> coaches =  coachRepository.findByEmail(email);
        if(coaches.size() < 1) return null;

        return coaches.get(0);
    }
}
