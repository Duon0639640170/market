package com.it.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_payment")
public class PaymentEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pm_id")
	private Integer pm_id;

	@Column(name = "id")
	private Integer id;

	@Column(name = "order_ref")
	private String order_ref;

	@Column(name = "dr_adress")
	private String dr_adress;

	@Column(name = "dr_status")
	private String dr_status;
	
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

	@Column(name = "pm_no")
	private String pm_no;

	@OneToMany(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "order_ref", referencedColumnName = "order_ref", insertable = false, updatable = false)
	private List<OrderEntity> orderEntities;

	public String getOrder_ref() {
		return order_ref;
	}

	public void setOrderRef(String order_ref) {
		this.order_ref = order_ref;
	}

	public List<OrderEntity> getOrderEntities() {
		return orderEntities;
	}

	public void setOrderEntities(List<OrderEntity> orderEntities) {
		this.orderEntities = orderEntities;
	}

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

	public String getDr_adress() {
		return dr_adress;
	}

	public void setDr_adress(String dr_adress) {
		this.dr_adress = dr_adress;
	}

	public String getDr_status() {
		return dr_status;
	}

	public void setDr_status(String dr_status) {
		this.dr_status = dr_status;
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
