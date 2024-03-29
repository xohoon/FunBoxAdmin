package net.company.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//import com.mysql.jdbc.CallableStatement;
import com.mysql.cj.jdbc.CallableStatement;

import net.company.dto.Company;
import net.company.dto.CompanyAdded;
import net.company.dto.CompanyApplication;
import net.company.dto.CompanyApplicationDetail;
import net.company.dto.CompanyBean;
import net.company.dto.CompanyDeadLine;
import net.company.dto.CompanyDetail;
import net.company.dto.CompanyFile;
import net.company.dto.CompanyInvested;
import net.company.dto.CompanyPopularityList;
import net.company.dto.CompanyRegister;
import net.company.dto.CompanyFilePath;
import net.util.Paging;

public class CompanyDAO {

	private static CompanyDAO instance;

	// 3.
	public static CompanyDAO getInstance() {
		if (instance == null)
			instance = new CompanyDAO();
		return instance;
	}

	// 4.
	private Connection conn;
	private static String URL = "jdbc:mysql://52.79.240.236/funbox?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=utf8";
	private static String USERNAME = "damonwin01";
	private static String PASSWORD = "damon123!!";

	ResultSet rs;
	// 2.

	public CompanyDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 또신규씨!!!
	public boolean getCompanyApplicationList(List<CompanyApplication> companyApplicationList, int _page,
			int _search_type, String _search_word, Paging paging) {
		CallableStatement cstmt = null;
		try {
			cstmt = (CallableStatement) conn.prepareCall("CALL SELECT_COMPANY_APPLICATION_LIST(?,?,?,?,?,?,?)");
			cstmt.setInt(1, _page);
			cstmt.setInt(2, _search_type);
			cstmt.setString(3, _search_word);
			cstmt.setInt(4, 10);

			cstmt.registerOutParameter("_current_min_page", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_current_max_page", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_max_page", java.sql.Types.INTEGER);

			rs = cstmt.executeQuery();

			paging.setCurrent_min_page(cstmt.getInt("_current_min_page"));
			paging.setCurrent_max_page(cstmt.getInt("_current_max_page"));
			paging.setMax_page(cstmt.getInt("_max_page"));

			while (rs.next()) {
				CompanyApplication companyApplication = new CompanyApplication();
				companyApplication.setApp_cp_idx(rs.getInt("app_cp_idx"));
				companyApplication.setApp_cp_name(rs.getString("app_cp_name"));
				companyApplication.setMb_id(rs.getString("mb_id"));
				companyApplication.setApp_cp_manager(rs.getString("app_cp_manager"));
				companyApplication.setApp_cp_hp(rs.getString("app_cp_hp"));
				companyApplication.setApp_cp_ch(rs.getString("app_cp_ch"));
				companyApplication.setApp_cp_sector(rs.getString("app_cp_sector"));
				companyApplication.setApp_cp_status(rs.getBoolean("app_cp_status"));
				companyApplication.setApp_cp_open_date_time(rs.getString("app_cp_open_date_time"));
				companyApplication.setApp_deleted_status(rs.getBoolean("app_deleted_status"));
				companyApplicationList.add(companyApplication);
			}
			return true;
		} catch (Exception ex) {
			System.out.println("getCompanyApplicationList ����: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� ����: " + e.getMessage());
			}
		}

