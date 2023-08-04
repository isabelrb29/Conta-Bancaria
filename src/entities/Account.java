package entities;

import exceptions.BusinessException;

public class Account {
	//Variaveis
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	//Contrutores
	public Account() {
	}
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}
	
	//Gets e Sets
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public String getHolder() {
		return holder;
	}
	
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	//Metodos
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}
	
	//Validando valor de saque caso seja maior que o limite de saque ou maior que o valor em conta
	private void validateWithdraw(double amount) {
		if (amount > getBalance()) {
			throw new BusinessException("Withdraw error: Balance is not enough.");
		}
		if (amount > getWithdrawLimit()) {
			throw new BusinessException("Withdraw error: The amount exceeds withdraw limit.");
		}
	}

}
