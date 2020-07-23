package com.it.dto;

import java.math.BigDecimal;

public class PaymentDto {

	private int pm_id;
	private int id;
	private int pd_id;
	private BigDecimal pm_totalpric;
	private String pm_img;
	private String pm_date;
	private String pm_status;
	private String pm_parcel;
	
	public int getPm_id() {
		return pm_id;
	}
	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPd_id() {
		return pd_id;
	}
	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}
	public BigDecimal getPm_totalpric() {
		return pm_totalpric;
	}
	public void setPm_totalpric(BigDecimal pm_totalpric) {
		this.pm_totalpric = pm_totalpric;
	}
	public String getPm_img() {
		return pm_img;
	}
	public void setPm_img(String pm_img) {
		this.pm_img = pm_img;
	}
	public String getPm_date() {
		return pm_date;
	}
	public void setPm_date(String pm_date) {
		this.pm_date = pm_date;
	}
	public String getPm_status() {
		return pm_status;
	}
	public void setPm_status(String pm_status) {
		this.pm_status = pm_status;
	}
	public String getPm_parcel() {
		return pm_parcel;
	}
	public void setPm_parcel(String pm_parcel) {
		this.pm_parcel = pm_parcel;
	}


	
	
}