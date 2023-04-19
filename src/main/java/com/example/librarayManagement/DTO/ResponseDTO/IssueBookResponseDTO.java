package com.example.librarayManagement.DTO.ResponseDTO;

import com.example.librarayManagement.Entity.Transactions;
import com.example.librarayManagement.Enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IssueBookResponseDTO {
    private String transactionNumber;

    private TransactionStatus transactionStatus;

    private String bookName;
}
