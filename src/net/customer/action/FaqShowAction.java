package net.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.dao.CustomerDAO;

// 유정 - faq 게시물 활성화/비활성화 하기
public class FaqShowAction implements Action {

	@Override
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		JSONObject jsondata = new JSONObject();
		
		int status = Integer.parseInt(request.getParameter("status"));
		int faq_idx = Integer.parseInt(request.getParameter("faq_idx"));
		
		CustomerDAO ct_dao = new CustomerDAO();
		boolean result = ct_dao.faqShow(status, faq_idx);
		
		if(result) {
			jsondata.put("result", "faqShow_success");
		}else {
			jsondata.put("result", "faqShow_fail");
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(jsondata);
    	
		return null;
	}

}
