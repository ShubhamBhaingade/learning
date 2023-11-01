package com.cg.accountThird.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.accountThird.entity.Transaction;
@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, Integer>{
	
	

}
