package net.member.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.Member;
import net.util.Paging;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		String page_string = request.getParameter("page");
		Integer page = 0;
		
		if (page_string == null) {
			page = 1;
		}else {
			page = Integer.parseInt(page_string);
		}
		
		if (page < 1) {
			page = 1;
		}
		
		
		List<Member> memberList = new ArrayList<Member>();
		Paging paging = new Paging();
		
		
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.getMemberList(memberList,page,paging);

		// 잘 못된 접근
		if (memberList.size() < 1) {

		}
		
		if (paging.getMax_page() < page) {
			request.setAttribute("current_page", paging.getMax_page());
		}else {
			request.setAttribute("current_page", page);
		}
		request.setAttribute("current_min_page", paging.getCurrent_min_page());
		request.setAttribute("current_max_page", paging.getCurrent_max_page());
		request.setAttribute("max_page", paging.getMax_page());
		request.setAttribute("memberList", memberList);

		forward.setRedirect(false);
		forward.setPath("./member/memberList.jsp");
		return forward;
	}

}
