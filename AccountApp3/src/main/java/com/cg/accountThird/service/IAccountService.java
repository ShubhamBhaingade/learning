package com.cg.accountThird.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.accountThird.entity.Account;
import com.cg.accountThird.entity.Transaction;
import com.cg.accountThird.entity.Verification;
import com.cg.accountThird.exception.InvalidLocationException;

@Service
public interface IAccountService {

	public int saveAccount(Account a)throws InvalidLocationException;

	public Account getAccountById(int searchId);

	public List<Account> getAllAccount();
	
	public List<Account>getAccountByLoc(String loc)throws InvalidLocationException;
	
	public List<Account>getAccountByAccountType(String accountType);
	
	public Account updateAccount(int searchId,int newBalance) ;
	
	public Account updateMobilePin(int searchId,int newMbPin);

	public String addVerificationDetails(int searchId, Verification verification);
	
	public Account addPolicyToAccount(int searchCode,int policyCode );
	
	public Account addDebitCardToAccount(int searchCode,long cardNumber);
	
	public String allocateAccountToTransaction(int transactionId,int searchCode);
	
	public List<Transaction>getAllTransactionByAccount(int searchCode);
	
	

}
