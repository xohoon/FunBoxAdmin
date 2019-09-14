package net.company.dto;

public class CompanyInvested {
	private int cp_idx;
	private String cp_name;
	private String mb_id;
	private String cp_manager;
	private String cp_phone;
	private int cp_pre_net_profit_ratio;
	private String iv_min_amount;
	private String iv_goal_amount;
	private String iv_current_amount;
	private String cp_monthly_profit;
	private String ma_estimated_revenue;
	private int d_day;
	private String cp_funding_status;
	private String cp_revenue_distribution_status;
	private String cp_overdue_status;
	private String iv_balance_stock;
	private String result;
	
	
	
	
	public String getCp_revenue_distribution_status() {
		return cp_revenue_distribution_status;
	}

	public void setCp_revenue_distribution_status(String cp_revenue_distribution_status) {
		this.cp_revenue_distribution_status = cp_revenue_distribution_status;
	}

	public String getCp_overdue_status() {
		return cp_overdue_status;
	}

	public void setCp_overdue_status(String cp_overdue_status) {
		this.cp_overdue_status = cp_overdue_status;
	}

	public String getCp_funding_status() {
		return cp_funding_status;
	}

	public void setCp_funding_status(String cp_funding_status) {
		this.cp_funding_status = cp_funding_status;
	}

	public int getCp_pre_net_profit_ratio() {
		return cp_pre_net_profit_ratio;
	}

	public void setCp_pre_net_profit_ratio(int cp_pre_net_profit_ratio) {
		this.cp_pre_net_profit_ratio = cp_pre_net_profit_ratio;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getIv_min_amount() {
		return iv_min_amount;
	}

	public void setIv_min_amount(String iv_min_amount) {
		this.iv_min_amount = iv_min_amount;
	}

	public String getIv_goal_amount() {
		return iv_goal_amount;
	}

	public void setIv_goal_amount(String iv_goal_amount) {
		this.iv_goal_amount = iv_goal_amount;
	}

	public String getIv_current_amount() {
		return iv_current_amount;
	}

	public void setIv_current_amount(String iv_current_amount) {
		this.iv_current_amount = iv_current_amount;
	}

	public String getCp_monthly_profit() {
		return cp_monthly_profit;
	}

	public void setCp_monthly_profit(String cp_monthly_profit) {
		this.cp_monthly_profit = cp_monthly_profit;
	}
	
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

	@Override
	public String toString() {
		return "CompanyInvested [cp_idx=" + cp_idx + ", cp_name=" + cp_name + ", mb_id=" + mb_id + ", cp_manager="
				+ cp_manager + ", cp_phone=" + cp_phone + ", cp_pre_net_profit_ratio=" + cp_pre_net_profit_ratio
				+ ", iv_min_amount=" + iv_min_amount + ", iv_goal_amount=" + iv_goal_amount + ", iv_current_amount="
				+ iv_current_amount + ", cp_monthly_profit=" + cp_monthly_profit + ", ma_estimated_revenue="
				+ ma_estimated_revenue + ", d_day=" + d_day + ", cp_funding_status=" + cp_funding_status
				+ ", cp_revenue_distribution_status=" + cp_revenue_distribution_status + ", cp_overdue_status="
				+ cp_overdue_status + ", iv_balance_stock=" + iv_balance_stock + ", result=" + result + "]";
	}

	

	

	
}
