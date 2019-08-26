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
				jsonObject.put("message", "Ȯ�ε��� ���� ����");
			}else {
				if (companyDAO.deleteCompanyApply(app_cp_idx)) {
					jsonObject.put("result", 0);
					jsonObject.put("message", app_cp_idx + "�� ��û�� ���� ����");
				}else{
					jsonObject.put("result", 1);
					jsonObject.put("message", app_cp_idx + "�� ��û�� ���� ����");
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject getInsertManualTableResult(int aas_idx,Integer[] cp_idx_value_arr ) {
		jsonObject = new JSONObject();
		CompanyDAO companyDAO = new CompanyDAO();
		try {
			if(companyDAO.insertManualTable(aas_idx, cp_idx_value_arr)) {
				jsonObject.put("result", 0);
				jsonObject.put("message", "aas_idx : "+aas_idx+"이 수동으로 처리되었습니다.");
			}else {
				jsonObject.put("result", 1);
				jsonObject.put("message", "알수 없는 오류 발생!!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}

}
