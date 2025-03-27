package com.skylark.sport.service;

import com.skylark.sport.entity.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityMapperService {

    Activity getActivityById(int activityId);

    List<Activity> getAllActivity();

    void insertActivity(Activity activity);
}
