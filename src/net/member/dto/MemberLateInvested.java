package net.member.dto;

import java.util.Date;

public class MemberLateInvested {
	private String mi_name;
	private String mi_point;
	private String mi_hoiling_stock;
	private Date mi_reg_date_time;

	public String getMi_name() {
		return mi_name;
	}

	public void setMi_name(String mi_name) {
		this.mi_name = mi_name;
	}

	public String getMi_point() {
		return mi_point;
	}

	public void setMi_point(String mi_point) {
		this.mi_point = mi_point;
	}

	public String getMi_hoiling_stock() {
		return mi_hoiling_stock;
	}

	public void setMi_hoiling_stock(String mi_hoiling_stock) {
		this.mi_hoiling_stock = mi_hoiling_stock;
	}

	public Date getMi_reg_date_time() {
		return mi_reg_date_time;
	}

	public void setMi_reg_date_time(Date mi_reg_date_time) {
		this.mi_reg_date_time = mi_reg_date_time;
	}

}
