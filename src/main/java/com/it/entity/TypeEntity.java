package com.it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_type")
public class TypeEntity {
	
	@Id
	@Column(name = "type_id")
	private Integer type_id;

	@Column(name = "type_name")
	private String type_name;

	@Column(name = "type_detail")
	private String type_detail;

	@Column(name = "type_status")
	private String type_status;

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getType_detail() {
		return type_detail;
	}

	public void setType_detail(String type_detail) {
		this.type_detail = type_detail;
	}

	public String getType_status() {
		return type_status;
	}

	public void setType_status(String type_status) {
		this.type_status = type_status;
	}

	
}
