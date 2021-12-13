package com.Nm.Andriod_prod;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MobileBaseClass;
import com.Nm.Pom.AndriodPom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ColdStorage_android_Live extends MobileBaseClass{
	
	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA"); //RZ8R20GLXTA //GBT4C19326001968
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
			capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//Moneflow.html");
       
       //initialize ExtentReports and attach the HtmlReporter
       report = new ExtentReports();
       
     // htmlReporter.setAppendExisting(true);
       report.attachReporter(htmlReporter);
       report.setSystemInfo("Host name", "localhost");
       report.setSystemInfo("Environemnt", "QA");
       report.setSystemInfo("user", "Automation Team");
   
       //configuration items to change the look and feel
       //add content, manage tests etc

       htmlReporter.config().setDocumentTitle("Extent Report ");
       htmlReporter.config().setReportName("NetMeds.com");

       //htmlReporter.config().setTheme(Theme.STANDARD);
   	
   }
	
	@Test
	public void coldStorage() throws Throwable {
		
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "************* Cold Storage ********************" );
		
		AndriodPom m = new AndriodPom();
		
		Thread.sleep(10000);
		popupclose();
		popupclose();
		try {
			Thread.sleep(2000);
			btnclick(m.getLetsstarted());
			Thread.sleep(10000);
			driver.hideKeyboard();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		popupclose();
		popupclose();
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys("7010752043");
			Thread.sleep(3000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys("Change@92");
			
			btnclick(m.getLogin());
			Thread.sleep(2000);
		}catch(Exception e) {
				System.out.println("Already logged in");
			}
		Thread.sleep(10000);
		btnclick(m.getGotocart()); 
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_no_result']")).size() == 0)) {

				try {
					btnclick(m.getRemoveButton());
				} catch (Exception e) {
					
				}

			} else {
				logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		}
		btnclick(m.getCart_search());
		Thread.sleep(2000);

		
		Thread.sleep(2000);
		m.getSearchbarone().sendKeys("human mixtard injection");
		
		Thread.sleep(5000);
		//driver.hideKeyboard();
		
		Thread.sleep(5000);
		
		
		Thread.sleep(2000);
		btnclick(m.getSearch_drugname());
		Thread.sleep(10000);
		/*
		
	//	btnclick(m.getPDP_CheckAvailabilty_btn());
		

		Thread.sleep(2000);
		btnclick(m.getPDP_ColdStorage_PinCheck());
		
		Thread.sleep(2000);
	//	driver.hideKeyboard();
		

		Thread.sleep(2000);
		type(m.getPDP_ColdStorage_PinCheck(), "600055");
		

		Thread.sleep(3000);
		btnclick(m.getPDP_CheckAvailabilty_CheckBtn());
		

		Thread.sleep(2000);
//		System.out.println(m.getPDP_Colstorage_DeliveryError().getText());
		

		Thread.sleep(2000);
		m.getPDP_ColdStorage_PinCheck().clear();
		
		Thread.sleep(2000);
	//	driver.hideKeyboard();
		

		Thread.sleep(2000);
         type(m.getPDP_ColdStorage_PinCheck(), "600100");
		

         Thread.sleep(3000);
 		btnclick(m.getPDP_CheckAvailabilty_CheckBtn());
		

		Thread.sleep(2000);
 //       System.out.println(m.getPDP_Colstorage_DeliveryError().getText());
		

		Thread.sleep(2000);
		m.getPDP_ColdStorage_PinCheck().clear();
		
		Thread.sleep(2000);
		driver.hideKeyboard();
		
		Thread.sleep(2000);
         type(m.getPDP_ColdStorage_PinCheck(), "180001");
		

         Thread.sleep(3000);
 		btnclick(m.getPDP_CheckAvailabilty_CheckBtn());
		

		Thread.sleep(2000);
//		  System.out.println(m.getPDP_Colstorage_DeliveryError().getText());
			

			Thread.sleep(2000);
			m.getPDP_ColdStorage_PinCheck().clear();
		
			Thread.sleep(3000);
		btnclick(m.getPDP_CheckAvailabilty_Close_btn());
		
		*/
		
		
		Thread.sleep(3000);
		btnclick(m.getAdd_To_cart());
		
		Thread.sleep(3000);
		btnclick(m.getPDP_Cart_btn());
		
		Thread.sleep(3000);
		btnclick(m.getProceed_btn());
		
		Thread.sleep(13000);
		btnclick(m.getDoctor_consultation());
		
		Thread.sleep(3000);
		try {
		btnclick(m.getDoctorConsultation_CloseBtn());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		Thread.sleep(3000);
		btnclick(m.getOrder_review_btn());
		
		Thread.sleep(13000);
		String Cold = gettext(m.getOrder_review_ColdStorage_text());
		System.out.println(Cold);
		Thread.sleep(3000);
		String TakeAction = gettext(m.getTake_Action_Description());
		
		Thread.sleep(3000);
		if (TakeAction.contains("Cold-storage products cannot be delivered to the selected pincode.")) {
			
			Thread.sleep(13000);
			btnclick(m.getTake_Action_Description());
			
			Thread.sleep(3000);
			btnclick(m.getM2_ModifyAddress());
			
			Thread.sleep(3000);
			m.getPincode().clear();
			
			Thread.sleep(3000);
			type(m.getPincode(), "600100");
			
			Thread.sleep(3000);
		     btnclick(m.getSave_address());
		     
		     Thread.sleep(13000);
		     driver.findElementByAccessibilityId("Navigate up").click();
		     
		     
		     Thread.sleep(3000);
		} else if (TakeAction.contains("One or more items cannot be delivered at the selected pincode currently.")) {
			
			Thread.sleep(3000);
			System.out.println("Please Change the Pincode to deliver this product");
			
			
		} else {
			
			Thread.sleep(3000);
			System.out.println("Click on proceed to Continue into payment");
			
			
		}
		
		
		
		
	}
	
	
	
	

}
