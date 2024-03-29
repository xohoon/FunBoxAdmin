package net.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.customer.dto.FaqBoard;
import net.customer.dto.NoticeBoard;
import net.customer.dto.inquiryAnswer;
import net.customer.dto.inquiryBoard;

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
	
	// 유정 - 총 faq 리스트 수 출력하기
	public int faqCount(String category) {
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;
		String sql = "select * from faq where category=?";

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
		String sql = "select f.idx,f.category,f.title,f.content,f.reg_date_time,f.status,m.mb_name from faq as f join member as m on f.mb_idx=m.mb_idx where category=? order by idx desc limit " + startRow
				+ ", " + pageSize;

		try {
			if (category.equals("0")) {
				sql = "select f.idx,f.category,f.title,f.content,f.reg_date_time,f.status,m.mb_name from faq as f join member as m on f.mb_idx=m.mb_idx order by idx desc limit " + startRow + "," + pageSize;
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
				faq.setStatus(rs.getInt("status"));
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
		String sql = "select f.idx,f.category,f.title,f.content,f.reg_date_time,f.uploadfile,f.alias_uploadfile,f.real_path,m.mb_name from faq as f join member as m on f.mb_idx=m.mb_idx where idx=? order by reg_date_time";
		
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
				faq.setUploadfile(rs.getString("uploadfile"));
				faq.setAlias_uploadfile(rs.getString("alias_uploadfile"));
				faq.setReal_path(rs.getString("real_path"));
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
	
	// 유정 - faq 게시물 등록하기
	public boolean faqRegister(FaqBoard faq) {
		String sql = "insert into faq(category,title,content,uploadfile,alias_uploadfile,real_path,reg_date_time) values (?,?,?,?,?,?,CURRENT_TIMESTAMP)";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, faq.getCategory());
			pstmt.setString(2, faq.getTitle());
			pstmt.setString(3, faq.getContent());
			pstmt.setString(4, faq.getUploadfile());
			pstmt.setString(5, faq.getAlias_uploadfile());
			pstmt.setString(6, faq.getReal_path());
			
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
	
	// 유정 - faq 게시물 삭제하기
	public boolean faqDelete(int faq_idx) {
		String sql = "delete from faq where idx=?";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, faq_idx);
			
			result = pstmt.executeUpdate();
			
			if(result != 0) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("faqDelete 에러: " + e);
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
	
	// 유정 - faq 게시물 수정하기
	public boolean faqModify(FaqBoard faq) {
		String sql = "update faq set category=?,title=?,content=?,uploadfile=?,alias_uploadfile=?,real_path=? where idx=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, faq.getCategory());
			pstmt.setString(2, faq.getTitle());
			pstmt.setString(3, faq.getContent());
			pstmt.setString(4, faq.getUploadfile());
			pstmt.setString(5, faq.getAlias_uploadfile());
			pstmt.setString(6, faq.getReal_path());
			pstmt.setInt(7, faq.getIdx());
			pstmt.executeUpdate();
			
			return true;
			
		} catch (Exception ex) {
			System.out.println("faqModify 에러: " + ex);
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
		
		return false;
	}
	
	// 유정 - faq 게시물 활성화/비활성화 하기
	public boolean faqShow(int status, int faq_idx) {
		String sql = "update faq set status=? where idx=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setInt(2, faq_idx);
			pstmt.executeUpdate();
			
			return true;
			
		} catch (Exception ex) {
			System.out.println("faqShow 에러: " + ex);
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
		
		return false;
	}
	
	// 유정 - 공지 게시물 활성화/비활성화 하기
	public boolean NoticeShow(int status, int notice_idx) {
		String sql = "update notice set status=? where idx=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setInt(2, notice_idx);
			pstmt.executeUpdate();
			
			return true;
			
		} catch (Exception ex) {
			System.out.println("NoticeShow 에러: " + ex);
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
		
		return false;
	}
	
	// 유정 - 공지 게시물 등록하기
	public boolean noticeRegister(NoticeBoard notice) {
		String sql = "insert into notice(title,content,uploadfile,alias_uploadfile,real_path,reg_date_time) values (?,?,?,?,?,CURRENT_TIMESTAMP)";
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setString(3, notice.getUploadfile());
			pstmt.setString(4, notice.getAlias_uploadfile());
			pstmt.setString(5, notice.getReal_path());
			
			result = pstmt.executeUpdate();
			if(result != 0) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("noticeRegister 에러: " + e);
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
	
	// 유정 - 공지사항 상세 불러오기
	public NoticeBoard noticeDetail(int idx) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select n.idx,n.title,n.content,n.reg_date_time,n.uploadfile,n.alias_uploadfile,n.real_path,m.mb_name from notice as n join member as m on n.mb_idx=m.mb_idx where idx=? order by reg_date_time";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				NoticeBoard notice = new NoticeBoard();
				notice.setIdx(rs.getInt("idx"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setReg_date_time(rs.getDate("reg_date_time"));
				notice.setUploadfile(rs.getString("uploadfile"));
				notice.setAlias_uploadfile(rs.getString("alias_uploadfile"));
				notice.setReal_path(rs.getString("real_path"));
				notice.setMb_name(rs.getString("mb_name"));
				
				return notice;
			}
		} catch (Exception ex) {
			System.out.println("noticeDetail 에러: " + ex);
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
	
	// 유정 - 공지 게시물 수정하기
	public boolean noticeModify(NoticeBoard notice) {
		String sql = "update notice set title=?,content=?,uploadfile=?,alias_uploadfile=?,real_path=? where idx=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setString(3, notice.getUploadfile());
			pstmt.setString(4, notice.getAlias_uploadfile());
			pstmt.setString(5, notice.getReal_path());
			pstmt.setInt(6, notice.getIdx());
			pstmt.executeUpdate();
			
			return true;
			
		} catch (Exception ex) {
			System.out.println("noticeModify 에러: " + ex);
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
		
		return false;
	}
	
	// 윤식 - 1 : 1 문의 계시판 가져오기 
	public ArrayList<inquiryBoard> getinquiryBoard(int startRow, int pageSize, String category, String id) {

		// 전체		
		String sql = "SELECT idx, id, name, title, reg_date_time, qna_reply FROM qna "
					+"where id like '%"+ id +"%' "
					+"ORDER BY reg_date_time DESC limit "
					+ startRow + ", " + pageSize;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<inquiryBoard> transinquiryBoardList = new ArrayList<inquiryBoard>(); 
		
		try {
			if (category.equals("0")) { // 전체					
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			}else if(category.equals("1")){ // 답변
				sql = "SELECT idx, id, name, title, reg_date_time, qna_reply FROM qna "
					+"where id like '%"+ id +"%' "
					+"AND qna_reply IS NOT NULL "
					+"ORDER BY reg_date_time DESC limit "
					+ startRow + ", " + pageSize;	
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			}else if(category.equals("2")){ // 미답변
				sql = "SELECT idx, id, name, title, reg_date_time, qna_reply FROM qna "
					+"where id like '%"+ id +"%' "
					+"AND qna_reply IS NULL "
					+"ORDER BY reg_date_time DESC limit "
					+ startRow + ", " + pageSize;					
					
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			}
			
			while (rs.next()) {
				inquiryBoard inquiryList = new inquiryBoard();
				inquiryList.setIdx(rs.getInt("idx"));
				inquiryList.setId(rs.getString("id"));
				inquiryList.setName(rs.getString("name"));
				inquiryList.setTitle(rs.getString("title"));
				inquiryList.setReg_date_time(rs.getString("reg_date_time"));
				inquiryList.setQna_reply(rs.getString("qna_reply"));
				
				
				transinquiryBoardList.add(inquiryList);
			}
			
			return transinquiryBoardList;
			
		} catch (Exception ex) {
			System.out.println("getinquiryBoard 에러: " + ex);
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
	
	// 1:1 카운트 개수 가져오기 - 윤식 추가
	public int inquiryBoardCount(String category , String id) {
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;
		
		String sql = "SELECT idx, id, name, title, reg_date_time, qna_reply FROM qna "
					+" where id like '%"+ id +"%' ";

		try {
			if (category.equals("0")) { // 전체
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			}else if(category.equals("1")){ // 답변
				sql = "SELECT idx, id, name, title, reg_date_time, qna_reply FROM qna "
					+"where id like '%"+ id +"%' "
					+"AND qna_reply IS NOT NULL ";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}else if(category.equals("2")){ //미 답변
				sql = "SELECT idx, id, name, title, reg_date_time, qna_reply FROM qna "
					+"where id like '%"+ id +"%' "
					+"AND qna_reply IS NULL ";
				
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
			}
			
			rs.last();
			count = rs.getRow();
			rs.beforeFirst();

			return count;
		} catch (Exception ex) {
			System.out.println("inquiryBoardCount 에러: " + ex);
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
	// 윤식 - 1:1 title 글 선택시 해당 글 불러오기
	public ArrayList<inquiryAnswer> getinquiryAnswer(String idx) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = "SELECT idx, title, category, id, name, reg_date_time, content, qna_reply FROM qna "  			
				+"where idx= "+ idx;
			
		ArrayList<inquiryAnswer> sendList = new ArrayList<inquiryAnswer>();
		
		try {
							
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				inquiryAnswer getList = new inquiryAnswer(); 
				getList.setIdx(rs.getInt("idx"));
				getList.setTitle(rs.getString("title"));
				getList.setCategory(rs.getString("category"));
				getList.setId(rs.getString("id"));
				getList.setName(rs.getString("name"));				
				getList.setReg_date_time(rs.getDate("reg_date_time"));
				getList.setContent(rs.getString("content"));
				getList.setQna_reply(rs.getString("qna_reply"));
				
				sendList.add(getList);
			}
		
			return sendList;
			
		}catch (Exception ex) {
		System.out.println("getinquiryAnswer 에러: " + ex);
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
	
	
	public boolean replyupdate(String reply, int idx) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		String sql = "update qna set qna_reply=?, reply_check=? where idx=?";		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reply);
			pstmt.setBoolean(2, true); 
			pstmt.setInt(3, idx);			
			pstmt.executeUpdate();
			
			return true;
			
		} catch (Exception ex) {
			System.out.println("replyupdate 에러: " + ex);
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
		
		return false;
	}
	
	// 태훈 - 공지게시판
	public ArrayList<NoticeBoard> getNotice(int startRow, int pageSize) throws Exception {
		ArrayList<NoticeBoard> notice_list = new ArrayList<NoticeBoard>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT n.idx, n.title, n.content, n.reg_date_time, n.status, m.mb_name " 
				+ "FROM notice as n join member as m on n.mb_idx=m.mb_idx " 
				+ "ORDER BY idx desc limit "
				+ startRow + ", " + pageSize;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				NoticeBoard notice = new NoticeBoard();

				notice.setIdx(rs.getInt("idx"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setReg_date_time(rs.getDate("reg_date_time"));
				notice.setStatus(rs.getInt("status"));
				notice.setMb_name(rs.getString("mb_name"));

				notice_list.add(notice);
			}
			return notice_list;

		} catch (Exception ex) {

			System.out.println("getNotice 에러: " + ex);
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

	// 태훈 - notice count
	public int noticeCount() {
		PreparedStatement pstmt = null;
		int count = 0;
		ResultSet rs = null;
		String sql = "select * from notice";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
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
		
	// 유정 - 저장될 경로 가져오기
	public String getUploadDirectory(String file_category) {
		String sql = "SELECT file_path FROM file_path WHERE file_category = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, file_category);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String file_path = rs.getString("file_path");
				return file_path;
			}
		} catch (Exception ex) {
			System.out.println("getUploadFilePath 에러: " + ex);
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
	
	// 유정 - 파일 다운로드 경로 가져오기
	public String fileDownPath(int idx, String uploadfile) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select real_path from faq where idx=? and alias_uploadfile=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setString(2, uploadfile);
			rs = pstmt.executeQuery();
	
			if (rs.next()) {
				String real_path = rs.getString("real_path");
				return real_path;
			}

		} catch (Exception ex) {
			System.out.println("fileDownPath 에러: " + ex);
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
}
