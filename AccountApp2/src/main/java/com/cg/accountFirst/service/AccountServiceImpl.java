package com.cg.accountFirst.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.accountFirst.entity.Account;
import com.cg.accountFirst.repository.AccountRepository;
@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	AccountRepository repository;
	
	

	public AccountServiceImpl() {
		System.out.println("inside implementation class");
	}

	@Override
	public String saveAccount(Account a) {
		if(a != null) {
			int id=new Random().nextInt(1000);
			a.setId(id);
			return repository.saveAccount(a);
		}
		return "wrong input exception";
	}

	@Override
	public Account getAccountById(int searchId) {
		if(searchId!=0) {
			Account a=repository.getAccountById(searchId);
			if(a!=null) return a;
			else return null;
			
		}
		return null;
	}

	@Override
	public List<Account> getAllAccount() {
		
		return repository.getAllAccounts();
	}

	@Override
	public List<Account> getAllAccounts(String searchLoc) {
		return repository.getAllAccounts(searchLoc);
	}
	public Account updatePin(int searchNum){
		if(searchNum != 0) {
			Account a = repository.updatePin(searchNum);
			if (a != null) {
				return a;
			} else {
				return null;
			}
		}
		return null;
}
}


