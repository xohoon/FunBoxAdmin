package net.company.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.company.dao.CompanyDAO;
import net.company.dto.CompanyBean;

public class CompanyInvestDetailFundedAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		CompanyBean company = new CompanyBean();		
		int cp_idx = 1;
		
		try {
			String idx = request.getParameter("cp_idx");
			cp_idx = Integer.parseInt(idx);
		}catch(NumberFormatException e) {
			System.out.println("NumberFormatException 에러: " + e);
		}
		
		CompanyDAO company_dao = new CompanyDAO();
		company = company_dao.getCompanyInfo2(cp_idx);
		
		int iv_min_amount = Integer.parseInt(company.getIv_min_amount());	// 투자 - 최소금액(1구좌 금액)
		int iv_appl_stock = Integer.parseInt(company.getIv_appl_stock());	// 모집 구좌
		int account_value = iv_min_amount * iv_appl_stock;	// 구좌 가치
		int cp_monthly_profit = Integer.parseInt(company.getCp_monthly_profit());	// 월 수익률
		int z = 100;
		
		double monthly_profit_result = (double)cp_monthly_profit / (double)z;
		double result = Math.floor((double)account_value*(double)monthly_profit_result);
		
		request.setAttribute("accountValue", account_value);
		request.setAttribute("companyBean", company);
		request.setAttribute("result", result);
		
		forward.setRedirect(false);
		forward.setPath("./company/companyInvestDetailFunded.jsp");
		return forward;
	}

}
