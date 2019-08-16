package net.company.dto;

public class CompanyApplication {
	private int app_cp_idx;
	private String mb_id;
	private String app_cp_manager;
	private String app_cp_hp;
	private String app_cp_ch;
	private String app_cp_sector;
	private boolean app_cp_status;
	private boolean app_deleted_status;

	public int getApp_cp_idx() {
		return app_cp_idx;
	}

	public void setApp_cp_idx(int app_cp_idx) {
		this.app_cp_idx = app_cp_idx;
	}

	public String getMb_id() {
		return mb_id;
	}

	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}

	public String getApp_cp_manager() {
		return app_cp_manager;
	}

	public void setApp_cp_manager(String app_cp_manager) {
		this.app_cp_manager = app_cp_manager;
	}

	public String getApp_cp_hp() {
		return app_cp_hp;
	}

	public void setApp_cp_hp(String app_cp_hp) {
		this.app_cp_hp = app_cp_hp;
	}

	public String getApp_cp_ch() {
		return app_cp_ch;
	}

	public void setApp_cp_ch(String app_cp_ch) {
		this.app_cp_ch = app_cp_ch;
	}

	public String getApp_cp_sector() {
		return app_cp_sector;
	}

	public void setApp_cp_sector(String app_cp_sector) {
		this.app_cp_sector = app_cp_sector;
	}

	public boolean isApp_cp_status() {
		return app_cp_status;
	}

	public void setApp_cp_status(boolean app_cp_status) {
		this.app_cp_status = app_cp_status;
	}

	public boolean isApp_deleted_status() {
		return app_deleted_status;
	}

	public void setApp_deleted_status(boolean app_deleted_status) {
		this.app_deleted_status = app_deleted_status;
	}

}
