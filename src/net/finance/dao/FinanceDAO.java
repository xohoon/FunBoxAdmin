package net.finance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.customer.dto.Token;

public class FinanceDAO {
	private static FinanceDAO instance;

	// 3.
	public static FinanceDAO getInstance() {
		if (instance == null)
			instance = new FinanceDAO();
		return instance;
	}

	// 4.
	private Connection conn;
	private static String URL = "jdbc:mysql://52.79.240.236/funbox?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=utf8";
	private static String USERNAME = "damonwin01";
	private static String PASSWORD = "damon123!!";

	ResultSet rs;
	// 2.

	public FinanceDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 윤식 추가 -- 재정관리 / 토큰 입출금 내역
	public ArrayList<Token> getTokenWithdrawList(int startRow, int pageSize, String category) {
		
		String sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B UNION "  
				     +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B "  
				     +"ORDER BY td_date_time DESC limit "
				     +startRow + ", " + pageSize;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Token> transTokenList = new ArrayList<Token>(); 
		
		try {
			if (category.equals("0")) { // 전체
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("1")){ // 입금
				sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B WHERE A.td_to_address='durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek'UNION "
					 +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B "
					 +"ORDER BY td_date_time DESC limit "
					 +startRow + ", " + pageSize;
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("2")){ // 출금
				sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B UNION "
					  +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B  WHERE A.td_to_address='durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek'"
					  +"ORDER BY td_date_time DESC limit "
					  +startRow + ", " + pageSize;
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}
			while (rs.next()) {
				Token tokenList = new Token();
				tokenList.setMb_id(rs.getString("mb_id"));
				tokenList.setTd_from_address(rs.getString("td_from_address"));
				tokenList.setTd_to_address(rs.getString("td_to_address"));
				tokenList.setTd_amount(rs.getString("td_amount"));
				tokenList.setTd_status(rs.getString("td_status"));
				tokenList.setTd_date_time(rs.getString("td_date_time"));
				transTokenList.add(tokenList);								
			}
			
			return transTokenList;
		} catch (Exception ex) {
			System.out.println("getTokenWithdrawList 에러: " + ex);
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
	
	// 토큰 입출금 내역
	public int tokenCount(String category) {
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;
		String sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B UNION "  
			     +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B "  
			     +"ORDER BY td_date_time DESC";

		try {
			if (category.equals("0")) { // 전체
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			}else if(category.equals("1")){ // 입금
				sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B WHERE A.td_to_address='durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek'UNION "
					 +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B "
					 +"ORDER BY td_date_time DESC";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("2")){
				sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B UNION "
					  +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B  WHERE A.td_to_address='durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek'"
					  +"ORDER BY td_date_time DESC";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}

			rs.last();

			count = rs.getRow();

			rs.beforeFirst();

			return count;

		} catch (Exception ex) {
			System.out.println("tokenCount 에러: " + ex);
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
	
}
