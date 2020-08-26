package com.it.dto;

public class SystembankDto {

	private int id;
	private String bank_account;
	private String bank_name;
	private String account_name;
	
	public SystembankDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SystembankDto(int id, String  bank_account, String  bank_name, String account_name) {
		super();
		this.id = id;
		this.bank_account = bank_account;
		this.bank_name = bank_name;
		this.account_name = account_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBank_account() {
		return bank_account;
	}

	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

}
