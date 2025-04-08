package com.skylark.sport.auth;

import com.skylark.sport.entity.Coach;
import com.skylark.sport.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coaches")
@CrossOrigin("*")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping
    public void createCoach(@RequestBody Coach coach) {
        coachService.saveCoach(coach);
    }

    @GetMapping("/{id}")
    public Coach getCoachById(@PathVariable Long id) {
        return coachService.findCoachById(id);
    }

    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.findAllCoaches();
    }

    @DeleteMapping("/{id}")
    public void deleteCoachById(@PathVariable Long id) {
        coachService.deleteCoachById(id);
    }
}
