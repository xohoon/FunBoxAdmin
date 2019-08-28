package net.customer.action;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.dao.CustomerDAO;

public class FileDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		System.out.println("FileDownAction OK!");

		// get으로 idx 가져오기
		int faq_idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println("faq_idx: "+faq_idx);
		
		// get으로 파일명 가져오기
		String fileName = request.getParameter("fileName");
		System.out.println("파일명: "+fileName);
		
		// 경로 가져오기
		CustomerDAO ct_dao = new CustomerDAO();
		String saveDir = ct_dao.fileDownPath(faq_idx, fileName);
//		String saveDir = request.getSession().getServletContext().getRealPath("/upload/");
		System.out.println("경로: "+saveDir);
		File file = new File(saveDir + "/" + fileName);
		
		// MIMETYPE 설정하기
		String mimeType = request.getSession().getServletContext().getMimeType(file.toString());
		if(mimeType == null) {
			response.setContentType("application/octet-stream");
		}
		
		// 다운로드용 파일명을 설정
		String downName = null;
		if(request.getHeader("user-agent").indexOf("MSIE") == -1) {
			downName = new String(fileName.getBytes("UTF-8"), "8859_1");
		}
		else {
			downName = new String(fileName.getBytes("EUC-KR"), "8859_1");
		}
		
		// 무조건 다운로드하도록 설정
		response.setHeader("Content-Disposition","attachment;fileName=\"" + downName + "\";");
		
		// 요청된 파일을 읽어서 클라이언트쪽으로 저장한다.
		FileInputStream fileInputStream = new FileInputStream(file);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		
		byte b [] = new byte[1024];
		int data = 0;
		
		while((data=(fileInputStream.read(b, 0, b.length))) != -1)
		{
			servletOutputStream.write(b, 0, data);
		}
		
		servletOutputStream.flush();
		servletOutputStream.close();
		fileInputStream.close();
		
		return null;
	}

}
