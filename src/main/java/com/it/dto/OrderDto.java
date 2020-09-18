package com.it.dto;

import java.io.Serializable;

public class OrderDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int order_id;
	private int id;
	private int shop_id;
	private int pd_id;
	private String order_ref;
	private String order_name;
	private String order_date;
	private int order_number;

	public OrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDto(int order_id, int id, int shop_id, int pd_id, String order_ref, String order_name,
			String order_date, int order_number) {
		super();
		this.order_id = order_id;
		this.id = id;
		this.shop_id = shop_id;
		this.pd_id = pd_id;
		this.order_ref = order_ref;
		this.order_name = order_name;
		this.order_date = order_date;
		this.order_number = order_number;
	}
	private ProductDto productType;


	public ProductDto getProductType() {
		return productType;
	}

	public void setProductType(ProductDto productType) {
		this.productType = productType;
	}
	
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}

	
}
