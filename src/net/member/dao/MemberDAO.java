package net.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.CallableStatement;
//import com.mysql.cj.jdbc.CallableStatement;
import net.member.dto.Member;
import net.member.dto.MemberLateInvested;
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

	// ȸ������Ʈ
	public boolean getMemberList(List<Member> memberList, int _page, int _search_type, String _search_word,
			Paging paging) {
		CallableStatement cstmt = null;
		try {
			cstmt = (CallableStatement) conn.prepareCall("CALL SELECT_MEMBER_LIST(?,?,?,?,?,?,?)");
			cstmt.setInt(1, _page);
			cstmt.setInt(2, _search_type);
			cstmt.setString(3, _search_word);
			cstmt.setInt(4, 10);
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
			System.out.println("SelectMemberList ����: " + ex);
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

	// ȸ������ id �ߺ�üũ
	public boolean checkDuplicationID(String mb_id) {
		String sql = "SELECT mb_id FROM member WHERE mb_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return false;
			} else {
				return true;
			}

		} catch (Exception ex) {
			System.out.println("checkDuplicationID ����: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� ����: " + e.getMessage());
			}
		}
		return false;
	}

	// ȸ�����
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
			System.out.println("registerMember ����: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� ����: " + e.getMessage());
			}
		}
		return false;
	}

	// ȸ�� �� ����
	public List<MemberLateInvested> getMemberLateInvestedList(int mb_idx) {
		String sql = "SELECT mi_name, mi_point, mi_hoiling_stock, mi_reg_date_time FROM member_invest WHERE mb_idx = ? ORDER BY mi_reg_date_time DESC LIMIT 0,10";
		PreparedStatement pstmt = null;
		List<MemberLateInvested> memberLateInvestedList = new ArrayList<MemberLateInvested>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mb_idx);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberLateInvested memberLateInvested = new MemberLateInvested();
				memberLateInvested.setMi_name(rs.getString("mi_name"));
				memberLateInvested.setMi_point(rs.getString("mi_point"));
				memberLateInvested.setMi_hoiling_stock(rs.getString("mi_hoiling_stock"));
				memberLateInvested.setMi_reg_date_time(rs.getDate("mi_reg_date_time"));
				memberLateInvestedList.add(memberLateInvested);
			}

			return memberLateInvestedList;
		} catch (Exception ex) {
			System.out.println("getMemberLateInvestedList ����: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� ����: " + e.getMessage());
			}
		}
		return memberLateInvestedList;
	}

	public Member getMember(int mb_idx) {
		String sql = "SELECT * FROM member WHERE mb_idx = ?";
		PreparedStatement pstmt = null;
		Member member = new Member();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mb_idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member.setMb_idx(mb_idx);
				member.setMb_id(rs.getString("mb_id"));
				member.setMb_name(rs.getString("mb_name"));
				member.setMb_email(rs.getString("mb_email"));
				member.setMb_phone(rs.getString("mb_phone"));
				member.setMb_add_num(rs.getString("mb_add_num"));
				member.setMb_add_ch(rs.getString("mb_add_ch"));
				member.setMb_add_more(rs.getString("mb_add_more"));
				member.setMb_add_extra(rs.getString("mb_add_extra"));
				member.setMb_recommend(rs.getString("mb_recommend"));
				member.setMb_point(rs.getString("mb_point"));
				member.setMb_token(rs.getString("mb_token"));
			}

			return member;
		} catch (Exception ex) {
			System.out.println("getMember ����: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� ����: " + e.getMessage());
			}
		}
		return member;
	}

	public boolean modifyMember(Member member) {
		String sql = "UPDATE member SET mb_name=?,mb_id=?,mb_email=?,mb_phone=?,mb_add_num=?,mb_add_ch=?,mb_add_more=?,mb_add_extra=?,mb_recommend=?,mb_point=?,mb_token=? WHERE mb_idx = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getMb_name());
			pstmt.setString(2, member.getMb_id());
			pstmt.setString(3, member.getMb_email());
			pstmt.setString(4, member.getMb_phone());
			pstmt.setString(5, member.getMb_add_num());
			pstmt.setString(6, member.getMb_add_ch());
			pstmt.setString(7, member.getMb_add_more());
			pstmt.setString(8, member.getMb_add_extra());
			pstmt.setString(9, member.getMb_recommend());
			pstmt.setString(10, member.getMb_point());
			pstmt.setString(11, member.getMb_token());
			pstmt.setInt(12, member.getMb_idx());

			result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}
		} catch (Exception ex) {
			System.out.println("modifyMember ����: " + ex);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("���� ���� ����: " + e.getMessage());
			}
		}
		return false;
	}
}
