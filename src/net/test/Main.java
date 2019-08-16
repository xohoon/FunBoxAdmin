package net.test;

import java.util.List;

import net.company.dao.CompanyDAO;
import net.company.dto.CompanyApplication;
import net.member.dao.MemberDAO;
import net.member.dto.Member;

public class Main {

	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		CompanyDAO companyDAO = new CompanyDAO();
		List<Member> memberList;
		List<CompanyApplication> companyApplicationList;
		//memberList = memberDAO.SelectMemberList(1);
		//companyApplicationList = companyDAO.getCompanyApplicationList(1);
		
		//System.out.println(companyApplicationList.get(0).getApp_cp_idx());
		
		System.out.println(companyDAO.getCompanyApplicationMaxPage());
		
	}

}
