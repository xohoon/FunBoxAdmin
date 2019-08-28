package net.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.CallableStatement;

import net.admin.dto.IndexNeeds;
import net.company.dto.CompanyApplication;
import net.util.Paging;

public class AdminDAO {

	private static AdminDAO instance;

	// 3.
	public static AdminDAO getInstance() {
		if (instance == null)
			instance = new AdminDAO();
		return instance;
	}

	// 4.
	private Connection conn;
	private static String URL = "jdbc:mysql://52.79.240.236/funbox?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=utf8";
	private static String USERNAME = "damonwin01";
	private static String PASSWORD = "damon123!!";

	ResultSet rs;
	// 2.

	public AdminDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean setIndexNeeds(IndexNeeds indexNeeds) {
		CallableStatement cstmt = null;
		try {
			cstmt = (CallableStatement) conn.prepareCall("CALL SELECT_INDEX_NEEDS(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			cstmt.registerOutParameter("_new_member_count", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_member_count", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_cpp_admin_checked_count", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_cpp_count", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_cp_iv_count", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_main_banner1_count", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_main_banner2_count", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_faq_count", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_qna_admin_reply_count", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_notice_count", java.sql.Types.INTEGER);

			rs = cstmt.executeQuery();

			
			indexNeeds.setNew_member_count(cstmt.getInt("_new_member_count"));
			indexNeeds.setMember_count(cstmt.getInt("_member_count"));
			indexNeeds.setCpp_admin_checked_count(cstmt.getInt("_cpp_admin_checked_count"));
			indexNeeds.setCpp_count(cstmt.getInt("_cpp_count"));
			indexNeeds.setCp_iv_count(cstmt.getInt("_cp_iv_count"));
			indexNeeds.setMain_banner1_count(cstmt.getInt("_main_banner1_count"));
			indexNeeds.setMain_banner2_count(cstmt.getInt("_main_banner2_count"));
			indexNeeds.setFaq_count(cstmt.getInt("_faq_count"));
			indexNeeds.setQna_admin_reply_count(cstmt.getInt("_qna_admin_reply_count"));
			indexNeeds.setNotice_count(cstmt.getInt("_notice_count"));
			
			return true;
		} catch (Exception ex) {
			System.out.println("setIndexNeeds Error: " + ex);
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
}
