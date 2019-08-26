package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;

// 태훈 - 실시간 수동 데이터 가져오기
public class CompanyPopularityInfoAjax implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		@SuppressWarnings("unused")
		ActionForward forward = new ActionForward();
		
		String setting = request.getParameter("setting");
		
		CompanyDAO comapnyDAO = new CompanyDAO();
		JSONArray realList = comapnyDAO.getCompanyPopularityList();
		System.out.println(">>data:::"+realList.size());
		
		response.setContentType("application/x-json;charset=UTF-8");
		response.getWriter().print(realList);
		
		return null;
	}

}
