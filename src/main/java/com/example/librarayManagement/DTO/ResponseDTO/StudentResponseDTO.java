package com.example.librarayManagement.DTO.ResponseDTO;

import com.example.librarayManagement.Enums.Branch;
import com.example.librarayManagement.Enums.StudentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {
    private String name;
    private Branch branch;
    private int age;
    private StudentType studentType;
    private String mobNo;
    private String email;
}
