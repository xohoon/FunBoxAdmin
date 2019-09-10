package net.company.dto;

import java.sql.Date;

// 태훈 추가 - 기업등록
public class CompanyDetail {
	private int cp_idx;
	private String cp_sector;
	private String cp_name;
	private String cp_branch;
	private String cp_manager;
	private String cp_number;
	private String cp_capital;
	private String cp_address;
	private String cp_add_ch;
	private String cp_add_more;
	private String cp_add_num;
	private String cp_add_extra;
	private String cp_monthly_profit;
	private String cp_reward_main_title;
	private String cp_reward_sub_title;
	private String cp_reward_content;
	private String cp_intro_headline;
	private String cp_intro_content;
	private String iv_contraction_during;
	private String iv_min_amount;
	private String iv_appl_stock;
	private String iv_goal_amount;
	private String iv_appl_day;
	private String pl_year;
	private String pl_month;
	private String pl_sales;
	private String pl_material;
	private String pl_person_pay;
	private String pl_rent_building;
	private String pl_operating_pay;
	private String pl_net_revenue;
	private String ma_odds_percent;
	private String ma_odds_money;
	private String ma_share_percent;
	private String ma_share_money;
	private String ma_platform_pay;
	private String ma_estimated_revenue;
	private String ma_monthly_average;
	
	
	// String /**/ 구분 데이터	
	private String cp_pay_count;
	private String cp_pay_expected_payment_date;
	private String cp_pay_principal;
	private String cp_pay_interest_paid;
	private String cp_pay_fees;
	private String cp_pay_actual_payment_amout;
	private String cp_pay_actual_rate_return;
	private String cp_point_title;
	private String cp_point_content;
	private String cp_notice_title;
	private String cp_notice_content;
	
	
	// file
	private String cf_thumbnail;
	private String cf_alias_thumbnail;
	private String cf_pr_background;
	private String cf_alias_pr_background;
	private String cf_funding_contract;
	private String cf_alias_funding_contract;
	private String cf_corporation_icon;
	private String cf_alias_corporation_icon;
	private String cf_folder;
	private String cf_business_plan_images;
	private String cf_alias_business_plan_images;
	
	// files
	private String cf_store_images;
	private String cf_alias_store_images;
	private String cf_business_plan;
	private String cf_alias_business_plan;
	private String cf_etc_files;
	private String cf_alias_etc_files;
	
	private String company_file_path;
	private String company_image_path;
	
	//2019-09-09 추가
	private Date cp_open_datetime;
	private Date iv_appl_start_date_time;
	private Date iv_appl_stop_date_time;
	private String mb_id;
	
	
	
