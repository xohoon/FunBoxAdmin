package net.customer.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.dao.CustomerDAO;
import net.customer.dto.inquiryAnswer;

public class InquiryAnswerFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("InquiryAnswerFormAction 확인");
		ActionForward forward = new ActionForward();
		String idx = request.getParameter("idx");
		
		try {
			if(idx.equals(null)) {
				idx = " ";
			}
		}catch(NullPointerException e) {
			idx = " ";			
		}
		ArrayList<inquiryAnswer> Answer = new ArrayList<inquiryAnswer>();
		
		CustomerDAO customerdao = new CustomerDAO();
		Answer = customerdao.getinquiryAnswer(idx);
		
		System.out.println("AnswerList : " + Answer.toString());		
		request.setAttribute("Answer", Answer);
		
		forward.setRedirect(false);
		forward.setPath("./customer/inquiryAnswerForm.jsp");
		return forward;
	}

}
