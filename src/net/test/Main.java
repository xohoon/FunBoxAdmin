package net.test;

import net.company.dao.CompanyDAO;
import net.company.dto.CompanyDetail;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompanyDAO companyDAO = new CompanyDAO();
		CompanyDetail companyDetail = new CompanyDetail();
		
		
		System.out.println(companyDAO.getFileDirectory(37,3));
	}

}
