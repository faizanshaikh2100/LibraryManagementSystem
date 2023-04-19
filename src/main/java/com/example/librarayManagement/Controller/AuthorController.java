package com.example.librarayManagement.Controller;

import com.example.librarayManagement.DTO.RequestDTO.AuthorRequestDTO;
import com.example.librarayManagement.Entity.Author;
import com.example.librarayManagement.Repositroy.AuthorRepository;
import com.example.librarayManagement.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService service;

    @PostMapping("/add-author")
    public String addAuthor(@RequestBody AuthorRequestDTO authorRequestDTO){
       return service.addAuthor(authorRequestDTO);
    }
}
