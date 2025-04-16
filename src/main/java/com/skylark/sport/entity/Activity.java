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

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "coach_id", referencedColumnName = "id")
    private Coach coach;

    private String name;

    private int month;

    private int date;

    private String year;

    private boolean approved;

    private Category category;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Goals goal;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ActivityMapper> measures;

//TODO Add category also


}



