package net.company.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyAdded;

public class CompanyRecomnandManagementAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CompanyDAO companyDAO = new CompanyDAO();
		//추천 기업  자동 상태 들고오기
		boolean auto_status = companyDAO.getAutoStatus(2);
		companyDAO = new CompanyDAO();
		
		List<CompanyAdded> companyAddedList = new ArrayList<CompanyAdded>();
		companyDAO.getCompanyAddedList(companyAddedList, 2);
		
		ActionForward forward = new ActionForward();
		
		request.setAttribute("auto_status", auto_status);
		request.setAttribute("companyAddedList", companyAddedList);
		request.setAttribute("aas_idx", 2);
		
		forward.setRedirect(false);
		forward.setPath("./company/companyRecomnandManagement.jsp");
		return forward;
	}

}
