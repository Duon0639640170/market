package com.it.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_report")
public class ReportEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		@Id
		@Column(name = "rp_id")
		private Integer rp_id;

		@Column(name = "user_id")
		private Integer user_id;

		@Column(name = "shop_id")
		private Integer shop_id;

		@Column(name = "pd_id")
		private Integer pd_id;

		@Column(name = "rp_product")
		private String rp_product;

		@Column(name = "rp_trackingnumber")
		private String rp_trackingnumber;
		
		@Column(name = "rp_date")
		private String rp_date;

		public Integer getRp_id() {
			return rp_id;
		}

		public void setRp_id(Integer rp_id) {
			this.rp_id = rp_id;
		}

		public Integer getUser_id() {
			return user_id;
		}

		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}

		public Integer getShop_id() {
			return shop_id;
		}

		public void setShop_id(Integer shop_id) {
			this.shop_id = shop_id;
		}

		public Integer getPd_id() {
			return pd_id;
		}

		public void setPd_id(Integer pd_id) {
			this.pd_id = pd_id;
		}

		public String getRp_product() {
			return rp_product;
		}

		public void setRp_product(String rp_product) {
			this.rp_product = rp_product;
		}

		public String getRp_trackingnumber() {
			return rp_trackingnumber;
		}

		public void setRp_trackingnumber(String rp_trackingnumber) {
			this.rp_trackingnumber = rp_trackingnumber;
		}

		public String getRp_date() {
			return rp_date;
		}

		public void setRp_date(String rp_date) {
			this.rp_date = rp_date;
		}

		
		
		
}
