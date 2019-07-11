package com.springjpa.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DISTRICT")
public class DistrictServiceModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "dit_id")
	private long dit_id ;
	
	@Column(name = "dit_code")
	private long dit_code;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "dit_name")
	private String dit_name;
	
	@Column(name = "dit_describe")
	private String dit_describe;
	
	@Column(name = "dit_order")
	private int dit_order;
	
	@Column(name = "dit_status")
	private int dit_status;
	
//	private long count_record;
//	
//	public long getcount_record() {
//		return count_record;
//	}
//	
//	public void setcount_record(long count_record) {
//		this.count_record = count_record;
//	}

	public long getdit_id() {
		return dit_id;
	}

	public void setdit_id(long dit_id) {
		this.dit_id = dit_id;
	}

	public long getdit_code() {
		return dit_code;
	}

	public void setdit_code(long dit_code) {
		this.dit_code = dit_code;
	}

	public String getdit_name() {
		return dit_name;
	}

	public void setdit_name(String dit_name) {
		this.dit_name = dit_name;
	}

	public String getdit_describe() {
		return dit_describe;
	}

	public void setdit_describe(String dit_describe) {
		this.dit_describe = dit_describe;
	}

	public int getdit_order() {
		return dit_order;
	}

	public void setdit_order(int dit_order) {
		this.dit_order = dit_order;
	}

	public int getdit_status() {
		return dit_status;
	}

	public void setdit_status(int dit_status) {
		this.dit_status = dit_status;
	}

	public DistrictServiceModel(long dit_id, long dit_code, String dit_name, String dit_describe, int dit_order, int dit_status) {
		super();
		this.dit_id = dit_id;
		this.dit_code = dit_code;
		this.dit_name = dit_name;
		this.dit_describe = dit_describe;
		this.dit_order = dit_order;
		this.dit_status = dit_status;
	}

	public DistrictServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
