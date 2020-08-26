package com.it.dto;

import java.math.BigDecimal;

public class DeliverryDto {

	private int dr_id;
	private int order_id;
	private int shop_id;
	private String dr_tracking_no;
	private String dr_status;
	public int getDr_id() {
		return dr_id;
	}
	public void setDr_id(int dr_id) {
		this.dr_id = dr_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getDr_tracking_no() {
		return dr_tracking_no;
	}
	public void setDr_tracking_no(String dr_tracking_no) {
		this.dr_tracking_no = dr_tracking_no;
	}
	public String getDr_status() {
		return dr_status;
	}
	public void setDr_status(String dr_status) {
		this.dr_status = dr_status;
	}
	
	
}
