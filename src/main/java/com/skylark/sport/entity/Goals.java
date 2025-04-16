package com.skylark.sport.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private int month;

    private String year;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "coach_id", referencedColumnName = "id")
    private Coach coach;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<GoalMapper> measures;

    private Category category;
}
