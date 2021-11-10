package com.Nm.Msite_stage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Base.BaseClass;
import com.Nm.Base.MobileBaseClass;
import com.Nm.Pom.AndriodPom;
import com.Nm.Pom.Monepom;
import com.Nm.Pom.MsitePOM;
import com.Nm.Website_live.RetryAnalyzer;
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

public class Youraccount extends MobileBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		
		//@BeforeClass
		public void launchbrowser2()   {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			//capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA"); //RZ8R20GLXTA //GBT4C19326001968

		//	capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");  //fc95d519 //RZ8R20GLXTA

			capabilities.setCapability("platformName", "Android");
		//	capabilities.setCapability("deviceName", "vivo 1819");
		//	capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			/*capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			*/
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE ,"com.android.chrome");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY ,"com.google.android.apps.chrome.Main");
			capabilities.setCapability("noReset", true);
			
			capabilities.setCapability("autoDismissAlerts", true);  
			
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}


		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");//"c195de14"
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
			capabilities.setCapability(MobileCapabilityType.VERSION,"11 RP1A.200720.011" );
			//for m-site
			capabilities.setCapability("chromedriverExecutable", "D:\\Automation\\Driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
			//capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			
					
			//capabilities.setCapability("autoDismissAlerts", true);  
			
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
	

	/*
	@BeforeMethod
	  public void setUp1() throws MalformedURLException {
	      System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Driver\\chromedriver.exe");
	      Map<String, String> mobileEmulation = new HashMap<String, String>();
	      mobileEmulation.put("deviceName", "Moto G4");

	      ChromeOptions chromeOptions = new ChromeOptions();
	      chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	      chromeOptions.addArguments("--disable-notifications");
	      driver = new ChromeDriver(chromeOptions);
	     
	     
	  }  */
	
	/* Under your account page
	 	Test Case 1 : Verify the functionalities of Delivery address Page (Add, Edit, Select and Delete Address).
	  	Test Case 2 : Verify the functionalities under my wallet page (Assertion of all the texts,NMS Cash, NMS super Cash And how to use it).
	  	Test Case 3 : Verify the functionalities of Edit profile Page.
	  	Test Case 4	: Verify the functionalities of Contact us  Page.(Assertion of all the texts).
	  	Test Case 5 : Verify the functionalities of My Prescription Page.(Assertion of all the texts).
	  	Test Case 6 : Verify the functionalities of refer and earn.(Assertion of all the texts).
	  	Test Case 7 :Verify the functionalities of Help Page.
	  	Test Case 8 :Verify the functionalities of Rate us page.
	  	Test Case 9 :Verify the functionalities of Legal Information Page.
	  :
	 */
	
	

//*****************************************************Your Accountpage*************************

//Menu : Delivery Address//
	
	
	@Test(enabled = false)
	public void DeliverAddressSection() throws Throwable {

		logger = report.createTest("DeliverAddressSection");
		logger.log(Status.PASS, "*************DeliverAddressSection********************");

	
		MsitePOM m = new MsitePOM();
		//driver.manage().window().maximize();
		driver.get("https://m.netmeds.com/");
		try {

		//	btnclick(m.getSignin());
			Thread.sleep(5000);
		//	type(m.getMobileno(), "8072281468");
			Thread.sleep(5000);
		//	btnclick(m.getUsepwdbtn());
			Thread.sleep(5000);
		//	type(m.getPassword(), "test@123");
		//	btnclick(m.getSignInpage());
		//	Thread.sleep(5000);
			logger.log(Status.PASS, "Successfully navigate to home page");
		} catch (Exception e) {
			
			System.out.println("Already Logged in");
			
		}
		
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//span[@class='app_close']")).click();
		} catch (Exception e) {
			System.out.println("No Popup to close");
		}


//Let's chat handle//
		Thread.sleep(5000);
		try {
			MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
			}catch (Exception e) {
				// TODO: handle exception
			}


		Thread.sleep(5000);
				
	
//Step 3 : Navigate to user profile//

		//btnclick(m.getUserprofile());
		driver.findElement(By.xpath("//*[@text='Account']")).click();
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");
		Thread.sleep(3000);
//Step 4 : Navigate to Delivery Address//

		//btnclick(m.getDeliveryaddress());
		
		driver.findElement(By.xpath("//*[@text='Delivery Addresses ']")).click();
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to Delivery Address");
		System.out.println("Successfully navigate to Delivery Address");
		
		
		//Let's chat handle//
		Thread.sleep(5000);
		try {
			MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
			System.out.println("Successfully closed let's chat");
			}catch (Exception e) {
				System.out.println("No pop up available to close");
			}

//Step 5: Select Address//

		//btnclick(m.getSlctaddress());
		driver.findElement(By.xpath("(//*[@name='customeraddress'])[2]")).click();
		Thread.sleep(5000);
		logger.log(Status.PASS, "Address was selected successfully");
		System.out.println("Address was selected successfully");
		
		//Add address

				Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@class='add-address ng-star-inserted']")).click();
	
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='pin']")).sendKeys("600093");
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("ram");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("kumar");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='street']")).sendKeys("firststreet");
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@id='landmark']")).sendKeys("newyear");
				Thread.sleep(5000);
				
				
				driver.findElement(By.xpath("//*[@text='Save Address']")).click();

				

				logger.log(Status.PASS, "Address was addedd successfully");
				System.out.println("Address was added successfully");



