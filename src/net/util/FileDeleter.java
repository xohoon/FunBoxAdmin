package net.util;

import java.io.File;

public class FileDeleter {
	public static boolean deleteDirectoryFile(String path) {
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
		return true;
	}
}
