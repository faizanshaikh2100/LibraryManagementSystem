package com.example.librarayManagement.Controller;

import com.example.librarayManagement.DTO.RequestDTO.BookDTO.BookRequestDTO;
import com.example.librarayManagement.DTO.ResponseDTO.BookResponseDTO;
import com.example.librarayManagement.Service.BookService;
import com.example.librarayManagement.Service.Implementation.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService service;
    @PostMapping("/add-book")
    public String addBook(@RequestBody BookRequestDTO bookRequestDTO) throws Exception{
        return service.addBook(bookRequestDTO);
    }
    @GetMapping("/get-by-name")
    public BookResponseDTO getBookByBookName(@RequestParam ("bookName") String bookName)throws Exception{
        return service.getBookByBookName(bookName);
    }

    @GetMapping("/get-by-author")
    public List<BookResponseDTO> getBooksByAuthorName(@RequestParam ("authorName")String authorName)throws Exception{
        return service.getBooksByAuthorName(authorName);
    }

    @GetMapping("/get-all-books")
    public List<BookResponseDTO> getAllBooks(){
        return service.getAllBooks();
    }

    @DeleteMapping("/delete-by-name")
    public String deleteBookByName(@RequestParam("bookName") String bookName)throws Exception{
        return service.deleteBookByName(bookName);
    }
}
