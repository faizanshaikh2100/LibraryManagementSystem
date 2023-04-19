package com.example.librarayManagement.Controller;

import com.example.librarayManagement.DTO.RequestDTO.StudentRequestDTO;
import com.example.librarayManagement.DTO.RequestDTO.StudentRequestDTOEmail;
import com.example.librarayManagement.DTO.RequestDTO.StudentRequestDTOMobile;
import com.example.librarayManagement.DTO.ResponseDTO.StudentResponseDTO;
import com.example.librarayManagement.Entity.Student;
import com.example.librarayManagement.Exception.StudentNotFoundException;
import com.example.librarayManagement.Repositroy.StudentRepository;

import com.example.librarayManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService service;
    @PostMapping("/add-student")
    public String addStudent(@RequestBody StudentRequestDTO studentRequestDTO){
        return service.addStudent(studentRequestDTO);

    }

    @GetMapping("/get-all-students")
    public List<StudentResponseDTO> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/get-student-by-mob")
    public StudentResponseDTO getStudentByMob(@RequestBody StudentRequestDTOMobile studentRequestDTOMobile) throws Exception {
        return service.getStudentByMob(studentRequestDTOMobile);
    }

    @DeleteMapping("delete-student-by-mobile")
    public String deleteStudentByMobNo(@RequestBody StudentRequestDTOMobile studentRequestDTOMobile)throws Exception{
        return service.deleteStudentByMobNo(studentRequestDTOMobile);
    }
    @GetMapping("get-student-by-email")
    public StudentResponseDTO getStudentByEmail(@RequestBody StudentRequestDTOEmail studentRequestDTOEmail)throws Exception{
        return service.getStudentByEmail(studentRequestDTOEmail);
    }
    @DeleteMapping("delete-student-by-email")
    public String deleteStudentByEmail(@RequestBody StudentRequestDTOEmail studentRequestDTOEmail)throws Exception{
        return service.deleteStudentByEmail(studentRequestDTOEmail);
    }
}
