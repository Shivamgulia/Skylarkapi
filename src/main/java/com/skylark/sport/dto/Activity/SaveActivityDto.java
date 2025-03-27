package com.skylark.sport.dto.Activity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveActivityDto {
    private String activityName;

    private int month;

    private int date;

    private String year;

    private int amount;

    private String unit;


}
