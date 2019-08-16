package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;

public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); 
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/memberDetail.jsp");
		return forward;
	}

}
