package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyApplicationDetail;

public class CompanyInvestApplyDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String app_cp_idx_string = request.getParameter("app_cp_idx");
		Integer app_cp_idx = 0;
		
		if (app_cp_idx_string != null) {
			try {
				app_cp_idx = Integer.parseInt(app_cp_idx_string);
			} catch (NumberFormatException nfe) {
				//error processing
			}
		}
		
		CompanyDAO companyDAO = new CompanyDAO();
		CompanyApplicationDetail companyApplicationDetail = companyDAO.getCompanyApplicationDetail(app_cp_idx);
		
		request.setAttribute("companyApplicationDetail", companyApplicationDetail);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./company/companyInvestApplyDetail.jsp");
		return forward;
	}

}
