package com.cg.accountThird.entity;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Verification {
	
	private String panNumber;
	private boolean status; 
	
	public boolean returnBoolean() {
		return status;
	}

}
