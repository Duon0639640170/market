package com.it.dto;

import java.math.BigDecimal;

public class ProductDto {

	private int pd_id;
	private int shop_id;
	private String pd_name;
	private String pd_img;
	private BigDecimal pd_price;
	private String pd_details;
	private  int pd_number;
	public int getPd_id() {
		return pd_id;
	}
	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public String getPd_img() {
		return pd_img;
	}
	public void setPd_img(String pd_img) {
		this.pd_img = pd_img;
	}
	public BigDecimal getPd_price() {
		return pd_price;
	}
	public void setPd_price(BigDecimal pd_price) {
		this.pd_price = pd_price;
	}
	public String getPd_details() {
		return pd_details;
	}
	public void setPd_details(String pd_details) {
		this.pd_details = pd_details;
	}
	public int getPd_number() {
		return pd_number;
	}
	public void setPd_number(int pd_number ) {
		this.pd_number = pd_number;
	}
	
	
	


}
