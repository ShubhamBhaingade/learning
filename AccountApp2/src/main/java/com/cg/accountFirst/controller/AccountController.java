package com.cg.accountFirst.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.accountFirst.entity.Account;
import com.cg.accountFirst.service.IAccountService;

@RestController
@RequestMapping("/myaccountApp")
public class AccountController {
	@Autowired
	IAccountService service;

	public AccountController() {

		System.out.println("inside constructor");
	}

	@PostMapping("/register/account")
	public String saveAccount(Account a) {
		String notification = service.saveAccount(a);
		return notification;
	}

	@GetMapping("/getId/{id}")
	public Account getAccountById(@PathVariable int id) {
		return service.getAccountById(id);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Account>> getAllAccount() {
		// System.out.println("inside controller mapping");
		List<Account> temp = service.getAllAccount();
		System.out.println(temp);
		return new ResponseEntity<List<Account>>(temp, HttpStatus.OK);

	}
	@GetMapping("/accountloc/{loc}")
	public List<Account> getAccountByLocation(@PathVariable String loc){
		return service.getAllAccounts(loc);
	}
	@GetMapping("/account/update/{id}")
	public Account updateAccountPin(@PathVariable int id) {
		return service.updatePin(id);
	}
	
	

}
