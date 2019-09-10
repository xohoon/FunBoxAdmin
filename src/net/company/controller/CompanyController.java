package net.company.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.action.CompanyAllListAction;
import net.company.action.CompanyDeadLineAction;
import net.company.action.CompanyDeadLineSaveAction;
import net.company.action.CompanyInvestApplyDetailAction;
import net.company.action.CompanyInvestApplyListAction;
import net.company.action.CompanyInvestDetailFundedAction;
import net.company.action.CompanyInvestedDetailAction;
import net.company.action.CompanyInvestedDoneListAction;
import net.company.action.CompanyInvestedListAction;
import net.company.action.CompanyMainSlideManagement1Action;
import net.company.action.CompanyMainSlideManagement2Action;
import net.company.action.CompanyPopularityInfoAjax;
import net.company.action.CompanyPopularityManagementAction;
import net.company.action.CompanyRecomnandManagementAction;
import net.company.action.CompanyRegisterAction;
import net.company.action.CompanyRegisterFormAction;
import net.company.action.DeleteCompanyInvestApply;
import net.company.action.ModifyCompanyAction;
import net.company.action.SetAutoOrManualAction;
import net.company.action.companyPopularityManagementUpdateAction;

@MultipartConfig(maxFileSize = 136314880)
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
			case "/CompanyDeadLineSaveAction.cp": // 윤식 추가  수동 top 3 지정후 저장
				action = new CompanyDeadLineSaveAction();
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
			case "/setAutoOrManual.cp":
				//ajax
				action = new SetAutoOrManualAction();
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
			case "/companyRegisterAction.cp":
				action = new CompanyRegisterAction();
				forward = action.execute(request, response);
				break;
				//태훈끝//
			case "/modifyCompany.cp":
				action = new ModifyCompanyAction();
				forward = action.execute(request, response);
				break;
			case "/companyInvestDetailFunded.cp":
				action = new CompanyInvestDetailFundedAction();
				forward = action.execute(request, response);
				break;
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
