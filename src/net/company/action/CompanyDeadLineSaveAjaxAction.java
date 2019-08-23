package net.company.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyDeadLine;


public class CompanyDeadLineSaveAjaxAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		System.out.println(" CompanyDeadLineSaveAjaxAction 확인");
		// 자동 : 1 , 수동 : 0
		String radioVal = request.getParameter("radioVal");
		System.out.println(radioVal);
		
		CompanyDAO companydao = new CompanyDAO();
		ArrayList<CompanyDeadLine> transDeadLineList = companydao.getAuto_ManDeadLineSearchList(radioVal, "");
		System.out.println("transDeadLineList :" + transDeadLineList.toString());	
				
		forward.setPath("./company/companyDeadLineManagement.jsp");
		return forward;
	}

}
