package com.cg.accountThird.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccountBasicDTO {
	
	
	private int balance;
	private String loc;
	private int mobilePin;
	private String accountType;
	private String pan;
	private boolean status;
	

}
