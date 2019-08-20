package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.json.MemberJson;
import net.member.dto.Member;

public class ModifyMemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberJson memberJson = new MemberJson();
		Member member = new Member();

		String mb_idx_string = request.getParameter("mb_idx");
		Integer mb_idx = 0;
		
		try {
			mb_idx = Integer.parseInt(mb_idx_string);
		} catch (NumberFormatException nfe) {
			//Exception processing
		}
		
		String mb_name = request.getParameter("mb_name");
		String mb_id = request.getParameter("mb_id");
		String mb_email = request.getParameter("mb_email");
		String mb_phone = request.getParameter("mb_phone");
		String mb_add_num = request.getParameter("mb_add_num");
		String mb_add_ch = request.getParameter("mb_add_ch");
		String mb_add_more = request.getParameter("mb_add_more");
		String mb_add_extra = request.getParameter("mb_add_extra");
		String mb_recommend = request.getParameter("mb_recommend");
		String mb_point = request.getParameter("mb_point");
		String mb_token = request.getParameter("mb_token");
		
		member.setMb_idx(mb_idx);
		
		member.setMb_name(mb_name);
		member.setMb_id(mb_id);
		member.setMb_email(mb_email);
		member.setMb_phone(mb_phone);
		member.setMb_add_num(mb_add_num);
		member.setMb_add_ch(mb_add_ch);
		member.setMb_add_more(mb_add_more);
		member.setMb_add_extra(mb_add_extra);
		member.setMb_recommend(mb_recommend);
		member.setMb_point(mb_point);
		member.setMb_token(mb_token);

		JSONObject jsonObject = memberJson.modifyMemberResult(member);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jsonObject);

		return null;
	}

}
