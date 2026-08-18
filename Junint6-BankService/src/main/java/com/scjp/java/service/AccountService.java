package com.scjp.java.service;

import java.util.HashMap;
import java.util.Map;

import com.scjp.java.entity.Account;
import com.scjp.java.exception.AccountNotFoundException;

public class AccountService {

	Map<Long,Account> accounts=new HashMap<>();
	
	public Account createAccount(Long aacountNumber,String holderName,Double balance)  {
		if(accounts.containsKey(aacountNumber)) {
			throw new IllegalArgumentException("Account with same number already exists");
		}
		
		Account account=new Account(aacountNumber, holderName, balance);
		accounts.put(aacountNumber, account);
		return account;
	}
	
	public Account updateAccount(Long accouNum,String holderName) {
		Account account =accounts.get(accouNum);
		
		if(account==null) {
			throw new AccountNotFoundException("Account not found");
			
		}
		account.setAccHolderName(holderName);
		return account;
	}
	
	public Account getAccount(Long accountNum) {
		Account account=accounts.get(accountNum);
		if(account==null) {
			throw new AccountNotFoundException("Account not found");
		}
		return account;
	}
	
	public void removeAccount(Long accountNum) {
		Account account=accounts.get(accountNum);
		if(account==null) {
			throw new AccountNotFoundException("Account not found");
		}
		accounts.remove(accountNum);
	}
	
	public void deposit(Long accountNum,Double amount) {
		Account account=accounts.get(accountNum);
		if(account==null) {
			throw new AccountNotFoundException("Account is not exist");
			
		}
		
		if(amount<0) {
			throw new IllegalArgumentException("Deposit amount must be greater than zero.");
		}
		
		Double amount2=account.getBalance()+amount;
		account.setBalance(amount2);
		
	}
	
	public void withdraw(Long accNum,Double amount) {
		Account account=accounts.get(accNum);
		if(account==null) {
			throw new AccountNotFoundException("Account is not exists");
		}
		if(amount<0) {
			throw new IllegalArgumentException("Withdraw amount must be greater than zero.");
		}
		
		if(amount>account.getBalance()) {
			throw new IllegalArgumentException("Insuficient Balance");
		}
		
		Double aount2=account.getBalance()-amount;
		account.setBalance(aount2);
	}
	
	public void transferMoney(Long accoNum1,Long accNum2,Double amount) {
		Account fromAccount=accounts.get(accoNum1);
		Account toAccount=accounts.get(accNum2);
		if(fromAccount==null||toAccount==null) {
			throw new AccountNotFoundException("one or Both account not found");
		}
		if(amount<=0) {
			throw new IllegalArgumentException("Ammount is not valid");
		}
		
		if(fromAccount.getBalance()<amount) {
			throw new IllegalArgumentException("please enter valid amount");
		}
		
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
	}
}
