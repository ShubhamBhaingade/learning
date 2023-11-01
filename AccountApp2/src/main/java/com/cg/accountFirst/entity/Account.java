package com.cg.accountFirst.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	private int id;
	private int balance;
	private String loc;
	private int mobilePin;
	private String accountType;
	public Account(int balance, String loc, int mobilePin, String accountType) {
		super();
		this.balance = balance;
		this.loc = loc;
		this.mobilePin = mobilePin;
		this.accountType = accountType;
	}
	
	


}