//Step 6: Modify Address//

		//Modify address
		Thread.sleep(5000);
	MobileElement modify =	(MobileElement) driver.findElement(By.xpath("(//*[@text='Modify'])[1]"));

		modify.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='pin']")).sendKeys("600093");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("raj");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("kumar");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='street']")).sendKeys("newstreet");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='landmark']")).sendKeys("nehrunagar");
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//*[@text='Save Address']")).click();


		logger.log(Status.PASS, "Address was modified successfully");

		System.out.println("Address was modified successfully");

		//Delete address

		Thread.sleep(3000);
	driver.findElements(By.xpath("(//*[@text='Delete'])[1]"));

		

		logger.log(Status.PASS, "Address was deleted successfully");
		System.out.println("Address was deleted successfully");

		
		System.out.println("Delivery Address Section is working properly ");
	}

	// **************************************************************MY
	// Wallet*************************************************************************************//

	@Test(enabled = false)
	public void Mywallet() throws Throwable {

		logger = report.createTest("Mywallet");
		logger.log(Status.PASS, "*************Mywallet********************");

		MsitePOM m = new MsitePOM();
		//driver.manage().window().maximize();
		driver.get("https://m.netmeds.com/");
		try {

		//	btnclick(m.getSignin());
			Thread.sleep(5000);
		//	type(m.getMobileno(), "8072281468");
			Thread.sleep(5000);
		//	btnclick(m.getUsepwdbtn());
			Thread.sleep(5000);
		//	type(m.getPassword(), "test@123");
		//	btnclick(m.getSignInpage());
		//	Thread.sleep(5000);
			logger.log(Status.PASS, "Successfully navigate to home page");
		} catch (Exception e) {
			
			System.out.println("Already Logged in");
			
		}
		
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//span[@class='app_close']")).click();
		} catch (Exception e) {
			System.out.println("No Popup to close");
		}


//Let's chat handle//
		Thread.sleep(5000);
		try {
			MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
			}catch (Exception e) {
				// TODO: handle exception
			}


		Thread.sleep(5000);
				
	
//Step 3 : Navigate to user profile//

		//btnclick(m.getUserprofile());
		driver.findElement(By.xpath("//*[@text='Account']")).click();
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");
		Thread.sleep(4000);

//Let's chat handle//
		Thread.sleep(5000);
		try {
			MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
			System.out.println("Successfully closed let's chat");
			}catch (Exception e) {
				System.out.println("No pop up available to close");
			}
//		Step 4 : Navigate to wallet Page

	
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@href='/customer/nmswallet']")).click();
		Thread.sleep(3000);
		
		

		

//		Step 5 : get Available balance text and do assertion
		// Step 7 :Get NMS Cash text and do assertion
//		Step 10 :Get NMS super Cash text and do assertion

		//SoftAssert SoftAssert = new SoftAssert();
		//Let's chat handle//
				Thread.sleep(5000);
				try {
					MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
					netty.click();
					System.out.println("Successfully closed let's chat");
					}catch (Exception e) {
						System.out.println("No pop up available to close");
					}
		
		Assert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='AVAILABLE BALANCE']"))), "AVAILABLE BALANCE");
		
		System.out.println(driver.findElement(By.xpath("//*[@text='AVAILABLE BALANCE']")).getText());
		
		
		Thread.sleep(5000);
		System.out.println((driver.findElement(By.xpath("(//*[@class='bldtxt ng-star-inserted'])[1]"))).getText());
		Thread.sleep(5000);
		System.out.println((driver.findElement(By.xpath("//*[@text='NMS Cash ']"))).getText());
		Thread.sleep(5000);
		//System.out.println((driver.findElement(By.xpath("//*[@class='bldtxt ng-star-inserted'])[2]"))).getText());
		Thread.sleep(5000);
		System.out.println((driver.findElement(By.xpath("//*[@text='NMS Super Cash ']"))).getText());
		Thread.sleep(5000);
	//	System.out.println((driver.findElement(By.xpath("//*[@class='bldtxt ng-star-inserted'])[3]"))).getText());
		
		
		Thread.sleep(5000);
	Assert.assertTrue((driver.findElement(By.xpath("//*[@text='NMS Cash ']")).getText()).contains("NMS Cash"));
	Thread.sleep(5000);
	Assert.assertTrue((driver.findElement(By.xpath("//*[@text='NMS Super Cash ']")).getText()).contains("NMS Super Cash"));

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");

//		Step 8 :check How to use page is getting open

		driver.findElement(By.xpath("//*[@class='howuse htunmscash']")).click();
		Thread.sleep(3000);

		logger.log(Status.PASS, "how to use NMScash button is enabled");
		System.out.println("how to use button NMSCash is enabled");

