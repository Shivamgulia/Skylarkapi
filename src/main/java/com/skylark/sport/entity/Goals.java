package com.skylark.sport.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    private String type;

    private int month;

    private String year;

    private int amount;

    private String unit;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "coach_id", referencedColumnName = "id")
    private Coach coach;
}
