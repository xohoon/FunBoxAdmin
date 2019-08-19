package net.json;

import org.json.simple.JSONObject;

import net.member.dao.MemberDAO;
import net.member.dto.Member;

public class MemberJson {
	private JSONObject jsonObject;


	@SuppressWarnings("unchecked")
	public JSONObject getCheckDuplicateIDResult(String mb_id) {
		MemberDAO dao = new MemberDAO();
		jsonObject = new JSONObject();
		try {
			if (dao.checkDuplicationID(mb_id)) {
				jsonObject.put("result", 0);
				jsonObject.put("message", "��� �� �� �ִ� ID �Դϴ�.");
			} else {
				jsonObject.put("result", 1);
				jsonObject.put("message", "�̹� ��� �� �� ID �Դϴ�.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}

	@SuppressWarnings("unchecked")
	public JSONObject getMemberResgisterResult(Member member) {
		MemberDAO dao = new MemberDAO();
		jsonObject = new JSONObject();
		try {
			if (dao.registeMember(member)) {
				jsonObject.put("result", 0);
				jsonObject.put("message", "ȸ�� ��� �Ϸ�.");
			} else {
				jsonObject.put("result", 1);
				jsonObject.put("message", "ȸ�� ��� ����.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
}
