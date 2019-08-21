package net.finance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.finance.dto.Invest;
import net.finance.dto.Point;
import net.finance.dto.Token;

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
	// 윤식 추가 -- 재정관리 / 토큰 입출금 내역 List, 검색 조회
	public ArrayList<Token> getTokenWithdrawList(int startRow, int pageSize, String category, String id) {
		
		String sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B WHERE B.mb_id like '%"+ id +"%' UNION "  
				     +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B where B.mb_id like '%"+ id +"%' "  
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
				sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B WHERE A.td_to_address='durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek' and B.mb_id like '%"+ id +"%' UNION "
					 +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B where B.mb_id like '%"+ id +"%' "
					 +"ORDER BY td_date_time DESC limit "
					 +startRow + ", " + pageSize;
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("2")){ // 출금
				sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B where B.mb_id like '%"+ id +"%' UNION "
					  +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B  WHERE A.td_from_address='durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek' and B.mb_id like '%"+ id +"%'"
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
	
	// 토큰 입출금 내역 카운트
	public int tokenCount(String category , String id) {
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;
		String sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B WHERE B.mb_id like '%"+ id +"%' UNION "  
			     +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B where B.mb_id like '%"+ id +"%' " ;			     			     

		try {
			if (category.equals("0")) { // 전체
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			}else if(category.equals("1")){ // 입금
				sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B WHERE A.td_to_address='durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek' and B.mb_id like '%"+ id +"%' UNION "
					 +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B where B.mb_id like '%"+ id +"%' ";						 
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("2")){
				sql = "SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time FROM token_deposit AS A, member AS B where B.mb_id like '%"+ id +"%' UNION "
				     +"SELECT B.mb_id, A.td_to_address, A.td_from_address, A.td_amount, A.td_status, A.td_date_time from token_withdraw AS A, member AS B  WHERE A.td_from_address='durlsmswlrkqwnthrkemfdjrksmszksdlqslekdqmfkzpttlftlrksqhrlehwkfdksehlrhdkwnalclfrjtrkxwyejejrlfdjdirlfdlwhwjfdlehlsmswlqhftndlTtmqslek' and B.mb_id like '%"+ id +"%'";						 
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
	
	// 포인트 환전 내역 List 불러오기
	public ArrayList<Point> gettokenExchangeList(int startRow, int pageSize, String category, String id) {
		String sql = "SELECT DISTINCT C.mb_id, A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B ,member as C " 
					+ "WHERE A.tk_idx = B.tk_idx AND A.po_category = 2 AND C.mb_id like '%"+ id +"%' UNION " 
					+ "SELECT DISTINCT C.mb_id, A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B, member as C " 
					+ "WHERE A.tk_idx = B.tk_idx AND A.po_category = 3 AND C.mb_id like '%"+ id +"%' "
					+ "ORDER BY po_date_time DESC limit "
					+ startRow + ", " + pageSize;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Point> transPointList = new ArrayList<Point>(); 
		
		try {
			if (category.equals("0")) { // 전체
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("1")){ // 충전
				sql = "SELECT DISTINCT C.mb_id, A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B ,member as C " 
					+ "WHERE A.tk_idx = B.tk_idx AND A.po_category = 2 AND C.mb_id like '%"+ id +"%' " 					
					+ "ORDER BY po_date_time DESC limit "
					+ startRow + ", " + pageSize;
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("2")){ // 환전
				sql = "SELECT DISTINCT C.mb_id, A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B ,member as C " 
					+ "WHERE A.tk_idx = B.tk_idx AND A.po_category = 3 AND C.mb_id like '%"+ id +"%' "
					+ "ORDER BY po_date_time DESC limit "
					+ startRow + ", " + pageSize;

				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}
			while (rs.next()) {
				Point pointList = new Point();
				
				pointList.setMb_id(rs.getString("mb_id"));
				pointList.setPo_category(rs.getString("po_category"));
				pointList.setPo_amount(rs.getString("po_amount"));
				pointList.setPo_date_time(rs.getString("po_date_time"));
				pointList.setTk_amount(rs.getString("tk_amount"));
				
				transPointList.add(pointList);								
			}
			
			return transPointList;
			
		} catch (Exception ex) {
			System.out.println("tokenExchangeList 에러: " + ex);
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
	// 포인트 환전 내역 count
	public int pointCount(String category , String id) {
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;
		String sql = "SELECT DISTINCT C.mb_id, A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B ,member as C " 
				+ "WHERE A.tk_idx = B.tk_idx AND A.po_category = 2 AND C.mb_id like '%"+ id +"%' UNION " 
				+ "SELECT DISTINCT C.mb_id, A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B, member as C " 
				+ "WHERE A.tk_idx = B.tk_idx AND A.po_category = 3 AND C.mb_id like '%"+ id +"%' ";			     			     

		try {
			if (category.equals("0")) { // 전체
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			}else if(category.equals("1")){ // 환전
				sql = "SELECT DISTINCT C.mb_id, A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B ,member as C " 
					+ "WHERE A.tk_idx = B.tk_idx AND A.po_category = 2 AND C.mb_id like '%"+ id +"%' ";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("2")){ // 충전
				sql = "SELECT DISTINCT C.mb_id, A.po_category, A.po_amount, A.po_date_time, B.tk_amount FROM point_transaction as A, token_transaction as B ,member as C " 
					+ "WHERE A.tk_idx = B.tk_idx AND A.po_category = 3 AND C.mb_id like '%"+ id +"%' ";						 
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}

			rs.last();
			count = rs.getRow();
			rs.beforeFirst();

			return count;
		} catch (Exception ex) {
			System.out.println("pointCount 에러: " + ex);
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
	
	// 투자 내역 List 불러오기
		public ArrayList<Invest> getInvestList(int startRow, int pageSize, String category, String id) {
			
			String sql = "select mb_id, mi_category, mi_name, mi_point, mi_reg_date_time, mi_note from member_invest "
						+"where mb_id like '%"+ id +"%' "
						+"ORDER BY mi_reg_date_time DESC limit "
						+ startRow + ", " + pageSize;
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			ArrayList<Invest> transInvestList = new ArrayList<Invest>(); 
			
			try {
				if (category.equals("0")) { // 전체					
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
				}else if(category.equals("1")){ // 투자
					sql = "select mb_id, mi_category, mi_name, mi_point, mi_reg_date_time, mi_note from member_invest "
						+"where mb_id like '%"+ id +"%' and "
						+"mi_category = '투자' "
						+"ORDER BY mi_reg_date_time DESC limit "
						+ startRow + ", " + pageSize;		
					
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
				}else if(category.equals("2")){ // 이자
					sql = "select mb_id, mi_category, mi_name, mi_point, mi_reg_date_time, mi_note from member_invest "
						+"where mb_id like '%"+ id +"%' and "
						+"mi_category = '이자' "
						+ "ORDER BY mi_reg_date_time DESC limit "
						+ startRow + ", " + pageSize;					
						
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
				}else if(category.equals("3")){ // 회수
					sql = "select mb_id, mi_category, mi_name, mi_point, mi_reg_date_time, mi_note from member_invest "
						+"where mb_id like '%"+ id +"%' and "
						+"mi_category = '회수' "
						+ "ORDER BY mi_reg_date_time DESC limit "
						+ startRow + ", " + pageSize;						
						
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					
				}
				while (rs.next()) {
					Invest investList = new Invest();
					investList.setMb_id(rs.getString("mb_id"));
					investList.setMi_category(rs.getString("mi_category"));
					investList.setMi_name(rs.getString("mi_name"));
					investList.setMi_point(rs.getString("mi_point"));
					investList.setMi_reg_date_time(rs.getString("mi_reg_date_time"));
					investList.setMi_note(rs.getString("mi_note"));
					
					transInvestList.add(investList);
				}
				
				return transInvestList;
				
			} catch (Exception ex) {
				System.out.println("getInvestList 에러: " + ex);
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
		
	// 투자내역 개수 불러오기
	public int investCount(String category , String id) {
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;
		String sql = "select mb_id, mi_category,mi_name,mi_point,mi_reg_date_time,mi_note from member_invest "
					+"where mb_id like '%"+ id +"%' ";			     			     

		try {
			if (category.equals("0")) { // 전체
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			}else if(category.equals("1")){ // 입금
				sql = "select mb_id, mi_category,mi_name,mi_point,mi_reg_date_time,mi_note from member_invest "
					 +"where mb_id like '%"+ id +"%' and "
					 +"mi_category = '투자'";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("2")){
				sql = "select mb_id, mi_category,mi_name,mi_point,mi_reg_date_time,mi_note from member_invest "
						 +"where mb_id like '%"+ id +"%' and "
						 +"mi_category = '이자'";						 
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("3")){
				sql = "select mb_id, mi_category,mi_name,mi_point,mi_reg_date_time,mi_note from member_invest "
						 +"where mb_id like '%"+ id +"%' and "
						 +"mi_category = '회수'";						 
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}

			rs.last();
			count = rs.getRow();
			rs.beforeFirst();

			return count;
		} catch (Exception ex) {
			System.out.println("investCount 에러: " + ex);
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
