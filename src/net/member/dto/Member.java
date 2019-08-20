package net.member.dto;

import java.util.Date;

public class Member {

	private int mb_idx;
	private String mb_id;
	private String mb_pw;
	private String mb_pincode;
	private String mb_name;
	private String mb_phone;
	private String mb_add_num;
	private String mb_add_ch;
	private String mb_add_more;
	private String mb_add_extra;
	private String mb_email;
	private String mb_recommend;
	private String mb_wallet_address;
	private String mb_point;
	private String mb_token;
	private boolean agree1;
	private boolean agree2;
	private int mb_sort;
	private Date reg_date_time;
	private Date secession_date_time;

	public int getMb_idx() {
		return mb_idx;
	}

	public void setMb_idx(int mb_idx) {
		this.mb_idx = mb_idx;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public String getMb_pw() {
		return mb_pw;
	}

	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}

	public String getMb_pincode() {
		return mb_pincode;
	}

	public void setMb_pincode(String mb_pincode) {
		this.mb_pincode = mb_pincode;
	}

	public String getMb_name() {
		return mb_name;
	}

	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}

	public String getMb_phone() {
		return mb_phone;
	}

	public void setMb_phone(String mb_phone) {
		this.mb_phone = mb_phone;
	}

	public String getMb_add_num() {
		return mb_add_num;
	}

	public void setMb_add_num(String mb_add_num) {
		this.mb_add_num = mb_add_num;
	}

	public String getMb_add_ch() {
		return mb_add_ch;
	}

	public void setMb_add_ch(String mb_add_ch) {
		this.mb_add_ch = mb_add_ch;
	}

	public String getMb_add_more() {
		return mb_add_more;
	}

	public void setMb_add_more(String mb_add_more) {
		this.mb_add_more = mb_add_more;
	}

	public String getMb_add_extra() {
		return mb_add_extra;
	}

	public void setMb_add_extra(String mb_add_extra) {
		this.mb_add_extra = mb_add_extra;
	}

	public String getMb_email() {
		return mb_email;
	}

	public void setMb_email(String mb_email) {
		this.mb_email = mb_email;
	}

	public String getMb_recommend() {
		return mb_recommend;
	}

	public void setMb_recommend(String mb_recommend) {
		this.mb_recommend = mb_recommend;
	}

	public String getMb_wallet_address() {
		return mb_wallet_address;
	}

	public void setMb_wallet_address(String mb_wallet_address) {
		this.mb_wallet_address = mb_wallet_address;
	}

	public String getMb_point() {
		return mb_point;
	}

	public void setMb_point(String mb_point) {
		this.mb_point = mb_point;
	}

	public String getMb_token() {
		return mb_token;
	}

	public void setMb_token(String mb_token) {
		this.mb_token = mb_token;
	}

	public boolean isAgree1() {
		return agree1;
	}

	public void setAgree1(boolean agree1) {
		this.agree1 = agree1;
	}

	public boolean isAgree2() {
		return agree2;
	}

	public void setAgree2(boolean agree2) {
		this.agree2 = agree2;
	}

	public int getMb_sort() {
		return mb_sort;
	}

	public void setMb_sort(int mb_sort) {
		this.mb_sort = mb_sort;
	}

	public Date getReg_date_time() {
		return reg_date_time;
	}

	public void setReg_date_time(Date reg_date_time) {
		this.reg_date_time = reg_date_time;
	}

	public Date getSecession_date_time() {
		return secession_date_time;
	}

	public void setSecession_date_time(Date secession_date_time) {
		this.secession_date_time = secession_date_time;
	}

	@Override
	public String toString() {
		return "Member [mb_idx=" + mb_idx + ", mb_id=" + mb_id + ", mb_pw=" + mb_pw + ", mb_pincode=" + mb_pincode
				+ ", mb_name=" + mb_name + ", mb_phone=" + mb_phone + ", mb_add_num=" + mb_add_num + ", mb_add_ch="
				+ mb_add_ch + ", mb_add_more=" + mb_add_more + ", mb_add_extra=" + mb_add_extra + ", mb_email="
				+ mb_email + ", mb_recommend=" + mb_recommend + ", mb_wallet_address=" + mb_wallet_address
				+ ", mb_point=" + mb_point + ", mb_token=" + mb_token + ", agree1=" + agree1 + ", agree2=" + agree2
				+ ", mb_sort=" + mb_sort + ", reg_date_time=" + reg_date_time + ", secession_date_time="
				+ secession_date_time + ", getMb_idx()=" + getMb_idx() + ", getMb_id()=" + getMb_id() + ", getMb_pw()="
				+ getMb_pw() + ", getMb_pincode()=" + getMb_pincode() + ", getMb_name()=" + getMb_name()
				+ ", getMb_phone()=" + getMb_phone() + ", getMb_add_num()=" + getMb_add_num() + ", getMb_add_ch()="
				+ getMb_add_ch() + ", getMb_add_more()=" + getMb_add_more() + ", getMb_add_extra()=" + getMb_add_extra()
				+ ", getMb_email()=" + getMb_email() + ", getMb_recommend()=" + getMb_recommend()
				+ ", getMb_wallet_address()=" + getMb_wallet_address() + ", getMb_point()=" + getMb_point()
				+ ", getMb_token()=" + getMb_token() + ", isAgree1()=" + isAgree1() + ", isAgree2()=" + isAgree2()
				+ ", getMb_sort()=" + getMb_sort() + ", getReg_date_time()=" + getReg_date_time()
				+ ", getSecession_date_time()=" + getSecession_date_time() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
