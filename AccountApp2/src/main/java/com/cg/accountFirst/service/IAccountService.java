package com.cg.accountFirst.service;

import java.util.List;

import com.cg.accountFirst.entity.Account;

public interface IAccountService {
	
	public String saveAccount(Account a);
	public Account getAccountById(int searchId);
	public List<Account>getAllAccount();
	public List<Account> getAllAccounts(String searchLoc);
	public Account updatePin(int searchId);
	
	

}
