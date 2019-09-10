package net.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * CompanyDAO companyDAO = new CompanyDAO(); CompanyDetail companyDetail = new
		 * CompanyDetail();
		 * 
		 * 
		 * System.out.println(companyDAO.getFileDirectory(37,3));
		 */
		
		String from = "2013-04-08";

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date to = transFormat.parse(from);
			System.out.println(to);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

}
