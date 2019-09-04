package net.finance.dto;

import java.util.Date;

public class Invest {
	
	private String mb_id;
	private String mi_category;
	private String mi_name;
	private String mi_point;
	private Date mi_reg_date_time;
	private String mi_note;
	
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMi_category() {
		return mi_category;
	}
	public void setMi_category(String mi_category) {
		this.mi_category = mi_category;
	}
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
	public Date getMi_reg_date_time() {
		return mi_reg_date_time;
	}
	public void setMi_reg_date_time(Date mi_reg_date_time) {
		this.mi_reg_date_time = mi_reg_date_time;
	}
	public String getMi_note() {
		return mi_note;
	}
	public void setMi_note(String mi_note) {
		this.mi_note = mi_note;
	}
	@Override
	public String toString() {
		return "invest [mb_id=" + mb_id + ", mi_category=" + mi_category + ", mi_name=" + mi_name + ", mi_point="
				+ mi_point + ", mi_reg_date_time=" + mi_reg_date_time + ", mi_note=" + mi_note + "]";
	}
	
	
}
