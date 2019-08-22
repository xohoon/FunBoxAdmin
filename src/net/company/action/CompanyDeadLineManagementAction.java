package net.company.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.Company;

public class CompanyDeadLineManagementAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String search_type_string = request.getParameter("search_type");
		String search_word = request.getParameter("search_word");
		
		Integer search_type = 0;
		
		if (search_type_string != null) {
			try {
				search_type = Integer.parseInt(search_type_string);
			} catch (NumberFormatException nfe) {
				search_type = 0;
			}
			if (search_type > 1) {
				search_type = 0;
			}
		}
		
		List<Company> companyList = new ArrayList<Company>();
		
		CompanyDAO companyDAO = new CompanyDAO();
		companyDAO.getCompanyAllList(companyList, search_type, search_word);
		
		if (companyList.size() < 1) {

		}
		
		request.setAttribute("search_type", search_type);
		request.setAttribute("search_word", search_word);
		request.setAttribute("companyList", companyList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setRedirect(false);
		forward.setPath("./company/companyDeadLineManagement.jsp");
		return forward;
	}

}
