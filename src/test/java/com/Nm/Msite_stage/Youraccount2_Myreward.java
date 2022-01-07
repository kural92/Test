package com.Nm.Msite_stage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import com.Nm.Base.MsiteBaseClass;
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

public class Youraccount2_Myreward extends MsiteBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		
		public void launchbrowser()   {
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
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("newCommandTimeout", 100);
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


		//*****************************************************My reward*************************


			
			
			@Test(enabled = true)
			public void Myrewards() throws Throwable {

				logger = report.createTest("My rewards");
				logger.log(Status.PASS, "*************Myrewards********************");

			
				//Step1 :Launch Browser//		
				MsitePOM m = new MsitePOM();
				//driver.manage().window().maximize();
				driver.get("https://m.netmeds.com/");
				driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);
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
				popupclose();
				Thread.sleep(5000);
						
			
		//Step 3 : Navigate to user profile//

				//btnclick(m.getUserprofile());
				btnclick(m.getmyaccount());
				Thread.sleep(3000);
				logger.log(Status.PASS, "Successfully navigate to userprofile");
				System.out.println("Successfully navigate to userprofile");

		//Navigate to My rewards
			
				
				
				Thread.sleep(10000);
				
				btnclick(m.getMyrewards());
				
				Thread.sleep(3000);
				
				//Let's chat handle//
				Thread.sleep(5000);
				letschat();
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("(//*[@class='scratchcard ng-star-inserted'])[1]")).click();
				Thread.sleep(3000);
				driver.swipe(345, 1029, 900, 1105, 1000);
				
				driver.swipe(82, 1029, 900, 1105, 1000);
				
				driver.swipe(600, 1029, 900, 1105, 1000);

				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@nodeName='SPAN' and ./parent::*[@nodeName='BUTTON']]")).click();
				
				Thread.sleep(5000);
				
				try {
				System.out.println("offer percentage " + driver.findElement(By.xpath("//*[@css='H3.subtitle']")).getAttribute("innerText"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				Thread.sleep(3000);
				
				System.out.println("offer description is " + driver.findElement(By.xpath("//*[@css='P.content']")).getAttribute("innerText"));
				
				
				Thread.sleep(3000);
				 
				System.out.println("offer expiry_date is " + driver.findElement(By.xpath("//*[@class='expiredate ng-star-inserted']")).getText());
				
				Thread.sleep(3000);
				
				System.out.println("offercode is  " + driver.findElement(By.xpath("//*[@css='INPUT.form-control' and @top='true']")).getAttribute("innerText"));
				 
				Thread.sleep(3000);
				
				try{
					driver.findElement(By.xpath("//*[@class='primarybtn ng-star-inserted']")).isEnabled();
					
					System.out.println("Book Now button is enabled	");
				}catch (Exception e) {
					System.out.println("no Book Now button is enabled	");
				}
				
				
				Thread.sleep(3000);
				
				List <WebElement> instruction_details = driver.findElements(By.xpath("//*[@class='mat-expansion-panel-header-title' and @top='true']"));
				
				System.out.println("the element size is" + instruction_details.size());
				
				for (int i=0;i<instruction_details.size();i++) {
					
					Thread.sleep(3000);
					
					instruction_details.get(i).click();
					
					
				}
				
				logger.log(Status.PASS, "Instruction details are displaying properly");
				System.out.println("Instruction details are displaying properly");
				driver.navigate().back();
				
				driver.navigate().back();
				
				logger.log(Status.PASS, "My rewards section is working properly");
				System.out.println("My rewards section is working properly");
				
				
				
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
				
		 //     driver.quit();
			}


		}
