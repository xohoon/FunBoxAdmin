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
import net.finance.action.TokenExchangeListAction;
import net.finance.action.TokenWithdrawalListAction;
import net.finance.action.tokenWithdrawalSearchAction;

@WebServlet("/FinanceController")
public class FinanceController extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 1L;
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println(command);
		try {
			switch (command) { // 포인트환전내역
			case "/tokenExchangeList.fn":
				action = new TokenExchangeListAction();
				forward = action.execute(request, response);
				break;
			case "/tokenWithdrawalList.fn": //토큰입출내역
				action = new TokenWithdrawalListAction();
				forward = action.execute(request, response);
				break;
			case "/tokenWithdrawalSearch.fn": //검색 출력
				action = new tokenWithdrawalSearchAction();
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
