 package com.Nm.Andriod_prod;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public class Sample {
	public static WebDriver driver=null;
	@BeforeClass
	  public void setUp1() throws MalformedURLException {
	      System.setProperty("webdriver.chrome.driver", "D:\\Eclipse_WorkSpace\\Automation\\Driver\\chromedriver.exe");
	      Map<String, String> mobileEmulation = new HashMap<String, String>();
	      mobileEmulation.put("deviceName", "Pixel 2");
       
	      ChromeOptions chromeOptions = new ChromeOptions();
	      
	      chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	     chromeOptions.setExperimentalOption("debuggerAddress", "localhost:9222");
	      chromeOptions.addArguments("--disable-notifications");
	   
	       driver = new ChromeDriver(chromeOptions);
	    
	     
	  }  
}
