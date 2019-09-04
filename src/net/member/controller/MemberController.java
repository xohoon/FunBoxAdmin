package net.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.member.action.CheckDuplicationIDAction;
import net.member.action.MemberDetailAction;
import net.member.action.MemberListAction;
import net.member.action.MemberRegisterAction;
import net.member.action.MemberRemoveAction;
import net.member.action.ModifyMemberAction;
import net.member.action.RegisteMemberAction;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		try {
			switch (command) {
			case "/memberList.mb":
				action = new MemberListAction(); // �쉶�썝由ъ뒪�듃
				forward = action.execute(request, response);
				break;
			case "/memberDetail.mb":
				action = new MemberDetailAction(); // �쉶�썝�젙蹂� �긽�꽭蹂닿린 諛� �닔�젙
				forward = action.execute(request, response);
				break;
			case "/memberRemove.mb":
				action = new MemberRemoveAction(); // �쉶�썝由ъ뒪�듃
				forward = action.execute(request, response);
				break;
			case "/memberRegisterForm.mb": // �쉶�썝�벑濡�
				action = new MemberRegisterAction(); 
				forward = action.execute(request, response);
				break;
			case "/registeMember.mb": // �쉶�썝�벑濡�
				//ajax 통신
				action = new RegisteMemberAction(); 
				forward = action.execute(request, response);
				break;
			case "/modifyMember.mb":
				//ajax 통신
				action = new ModifyMemberAction();
				forward = action.execute(request, response);
				break;
			case "/CheckDuplicationID.mb":
				//ajax 통신
				action = new CheckDuplicationIDAction();
				forward = action.execute(request, response);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		///////////////////////�쑄�떇 異붽� end///////////////////////
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
