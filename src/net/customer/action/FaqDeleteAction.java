package net.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.dao.CustomerDAO;

public class FaqDeleteAction implements Action {

	@Override
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		JSONObject jsondata = new JSONObject();
		int faq_idx = Integer.parseInt(request.getParameter("faq_idx"));

		CustomerDAO ct_dao = new CustomerDAO();
		boolean result = ct_dao.faqDelete(faq_idx);
		
		if(result) {
			jsondata.put("result", "faqDelete_success");
		}else {
			jsondata.put("result", "faqDelete_fail");
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(jsondata);
		
		return null;
	}

}
