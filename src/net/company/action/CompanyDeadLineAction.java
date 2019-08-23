package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.common.action.Action;
import net.common.action.ActionForward;


public class CompanyDeadLineAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		System.out.println(" CompanyDeadLineAction 확인");
		
		forward.setPath("./company/companyDeadLineManagement.jsp");
		return forward;	
	}

}
