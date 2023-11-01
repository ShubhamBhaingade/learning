package com.cg.accountThird.service;

import org.springframework.stereotype.Service;

import com.cg.accountThird.entity.DebitCard;

@Service
public interface IDebitCardService {
	
	public long saveDebitCard(DebitCard debitCard);
	public DebitCard getDebitCardByCardNumber(long cardNumber);
	//DebitCard debitCard
	public DebitCard updatePin(long cardNumber,int pin);

}
