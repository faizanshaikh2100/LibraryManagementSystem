package com.example.librarayManagement.Service.Implementation;

import com.example.librarayManagement.DTO.RequestDTO.AuthorRequestDTO;
import com.example.librarayManagement.Entity.Author;
import com.example.librarayManagement.Repositroy.AuthorRepository;
import com.example.librarayManagement.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(AuthorRequestDTO authorRequestDTO) {

        Author author = new Author();
        author.setName(authorRequestDTO.getName());
        author.setAge(authorRequestDTO.getAge());
        author.setEmail(authorRequestDTO.getEmail());
        authorRepository.save(author);
        return "Successfully added author!";
    }
}
