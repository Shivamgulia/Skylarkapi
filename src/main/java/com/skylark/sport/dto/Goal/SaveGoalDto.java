package com.skylark.sport.dto.Goal;


import com.skylark.sport.entity.Coach;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveGoalDto {

    private String goalName;

    private int month;

    private String year;

    private int amount;

    private String unit;

    private Long coach;


}
