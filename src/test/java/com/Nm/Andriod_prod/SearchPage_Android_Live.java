package com.Nm.Andriod_prod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
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

public class SearchPage_Android_Live extends MobileBaseClass {
	
	
	
	


	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.UDID, UDID); //RZ8R20GLXTA //GBT4C19326001968
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
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//Search.html");
       
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
	public void SearchPage_result() throws Throwable {
		
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		AndriodPom m = new AndriodPom();
		
		Thread.sleep(10000);
		try {
		popupclose();
		popupclose();
		
			Thread.sleep(2000);
			btnclick(m.getLetsstarted());
			Thread.sleep(10000);
			driver.hideKeyboard();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		try {
			popupclose();
			popupclose();
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
					// TODO: handle exception
				}

			} else {
				logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		}
		
		
		///
		Thread.sleep(5000);
		driver.findElementByAccessibilityId("Navigate up").click();
		//btnclick(m.getFooter_HomePage());
		
		
		Thread.sleep(3000);
		btnclick(m.getHeader_SearchBar());
		Thread.sleep(5000);
		type(m.getSearchBar(), "Gemer 2mg");
		
		Thread.sleep(5000);
		
		
		
		driver.hideKeyboard();
		
		Thread.sleep(5000);
		int a = m.getSearch_results().size();
		System.out.println(a+" : are the search result displayed in front to see more please scroll down");
		
		Thread.sleep(5000);
		for (int i = 0; i <a; i++) {
			Thread.sleep(5000);
			String det = m.getSearch_results().get(i).getText();
			System.out.println(det);
			
			try {
			String cate = m.getSearch_results_category_List().get(i).getText();
			System.out.println(cate);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
			String Drug = m.getSearch_results_Drug_List().get(i).getText();
			System.out.println(Drug);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
			String Deta = m.getSearch_results_Detail_List().get(i).getText();
			System.out.println(Deta);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		
		} 
		
		Thread.sleep(3000);
		btnclick(m.getM2_Search_AddToCart());
		
		
		Thread.sleep(3000);
		for (int j = 0; j < 10; j++) {
try {
			Thread.sleep(3000);
			btnclick(m.getSearch_results_AddTocart_IncreaseQty());
} catch (Exception e) {
	// TODO: handle exception
}
			
		}
		
		Thread.sleep(3000);
		for (int j = 0; j < 11; j++) {
try {
			Thread.sleep(3000);
			btnclick(m.getSearch_results_AddTocart_DecreaseQty());
} catch (Exception e) {
	// TODO: handle exception
}
			
		}
		
		
		Thread.sleep(3000);
		btnclick(m.getSearch_results_Drug());
		
		
		Thread.sleep(7000);
		btnclick(m.getPDP_Search_btnn());
		
		Thread.sleep(3000);
		type(m.getSearchBar(), "Telma");
		
		Thread.sleep(3000);
		btnclick(m.getM2_Search_AddToCart());
		
		Thread.sleep(3000);
		btnclick(m.getPDP_Cart_btn());
		
		Thread.sleep(3000);
		btnclick(m.getPDP_Search_btnn());
		
		Thread.sleep(3000);
		type(m.getSearchBar(), "Dolo");
		
		Thread.sleep(3000);
		btnclick(m.getSearch_results_Drug());
		
		Thread.sleep(5000);
		btnclick(m.getPDP_Manufacture_name());
		
		Thread.sleep(3000);
		btnclick(m.getPDP_Search_btnn());
		
		
		
		
	}
	
	
	@AfterTest
	public void tearDown() {
		// TODO Auto-generated method stub
  
	}

}
