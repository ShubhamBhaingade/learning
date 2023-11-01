package com.cg.accountThird.util;

import org.springframework.stereotype.Component;

import com.cg.accountThird.dto.AccountTransactionResponseDTO;
import com.cg.accountThird.entity.Account;
import com.cg.accountThird.entity.Transaction;

@Component
public class AccountTransactionResponseDTOConvertor {
	
	public AccountTransactionResponseDTO getAccountDTO(Transaction t ){
		AccountTransactionResponseDTO dto=new AccountTransactionResponseDTO();

		dto.setBalance(t.getAccount().getBalance());
		dto.setLoc(t.getAccount().getLoc());
		dto.setMobilePin(t.getAccount().getMobilePin());
		dto.setAccountType(t.getAccount().getAccountType());
		dto.setTransactionDate(t.getTransactionDate());
		dto.setTransactionAmount(t.getTransactionAmount());
		
		return dto;
		
	}

}





//dto.setBalance(acc.getBalance());
//dto.setLoc(acc.getLoc());
//dto.setMobilePin(acc.getMobilePin());
//dto.setAccountType(acc.getAccountType());
//dto.setTransactionAmount(acc.);