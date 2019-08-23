package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;


public class CompanyDeadLineSaveAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		System.out.println(" CompanyDeadLineSaveAjaxAction 확인");
		//String button = response("button");
		//String button = (String)request.getAttribute("button");
		String button = request.getParameter("button");
		System.out.println(button);
		
		
		
		
		forward.setPath("./company/companyDeadLineManagement.jsp");
		return forward;
	}

}
