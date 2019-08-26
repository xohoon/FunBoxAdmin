package net.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



import com.mysql.jdbc.CallableStatement;
//import com.mysql.cj.jdbc.CallableStatement;

import net.company.dto.Company;
import net.company.dto.CompanyAdded;
import net.company.dto.CompanyApplication;
import net.company.dto.CompanyApplicationDetail;
import net.company.dto.CompanyDeadLine;
import net.company.dto.CompanyInvested;
import net.company.dto.CompanyPopularityList;
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

	// �����û�� ����Ʈ
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

	// ��� ���� ��� ����Ʈ
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
				companyInvested.setCp_name(rs.getString("cp_name"));
				companyInvested.setMb_id(rs.getString("mb_id"));
				companyInvested.setMb_id(rs.getString("cp_manager"));
				companyInvested.setMb_id(rs.getString("cp_phone"));
				companyInvested.setCp_pre_net_profit_ratio(rs.getInt("cp_pre_net_profit_ratio"));
				companyInvested.setD_day(rs.getInt("d_day"));
				companyInvested.setMb_id(rs.getString("iv_balance_stock"));
				companyInvestedList.add(companyInvested);
			}
			return true;
		} catch (Exception ex) {
			System.out.println("getCompanyInvestedList ����: " + ex);
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
				companyApplicationDetail.setApp_cp_name(rs.getString("app_cp_name"));
				companyApplicationDetail.setMb_id(rs.getString("mb_id"));
				companyApplicationDetail.setApp_cp_manager(rs.getString("app_cp_manager"));
				companyApplicationDetail.setApp_cp_hp(rs.getString("app_cp_hp"));
				companyApplicationDetail.setApp_cp_num(rs.getString("mb_add_num"));
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
			}
		} catch (Exception ex) {
			System.out.println("getMember ����: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� ����: " + e.getMessage());
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
	public boolean getCompanyAllList(List<Company> companyList,boolean _search_type, String _search_word, int _category) {
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
	
	//해당 페이지 수동 테이블 들고오기
	public boolean getCompanyAddedList(List<CompanyAdded> companyAddedList,int _category) {
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
	
	public boolean insertManualTable(int aas_idx,Integer[] cp_idx_value_arr) {
		String sql = "";
		switch (aas_idx) {
			case 1:
				sql = "";
				break;
			case 2:
				sql = "INSERT INTO recommended_company SELECT cp.cp_idx, cp.cp_name, cp.cp_sector, cp.cp_branch, cp.cp_monthly_profit, round((cp_iv.iv_current_amount/cp_iv.iv_goal_amount*100)) as percent, cp_iv.iv_goal_amount, cp_iv.iv_current_amount, cp_iv.iv_appl_stop_date_time, concat(cp_f.cf_directory,cp_f.cf_image1) as thumbnail_image, cp.cp_recommand_count FROM company as cp JOIN company_invest as cp_iv ON cp.cp_idx = cp_iv.cp_idx JOIN company_file as cp_f ON cp.cp_idx = cp_f.cp_idx WHERE cp.cp_idx IN (";
				break;
			case 3:
				sql = "";
				break;			
	
			case 4:
				sql = "INSERT INTO am_banner_1 SELECT cp.cp_idx,cp.cp_name,cp.cp_name,concat(cp_f.cf_directory,cp_f.cf_image2) as banner_image FROM company cp JOIN company_file cp_f ON cp.cp_idx = cp_f.cp_idx WHERE cp.cp_idx IN(";
				break;			
	
			case 5:
				sql = "INSERT INTO am_banner_2 SELECT cp.cp_idx,cp.cp_name,cp.cp_name,cp.cp_intro_content,cp.cp_open_datetime, concat(cp_f.cf_directory,cp_f.cf_image2) as banner_image FROM company cp JOIN company_file cp_f ON cp.cp_idx = cp_f.cp_idx WHERE cp.cp_idx IN(";
				break;			
	
			default:
				break;
		}
		for (int i = 0; i < cp_idx_value_arr.length; i++) {
			if (i + 1 == cp_idx_value_arr.length) {
				sql += "?)";
			}else {
				sql += "?,";
			}
		}
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < cp_idx_value_arr.length; i++) {
				pstmt.setInt(i+1, cp_idx_value_arr[i]);
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

	
	// 윤식 추가 - 자동, 수동 헨들러 //찾기
	public ArrayList<CompanyDeadLine> getAuto_ManDeadLineSearchList(String radioVal, String id) {

		String sql = "select mb.mb_id, cp.cp_manager, "+"cp.cp_idx, "+"cp.cp_monthly_profit, "+"cp.cp_sector, "+"cp.cp_name, "+"cp.cp_branch, "+"cp_i.iv_current_amount, "+"cp_i.iv_goal_amount, "+"cp_i.iv_appl_stop_date_time, " 
				+"concat(cp_f.cf_directory,cp_f.cf_image1) as thumbnail_image," 
				+"round((iv_current_amount/iv_goal_amount)*100) as persent "
				+"from company cp, company_file cp_f, company_invest cp_i, member mb " 
				+"where cp.cp_open_status = true " 
				+"AND cp.cp_idx ='"+ id +"' "
				+"AND cp_i.cp_idx ='"+ id +"' "  
				+"AND cp_f.cp_idx ='"+ id +"' "
				+"AND cp.mb_id = mb.mb_id ";
			

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
	ArrayList<CompanyDeadLine> transDeadLineList = new ArrayList<CompanyDeadLine>(); 
	
	try {
		if (radioVal.equals("0")) { // 수동			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		}else if(radioVal.equals("1")){ // 자동
				sql = "select mb.mb_id, cp.cp_manager, "+"cp.cp_idx, "+"cp.cp_monthly_profit, "+"cp.cp_sector, "+"cp.cp_name, "+"cp.cp_branch, "+"cp_i.iv_current_amount, "+"cp_i.iv_goal_amount, "+"cp_i.iv_appl_stop_date_time, "
					+"concat(cp_f.cf_directory,cp_f.cf_image1) as thumbnail_image, "
					+"round((iv_current_amount/iv_goal_amount)*100) as persent from company cp, company_file cp_f, company_invest cp_i, member mb " 
					+"where cp_i.iv_appl_stop_date_time > now() " 
					+"AND cp.cp_open_status = true " 
					+"AND cp.cp_idx = cp_i.cp_idx " 
					+"AND cp.cp_idx = cp_f.cp_idx " 
					+"order by cp_i.iv_appl_stop_date_time asc limit 3";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		}
		while (rs.next()) {
			CompanyDeadLine DeadLineList = new CompanyDeadLine();
			
			DeadLineList.setCp_idx(rs.getInt("cp_idx"));
			DeadLineList.setMb_id(rs.getString("mb_id"));
			DeadLineList.setCp_manager(rs.getString("cp_manager"));
			DeadLineList.setCp_monthly_profit(rs.getInt("cp_monthly_profit"));
			DeadLineList.setCp_sector(rs.getString("cp_sector"));
			DeadLineList.setCp_name(rs.getString("cp_name"));
			DeadLineList.setCp_branch(rs.getString("cp_branch"));
			DeadLineList.setIv_current_amount(rs.getString("iv_current_amount"));
			DeadLineList.setIv_goal_amount(rs.getString("iv_goal_amount"));
			DeadLineList.setAppl_stop_date_time(rs.getString("iv_appl_stop_date_time"));
			DeadLineList.setThumbnail_image(rs.getString("thumbnail_image"));
			DeadLineList.setPersent(rs.getString("persent"));
			
			transDeadLineList.add(DeadLineList);								
		}
		
		return transDeadLineList;
		
	} catch (Exception ex) {
		System.out.println("getAuto_ManDeadLineSearchList 에러: " + ex);
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
		
		String sql = "UPDATE admin_am_setting SET aas_auto_status ="+ auto_status +" WHERE aas_idx = "+aas_idx;  
		
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
	
	// 마감임박 admin_deadLine 테이블에 insert
	public boolean insertAutoManDeadLineList(ArrayList<CompanyDeadLine> transDeadLineList) {
		String sql = "INSERT INTO admin_deadLine("
				+ "cp_idx, mb_id, cp_manager, cp_monthly_profit, cp_sector, cp_name, cp_branch, "
				+ "iv_current_amount, iv_goal_amount, appl_stop_date_time, thumbnail_image, persent) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println("insertAutoManDeadLineList :" + transDeadLineList.toString());
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i =0 ; i < transDeadLineList.size() ; i++) {							
				pstmt.setInt(1, transDeadLineList.get(i).getCp_idx());
				pstmt.setString(2, transDeadLineList.get(i).getMb_id());
				pstmt.setString(3, transDeadLineList.get(i).getCp_manager());
				pstmt.setInt(4, transDeadLineList.get(i).getCp_monthly_profit());
				pstmt.setString(5, transDeadLineList.get(i).getCp_sector());
				pstmt.setString(6, transDeadLineList.get(i).getCp_name());
				pstmt.setString(7, transDeadLineList.get(i).getCp_branch());			
				pstmt.setString(8, transDeadLineList.get(i).getIv_current_amount());
				pstmt.setString(9, transDeadLineList.get(i).getIv_goal_amount());
				pstmt.setString(10, transDeadLineList.get(i).getAppl_stop_date_time());
				pstmt.setString(11, transDeadLineList.get(i).getThumbnail_image());
				pstmt.setString(12, transDeadLineList.get(i).getPersent());
			}			
			result = pstmt.executeUpdate();
			System.out.println(pstmt);
			
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("InsertCompany 에러: " + ex);
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
		String sql = "SELECT cp_idx, cp_name, manager_name, member_id "
				+ "FROM popularityManagement_list ";

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
		String sql = "SELECT cp_idx, cp_name, manager_name, member_id "
				+ "FROM popularityManagement_list "
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
			  if(result == 1) {
				  System.out.println("result:::"+result);
				  return result;
			  }else {
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
	///////////////////////////////// 태훈끝//////////////////////////////////////////////

	public String getDownloadPath(int app_cp_idx) {
		String sql = "SELECT app_cp_real_path FROM company_application WHERE app_cp_idx = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, app_cp_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return rs.getString("app_cp_real_path");
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

}