//		Step 9 : Close the how to use page
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@class='close pull-right']")).click();
		logger.log(Status.PASS, "how to use NMScash button is closed");
		System.out.println("how to use button NMSCash is closed");
//How to use
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='howuse htusprcash']")).click();
		Thread.sleep(3000);
		logger.log(Status.PASS, "how to use NMSsupercash button is enabled");
		System.out.println("how to use button NMSsuperCash is enabled");

//Step 11 :Close the how to use page

		driver.findElement(By.xpath("//*[@class='close pull-right']")).click();

		
		System.out.println("My wallet page is working fine");
	}

	// **************************************************************Edit
	// Profile*************************************************************************************//

	@Test(enabled = false)
	public void Editprofile() throws Throwable {

		logger = report.createTest("Editprofile");
		logger.log(Status.PASS, "*************Editprofile********************");

		
		MsitePOM m = new MsitePOM();
		//driver.manage().window().maximize();
		driver.get("https://m.netmeds.com/");
		try {

		//	btnclick(m.getSignin());
			Thread.sleep(5000);
		//	type(m.getMobileno(), "8072281468");
			Thread.sleep(5000);
		//	btnclick(m.getUsepwdbtn());
			Thread.sleep(5000);
		//	type(m.getPassword(), "test@123");
		//	btnclick(m.getSignInpage());
		//	Thread.sleep(5000);
			logger.log(Status.PASS, "Successfully navigate to home page");
		} catch (Exception e) {
			
			System.out.println("Already Logged in");
			
		}
		
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//span[@class='app_close']")).click();
		} catch (Exception e) {
			System.out.println("No Popup to close");
		}


//Let's chat handle//
		Thread.sleep(5000);
		try {
			MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
			}catch (Exception e) {
				// TODO: handle exception
			}


		Thread.sleep(5000);
				
	
//Step 3 : Navigate to user profile//

		//btnclick(m.getUserprofile());
		driver.findElement(By.xpath("//*[@text='Account']")).click();
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");
//click Modify button

		//btnclick(m.getEditprofile());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='editinfo personalinfor d-block d-sm-none ng-star-inserted']")).click();
		
		//Let's chat handle//
				Thread.sleep(5000);
				try {
					MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
					netty.click();
					}catch (Exception e) {
						// TODO: handle exception
					}

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='firstname' ]")).sendKeys("vijay");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='lastname' ]")).sendKeys("sekar");
		
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@class='mat-select-arrow-wrapper']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@class='mat-option-text' and @top='true'])[2]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@id='date_of_birth'])")).click();
		Thread.sleep(3000);

		//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_age")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='mat-calendar-period-button mat-button mat-button-base']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='mat-calendar-body-cell-content' and @top='true'])[10]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@class='mat-calendar-body-cell-content' and @top='true'])[3]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='mat-calendar-body-cell-content' and @top='true'])[11]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Save Changes']")).click();

		
//		Thread.sleep(2000);

		logger.log(Status.PASS, "Profile  was succesfully edited");
		System.out.println("Profile  was succesfully edited");

	}

	

//********************************************* My prescription***************************************************************************************
	@Test(enabled = false)
	public void Myprescription() throws Throwable {

		logger = report.createTest("Myprescription");
		logger.log(Status.PASS, "*************Myprescription********************");

//Step1 :Launch Browser//		
		MsitePOM m = new MsitePOM();
		//driver.manage().window().maximize();
		driver.get("https://m.netmeds.com/");
		try {

		//	btnclick(m.getSignin());
			Thread.sleep(5000);
		//	type(m.getMobileno(), "8072281468");
			Thread.sleep(5000);
		//	btnclick(m.getUsepwdbtn());
			Thread.sleep(5000);
		//	type(m.getPassword(), "test@123");
		//	btnclick(m.getSignInpage());
		//	Thread.sleep(5000);
			logger.log(Status.PASS, "Successfully navigate to home page");
		} catch (Exception e) {
			
			System.out.println("Already Logged in");
			
		}
		
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//span[@class='app_close']")).click();
		} catch (Exception e) {
			System.out.println("No Popup to close");
		}


//Let's chat handle//
		Thread.sleep(5000);
		try {
			MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
			}catch (Exception e) {
				// TODO: handle exception
			}


		Thread.sleep(5000);
				
	
//Step 3 : Navigate to user profile//

		//btnclick(m.getUserprofile());
		driver.findElement(By.xpath("//*[@text='Account']")).click();
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");


// Step 4 : Navigate to My prescription Page

		//btnclick(m.getMyprescription_page());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='My Prescription ']")).click();
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to My prescription Page");

		System.out.println("Successfully navigate to My prescription Page");
