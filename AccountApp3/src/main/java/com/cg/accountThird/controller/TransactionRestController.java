package com.cg.accountThird.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.accountThird.entity.Transaction;
import com.cg.accountThird.service.ITransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionRestController {
	@Autowired
	ITransactionService transactionService;
	@PostMapping("/add")
	public int addTransaction(@RequestBody Transaction trans) {
		int transCode=transactionService.addTransaction(trans);
		return transCode;
		
	}
	@GetMapping("/getbyid")
	public ResponseEntity<Transaction>getTransactionById(@RequestParam int transactionId){
		Transaction savedT= transactionService.getTransactionById(transactionId);
		return new ResponseEntity<Transaction>(savedT,HttpStatus.OK);
	}
	

}
