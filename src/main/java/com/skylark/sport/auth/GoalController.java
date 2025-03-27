package com.skylark.sport.auth;

import com.skylark.sport.dto.Goal.SaveGoalDto;
import com.skylark.sport.entity.Goals;
import com.skylark.sport.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GoalController {


    @Autowired
    private GoalService goalService;

    @PostMapping("/goals")
    public Long createGoal(@RequestBody SaveGoalDto goals) {
        Goals goal = new Goals();
        goal.setYear(goals.getYear());
        goal.setUnit(goals.getUnit());
        goal.setType(goals.getGoalName());
        goal.setMonth(goals.getMonth());
        goal.setAmount(goals.getAmount());
        goal.setCoach(goals.getCoach());

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
