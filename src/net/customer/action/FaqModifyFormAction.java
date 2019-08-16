package net.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.dao.CustomerDAO;

public class FaqModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		int faq_idx = Integer.parseInt(request.getParameter("idx"));
		
		CustomerDAO customer_dao = new CustomerDAO();
		
		forward.setRedirect(false);
		forward.setPath("./customer/faqModifyForm.jsp");
		return forward;
	}

}
