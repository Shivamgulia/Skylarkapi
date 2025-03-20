package com.skylark.sport.auth;


import com.skylark.sport.dto.Activity.SaveActivityDto;
import com.skylark.sport.entity.Activity;
import com.skylark.sport.entity.Goals;
import com.skylark.sport.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ActivityController {

    @Autowired
    public ActivityService activityService;

    @PostMapping("/activitys")
    public Long createActivity(@RequestBody SaveActivityDto activity) {

        Activity newActivity = new Activity();
        newActivity.setType(activity.getActivityName());
        newActivity.setDate(activity.getDate());
        newActivity.setUnit(activity.getUnit());
        newActivity.setMonth(activity.getMonth());
        newActivity.setYear(activity.getYear());
        newActivity.setAmount(activity.getAmount());

        Activity saveActivity = activityService.saveActivity(newActivity);

        return saveActivity.getId();
    }


    @GetMapping("/activitys/{activityId}")
    public Activity getActivityById(@PathVariable("activityId") Long id) {

        return activityService.getActivityById(id);

    }

    @GetMapping("/activitys")
    public List<Activity> getAllActivities() {
        return activityService.getAllActivity();
    }

}
