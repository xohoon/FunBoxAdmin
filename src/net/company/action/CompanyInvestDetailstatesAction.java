package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;


// 태훈 추가 - 기업등록
public class CompanyInvestDetailstatesAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		String cp_idx = request.getParameter("cp_idx");
		String fund_state = request.getParameter("fund_state");
		String give_state = request.getParameter("give_state");
		String arrears_state = request.getParameter("arrears_state");
		
		boolean result = false;
		
		System.out.println("cp_idx :" +cp_idx);
		System.out.println("fund_state :" +fund_state);
		System.out.println("give_state :" +give_state);
		System.out.println("arrears_state :" +arrears_state);
		
		
		CompanyDAO companyDAO = new CompanyDAO();
		result = companyDAO.statesSave(fund_state, give_state, arrears_state, cp_idx);
		System.out.println("결과값 : " + result);
		
		
		forward.setPath("/companyInvestedList.cp?page=1&funding_status="+fund_state);
		return forward;
	}

}

