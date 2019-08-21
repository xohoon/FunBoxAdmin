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
				jsonObject.put("message", "사용 가능한 ID 입니다.");
			} else {
				jsonObject.put("result", 1);
				jsonObject.put("message", "이미 사용 중인 ID 입니다.");
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
				jsonObject.put("message", "회원등록 완료.");
			} else {
				jsonObject.put("result", 1);
				jsonObject.put("message", "회원등록 실패.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject modifyMemberResult(Member member) {
		MemberDAO dao = new MemberDAO();
		jsonObject = new JSONObject();
		try {
			if (dao.modifyMember(member)) {
				jsonObject.put("result", 0);
				jsonObject.put("message", "ȸ�� ���� �Ϸ�.");
			} else {
				jsonObject.put("result", 1);
				jsonObject.put("message", "ȸ�� ���� ����.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
}
