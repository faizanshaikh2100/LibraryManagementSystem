package com.example.librarayManagement.Service.Implementation;

import com.example.librarayManagement.DTO.RequestDTO.StudentRequestDTO;
import com.example.librarayManagement.DTO.RequestDTO.StudentRequestDTOEmail;
import com.example.librarayManagement.DTO.RequestDTO.StudentRequestDTOMobile;
import com.example.librarayManagement.DTO.ResponseDTO.StudentResponseDTO;
import com.example.librarayManagement.Entity.Card;
import com.example.librarayManagement.Entity.Student;
import com.example.librarayManagement.Enums.CardStatus;
import com.example.librarayManagement.Exception.EmailNotFound;
import com.example.librarayManagement.Exception.InvalidMobileNumber;
import com.example.librarayManagement.Exception.StudentNotFoundException;
import com.example.librarayManagement.Repositroy.StudentRepository;
import com.example.librarayManagement.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;
    @Override
    public String addStudent(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setStudentType(studentRequestDTO.getStudentType());
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setBranch(studentRequestDTO.getBranch());
        student.setMobNo(studentRequestDTO.getMobNo());
        student.setEmail(studentRequestDTO.getEmail());
        Card card = new Card();
        card.setStudent(student);
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-05-20");
        student.setCard(card);
        repository.save(student);
        return "Successfully added Student!🧑‍🎓";
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student>studentList = repository.findAll();
        List<StudentResponseDTO> studentResponseDTOList =new ArrayList<>();

        for(Student student:studentList){
            studentResponseDTOList.add(new StudentResponseDTO(student.getName(),
             student.getBranch(),student.getAge(),student.getStudentType(),student.getMobNo(),student.getEmail()));
        }
        return studentResponseDTOList;
    }

    @Override
    public StudentResponseDTO getStudentByMob(StudentRequestDTOMobile studentRequestDTOMobile) throws Exception {
        try {
            Student student = repository.findByMobNo(studentRequestDTOMobile.getMobNo());
            return new StudentResponseDTO(student.getName(),student.getBranch(),student.getAge(),student.getStudentType(),student.getMobNo(),student.getEmail());
        }
        catch(Exception e){
            throw new InvalidMobileNumber("Student with that Mobile number Not Found! 😢");
        }
    }

    @Override
    public String deleteStudentByMobNo(StudentRequestDTOMobile studentRequestDTOMobile) throws Exception {

        try{
            Student student = repository.findByMobNo(studentRequestDTOMobile.getMobNo());
            repository.deleteById(student.getStudentId());
        }catch(Exception e){
            throw new InvalidMobileNumber("Student with that Mobile number Not Found! 😢");
        }

        return "Successfully Deleted Student";
    }

    @Override
    public StudentResponseDTO getStudentByEmail(StudentRequestDTOEmail studentRequestDTOEmail) throws Exception {
        try {
            Student student = repository.findByEmail(studentRequestDTOEmail.getEmail());
            return new StudentResponseDTO(student.getName(), student.getBranch(),
                    student.getAge(), student.getStudentType(), student.getMobNo(), student.getEmail());
        }
        catch(Exception e){
            throw new EmailNotFound("Student with that email not found");
        }
    }
    @Override
    public String deleteStudentByEmail(StudentRequestDTOEmail studentRequestDTOEmail) throws Exception {

        try{
            Student student = repository.findByEmail(studentRequestDTOEmail.getEmail());
            repository.deleteById(student.getStudentId());
        }catch(Exception e){
            throw new EmailNotFound("Student with that Email Not Found! 😢");
        }

        return "Successfully Deleted Student";
    }

}
