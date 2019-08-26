package net.company.dto;

public class CompanyDeadLine {
	private int cp_idx;
	private String mb_id;
	private String cp_manager;
	private int cp_monthly_profit;
	private String cp_sector;
	private String cp_name;
	private String cp_branch;
	private String iv_current_amount;
	private String iv_goal_amount;
	private String appl_stop_date_time;
	private String thumbnail_image;
	private String persent;
	
	public int getCp_idx() {
		return cp_idx;
	}
	public void setCp_idx(int cp_idx) {
		this.cp_idx = cp_idx;
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
	public int getCp_monthly_profit() {
		return cp_monthly_profit;
	}
	public void setCp_monthly_profit(int cp_monthly_profit) {
		this.cp_monthly_profit = cp_monthly_profit;
	}
	public String getCp_sector() {
		return cp_sector;
	}
	public void setCp_sector(String cp_sector) {
		this.cp_sector = cp_sector;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getCp_branch() {
		return cp_branch;
	}
	public void setCp_branch(String cp_branch) {
		this.cp_branch = cp_branch;
	}
	public String getIv_current_amount() {
		return iv_current_amount;
	}
	public void setIv_current_amount(String iv_current_amount) {
		this.iv_current_amount = iv_current_amount;
	}
	public String getIv_goal_amount() {
		return iv_goal_amount;
	}
	public void setIv_goal_amount(String iv_goal_amount) {
		this.iv_goal_amount = iv_goal_amount;
	}
	public String getAppl_stop_date_time() {
		return appl_stop_date_time;
	}
	public void setAppl_stop_date_time(String appl_stop_date_time) {
		this.appl_stop_date_time = appl_stop_date_time;
	}
	public String getThumbnail_image() {
		return thumbnail_image;
	}
	public void setThumbnail_image(String thumbnail_image) {
		this.thumbnail_image = thumbnail_image;
	}
	public String getPersent() {
		return persent;
	}
	public void setPersent(String persent) {
		this.persent = persent;
	}
	
	@Override
	public String toString() {
		return "CompanyDeadLine [cp_idx=" + cp_idx + ", mb_id=" + mb_id + ", cp_manager=" + cp_manager
				+ ", cp_monthly_profit=" + cp_monthly_profit + ", cp_sector=" + cp_sector + ", cp_name=" + cp_name
				+ ", cp_branch=" + cp_branch + ", iv_current_amount=" + iv_current_amount + ", iv_goal_amount="
				+ iv_goal_amount + ", appl_stop_date_time=" + appl_stop_date_time + ", thumbnail_image="
				+ thumbnail_image + ", persent=" + persent + "]";
	}
	
	
	
}
