package com.example.librarayManagement.Entity;

import com.example.librarayManagement.Enums.Branch;
import com.example.librarayManagement.Enums.StudentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;


    @Enumerated(EnumType.STRING)
    private Branch branch;
    private int age;
    @Enumerated(EnumType.STRING)
    private StudentType studentType;

    @Column(unique = true)
    private String mobNo;

    @Column(unique = true)
    private String email;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;
}
