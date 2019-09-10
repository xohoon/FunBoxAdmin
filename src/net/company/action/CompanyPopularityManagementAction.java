package net.company.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		int aas_idx = 1;
		CompanyDAO companyDAO = new CompanyDAO();
		boolean aas_auto_status = companyDAO.getAutoStatus(aas_idx);

		companyDAO = new CompanyDAO();
		List<CompanyPopularityList> popuInfo = companyDAO.getCompanyPopularityInfo();
		int auto_status = 0;
		if(aas_auto_status == true) {
			auto_status = 1;
			System.out.println(">>>1"+auto_status);
			System.out.println(">>>1"+aas_auto_status);
			request.setAttribute("auto_status", auto_status);
			request.setAttribute("popuInfo", popuInfo);
		}else {
			auto_status = 0;
			System.out.println(">>>2"+auto_status);
			System.out.println(">>>2"+aas_auto_status);
			request.setAttribute("auto_status", auto_status);
			request.setAttribute("popuInfo", popuInfo);
		}
		
		forward.setPath("./company/companyPopularityManagement.jsp");
		return forward;	
	}

}
