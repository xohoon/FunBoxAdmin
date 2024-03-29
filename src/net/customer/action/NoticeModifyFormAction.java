package net.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.dao.CustomerDAO;
import net.customer.dto.NoticeBoard;

public class NoticeModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		int notice_idx = Integer.parseInt(request.getParameter("idx"));
		
		CustomerDAO ct_dao = new CustomerDAO();
		NoticeBoard notice = ct_dao.noticeDetail(notice_idx);
		
		request.setAttribute("notice", notice);
		
		forward.setRedirect(false);
		forward.setPath("./customer/noticeModifyForm.jsp");
		return forward;
	}

}