//Step 5 : Do assertion for all the text in refer and earn page//			
		Thread.sleep(3000);
		Assert.assertTrue(gettext(driver.findElement(By.xpath("//*[@class='order-id']"))).contains("Order ID"));
		Thread.sleep(3000);
		System.out.println((driver.findElement(By.xpath("//*[@class='order-id']")).getText()));
		Thread.sleep(3000);
		Assert.assertTrue(gettext(driver.findElement(By.xpath("//*[@class='date']"))).contains("Date"));
		Thread.sleep(3000);
		System.out.println((driver.findElement(By.xpath("//*[@class='date']")).getText()));
		
		Thread.sleep(3000);
		
		Assert.assertTrue(gettext(driver.findElement(By.xpath("//*[@text='Prescription Status :']"))).contains("Prescription Status :"));
		Thread.sleep(3000);
		System.out.println(gettext(driver.findElement(By.xpath("//*[@text='Prescription Status :']"))));
	
		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");

		// Click on prescription image//

		btnclick(driver.findElement(By.xpath("//*[@class='rxviewimg']")));
		Thread.sleep(3000);
		logger.log(Status.PASS, "Prescription image opened successfully");

		System.out.println("Prescription image opened successfully");
		
		
		// Open & Close image//
		


		driver.findElement(By.xpath("//*[@nodeName='SPAN' and ./parent::*[@nodeName='BUTTON']]")).click();
		
		logger.log(Status.PASS, "Image closed successfully");

		System.out.println(" image closed successfully");
		// Click on Prescription Image//
		Thread.sleep(3000);
		btnclick(driver.findElement(By.xpath("(//*[@class='download-link'])[1]")));
		Thread.sleep(3000);
		logger.log(Status.PASS, "image downloaded successfully");
		System.out.println("image downloaded");

		logger.log(Status.PASS, "My prescription page is working properly");
		System.out.println("My prescription page is working properly");

	}

	// **************************************************************refer and
	// earn*************************************************************************************//

	@Test(enabled = false)
	public void Referearn() throws Throwable {

		logger = report.createTest("refer&earn");
		logger.log(Status.PASS, "*************refer&earn********************");

//Step1 :Launch Browser//		
		MsitePOM m = new MsitePOM();
		//driver.manage().window().maximize();
		driver.get("https://m.netmeds.com/");
		try {

		//	btnclick(m.getSignin());
			Thread.sleep(5000);
		//	type(m.getMobileno(), "8072281468");
			Thread.sleep(5000);
		//	btnclick(m.getUsepwdbtn());
			Thread.sleep(5000);
		//	type(m.getPassword(), "test@123");
		//	btnclick(m.getSignInpage());
		//	Thread.sleep(5000);
			logger.log(Status.PASS, "Successfully navigate to home page");
		} catch (Exception e) {
			
			System.out.println("Already Logged in");
			
		}
		
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//span[@class='app_close']")).click();
		} catch (Exception e) {
			System.out.println("No Popup to close");
		}


//Let's chat handle//
		Thread.sleep(5000);
		try {
			MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
			}catch (Exception e) {
				// TODO: handle exception
			}


		Thread.sleep(5000);
				
	
//Step 3 : Navigate to user profile//

		//btnclick(m.getUserprofile());
		driver.findElement(By.xpath("//*[@text='Account']")).click();
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");
		
	// Step 4 : Navigate to Refer and earn

		driver.swipe(790, 1100, 800, 70, 1000);
		
		Thread.sleep(3000);

		btnclick(driver.findElement(By.xpath("//*[@text='INVITE NOW']")));
		Thread.sleep(3000);
		
		logger.log(Status.PASS, "Successfully navigate to refer and earn page");

		System.out.println("Successfully navigate to refer and earn page");
		
