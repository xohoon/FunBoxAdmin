package net.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.customer.action.FaqBoardAction;
import net.customer.action.FaqDeleteAction;
import net.customer.action.FaqModifyAction;
import net.customer.action.FaqModifyFormAction;
import net.customer.action.FaqRegisterFormAction;
import net.customer.action.FaqShowAction;
import net.customer.action.InquiryAnswerFormAction;
import net.customer.action.InquiryBoardAction;
import net.customer.action.NoticeBoardAction;
import net.customer.action.NoticeModifyFormAction;
import net.customer.action.NoticeRegisterFormAction;
import net.customer.action.inquiryAnswerInsertAction;
import net.customer.action.inquiryFormAction;

@WebServlet("/CustomerController")
@MultipartConfig(maxFileSize = 136314880)
public class CustomerController extends HttpServlet implements Servlet{
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
			case "/faqBoard.cu":
				action = new FaqBoardAction();
				forward = action.execute(request, response);
				break;
			case "/faqModify.cu":
				action = new FaqModifyAction();
				forward = action.execute(request, response);
				break;
			case "/faqModifyForm.cu":
				action = new FaqModifyFormAction();
				forward = action.execute(request, response);
				break;
			case "/faqRegister.cu":
				forward = new ActionForward();
			    forward.setRedirect(false); 
			    forward.setPath("./customer/faqRegisterForm.jsp");
			    break;
			case "/faqRegisterForm.cu":
				action = new FaqRegisterFormAction();
				forward = action.execute(request, response);
				break;
			case "/faqDelete.cu":
				action = new FaqDeleteAction();
				forward = action.execute(request, response);
				break;
			case "/faqShow.cu":
				action = new FaqShowAction();
				forward = action.execute(request, response);
				break;
			case "/inquiryAnswerForm.cu": // 1:1 문의 수정 폼 - 윤식
				action = new InquiryAnswerFormAction();
				forward = action.execute(request, response);
				break;
			case "/inquiryBoard.cu": // 1:1 문의 계시판 - 윤식
				action = new InquiryBoardAction();
				forward = action.execute(request, response);
				break;
			case "/answerInsert.cu": // 답글 달기 - 윤식
				action = new inquiryAnswerInsertAction();
				forward = action.execute(request, response);
				break;
			case "/noticeBoard.cu":
				action = new NoticeBoardAction();
				forward = action.execute(request, response);
				break;
			case "/noticeModifyForm.cu":
				action = new NoticeModifyFormAction();
				forward = action.execute(request, response);
				break;
			case "/noticeRegisterForm.cu":
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
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
