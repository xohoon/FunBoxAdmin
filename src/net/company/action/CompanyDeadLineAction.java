package net.company.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyDeadLine;


public class CompanyDeadLineAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		System.out.println(" CompanyDeadLineAction 확인");
		
		CompanyDAO companydao = new CompanyDAO();
		ArrayList<CompanyDeadLine> companydeadline = companydao.getMan3List();
		System.out.println("companydeadline : " + companydeadline.toString());		
		request.setAttribute("companydeadline", companydeadline);
		
		forward.setPath("./company/companyDeadLineManagement.jsp");
		return forward;	
	}

}
