package com.skylark.sport.auth;


import com.skylark.sport.dto.Activity.SaveActivityDto;
import com.skylark.sport.entity.Activity;
import com.skylark.sport.entity.Coach;
import com.skylark.sport.entity.Goals;
import com.skylark.sport.entity.Student;
import com.skylark.sport.service.ActivityService;
import com.skylark.sport.service.CoachService;
import com.skylark.sport.service.GoalService;
import com.skylark.sport.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ActivityController {

    @Autowired
    public ActivityService activityService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private GoalService goalService;

    @PostMapping("/activitys")
    public Long createActivity(@RequestBody SaveActivityDto activity) {


        Student student = studentService.findStudentById(activity.getStudentId());
        if (student == null) {
            throw new RuntimeException("Student not found");
        }

        Coach coach = coachService.findCoachById(activity.getCoachId());

        if (coach == null) {
            throw new RuntimeException("Coach not found");
        }

        Goals goals = goalService.findById(activity.getGoalId());

        if(goals == null) {
            throw new RuntimeException("Goal not found");
        }

        Activity newActivity = new Activity();
        newActivity.setCategory(activity.getCategory());
        newActivity.setDate(activity.getDate());
        newActivity.setMonth(activity.getMonth());
        newActivity.setYear(activity.getYear());
        newActivity.setName(activity.getActivityName());
        newActivity.setMeasures(activity.getMeasures());
        newActivity.setStudent(student);
        newActivity.setCoach(coach);
        newActivity.setMeasures(activity.getMeasures());
        newActivity.setGoal(goals);

        Activity saveActivity = activityService.saveActivity(newActivity);

        return saveActivity.getId();
    }


    @GetMapping("/activitys/{activityId}")
    public Activity getActivityById(@PathVariable("activityId") Long id) {
        return activityService.getActivityById(id);

    }

    @GetMapping("/studentactivitys/{studentid}")
    public List<Activity> getStudentActivities(@PathVariable("studentid") Long studentid,  @RequestParam(name = "month", required = false) Optional<Integer> month) {
        if(month.isPresent()) {
            return activityService.getActivityByStudentAndMonth(studentid, month.get());
        }
        return activityService.getActivityByStudent(studentid);
    }

    @GetMapping("/coachactivitys/{coachid}")
    public List<Activity> getCoachActivities(@PathVariable("coachid") Long coachId, @RequestParam(name = "month", required = false) Optional<Integer> month) {
        if(month.isPresent()) {
            return activityService.getActivityByCoachAndMonth(coachId, month.get());
        }
        return activityService.getActivityByCoach(coachId);
    }

    @GetMapping("/activitys")
    public List<Activity> getAllActivities() {
        return activityService.getAllActivity();
    }

    @PutMapping("/verfiyactivity")
    public String updateActivity(@RequestBody List<Long> activityIds) {
        try {
            for (Long activityId : activityIds) {
                activityService.markActivityApproved(activityId);
            }
            return "success";
        }
        catch (Exception e) {
            return "failed";
        }
    }

}
