package net.company.dto;

// 태훈 추가 - 기업등록
public class CompanyRegister {
	
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
	private String cp_monthly_profit;
	private String iv_contraction_during;
	private String iv_min_amount;
	private String iv_appl_stock;
	private String iv_goal_amount;
	private String iv_appl_day;
	private String cp_reward_main_title;
	private String cp_reward_sub_title;
	private String cp_reward_content;
	private String cp_intro_headline;
	private String cp_intro_content;
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
	private String cf_folder;
	
	// String /**/ 구분 데이터
	private String point_title_string;
	private String point_content_string;
	private String pay_count_string;
	private String pay_payment_date_string;
	private String pay_principal_string;
	private String pay_interest_string;
	private String pay_fees_string;
	private String pay_actual_payment_string;
	private String pay_actual_rate_string;
	private String notice_title_string;
	private String notice_content_string;
	
	
	// file
	private String cf_thumbnail;
	private String cf_alias_thumbnail;
	private String cf_pr_background;
	private String cf_alias_pr_background;
	private String cf_business_plan;
	private String cf_alias_business_plan;
	private String cf_funding_contract;
	private String cf_alias_funding_contract;
	private String cf_info_banner;
	private String cf_alias_info_banner;
	// files
	private String store_images;
	private String alias_store_images;
	private String business_plan;
	private String alias_business_plan;
	private String etc_files;
	private String alias_etc_files;
	
	
	public String getCf_folder() {
		return cf_folder;
	}
	public void setCf_folder(String cf_folder) {
		this.cf_folder = cf_folder;
	}
	public String getAlias_store_images() {
		return alias_store_images;
	}
	public void setAlias_store_images(String alias_store_images) {
		this.alias_store_images = alias_store_images;
	}
	public String getAlias_business_plan() {
		return alias_business_plan;
	}
	public void setAlias_business_plan(String alias_business_plan) {
		this.alias_business_plan = alias_business_plan;
	}
	public String getAlias_etc_files() {
		return alias_etc_files;
	}
	public void setAlias_etc_files(String alias_etc_files) {
		this.alias_etc_files = alias_etc_files;
	}
	public String getPay_actual_payment_string() {
		return pay_actual_payment_string;
	}
	public void setPay_actual_payment_string(String pay_actual_payment_string) {
		this.pay_actual_payment_string = pay_actual_payment_string;
	}
	public String getPay_count_string() {
		return pay_count_string;
	}
	public void setPay_count_string(String pay_count_string) {
		this.pay_count_string = pay_count_string;
	}
	public String getPay_payment_date_string() {
		return pay_payment_date_string;
	}
	public void setPay_payment_date_string(String pay_payment_date_string) {
		this.pay_payment_date_string = pay_payment_date_string;
	}
	public String getPay_principal_string() {
		return pay_principal_string;
	}
	public void setPay_principal_string(String pay_principal_string) {
		this.pay_principal_string = pay_principal_string;
	}
	public String getPay_interest_string() {
		return pay_interest_string;
	}
	public void setPay_interest_string(String pay_interest_string) {
		this.pay_interest_string = pay_interest_string;
	}
	public String getPay_fees_string() {
		return pay_fees_string;
	}
	public void setPay_fees_string(String pay_fees_string) {
		this.pay_fees_string = pay_fees_string;
	}
	public String getPay_actual_rate_string() {
		return pay_actual_rate_string;
	}
	public void setPay_actual_rate_string(String pay_actual_rate_string) {
		this.pay_actual_rate_string = pay_actual_rate_string;
	}
	public String getNotice_title_string() {
		return notice_title_string;
	}
	public void setNotice_title_string(String notice_title_string) {
		this.notice_title_string = notice_title_string;
	}
	public String getNotice_content_string() {
		return notice_content_string;
	}
	public void setNotice_content_string(String notice_content_string) {
		this.notice_content_string = notice_content_string;
	}
	public String getStore_images() {
		return store_images;
	}
	public void setStore_images(String store_images) {
		this.store_images = store_images;
	}
	public String getBusiness_plan() {
		return business_plan;
	}
	public void setBusiness_plan(String business_plan) {
		this.business_plan = business_plan;
	}
	public String getEtc_files() {
		return etc_files;
	}
	public void setEtc_files(String etc_files) {
		this.etc_files = etc_files;
	}
	public String getPoint_title_string() {
		return point_title_string;
	}
	public void setPoint_title_string(String point_title_string) {
		this.point_title_string = point_title_string;
	}
	public String getPoint_content_string() {
		return point_content_string;
	}
	public void setPoint_content_string(String point_content_string) {
		this.point_content_string = point_content_string;
	}
	public String getCp_address() {
		return cp_address;
	}
	public void setCp_address(String cp_address) {
		this.cp_address = cp_address;
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
	public String getCf_info_banner() {
		return cf_info_banner;
	}
	public void setCf_info_banner(String cf_info_banner) {
		this.cf_info_banner = cf_info_banner;
	}
	public String getCf_alias_info_banner() {
		return cf_alias_info_banner;
	}
	public void setCf_alias_info_banner(String cf_alias_info_banner) {
		this.cf_alias_info_banner = cf_alias_info_banner;
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
	public String getCp_add_ch() {
		return cp_add_ch;
	}
	public void setCp_add_ch(String cp_add_ch) {
		this.cp_add_ch = cp_add_ch;
	}
	public String getCp_monthly_profit() {
		return cp_monthly_profit;
	}
	public void setCp_monthly_profit(String cp_monthly_profit) {
		this.cp_monthly_profit = cp_monthly_profit;
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
	@Override
	public String toString() {
		return "CompanyRegister [cp_sector=" + cp_sector + ", cp_name=" + cp_name + ", cp_branch=" + cp_branch
				+ ", cp_manager=" + cp_manager + ", cp_number=" + cp_number + ", cp_capital=" + cp_capital
				+ ", cp_address=" + cp_address + ", cp_add_ch=" + cp_add_ch + ", cp_add_more=" + cp_add_more
				+ ", cp_add_num=" + cp_add_num + ", cp_monthly_profit=" + cp_monthly_profit + ", iv_contraction_during="
				+ iv_contraction_during + ", iv_min_amount=" + iv_min_amount + ", iv_appl_stock=" + iv_appl_stock
				+ ", iv_goal_amount=" + iv_goal_amount + ", iv_appl_day=" + iv_appl_day + ", cp_reward_main_title="
				+ cp_reward_main_title + ", cp_reward_sub_title=" + cp_reward_sub_title + ", cp_reward_content="
				+ cp_reward_content + ", cp_intro_headline=" + cp_intro_headline + ", cp_intro_content="
				+ cp_intro_content + ", pl_year=" + pl_year + ", pl_month=" + pl_month + ", pl_sales=" + pl_sales
				+ ", pl_material=" + pl_material + ", pl_person_pay=" + pl_person_pay + ", pl_rent_building="
				+ pl_rent_building + ", pl_operating_pay=" + pl_operating_pay + ", pl_net_revenue=" + pl_net_revenue
				+ ", ma_odds_percent=" + ma_odds_percent + ", ma_odds_money=" + ma_odds_money + ", ma_share_percent="
				+ ma_share_percent + ", ma_share_money=" + ma_share_money + ", ma_platform_pay=" + ma_platform_pay
				+ ", ma_estimated_revenue=" + ma_estimated_revenue + ", ma_monthly_average=" + ma_monthly_average
				+ ", cf_folder=" + cf_folder + ", point_title_string=" + point_title_string + ", point_content_string="
				+ point_content_string + ", pay_count_string=" + pay_count_string + ", pay_payment_date_string="
				+ pay_payment_date_string + ", pay_principal_string=" + pay_principal_string + ", pay_interest_string="
				+ pay_interest_string + ", pay_fees_string=" + pay_fees_string + ", pay_actual_payment_string="
				+ pay_actual_payment_string + ", pay_actual_rate_string=" + pay_actual_rate_string
				+ ", notice_title_string=" + notice_title_string + ", notice_content_string=" + notice_content_string
				+ ", cf_thumbnail=" + cf_thumbnail + ", cf_alias_thumbnail=" + cf_alias_thumbnail
				+ ", cf_pr_background=" + cf_pr_background + ", cf_alias_pr_background=" + cf_alias_pr_background
				+ ", cf_business_plan=" + cf_business_plan + ", cf_alias_business_plan=" + cf_alias_business_plan
				+ ", cf_funding_contract=" + cf_funding_contract + ", cf_alias_funding_contract="
				+ cf_alias_funding_contract + ", cf_info_banner=" + cf_info_banner + ", cf_alias_info_banner="
				+ cf_alias_info_banner + ", store_images=" + store_images + ", alias_store_images=" + alias_store_images
				+ ", business_plan=" + business_plan + ", alias_business_plan=" + alias_business_plan + ", etc_files="
				+ etc_files + ", alias_etc_files=" + alias_etc_files + "]";
	}
	
	
	
	

}
