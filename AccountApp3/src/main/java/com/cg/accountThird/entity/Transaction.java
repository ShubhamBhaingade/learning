package com.cg.accountThird.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="tbl_transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private String transactionDate;
	private int transactionAmount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="trasactionId")
	private Account account;
	
	public Transaction(String transactionDate, int transactionAmount) {
		super();
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}
	
	
	

	
	

}
