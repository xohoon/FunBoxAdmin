package net.json;

import org.json.simple.JSONObject;

import net.company.dao.CompanyDAO;

public class CompanyJson {
	private JSONObject jsonObject;

	@SuppressWarnings("unchecked")
	public JSONObject getDeleteCompanyApply(int app_cp_idx) {
		CompanyDAO companyDAO = new CompanyDAO();
		jsonObject = new JSONObject();
		try {
			if (app_cp_idx < 0) {
				jsonObject.put("result", 2);
				jsonObject.put("message", "잘 못 된 접근입니다.");
			}else {
				if (companyDAO.deleteCompanyApply(app_cp_idx)) {
					jsonObject.put("result", 0);
					jsonObject.put("message", app_cp_idx + "가 성공적으로 삭제되었습니다.");
				}else{
					jsonObject.put("result", 1);
					jsonObject.put("message", app_cp_idx + "의 삭제 실패");
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getInsertManualTableResult(int aas_idx,Integer[] cp_idx_value_arr,boolean auto_status ) {
		jsonObject = new JSONObject();
		
		try {
			boolean result = false;
			CompanyDAO companyDAO = new CompanyDAO();
			result = companyDAO.setAutoStatus(aas_idx, auto_status);
			if (!auto_status) {
				companyDAO = new CompanyDAO();
				result = companyDAO.deleteManualTable(aas_idx);
				companyDAO = new CompanyDAO();
				result = companyDAO.insertManualTable(aas_idx, cp_idx_value_arr);
				if(result) {
					jsonObject.put("result", 0);
					jsonObject.put("message", "aas_idx : "+aas_idx+"이 수동으로 처리되었습니다.");
				}else {
					jsonObject.put("result", 1);
					jsonObject.put("message", "알수 없는 오류 발생!!!!");
				}
			}else {
				if(result) {
					jsonObject.put("result", 0);
					jsonObject.put("message", "aas_idx :"+aas_idx+"이 자동으로 처리되었습니다.");
				}else {
					jsonObject.put("result", 1);
					jsonObject.put("message", "알수 없는 오류 발생!!!!");
				}
			}
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
