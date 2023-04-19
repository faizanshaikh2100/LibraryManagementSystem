package com.example.librarayManagement.DTO.RequestDTO.BookDTO;

import com.example.librarayManagement.Enums.Genre;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {
    private String bookName;


    private int authorId;
    private Genre genre;

    private int price;


}
