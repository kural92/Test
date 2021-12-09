package com.Nm.Msite_stage;


	
	
	//package <set your test package>;
	import io.appium.java_client.remote.AndroidMobileCapabilityType;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
	import io.appium.java_client.remote.MobileBrowserType;
	import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
	import org.testng.annotations.*;
	import java.net.URL;
	import java.net.MalformedURLException;
	import java.util.logging.Level;

	public class Sample_Msite {
	    private String reportDirectory = "reports";
	    private String reportFormat = "xml";
	    private String testName = "Untitled";
	    protected AndroidDriver<AndroidElement> driver = null;

	    DesiredCapabilities dc = new DesiredCapabilities();
	    
	    @BeforeMethod
	    public void setUp() throws MalformedURLException {
	        dc.setCapability("reportDirectory", reportDirectory);
	        dc.setCapability("reportFormat", reportFormat);
	        dc.setCapability("testName", testName);
	        dc.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA");
	        dc.setBrowserName(MobileBrowserType.CHROMIUM);
	        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
	        driver.setLogLevel(Level.INFO);
	    }

	    @Test
	    public void testUntitled() {
	        driver.get("http://m.netmeds.com");
	        
	        driver.findElement(By.id("fHome")).click();
	        
	        driver.findElement(By.xpath("//*[@id='fHome']")).click();
	        
	        
	        
	        
	        
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}


