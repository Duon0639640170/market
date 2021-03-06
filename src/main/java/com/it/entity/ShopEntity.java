package com.it.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_shop")
public class ShopEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "shop_id")
	private Integer shop_id;

	@Column(name = "id")
	private Integer id;

	@Column(name = "shop_name")
	private String shop_name;

	@Column(name = "shop_img")
	private String shop_img;

	@Column(name = "shop_address")
	private String shop_address;

	@Column(name = "shop_tel")
	private String shop_tel;
	
	@Column(name = "bank_account_no")
	private String bank_account_no;
	
	@Column(name = "bank_name")
	private String bank_name;

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
