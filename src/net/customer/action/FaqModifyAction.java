package net.customer.action;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.dao.CustomerDAO;
import net.customer.dto.FaqBoard;

// 유정 추가
public class FaqModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		
		FaqBoard faq = new FaqBoard();
		
		int faq_idx = Integer.parseInt(request.getParameter("faq_idx"));
		int category = Integer.parseInt(request.getParameter("selectBox"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// 날짜변환 기능
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String now = format.format(date);
		
		// 폴더이름 변수
		String company_path = title + "_" + now;
		
		CustomerDAO ct_dao2 = new CustomerDAO();
		// company 기본경로 + 폴더 이름 -> 폴더 경로에 파일삽입위해서
		String real_path = ct_dao2.getUploadDirectory("admin_faq_path") + "/" + company_path;

		// 파일디렉토리
		File fileSaveDir = new File(real_path);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
        Part part = request.getPart("uploadfile");
        
        String fileName = extractFileName(part);
        String alias = UUID.randomUUID().toString().substring(0, 9);
        String fileFormat = getFileFormat(part);

        if(fileName != null && !fileName.isEmpty()){
        	faq.setUploadfile(fileName);
			faq.setAlias_uploadfile(alias + "uploadfile" + fileFormat);
			//System.out.println(real_path + "/" + alias+"app_cp_registrantion"+fileFormat);
			part.write(real_path + "/" + alias + "uploadfile" + fileFormat);
        }
                
        response.setContentType("text/html;charset=utf-8");
        
        
		faq.setIdx(faq_idx);
		faq.setCategory(category);
		faq.setTitle(title);
		faq.setContent(content);
		faq.setReal_path(real_path);
		
		CustomerDAO ct_dao = new CustomerDAO();
		boolean result = ct_dao.faqModify(faq);
		
		if(result) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('FAQ 게시물 수정이 완료되었습니다.');");
			out.println("opener.location.href='./faqBoard.cu';");
			out.println("window.close();");
			out.println("</script>");
			out.close();

			return null;
		}else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('FAQ 게시물 수정에 실패했습니다.\n다시 시도해주세요.');");
			out.println("opener.location.href='./faqBoard.cu';");
			out.println("window.close();");
			out.println("</script>");
			out.close();

			return null;
		}
	}
	
	// 파일명 얻기
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "NULL";
	}

	private String getFileFormat(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return "." + s.substring(s.lastIndexOf(".") + 1,s.length()-1);
			}
		}
		return "";
	}

}
