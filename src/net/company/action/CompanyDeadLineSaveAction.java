package net.company.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyDeadLine;


public class CompanyDeadLineSaveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		boolean result = false;
		boolean transval = false;
		boolean states = false;
		// 조건문 달아주기 DAO 너무 많음
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		System.out.println(" CompanyDeadLineSaveAction 확인");
		// 자동 : 1 , 수동 : 0
		String radioVal = request.getParameter("radioVal");
		
		if(radioVal.equals("1")) {
			transval = true;
		}else {
			transval = false;
		}
		
		String cp_idx_1 = request.getParameter("cp_idx_1");
		String cp_idx_2 = request.getParameter("cp_idx_2");
		String cp_idx_3 = request.getParameter("cp_idx_3");
		System.out.println(radioVal);
		System.out.println("cp_idx_1 : " + cp_idx_1);
		System.out.println("cp_idx_2 : " + cp_idx_2);
		System.out.println("cp_idx_3 : " + cp_idx_3);
		
		CompanyDAO companydao_update = new CompanyDAO();		
		states = companydao_update.setAutoStatus(3, transval);
		System.out.println(states);
		/*
		 * if() { if(radioVal.equals("1")) { // 자동일때 CompanyDAO companydao = new
		 * CompanyDAO(); ArrayList<CompanyDeadLine> transDeadLineList =
		 * companydao.getAuto_ManDeadLineSearchList(radioVal, "0");
		 * System.out.println("transDeadLineList[자동] :" + transDeadLineList.toString());
		 * CompanyDAO companydao_auto = new CompanyDAO(); result =
		 * companydao_auto.insertAutoManDeadLineList(transDeadLineList);
		 * System.out.println("결과 값 확인 :" + result);
		 * 
		 * }else if(radioVal.equals("0")) {// 수동일때 CompanyDAO companydao1 = new
		 * CompanyDAO(); ArrayList<CompanyDeadLine> transDeadLineList1 =
		 * companydao1.getAuto_ManDeadLineSearchList(radioVal, "cp_idx_1");
		 * System.out.println("transDeadLineList[수동] :" +
		 * transDeadLineList1.toString()); CompanyDAO companydao_auto1 = new
		 * CompanyDAO(); result =
		 * companydao_auto1.insertAutoManDeadLineList(transDeadLineList1);
		 * System.out.println("결과 값 확인 1:" + result);
		 * 
		 * CompanyDAO companydao2 = new CompanyDAO(); ArrayList<CompanyDeadLine>
		 * transDeadLineList2 = companydao1.getAuto_ManDeadLineSearchList(radioVal,
		 * "cp_idx_2"); System.out.println("transDeadLineList[수동] :" +
		 * transDeadLineList2.toString()); CompanyDAO companydao_auto2 = new
		 * CompanyDAO(); result =
		 * companydao_auto2.insertAutoManDeadLineList(transDeadLineList2);
		 * System.out.println("결과 값 확인 2:" + result);
		 * 
		 * CompanyDAO companydao3 = new CompanyDAO(); ArrayList<CompanyDeadLine>
		 * transDeadLineList3 = companydao1.getAuto_ManDeadLineSearchList(radioVal,
		 * "cp_idx_3"); System.out.println("transDeadLineList[수동] :" +
		 * transDeadLineList3.toString()); CompanyDAO companydao_auto3 = new
		 * CompanyDAO(); result =
		 * companydao_auto3.insertAutoManDeadLineList(transDeadLineList3);
		 * System.out.println("결과 값 확인 3:" + result); }
		 * 
		 * }else if(states.equals("fail")) {
		 * System.out.println(" companydao_update 실패 하였습니다."); }
		 */
		// cp_idx 값으로 기업 찾기		
		forward.setPath("./company/companyDeadLineManagement.jsp");
		return forward;
	}

}
