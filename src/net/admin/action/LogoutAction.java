package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.common.action.Action;
import net.common.action.ActionForward;

// 태훈 - 관리자 로그아웃 세션삭제
public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		String adminId = (String)session.getAttribute("adminId");
		session.setAttribute("adminId", null);
		adminId = (String)session.getAttribute("adminId");
		session.invalidate();
		forward.setRedirect(false);
		forward.setPath("/loginForm.ad");
		return forward;
	}
}
