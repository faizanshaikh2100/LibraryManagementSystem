package com.example.librarayManagement.DTO.ResponseDTO;

import com.example.librarayManagement.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {
    private String bookName;


    private Date issuedDate;


    private Genre genre;

    private int price;
}
