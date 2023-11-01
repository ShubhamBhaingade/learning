package com.cg.accountThird.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.accountThird.entity.DebitCard;
import com.cg.accountThird.repository.IDebitCardRepository;

@Service
public class DebitCardServiceImpl implements IDebitCardService {
	@Autowired
	IDebitCardRepository debitCardRepository;

	@Override
	public long saveDebitCard(DebitCard debitCard) {
		long dbCode=0;
		if(debitCard!=null) {
			DebitCard savedDebitCard=debitCardRepository.save(debitCard);
			dbCode=savedDebitCard.getCardNumber();
			
		}
		return dbCode;
		
	}

	@Override
	public DebitCard getDebitCardByCardNumber(long cardNumber) {
		// TODO Auto-generated method stub
		return debitCardRepository.findById(cardNumber).get();
	}
	@Transactional
	@Override
	public DebitCard updatePin(long cardNumber,int pin) {
		DebitCard updatedDebit=debitCardRepository.findById(cardNumber).get();
		if(updatedDebit!=null) {
			updatedDebit.setPin(pin);
			return updatedDebit;
		}
		return null;
	}
	
	
	
	

}
