package net.company.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import net.common.action.Action;
import net.common.action.ActionForward;
import net.json.CompanyJson;

public class SetAutoOrManualAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CompanyJson companyJson = new CompanyJson();
		String cp_idx_value_arr_string[] = request.getParameterValues("cp_idx_value_arr");
		Integer cp_idx_value_arr[] = new Integer[cp_idx_value_arr_string.length];
		boolean auto_status = Boolean.parseBoolean(request.getParameter("auto_status"));
		String aas_idx_string = request.getParameter("aas_idx");
		Integer aas_idx = 0;
		
		if (aas_idx_string != null) {
			try {
				aas_idx = Integer.parseInt(aas_idx_string);
			} catch (NumberFormatException nfe) {
				//오류 처리
			}			
		}
		
		for (int i = 0; i < cp_idx_value_arr_string.length; i++) {
			cp_idx_value_arr[i] = Integer.parseInt(cp_idx_value_arr_string[i]);
		}
		
		JSONObject jsonObject = companyJson.getInsertManualTableResult(aas_idx, cp_idx_value_arr,auto_status);
		

		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jsonObject);
		
		return null;
	}

}
