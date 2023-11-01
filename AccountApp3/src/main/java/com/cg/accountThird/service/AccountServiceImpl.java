package com.cg.accountThird.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.accountThird.dto.AccountRequestSubmitDTO;
import com.cg.accountThird.entity.Account;
import com.cg.accountThird.entity.DebitCard;
import com.cg.accountThird.entity.Policy;
import com.cg.accountThird.entity.Transaction;
import com.cg.accountThird.entity.Verification;
import com.cg.accountThird.exception.InvalidLocationException;
import com.cg.accountThird.repository.IAccountRepository;
import com.cg.accountThird.repository.IDebitCardRepository;
import com.cg.accountThird.repository.IPolicyRepository;
import com.cg.accountThird.repository.ITransactionRepository;
import com.cg.accountThird.util.AccountDTOConvertor;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	IAccountRepository accRepository;

	@Autowired
	IPolicyRepository policyRepository;

	@Autowired
	IDebitCardRepository debitCardRepository;
	@Autowired
	ITransactionRepository transactionRepository;

	
	@Override//do it at last
	public List<Transaction> getAllTransactionByAccount(int searchCode) {
		Account a=getAccountById(searchCode);
		List<Transaction>allTransAction=a.getAllTransaction();
		return allTransAction;
	}

	@Override
	@Transactional//one to many
	public String allocateAccountToTransaction(int transactionId, int searchCode) {
		String status="";
		Account a=getAccountById(searchCode);
		Transaction t=transactionRepository.findById(transactionId).get();
		if(a!=null && t!=null) {
			List<Transaction>allTransAction=a.getAllTransaction();
			allTransAction.add(t);
			
			a.setAllTransaction(allTransAction);
			
			status="Account allocated,Account count"+a.getAllTransaction().size();
			
		}
		else {
			status="Account"+a+" Or"+"Transaction"+t;
		}
		return status;
	}

	@Override
	@Transactional//one to one
	public Account addDebitCardToAccount(int searchCode, long cardNumber) {
		Account savedAccount = getAccountById(searchCode);
		DebitCard debitCard = debitCardRepository.findById(cardNumber).get();
		if (savedAccount != null && debitCard != null) {
			savedAccount.setDebitCard(debitCard);
			return savedAccount;
		}
		return null;
	}

	@Override
	@Transactional//one to one
	public Account addPolicyToAccount(int searchCode, int policyCode) {
		Account savedAcc = getAccountById(searchCode);
		Policy policy = policyRepository.findById(policyCode).get();
		if (savedAcc != null && policy != null) {
			savedAcc.setPolicy(policy);
			return savedAcc;
		}
		return null;
	}

	@Override
	@Transactional
	public String addVerificationDetails(int searchId, Verification verification) {
		Account savedAccount = getAccountById(searchId);
		if (savedAccount != null) {
			savedAccount.setAccVerification(verification);
			return "Verification Added" + savedAccount.getAccVerification().isStatus();
		}
		return null;
	}

	@Override
	public int saveAccount(Account a)throws InvalidLocationException {
		if (a==null)throw new NullPointerException("Account is null");
		else if(a!=null) {
			if(a.getLoc().equals("A"))
			{
				throw new InvalidLocationException("location  A is invalid",AccountServiceImpl.class+"");
			}
		}
		Account savedAccount = accRepository.save(a);
		if (savedAccount != null) {
			return savedAccount.getId();
		} else
			return 0;
	}

	@Override
	public Account getAccountById(int searchId) {
		Account savedAccount = accRepository.findById(searchId).get();
		if (savedAccount != null) {
			return savedAccount;
		} else
			return null;
	}

	@Override
	public List<Account> getAllAccount() {
		List<Account> allAccounts = accRepository.findAll();
		if (allAccounts != null || allAccounts.size() != 0) {
//			for(Account a : allAccounts)
//			{
//				AccountDTOConvertor acdto = new AccountDTOConvertor();
//				acdto.
			
			System.out.println("Inside service get all "+allAccounts.size());
				return allAccounts;
//			}
		} else
			return null;
	}

	@Override//write this method in repo
	
	public List<Account> getAccountByLoc(String loc) throws InvalidLocationException {
		if(loc==null||loc.isEmpty()) {
			throw new InvalidLocationException("location is invalid", loc);
		}
		return accRepository.getAccountByLoc(loc);
	}

	@Override
	public List<Account> getAccountByAccountType(String accountType) {

		return accRepository.getAccountByAccountType(accountType);
	}

	@Override
	@Transactional
	public Account updateAccount(int searchId, int newBalance) {
		Account savedAccount = getAccountById(searchId);
		if (savedAccount != null) {
			savedAccount.setBalance(newBalance);
			return savedAccount;
		}
		return null;
	}

	@Override
	@Transactional
	public Account updateMobilePin(int searchId, int newMbPin) {
		Account savedAccount = getAccountById(searchId);
		if (savedAccount != null) {
			savedAccount.setMobilePin(newMbPin);
			return savedAccount;
		}
		return null;

	}

}
