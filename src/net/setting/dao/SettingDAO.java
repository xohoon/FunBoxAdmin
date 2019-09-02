package net.setting.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SettingDAO {
	private static SettingDAO instance;

	// 3.
	public static SettingDAO getInstance() {
		if (instance == null)
			instance = new SettingDAO();
		return instance;
	}

	// 4.
	private Connection conn;
	private static String URL = "jdbc:mysql://52.79.240.236/funbox?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=utf8";
	private static String USERNAME = "damonwin01";
	private static String PASSWORD = "damon123!!";

	ResultSet rs;
	// 2.

	public SettingDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 태훈 추가 - 현재 수수료 가져오기
	public String getFees() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT fees_percent "
				+ "FROM fees_setting "
				+ "WHERE fees_idx = 1";
		String fees = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				fees = rs.getString("fees_percent");
			}
			return fees;
		} catch (Exception ex) {
			System.out.println("getMember ERROR: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("연결 해제 실패 ::: " + e.getMessage());
			}
		}
		return null;
	}

	// 태훈 추가 - 수수료 업데이트
	public boolean FeesUpdate(String fees) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "UPDATE fees_setting " 
				+ "SET fees_percent = "+fees+" "
				+ "WHERE fees_idx = 1";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			return true;
		}catch(Exception e) {
			System.out.println("FeesUpdate error ::: " + e);
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				System.out.println("연결 해제 실패 ::: " + e.getMessage());
			}
			
		}
		return false;
	}
}
