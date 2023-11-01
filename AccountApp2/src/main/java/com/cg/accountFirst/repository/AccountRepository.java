package com.cg.accountFirst.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cg.accountFirst.entity.Account;

@Component
public class AccountRepository {

	List<Account> allAccounts = new ArrayList<>();

	public AccountRepository() {
		System.out.println("inside constructor");
		Account a1 = new Account(101, 5000, "Mumbai", 78, "Salaried Account");
		Account a2 = new Account( 102,5080, "pune", 89, "Saving Account");
		Account a3 = new Account(103, 8000, "nashik", 33, "Current Account");
		Account a4 = new Account(104, 4500, "Mumbai", 18, "salaried Account");

		allAccounts.add(a1);
		allAccounts.add(a2);
		allAccounts.add(a3);
		allAccounts.add(a4);

	}

	public String saveAccount(Account a) {
		allAccounts.add(a);
		return "Account saved" +a.getId();
	}

	public Account getAccountById(int id) {
		return allAccounts.stream().filter(a -> a.getId() == id).findFirst().get();

	}

	public List<Account> getAllAccounts() {
		System.out.println("inside all account");
		return allAccounts;
	}

	public List<Account> getAllAccounts(String loc) {
		return allAccounts.stream().filter((a)->
			a.getLoc().equals(loc)).collect(Collectors.toList());
		
	}
	public Account updatePin(int num) {
		Account aa = allAccounts.stream().filter((a)->{
			if(a.getMobilePin() == num) {
				a.setMobilePin(07);
				return true;
			}else return false;
		}).findFirst().get();
		return aa;
	}
	

}
