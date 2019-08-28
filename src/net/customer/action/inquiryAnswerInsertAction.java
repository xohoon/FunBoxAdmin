package net.customer.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;

public class inquiryAnswerInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("inquiryAnswerInsertAction 확인");
		String reply = request.getParameter("reply");
		System.out.println("reply : "+ reply);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('');");
		out.println("window.close()");
		out.println("opener.location.replace('./customer/inquiryAnswerForm.jsp'");
		out.println("</script>");
		out.close();
	
		return null;
		
	}

}
