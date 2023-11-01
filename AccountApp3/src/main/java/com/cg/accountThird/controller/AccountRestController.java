package com.cg.accountThird.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.accountThird.dto.AccountBasicDTO;
import com.cg.accountThird.dto.AccountRequestSubmitDTO;
import com.cg.accountThird.dto.AccountTransactionResponseDTO;
import com.cg.accountThird.entity.Account;
import com.cg.accountThird.entity.Transaction;
import com.cg.accountThird.entity.Verification;
import com.cg.accountThird.exception.InvalidLocationException;
import com.cg.accountThird.service.AccountServiceImpl;
import com.cg.accountThird.util.AccountBasicMapper;
import com.cg.accountThird.util.AccountDTOConvertor;
import com.cg.accountThird.util.AccountTransactionResponseDTOConvertor;

@RestController
@RequestMapping("/cg")
@Validated
@CrossOrigin(origins = {"http://localhost:4545", "http://localhost:4200"},allowedHeaders = "*")
public class AccountRestController {

	@Autowired
	AccountServiceImpl service;

	@Autowired
	AccountDTOConvertor accConvertor;

	@Autowired
	AccountTransactionResponseDTOConvertor dtoConvertor;
	@Autowired
	AccountBasicMapper dtomapper;

	@PostMapping("/register/account")
	public int saveAccount(@RequestBody @Valid AccountRequestSubmitDTO dto) throws NullPointerException,InvalidLocationException {
		Account a = accConvertor.getAccountFromAccountDTO(dto);
		int notification = service.saveAccount(a);
		return notification;
	}

	@GetMapping("c{id}")
	public Account getAccountById(@PathVariable int id) {
		return service.getAccountById(id);
	}

	@GetMapping("/getall")
	
	public ResponseEntity<List<AccountBasicDTO>> getEmployees()
	{
		System.out.println("inside controller getEmployees()");
		List<Account> temp =  service.getAllAccount();
		
		List<AccountBasicDTO> temp2 = new ArrayList<>();
		
		for (Account e : temp) {
			AccountBasicDTO dto= dtomapper.mapAccountToDto(e);
			temp2.add(dto);
		}
		
		return new ResponseEntity<List<AccountBasicDTO>>(temp2, HttpStatus.OK);
	}
//	public ResponseEntity<List<Account>> getAllAccount() {
//		 System.out.println("inside controller mapping");
//		List<Account> temp = service.getAllAccount();
//		System.out.println(temp);
//		return new ResponseEntity<List<Account>>(temp, HttpStatus.OK);
//
//	}

	@GetMapping("/getbyloc")
	public ResponseEntity<List<Account>> getAccountByLoc(@RequestParam String l) throws InvalidLocationException {
		List<Account> temp = service.getAccountByLoc(l);
		return new ResponseEntity<List<Account>>(temp, HttpStatus.OK);
	}

	@GetMapping("/getbyaccType")
	public ResponseEntity<List<Account>> getAccountByAccountType(@RequestParam String acc) {
		List<Account> temp = service.getAccountByAccountType(acc);
		return new ResponseEntity<List<Account>>(temp, HttpStatus.OK);
	}

	@PutMapping("/updateaccount")
	public ResponseEntity<Account> updateAccount(@RequestParam int i, @RequestParam int bal) {
		Account updatedAccount = service.updateAccount(i, bal);
		Account a1 = new Account();
		if (updatedAccount != null) {
			return new ResponseEntity<Account>(updatedAccount, HttpStatus.OK);

		} else {
			return new ResponseEntity<Account>(a1, HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updatembpin")
	public ResponseEntity<Account> updateMobilePin(@RequestParam int i, @RequestParam int mb) {
		Account updatedPin = service.updateMobilePin(i, mb);
		Account a1 = new Account();
		if (updatedPin != null) {
			return new ResponseEntity<Account>(updatedPin, HttpStatus.OK);
		}
		return new ResponseEntity<Account>(updatedPin, HttpStatus.NOT_FOUND);
	}

	@PutMapping("/verification")
	public ResponseEntity<String> addVerificationDetails(@RequestParam Verification verification,
			@RequestParam int id) {
		String status = service.addVerificationDetails(id, verification);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	@PutMapping("/addacctopol")
	public Account addPolicy(@RequestParam int accId, @RequestParam int pollCode) {

		Account updatedAcc = service.addPolicyToAccount(accId, pollCode);
		return updatedAcc;
	}

	@PutMapping("/adddebit")
	public Account addDebitCardToAcc(@RequestParam int accId, @RequestParam long debtCode) {
		Account updatedAccount = service.addDebitCardToAccount(accId, debtCode);
		return updatedAccount;

	}

	@PutMapping("/trans") // 10-10-2023 one to many
	public ResponseEntity<String> doAccountAllotment(@RequestParam int transactionId, @RequestParam int searchCode) {
		String status = service.allocateAccountToTransaction(transactionId, searchCode);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}
	
	@GetMapping("/last")
	public ResponseEntity<AccountTransactionResponseDTO>getAccountByTransaction(@RequestParam int id){
		Account a=service.getAccountById(id);
		Transaction t=new Transaction();
		
		AccountTransactionResponseDTO dto=dtoConvertor.getAccountDTO(t);
		return new ResponseEntity<AccountTransactionResponseDTO>(dto,HttpStatus.OK);
		
	}

}
