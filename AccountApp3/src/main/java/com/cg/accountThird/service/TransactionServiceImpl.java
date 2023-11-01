package com.cg.accountThird.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.accountThird.entity.Transaction;
import com.cg.accountThird.repository.ITransactionRepository;

@Service
public class TransactionServiceImpl implements ITransactionService {
	@Autowired
	ITransactionRepository transactionRepository;

	@Override
	public int addTransaction(Transaction transaction) {
		if(transaction!=null) {
			Transaction savedTransaction=transactionRepository.save(transaction);
			return savedTransaction.getTransactionId();
			
		}
		return 0;
	}

	@Override
	public Transaction getTransactionById(int transactionId) {
		if(transactionId!=0) {
			Transaction savedTransaction=transactionRepository.findById(transactionId).get();
			return savedTransaction;
		}
		return null;
	}


	

}
