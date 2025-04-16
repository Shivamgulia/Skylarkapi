package com.skylark.sport.auth;

import com.skylark.sport.dto.Goal.SaveGoalDto;
import com.skylark.sport.entity.Coach;
import com.skylark.sport.entity.Goals;
import com.skylark.sport.service.CoachService;
import com.skylark.sport.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GoalController {


    @Autowired
    private GoalService goalService;

    @Autowired
    private CoachService coachService;

    @PostMapping("/goals")
    public Long createGoal(@RequestBody SaveGoalDto goals) {

        Coach coach = coachService.findCoachById(goals.getCoach());

        if(coach == null) {
            throw new RuntimeException("Coach not found");
        }


        Goals goal = new Goals();
        goal.setYear(goals.getYear());
        goal.setName(goals.getGoalName());
        goal.setCategory(goals.getCategory());
        goal.setMonth(goals.getMonth());
        goal.setMeasures(goals.getMeasures());
        goal.setCoach(coach);

        Goals savedGoal = goalService.save(goal);

        return  savedGoal.getId();
    }

    @GetMapping("/goals/{goalid}")
    public Goals getGoalById(@PathVariable("goalid") Long id) {
        return goalService.findById(id);
    }


    @GetMapping("/coachgoals/{coachid}")
    public List<Goals> getGoals(@PathVariable("coachid") Long coachid) {
        return goalService.findByCoach(coachid);

    }

    @GetMapping("/goals")
    public List<Goals> getAllGoals() {
        return goalService.findAll();
    }



}
