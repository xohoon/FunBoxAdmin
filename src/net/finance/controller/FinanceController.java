package net.finance.controller;

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

import net.finance.action.MemberInvestedListAction;
import net.finance.action.TokenExchangeListAction;
import net.finance.action.TokenWithdrawalListAction;

@WebServlet("/FinanceController")
public class FinanceController extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 1L;
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8"); 
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println(command);
		try {
			switch (command) { // �룷�씤�듃�솚�쟾�궡�뿭
			case "/tokenExchangeList.fn":
				action = new TokenExchangeListAction();
				forward = action.execute(request, response);
				break;
			case "/tokenWithdrawalList.fn": //
				action = new TokenWithdrawalListAction();
				forward = action.execute(request, response);
				break;
			case "/memberInvestedList.fn": // 투자내역 관리 윤식 추가
				action = new MemberInvestedListAction();
				forward = action.execute(request, response);
				break;				
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
