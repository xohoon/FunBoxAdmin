package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;

public class CompanyMainSlideManagement2Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CompanyDAO companyDAO = new CompanyDAO();
		//mainbanner 1 슬라이드 상태
		boolean auto_status = companyDAO.getAutoStatus(5);
		
		ActionForward forward = new ActionForward();
		
		request.setAttribute("auto_status", auto_status);
		
		forward.setRedirect(false);
		forward.setPath("./company/companyMainSlideManagement2.jsp");
		return forward;
	}

}
