package com.it.dto;

public class ShopDto {

	private int shop_id;
	private int id;
	private String shop_name;
	private String shop_img;
	private String shop_address;
	private String shop_tel;
	private String bank_account_no;
	private String bank_name;
	
	public ShopDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopDto(int shop_id, int id, String  shop_name, String  shop_img, String shop_address, String shop_tel,
			String bank_account_no, String bank_name) {
		super();
		this.shop_id = shop_id;
		this.id = id;
		this.shop_name = shop_name;
		this.shop_img = shop_img;
		this.shop_address = shop_address;
		this.shop_tel = shop_tel;
		this.bank_account_no = bank_account_no;
		this.bank_name = bank_name;
	}
	
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getShop_img() {
		return shop_img;
	}
	public void setShop_img(String shop_img) {
		this.shop_img = shop_img;
	}
	public String getShop_address() {
		return shop_address;
	}
	public void setShop_address(String shop_address) {
		this.shop_address = shop_address;
	}
	public String getShop_tel() {
		return shop_tel;
	}
	public void setShop_tel(String shop_tel) {
		this.shop_tel = shop_tel;
	}
	public String getBank_account_no() {
		return bank_account_no;
	}
	public void setBank_account_no(String bank_account_no) {
		this.bank_account_no = bank_account_no;
	}
	public String getBank_name() {
		return bank_name;
	}
	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}
	
	

}
