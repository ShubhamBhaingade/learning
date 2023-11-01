package com.cg.accountThird.util;

import org.springframework.stereotype.Component;

import com.cg.accountThird.dto.AccountRequestSubmitDTO;
import com.cg.accountThird.entity.Account;
import com.cg.accountThird.entity.Verification;

@Component
public class AccountDTOConvertor {
	
	public Account getAccountFromAccountDTO(AccountRequestSubmitDTO dto) {
		Account a=new Account();
		a.setBalance(dto.getBalance());
		a.setLoc(dto.getLoc());
		a.setMobilePin(dto.getMobilePin());
		a.setAccountType(dto.getAccountType());
		
		Verification verify=new Verification(dto.getPanNumber(),true);
		a.setAccVerification(verify);
		
		return a;
		
		
	}

}
