package com.example.librarayManagement.DTO.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequestDTO {
    private String name;
    int age;
    private String email;

}
