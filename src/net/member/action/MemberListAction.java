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

		String page_string = request.getParameter("page");
		String search_type_string = request.getParameter("search_type");
		String search_word = request.getParameter("search_word");
		
		Integer page = 0;
		Integer search_type = 0;

		if (page_string == null) {
			page = 1;
		} else {
			try {
				page = Integer.parseInt(page_string);
			} catch (NumberFormatException nfe) {
				page = 0;
			}
			if (page < 1) {
				page = 1;
			}
		}

		if (search_type_string != null) {
			try {
				search_type = Integer.parseInt(search_type_string);
			} catch (NumberFormatException nfe) {
				search_type = 0;
			}
			if (search_type > 4) {
				search_type = 0;
			}
		}

		List<Member> memberList = new ArrayList<Member>();
		Paging paging = new Paging();

		MemberDAO memberDAO = new MemberDAO();
		memberDAO.getMemberList(memberList, page, search_type, search_word, paging);

		// 잘 못된 접근
		if (memberList.size() < 1) {

		}

		if (paging.getMax_page() < page) {
			request.setAttribute("current_page", paging.getMax_page());
		} else {
			request.setAttribute("current_page", page);
		}
		
		request.setAttribute("current_min_page", paging.getCurrent_min_page());
		request.setAttribute("current_max_page", paging.getCurrent_max_page());
		request.setAttribute("max_page", paging.getMax_page());
		request.setAttribute("search_type", search_type);
		request.setAttribute("search_word", search_word);
		request.setAttribute("memberList", memberList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/memberList.jsp");
		
		return forward;
	}

}
