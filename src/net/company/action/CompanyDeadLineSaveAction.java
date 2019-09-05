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
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		System.out.println(" CompanyDeadLineSaveAction 확인");
		// 자동 : 1 , 수동 : 0
		String radioVal = request.getParameter("radioVal");
		System.out.println("push 확인 : " + radioVal);
		
		if(radioVal.equals("1")) {
			transval = true;
			System.out.println(transval);
		}else {
			transval = false;
			System.out.println(transval);
		}
		
		String cp_idx_1 = request.getParameter("cp_idx_1");
		String cp_idx_2 = request.getParameter("cp_idx_2");
		String cp_idx_3 = request.getParameter("cp_idx_3");
		System.out.println(radioVal);
		
		System.out.println("cp_idx_1 : " + cp_idx_1);
		System.out.println("cp_idx_2 : " + cp_idx_2);
		System.out.println("cp_idx_3 : " + cp_idx_3);
		
		// admin table 관리 업데이트
		CompanyDAO companydao_update = new CompanyDAO();		
		states = companydao_update.setAutoStatus(3, transval);
		
		// 테이블 비우기
		CompanyDAO companydao_deletetable = new CompanyDAO();
		companydao_deletetable.deletetalbe();
		
				
		 if(states) { 
			 if(radioVal.equals("1")) { //자동일때  				 
				 CompanyDAO companydao_auto = new CompanyDAO(); 
				 result = companydao_auto.insertAutoManDeadLineList(radioVal, "0");
				 System.out.println("결과 값 확인 :" + result);		
				 
			 }else if(radioVal.equals("0")) {// 수동일때 
				 CompanyDAO companydao_auto1 = new CompanyDAO(); 
				 result = companydao_auto1.insertAutoManDeadLineList(radioVal, cp_idx_1);
				 System.out.println("결과 값 확인 1:" + result);
			   
				 CompanyDAO companydao_auto2 = new CompanyDAO(); 
				 result = companydao_auto2.insertAutoManDeadLineList(radioVal, cp_idx_2);
				 System.out.println("결과 값 확인 2:" + result);
			 
				 CompanyDAO companydao_auto3 = new CompanyDAO(); 
				 result = companydao_auto3.insertAutoManDeadLineList(radioVal, cp_idx_3);
				 System.out.println("결과 값 확인 3:" + result); 			
		 	}
		 }else{
			 System.out.println(" companydao_update 실패 하였습니다."); 
		 }
		 
		 
		// cp_idx 값으로 기업 찾기		
		forward.setPath("/companyDeadLineManagement.cp");
		return forward;
	}

}
