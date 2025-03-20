package com.skylark.sport.dto.Activity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveActivityDto {
    private String activityName;

    private String month;

    private int date;

    private int year;

    private int amount;

    private String unit;


}
