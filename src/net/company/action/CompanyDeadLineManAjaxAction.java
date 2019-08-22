package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;


public class CompanyDeadLineManAjaxAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		@SuppressWarnings("unused")
		
		String category = request.getParameter("category");
		
		System.out.println("category :"+category);
		
		CompanyDAO companydao = new CompanyDAO();
		JSONArray Man3list = companydao.getMan3List(category);
		
		response.setContentType("application/x-json;charset=UTF-8");
		response.getWriter().print(Man3list);
				
		return null;
	}

}
