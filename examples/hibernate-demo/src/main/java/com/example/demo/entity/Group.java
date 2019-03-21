package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString(of = {"id", "year", "name"})
@Table(name = "class")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int year;
    private String name;

    @OneToMany
    @JoinColumn
    private List<Student> students;

    @ManyToMany(mappedBy = "groups")
    private List<Teacher> teachers;
}
