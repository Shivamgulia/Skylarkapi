package com.skylark.sport.service.Impl;

import com.skylark.sport.entity.Activity;
import com.skylark.sport.repository.ActivityRepository;
import com.skylark.sport.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    public ActivityRepository activityRepository;


    @Override
    public Activity getActivityById(Long activityId) {

        Optional<Activity> activity = activityRepository.findById(activityId);

        if(activity.isPresent()) {
            return activity.get();
        }
        return null;
    }

    @Override
    public Activity saveActivity(Activity activity) {
        Activity savedActivity = activityRepository.save(activity);

        return savedActivity;
    }

    @Override
    public void deleteActivity(Long activityId) {
        activityRepository.deleteById(activityId);


    }

    @Override
    public List<Activity> getAllActivity() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList;
    }
}
