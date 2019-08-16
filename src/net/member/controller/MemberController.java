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
import net.member.action.MemberDetailAction;
import net.member.action.MemberInvestedListAction;
import net.member.action.MemberListAction;
import net.member.action.MemberRegisterAction;

@WebServlet("/MemberController")
public class MemberController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		try {
			switch (command) {
			case "memberList.mb":
				action = new MemberListAction(); // 회원리스트
				forward = action.execute(request, response);
				break;
			case "memberDetail.mb":
				action = new MemberDetailAction(); // 회원정보 상세보기 및 수정
				forward = action.execute(request, response);
				break;
			case "memberInvestedList.mb": // 투자내역
				action = new MemberInvestedListAction();
				forward = action.execute(request, response);
				break;			
			case "memberRegister.mb": // 회원등록
				action = new MemberRegisterAction(); 
				forward = action.execute(request, response);
				break;			
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		///////////////////////윤식 추가 end///////////////////////
		
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
