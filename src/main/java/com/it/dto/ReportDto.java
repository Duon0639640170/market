package com.it.dto;

public class ReportDto {

	
	private int rp_id;
	private int user_id;
	private int shop_id;
	private int pd_id;
	private String rp_product;
	private String rp_trackingnumber;
	private String rp_date;
	
	public ReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportDto(int rp_id, int user_id, int  shop_id, String  rp_product, String rp_trackingnumber, String rp_date) {
		super();
		this.rp_id = rp_id;
		this.user_id = user_id;
		this.shop_id = shop_id;
		this.rp_product = rp_product;
		this.rp_trackingnumber = rp_trackingnumber;
		this.rp_date = rp_date;
	}
	
	public int getRp_id() {
		return rp_id;
	}
	public void setRp_id(int rp_id) {
		this.rp_id = rp_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getPd_id() {
		return pd_id;
	}
	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}
	public String getRp_product() {
		return rp_product;
	}
	public void setRp_product(String rp_product) {
		this.rp_product = rp_product;
	}
	public String getRp_trackingnumber() {
		return rp_trackingnumber;
	}
	public void setRp_trackingnumber(String rp_trackingnumber) {
		this.rp_trackingnumber = rp_trackingnumber;
	}
	public String getRp_date() {
		return rp_date;
	}
	public void setRp_date(String rp_date) {
		this.rp_date = rp_date;
	}
	
	
	
}
