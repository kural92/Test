package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileAndEnv {
 public static Map<String,String> fileanddev= new HashMap<String,String>();
 public static Properties propmain =new Properties();
 public static Properties proppreset =new Properties(); 
 public static Map<String,String> envAndFile() throws IOException{
	
		
			FileInputStream filedev=new FileInputStream(System.getProperty("user.dir")+"/Inputs/Stage.properties");
			// machine readble foremet
			propmain.load(filedev);
			//property 
			fileanddev.put("Baseuri",propmain.getProperty("Baseuri"));
			fileanddev.put("Rurl",propmain.getProperty("Rurl"));
			fileanddev.put("mobilenumber",propmain.getProperty("mobilenumber"));
			fileanddev.put("Newusermobilenumber",propmain.getProperty("Newusermobilenumber"));
			fileanddev.put("testerName",propmain.getProperty("testerName"));
			fileanddev.put("chrompath",propmain.getProperty("chrompath"));
		
	
	return fileanddev;
	 
 }
 public static Map<String,String> getConfigData() throws IOException{
	 if (fileanddev==null) {
		 fileanddev=envAndFile();
	}
	return fileanddev;
	 
 }
}
