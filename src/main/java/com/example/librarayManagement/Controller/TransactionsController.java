package com.example.librarayManagement.Controller;

import com.example.librarayManagement.DTO.RequestDTO.BookDTO.IssueBookRequestDTO;
import com.example.librarayManagement.DTO.ResponseDTO.IssueBookResponseDTO;
import com.example.librarayManagement.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {

    @Autowired
    TransactionService service;

    @PostMapping("/issue-book")
    public IssueBookResponseDTO issueBook(@RequestBody IssueBookRequestDTO issueBookRequestDTO) throws Exception {
       return service.issueBook(issueBookRequestDTO);
    }
}
