package com.skylark.sport.service;

import com.skylark.sport.entity.Activity;
import com.skylark.sport.entity.ActivityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityMapperService {

    ActivityMapper getActivityById(Long activityId);

    List<ActivityMapper> getAllActivity();

    void insertActivity(ActivityMapper activity);
}
