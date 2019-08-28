package net.customer.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;

public class inquiryAnswerInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("inquiryAnswerInsertAction 확인");
		ActionForward forward = new ActionForward();
		String reply = request.getParameter("reply");
		System.out.println("reply : "+ reply);
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('');");
		out.println("window.close()");
//		out.println("opener.location.replace('./Mypage4_1.mb')");
		out.println("opener.location.replace('./customer/inquiryAnswerForm.jsp'");
//		out.println("location.href='./MemberInvestmentList.mb';");
		out.println("</script>");
		out.close();
		
		
		/*
		 * forward.setRedirect(false);
		 * forward.setPath("./customer/inquiryAnswerForm.jsp");
		 */ 
		//return forward;
		return null;
	}

}
