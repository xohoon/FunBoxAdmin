package net.company.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyAdded;

public class CompanyMainSlideManagement2Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CompanyDAO companyDAO = new CompanyDAO();
		//mainbanner 1 슬라이드 상태
		boolean auto_status = companyDAO.getAutoStatus(5);
		
		companyDAO = new CompanyDAO();
		
		List<CompanyAdded> companyAddedList = new ArrayList<CompanyAdded>();
		companyDAO.getCompanyAddedList(companyAddedList, 5);
		ActionForward forward = new ActionForward();
		
		request.setAttribute("auto_status", auto_status);
		request.setAttribute("companyAddedList", companyAddedList);
		
		forward.setRedirect(false);
		forward.setPath("./company/companyMainSlideManagement2.jsp");
		return forward;
	}

}
