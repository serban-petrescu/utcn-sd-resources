package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@ToString(of = {"id", "score", "date"})
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int score;
    private LocalDate date;

    @ManyToOne
    @JoinColumn
    private Teacher createdBy;
}
