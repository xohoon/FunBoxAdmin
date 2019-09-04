package net.company.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.Company;

public class CompanyAllListAction implements Action {
/////
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String search_type_string = request.getParameter("search_type");
		String search_word = request.getParameter("search_word");
		String category_string = request.getParameter("category");
		
		boolean search_type = false;
		Integer category = 0;
		
		if (search_type_string != null) {
			try {
				if (Integer.parseInt(search_type_string) > 0) {
					search_type = true;
				}
			} catch (NumberFormatException nfe) {
				search_type = false;
			}			
		}
		
		if (category_string != null) {
			try {
				category = Integer.parseInt(category_string);
			} catch (NumberFormatException nfe) {
				category = 0;
			}
		}
		
		List<Company> companyList = new ArrayList<Company>();
		
		CompanyDAO companyDAO = new CompanyDAO();
		companyDAO.getCompanyAllList(companyList, search_type, search_word, category);
		if (companyList.size() < 1) {

		}
		
		request.setAttribute("search_type", search_type);
		request.setAttribute("search_word", search_word);
		request.setAttribute("companyList", companyList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./company/companyAllList.jsp");
		return forward;
	}

}
