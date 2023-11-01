package com.cg.accountThird.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="account_table")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int balance;
	private String loc;
	private int mobilePin;
	private String accountType;
	//Verfication Embeded
	@Embedded
	private Verification accVerification;
	//policy one to one
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="policyCode")
	private Policy policy;
	
	
	//Debit card
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="debitId")
	private DebitCard debitCard;
	//One to many
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="trasactionId")
	private List<Transaction> allTransaction;
	
	public Account(int balance, String loc, int mobilePin, String accountType) {
		super();
		this.balance = balance;
		this.loc = loc;
		this.mobilePin = mobilePin;
		this.accountType = accountType;
	}
	
	

}
