package com.skylark.sport.service.Impl;

import com.skylark.sport.entity.Activity;
import com.skylark.sport.entity.ActivityMapper;
import com.skylark.sport.repository.ActivityMapperRespository;
import com.skylark.sport.service.ActivityMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityMapperServiceImpl implements ActivityMapperService {

    @Autowired
    private ActivityMapperRespository activityMapperRespository;


    @Override
    public ActivityMapper getActivityById(Long activityMapperId) {

        Optional<ActivityMapper> activity = activityMapperRespository.findById(activityMapperId);
        return activity.orElse(null);
    }

    @Override
    public List<ActivityMapper> getAllActivity() {
        return activityMapperRespository.findAll();
    }

    @Override
    public void insertActivity(ActivityMapper activity) {
        activityMapperRespository.save(activity);

    }
}
