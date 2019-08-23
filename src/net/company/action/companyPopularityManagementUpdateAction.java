package net.company.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyPopularityList;

// 태훈 - 실시간 수동 데이터 입력
public class companyPopularityManagementUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		System.out.println("어디까지오니");
		int cp_idx_2 = (Integer)request.getAttribute("1");
		int cp_idx_1 = Integer.parseInt(request.getParameter("1"));
		System.out.println(">>1"+cp_idx_1);
		System.out.println(">>1"+cp_idx_2);
		
		forward.setRedirect(false);
		forward.setPath("./companyPopularityManagement.cp");
		return forward;
	}

}
