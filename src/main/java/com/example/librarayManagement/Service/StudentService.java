package com.example.librarayManagement.Service;


import com.example.librarayManagement.DTO.RequestDTO.StudentRequestDTO;
import com.example.librarayManagement.DTO.RequestDTO.StudentRequestDTOEmail;
import com.example.librarayManagement.DTO.RequestDTO.StudentRequestDTOMobile;
import com.example.librarayManagement.DTO.ResponseDTO.StudentResponseDTO;
import com.example.librarayManagement.Entity.Student;
import com.example.librarayManagement.Exception.InvalidMobileNumber;
import com.example.librarayManagement.Exception.StudentNotFoundException;

import java.util.*;

public interface StudentService {
    public String addStudent(StudentRequestDTO studentRequestDTO);



    public List<StudentResponseDTO> getAllStudents();

    public StudentResponseDTO getStudentByMob(StudentRequestDTOMobile studentRequestDTOMobile) throws Exception;

    public String deleteStudentByMobNo(StudentRequestDTOMobile studentRequestDTOMobile)throws Exception;

    public StudentResponseDTO getStudentByEmail(StudentRequestDTOEmail studentRequestDTOEmail)throws Exception;
    public String deleteStudentByEmail(StudentRequestDTOEmail studentRequestDTOEmail) throws Exception;
}
