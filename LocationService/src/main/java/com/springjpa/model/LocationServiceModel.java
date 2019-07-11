package com.springjpa.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROVINCE")
public class LocationServiceModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "pre_id")
	private long pre_id ;
	
	@Column(name = "pre_code")
	private long pre_code;

	@Column(name = "pre_name")
	private String pre_name;
	
	@Column(name = "pre_describe")
	private String pre_describe;
	
	@Column(name = "pre_order")
	private long pre_order;
	
	@Column(name = "pre_status")
	private int pre_status;

	public long getPre_id() {
		return pre_id;
	}

	public void setPre_id(long pre_id) {
		this.pre_id = pre_id;
	}

	public long getPre_code() {
		return pre_code;
	}

	public void setPre_code(long pre_code) {
		this.pre_code = pre_code;
	}

	public String getPre_name() {
		return pre_name;
	}

	public void setPre_name(String pre_name) {
		this.pre_name = pre_name;
	}

	public String getPre_describe() {
		return pre_describe;
	}

	public void setPre_describe(String pre_describe) {
		this.pre_describe = pre_describe;
	}

	public long getPre_order() {
		return pre_order;
	}

	public void setPre_order(long pre_order) {
		this.pre_order = pre_order;
	}

	public int getPre_status() {
		return pre_status;
	}

	public void setPre_status(int pre_status) {
		this.pre_status = pre_status;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LocationServiceModel(long pre_id, long pre_code, String pre_name, String pre_describe, long pre_order, int pre_status) {
		super();
		this.pre_id = pre_id;
		this.pre_code = pre_code;
		this.pre_name = pre_name;
		this.pre_describe = pre_describe;
		this.pre_order = pre_order;
		this.pre_status = pre_status;
	}

	public LocationServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
