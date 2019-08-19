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
import net.util.Paging;

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
	public boolean getMemberList(List<Member> memberList, int _page, Paging paging) {
		CallableStatement cstmt = null;
		try {
			cstmt = (CallableStatement) conn.prepareCall("CALL SELECT_MEMBER_LIST(?,?,?,?,?)");
			cstmt.setInt(1, _page);
			cstmt.setInt(2, 10);
			cstmt.registerOutParameter("_current_min_page", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_current_max_page", java.sql.Types.INTEGER);
			cstmt.registerOutParameter("_max_page", java.sql.Types.INTEGER);

			rs = cstmt.executeQuery();

			paging.setCurrent_min_page(cstmt.getInt("_current_min_page"));
			paging.setCurrent_max_page(cstmt.getInt("_current_max_page"));
			paging.setMax_page(cstmt.getInt("_max_page"));

			while (rs.next()) {
				Member member = new Member();
				member.setMb_idx(rs.getInt("mb_idx"));
				member.setMb_id(rs.getString("mb_id"));
				member.setMb_name(rs.getString("mb_name"));
				member.setMb_email(rs.getString("mb_email"));
				member.setMb_phone(rs.getString("mb_phone"));
				member.setMb_recommend(rs.getString("mb_recommend"));
				memberList.add(member);
			}
			return true;
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

		return false;
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

	// 회원가입 id 중복체크
	public boolean checkDuplicationID(String mb_id) {
		String sql = "SELECT mb_id FROM member WHERE mb_id = ?";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, mb_id);
			rs = pstm.executeQuery();

			if (rs.next()) {
				return false;
			} else {
				return true;
			}

		} catch (Exception ex) {
			System.out.println("checkDuplicationID 에러: " + ex);
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
		return false;
	}

	// 회원등록
	public boolean registeMember(Member member) {
		String sql = "insert into member(mb_id,mb_pw,mb_pincode,mb_email,mb_name,mb_phone,mb_add_num,mb_add_ch,mb_add_more,mb_add_extra,mb_recommend,reg_date_time) values (?,?,?,?,?,?,?,?,?,?,?,now())";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMb_id());
			pstmt.setString(2, member.getMb_pw());
			pstmt.setString(3, member.getMb_pincode());
			pstmt.setString(4, member.getMb_email());
			pstmt.setString(5, member.getMb_name());
			pstmt.setString(6, member.getMb_phone());
			pstmt.setString(7, member.getMb_add_num());
			pstmt.setString(8, member.getMb_add_ch());
			pstmt.setString(9, member.getMb_add_more());
			pstmt.setString(10, member.getMb_add_extra());
			pstmt.setString(11, member.getMb_recommend());

			result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("registerMember 에러: " + ex);
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
		return false;
	}
}
