package net.company.dto;

// 태훈 실시간 수동 
public class CompanyPopularityList {
	
	private int cp_idx;
	private String cp_name;
	private String manager_name;
	private String member_id;
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
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	@Override
	public String toString() {
		return "CompanyPopularityList [cp_idx=" + cp_idx + ", cp_name=" + cp_name + ", manager_name=" + manager_name
				+ ", member_id=" + member_id + "]";
	}
	
	

}
