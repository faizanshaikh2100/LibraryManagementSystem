package com.example.librarayManagement.Repositroy;

import com.example.librarayManagement.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Author findByAuthorId(int authorId);
}
