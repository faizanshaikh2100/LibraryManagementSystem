package com.example.librarayManagement.Entity;

import com.example.librarayManagement.Enums.Genre;
import com.example.librarayManagement.Enums.Issued;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column(unique = true)
    private String bookName;

    @CreationTimestamp
    private Date issuedDate;

    @Enumerated(EnumType.STRING)
    private Issued issued = Issued.NOTISSUED;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int price;
    @ManyToOne
    @JoinColumn
    private Card card;

    @ManyToOne
    @JoinColumn
    private Author author;

    @OneToMany(mappedBy = "book_t",cascade = CascadeType.ALL)
    List<Transactions> transctionsList = new ArrayList<>();

}
