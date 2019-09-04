package net.member.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Member;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.dao.MemberDAO;


public class MemberRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		
		String mb_idx_string = request.getParameter("mb_idx");
		Integer mb_idx = 0;
		System.out.println("MemberRemoveAction 확인");
		System.out.println("mb_idx 확인");
		boolean result = false;
		
		try {
			mb_idx = Integer.parseInt(mb_idx_string);
		} catch (NumberFormatException nfe) {
			mb_idx = 0;
		}
		
		MemberDAO memberdao = new MemberDAO();
		result = memberdao.remonveupdate(mb_idx);
		System.out.println("result : " + result);
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("window.close();");
		out.println("opener.location.replace('memberList.mb')");
		out.println("</script>");		
		out.close();
		
		return null;
	}

}
