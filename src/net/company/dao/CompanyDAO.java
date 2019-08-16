package net.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.CallableStatement;

import net.company.dto.CompanyApplication;
import net.company.dto.CompanyInvested;
import net.member.dto.Member;

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

	// 기업신청서 리스트
	public List<CompanyApplication> getCompanyApplicationList(int _page) {
		CallableStatement cstmt = null;
		List<CompanyApplication> companyApplicationList = new ArrayList<CompanyApplication>();
		try {
			cstmt = (CallableStatement) conn.prepareCall("CALL SELECT_COMPANY_APPLICATION_LIST(?,?)");
			cstmt.setInt(1, _page);
			cstmt.setInt(2, 10);
			rs = cstmt.executeQuery();
			while (rs.next()) {
				CompanyApplication companyApplication = new CompanyApplication();
				companyApplication.setApp_cp_idx(rs.getInt("app_cp_idx"));
				companyApplication.setMb_id(rs.getString("mb_id"));
				companyApplication.setApp_cp_manager(rs.getString("app_cp_manager"));
				companyApplication.setApp_cp_hp(rs.getString("app_cp_hp"));
				companyApplication.setApp_cp_ch(rs.getString("app_cp_ch"));
				companyApplication.setApp_cp_sector(rs.getString("app_cp_sector"));
				companyApplication.setApp_cp_status(rs.getBoolean("app_cp_status"));
				companyApplication.setApp_deleted_status(rs.getBoolean("app_deleted_status"));
				companyApplicationList.add(companyApplication);
			}
		} catch (Exception ex) {
			System.out.println("getCompanyApplicationList 에러: " + ex);
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

		return companyApplicationList;
	}

	// 기업 신청 리스트 최대 페이지
	public int getCompanyApplicationListMaxPage() {
		int max_page = 0;
		String sql = "SELECT CEIL( COUNT(*)/ ? ) AS MAX_PAGE FROM company_application";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				max_page = rs.getInt("MAX_PAGE");
			}
		} catch (Exception ex) {
			System.out.println("getCompanyApplicationMaxPage 에러: " + ex);
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
		return max_page;
	}

	// 기업 투자 목록 리스트
	public List<CompanyInvested> getCompanyInvestedList(int _page,String _cp_funding_status) {
		CallableStatement cstmt = null;
		List<CompanyInvested> companyInvestedList = new ArrayList<CompanyInvested>();
		try {
			cstmt = (CallableStatement) conn.prepareCall("CALL SELECT_COMPANY_INVESTED_LIST(?,?,?)");
			cstmt.setInt(1, _page);
			cstmt.setString(2, _cp_funding_status);
			cstmt.setInt(3, 10);
			rs = cstmt.executeQuery();
			while (rs.next()) {
				CompanyInvested companyInvested = new CompanyInvested();
				companyInvested.setCp_name(rs.getString("cp_name"));
				companyInvested.setMb_id(rs.getString("mb_id"));
				companyInvested.setMb_id(rs.getString("cp_manager"));
				companyInvested.setMb_id(rs.getString("cp_phone"));
				companyInvested.setCp_pre_net_profit_ratio(rs.getInt("cp_pre_net_profit_ratio"));
				companyInvested.setD_day(rs.getInt("D_day"));
				companyInvested.setMb_id(rs.getString("iv_balance_stock"));
				companyInvestedList.add(companyInvested);
			}
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
				System.out.println("연결 해제 실패: " + e.getMessage());
			}
		}

		return companyInvestedList;
	}

	// 투자 기업 리스트 최대 페이지
	public int getInvestedCompanyList(String cp_funding_status) {
		int max_page = 0;
		String sql = "SELECT CEIL(count(*)/?) as MAX_PAGE FROM company cp INNER JOIN company_invest cp_iv ON cp.cp_idx = cp_iv.cp_idx INNER JOIN company_pre_revenue cp_rv ON cp.cp_idx = cp_rv.cp_idx WHERE cp.cp_funding_status = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			pstmt.setString(2, cp_funding_status);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				max_page = rs.getInt("MAX_PAGE");
			}
		} catch (Exception ex) {
			System.out.println("getInvestedCompanyList 에러: " + ex);
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
		return max_page;
	}
}
