package com.cg.accountThird.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_debitcard")
public class DebitCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cardNumber;

	private int pin=1234;
	private String expiryDate;
	private boolean cardStatus = true;
	private boolean isBlocked;

}
