package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.json.MemberJson;

public class CheckDuplicationIDAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		MemberJson memberJson = new MemberJson();

		String mb_id = request.getParameter("mb_id");

		JSONObject jsonObject = memberJson.getCheckDuplicateIDResult(mb_id);

		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jsonObject);

		return null;
	}

}
