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

//import com.mysql.cj.jdbc.CallableStatement;
import com.mysql.jdbc.CallableStatement;

import net.company.dto.Company;
import net.company.dto.CompanyApplication;
import net.company.dto.CompanyApplicationDetail;
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
	public boolean getCompanyAllList(List<Company> companyList,int _search_type, String _search_word ) {
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
	
	// 마감 임박 클라이언트 수동 List 값 가져 오기(수동)
		@SuppressWarnings({ "unchecked", "unused" })
		public JSONArray getMan3List(String cp_idx) {
			
		String sql = "select " 					
					+"cp_idx, " 
					+"mb_id, "
					+"cp_name, " 					
					+"cp_manager "
					+"from admin_deadLine ";					
				     	
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		JSONArray jsonArr = new JSONArray(); 
		System.out.println(sql);
		
		try { 
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("cp_idx", rs.getString("cp_idx"));
				jsonObj.put("mb_id", rs.getString("mb_id"));
				jsonObj.put("cp_name", rs.getString("cp_name"));				
				jsonObj.put("cp_manager", rs.getString("cp_manager"));
				
				jsonArr.add(jsonObj);						
			}
			System.out.println(jsonArr.toString());
			
			return jsonArr;
			
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
	
	/////////////////////////////////태훈시작//////////////////////////////////////////////
	// 실시간 수동 목록 가져오기
		public List<CompanyPopularityList> getCompanyPopularityList() {
			String sql = "SELECT cp_idx, cp_name, manager_name, member_id "
					+ "FROM popularityManagement_list "
					+ "ORDER BY cp_idx DESC";

			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<CompanyPopularityList> realList = new ArrayList<CompanyPopularityList>();

			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					CompanyPopularityList realDAO = new CompanyPopularityList();
					realDAO.setCp_idx(rs.getInt("cp_idx"));
					realDAO.setCp_name(rs.getString("cp_name"));
					realDAO.setManager_name(rs.getString("manager_name"));
					realDAO.setMember_id(rs.getString("member_id"));
					
					realList.add(realDAO);
				}
				return realList;
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
		/////////////////////////////////태훈끝//////////////////////////////////////////////
	
}
