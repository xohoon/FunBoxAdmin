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
		System.out.println(" CompanyDeadLineAction 확인");
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		int aas_auto_status = 0;
		
		
		
		CompanyDAO companydao1 = new CompanyDAO();
		aas_auto_status = companydao1.auto_mancheck();
		System.out.println("aas_auto_status : " + aas_auto_status);
		
		CompanyDAO companydao2 = new CompanyDAO();
		ArrayList<CompanyDeadLine> companydeadline = companydao2.getMan3List();
		System.out.println("companydeadline : " + companydeadline.toString());
		
		request.setAttribute("companydeadline", companydeadline);
		request.setAttribute("aas_auto_status", new Integer(aas_auto_status));
		
		
		forward.setRedirect(false);
		forward.setPath("./company/companyDeadLineManagement.jsp");
		return forward;	
	}

}
