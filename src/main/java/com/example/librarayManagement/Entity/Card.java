package com.example.librarayManagement.Entity;

import com.example.librarayManagement.Enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="card")
public class Card {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

    @CreationTimestamp
    private Date issuedDate;

    
    private String validTill;

    @OneToOne
    @JoinColumn
    private Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> booksList = new ArrayList<>();

    @OneToMany(mappedBy = "card_t",cascade = CascadeType.ALL)
    List<Transactions>transctionsList = new ArrayList<>();

}
