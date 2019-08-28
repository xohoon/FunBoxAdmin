package net.customer.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.dao.CustomerDAO;

public class inquiryAnswerInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		boolean result = false;
		
		System.out.println("inquiryAnswerInsertAction 확인");
		String reply = request.getParameter("reply");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		CustomerDAO custonerdao = new CustomerDAO();
		result = custonerdao.replyupdate(reply, idx);

		//insert 구분 추가
		
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("window.close();");
		out.println("alert('답글을 달았습니다.');");
		out.println("opener.location.replace('./inquiryBoard.cu')");
		out.println("</script>");		
		out.close();
		
		return null;
	}

}
