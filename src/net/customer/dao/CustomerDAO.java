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
	
	// 유정 - 총 faq 리스트 수 출력 함수
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
	
	// 유정 - 고객지원 - FAQ 불러오기
	public ArrayList<FaqBoard> getFaq(String category, int startRow, int pageSize) throws Exception {
		ArrayList<FaqBoard> faq_list = new ArrayList<FaqBoard>();
		// 0을 넣었을때 다른 sql 구문이 돌수 있게 하자
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = "select f.idx, f.category, f.title, f.content, f.reg_date_time, m.mb_name from faq as f join member as m on f.mb_idx = m.mb_idx where category=? order by reg_date_time desc limit " + startRow
				+ ", " + pageSize;

		try {
			if (category.equals("0")) {
				sql = "select f.idx, f.category, f.title, f.content, f.reg_date_time, m.mb_name from faq as f join member as m on f.mb_idx = m.mb_idx order by reg_date_time desc limit " + startRow + "," + pageSize;
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
				faq.setMb_name(rs.getString("mb_name"));
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
	
	// 유정 - faq 상세 불러오기
	public FaqBoard faqDetail(int idx) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select f.idx, f.category, f.title, f.content, f.reg_date_time, m.mb_name from faq as f join member as m on f.mb_idx = m.mb_idx where idx = ? order by reg_date_time";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				FaqBoard faq = new FaqBoard();
				faq.setIdx(rs.getInt("idx"));
				faq.setCategory(rs.getInt("category"));
				faq.setTitle(rs.getString("title"));
				faq.setContent(rs.getString("content"));
				faq.setReg_date_time(rs.getDate("reg_date_time"));
				faq.setMb_name(rs.getString("mb_name"));
				
				return faq;
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
	
	// 유정 - faq 게시물 등록
	public boolean faqRegister(FaqBoard faq) {
		String sql = "insert into faq(category,title,content,reg_date_time) values (?,?,?,CURRENT_TIMESTAMP)";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, faq.getCategory());
			pstmt.setString(2, faq.getTitle());
			pstmt.setString(3, faq.getContent());
			
			result = pstmt.executeUpdate();
			if(result != 0) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("faqRegister 에러: " + e);
		}finally {
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
}
