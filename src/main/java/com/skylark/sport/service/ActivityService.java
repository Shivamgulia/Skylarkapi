package com.skylark.sport.service;

import com.skylark.sport.entity.Activity;

import java.util.List;

public interface ActivityService {

    Activity getActivityById(Long activityId);

    Activity saveActivity(Activity activity);

    void deleteActivity(Long activityId);

    List<Activity> getAllActivity();

    List<Activity> getActivityByStudent(Long userId);

    List<Activity> getActivityByCoach(Long coachId);

    List<Activity> getActivityByCoachAndMonth(Long coachId, int month);

    List<Activity> getActivityByStudentAndMonth(Long coachId, int month);

    void markActivityApproved (Long activityId);
}
