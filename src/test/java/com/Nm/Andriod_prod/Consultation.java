package com.Nm.Andriod_prod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.BaseClass;
import com.Nm.Base.MobileBaseClass;
import com.Nm.Pom.AndriodPom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Consultation extends MobileBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.UDID, UDID);//"c195de14"
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
			//capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			
					
			capabilities.setCapability("autoDismissAlerts", true);  
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//AlternateBrand.html");
       
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
	

	
	
	
	@Test(priority = 1,enabled=true)
	public void Consult_Myself() throws Throwable {
		
		
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
		
		
		
		for (int i = 0; i < 10; i++) {
			
			Thread.sleep(3000);
			driver.swipe(0, 1000, 0, 0, 1000);
			
			if (m.getConsultation_Btn_List().size()==1) {
				
				Thread.sleep(3000);
				btnclick(m.getConsultation_Btn());
				break;
			} else {
				
				System.out.println("Swipe Down to click on Consult Now Button");

			}
			
			
			
		}
		
		WebDriverWait wait= new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(m.getStart_Consultation_Btn()));
		
		Thread.sleep(3000);
		btnclick(m.getStart_Consultation_Btn());
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_MySelf()));
		btnclick(m.getConsult_MySelf());
		
		Thread.sleep(3000);
		type(m.getConsult_Symptons_TextBox(), "Ear pain");
		
		driver.hideKeyboard();
		
		/*
		Thread.sleep(3000);
		btnclick(m.getConsult_Specialist_ViewAll());
		
		
		Thread.sleep(3000);
		btnclick(m.getConsult_ENT());
		
		
		Thread.sleep(3000);
		btnclick(m.getConsult_specilaisation_DoneBtn());
		*/
		Thread.sleep(3000);
		btnclick(m.getConsult_general_Physician());
		
		Thread.sleep(3000);
		btnclick(m.getSTART_CONSULTATION_BTN());
		
		
		wait.until(ExpectedConditions.visibilityOf(m.getConsult_Chat_Text()));
		
		wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_Doctor_select_btn()));
		Thread.sleep(3000);
		btnclick(m.getConsult_Doctor_select_btn());
		/*
		Thread.sleep(6000);
	//	wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_Chat()));
		btnclick(m.getConsult_Chat());
		
		try {
			Thread.sleep(6000);
			//	wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_Chat()));
			
				btnclick(m.getConsult_Chat());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfAllElements(m.getConsult_Payment_Package_List()));
		m.getConsult_Payment_Package_List().get(1).click();
		*/
		
		
			    //wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_Chat()));

			        //btnclick(m.getConsult_Chat());
		Thread.sleep(6000);
			        driver.findElement(By.xpath("//android.widget.TextView[@text='Chat']")).click();
			        
			        Thread.sleep(3000);
			        
			    //    driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/btn_make_payment']")).click();
			        Thread.sleep(3000);
			
			        wait.until(ExpectedConditions.visibilityOfAllElements(m.getConsult_Payment_Package_List()));
			        m.getConsult_Payment_Package_List().get(1).click();
			        
			        Thread.sleep(3000);
			        
				        driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/btn_make_payment']")).click();
				      
		
