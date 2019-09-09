package net.company.dto;

public class CompanyInvested {
	private int cp_idx;
	private String cp_name;
	private String mb_id;
	private String cp_manager;
	private String cp_phone;
	// private int cp_pre_net_profit_ratio;
	private String ma_estimated_revenue;
	private int d_day;
	private String iv_balance_stock;

	public int getCp_idx() {
		return cp_idx;
	}

	public void setCp_idx(int cp_idx) {
		this.cp_idx = cp_idx;
	}

	public String getCp_name() {
		return cp_name;
	}

	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public String getCp_manager() {
		return cp_manager;
	}

	public void setCp_manager(String cp_manager) {
		this.cp_manager = cp_manager;
	}

	public String getCp_phone() {
		return cp_phone;
	}

	public void setCp_phone(String cp_phone) {
		this.cp_phone = cp_phone;
	}

	public String getMa_estimated_revenue() {
		return ma_estimated_revenue;
	}

	public void setMa_estimated_revenue(String ma_estimated_revenue) {
		this.ma_estimated_revenue = ma_estimated_revenue;
	}

	public int getD_day() {
		return d_day;
	}

	public void setD_day(int d_day) {
		this.d_day = d_day;
	}

	public String getIv_balance_stock() {
		return iv_balance_stock;
	}

	public void setIv_balance_stock(String iv_balance_stock) {
		this.iv_balance_stock = iv_balance_stock;
	}

}
