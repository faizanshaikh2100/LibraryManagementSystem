package com.example.librarayManagement.Repositroy;

import com.example.librarayManagement.Entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRespositroy extends JpaRepository<Card,Integer> {
    Card findByCardId(int id);
}
