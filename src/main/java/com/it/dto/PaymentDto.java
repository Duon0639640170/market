package com.it.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class PaymentDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int pm_id;
	private int id;
	private String dr_adress;
	private String dr_status;
	private BigDecimal pm_totalpric;
	private String pm_img;
	private String pm_date;
	private String pm_status;
	private String tracking_no;
	private String pm_no;
	private List<OrderDto> orders;

	public List<OrderDto> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}

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


	public String getDr_adress() {
		return dr_adress;
	}

	
	public String getDr_status() {
		return dr_status;
	}

	public void setDr_status(String dr_status) {
		this.dr_status = dr_status;
	}

	public void setDr_adress(String dr_adress) {
		this.dr_adress = dr_adress;
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

	public String getTracking_no() {
		return tracking_no;
	}

	public void setTracking_no(String tracking_no) {
		this.tracking_no = tracking_no;
	}

	public String getPm_no() {
		return pm_no;
	}

	public void setPm_no(String pm_no) {
		this.pm_no = pm_no;
	}

}
