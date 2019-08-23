package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;


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
		
		if(radioVal.equals("0")) { // 수동일때
			//해당 쿼리문 돌기
			CompanyDAO companydao = new CompanyDAO();
			
		}else if(radioVal.equals("1")) { // 자동일때
			CompanyDAO companydao = new CompanyDAO();
		
		}
				
		forward.setPath("./company/companyDeadLineManagement.jsp");
		return forward;
	}

}
