package net.company.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyPopularityList;

// 태훈 실시간 수동 목록
public class CompanyPopularityManagementAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		System.out.println(" CompanyPopularityManagementAction 확인");
		
		CompanyDAO companyDAO = new CompanyDAO();
		List<CompanyPopularityList> popuInfo = companyDAO.getCompanyPopularityInfo();
		request.setAttribute("popuInfo", popuInfo);
		
		forward.setPath("./company/companyPopularityManagement.jsp");
		return forward;	
	}

}
