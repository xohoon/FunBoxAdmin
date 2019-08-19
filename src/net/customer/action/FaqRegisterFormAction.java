package net.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.dao.CustomerDAO;
import net.customer.dto.FaqBoard;

// 유정 추가
public class FaqRegisterFormAction implements Action {

	@Override
	@SuppressWarnings("unchecked")
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); //한글처리
		FaqBoard faq = new FaqBoard();
		JSONObject jsondata = new JSONObject();
		
		int category = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		faq.setCategory(category);
		faq.setTitle(title);
		faq.setContent(content);
		
		CustomerDAO ct_dao = new CustomerDAO();
		boolean result = ct_dao.faqRegister(faq);
		
		if(result) {
			jsondata.put("result", "register_success");
		}else {
			jsondata.put("result", "register_fail");
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(jsondata);
    	
		return null;
	}

}
