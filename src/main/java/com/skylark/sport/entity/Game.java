package com.skylark.sport.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String title;


//    TODO Error is due to a new table not being created for the list create a complete entity for team and add that
    private String team1;
    private int team1Score;


    private String team2;
    private int team2Score;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ArrayList<GamePlayer> players;

}
