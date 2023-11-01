package com.cg.accountThird.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.accountThird.entity.DebitCard;
import com.cg.accountThird.service.IDebitCardService;

@RestController
@RequestMapping("/debitcard")
public class DebitCardRestController {
	@Autowired
	IDebitCardService debitCardService;
	@PostMapping("/save")
	public long saveDebitCard(@RequestBody DebitCard debitCard) {

		long savedDbCardNumber = debitCardService.saveDebitCard(debitCard);
		return savedDbCardNumber;

	}
	@GetMapping("getbyid/{cardNum}")
	public DebitCard getDebitCardByCardNumber(@PathVariable long cardNum) {
		DebitCard cNum=debitCardService.getDebitCardByCardNumber(cardNum);
		return cNum;
	}
	@PutMapping("/updatepin")
	public DebitCard updatePin(@RequestParam long c,@RequestParam int p) {
		DebitCard update=debitCardService.updatePin(c, p);
		return update;
		
	}

}
