package net.test;

import java.io.File;

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
		
		String path = "C:\\FunBox";
		File deleteFolder = new File(path);
		
		if(deleteFolder.exists()){
			File[] deleteFolderList = deleteFolder.listFiles();
			
			for (int j = 0; j < deleteFolderList.length; j++) {
				deleteFolderList[j].delete(); 
			}
			
			if(deleteFolderList.length == 0 && deleteFolder.isDirectory()){
				deleteFolder.delete();
			}
		}
	}

}
