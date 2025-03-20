package com.skylark.sport.service;

import com.skylark.sport.entity.Goals;

import java.util.List;

public interface GoalService {


    Goals save(Goals goals);

    List<Goals> findAll();

    Goals findById(Long id);

    void deleteById(Long id);


}
