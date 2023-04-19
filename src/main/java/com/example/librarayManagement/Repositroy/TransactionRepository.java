package com.example.librarayManagement.Repositroy;

import com.example.librarayManagement.Entity.Transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,String> {
}
