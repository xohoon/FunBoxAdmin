package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import net.admin.dao.AdminDAO;
import net.common.action.Action;
import net.common.action.ActionForward;

//태훈 추가 - 관리자 로그인 아이디/비밀번호 체크 Action
public class LoginCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		JSONObject jsonObj = new JSONObject();
		HttpSession session = request.getSession();
		String adminIdCk = (String)request.getParameter("adminId"); 
		String adminPwCk = (String)request.getParameter("adminPw"); 
		int result = -1;
		if(adminIdCk != null && adminPwCk != null) {
			AdminDAO adminDAO = new AdminDAO();
			result = adminDAO.AdminLoginCheck(adminIdCk, adminPwCk);
			if(result == 0) {
				// 비밀번호 불일치
				jsonObj.put("result", 0);
			}else if(result == 1) {
				// 비밀번호 일치
				jsonObj.put("result", 1);
				session.setAttribute("adminId", adminIdCk);
			}else {
				// 아이디 없음
				jsonObj.put("result", -1);
			}
		}
		response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(jsonObj);
		return null;
	}

}
