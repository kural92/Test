package com.Nm.Andriod_prod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;


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

public class COD_Logic_Android extends MobileBaseClass {
	
	
	
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
	public void COD_60_5000() throws Throwable {
		
		
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
			driver.launchApp();
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
		String aa = "Gemer 2mg,Ajmal Amber Wood";
		String [] spl = aa.split(",");
		System.out.println(spl.length);
		
		
		
		for (int i = 0; i < spl.length; i++) {
			
			
		
		
		
		Thread.sleep(3000);
		btnclick(m.getHeader_SearchBar());
		Thread.sleep(5000);
		type(m.getSearchBar(), spl[i]);
		
		Thread.sleep(5000);
		
		driver.hideKeyboard();
		
		Thread.sleep(5000);
		btnclick(m.getM2_Search_AddToCart());
		
		for (int j = 0; j < 5; j++) {
			
			Thread.sleep(3000);
			btnclick(m.getSearch_results_AddTocart_IncreaseQty());
			
			
		}
		
		Thread.sleep(5000);
		btnclick(m.getPDP_Cart_btn());
		
		
		Thread.sleep(3000);
		btnclick(m.getM2_ProceedBtn());
	try {	
		Thread.sleep(6000);
		btnclick(m.getDoctor_consultation());
		
		Thread.sleep(3000);
		btnclick(m.getDoctorConsultation_CloseBtn());
		
		Thread.sleep(3000);
		btnclick(m.getOrder_review_btn());
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	float total ;
		Thread.sleep(3000);
		String Tot = m.getOrderReview_TotalAmount().getText();
		System.out.println(Tot);
		try {
		String tota = Tot.substring(1, 7);
		System.out.println(tota);
		 total = Float.parseFloat(tota);
		System.out.println(total);
		} catch (Exception e) {
			String tota = Tot.substring(1, 8);
			System.out.println(tota);
			 total = Float.parseFloat(tota);
			System.out.println(total);
		}
		
		Thread.sleep(3000);
		btnclick(m.getOrderReview_Proceed_Btn());
		
		
		
		Thread.sleep(3000);
		if (total<60||total>5000) {
			
			System.out.println("Unable to Process the payment / Cash on Delivery Option.The Net Value was Below 60 or above 5000");
		/*	
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			
			
			Thread.sleep(3000);
			btnclick(m.getCOD_CheckBox());
			
			Thread.sleep(3000);
			btnclick(m.getCOD_PayBtn());
			
			*/
			
		} else {
			
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			
			
			Thread.sleep(3000);
			btnclick(m.getCOD_CheckBox());
			
			Thread.sleep(3000);
			btnclick(m.getCOD_PayBtn());
			
			Thread.sleep(3000);
			btnclick(m.getTrack_Order());
			
			Thread.sleep(6000);
			btnclick(m.getViewdetails());
			
			Thread.sleep(5000);
			btnclick(m.getCancel_Order());
			
			Thread.sleep(3000);
			btnclick(m.getCancel_Order_reason());
			
			Thread.sleep(3000);
			driver.swipe(0, 200, 0, 0, 0);
			
			
			Thread.sleep(3000);
			btnclick(m.getSubmit_cancelBtn());
			
			Thread.sleep(10000);
			btnclick(m.getFooter_HomePage());
			
			Thread.sleep(6000);
			
			
			
		}
		
		}
		
		
	}

}
