package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.admin.dao.AdminDAO;
import net.admin.dto.IndexNeeds;
import net.common.action.Action;
import net.common.action.ActionForward;

public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		IndexNeeds indexNeeds = new IndexNeeds();
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.setIndexNeeds(indexNeeds);
	
		request.setAttribute("indexNeeds", indexNeeds);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("index.jsp");
		return forward;
	}

}
