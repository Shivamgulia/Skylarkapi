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
    public Activity getActivityById(int activityId) {

        Optional<Activity> activity = activityMapperRespository.findById(activityId);
        return activity.orElse(null);
    }

    @Override
    public List<Activity> getAllActivity() {
        return activityMapperRespository.findAll();
    }

    @Override
    public void insertActivity(Activity activity) {
        activityMapperRespository.save(activity);

    }
}
