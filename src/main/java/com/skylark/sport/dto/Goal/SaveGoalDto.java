package com.skylark.sport.dto.Goal;


import com.skylark.sport.entity.ActivityMapper;
import com.skylark.sport.entity.Category;
import com.skylark.sport.entity.Coach;
import com.skylark.sport.entity.GoalMapper;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveGoalDto {

    private String goalName;

    private int month;

    private String year;

    private Long coach;

    private List<GoalMapper> measures;

    private Category category;



}
