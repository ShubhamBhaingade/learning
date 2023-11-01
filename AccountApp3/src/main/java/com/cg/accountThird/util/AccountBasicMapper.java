package com.cg.accountThird.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.accountThird.dto.AccountBasicDTO;
import com.cg.accountThird.entity.Account;

@Component
public class AccountBasicMapper {
	
	public List<AccountBasicDTO>mapAccountListToDtoList(List<Account>list){
		List<AccountBasicDTO>dtoList=new ArrayList<>();
		for (Account acc : list) {
			
			AccountBasicDTO dto=new AccountBasicDTO();
			dtoList.add(dto);
			
		}
		return dtoList;
	}
	
	public AccountBasicDTO mapAccountToDto(Account a) {
		AccountBasicDTO dto=new AccountBasicDTO();
		if(a!=null) {
			dto.setBalance(a.getBalance());
			dto.setLoc(a.getLoc());
			dto.setMobilePin(a.getMobilePin());
			dto.setAccountType(a.getAccountType());
			
			if(a.getAccVerification()!=null) {
				dto.setPan(a.getAccVerification().getPanNumber());
				dto.setStatus(true);
				
			}
			else {
				dto.setPan("pending");
				dto.setStatus(false);
			}
			
		}
		return dto;
	}

}