		return false;
	}

	// 투자기업목록 List 20190909 윤식 수정
	public boolean getCompanyInvestedList(List<CompanyInvested> companyInvestedList, int _page,
			String _cp_funding_status, Paging paging) {
		CallableStatement cstmt = null;
		try {
			cstmt = (CallableStatement) conn.prepareCall("CALL SELECT_COMPANY_INVESTED_LIST(?,?,?,?,?,?)");
			cstmt.setInt(1, _page);
			cstmt.setString(2, _cp_funding_status);
			cstmt.setInt(3, 10);

			cstmt.registerOutParameter("_current_min_page", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_current_max_page", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_max_page", java.sql.Types.INTEGER);

			rs = cstmt.executeQuery();

			paging.setCurrent_min_page(cstmt.getInt("_current_min_page"));
			paging.setCurrent_max_page(cstmt.getInt("_current_max_page"));
			paging.setMax_page(cstmt.getInt("_max_page"));

			while (rs.next()) {
				CompanyInvested companyInvested = new CompanyInvested();
				companyInvested.setCp_idx(rs.getInt("cp_idx"));
				companyInvested.setCp_name(rs.getString("cp_name"));
				companyInvested.setMb_id(rs.getString("mb_id"));
				companyInvested.setCp_manager(rs.getString("cp_manager"));                                                            
				companyInvested.setCp_phone(rs.getString("cp_phone"));
				companyInvested.setCp_monthly_profit(rs.getString("cp_monthly_profit"));
				companyInvested.setIv_min_amount(rs.getString("iv_min_amount"));
				companyInvested.setIv_goal_amount(rs.getString("iv_goal_amount"));
				companyInvested.setIv_current_amount(rs.getString("iv_current_amount"));
				companyInvested.setMb_id(rs.getString("cp_manager"));
				companyInvested.setMb_id(rs.getString("cp_phone"));
				companyInvested.setCp_funding_status(rs.getString("cp_funding_status"));
				companyInvested.setCp_revenue_distribution_status(rs.getString("cp_revenue_distribution_status"));
				companyInvested.setCp_overdue_status(rs.getString("cp_overdue_status"));
				companyInvested.setD_day(rs.getInt("d_day"));
				companyInvested.setIv_balance_stock(rs.getString("iv_balance_stock"));				
				companyInvested.setResult(rs.getString("result"));
				companyInvestedList.add(companyInvested);
			}
			return true;
		} catch (Exception ex) {
			System.out.println("getCompanyInvestedList 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� ����: " + e.getMessage());
			}
		}

		return false;
	}

	public boolean deleteCompanyApply(int app_cp_idx) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn
					.prepareStatement("UPDATE company_application SET app_deleted_status = true WHERE app_cp_idx = ?");
			pstmt.setInt(1, app_cp_idx);
			pstmt.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println("deleteCompanyApply ����: " + ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� : " + e.getMessage());
			}
		}
		return false;
	}

	public CompanyApplicationDetail getCompanyApplicationDetail(int app_cp_idx) {
		String sql = "SELECT * FROM company_application WHERE app_cp_idx = ?";
		PreparedStatement pstmt = null;
		CompanyApplicationDetail companyApplicationDetail = new CompanyApplicationDetail();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, app_cp_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				companyApplicationDetail.setApp_cp_idx(rs.getInt("app_cp_idx"));
				companyApplicationDetail.setApp_cp_name(rs.getString("app_cp_name"));
				companyApplicationDetail.setMb_id(rs.getString("mb_id"));
				companyApplicationDetail.setApp_cp_manager(rs.getString("app_cp_manager"));
				companyApplicationDetail.setApp_cp_hp(rs.getString("app_cp_hp"));
				companyApplicationDetail.setApp_cp_num(rs.getString("app_cp_num"));
				companyApplicationDetail.setApp_cp_ch(rs.getString("app_cp_ch"));
				companyApplicationDetail.setApp_cp_more(rs.getString("app_cp_more"));
				companyApplicationDetail.setApp_cp_extra(rs.getString("app_cp_extra"));
				companyApplicationDetail.setApp_cp_sector(rs.getString("app_cp_sector"));
				companyApplicationDetail.setApp_cp_status(rs.getBoolean("app_cp_status"));
				companyApplicationDetail.setApp_cp_open_date_time(rs.getString("app_cp_open_date_time"));
				companyApplicationDetail.setApp_cp_prestige(rs.getString("app_cp_prestige"));
				companyApplicationDetail.setApp_cp_deposit(rs.getString("app_cp_deposit"));
				companyApplicationDetail.setApp_cp_monthly(rs.getString("app_cp_monthly"));
				companyApplicationDetail.setApp_cp_goal_amount(rs.getString("app_cp_goal_amount"));
				companyApplicationDetail.setApp_cp_avg_monthly_profit(rs.getString("app_cp_avg_monthly_profit"));
				companyApplicationDetail.setApp_cp_monthly_profit(rs.getString("app_cp_monthly_profit"));
				companyApplicationDetail.setApp_cp_during(rs.getString("app_cp_during"));
				companyApplicationDetail.setApp_cp_inv_min_amount(rs.getString("app_cp_inv_min_amount"));
				companyApplicationDetail.setApp_cp_introduction(rs.getString("app_cp_introduction"));
				companyApplicationDetail.setApp_cp_purpose(rs.getString("app_cp_purpose"));
				companyApplicationDetail.setApp_cp_point(rs.getString("app_cp_point"));
				// 파일

				companyApplicationDetail.setApp_cp_registrantion(rs.getString("app_cp_registrantion"));
				companyApplicationDetail.setApp_cp_financial(rs.getString("app_cp_financial"));
				companyApplicationDetail.setApp_cp_estate_contract(rs.getString("app_cp_estate_contract"));
				companyApplicationDetail.setApp_cp_alias_registrantion(rs.getString("app_cp_alias_registrantion"));
				companyApplicationDetail.setApp_cp_alias_financial(rs.getString("app_cp_alias_financial"));
				companyApplicationDetail.setApp_cp_alias_estate_contract(rs.getString("app_cp_alias_estate_contract"));
				companyApplicationDetail.setApp_cp_image1(rs.getString("app_cp_image1"));
				companyApplicationDetail.setApp_cp_image2(rs.getString("app_cp_image2"));
				companyApplicationDetail.setApp_cp_image3(rs.getString("app_cp_image3"));
				companyApplicationDetail.setApp_cp_image4(rs.getString("app_cp_image4"));
				companyApplicationDetail.setApp_cp_image5(rs.getString("app_cp_image5"));
				companyApplicationDetail.setApp_cp_alias_image1(rs.getString("app_cp_alias_image1"));
				companyApplicationDetail.setApp_cp_alias_image2(rs.getString("app_cp_alias_image2"));
				companyApplicationDetail.setApp_cp_alias_image3(rs.getString("app_cp_alias_image3"));
				companyApplicationDetail.setApp_cp_alias_image4(rs.getString("app_cp_alias_image4"));
				companyApplicationDetail.setApp_cp_alias_image5(rs.getString("app_cp_alias_image5"));
				companyApplicationDetail.setApp_cp_other_document1(rs.getString("app_cp_other_document1"));
				companyApplicationDetail.setApp_cp_other_document2(rs.getString("app_cp_other_document2"));
				companyApplicationDetail.setApp_cp_other_document3(rs.getString("app_cp_other_document3"));
				companyApplicationDetail.setApp_cp_other_document4(rs.getString("app_cp_other_document4"));
				companyApplicationDetail.setApp_cp_other_document5(rs.getString("app_cp_other_document5"));
				companyApplicationDetail.setApp_cp_alias_other_document1(rs.getString("app_cp_alias_other_document1"));
				companyApplicationDetail.setApp_cp_alias_other_document2(rs.getString("app_cp_alias_other_document2"));
				companyApplicationDetail.setApp_cp_alias_other_document3(rs.getString("app_cp_alias_other_document3"));
				companyApplicationDetail.setApp_cp_alias_other_document4(rs.getString("app_cp_alias_other_document4"));
				companyApplicationDetail.setApp_cp_alias_other_document5(rs.getString("app_cp_alias_other_document5"));
			}
		} catch (Exception ex) {
			System.out.println("CompanyApplicationDetail error: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("CompanyApplicationDetail 연결 해제 실패: " + e.getMessage());
			}
		}
		return companyApplicationDetail;
	}

	// 전체목록 들고오기
	public boolean getCompanyAllList(List<Company> companyList, int _search_type, String _search_word) {
		CallableStatement cstmt = null;
		try {
			cstmt = (CallableStatement) conn.prepareCall("CALL SELECT_COMPANY_LIST(?,?)");
			cstmt.setInt(1, _search_type);
			cstmt.setString(2, _search_word);

			rs = cstmt.executeQuery();

			while (rs.next()) {
				Company company = new Company();
				company.setCp_idx(rs.getInt("cp_idx"));
				company.setCp_name(rs.getString("cp_name"));
				company.setMb_id(rs.getString("mb_id"));
				company.setCp_manager(rs.getString("cp_manager"));
				companyList.add(company);
			}
			return true;
		} catch (Exception ex) {
			System.out.println("getCompanyAllList Error: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� ����: " + e.getMessage());
			}
		}

		return false;
	}

	// 전체목록 들고오기
	public boolean getCompanyAllList(List<Company> companyList, boolean _search_type, String _search_word,
			int _category) {
		String sql = "";
		switch (_category) {
		case 1:
			sql = "SELECT cp_idx,cp_name,mb_id,cp_manager FROM company WHERE cp_idx NOT IN(SELECT cp_idx FROM popularityManagement_list)";
			break;
		case 2:
			sql = "SELECT cp_idx,cp_name,mb_id,cp_manager FROM company WHERE cp_idx NOT IN(SELECT cp_idx FROM recommended_company)";
			break;
		case 3:
			sql = "SELECT cp_idx,cp_name,mb_id,cp_manager FROM company WHERE cp_idx NOT IN(SELECT cp_idx FROM admin_deadLine)";
			break;

		case 4:
			sql = "SELECT cp_idx,cp_name,mb_id,cp_manager FROM company WHERE cp_idx NOT IN(SELECT cp_idx FROM am_banner_1)";
			break;

		case 5:
			sql = "SELECT cp_idx,cp_name,mb_id,cp_manager FROM company WHERE cp_idx NOT IN(SELECT cp_idx FROM am_banner_2)";
			break;

		default:
			break;
		}
		if (_search_type) {
			sql += "AND cp_name LIKE  CONCAT('%',?,'%')";
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			if (_search_type) {
				pstmt.setString(1, _search_word);
			}
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Company company = new Company();
				company.setCp_idx(rs.getInt("cp_idx"));
				company.setCp_name(rs.getString("cp_name"));
				company.setMb_id(rs.getString("mb_id"));
				company.setCp_manager(rs.getString("cp_manager"));
				companyList.add(company);
			}
			return true;

		} catch (Exception ex) {
			System.out.println("getCompanyAllList 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return false;
	}

	// 해당 페이지 수동 테이블 들고오기
	public boolean getCompanyAddedList(List<CompanyAdded> companyAddedList, int _category) {
		String sql = "";
		switch (_category) {
		case 1:
			sql = "SELECT cp_idx,cp_name,mb_id,cp_manager FROM company cp WHERE cp_idx IN(SELECT cp_idx FROM popularityManagement_list)";
			break;
		case 2:
			sql = "SELECT cp_idx,cp_name,mb_id,cp_manager FROM company cp WHERE cp_idx IN(SELECT cp_idx FROM recommended_company)";
			break;
		case 3:
			sql = "SELECT cp_idx,cp_name,mb_id,cp_manager FROM company cp WHERE cp_idx IN(SELECT cp_idx FROM admin_deadLine)";
			break;
		case 4:
			sql = "SELECT cp_idx,cp_name,mb_id,cp_manager FROM company cp WHERE cp_idx IN(SELECT cp_idx FROM am_banner_1)";
			break;

		case 5:
			sql = "SELECT cp_idx,cp_name,mb_id,cp_manager FROM company cp WHERE cp_idx IN(SELECT cp_idx FROM am_banner_2)";
			break;

		default:
			break;
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CompanyAdded companyAdded = new CompanyAdded();
				companyAdded.setCp_idx(rs.getInt("cp_idx"));
				companyAdded.setCp_name(rs.getString("cp_name"));
				companyAdded.setMb_id(rs.getString("mb_id"));
				companyAdded.setCp_manager(rs.getString("cp_manager"));
				companyAddedList.add(companyAdded);
			}

			return true;

		} catch (Exception ex) {
			System.out.println("getCompanyAddedList 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return false;
	}

	// 자동 수동 상태 들고오기 // 박신규 추가
	public boolean getAutoStatus(int aas_idx) {
		String sql = "SELECT aas_auto_status FROM admin_am_setting WHERE aas_idx = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, aas_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getBoolean("aas_auto_status");
			}
		} catch (Exception ex) {
			System.out.println("getAutoStatus 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return true;
	}

	// 자동 수동 상태 들고오기 // 박신규 추가
	public boolean getCompanyFile(int cp_idx, CompanyFile companyFile) {
		String sql = "SELECT * FROM company_file WHERE cp_idx = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cp_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				companyFile.setCp_idx(rs.getInt("cp_idx"));
				companyFile.setCf_store_images(rs.getString("cf_store_images"));
				companyFile.setCf_alias_store_images(rs.getString("cf_alias_store_images"));
				companyFile.setCf_corporation_icon(rs.getString("cf_corporation_icon"));
				companyFile.setCf_alias_corporation_icon(rs.getString("cf_alias_corporation_icon"));
				companyFile.setCf_invest_image(rs.getString("cf_invest_image"));
				companyFile.setCf_alias_invest_image(rs.getString("cf_alias_invest_image"));
				companyFile.setCf_folder(rs.getString("cf_folder"));
				companyFile.setCf_business_plan_images(rs.getString("cf_business_plan_images"));
				companyFile.setCf_alias_business_plan_images(rs.getString("cf_alias_business_plan_images"));
				companyFile.setCf_etc_files(rs.getString("cf_etc_files"));
				companyFile.setCf_alias_etc_files(rs.getString("cf_alias_etc_files"));
				companyFile.setCf_thumbnail(rs.getString("cf_thumbnail"));
				companyFile.setCf_alias_thumbnail(rs.getString("cf_alias_thumbnail"));
				companyFile.setCf_pr_background(rs.getString("cf_pr_background"));
				companyFile.setCf_alias_pr_background(rs.getString("cf_alias_pr_background"));
				companyFile.setCf_funding_contract(rs.getString("cf_funding_contract"));
				companyFile.setCf_alias_funding_contract(rs.getString("cf_alias_funding_contract"));
				companyFile.setCf_business_plan(rs.getString("cf_business_plan"));
				companyFile.setCf_alias_business_plan(rs.getString("cf_alias_business_plan"));
			}
			return true;
		} catch (Exception ex) {
			System.out.println("getAutoStatus 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return true;
	}

	public boolean deleteManualTable(int aas_idx) {
		String sql = "";
		switch (aas_idx) {
		case 1:
			sql = "DELETE FROM popularityManagement_list";
			break;
		case 2:
			sql = "DELETE FROM recommended_company";
			break;
		case 3:
			sql = "DELETE FROM admin_deadLine";
			break;

		case 4:
			sql = "DELETE FROM am_banner_1";
			break;

		case 5:
			sql = "DELETE FROM am_banner_2";
			break;

		default:
			break;
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			return true;

		} catch (Exception ex) {
			System.out.println("deleteManualTable 에러: " + ex);

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}
		return false;
	}

	public boolean insertManualTable(int aas_idx, Integer[] cp_idx_value_arr) {
		String sql = "";
		switch (aas_idx) {
		case 1:
			sql = "";
			break;
		case 2:
			sql = "INSERT INTO recommended_company SELECT cp.cp_idx, cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_appl_stop_date_time, cp.cp_recommand_count FROM company as cp JOIN company_invest as cp_iv ON cp.cp_idx = cp_iv.cp_idx JOIN company_file as cp_f ON cp.cp_idx = cp_f.cp_idx WHERE cp.cp_idx IN (";
			break;
		case 3:
			sql = "";
			break;

		case 4:
			sql = "INSERT INTO am_banner_1 SELECT cp.cp_idx,cp.cp_name,cp.cp_branch,cp.cp_intro_content FROM company cp JOIN company_file cp_f ON cp.cp_idx = cp_f.cp_idx WHERE cp.cp_idx IN(";
			break;

		case 5:
			sql = "INSERT INTO am_banner_2 SELECT cp.cp_idx,cp.cp_name,cp.cp_branch,cp.cp_intro_content,cp.cp_open_datetime FROM company cp JOIN company_file cp_f ON cp.cp_idx = cp_f.cp_idx WHERE cp.cp_idx IN(";
			break;

		default:
			break;
		}
		for (int i = 0; i < cp_idx_value_arr.length; i++) {
			if (i + 1 == cp_idx_value_arr.length) {
				sql += "?)";
			} else {
				sql += "?,";
			}
		}
		System.out.println(sql);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < cp_idx_value_arr.length; i++) {
				pstmt.setInt(i + 1, cp_idx_value_arr[i]);
			}
			pstmt.executeUpdate();
			return true;

		} catch (Exception ex) {
			System.out.println("insertManualTable 에러: " + ex);

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}
		return false;
	}

	// 마감 임박 클라이언트 수동 List 값 가져 오기(수동) 윤식 추가
	public ArrayList<CompanyDeadLine> getMan3List() {

		String sql = "select " + "cp_idx, " + "mb_id, " + "cp_name, " + "cp_manager " + "from admin_deadLine ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<CompanyDeadLine> companydeadline = new ArrayList<CompanyDeadLine>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CompanyDeadLine deadlineList = new CompanyDeadLine();
				deadlineList.setCp_idx(rs.getInt("cp_idx"));
				deadlineList.setMb_id(rs.getString("mb_id"));
				deadlineList.setCp_name(rs.getString("cp_name"));
				deadlineList.setCp_manager(rs.getString("cp_manager"));

				companydeadline.add(deadlineList);
			}
			System.out.println(companydeadline.toString());

			return companydeadline;

		} catch (Exception ex) {
			System.out.println("getMan3List에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return null;
	}

	// admin_am_setting update 자동 수동
	public boolean setAutoStatus(int aas_idx, boolean auto_status) {

		String sql = "UPDATE admin_am_setting SET aas_auto_status =" + auto_status + " WHERE aas_idx = " + aas_idx;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();

			return true;

		} catch (Exception ex) {
			System.out.println("setAutoStatus 에러: " + ex);

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return false;
	}

	// 테이블 비우기
	public boolean deletetalbe() {
		String sql = "DELETE FROM admin_deadLine";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
			System.out.println("테이블 비우기 성공");
			return true;

		} catch (Exception ex) {
			System.out.println("deletetalbe 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return false;
	}

	// 자동 수동 체크값 가져오기
	public int auto_mancheck() {
		String sql = "SELECT aas_auto_status from admin_am_setting WHERE aas_idx = 3";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int aas_auto_status = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				aas_auto_status = rs.getInt("aas_auto_status");
			}

			return aas_auto_status;

		} catch (Exception ex) {
			System.out.println("deletetalbe 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return aas_auto_status;
	}

	// 마감임박 admin_deadLine 테이블에 insert
	public boolean insertAutoManDeadLineList(String radioVal, String id) {

		String sql = "INSERT INTO admin_deadLine("
				+ "cp_idx, mb_id, cp_manager, cp_monthly_profit, cp_sector, cp_name, cp_branch, "
				+ "iv_goal_amount, appl_stop_date_time, persent) "
				+ "select cp.cp_idx, mb.mb_id, cp.cp_manager, cp.cp_monthly_profit, cp.cp_sector, cp.cp_name, cp.cp_branch, cp_i.iv_goal_amount, cp_i.iv_appl_stop_date_time, "
				+ "round((iv_current_amount/iv_goal_amount)*100) as persent "
				+ "from company cp, company_file cp_f, company_invest cp_i, member mb " + "where cp.cp_idx ='" + id
				+ "' " + "AND cp_i.cp_idx ='" + id + "' " + "AND cp_f.cp_idx ='" + id + "' "
				+ "AND cp.mb_id = mb.mb_id ";

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("radioVal: " + radioVal);
		System.out.println("id: " + id);

		try {
			if (radioVal.equals("0")) {
				pstmt = conn.prepareStatement(sql);
				result = pstmt.executeUpdate();

				if (result != 0) {
					return true;
				}

			} else if (radioVal.equals("1")) { // 자동
				sql = "INSERT INTO admin_deadLine("
						+ "cp_idx, mb_id, cp_manager, cp_monthly_profit, cp_sector, cp_name, cp_branch, "
						+ "iv_goal_amount, appl_stop_date_time, persent) "
						+ "SELECT cp.cp_idx, mb.mb_id, cp.cp_manager, cp.cp_monthly_profit,  cp.cp_sector,  cp.cp_name,  cp.cp_branch,  cp_iv.iv_goal_amount, cp_iv.iv_appl_stop_date_time, " 
						+ "round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as persent " 
						+ "FROM company cp JOIN company_file cf ON cp.cp_idx = cf.cp_idx " 
						+ "JOIN company_invest cp_iv ON cp.cp_idx = cp_iv.cp_idx " 
						+ "JOIN member mb ON cp.mb_id = mb.mb_id "   
						+ "ORDER BY cp_iv.iv_appl_stop_date_time LIMIT 3 ";

				pstmt = conn.prepareStatement(sql);
				result = pstmt.executeUpdate();

				if (result != 0) {
					return true;
				}
			}

		} catch (Exception ex) {
			System.out.println("insertAutoManDeadLineList 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return false;

	}

	///////////////////////////////// 태훈시작//////////////////////////////////////////////
	// 실시간 수동 목록 가져오기 ajax 버전
	@SuppressWarnings({ "unchecked", "unused" })
	public JSONArray getCompanyPopularityList() {
		String sql = "SELECT cp_idx, cp_name, manager_name, member_id " + "FROM popularityManagement_list ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray jsonArr = new JSONArray();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("cp_idx", rs.getInt("cp_idx"));
				jsonObj.put("cp_name", rs.getString("cp_name"));
				jsonObj.put("manager_name", rs.getString("manager_name"));
				jsonObj.put("member_id", rs.getString("member_id"));

				jsonArr.add(jsonObj);
			}
			return jsonArr;
		} catch (Exception ex) {
			System.out.println("getCompanyPopularityList ajax 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return null;
	}

	// 실시간 수동 데이터 가져오기 c태그
	public List<CompanyPopularityList> getCompanyPopularityInfo() {
		String sql = "SELECT cp_idx, cp_name, manager_name, member_id " + "FROM popularityManagement_list "
				+ "ORDER BY popu_idx ASC";
		List<CompanyPopularityList> popuList = new ArrayList<CompanyPopularityList>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				CompanyPopularityList popuVO = new CompanyPopularityList();
				popuVO.setCp_idx(rs.getInt("cp_idx"));
				popuVO.setCp_name(rs.getString("cp_name"));
				popuVO.setManager_name(rs.getString("manager_name"));
				popuVO.setMember_id(rs.getString("member_id"));

				popuList.add(popuVO);
			}
			return popuList;
		} catch (Exception ex) {
			System.out.println("getCompanyPopularityList ctag 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return null;
	}

	// 실시간 수동 데이터 넣기
	public int insertPopularityManagement(List<Integer> cp_idx_list) {
		int result = 0;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			cstmt = (CallableStatement) conn.prepareCall("call POPULARITY(?,?,?,?,?,?,?,?,?,?,?)");

			cstmt.setInt(1, cp_idx_list.get(0));
			cstmt.setInt(2, cp_idx_list.get(1));
			cstmt.setInt(3, cp_idx_list.get(2));
			cstmt.setInt(4, cp_idx_list.get(3));
			cstmt.setInt(5, cp_idx_list.get(4));
			cstmt.setInt(6, cp_idx_list.get(5));
			cstmt.setInt(7, cp_idx_list.get(6));
			cstmt.setInt(8, cp_idx_list.get(7));
			cstmt.setInt(9, cp_idx_list.get(8));
			cstmt.setInt(10, cp_idx_list.get(9));
			cstmt.registerOutParameter(11, java.sql.Types.INTEGER);

			cstmt.execute();
			result = cstmt.getInt("@RESULT");
			if (result == 1) {
				System.out.println("result:::" + result);
				return result;
			} else {
				result = -1;
			}
		} catch (Exception ex) {
			System.out.println("insertPopularityManagement 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}
		return result;
	}

	// 저장될 경로 가져오기
	public Boolean getUploadFilePath(CompanyFilePath companyApplicationFilePath, String companyFolder) {
		String sql = "SELECT CONCAT((SELECT file_path FROM file_path WHERE idx = 2),? ,(SELECT file_path FROM file_path WHERE idx = 3)) AS app_cp_file_path,CONCAT((SELECT file_path FROM file_path WHERE idx = 2), ?,(SELECT file_path FROM file_path WHERE idx = 4)) AS app_cp_image_path";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, companyFolder);
			pstmt.setString(2, companyFolder);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				companyApplicationFilePath.setApp_cp_file_path(rs.getString("app_cp_image_path"));
				companyApplicationFilePath.setApp_cp_image_path(rs.getString("app_cp_file_path"));
				return true;
			}
		} catch (Exception ex) {
			System.out.println("getUploadFilePath 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return false;
	}

	public Boolean getCompanyDetail(CompanyDetail companyDetail, int cp_idx) {
		String sql = "SELECT *,CONCAT((SELECT file_path FROM file_path WHERE idx = 2),cf.cf_folder,(SELECT file_path FROM file_path WHERE idx = 4)) AS company_file_path,CONCAT((SELECT file_path FROM file_path WHERE idx = 2),cf.cf_folder,(SELECT file_path FROM file_path WHERE idx = 3)) AS company_image_path FROM company cp JOIN company_invest cp_iv ON cp.cp_idx = cp_iv.cp_idx JOIN company_content cp_ct ON cp.cp_idx = cp_ct.cp_idx JOIN company_file cf ON cf.cp_idx JOIN company_pay_schedule cp_sh ON cp_sh.cp_idx WHERE cp.cp_idx = ? AND cp.cp_idx = cp_iv.cp_idx AND cp_ct.cp_idx = cp.cp_idx AND cf.cp_idx = cp.cp_idx AND cp_sh.cp_idx = cp.cp_idx";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cp_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				companyDetail.setCp_idx(rs.getInt("cp_idx"));
				companyDetail.setCp_sector(rs.getString("cp_sector"));
				companyDetail.setCp_name(rs.getString("cp_name"));
				companyDetail.setCp_branch(rs.getString("cp_branch"));
				companyDetail.setCp_manager(rs.getString("cp_manager"));
				companyDetail.setCp_number(rs.getString("cp_number"));
				companyDetail.setCp_capital(rs.getString("cp_capital"));
				companyDetail.setCp_address(rs.getString("cp_address"));
				companyDetail.setCp_add_ch(rs.getString("cp_add_ch"));
				companyDetail.setCp_add_more(rs.getString("cp_add_more"));
				companyDetail.setCp_add_num(rs.getString("cp_add_num"));
				companyDetail.setCp_add_extra(rs.getString("cp_add_extra"));
				companyDetail.setCp_monthly_profit(rs.getString("cp_monthly_profit"));
				companyDetail.setCp_reward_main_title(rs.getString("cp_reward_main_title"));
				companyDetail.setCp_reward_sub_title(rs.getString("cp_reward_sub_title"));
				companyDetail.setCp_reward_content(rs.getString("cp_reward_content"));
				companyDetail.setCp_intro_headline(rs.getString("cp_intro_headline"));
				companyDetail.setCp_intro_content(rs.getString("cp_intro_content"));
				// company_invest insert data
				companyDetail.setIv_contraction_during(rs.getString("iv_contraction_during"));
				companyDetail.setIv_min_amount(rs.getString("iv_min_amount"));
				companyDetail.setIv_appl_stock(rs.getString("iv_appl_stock"));
				companyDetail.setIv_goal_amount(rs.getString("iv_goal_amount"));
				companyDetail.setIv_appl_day(rs.getString("iv_appl_day"));
				companyDetail.setPl_year(rs.getString("pl_year"));
				companyDetail.setPl_month(rs.getString("pl_month"));
				companyDetail.setPl_sales(rs.getString("pl_sales"));
				companyDetail.setPl_material(rs.getString("pl_material"));
				companyDetail.setPl_person_pay(rs.getString("pl_person_pay"));
				companyDetail.setPl_rent_building(rs.getString("pl_rent_building"));
				companyDetail.setPl_operating_pay(rs.getString("pl_operating_pay"));
				companyDetail.setPl_net_revenue(rs.getString("pl_net_revenue"));
				companyDetail.setMa_odds_percent(rs.getString("ma_odds_percent"));
				companyDetail.setMa_odds_money(rs.getString("ma_odds_money"));
				companyDetail.setMa_share_percent(rs.getString("ma_share_percent"));
				companyDetail.setMa_share_money(rs.getString("ma_share_money"));
				companyDetail.setMa_platform_pay(rs.getString("ma_platform_pay"));
				companyDetail.setMa_estimated_revenue(rs.getString("ma_estimated_revenue"));
				companyDetail.setMa_monthly_average(rs.getString("ma_monthly_average"));
				// company_content insert data
				companyDetail.setCp_point_title(rs.getString("cp_point_title"));
				companyDetail.setCp_point_content(rs.getString("cp_point_content"));
				companyDetail.setCp_notice_title(rs.getString("cp_notice_title"));
				companyDetail.setCp_notice_content(rs.getString("cp_notice_content"));
				// company_scheduler insert data
				companyDetail.setCp_pay_count(rs.getString("cp_pay_count"));
				companyDetail.setCp_pay_expected_payment_date(rs.getString("cp_pay_expected_payment_date"));
				companyDetail.setCp_pay_principal(rs.getString("cp_pay_principal"));
				companyDetail.setCp_pay_interest_paid(rs.getString("cp_pay_interest_paid"));
				companyDetail.setCp_pay_fees(rs.getString("cp_pay_fees"));
				companyDetail.setCp_pay_actual_payment_amout(rs.getString("cp_pay_actual_payment_amout"));
				companyDetail.setCp_pay_actual_rate_return(rs.getString("cp_pay_actual_rate_return"));
				companyDetail.setCf_store_images(rs.getString("cf_store_images"));
				companyDetail.setCf_alias_store_images(rs.getString("cf_alias_store_images"));

				// 상세페이지 로고//
				companyDetail.setCf_corporation_icon(rs.getString("cf_corporation_icon"));
				companyDetail.setCf_alias_corporation_icon(rs.getString("cf_alias_corporation_icon"));
				// 상세페이지 로고//

				companyDetail.setCf_folder(rs.getString("cf_folder"));
				companyDetail.setCf_business_plan(rs.getString("cf_business_plan"));
				companyDetail.setCf_alias_business_plan(rs.getString("cf_alias_business_plan"));
				companyDetail.setCf_etc_files(rs.getString("cf_etc_files"));
				companyDetail.setCf_alias_etc_files(rs.getString("cf_alias_etc_files"));
				companyDetail.setCf_thumbnail(rs.getString("cf_thumbnail"));
				companyDetail.setCf_alias_thumbnail(rs.getString("cf_alias_thumbnail"));
				companyDetail.setCf_pr_background(rs.getString("cf_pr_background"));
				companyDetail.setCf_alias_pr_background(rs.getString("cf_alias_pr_background"));
				companyDetail.setCf_funding_contract(rs.getString("cf_funding_contract"));
				companyDetail.setCf_alias_funding_contract(rs.getString("cf_alias_funding_contract"));
				companyDetail.setCf_business_plan_images(rs.getString("cf_business_plan_images"));
				companyDetail.setCf_alias_business_plan_images(rs.getString("cf_alias_business_plan_images"));

				companyDetail.setCompany_file_path(rs.getString("company_file_path"));
				companyDetail.setCompany_image_path(rs.getString("company_image_path"));

				companyDetail.setCp_open_datetime(rs.getDate("cp_open_datetime"));
				companyDetail.setIv_appl_start_date_time(rs.getDate("iv_appl_start_date_time"));
				companyDetail.setIv_appl_stop_date_time(rs.getDate("iv_appl_stop_date_time"));

				companyDetail.setMb_id(rs.getString("mb_id"));

				return true;
			}
		} catch (Exception ex) {
			System.out.println("getCompanyDetail 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return false;
	};

	// 태훈추가 - 관리자 페이지 기업등록
	public int ComapnyRegister(CompanyRegister register) {
		int result = 0;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			cstmt = (CallableStatement) conn.prepareCall(
					"call COMPANY_REGISTER(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?    ,?,?,?,?,?,?)");
			// company insert data
			cstmt.setString(1, register.getCp_sector());
			cstmt.setString(2, register.getCp_name());
			cstmt.setString(3, register.getCp_branch());
			cstmt.setString(4, register.getCp_manager());
			cstmt.setString(5, register.getCp_number());
			cstmt.setString(6, register.getCp_capital());
			cstmt.setString(7, register.getCp_address());
			cstmt.setString(8, register.getCp_add_ch());
			cstmt.setString(9, register.getCp_add_more());
			cstmt.setString(10, register.getCp_add_num());
			cstmt.setString(11, register.getCp_monthly_profit());
			cstmt.setString(12, register.getCp_reward_main_title());
			cstmt.setString(13, register.getCp_reward_sub_title());
			cstmt.setString(14, register.getCp_reward_content());
			cstmt.setString(15, register.getCp_intro_headline());
			cstmt.setString(16, register.getCp_intro_content());
			// company_invest insert data
			cstmt.setString(17, register.getIv_contraction_during());
			cstmt.setString(18, register.getIv_min_amount());
			cstmt.setString(19, register.getIv_appl_stock());
			cstmt.setString(20, register.getIv_goal_amount());
			cstmt.setString(21, register.getIv_appl_day());
			cstmt.setString(22, register.getPl_year());
			cstmt.setString(23, register.getPl_month());
			cstmt.setString(24, register.getPl_sales());
			cstmt.setString(25, register.getPl_material());
			cstmt.setString(26, register.getPl_person_pay());
			cstmt.setString(27, register.getPl_rent_building());
			cstmt.setString(28, register.getPl_operating_pay());
			cstmt.setString(29, register.getPl_net_revenue());
			cstmt.setString(30, register.getMa_odds_percent());
			cstmt.setString(31, register.getMa_odds_money());
			cstmt.setString(32, register.getMa_share_percent());
			cstmt.setString(33, register.getMa_share_money());
			cstmt.setString(34, register.getMa_platform_pay());
			cstmt.setString(35, register.getMa_estimated_revenue());
			cstmt.setString(36, register.getMa_monthly_average());
			// company_content insert data
			cstmt.setString(37, register.getPoint_title_string());
			cstmt.setString(38, register.getPoint_content_string());
			cstmt.setString(39, register.getNotice_title_string());
			cstmt.setString(40, register.getNotice_content_string());
			// company_scheduler insert data
			cstmt.setString(41, register.getPay_count_string());
			cstmt.setString(42, register.getPay_payment_date_string());
			cstmt.setString(43, register.getPay_principal_string());
			cstmt.setString(44, register.getPay_interest_string());
			cstmt.setString(45, register.getPay_fees_string());
			cstmt.setString(46, register.getPay_actual_payment_string());
			cstmt.setString(47, register.getPay_actual_rate_string());
			cstmt.setString(48, register.getStore_images());
			cstmt.setString(49, register.getAlias_store_images());
			cstmt.setString(50, register.getCf_info_banner());
			cstmt.setString(51, register.getCf_alias_info_banner());
			cstmt.setString(52, null);
			cstmt.setString(53, null);
			cstmt.setString(54, register.getCf_folder());
			cstmt.setString(55, register.getBusiness_plan());
			cstmt.setString(56, register.getAlias_business_plan());
			cstmt.setString(57, register.getEtc_files());
			cstmt.setString(58, register.getAlias_etc_files());
			cstmt.setString(59, register.getCf_thumbnail());
			cstmt.setString(60, register.getCf_alias_thumbnail());
			cstmt.setString(61, register.getCf_pr_background());
			cstmt.setString(62, register.getCf_alias_pr_background());
			cstmt.setString(63, register.getCf_funding_contract());
			cstmt.setString(64, register.getCf_alias_funding_contract());
			cstmt.setString(65, register.getCf_business_plan());
			cstmt.setString(66, register.getCf_alias_business_plan());

			cstmt.registerOutParameter(67, java.sql.Types.INTEGER);
			// 예상지급 스케줄 합계
			cstmt.setString(68, register.getCp_total_sum_pay_principal());
			cstmt.setString(69, register.getCp_total_sum_pay_interest_paid());
			cstmt.setString(70, register.getCp_total_sum_pay_fees());
			cstmt.setString(71, register.getCp_total_sum_pay_actual_payment_amout());
			cstmt.setString(72, register.getCp_total_sum_actual_rate_return());

			// 2019-09-09
			cstmt.setDate(73, (Date) register.getCp_open_datetime());
			cstmt.setDate(74, (Date) register.getIv_appl_start_date_time());
			cstmt.setDate(75, (Date) register.getIv_appl_stop_date_time());
			cstmt.setString(76, register.getCp_add_extra());
			cstmt.setString(77, register.getMb_id());

			cstmt.execute();
			result = cstmt.getInt("@RESULT");
			if (result == 1) {
				return result;
			} else {
				result = -1;
				System.out.println("Database :: data size check please :)");
			}
		} catch (Exception ex) {
			System.out.println("ComapnyRegister 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}
		return result;
	}

	// 태훈추가 - 관리자 페이지 기업 수정
	public int CompanyUpdate(CompanyDetail detail) {
		int result = 0;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		try {
			cstmt = (CallableStatement) conn.prepareCall("call COMPANY_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			// company insert data
			cstmt.setString(1, detail.getCp_sector());
			cstmt.setString(2, detail.getCp_name());
			cstmt.setString(3, detail.getCp_branch());
			cstmt.setString(4, detail.getCp_manager());
			cstmt.setString(5, detail.getCp_number());
			cstmt.setString(6, detail.getCp_capital());
			cstmt.setString(7, detail.getCp_address());
			cstmt.setString(8, detail.getCp_add_ch());
			cstmt.setString(9, detail.getCp_add_more());
			cstmt.setString(10, detail.getCp_add_num());
			cstmt.setString(11, detail.getCp_monthly_profit());
			cstmt.setString(12, detail.getCp_reward_main_title());
			cstmt.setString(13, detail.getCp_reward_sub_title());
			cstmt.setString(14, detail.getCp_reward_content());
			cstmt.setString(15, detail.getCp_intro_headline());
			cstmt.setString(16, detail.getCp_intro_content());
			// company_invest insert data
			cstmt.setString(17, detail.getIv_contraction_during());
			cstmt.setString(18, detail.getIv_min_amount());
			cstmt.setString(19, detail.getIv_appl_stock());
			cstmt.setString(20, detail.getIv_goal_amount());

			// 수정해야함
			cstmt.setString(21, "수정해야해");

			cstmt.setString(22, detail.getPl_year());
			cstmt.setString(23, detail.getPl_month());
			cstmt.setString(24, detail.getPl_sales());
			cstmt.setString(25, detail.getPl_material());
			cstmt.setString(26, detail.getPl_person_pay());
			cstmt.setString(27, detail.getPl_rent_building());
			cstmt.setString(28, detail.getPl_operating_pay());
			cstmt.setString(29, detail.getPl_net_revenue());
			cstmt.setString(30, detail.getMa_odds_percent());
			cstmt.setString(31, detail.getMa_odds_money());
			cstmt.setString(32, detail.getMa_share_percent());
			cstmt.setString(33, detail.getMa_share_money());
			cstmt.setString(34, detail.getMa_platform_pay());
			cstmt.setString(35, detail.getMa_estimated_revenue());
			cstmt.setString(36, detail.getMa_monthly_average());
			// company_content insert data
			cstmt.setString(37, detail.getCp_pay_count());
			cstmt.setString(38, detail.getCp_pay_expected_payment_date());
			cstmt.setString(39, detail.getCp_pay_principal());
			cstmt.setString(40, detail.getCp_pay_interest_paid());
			cstmt.setString(41, detail.getCp_pay_fees());
			cstmt.setString(42, detail.getCp_pay_actual_payment_amout());
			cstmt.setString(43, detail.getCp_pay_actual_rate_return());
			cstmt.setString(44, detail.getCp_point_title());
			cstmt.setString(45, detail.getCp_point_content());
			cstmt.setString(46, detail.getCp_notice_title());
			cstmt.setString(47, detail.getCp_notice_content());
			cstmt.setInt(48, detail.getCp_idx());
			cstmt.registerOutParameter(49, java.sql.Types.INTEGER);

			// 파일
			cstmt.setString(50, detail.getCf_thumbnail());
			cstmt.setString(51, detail.getCf_pr_background());
			cstmt.setString(52, detail.getCf_store_images());
			cstmt.setString(53, detail.getCf_business_plan_images());
			cstmt.setString(54, detail.getCf_etc_files());
			cstmt.setString(55, detail.getCf_alias_store_images());
			cstmt.setString(56, detail.getCf_alias_business_plan_images());
			cstmt.setString(57, detail.getCf_alias_etc_files());
			cstmt.setString(58, detail.getCf_business_plan());
			cstmt.setString(59, detail.getCf_alias_business_plan());

			cstmt.setDate(60, detail.getCp_open_datetime());
			cstmt.setDate(61, detail.getIv_appl_start_date_time());
			cstmt.setDate(62, detail.getIv_appl_stop_date_time());
			
			cstmt.setString(63, detail.getCp_add_extra());
			
			
			
			cstmt.execute();
			result = cstmt.getInt("@RESULT");
			if (result == 1) {
				return result;
			} else {
				result = -1;
				System.out.println("Database :: data size check please :)");
			}
		} catch (Exception ex) {
			System.out.println("CompanyUpdate 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstmt != null)
					cstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}
		return result;
	}

	///////////////////////////////// 태훈끝//////////////////////////////////////////////

	public String getFileDirectory(int cp_idx, int kindOfFile) {
		String sql = "";

		switch (kindOfFile) {
		case 1:
			// Client Company File File
			sql = "SELECT CONCAT((SELECT file_path FROM file_path WHERE idx = 2), (SELECT cf_folder FROM company_file WHERE cp_idx = ?),(SELECT file_path FROM file_path WHERE idx = 4)) AS company_file_folder";
			break;
		case 2:
			// Client Company File Image
			sql = "SELECT CONCAT((SELECT file_path FROM file_path WHERE idx = 2), (SELECT cf_folder FROM company_file WHERE cp_idx = ?),(SELECT file_path FROM file_path WHERE idx = 3)) AS company_image_folder";
			break;
		case 3:
			// Client Company application File
			sql = "SELECT CONCAT((SELECT file_path FROM file_path WHERE idx = 1), (SELECT app_cp_folder FROM company_application WHERE app_cp_idx = ?),(SELECT file_path FROM file_path WHERE idx = 4)) AS company_file_folder";
			break;
		case 4:
			// Client Company application Image
			sql = "SELECT CONCAT((SELECT file_path FROM file_path WHERE idx = 1), (SELECT app_cp_folder FROM company_application WHERE app_cp_idx = ?),(SELECT file_path FROM file_path WHERE idx = 3)) AS company_image_folder";
			break;
		default:
			break;
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cp_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				switch (kindOfFile) {
				case 1:
					return rs.getString("company_file_folder");
				case 2:
					return rs.getString("company_image_folder");
				case 3:
					return rs.getString("company_file_folder");
				case 4:
					return rs.getString("company_image_folder");
				default:
					break;
				}

			}
		} catch (Exception ex) {
			System.out.println("getUploadFilePath 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("해제 실패 : " + e.getMessage());
			}
		}

		return null;
	}
	
	public boolean statesSave(String fund_state, String give_state, String arrears_state, String cp_idx) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("UPDATE company SET cp_funding_status = ?, cp_revenue_distribution_status = ?, cp_overdue_status = ? WHERE cp_idx = ?");
			pstmt.setString(1, fund_state);
			pstmt.setString(2, give_state);
			pstmt.setString(3, arrears_state);
			pstmt.setString(4, cp_idx);
			pstmt.executeUpdate();
			return true;
		} catch (Exception ex) {
			System.out.println("statesSave error: " + ex);
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� : " + e.getMessage());
			}
		}
		return false;
	}


	// 투자하기 - 모든 기업 정보 불러오기
	// 태훈 - 투자하기 필요한 정보 JOIN활용 불러오기
	public CompanyBean getCompanyInfo2(int idx) throws Exception {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		CompanyBean company = null;

		try {
			// 쿼리
			String sql = "SELECT *,(iv_current_amount/iv_goal_amount*100) AS iv_percent, CONCAT((SELECT file_path FROM file_path WHERE idx = 2),cf.cf_folder,(SELECT file_path FROM file_path WHERE idx = 4)) AS company_file_path ,CONCAT((SELECT file_path FROM file_path WHERE idx = 7),cf.cf_folder,(SELECT file_path FROM file_path WHERE idx = 3)) AS company_image_path ,(SELECT fees_percent FROM fees_setting WHERE fees_idx =1) AS fees_percent, DATEDIFF(cp_iv.iv_appl_stop_date_time,now()) AS by_end_date  FROM company cp JOIN company_invest cp_iv ON cp.cp_idx = cp_iv.cp_idx JOIN company_pay_schedule cp_pay ON cp.cp_idx = cp_pay.cp_idx JOIN company_file cf ON cp.cp_idx = cf.cp_idx JOIN company_content cp_ct ON cp.cp_idx = cp_ct.cp_idx WHERE cp.cp_idx = ? AND cp_iv.cp_idx = cp.cp_idx AND cp_pay.cp_idx = cp.cp_idx AND cf.cp_idx = cp.cp_idx AND cp.cp_idx = cp_ct.cp_idx";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idx);
			rs = pstm.executeQuery();

			if (rs.next()) { // 회원정보를 DTO에 담는다.

				// CompanyVO
				company = new CompanyBean();
				company.setCp_idx(rs.getInt("cp_idx"));
				company.setCp_name(rs.getString("cp_name"));
				company.setCp_number(rs.getString("cp_number"));
				company.setCp_manager(rs.getString("cp_manager"));
				company.setCp_phone(rs.getString("cp_phone"));
				company.setCp_sector(rs.getString("cp_sector"));
				company.setCp_add_num(rs.getString("cp_add_num"));
				company.setCp_add_ch(rs.getString("cp_add_ch"));
				company.setCp_add_more(rs.getString("cp_add_more"));
				company.setCp_branch(rs.getString("cp_branch"));
				company.setCp_intro_headline(rs.getString("cp_intro_headline"));
				company.setCp_lat(rs.getString("cp_lat"));
				company.setCp_lng(rs.getString("cp_lng"));
				company.setCp_add_extra(rs.getString("cp_add_extra"));
				company.setCp_capital(rs.getString("cp_capital"));
				company.setCp_open_datetime(rs.getDate("cp_open_datetime"));
				company.setCp_avg_monthly_sales(rs.getString("cp_avg_monthly_sales"));
				company.setCp_monthly_profit(rs.getString("cp_monthly_profit"));
				company.setCp_reg_datetime(rs.getDate("cp_reg_datetime"));
				company.setCp_exit_datetime(rs.getDate("cp_exit_datetime"));
				company.setCp_intro_content(rs.getString("cp_intro_content"));
				company.setCp_purpose(rs.getString("cp_purpose"));
				//company.setCp_point_comment(rs.getString("cp_point_comment"));
				company.setCp_update_datetime(rs.getDate("cp_update_datetime"));
				company.setCp_business_risk(rs.getString("cp_business_risk"));
				company.setCp_company_risk(rs.getString("cp_company_risk"));
				company.setCp_other_risks(rs.getString("cp_other_risks"));
				company.setCp_recommand(rs.getBoolean("cp_recommand"));
				company.setCp_best(rs.getBoolean("cp_best"));

				// InvestVO
				// 태훈 추가 - 투자율
				company.setIv_percent(rs.getString("iv_percent"));
				company.setIv_goal_amount(rs.getString("iv_goal_amount"));
				company.setIv_current_amount(rs.getString("iv_current_amount"));
				company.setIv_min_amount(rs.getString("iv_min_amount"));
				company.setIv_balance_stock(rs.getString("iv_balance_stock"));
				company.setIv_appl_stock(rs.getString("iv_appl_stock"));
				company.setIv_appl_start_date_time(rs.getDate("iv_appl_start_date_time"));
				company.setIv_appl_stop_date_time(rs.getDate("iv_appl_stop_date_time"));
				company.setIv_contraction_during(rs.getString("iv_contraction_during"));
				company.setIv_possible_amount(rs.getString("iv_possible_amount"));
				company.setIv_current_participants(rs.getString("iv_current_participants"));

				// Company_pay_scheduleVO
				company.setCp_pay_count(rs.getString("cp_pay_count"));
				company.setCp_pay_expected_payment_date(rs.getString("cp_pay_expected_payment_date"));
				company.setCp_pay_principal(rs.getString("cp_pay_principal"));
				company.setCp_pay_interest_paid(rs.getString("cp_pay_interest_paid"));
				company.setCp_pay_fees(rs.getString("cp_pay_fees"));
				company.setCp_pay_actual_payment_amout(rs.getString("cp_pay_actual_payment_amout"));
				company.setCp_pay_actual_rate_return(rs.getString("cp_pay_actual_rate_return"));

				// Company_revenueVO
				/*company.setCp_pre_sales(rs.getInt("cp_pre_sales"));
				company.setCp_pre_stuff(rs.getInt("cp_pre_stuff"));
				company.setCp_pre_costs_person(rs.getInt("cp_pre_costs_person"));
				company.setCp_pre_lease_expenses(rs.getInt("cp_pre_lease_expenses"));
				company.setCp_pre_operating_expenses(rs.getInt("cp_pre_operating_expenses"));
				company.setCp_pre_net_income(rs.getInt("cp_pre_net_income"));
				company.setCp_pre_cash_dividend_ratio(rs.getInt("cp_pre_cash_dividend_ratio"));
				company.setCp_pre_share(rs.getInt("cp_pre_share"));
				company.setCp_pre_platform(rs.getInt("cp_pre_platform"));
				company.setCp_pre_proceeds(rs.getInt("cp_pre_proceeds"));
				company.setCp_pre_avg_monthly(rs.getInt("cp_pre_avg_monthly"));
				company.setCp_pre_net_profit_ratio(rs.getInt("cp_pre_net_profit_ratio"));
				company.setCp_pre_interest_rate(rs.getInt("cp_pre_interest_rate"));
				*/
				// CompanyFileVO
				company.setCf_store_images(rs.getString("cf_store_images"));
				company.setCf_alias_store_images(rs.getString("cf_alias_store_images"));
				company.setCf_corporation_icon(rs.getString("cf_corporation_icon"));
				company.setCf_alias_corporation_icon(rs.getString("cf_alias_corporation_icon"));
				company.setCf_invest_image(rs.getString("cf_invest_image"));
				company.setCf_alias_invest_image(rs.getString("cf_alias_invest_image"));
				company.setCf_folder(rs.getString("cf_folder"));
				company.setCf_business_plan_images(rs.getString("cf_business_plan_images"));
				company.setCf_alias_business_plan_images(rs.getString("cf_alias_business_plan_images"));
				company.setCf_etc_files(rs.getString("cf_etc_files"));
				company.setCf_alias_etc_files(rs.getString("cf_alias_etc_files"));
				company.setCf_thumbnail(rs.getString("cf_thumbnail"));
				company.setCf_alias_thumbnail(rs.getString("cf_alias_thumbnail"));
				company.setCf_pr_background(rs.getString("cf_pr_background"));
				company.setCf_alias_pr_background(rs.getString("cf_alias_pr_background"));
				company.setCf_funding_contract(rs.getString("cf_funding_contract"));
				company.setCf_alias_funding_contract(rs.getString("cf_alias_funding_contract"));
				company.setCf_business_plan(rs.getString("cf_business_plan"));
				company.setCf_alias_business_plan(rs.getString("cf_alias_business_plan"));
				
				//파일 경로들
				company.setCompany_file_path(rs.getString("company_file_path"));
				company.setCompany_image_path(rs.getString("company_image_path"));

				//CompanyBean
				company.setCp_reward_main_title(rs.getString("cp_reward_main_title"));
				company.setCp_reward_sub_title(rs.getString("cp_reward_sub_title"));
				company.setCp_reward_content(rs.getString("cp_reward_content"));
				company.setCp_intro_headline(rs.getString("cp_intro_headline"));
				company.setCp_intro_content(rs.getString("cp_intro_content"));
				
				company.setPl_year(rs.getString("pl_year"));
				company.setPl_month(rs.getString("pl_month"));
				company.setPl_sales(rs.getString("pl_sales"));
				company.setPl_material(rs.getString("pl_material"));
				company.setPl_person_pay(rs.getString("pl_person_pay"));
				company.setPl_rent_building(rs.getString("pl_rent_building"));
				company.setPl_operating_pay(rs.getString("pl_operating_pay"));
				company.setPl_net_revenue(rs.getString("pl_net_revenue"));
				company.setCp_total_sum_pay_principal(rs.getString("cp_total_sum_pay_principal"));
				company.setCp_total_sum_pay_interest_paid(rs.getString("cp_total_sum_pay_interest_paid"));
				company.setCp_total_sum_pay_fees(rs.getString("cp_total_sum_pay_fees"));
				company.setCp_total_sum_pay_actual_payment_amout(rs.getString("cp_total_sum_pay_actual_payment_amout"));
				company.setCp_total_sum_actual_rate_return(rs.getString("cp_total_sum_actual_rate_return"));
				
				
				//copanycontent
				company.setCp_notice_title(rs.getString("cp_notice_title"));
				company.setCp_notice_content(rs.getString("cp_notice_content"));
				company.setCp_point_title(rs.getString("cp_point_title"));
				company.setCp_point_content(rs.getString("cp_point_content"));
				
				//유정이 친해지고 싶다....
				company.setMa_odds_percent(rs.getString("ma_odds_percent"));
				company.setMa_odds_money(rs.getString("ma_odds_money"));
				company.setMa_share_percent(rs.getString("ma_share_percent"));
				company.setMa_share_money(rs.getString("ma_share_money"));
				company.setMa_platform_pay(rs.getString("ma_platform_pay"));
				company.setMa_estimated_revenue(rs.getString("ma_estimated_revenue"));
				company.setMa_monthly_average(rs.getString("ma_monthly_average"));
				
				//fees setting
				company.setFees_percent(rs.getString("fees_percent"));
				
				//투자 마감일까지 남은 일수
				company.setBy_end_date(rs.getString("by_end_date"));
			}
			return company;

		} catch (Exception ex) {
			System.out.println("getCompanyInfo2 에러: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return null;
	}
}
