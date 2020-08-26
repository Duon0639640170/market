package com.it.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order")
public class OrderEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer order_id;

	@Column(name = "id")
	private Integer id;

	@Column(name = "shop_id")
	private Integer shopId;

	@Column(name = "pd_id")
	private Integer pd_id;
	
	@Column(name = "order_ref")
	private String order_ref;
	
	@Column(name = "order_name")
	private String order_name;
	
	@Column(name = "order_date")
	private String order_date;

	@Column(name = "order_number")
	private Integer order_number;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShop_id() {
		return shopId;
	}

	public void setShop_id(Integer shop_id) {
		this.shopId = shop_id;
	}

	public Integer getPd_id() {
		return pd_id;
	}

	public void setPd_id(Integer pd_id) {
		this.pd_id = pd_id;
	}
	
	public String getOrder_ref() {
		return order_ref;
	}

	public void setOrder_ref(String order_ref) {
		this.order_ref = order_ref;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public Integer getOrder_number() {
		return order_number;
	}

	public void setOrder_number(Integer order_number) {
		this.order_number = order_number;
	}

	
	
	
}
