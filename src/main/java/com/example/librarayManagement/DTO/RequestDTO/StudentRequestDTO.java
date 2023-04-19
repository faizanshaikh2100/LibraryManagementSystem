package com.example.librarayManagement.DTO.RequestDTO;

import com.example.librarayManagement.Enums.Branch;
import com.example.librarayManagement.Enums.StudentType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
    private String name;
    private Branch branch;
    private int age;
    private StudentType studentType;
    private String mobNo;

    private String email;
}
