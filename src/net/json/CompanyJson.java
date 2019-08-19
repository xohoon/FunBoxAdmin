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

}
