package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.json.CompanyJson;

public class DeleteCompanyInvestApply implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request.setCharacterEncoding("utf-8");
		CompanyJson companyJson = new CompanyJson();

		String app_cp_idx = request.getParameter("app_cp_idx");
		if (app_cp_idx == null) {
			app_cp_idx = "-1";
		}
		JSONObject jsonObject = companyJson.getDeleteCompanyApply(Integer.parseInt(app_cp_idx));

		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jsonObject);

		return null;
	}

}
