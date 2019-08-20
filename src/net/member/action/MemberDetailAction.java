package net.member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;
import net.member.dto.Member;
import net.member.dto.MemberLateInvested;

public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String mb_idx_string = request.getParameter("mb_idx");
		Integer mb_idx = 0;
		
		try {
			mb_idx = Integer.parseInt(mb_idx_string);
		} catch (NumberFormatException nfe) {
			mb_idx = 0;
		}
		
		Member member;
		List<MemberLateInvested> memberLateInvestedList;
		
		MemberDAO memberDAO = new MemberDAO();
		member = memberDAO.getMember(mb_idx);
		
		memberDAO = new MemberDAO();
		memberLateInvestedList = memberDAO.getMemberLateInvestedList(mb_idx);
		
		
		request.setAttribute("member", member);
		request.setAttribute("memberLateInvestedList", memberLateInvestedList);
		request.setAttribute("mb_idx", mb_idx);
		
		forward.setRedirect(false);
		forward.setPath("./member/memberDetail.jsp");
		return forward;
	}

}
