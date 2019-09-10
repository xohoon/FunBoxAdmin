package net.company.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyBean;

public class CompanyInvestDetailFundedAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		CompanyBean company = new CompanyBean();		
		int cp_idx = 1;
		
		try {
			String idx = request.getParameter("cp_idx");
			cp_idx = Integer.parseInt(idx);
		}catch(NumberFormatException e) {
			System.out.println("NumberFormatException 에러: " + e);
		}
		
		CompanyDAO company_dao = new CompanyDAO();
		company = company_dao.getCompanyInfo2(cp_idx);

		request.setAttribute("companyBean", company);
		
		forward.setRedirect(false);
		forward.setPath("./company/companyInvestDetailFunded.jsp");
		return forward;
	}

}
