package net.company.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyPopularityList;

public class companyPopularityManagementUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setCharacterEncoding("utf-8"); //�ѱ�ó��
		ActionForward forward = new ActionForward();
		
		CompanyPopularityList popularity = new CompanyPopularityList();
		List<CompanyPopularityList> popuList = new ArrayList<CompanyPopularityList>();
		CompanyDAO companyDAO = new CompanyDAO();
		popuList = companyDAO.getCompanyPopularityList();
		
		forward.setRedirect(false);
		forward.setPath("./company/companyPopularityManagement.jsp");
		return forward;
	}

}
