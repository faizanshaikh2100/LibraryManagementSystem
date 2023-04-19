package com.example.librarayManagement.DTO.RequestDTO.BookDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IssueBookRequestDTO {
    private String bookName;
    private int cardId;
}
