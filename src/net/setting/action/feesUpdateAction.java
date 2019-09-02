package net.setting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.setting.dao.SettingDAO;
// 태훈 추가 - 수수료 수정Action
public class feesUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); 
		
		JSONObject jsonObj = new JSONObject();
		SettingDAO settingDAO = new SettingDAO();
		boolean result = false;
		String fees = (String)request.getParameter("update_fees");
		if(fees != null) {
			result = settingDAO.FeesUpdate(fees);
			if(result == true) {
				jsonObj.put("result", 1);
			}else if(result == false) {
				jsonObj.put("result", 0);
			}
		}else {
			System.out.println("ERROR ::: fees value is null. check please");
		}
		
		response.setContentType("application/x-json; charset=UTF-8");
    	response.getWriter().print(jsonObj);
		return null;
	}

}
