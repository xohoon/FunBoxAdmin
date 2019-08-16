package net.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.CallableStatement;

import net.member.dto.Member;

public class MemberDAO {
	private static MemberDAO instance;

	// 3.
	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}

	// 4.
	private Connection conn;
	private static String URL = "jdbc:mysql://52.79.240.236/funbox?serverTimezone=Asia/Seoul&useSSL=false&useUnicode=true&characterEncoding=utf8";
	private static String USERNAME = "damonwin01";
	private static String PASSWORD = "damon123!!";

	ResultSet rs;
	// 2.

	public MemberDAO() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원리스트
	public List<Member> getMemberList(int _page) {
		CallableStatement cstmt = null;
		List<Member> MemberList = new ArrayList<Member>();
		try {
			cstmt = (CallableStatement) conn.prepareCall("CALL SELECT_MEMBER_LIST(?)");
			cstmt.setInt(1, _page);
			cstmt.setInt(2, 10);
			rs = cstmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMb_idx(rs.getInt("mb_idx"));
				member.setMb_id(rs.getString("mb_id"));
				member.setMb_id(rs.getString("mb_name"));
				member.setMb_id(rs.getString("mb_email"));
				member.setMb_id(rs.getString("mb_phone"));
				member.setMb_id(rs.getString("mb_recommend"));
				MemberList.add(member);
			}
		} catch (Exception ex) {
			System.out.println("SelectMemberList 에러: " + ex);
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

		return MemberList;
	}

	// 기업 신청 리스트 최대 페이지
	public int getMemberListMaxPage() {
		int max_page = 0;
		String sql = "SELECT CEIL( COUNT(*)/ ? ) AS MAX_PAGE FROM member";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				max_page = rs.getInt("MAX_PAGE");
			}
		} catch (Exception ex) {
			System.out.println("getMemberListMaxPage 에러: " + ex);
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
