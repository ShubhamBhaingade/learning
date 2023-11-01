package com.cg.accountThird.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.accountThird.entity.Account;

@Repository
public interface IAccountRepository  extends JpaRepository<Account, Integer>{
	
	public List<Account> getAccountByLoc(String loc);
	public List<Account>getAccountByAccountType(String accountType );
	
	

}
