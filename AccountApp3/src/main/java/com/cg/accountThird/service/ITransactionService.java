package com.cg.accountThird.service;

import org.springframework.stereotype.Service;

import com.cg.accountThird.entity.Transaction;

@Service
public interface ITransactionService {
	
	public int addTransaction(Transaction transaction);
	public Transaction getTransactionById(int transactionId);
	

}
