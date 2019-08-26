package net.company.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.*;
import net.company.action.*;


public class CompanyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		System.out.println("command : " + command);
		try {
			switch (command) {
			case "/companyDeadLineManagement.cp": // 윤식 추가
				action = new CompanyDeadLineAction();
				forward = action.execute(request, response);
				break;
			case "/companyDeadLineAjax.cp": // 윤식 추가  수동 top 3 처음페이지 불러올때
				action = new CompanyDeadLineAjaxAction();
				forward = action.execute(request, response);
				break;
			case "/companyDeadLineAjaxSave.cp": // 윤식 추가  수동 top 3 지정후 저장
				action = new CompanyDeadLineSaveAjaxAction();
				forward = action.execute(request, response);
				break;	
			case "/companyInvestApplyDetail.cp":
				action = new CompanyInvestApplyDetailAction();
				forward = action.execute(request, response);
				break;
			case "/companyInvestApplyList.cp":
				action = new CompanyInvestApplyListAction();
				forward = action.execute(request, response);
				break;
			case "/companyInvestedDetail.cp":
				action = new CompanyInvestedDetailAction();
				forward = action.execute(request, response);
				break;
			case "/companyInvestedDoneList.cp":
				action = new CompanyInvestedDoneListAction();
				forward = action.execute(request, response);
				break;
			case "/companyInvestedList.cp":
				action = new CompanyInvestedListAction();
				forward = action.execute(request, response);
				break;
			case "/companyMainSlideManagement1.cp":
				action = new CompanyMainSlideManagement1Action();
				forward = action.execute(request, response);
				break;
			case "/companyMainSlideManagement2.cp":
				action = new CompanyMainSlideManagement2Action();
				forward = action.execute(request, response);
				break;
			case "/companyPopularityManagement.cp":
				action = new CompanyPopularityManagementAction();
				forward = action.execute(request, response);
				break;
			case "/companyRecomnandManagement.cp":
				action = new CompanyRecomnandManagementAction();
				forward = action.execute(request, response);
				break;
			case "/companyRegisterForm.cp":
				action = new CompanyRegisterFormAction();
				forward = action.execute(request, response);
				break;
			case "/compnayAllList.cp":
				action = new CompanyAllListAction();
				forward = action.execute(request, response);
				break;
			case "/deleteCompanyInvestApply.cp":
				//ajax
				action = new DeleteCompanyInvestApply();
				forward = action.execute(request, response);
				break;
				//태훈추가//
			case "/companyPopularityManagementUpdate.cp":
				action = new companyPopularityManagementUpdateAction();
				forward = action.execute(request, response);
				break;
			case "/ComapnyPopularityInfoAjax.cp":
				//ajax
				action = new CompanyPopularityInfoAjax();
				forward = action.execute(request, response);
				break;
				//태훈끝//
			default:
				break;
			}
			if (forward != null) {
				if (forward.isRedirect()) {
					response.sendRedirect(forward.getPath());
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
