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
		//request.setCharacterEncoding("utf-8");
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
		
		if (funding_status == null) {
			funding_status = "0";
		}else if(funding_status == "11"){
			funding_status = "11";
		}else if(funding_status == "12"){
			funding_status = "12";
		}
		
		List<CompanyInvested> companyInvestedList = new ArrayList<CompanyInvested>();
		List transportresults = new ArrayList(); // 구좌 리스트 보내기
		Paging paging = new Paging();
		
		
		CompanyDAO companyDAO = new CompanyDAO();
		companyDAO.getCompanyInvestedList(companyInvestedList, page, funding_status, paging);
		
		System.out.println("CompanyInvested :" + companyInvestedList.toString());
	
		
		if (companyInvestedList.size() < 1) {

		}
		
		if (paging.getMax_page() < page) {
			request.setAttribute("current_page", paging.getMax_page());
		}else {
			request.setAttribute("current_page", page);
		}
		request.setAttribute("current_min_page", paging.getCurrent_min_page());
		request.setAttribute("current_max_page", paging.getCurrent_max_page());
		request.setAttribute("max_page", paging.getMax_page());
		request.setAttribute("companyInvestedList", companyInvestedList);
		request.setAttribute("transportresults", transportresults);
		request.setAttribute("funding_status", funding_status);
		
		
		forward.setRedirect(false);
		forward.setPath("./company/companyInvestedList.jsp");
		return forward;
	}

}
