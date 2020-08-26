package com.it.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_Deliverry")
public class DeliverryEntity {

	
	@Id
	@Column(name = "dr_id")
	private Integer drId;

	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "shop_id")
	private Integer shopId;

	@Column(name = "dr_tracking_no")
	private String drTrackingNo;

	@Column(name = "dr_status")
	private String drStatus;

	public Integer getDrId() {
		return drId;
	}

	public void setDrId(Integer drId) {
		this.drId = drId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getDrTrackingNo() {
		return drTrackingNo;
	}

	public void setDrTrackingNo(String drTrackingNo) {
		this.drTrackingNo = drTrackingNo;
	}

	public String getDrStatus() {
		return drStatus;
	}

	public void setDrStatus(String drStatus) {
		this.drStatus = drStatus;
	}
	
	
}
