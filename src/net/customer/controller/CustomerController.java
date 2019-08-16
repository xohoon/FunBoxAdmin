package net.customer.controller;

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
import net.customer.action.FaqBoardAction;
import net.customer.action.FaqModifyFormAction;
import net.customer.action.FaqRegisterFormAction;
import net.customer.action.InquiryAnswerFormAction;
import net.customer.action.InquiryBoardAction;
import net.customer.action.NoticeBoardAction;
import net.customer.action.NoticeModifyFormAction;
import net.customer.action.NoticeRegisterFormAction;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet implements Servlet{
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
			case "FaqBoard.cu":
				action = new FaqBoardAction();
				forward = action.execute(request, response);
				break;
			case "FaqModifyForm.cu":
				action = new FaqModifyFormAction();
				forward = action.execute(request, response);
				break;
			case "FaqRegisterForm.cu":
				action = new FaqRegisterFormAction();
				forward = action.execute(request, response);
				break;
			case "InquiryAnswerForm.cu":
				action = new InquiryAnswerFormAction();
				forward = action.execute(request, response);
				break;
			case "InquiryBoard.cu":
				action = new InquiryBoardAction();
				forward = action.execute(request, response);
				break;
			case "NoticeBoard.cu":
				action = new NoticeBoardAction();
				forward = action.execute(request, response);
				break;
			case "NoticeModifyForm.cu":
				action = new NoticeModifyFormAction();
				forward = action.execute(request, response);
				break;
			case "NoticeRegisterForm.cu":
				action = new NoticeRegisterFormAction();
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
