package net.test;

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
		
		String[] array = {"1321321","232132","321321321","321321321"};
		String string = "";
		string = setStringPattern(array,"/**/");
		
		System.out.println(string);
	}
	
	private static String setStringPattern(String[] array,String pattern) {
		String string = "";
		for (int i = 0; i < array.length; i++) {
			if (i == array.length -1) {
				string += array[i];
			}else {
				string += array[i] +pattern;
			}
		}
		return string;
	}

}
