package com.example.librarayManagement.Repositroy;

import com.example.librarayManagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


   Student findByMobNo(String mobNo);

   Student findByEmail(String email);


}
