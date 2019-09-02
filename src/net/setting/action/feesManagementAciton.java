package net.setting.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.setting.dao.SettingDAO;

public class feesManagementAciton implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8"); 
		ActionForward forward = new ActionForward();
		SettingDAO settingDAO = new SettingDAO();
		String fees = settingDAO.getFees();
		request.setAttribute("fees", fees);
		forward.setRedirect(false);
		forward.setPath("./setting/feesManagement.jsp");
		return forward;
	}

}
