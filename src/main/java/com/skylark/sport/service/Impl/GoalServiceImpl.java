package com.skylark.sport.service.Impl;

import com.skylark.sport.entity.Goals;
import com.skylark.sport.repository.GoalRepository;
import com.skylark.sport.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalServiceImpl implements GoalService {

    @Autowired
    public GoalRepository goalRepository;

    @Override
    public Goals save(Goals goals) {
        Goals savedGoal = goalRepository.save(goals);
        return savedGoal;
    }

    @Override
    public List<Goals> findAll() {
        List<Goals> goals = goalRepository.findAll();
        return goals;
    }

    @Override
    public Goals findById(Long id) {
        Optional<Goals> goals = goalRepository.findById(id);

        if(goals.isPresent()){
            return goals.get();
        }
        else {


            return null;
        }
    }

    @Override
    public void deleteById(Long id) {

        goalRepository.deleteById(id);


    }
}
