package com.skylark.sport.dto.Activity;


import com.skylark.sport.entity.ActivityMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private Long studentId;

    private Long coachId;

    private List<ActivityMapper> measures;


}
