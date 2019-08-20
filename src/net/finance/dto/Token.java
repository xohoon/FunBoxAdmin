package net.finance.dto;


public class Token {
	
	private String mb_id;
	private String td_to_address;
	private String td_from_address;
	private String td_amount;
	private String td_status;
	private String td_date_time;
	
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getTd_to_address() {
		return td_to_address;
	}
	public void setTd_to_address(String td_to_address) {
		this.td_to_address = td_to_address;
	}
	public String getTd_from_address() {
		return td_from_address;
	}
	public void setTd_from_address(String td_from_address) {
		this.td_from_address = td_from_address;
	}
	public String getTd_amount() {
		return td_amount;
	}
	public void setTd_amount(String td_amount) {
		this.td_amount = td_amount;
	}
	public String getTd_status() {
		return td_status;
	}
	public void setTd_status(String td_status) {
		this.td_status = td_status;
	}
	public String getTd_date_time() {
		return td_date_time;
	}
	public void setTd_date_time(String td_date_time) {
		this.td_date_time = td_date_time;
	}
	@Override
	public String toString() {
		return "Token [mb_id=" + mb_id + ", td_to_address=" + td_to_address + ", td_from_address=" + td_from_address
				+ ", td_amount=" + td_amount + ", td_status=" + td_status + ", td_date_time=" + td_date_time + "]";
	}
		
	
}