	public String getCompany_image_path() {
		return company_image_path;
	}
	public void setCompany_image_path(String company_image_path) {
		this.company_image_path = company_image_path;
	}
	public int getCp_idx() {
		return cp_idx;
	}
	public void setCp_idx(int cp_idx) {
		this.cp_idx = cp_idx;
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
	public String getCp_manager() {
		return cp_manager;
	}
	public void setCp_manager(String cp_manager) {
		this.cp_manager = cp_manager;
	}
	public String getCp_number() {
		return cp_number;
	}
	public void setCp_number(String cp_number) {
		this.cp_number = cp_number;
	}
	public String getCp_capital() {
		return cp_capital;
	}
	public void setCp_capital(String cp_capital) {
		this.cp_capital = cp_capital;
	}
	public String getCp_address() {
		return cp_address;
	}
	public void setCp_address(String cp_address) {
		this.cp_address = cp_address;
	}
	public String getCp_add_ch() {
		return cp_add_ch;
	}
	public void setCp_add_ch(String cp_add_ch) {
		this.cp_add_ch = cp_add_ch;
	}
	public String getCp_add_more() {
		return cp_add_more;
	}
	public void setCp_add_more(String cp_add_more) {
		this.cp_add_more = cp_add_more;
	}
	public String getCp_add_num() {
		return cp_add_num;
	}
	public void setCp_add_num(String cp_add_num) {
		this.cp_add_num = cp_add_num;
	}
	public String getCp_add_extra() {
		return cp_add_extra;
	}
	public void setCp_add_extra(String cp_add_extra) {
		this.cp_add_extra = cp_add_extra;
	}
	public String getCp_monthly_profit() {
		return cp_monthly_profit;
	}
	public void setCp_monthly_profit(String cp_monthly_profit) {
		this.cp_monthly_profit = cp_monthly_profit;
	}
	public String getCp_reward_main_title() {
		return cp_reward_main_title;
	}
	public void setCp_reward_main_title(String cp_reward_main_title) {
		this.cp_reward_main_title = cp_reward_main_title;
	}
	public String getCp_reward_sub_title() {
		return cp_reward_sub_title;
	}
	public void setCp_reward_sub_title(String cp_reward_sub_title) {
		this.cp_reward_sub_title = cp_reward_sub_title;
	}
	public String getCp_reward_content() {
		return cp_reward_content;
	}
	public void setCp_reward_content(String cp_reward_content) {
		this.cp_reward_content = cp_reward_content;
	}
	public String getCp_intro_headline() {
		return cp_intro_headline;
	}
	public void setCp_intro_headline(String cp_intro_headline) {
		this.cp_intro_headline = cp_intro_headline;
	}
	public String getCp_intro_content() {
		return cp_intro_content;
	}
	public void setCp_intro_content(String cp_intro_content) {
		this.cp_intro_content = cp_intro_content;
	}
	public String getIv_contraction_during() {
		return iv_contraction_during;
	}
	public void setIv_contraction_during(String iv_contraction_during) {
		this.iv_contraction_during = iv_contraction_during;
	}
	public String getIv_min_amount() {
		return iv_min_amount;
	}
	public void setIv_min_amount(String iv_min_amount) {
		this.iv_min_amount = iv_min_amount;
	}
	public String getIv_appl_stock() {
		return iv_appl_stock;
	}
	public void setIv_appl_stock(String iv_appl_stock) {
		this.iv_appl_stock = iv_appl_stock;
	}
	public String getIv_goal_amount() {
		return iv_goal_amount;
	}
	public void setIv_goal_amount(String iv_goal_amount) {
		this.iv_goal_amount = iv_goal_amount;
	}
	public String getIv_appl_day() {
		return iv_appl_day;
	}
	public void setIv_appl_day(String iv_appl_day) {
		this.iv_appl_day = iv_appl_day;
	}
	public String getPl_year() {
		return pl_year;
	}
	public void setPl_year(String pl_year) {
		this.pl_year = pl_year;
	}
	public String getPl_month() {
		return pl_month;
	}
	public void setPl_month(String pl_month) {
		this.pl_month = pl_month;
	}
	public String getPl_sales() {
		return pl_sales;
	}
	public void setPl_sales(String pl_sales) {
		this.pl_sales = pl_sales;
	}
	public String getPl_material() {
		return pl_material;
	}
	public void setPl_material(String pl_material) {
		this.pl_material = pl_material;
	}
	public String getPl_person_pay() {
		return pl_person_pay;
	}
	public void setPl_person_pay(String pl_person_pay) {
		this.pl_person_pay = pl_person_pay;
	}
	public String getPl_rent_building() {
		return pl_rent_building;
	}
	public void setPl_rent_building(String pl_rent_building) {
		this.pl_rent_building = pl_rent_building;
	}
	public String getPl_operating_pay() {
		return pl_operating_pay;
	}
	public void setPl_operating_pay(String pl_operating_pay) {
		this.pl_operating_pay = pl_operating_pay;
	}
	public String getPl_net_revenue() {
		return pl_net_revenue;
	}
	public void setPl_net_revenue(String pl_net_revenue) {
		this.pl_net_revenue = pl_net_revenue;
	}
	public String getMa_odds_percent() {
		return ma_odds_percent;
	}
	public void setMa_odds_percent(String ma_odds_percent) {
		this.ma_odds_percent = ma_odds_percent;
	}
	public String getMa_odds_money() {
		return ma_odds_money;
	}
	public void setMa_odds_money(String ma_odds_money) {
		this.ma_odds_money = ma_odds_money;
	}
	public String getMa_share_percent() {
		return ma_share_percent;
	}
	public void setMa_share_percent(String ma_share_percent) {
		this.ma_share_percent = ma_share_percent;
	}
	public String getMa_share_money() {
		return ma_share_money;
	}
	public void setMa_share_money(String ma_share_money) {
		this.ma_share_money = ma_share_money;
	}
	public String getMa_platform_pay() {
		return ma_platform_pay;
	}
	public void setMa_platform_pay(String ma_platform_pay) {
		this.ma_platform_pay = ma_platform_pay;
	}
	public String getMa_estimated_revenue() {
		return ma_estimated_revenue;
	}
	public void setMa_estimated_revenue(String ma_estimated_revenue) {
		this.ma_estimated_revenue = ma_estimated_revenue;
	}
	public String getMa_monthly_average() {
		return ma_monthly_average;
	}
	public void setMa_monthly_average(String ma_monthly_average) {
		this.ma_monthly_average = ma_monthly_average;
	}
	public String getCp_pay_count() {
		return cp_pay_count;
	}
	public void setCp_pay_count(String cp_pay_count) {
		this.cp_pay_count = cp_pay_count;
	}
	public String getCp_pay_expected_payment_date() {
		return cp_pay_expected_payment_date;
	}
	public void setCp_pay_expected_payment_date(String cp_pay_expected_payment_date) {
		this.cp_pay_expected_payment_date = cp_pay_expected_payment_date;
	}
	public String getCp_pay_principal() {
		return cp_pay_principal;
	}
	public void setCp_pay_principal(String cp_pay_principal) {
		this.cp_pay_principal = cp_pay_principal;
	}
	public String getCp_pay_interest_paid() {
		return cp_pay_interest_paid;
	}
	public void setCp_pay_interest_paid(String cp_pay_interest_paid) {
		this.cp_pay_interest_paid = cp_pay_interest_paid;
	}
	public String getCp_pay_fees() {
		return cp_pay_fees;
	}
	public void setCp_pay_fees(String cp_pay_fees) {
		this.cp_pay_fees = cp_pay_fees;
	}
	public String getCp_pay_actual_payment_amout() {
		return cp_pay_actual_payment_amout;
	}
	public void setCp_pay_actual_payment_amout(String cp_pay_actual_payment_amout) {
		this.cp_pay_actual_payment_amout = cp_pay_actual_payment_amout;
	}
	public String getCp_pay_actual_rate_return() {
		return cp_pay_actual_rate_return;
	}
	public void setCp_pay_actual_rate_return(String cp_pay_actual_rate_return) {
		this.cp_pay_actual_rate_return = cp_pay_actual_rate_return;
	}
	public String getCp_point_title() {
		return cp_point_title;
	}
	public void setCp_point_title(String cp_point_title) {
		this.cp_point_title = cp_point_title;
	}
	public String getCp_point_content() {
		return cp_point_content;
	}
	public void setCp_point_content(String cp_point_content) {
		this.cp_point_content = cp_point_content;
	}
	public String getCp_notice_title() {
		return cp_notice_title;
	}
	public void setCp_notice_title(String cp_notice_title) {
		this.cp_notice_title = cp_notice_title;
	}
	public String getCp_notice_content() {
		return cp_notice_content;
	}
	public void setCp_notice_content(String cp_notice_content) {
		this.cp_notice_content = cp_notice_content;
	}
	public String getCf_thumbnail() {
		return cf_thumbnail;
	}
	public void setCf_thumbnail(String cf_thumbnail) {
		this.cf_thumbnail = cf_thumbnail;
	}
	public String getCf_alias_thumbnail() {
		return cf_alias_thumbnail;
	}
	public void setCf_alias_thumbnail(String cf_alias_thumbnail) {
		this.cf_alias_thumbnail = cf_alias_thumbnail;
	}
	public String getCf_pr_background() {
		return cf_pr_background;
	}
	public void setCf_pr_background(String cf_pr_background) {
		this.cf_pr_background = cf_pr_background;
	}
	public String getCf_alias_pr_background() {
		return cf_alias_pr_background;
	}
	public void setCf_alias_pr_background(String cf_alias_pr_background) {
		this.cf_alias_pr_background = cf_alias_pr_background;
	}
	public String getCf_funding_contract() {
		return cf_funding_contract;
	}
	public void setCf_funding_contract(String cf_funding_contract) {
		this.cf_funding_contract = cf_funding_contract;
	}
	public String getCf_alias_funding_contract() {
		return cf_alias_funding_contract;
	}
	public void setCf_alias_funding_contract(String cf_alias_funding_contract) {
		this.cf_alias_funding_contract = cf_alias_funding_contract;
	}
	public String getCf_corporation_icon() {
		return cf_corporation_icon;
	}
	public void setCf_corporation_icon(String cf_corporation_icon) {
		this.cf_corporation_icon = cf_corporation_icon;
	}
	public String getCf_alias_corporation_icon() {
		return cf_alias_corporation_icon;
	}
	public void setCf_alias_corporation_icon(String cf_alias_corporation_icon) {
		this.cf_alias_corporation_icon = cf_alias_corporation_icon;
	}
	public String getCf_folder() {
		return cf_folder;
	}
	public void setCf_folder(String cf_folder) {
		this.cf_folder = cf_folder;
	}
	public String getCf_business_plan_images() {
		return cf_business_plan_images;
	}
	public void setCf_business_plan_images(String cf_business_plan_images) {
		this.cf_business_plan_images = cf_business_plan_images;
	}
	public String getCf_alias_business_plan_images() {
		return cf_alias_business_plan_images;
	}
	public void setCf_alias_business_plan_images(String cf_alias_business_plan_images) {
		this.cf_alias_business_plan_images = cf_alias_business_plan_images;
	}
	public String getCf_store_images() {
		return cf_store_images;
	}
	public void setCf_store_images(String cf_store_images) {
		this.cf_store_images = cf_store_images;
	}
	public String getCf_alias_store_images() {
		return cf_alias_store_images;
	}
	public void setCf_alias_store_images(String cf_alias_store_images) {
		this.cf_alias_store_images = cf_alias_store_images;
	}
	public String getCf_business_plan() {
		return cf_business_plan;
	}
	public void setCf_business_plan(String cf_business_plan) {
		this.cf_business_plan = cf_business_plan;
	}
	public String getCf_alias_business_plan() {
		return cf_alias_business_plan;
	}
	public void setCf_alias_business_plan(String cf_alias_business_plan) {
		this.cf_alias_business_plan = cf_alias_business_plan;
	}
	public String getCf_etc_files() {
		return cf_etc_files;
	}
	public void setCf_etc_files(String cf_etc_files) {
		this.cf_etc_files = cf_etc_files;
	}
	public String getCf_alias_etc_files() {
		return cf_alias_etc_files;
	}
	public void setCf_alias_etc_files(String cf_alias_etc_files) {
		this.cf_alias_etc_files = cf_alias_etc_files;
	}
	public String getCompany_file_path() {
		return company_file_path;
	}
	public void setCompany_file_path(String company_file_path) {
		this.company_file_path = company_file_path;
	}
	public Date getCp_open_datetime() {
		return cp_open_datetime;
	}
	public void setCp_open_datetime(Date cp_open_datetime) {
		this.cp_open_datetime = cp_open_datetime;
	}
	public Date getIv_appl_start_date_time() {
		return iv_appl_start_date_time;
	}
	public void setIv_appl_start_date_time(Date iv_appl_start_date_time) {
		this.iv_appl_start_date_time = iv_appl_start_date_time;
	}
	public Date getIv_appl_stop_date_time() {
		return iv_appl_stop_date_time;
	}
	public void setIv_appl_stop_date_time(Date iv_appl_stop_date_time) {
		this.iv_appl_stop_date_time = iv_appl_stop_date_time;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	
	
	
	
	
}

