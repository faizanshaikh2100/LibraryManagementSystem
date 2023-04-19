package com.example.librarayManagement.Service;

import com.example.librarayManagement.DTO.RequestDTO.BookDTO.BookRequestDTO;
import com.example.librarayManagement.DTO.ResponseDTO.BookResponseDTO;

import java.util.List;


public interface BookService  {
    public String addBook(BookRequestDTO bookRequestDTO) throws Exception;
    public BookResponseDTO getBookByBookName(String name)throws Exception;

    public List<BookResponseDTO> getBooksByAuthorName(String name)throws Exception;

    public List<BookResponseDTO> getAllBooks();

    public String deleteBookByName(String name)throws Exception;



}
