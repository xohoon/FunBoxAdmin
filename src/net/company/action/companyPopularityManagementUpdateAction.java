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
		
		List<Integer> cp_idx_list = new ArrayList<Integer>();
		int ass_idx = Integer.parseInt(request.getParameter("ass_idx"));
		String auto_status_value = (String)request.getParameter("auto_status");
		
		boolean auto_status = false;
		if(auto_status_value.equals("1")) {
			auto_status = true;
		}else {
			auto_status = false;
		}
		
		int cp_idx_1 = Integer.parseInt(request.getParameter("cp_idx_1"));
		int cp_idx_2 = Integer.parseInt(request.getParameter("cp_idx_2"));
		int cp_idx_3 = Integer.parseInt(request.getParameter("cp_idx_3"));
		int cp_idx_4 = Integer.parseInt(request.getParameter("cp_idx_4"));
		int cp_idx_5 = Integer.parseInt(request.getParameter("cp_idx_5"));
		int cp_idx_6 = Integer.parseInt(request.getParameter("cp_idx_6"));
		int cp_idx_7 = Integer.parseInt(request.getParameter("cp_idx_7"));
		int cp_idx_8 = Integer.parseInt(request.getParameter("cp_idx_8"));
		int cp_idx_9 = Integer.parseInt(request.getParameter("cp_idx_9"));
		int cp_idx_10 = Integer.parseInt(request.getParameter("cp_idx_10"));
		cp_idx_list.add(cp_idx_1);
		cp_idx_list.add(cp_idx_2);
		cp_idx_list.add(cp_idx_3);
		cp_idx_list.add(cp_idx_4);
		cp_idx_list.add(cp_idx_5);
		cp_idx_list.add(cp_idx_6);
		cp_idx_list.add(cp_idx_7);
		cp_idx_list.add(cp_idx_8);
		cp_idx_list.add(cp_idx_9);
		cp_idx_list.add(cp_idx_10);
		System.out.println(">>>data:::"+cp_idx_list.size());
		
		CompanyDAO companyDAO = new CompanyDAO();
		companyDAO.insertPopularityManagement(cp_idx_list);
		companyDAO = new CompanyDAO();
		companyDAO.setAutoStatus(ass_idx, auto_status);
		
		forward.setRedirect(false);
		forward.setPath("/companyPopularityManagement.cp");
		return forward;
	}

}
