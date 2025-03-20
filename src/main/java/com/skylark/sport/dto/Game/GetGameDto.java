package com.skylark.sport.dto.Game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetGameDto {

    private String gameName;

    private ArrayList<String> players1;
    private ArrayList<Integer> scores1;


    private ArrayList<String> players2;
    private ArrayList<Integer> scores2;



}
