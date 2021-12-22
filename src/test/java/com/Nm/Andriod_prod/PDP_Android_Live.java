package com.Nm.Andriod_prod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import junit.extensions.ActiveTestSuite;

public class PDP_Android_Live extends MobileBaseClass{
	
	
	

	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.UDID, UDID); //RZ8R20GLXTA //GBT4C19326001968
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
	//		capabilities.setCapability("platformVersion","10.0.0" );
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
	public void productDetails() throws Throwable {
		
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
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
			driver.launchApp();
		}
		
		
		popupclose();
		popupclose();
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys(" ");
			Thread.sleep(3000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys(" ");
			
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
		Thread.sleep(5000);
		btnclick(m.getCart_search());
		Thread.sleep(2000);
		
		
		int a = MobileBaseClass.getRowCount("AndPDP");
		for (int i = 0; i < 1; i++) {
			
		
		Thread.sleep(5000);
		m.getSearchbarone().sendKeys(MobileBaseClass.getExcelData("AndPDP", i, 0));
		
		Thread.sleep(5000);
		driver.hideKeyboard();
		
		Thread.sleep(5000);
		
		List<WebElement> search_result  =  m.getSearch_results();
		
		System.out.println(search_result.size());

		 
		
		Thread.sleep(2000);
				btnclick(m.getSearch_drugname());
				Thread.sleep(10000);
				
				
				String PDP_category_Name = m.getPDP_category_Name().getText();
						System.out.println(PDP_category_Name);
				
				Thread.sleep(2000);
				if (m.getPDP_Rx_Required_List().size()==1) {
					
					Thread.sleep(2000);
					String PDP_Rx_Required = m.getPDP_Rx_Required().getText();
					System.out.println(PDP_Rx_Required);
					
				}
		
				Thread.sleep(2000);
				String PDP_Manufacture_name = m.getPDP_Manufacture_name().getText();
				System.out.println(PDP_Manufacture_name);
				
				
				Thread.sleep(2000);
				String PDP_Best_Price = m.getPDP_Best_Price().getText();
				System.out.println(PDP_Best_Price);
				
				Thread.sleep(2000);
				if (m.getPDP_MRP_Price_List().size()==1) {
					Thread.sleep(2000);
					String PDP_MRP_Price = m.getPDP_MRP_Price().getText();
					System.out.println(PDP_MRP_Price);
				} else {

					
				}
				
				
				Thread.sleep(2000);
				for (int j = 0; j < 5; j++) {
					driver.swipe(0, 200, 0, 0, 1000);
					Thread.sleep(2000);
					if (m.getPDP_OfferAvailable_List().size()==1) {
						System.out.println("Swipe down to check Offer");
						break;
					} else {

					}
				}
			
				
				Thread.sleep(2000);
				Thread.sleep(2000);
				if (m.getPDP_OfferAvailable_List().size()==1) {
					
					Thread.sleep(2000);
					 btnclick(m.getPDP_OfferAvailable_Text());
					 Thread.sleep(2000);
						driver.swipe(0, 500, 0, 0, 1000);
						
						Thread.sleep(2000);
						
						List<WebElement> Coupon_code = m.getPDP_Coupon_Code();
								Thread.sleep(2000);
						List<WebElement> Coupon_Save_Per = m.getPDP_Coupon_Save_Percentage();
						Thread.sleep(2000);
						List<WebElement> Coupon_Detils = m.getPDP_Coupon_Details();
					    Thread.sleep(2000);
						
						if (!(Coupon_code.size()==0)) {
							
							for (int j = 0; j <Coupon_code.size() ; j++) {
								
								Thread.sleep(2000);
								System.out.println(gettext(Coupon_code.get(j)));
								
								Thread.sleep(2000);
								System.out.println(gettext(Coupon_Save_Per.get(j)));
								
								Thread.sleep(2000);
								System.out.println(gettext(Coupon_Detils.get(j)));
								
							}
							
						} else {

						}
						
						
						
				}
				
				
				Thread.sleep(2000);
				 Thread.sleep(2000);
	/*				driver.swipe(0, 0, 0, 200, 1000);
	btnclick(m.getPDP_Manufacture_name());
	
	Thread.sleep(15000);
	String manufac = m.getPDP_manufacture_Page().getText();
	
	if (PDP_Manufacture_name.contains(manufac)) {
		
		System.out.println("Manufacture Matches");
		
	} else {

		
		System.err.println("Manufacture not Matches");
	}
	*/
	Thread.sleep(2000);
	driver.findElementByAccessibilityId("Navigate up").click();
	
	
	Thread.sleep(10000);
	driver.findElementByAccessibilityId("Navigate up").click();
	
	try {
	Thread.sleep(2000);
//	driver.findElementByAccessibilityId("Navigate up").click();
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	Thread.sleep(2000);
	try {
	btnclick(m.getSearch_X_button());
	}catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(2000);
	Thread.sleep(2000);
	Thread.sleep(2000);
	
	
	
		}
		/*
		
		 //Share ICON
		/////////////////
		Thread.sleep(2000);
		m.getSearchbarone().sendKeys("Horlicks");
		
		Thread.sleep(5000);
		driver.hideKeyboard();
		
		Thread.sleep(5000);
		Thread.sleep(2000);
				btnclick(m.getSearch_drugname());
				Thread.sleep(5000);
				
				Thread.sleep(3000);
				btnclick(m.getPDP_Share_Icon());
				
				Thread.sleep(3000);
			//	btnclick(m.getPDP_Share_Message_Samsung());
				
				
				Thread.sleep(5000);
				try {
				btnclick(m.getSamsung_AllowOnce());
				} catch (Exception e) {
					// TODO: handle exception
				}
		
				Thread.sleep(3000);
				Thread.sleep(2000);
				driver.findElementByAccessibilityId("Navigate up").click();
				
		//////  
				
				
			*/
	}	
	
	
	

}
