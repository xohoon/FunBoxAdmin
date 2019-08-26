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
		boolean result = false;
		
		// 조건문 달아주기 DAO 너무 많음
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		System.out.println(" CompanyDeadLineSaveAjaxAction 확인");
		// 자동 : 1 , 수동 : 0
		String radioVal = request.getParameter("radioVal");
		System.out.println(radioVal);
		
		// cp_idx 값으로 기업 찾기 
		CompanyDAO companydao = new CompanyDAO();
		ArrayList<CompanyDeadLine> transDeadLineList = companydao.getAuto_ManDeadLineSearchList(radioVal, "11");
		System.out.println("transDeadLineList :" + transDeadLineList.toString());
		
		//insert 구현
		CompanyDAO companydao1 = new CompanyDAO();
		result = companydao1.insertAutoManDeadLineList(transDeadLineList);
		
		//System.out.println("transDeadLineList :" + transDeadLineList.get(0).getMb_id());
		
		forward.setPath("./company/companyDeadLineManagement.jsp");
		return forward;
	}

}