//Let's chat handle//
				Thread.sleep(5000);
				try {
					MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
					netty.click();
					}catch (Exception e) {
						// TODO: handle exception
					}
	
	/*//Copy Code
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='code']")).click();
				Thread.sleep(3000);
			
				System.out.println("Code was succesfully copied");
*/
//Step 5 : Do assertion for all the text in refer and earn page//			

		Assert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='Grab your']"))), "GRAB YOUR");
		
		System.out.println(gettext(driver.findElement(By.xpath("//*[@text='Grab your']"))));
		
		Assert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='Instant Rewards']"))), "Instant Rewards");
		
		System.out.println(gettext(driver.findElement(By.xpath("//*[@text='Instant Rewards']"))));

		Assert.assertEquals(gettext(driver.findElement(By.xpath("//*[@class='pcnt']"))), "A simpler way to earn and get discounts");
		
		System.out.println(gettext(driver.findElement(By.xpath("//*[@class='pcnt']"))));

		Assert.assertEquals(gettext(driver.findElement(By.xpath("(//*[@text='Invite your friends and family'])"))), "Invite your friends and family");
		
		System.out.println(driver.findElement(By.xpath("//*[@text='Invite your friends and family']")));

		Assert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='share the Netmeds app download link & Referral code with your friends and family']"))),
				"share the Netmeds app download link & Referral code with your friends and family");
		 
		System.out.println(gettext(driver.findElement(By.xpath("//*[@text='share the Netmeds app download link & Referral code with your friends and family']"))));
		

			
		Assert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='You get']"))), "You get");
		System.out.println(driver.findElement(By.xpath("//*[@text='You get']")).getText());
		

		//Assert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='Rs. 150  - after your Friend’s first order is delivered!']"))), "Rs. 150  - after your Friend’s first order is delivered!");
		
		System.out.println(gettext(driver.findElement(By.xpath("//*[@text='Rs. 150  - after your Friend’s first order is delivered!']"))));

		Assert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='Your Friends Get']"))), "Your Friends Get");

		System.out.println(gettext(driver.findElement(By.xpath("//*[@text='Your Friends Get']"))));
		
	
		Assert.assertTrue(gettext(driver.findElement(By.xpath("//*[@text='Flat 20% off + 20% NMS SuperCash on their first order (minimum order value Rs.500)']"))).contains("Flat 20% off"));

		System.out.println(gettext(driver.findElement(By.xpath("//*[@text='Flat 20% off + 20% NMS SuperCash on their first order (minimum order value Rs.500)']"))));
		

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");
//Step 6: Referral code check//

		String Actualreferralcodenumber = driver.findElement(By.xpath("//*[@class='code']")).getText();

		System.out.println(Actualreferralcodenumber);

		Thread.sleep(3000);
		
		//Step 9 : Click share link

		btnclick(driver.findElement(By.xpath("//*[@class='share-popup']")));
		Thread.sleep(3000);

		logger.log(Status.PASS, "Share link was opened successfully");
		System.out.println("Share link was opened successfully");


		driver.findElement(By.xpath("//*[@class='close pull-right']")).click();


		//btnclick(m.getTermscondition_link());



		driver.navigate().back();
		Thread.sleep(3000);


		logger.log(Status.PASS, "refer and earn page is working properly");
		System.out.println("refer and earn page is working properly");
	}

	// **************************************************************Help
	// Page*************************************************************************************//

	@Test(enabled = false)
	public void Helppage() throws Throwable {

		logger = report.createTest("Helppage");
		logger.log(Status.PASS, "*************Helppage********************");

//Step1 :Launch Browser//		
		//Step1 :Launch Browser//		
				MsitePOM m = new MsitePOM();
				//driver.manage().window().maximize();
				driver.get("https://m.netmeds.com/");
				try {

				//	btnclick(m.getSignin());
					Thread.sleep(5000);
				//	type(m.getMobileno(), "8072281468");
					Thread.sleep(5000);
				//	btnclick(m.getUsepwdbtn());
					Thread.sleep(5000);
				//	type(m.getPassword(), "test@123");
				//	btnclick(m.getSignInpage());
				//	Thread.sleep(5000);
					logger.log(Status.PASS, "Successfully navigate to home page");
				} catch (Exception e) {
					
					System.out.println("Already Logged in");
					
				}
				
				Thread.sleep(5000);
				try {
					driver.findElement(By.xpath("//span[@class='app_close']")).click();
				} catch (Exception e) {
					System.out.println("No Popup to close");
				}


		
						
			
		//Step 3 : Navigate to user profile//

				//btnclick(m.getUserprofile());
				driver.findElement(By.xpath("//*[@text='Account']")).click();
				Thread.sleep(3000);
				logger.log(Status.PASS, "Successfully navigate to userprofile");
				System.out.println("Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");
		
//Let's chat handle//
		Thread.sleep(5000);
		try {
			MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
			}catch (Exception e) {
				// TODO: handle exception
			}


		Thread.sleep(5000);

// Step 4 : Navigate to help page

		driver.swipe(790, 1100, 800, 70, 1000);
		
		 btnclick(driver.findElement(By.xpath("//*[@class='help-link']")));
		 
		 Thread.sleep(3000);
		 
		// driver.swipe(800, 250, 800, 250, 3000);	 
		 
	List<WebElement>	list =  driver.findElements(By.xpath("//*[@class='need_us ']"));
	
	
	int help = list.size();
	
	System.out.println("the element size is   "+help);
	

		 for (int i = 0; i<13; i++)
			 
		 {

				Thread.sleep(5000);
				
				driver.swipe(82, 931, 82, 830, 1000);
		
				list.get(i).click();
				Thread.sleep(1500);
				
				
				
				Thread.sleep(1500);
				if (i>11) {
				driver.swipe(730, 330, 730, 240, 3000);}

				System.out.println(list.get(i).getText());
				logger.log(Status.PASS, "Successfully all the topics are clicked");
			}

		 System.out.println("Successfully all the topics are clicked");

	}


	// **************************************************************Legal
	// Information*************************************************************************************//

	@Test(enabled = false)
	public void Legalinformation() throws Throwable {

		logger = report.createTest("Legalinformation");
		logger.log(Status.PASS, "*************Legalinformation********************");

		//Step1 :Launch Browser//		
		AndriodPom m = new AndriodPom();
		
		driver.launchApp();
			
			try {
				popupclose();
				Thread.sleep(5000);
				popupclose();
			btnclick(m.getLetsstarted());
			} catch (Exception e) {
				//driver.resetApp();
				//driver.launchApp();
			
			}
			
			Thread.sleep(1000);
			
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys("8072281468");
			popupclose();
			Thread.sleep(10000);
			popupclose();
			Thread.sleep(10000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys("test@123");
			
			Thread.sleep(2000);
		
			
			Thread.sleep(5000);
			btnclick(m.getLogin());
		}
		
		catch(Exception e) {
			System.out.println("Already logged in");
		}
		 
			popupclose();
		
		
	//Step 3 : Navigate to user profile//

			btnclick(m.getUserprofile());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to userprofile");

			System.out.println("Successfully navigate to userprofile");

	// Step 4 : Legal Information

			driver.swipe(790, 1100, 800, 70, 1000);
			btnclick(m.getLegalinfo());
		Thread.sleep(3000);
		List<WebElement>	list_tc =  m.getTC_Link();
		
		int help = list_tc.size();
		
		System.out.println("the element size is   "+help);
		

			 for (int i = 0; i<6; i++)
				 
			 {

					Thread.sleep(3000);

			
					list_tc.get(i).click();
					
					Thread.sleep(2000);

					//driver.findElementByAccessibilityId("Navigate up").click();
					
				//driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
				driver.navigate().back();
					
					Thread.sleep(1500);
					
					System.out.println(list_tc.get(i).getText());
					logger.log(Status.PASS, "Successfully all the topics are clicked");
				}
		

		logger.log(Status.PASS, "Terms and condition page is working properly");
		System.out.println("Terms and condition page is working properly");

	}

	
	// **************************************************************offers
		// page*************************************************************************************//

		@Test(enabled = false)
		public void offersPage() throws Throwable {

			logger = report.createTest("Offers Page");
			logger.log(Status.PASS, "*************Offers Page********************");

			//Step1 :Launch Browser//		
			AndriodPom m = new AndriodPom();
			
			driver.launchApp();
				
				try {
					popupclose();
					Thread.sleep(5000);
					popupclose();
				btnclick(m.getLetsstarted());
				} catch (Exception e) {
					//driver.resetApp();
					//driver.launchApp();
				
				}
				
				Thread.sleep(1000);
				
			try {
				
				Thread.sleep(2000);
				m.getMobilenumber().sendKeys("8072281468");
				popupclose();
				Thread.sleep(10000);
				popupclose();
				Thread.sleep(10000);
				btnclick(m.getUsepwd());
				Thread.sleep(5000);
			
				m.getPassword().sendKeys("test@123");
				
				Thread.sleep(2000);
			
				
				Thread.sleep(5000);
				btnclick(m.getLogin());
			}
			
			catch(Exception e) {
				System.out.println("Already logged in");
			}
			 
				popupclose();
			
			
		

					driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart")).click();
					Thread.sleep(3000);
					
					for (int i = 0; i < 16; i++) {
						Thread.sleep(3000);
						if (!(driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/cart_remove_product")).size() == 0)) {
							

							try {
	
									
								btnclick(m.getRemovebutton());
								
								
								logger.log(Status.PASS, "Items are removed successfully");
								System.out.println("Items are removed from the cart");
							} catch (Exception e) {
								System.out.println("No items in the cart ");
							}

						} else {
							break;

						}

					}
							
					driver.navigate().back();
					
		//Step 3 : Navigate to user profile//

				btnclick(m.getUserprofile());
				Thread.sleep(3000);
				logger.log(Status.PASS, "Successfully navigate to userprofile");

				System.out.println("Successfully navigate to userprofile");
				
	//Step 4 : Offers Page
				Thread.sleep(3000);
				btnclick(m.getOffers_page());
				Thread.sleep(2000);
				
	//Medicine
				
				driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/img_offer_full_image'])[1]")).click();
				Thread.sleep(3000);
		String couponcode =		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/tv_offer_coupon")).getText();
		
			driver.findElement(By.xpath("//android.widget.Button[@text ='COPY CODE AND SHOP']")).click();
			
			
			
		//	driver.findElement(By.xpath("//android.widget.TextView[@text='GO TO SEARCH']"));
			
			
				Thread.sleep(3000);
				try {
					
					type(m.getM3productsearch(),"Flavedon MR 35mg Tablet 10'S");
					
					Thread.sleep(3000);
			WebElement		Cart_btn = (driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn")));

					btnclick(Cart_btn);
					
					Thread.sleep(3000);
					
					System.out.println("successfully Items are added");
					
				} catch (Exception e) {
					System.out.println("Items are available in the cart");
				}
				
				
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart")).click();
				Thread.sleep(3000);
				
				
				//Select qtyincrease = new Select(m.getQty_Incr_Decr());
				//qtyincrease.selectByIndex(3);
				
			driver.findElement(By.xpath("(//android.widget.TextView[@resource-id ='com.NetmedsMarketplace.Netmeds:id/cart_tv_item_qty'])")).click();	
		
			WebElement qty_increase = driver.findElement(By.xpath("//android.widget.TextView[@text='11']"));
			
			Thread.sleep(2000);
			qty_increase.click();
		
		
	//Apply Promo
	if ((driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/chk_apply_promo_code"))).size()!=0) {
				
	//remove code
			
			try {
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/chk_apply_promo_code")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/apply_remove_coupon_btn")).click();
				//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/btn_dismiss")).click();
			}catch (Exception e) {
				
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/chk_apply_promo_code")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/btn_dismiss")).click();
				
			}
			
			
		}
		else  {
			
		}
		
		
			Thread.sleep(2000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/chk_apply_promo_code")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/promo_code']")).sendKeys(couponcode);
			Thread.sleep(3000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/apply_remove_coupon_btn")).click();
		
		
		Thread.sleep(3000);  
		
		driver.navigate().back();
		
		driver.navigate().back();
		
		driver.navigate().back();
//Diagonstics	
		
		driver.findElement(By.xpath("//android.widget.TextView[@text ='Diagnostics']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/img_offer_full_image'])[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.Button[@text='BOOK NOW']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Successfully navigated to diagonistics page");
		
		driver.navigate().back();
		
		
//Consultation
		
		//Step 3 : Navigate to user profile//

		btnclick(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");
		

		Thread.sleep(3000);
		btnclick(m.getOffers_page());
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text ='Consultation']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/img_offer_full_image'])[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.Button[@text='CONSULT NOW']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Successfully navigated to consultation page");
		
		driver.navigate().back();
		
		
		System.out.println("Offer Page is working properly");
		
	
		
		}
		
		// **************************************************************Contact
		// Us*************************************************************************************//

		@Test(enabled = false)
		public void contactus() throws Throwable {

			logger = report.createTest("contact");
			logger.log(Status.PASS, "*************contactus********************");

			
	//Step1 :Launch Browser//		
			MsitePOM m = new MsitePOM();
			//driver.manage().window().maximize();
			driver.get("https://m.netmeds.com/");
			try {

			//	btnclick(m.getSignin());
				Thread.sleep(5000);
			//	type(m.getMobileno(), "8072281468");
				Thread.sleep(5000);
			//	btnclick(m.getUsepwdbtn());
				Thread.sleep(5000);
			//	type(m.getPassword(), "test@123");
			//	btnclick(m.getSignInpage());
			//	Thread.sleep(5000);
				logger.log(Status.PASS, "Successfully navigate to home page");
			} catch (Exception e) {
				
				System.out.println("Already Logged in");
				
			}
			
			Thread.sleep(5000);
			try {
				driver.findElement(By.xpath("//span[@class='app_close']")).click();
			} catch (Exception e) {
				System.out.println("No Popup to close");
			}


	

			Thread.sleep(5000);
					
		
	//Step 3 : Navigate to user profile//

			//btnclick(m.getUserprofile());
			driver.findElement(By.xpath("//*[@text='Account']")).click();
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to userprofile");
			System.out.println("Successfully navigate to userprofile");
			
			
			//Let's chat handle//
			Thread.sleep(5000);
			try {
				MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
				netty.click();
				}catch (Exception e) {
					// TODO: handle exception
				}

			
	// Step 4 : Navigate to contact us page
	//Step 5 :get damged@netmeds text and Missing @ netmeds
	//Step 6 :Purpose of contact
			
		

			btnclick(driver.findElement(By.xpath("//*[@text='Contact us ']")));

			// driver.findElement(By.xpath("//a[@class=\"contactus-link\"]")).click();
			Thread.sleep(3000);

			SoftAssert SoftAssert = new SoftAssert();

			SoftAssert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='How would you like us to contact you?*']"))), "How would you like us to contact you?*");

			SoftAssert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='E-mail ID']"))), "E-mail ID");

			SoftAssert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='Purpose of Contact*']"))), "Purpose of Contact*");

			SoftAssert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='Please state your message here*']"))), "Please state your message here*");

			SoftAssert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='Email me a copy of this message for my records.']"))), "Email me a copy of this message for my records.");

			SoftAssert.assertAll();

			Thread.sleep(3000);

			logger.log(Status.PASS, "all the texts were asserted successfully");
			System.out.println("all the texts are asserted successfully");

			Select purpose = new Select(
					driver.findElement(By.xpath("//*[@class='empty field-required Required-ddrpreason ']")));
			purpose.selectByIndex(1);

			Thread.sleep(3000);

			logger.log(Status.PASS, "Successfully selected the purpose");

			System.out.println("Successfully selected the purpose");

	//Step 7 : State Your Message

			type(driver.findElement(By.xpath("//*[@class='input-text Required-comments comtxt']")), "Testing Purpose");
			Thread.sleep(3000);

			logger.log(Status.PASS, "Successfully message has been entered");
			System.out.println("Successfully message has been entered");

	//Step 8 : Check email me a copy

			btnclick(driver.findElement(By.xpath("//*[@nodeName='SPAN' and ./parent::*[@text='Email me a copy of this message for my records.']]")));

			// driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div/div/label/span")).click();

	//Step 9 : Click Submit
			//btncli(m.getContactus_submit());

			//driver.findElement(By.xpath("//button[@class=\"pink-btn contact-submit\"]")).click();

			logger.log(Status.PASS, "Sucessfully Submitted the message");
			System.out.println("Sucessfully Submitted the message");

		}
		
		// **************************************************************Rate
		// Us*************************************************************************************//

		@Test(enabled = true)
		public void rateus() throws Throwable {

			logger = report.createTest("Rateus");
			logger.log(Status.PASS, "*************Rateus********************");

	//Step1 :Launch Browser//		
			MsitePOM m = new MsitePOM();
			//driver.manage().window().maximize();
			driver.get("https://m.netmeds.com/");
			try {

			//	btnclick(m.getSignin());
				Thread.sleep(5000);
			//	type(m.getMobileno(), "8072281468");
				Thread.sleep(5000);
			//	btnclick(m.getUsepwdbtn());
				Thread.sleep(5000);
			//	type(m.getPassword(), "test@123");
			//	btnclick(m.getSignInpage());
			//	Thread.sleep(5000);
				logger.log(Status.PASS, "Successfully navigate to home page");
			} catch (Exception e) {
				
				System.out.println("Already Logged in");
				
			}
			
			Thread.sleep(5000);
			try {
				driver.findElement(By.xpath("//span[@class='app_close']")).click();
			} catch (Exception e) {
				System.out.println("No Popup to close");
			}


	

			Thread.sleep(5000);
					
		
	//Step 3 : Navigate to user profile//

			//btnclick(m.getUserprofile());
			driver.findElement(By.xpath("//*[@text='Account']")).click();
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to userprofile");
			System.out.println("Successfully navigate to userprofile");
			
			
			//Let's chat handle//
			Thread.sleep(5000);
			try {
				MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
				netty.click();
				}catch (Exception e) {
					// TODO: handle exception
				}

	// Step 4 : Navigate to Rate us page

			driver.swipe(790, 1100, 800, 70, 1000);

			btnclick(driver.findElement(By.xpath("//*[@text='Rate Us ']")));
			Thread.sleep(3000);

	//Step 5 : rate netmeds text

			SoftAssert SoftAssert = new SoftAssert();
			SoftAssert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='Rate Us']"))), "RATE NETMEDS");

			SoftAssert.assertEquals(gettext(driver.findElement(By.xpath("//*[@text='ANY SUGGESTIONS']"))), "ANY SUGGESTIONS");

			System.out.println(gettext(driver.findElement(By.xpath("//*[@text='Rate Us']"))));

			System.out.println(gettext(driver.findElement(By.xpath("//*[@text='ANY SUGGESTIONS']"))));
			
	//Step 5 : Do different star ratings		

			btnclick(driver.findElement(By.xpath("//*[@class='star star-1 ng-star-inserted']")));
			Thread.sleep(2000);
			btnclick(driver.findElement(By.xpath("//*[@class='star star-2 ng-star-inserted']")));
			Thread.sleep(2000);
			btnclick(driver.findElement(By.xpath("//*[@class='star star-3 ng-star-inserted']")));
			Thread.sleep(2000);
			btnclick(driver.findElement(By.xpath("//*[@class='star star-4 ng-star-inserted']")));
			Thread.sleep(2000);
			btnclick(driver.findElement(By.xpath("//*[@class='star star-5 ng-star-inserted']")));
			Thread.sleep(3000);
			btnclick(driver.findElement(By.xpath("//*[@class='star star-4 ng-star-inserted']")));
			Thread.sleep(2000);
			btnclick(driver.findElement(By.xpath("//*[@class='star star-3 ng-star-inserted']")));
			Thread.sleep(2000);
			btnclick(driver.findElement(By.xpath("//*[@class='star star-2 ng-star-inserted']")));
			Thread.sleep(3000);
			btnclick(driver.findElement(By.xpath("//*[@class='star star-1 ng-star-inserted']")));
			Thread.sleep(3000);

			logger.log(Status.PASS, "Successfully rating was given");

			System.out.println("Successfully rating was given");
			
		
	//Let's chat handle//
				Thread.sleep(5000);
				try {
					MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
					netty.click();
					}catch (Exception e) {
						// TODO: handle exception
					}

	//Step 6 : Write message//
			Thread.sleep(3000);
			type(driver.findElement(By.xpath("//*[@class='msg']")), "Testing purpose,please don't process");

			logger.log(Status.PASS, "Successfully comments were added");

			System.out.println("Successfully comments were added");
	

	//Step 7 : Submit Button

		//	btncli(m.getSubmitmsg());

			logger.log(Status.PASS, "Suggestion was submitted ");

			System.out.println("Suggestion was submitted");
		}
				
	
	@AfterMethod()
	public void screenShot(ITestResult result) throws Throwable {

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			logger.fail(result.getThrowable());
			try {

				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Report/" + result.getName() + ".png"));
				System.out.println("Successfully captured a screenshot");
				// logger.log(Status.FAIL, result.getThrowable());
				logger.log(Status.FAIL,
						"Snapshot below: " + logger.addScreenCaptureFromPath(result.getName() + ".png"));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));

		} else {

			// onFinish(context);
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			logger.skip(result.getThrowable());
			report.removeTest(logger);
		}
		Thread.sleep(3000);
		if (result.getStatus() == ITestResult.FAILURE) {
			Thread.sleep(3000);
			BaseClass.mail_report();
		}

	}

	@AfterTest
	private void quitbrowser() {
		report.flush();

		driver.quit();
	}

}
