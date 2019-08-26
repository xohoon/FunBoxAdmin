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
		List<String> cp_name_list = new ArrayList<String>();
		List<String> mb_id_list = new ArrayList<String>();
		List<String> manager_name_list = new ArrayList<String>();
		
		int cp_idx_1 = Integer.parseInt(request.getParameter("1"));
		int cp_idx_2 = Integer.parseInt(request.getParameter("2"));
		int cp_idx_3 = Integer.parseInt(request.getParameter("3"));
		int cp_idx_4 = Integer.parseInt(request.getParameter("4"));
		int cp_idx_5 = Integer.parseInt(request.getParameter("5"));
		int cp_idx_6 = Integer.parseInt(request.getParameter("6"));
		int cp_idx_7 = Integer.parseInt(request.getParameter("7"));
		int cp_idx_8 = Integer.parseInt(request.getParameter("8"));
		int cp_idx_9 = Integer.parseInt(request.getParameter("9"));
		int cp_idx_10 = Integer.parseInt(request.getParameter("10"));
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
		
		String cp_name_1 = request.getParameter("cp_name_1");
		String cp_name_2 = request.getParameter("cp_name_1");
		String cp_name_3 = request.getParameter("cp_name_1");
		String cp_name_4 = request.getParameter("cp_name_1");
		String cp_name_5 = request.getParameter("cp_name_1");
		String cp_name_6 = request.getParameter("cp_name_1");
		String cp_name_7 = request.getParameter("cp_name_1");
		String cp_name_8 = request.getParameter("cp_name_1");
		String cp_name_9 = request.getParameter("cp_name_1");
		String cp_name_10 = request.getParameter("cp_name_1");
		cp_name_list.add(cp_name_1);
		cp_name_list.add(cp_name_2);
		cp_name_list.add(cp_name_3);
		cp_name_list.add(cp_name_4);
		cp_name_list.add(cp_name_5);
		cp_name_list.add(cp_name_6);
		cp_name_list.add(cp_name_7);
		cp_name_list.add(cp_name_8);
		cp_name_list.add(cp_name_9);
		cp_name_list.add(cp_name_10);
		
		String mb_id_1 = request.getParameter("mb_id_1");
		String mb_id_2 = request.getParameter("mb_id_1");
		String mb_id_3 = request.getParameter("mb_id_1");
		String mb_id_4 = request.getParameter("mb_id_1");
		String mb_id_5 = request.getParameter("mb_id_1");
		String mb_id_6 = request.getParameter("mb_id_1");
		String mb_id_7 = request.getParameter("mb_id_1");
		String mb_id_8 = request.getParameter("mb_id_1");
		String mb_id_9 = request.getParameter("mb_id_1");
		String mb_id_10 = request.getParameter("mb_id_1");
		mb_id_list.add(mb_id_1);
		mb_id_list.add(mb_id_2);
		mb_id_list.add(mb_id_3);
		mb_id_list.add(mb_id_4);
		mb_id_list.add(mb_id_5);
		mb_id_list.add(mb_id_6);
		mb_id_list.add(mb_id_7);
		mb_id_list.add(mb_id_8);
		mb_id_list.add(mb_id_9);
		mb_id_list.add(mb_id_10);
		
		String manager_name_1 = request.getParameter("manager_name_1");
		String manager_name_2 = request.getParameter("manager_name_1");
		String manager_name_3 = request.getParameter("manager_name_1");
		String manager_name_4 = request.getParameter("manager_name_1");
		String manager_name_5 = request.getParameter("manager_name_1");
		String manager_name_6 = request.getParameter("manager_name_1");
		String manager_name_7 = request.getParameter("manager_name_1");
		String manager_name_8 = request.getParameter("manager_name_1");
		String manager_name_9 = request.getParameter("manager_name_1");
		String manager_name_10 = request.getParameter("manager_name_1");
		manager_name_list.add(manager_name_1);
		manager_name_list.add(manager_name_2);
		manager_name_list.add(manager_name_3);
		manager_name_list.add(manager_name_4);
		manager_name_list.add(manager_name_5);
		manager_name_list.add(manager_name_6);
		manager_name_list.add(manager_name_7);
		manager_name_list.add(manager_name_8);
		manager_name_list.add(manager_name_9);
		manager_name_list.add(manager_name_10);
		
		CompanyDAO companyDAO = new CompanyDAO();
		companyDAO.insertPopularityManagement(cp_idx_list);
		
		forward.setRedirect(false);
		forward.setPath("./companyPopularityManagement.cp");
		return forward;
	}

}
