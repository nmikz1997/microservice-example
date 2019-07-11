package com.unit.service.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UNIT")
public class UnitServiceModal implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "unt_id")
	private long unt_id ;
	
	@Column(name = "unt_code")
	private long unt_code;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "unt_name")
	private String unt_name;
	
	@Column(name = "unt_describe")
	private String unt_describe;
	
	@Column(name = "unt_address")
	private String unt_address;
	
	@Column(name = "unt_phone")
	private String unt_phone;
	
	@Column(name = "unt_website")
	private String unt_website;
	
	@Column(name = "unt_order")
	private int unt_order;
	
	@Column(name = "unt_status")
	private int unt_status;

	public long getUnt_id() {
		return unt_id;
	}

	public void setUnt_id(long unt_id) {
		this.unt_id = unt_id;
	}

	public long getUnt_code() {
		return unt_code;
	}

	public void setUnt_code(long unt_code) {
		this.unt_code = unt_code;
	}

	public String getUnt_name() {
		return unt_name;
	}

	public void setUnt_name(String unt_name) {
		this.unt_name = unt_name;
	}

	public String getUnt_describe() {
		return unt_describe;
	}

	public void setUnt_describe(String unt_describe) {
		this.unt_describe = unt_describe;
	}

	public String getUnt_address() {
		return unt_address;
	}

	public void setUnt_address(String unt_address) {
		this.unt_address = unt_address;
	}

	public String getUnt_phone() {
		return unt_phone;
	}

	public void setUnt_phone(String unt_phone) {
		this.unt_phone = unt_phone;
	}

	public String getUnt_website() {
		return unt_website;
	}

	public void setUnt_website(String unt_website) {
		this.unt_website = unt_website;
	}

	public int getUnt_order() {
		return unt_order;
	}

	public void setUnt_order(int unt_order) {
		this.unt_order = unt_order;
	}

	public int getUnt_status() {
		return unt_status;
	}

	public void setUnt_status(int unt_status) {
		this.unt_status = unt_status;
	}

	
	
public UnitServiceModal(long unt_id, long unt_code, String unt_name, String unt_describe, String unt_address,
			String unt_phone, String unt_website, int unt_order, int unt_status) {
		super();
		this.unt_id = unt_id;
		this.unt_code = unt_code;
		this.unt_name = unt_name;
		this.unt_describe = unt_describe;
		this.unt_address = unt_address;
		this.unt_phone = unt_phone;
		this.unt_website = unt_website;
		this.unt_order = unt_order;
		this.unt_status = unt_status;
	}

//	public UnitServiceModal(long unt_id, long unt_code, String unt_name, String unt_describe, int unt_order, int unt_status) {
//		super();
//		this.unt_id = unt_id;
//		this.unt_code = unt_code;
//		this.unt_name = unt_name;
//		this.unt_describe = unt_describe;
//		this.unt_order = unt_order;
//		this.unt_status = unt_status;
//	}

	public UnitServiceModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
