package com.springjpa.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Ward")
public class WardServiceModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "wad_id")
	private long wad_id ;
	
	@Column(name = "wad_code")
	private long wad_code;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "wad_name")
	private String wad_name;
	
	@Column(name = "wad_describe")
	private String wad_describe;
	
	@Column(name = "wad_order")
	private int wad_order;
	
	@Column(name = "wad_status")
	private int wad_status;
	
	@Column(name = "dit_id")
	private long dit_id;
	
	public long getdit_id() {
		return wad_id;
	}

	public void setdit_id(long dit_id) {
		this.dit_id = dit_id;
	}
	
	public long getwad_id() {
		return wad_id;
	}

	public void setwad_id(long wad_id) {
		this.wad_id = wad_id;
	}

	public long getwad_code() {
		return wad_code;
	}

	public void setwad_code(long wad_code) {
		this.wad_code = wad_code;
	}

	public String getwad_name() {
		return wad_name;
	}

	public void setwad_name(String wad_name) {
		this.wad_name = wad_name;
	}

	public String getwad_describe() {
		return wad_describe;
	}

	public void setwad_describe(String wad_describe) {
		this.wad_describe = wad_describe;
	}

	public int getwad_order() {
		return wad_order;
	}

	public void setwad_order(int wad_order) {
		this.wad_order = wad_order;
	}

	public int getwad_status() {
		return wad_status;
	}

	public void setwad_status(int wad_status) {
		this.wad_status = wad_status;
	}

	public WardServiceModel(long wad_id, long wad_code, String wad_name, String wad_describe, int wad_order, int wad_status, long dit_id) {
		super();
		this.wad_id = wad_id;
		this.wad_code = wad_code;
		this.wad_name = wad_name;
		this.wad_describe = wad_describe;
		this.wad_order = wad_order;
		this.wad_status = wad_status;
		this.dit_id = dit_id;
	}

	public WardServiceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
