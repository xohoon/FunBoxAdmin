package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyDetail;

public class CompanyInvestedDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String cp_idx_string = request.getParameter("cp_idx");
		Integer cp_idx = 0;
		
		try {
			cp_idx = Integer.parseInt(cp_idx_string);
		} catch (NumberFormatException nfe) {
			//error 처리
		}
		
		CompanyDAO companyDAO = new CompanyDAO();
		CompanyDetail companyDetail = new CompanyDetail();
		
		companyDAO.getCompanyDetail(companyDetail, 13);
		
		ActionForward forward = new ActionForward();
		
		//System.out.println(companyDetail);
		
		request.setAttribute("companyDetail", companyDetail);
		
		forward.setRedirect(false);
		forward.setPath("./company/companyInvestedDetail.jsp");
		return forward;
	}

}
