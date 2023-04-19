package com.example.librarayManagement.Repositroy;

import com.example.librarayManagement.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByBookName (String name);
    Book findByAuthor(String name);


}
