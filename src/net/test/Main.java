package net.test;

import java.util.ArrayList;
import java.util.List;

import net.company.dao.CompanyDAO;
import net.company.dto.Company;
import net.company.dto.CompanyApplication;
import net.company.dto.CompanyInvested;
import net.member.dao.MemberDAO;
import net.member.dto.Member;
import net.util.Paging;

public class Main {

	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		CompanyDAO companyDAO = new CompanyDAO();
		List<Member> memberList = new ArrayList<Member>();
		Integer a = null,b = null,c=null ;
		List<CompanyApplication> companyApplicationList;
		List<CompanyInvested> companyInvestedList = new ArrayList<CompanyInvested>();
		//memberList = memberDAO.SelectMemberList(1);
		//companyApplicationList = companyDAO.getCompanyApplicationList(1);
		
		//System.out.println(companyApplicationList.get(0).getApp_cp_idx());
		
		//System.out.println(companyDAO.getCompanyApplicationMaxPage());
		Paging paging = new Paging();
		List<Company> companyList = new ArrayList<Company>();
		//companyDAO.getCompanyAllList(companyList, true, "바른", 4);
		//System.out.println(companyList.size());
		int arr[] = {1};
		
		companyDAO.insertManualTable(4, arr);
		//companyDAO.getCompanyInvestedList(companyInvestedList, 1, "12", paging);
		//System.out.println(companyInvestedList.size());
		
		
	}

}
