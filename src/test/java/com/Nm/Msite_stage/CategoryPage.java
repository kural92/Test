package com.Nm.Msite_stage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CategoryPage extends MsiteBaseClass {

	
	
	
	
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
			capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse_WorkSpace\\Automation\\Driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			/*capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			*/
			capabilities.setCapability("newCommandTimeout", 100);
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE ,"com.android.chrome");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY ,"com.google.android.apps.chrome.Main");
			capabilities.setCapability("noReset", true);
			
			capabilities.setCapability("autoDismissAlerts", true);  
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("newCommandTimeout", 100);
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
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("newCommandTimeout", 100);	
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
	

   
//*****************************************************************Category Page   *********************************************************
	@Test(enabled = true)
	public void CategoryPage() throws Throwable {
		
		logger =  report.createTest("Category Page");
		logger.log(Status.PASS, "*************CategoryPage********************" );
		
		MsitePOM m = new MsitePOM();
		//driver.manage().window().maximize();
		driver.get("https://m.netmeds.com/");


	/*	try {

		//	btnclick(m.getSignin());
			Thread.sleep(5000);
		
			Thread.sleep(3000);
		//	btnclick(m.getUsepwdbtn());
			Thread.sleep(3000);
		//	type(m.getPassword(), "test@123");
		//	btnclick(m.getSignInpage());
		//	Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to home page");
		} catch (Exception e) {
			
			System.out.println("Already Logged in");
			
		}*/
		
		Thread.sleep(6000);
		
		popupclose() ;


//Let's chat handle//
		letschat();
		Thread.sleep(5000);
	
//  Remove existing items from the cart  //

		driver.findElement(By.xpath("//*[@class='counter']")).click();
		Thread.sleep(5000);
		
		
//Let's chat handle//
		Thread.sleep(5000);
		letschat();
		Thread.sleep(3000);
	//	driver.swipe(82, 1275, 82, 1152, 1000);
		//Switch to Native_App
		
		
        Set<String> contextNames = driver.getContextHandles();
        for (String strContextName : contextNames) {
            if (strContextName.contains("NATIVE_APP")) {
                driver.context("NATIVE_APP");
                break;
            }
        }
		for (int i = 0; i < 25; i++) {
			Thread.sleep(3000);
			if (!(driver.findElements(By.xpath("//*[@text='REMOVE']")).size() == 0)) {
				

				try {

					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@text='REMOVE']")).click();
					
					Thread.sleep(3000);
					logger.log(Status.PASS, "Items are removed successfully");
					System.out.println("Items are removed from the cart");
				} catch (Exception e) {
					System.out.println("No items in the cart ");
				}

			} else {
				break;

			}

		}
			
		 //Switch to Chrome browser
	    Set<String> contextNames1 = driver.getContextHandles();
	    for (String strContextName : contextNames1) {
	        if (strContextName.contains("CHROMIUM")) {
	            driver.context("CHROMIUM");
	            break;
	        }
	    }
			
	
	driver.navigate().back();
	
	//Wellness page
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@text='Wellness']")).click();
	System.out.println("Successfully Naviagted to Wellness Page");
	logger.log(Status.PASS, "Successfully Naviagted to Wellness Page");
	//View all
	Thread.sleep(4000);
	driver.navigate().to("https://m.netmeds.com/non-prescriptions");
	

	
	
	Navigating_to_category();
	
		
	System.out.println("Category Page is working properly");
		
		
		
	}
	
		
	
	
	
		
	
	@AfterMethod()
	public void screenShot(ITestResult result) throws Throwable {
		
	    if(result.getStatus() == ITestResult.FAILURE) {
	    	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	    	logger.fail(result.getThrowable());
	    	try {
				

				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Report/"+ result.getName()+".png"));
				System.out.println("Successfully captured a screenshot");
				//logger.log(Status.FAIL, result.getThrowable());
				logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath( result.getName()+".png"));
			
		
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	      }
	 
	    else if(result.getStatus() == ITestResult.SUCCESS) {
	    	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	    
	    }
	    else {
	    
	    	 // onFinish(context);
	    	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	    	logger.skip(result.getThrowable());
	    	report.removeTest(logger);
	    }
	    
	    
	    
	Thread.sleep(3000);
	if (result.getStatus() == ITestResult.FAILURE) {
		Thread.sleep(3000);
	//	BaseClass.mail_report();
	
		
	//	BaseClass.mail_report();
	}
	
	
	}	
		


	@AfterTest
	private void quitbrowser() {
		report.flush();
		
      //driver.quit();
	}


}