// Payment Decline
		try {
				        Thread.sleep(10000);
	//	wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/tv_wallet_link"))));
		List<WebElement> pay_Link = driver.findElements(By.xpath("//android.widget.TextView[@text='LINK']"));//("com.NetmedsMarketplace.Netmeds:id/tv_wallet_link"));
	
		//Mobiwik
		Thread.sleep(3000);
		pay_Link.get(0).click();
		
		
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("Navigate up")));
		driver.findElementByAccessibilityId("Navigate up").click();
		
		//PayTM 
		Thread.sleep(3000);
		pay_Link.get(1).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("Navigate up")));
		driver.findElementByAccessibilityId("Navigate up").click();
		
	/*	
		//FreeCharge
		 	Thread.sleep(3000);
		pay_Link.get(3);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("Navigate up")));
		driver.findElementByAccessibilityId("Navigate up").click();
		//Amazon Pay
		Thread.sleep(3000);
		pay_Link.get(2);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("Navigate up")));
		driver.findElementByAccessibilityId("Navigate up").click();
		 
		 
		*/
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	
	@Test(priority = 2,enabled = true)
	public void premium_Consultation() throws Throwable {
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		
AndriodPom m = new AndriodPom();
		WebDriverWait wait= new WebDriverWait(driver, 60);
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
		
		
		///////
		
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
		try {
		Thread.sleep(5000);
		driver.findElementByAccessibilityId("Navigate up").click();
		//btnclick(m.getFooter_HomePage());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		for (int i = 0; i < 10; i++) {
			
			Thread.sleep(3000);
			driver.swipe(0, 1000, 0, 0, 1000);
			
			if (m.getConsultation_Btn_List().size()==1) {
				
				Thread.sleep(3000);
				btnclick(m.getConsultation_Btn());
				break;
			} else {
				
				System.out.println("Swipe Down to click on Consult Now Button");

			}
			
			
			
		}
		
		
		Thread.sleep(10000);
		driver.swipe(0, 700, 0, 0, 1000);
		
	 Thread.sleep(3000);
	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/txt_consult_now"))));
	 btnclick(driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/txt_consult_now")));
	 
	 Thread.sleep(3000);
	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/img_filter"))));
	 
	 driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/img_filter")).click();
	 
	 Thread.sleep(10000);
	 List<WebElement> con_filter = driver.findElements(By.xpath("//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/checked']"));
	 
	 Thread.sleep(3000);
	 for (int i = 0; i < 1; i++) {
		
		 Thread.sleep(3000);
		 con_filter.get(0).click();
		 
	}
	 
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//android.widget.TextView[@text='APPLY']")).click();
	 Thread.sleep(3000);
	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/text_consult_now']"))));
	 driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/text_consult_now']")).click();
	 
	 
	 Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_MySelf()));
		btnclick(m.getConsult_MySelf());
		
		Thread.sleep(3000);
		type(m.getConsult_Symptons_TextBox(), "Ear pain");
		
		driver.hideKeyboard();
		
		/*
		Thread.sleep(3000);
		btnclick(m.getConsult_Specialist_ViewAll());
		
		
		Thread.sleep(3000);
		btnclick(m.getConsult_ENT());
		
		
		Thread.sleep(3000);
		btnclick(m.getConsult_specilaisation_DoneBtn());
		*/
		Thread.sleep(3000);
		btnclick(m.getConsult_general_Physician());
		
		Thread.sleep(3000);
		btnclick(m.getSTART_CONSULTATION_BTN());
		
		try {
		Thread.sleep(3000);
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/text_today_tom_slot")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/text_multi_choice']")).click();
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("com.NetmedsMarketplace.Netmeds:id/txt_view_schedule_consultation")).click();
		} catch (Exception e) {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/text_multi_choice']")).click();
			
			
			Thread.sleep(3000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/txt_view_schedule_consultation")).click();
			
		}
		
		
	
		//wait.until(ExpectedConditions.visibilityOf(m.getConsult_Chat_Text()));
		Thread.sleep(7000);
		/*
		wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_Doctor_select_btn()));
		Thread.sleep(3000);
		btnclick(m.getConsult_Doctor_select_btn());
		*/
	//	wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_Chat()));
		btnclick(driver.findElement(By.xpath("//android.widget.TextView[@text='Chat']")));//.getConsult_Chat());
		
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/btn_make_payment"))));
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/btn_make_payment")).click();
		try {
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_wallet_link']"))));
		List<WebElement> pay_Link = driver.findElements(By.xpath("android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_wallet_link']"));
	
		//Mobiwik
		Thread.sleep(3000);
		pay_Link.get(0);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("Navigate up")));
		driver.findElementByAccessibilityId("Navigate up").click();
		
		//PayTM 
		Thread.sleep(3000);
		pay_Link.get(1);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("Navigate up")));
		driver.findElementByAccessibilityId("Navigate up").click();
		
	/*	
		//FreeCharge
		 	Thread.sleep(3000);
		pay_Link.get(3);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("Navigate up")));
		driver.findElementByAccessibilityId("Navigate up").click();
		//Amazon Pay
		Thread.sleep(3000);
		pay_Link.get(2);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByAccessibilityId("Navigate up")));
		driver.findElementByAccessibilityId("Navigate up").click();
		 
		 
		*/
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
		
		
		

		
	
	
}
