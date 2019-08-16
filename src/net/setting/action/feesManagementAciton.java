package net.setting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;

public class feesManagementAciton implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); 
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./setting/feesManagement.jsp");
		return forward;
	}

}
