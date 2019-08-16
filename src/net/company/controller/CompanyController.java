package net.company.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.action.CompanyBannerManagementAction;

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

		try {
			switch (command) {
			case "companyBannerManagement.cp":
				action = new CompanyBannerManagementAction();
				forward = action.execute(request, response);
				break;
			case "companyDeadLineManagement.cp":
				action = new CompanyBannerManagementAction();
				forward = action.execute(request, response);
				break;
			case "companyInvestApplyDetail.cp":
				action = new CompanyBannerManagementAction();
				forward = action.execute(request, response);
				break;
			case "companyInvestApplyList.cp":
				action = new CompanyBannerManagementAction();
				forward = action.execute(request, response);
				break;
			case "companyInvestedDetail.cp":
				action = new CompanyBannerManagementAction();
				forward = action.execute(request, response);
				break;
			case "companyMainSlideManagement.cp":
				action = new CompanyBannerManagementAction();
				forward = action.execute(request, response);
				break;
			case "companyPopularityManagement.cp":
				action = new CompanyBannerManagementAction();
				forward = action.execute(request, response);
				break;
			case "companyRecomnandManagement.cp":
				action = new CompanyBannerManagementAction();
				forward = action.execute(request, response);
				break;
			case "companyRegister.cp":
				action = new CompanyBannerManagementAction();
				forward = action.execute(request, response);
				break;
			case "compnayAllList.cp":
				action = new CompanyBannerManagementAction();
				forward = action.execute(request, response);
				break;
			default:
				break;
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
