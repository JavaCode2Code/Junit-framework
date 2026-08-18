package com.scjp.java.entity;

public class Account {

	private Long accountNumer;
	private String accHolderName;
	private Double balance;

	public Account(Long accountNumer, String accHolderName, Double balance) {
		super();
		this.accountNumer = accountNumer;
		this.accHolderName = accHolderName;
		this.balance = balance;
	}

	public Long getAccountNumer() {
		return accountNumer;
	}

	public void setAccountNumer(Long accountNumer) {
		this.accountNumer = accountNumer;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
