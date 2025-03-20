package com.skylark.sport.dto.Goal;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveGoalDto {

    private String goalName;

    private String month;

    private String year;

    private int amount;

    private String unit;


}
