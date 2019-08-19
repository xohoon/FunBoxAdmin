package net.company.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyInvested;
import net.util.Paging;

public class CompanyInvestedListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		String page_string = request.getParameter("page");
		String funding_status = request.getParameter("funding_status");
		
		Integer page = 0;
		
		if (page_string == null) {
			page = 1;
		}else {
			page = Integer.parseInt(page_string);
		}
		
		if (page < 1) {
			page = 1;
		}
		
		if (funding_status == null || (!funding_status.equals("11") && !funding_status.equals("12"))) {
			funding_status = "12";//펀딩진행
		}
		
		List<CompanyInvested> companyInvestedList = new ArrayList<CompanyInvested>();
		Paging paging = new Paging();
		
		
		CompanyDAO companyDAO = new CompanyDAO();
		companyDAO.getCompanyInvestedList(companyInvestedList, page, funding_status, paging);

		// 잘 못된 접근
		if (companyInvestedList.size() < 1) {

		}
		
		request.setAttribute("current_page", page);
		request.setAttribute("current_min_page", paging.getCurrent_min_page());
		request.setAttribute("current_max_page", paging.getCurrent_max_page());
		request.setAttribute("max_page", paging.getMax_page());
		request.setAttribute("companyInvestedList", companyInvestedList);
		request.setAttribute("funding_status", funding_status);
		
		
		forward.setRedirect(false);
		forward.setPath("./company/companyInvestedList.jsp");
		return forward;
	}

}
