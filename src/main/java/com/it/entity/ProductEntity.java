package com.it.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class ProductEntity {

	@Id
	@Column(name = "pd_id")
	private Integer pd_id;

	@Column(name = "shop_id")
	private Integer shop_id;

	@Column(name = "pd_name")
	private String 	pd_name;

	@Column(name = "pd_img")
	private String pd_img;

	@Column(name = "pd_price")
	private BigDecimal pd_price;

	@Column(name = "pd_details")
	private String pd_details;

	public Integer getPd_id() {
		return pd_id;
	}

	public void setPd_id(Integer pd_id) {
		this.pd_id = pd_id;
	}

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
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

	
	


}
