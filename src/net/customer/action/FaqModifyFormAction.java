
package net.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.dao.CustomerDAO;
import net.customer.dto.FaqBoard;

// 유정 추가
public class FaqModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		int faq_idx = Integer.parseInt(request.getParameter("idx"));
		
		CustomerDAO ct_dao = new CustomerDAO();
		FaqBoard faq = ct_dao.faqDetail(faq_idx);
		
		request.setAttribute("faq", faq);
		
		forward.setRedirect(false);
		forward.setPath("./customer/faqModifyForm.jsp");
		return forward;
	}

}
