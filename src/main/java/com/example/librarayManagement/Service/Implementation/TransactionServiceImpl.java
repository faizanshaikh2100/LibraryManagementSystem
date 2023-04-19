package com.example.librarayManagement.Service.Implementation;

import com.example.librarayManagement.DTO.RequestDTO.BookDTO.IssueBookRequestDTO;
import com.example.librarayManagement.DTO.ResponseDTO.IssueBookResponseDTO;
import com.example.librarayManagement.Entity.Book;
import com.example.librarayManagement.Entity.Card;
import com.example.librarayManagement.Entity.Transactions;
import com.example.librarayManagement.Enums.CardStatus;
import com.example.librarayManagement.Enums.Issued;
import com.example.librarayManagement.Enums.TransactionStatus;
import com.example.librarayManagement.Repositroy.BookRepository;
import com.example.librarayManagement.Repositroy.CardRespositroy;
import com.example.librarayManagement.Repositroy.TransactionRepository;
import com.example.librarayManagement.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    CardRespositroy cardRespositroy;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionsRepository;
    @Override
    public IssueBookResponseDTO issueBook(IssueBookRequestDTO issueBookRequestDTO) throws Exception {
        Transactions transaction = new Transactions();
        transaction.setTransactionNumber(UUID.randomUUID().toString());
        transaction.setIssuedOperation(true);

        Card card;
        try{
            card = cardRespositroy.findById(issueBookRequestDTO.getCardId()).get();

        }
        catch(Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionsRepository.save(transaction);
            throw new Exception(e.getMessage());

        }
        transaction.setCard_t(card);

        Book book;
        try{
         book = bookRepository.findByBookName(issueBookRequestDTO.getBookName());
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionsRepository.save(transaction);
            throw new Exception("Invalid Book Name!!");

        }
        transaction.setBook_t(book);
        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionsRepository.save(transaction);
            throw new Exception("Card is not active");
        }
        if(book.getIssued().equals(Issued.ISSUED)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionsRepository.save(transaction);
            throw new Exception("Books is not available");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESSFUL);


        book.setIssued(Issued.ISSUED);
        book.setCard(card);
        book.getTransctionsList().add(transaction);
        card.getTransctionsList().add(transaction);
        card.getBooksList().add(book);

        cardRespositroy.save(card);

        return new IssueBookResponseDTO(transaction.getTransactionNumber(),transaction.getTransactionStatus(), book.getBookName());
    }
}
