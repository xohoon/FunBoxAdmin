package net.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.customer.dto.FaqBoard;

public class CustomerDAO {
	private static CustomerDAO instance;

	// 3.
	public static CustomerDAO getInstance() {
		if (instance == null)
			instance = new CustomerDAO();
		return instance;
	}

	// 4.
	private Connection conn;
	private static String URL = "jdbc:mysql://52.79.240.236/funbox?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=utf8";
	private static String USERNAME = "damonwin01";
	private static String PASSWORD = "damon123!!";

	ResultSet rs;
	// 2.

	public CustomerDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 총 faq 리스트 수 출력 함수
	public int faqCount(String category) {
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;
		String sql = "select * from faq where category = ?";

		try {
			if (category.equals("0")) {
				sql = "select * from faq ";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			} else {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, category);
				rs = pstmt.executeQuery();
			}

			rs.last();

			count = rs.getRow();

			rs.beforeFirst();

			return count;

		} catch (Exception ex) {
			System.out.println("faqCount 에러: " + ex);
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
		return 0;
	}
	
	// 고객지원 - FAQ 불러오기
	public ArrayList<FaqBoard> getFaq(String category, int startRow, int pageSize) throws Exception {
		ArrayList<FaqBoard> faq_list = new ArrayList<FaqBoard>();
		// 0을 넣었을때 다른 sql 구문이 돌수 있게 하자
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select * from faq where category=? order by reg_date_time desc limit " + startRow
				+ ", " + pageSize;

		try {
			if (category.equals("0")) {
				sql = "select * from faq order by reg_date_time desc limit " + startRow + "," + pageSize;
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
			} else {
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, category);
				rs = pstm.executeQuery();
			}

			while (rs.next()) {
				FaqBoard faq = new FaqBoard();
				faq.setIdx(rs.getInt("idx"));
				faq.setCategory(rs.getInt("category"));
				faq.setTitle(rs.getString("title"));
				faq.setContent(rs.getString("content"));
				faq.setReg_date_time(rs.getDate("reg_date_time"));
				faq_list.add(faq);
			}
			return faq_list;

		} catch (Exception ex) {

			System.out.println("getFaq 에러: " + ex);
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
	
	// faq 상세 불러오기
	public FaqBoard faqDetail(int idx) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from faq where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				FaqBoard faqBoard = new FaqBoard();
				faqBoard.setIdx(rs.getInt("idx"));
				faqBoard.setCategory(rs.getInt("category"));
				faqBoard.setTitle(rs.getString("title"));
				faqBoard.setContent(rs.getString("content"));
				faqBoard.setReg_date_time(rs.getDate("reg_date_time"));
				
				return faqBoard;
			}

		} catch (Exception ex) {
			System.out.println("faqDetail 에러: " + ex);
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

		return null;
	}
}
