package com.it.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_payment")
public class PaymentEntity {

	@Id
	@Column(name = "pm_id")
	private Integer pm_id;

	@Column(name = "id")
	private Integer id;

	@Column(name = "pd_id")
	private Integer pd_id;

	@Column(name = "pm_totalpric")
	private BigDecimal pm_totalpric;

	@Column(name = "pm_img")
	private String pm_img;

	@Column(name = "pm_date")
	private String pm_date;
	
	@Column(name = "pm_status")
	private String pm_status;

	@Column(name = "tracking_no")
	private String tracking_no;

	public Integer getPm_id() {
		return pm_id;
	}

	public void setPm_id(Integer pm_id) {
		this.pm_id = pm_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPd_id() {
		return pd_id;
	}

	public void setPd_id(Integer pd_id) {
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

	public String getTracking_no() {
		return tracking_no;
	}

	public void setTracking_no(String tracking_no) {
		this.tracking_no = tracking_no;
	}


	
}
