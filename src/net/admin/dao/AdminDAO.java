package net.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
	// 태훈 추가 - 관리자 로그인 아이디/비밀번호 체크
	public int AdminLoginCheck(String adminIdCk, String adminPwCk) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT admin_pw FROM admin_account WHERE admin_id = ?";
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminIdCk);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("admin_pw").equals(adminPwCk)) {
					result = 1;
				}else {
					result = 0;
				}
			}else {
				result = -1;
			}
			return result;
		}catch(Exception e) {
			System.out.println("AdminLoginCheck error ::: " + e);
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
		return result;
	}
	
	
	
}
