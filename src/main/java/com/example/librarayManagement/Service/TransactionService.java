package com.example.librarayManagement.Service;


import com.example.librarayManagement.DTO.RequestDTO.BookDTO.IssueBookRequestDTO;
import com.example.librarayManagement.DTO.ResponseDTO.IssueBookResponseDTO;

public interface TransactionService {
    public IssueBookResponseDTO issueBook(IssueBookRequestDTO issueBookRequestDTO) throws Exception;
}
