package net.finance.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.finance.dao.FinanceDAO;

public class tokenWithdrawalSearchAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		@SuppressWarnings("unused")
		
		ActionForward forward = new ActionForward();
		FinanceDAO financeDao = new FinanceDAO();
		String categroyFlag = "3";
		String category = "3";
		
		String searchID = request.getParameter("searchID");
				
		System.out.println("ID" + searchID);
		JSONArray search_list = financeDao.Search_ID_List(searchID);
		
		response.setContentType("application/x-json;charset=UTF-8");
		response.getWriter().print(search_list);
		
		forward.setRedirect(false);
		forward.setPath("./finance/tokenWithdrawalList.jsp");
		request.setAttribute("categroyFlag", categroyFlag);
		request.setAttribute("category", category);
		return null;
	}

}
