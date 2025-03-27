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
@Table(name="activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String type;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "coach_id", referencedColumnName = "id")
    private Coach coach;

    private int month;

    private int date;

    private String year;

    private int amount;

    private String unit;

    private boolean approved;

    private Category category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ActivityMapper> measures;

//TODO Add category also


}



enum Category {
    GYM,
    SPORT
}