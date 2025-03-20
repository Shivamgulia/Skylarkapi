package com.skylark.sport.service;

import com.skylark.sport.entity.Activity;

import java.util.List;

public interface ActivityService {

    Activity getActivityById(Long activityId);

    Activity saveActivity(Activity activity);

    void deleteActivity(Long activityId);

    List<Activity> getAllActivity();
}
