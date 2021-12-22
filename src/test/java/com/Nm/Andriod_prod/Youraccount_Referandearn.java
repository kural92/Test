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

public class Youraccount_Referandearn extends MobileBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.UDID, UDID);//"c195de14"
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


	// **************************************************************refer and
	// earn*************************************************************************************//

	@Test(enabled = true)
	public void Referearn() throws Throwable {

		logger = report.createTest("Refer and earn");
		logger.log(Status.PASS, "*************Refer and earn********************");

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

// Step 4 : Navigate to Refer and earn

		driver.swipe(0, 1100, 0, 0, 1000);
		
		Thread.sleep(3000);

		btnclick(m.getReferearnpage());
		Thread.sleep(3000);
		
		logger.log(Status.PASS, "Successfully navigate to refer and earn page");

		System.out.println("Successfully navigate to refer and earn page");

//Step 5 : Do assertion for all the text in refer and earn page//			

		Assert.assertEquals(gettext(m.getGrabyour()), "GRAB YOUR");
		
		System.out.println(m.getGrabyour().getText());
		Assert.assertEquals(gettext(m.getInstantrewards()), "Instant Rewards");
		
		System.out.println(m.getInstantrewards().getText());

		Assert.assertEquals(gettext(m.getSimplerway_txt()), "A simpler way to earn and get discounts");
		
		System.out.println(m.getSimplerway_txt().getText());

		Assert.assertEquals(gettext(m.getInvite()), "Invite your friends and family");
		
		System.out.println(m.getInvite().getText());

		Assert.assertEquals(gettext(m.getShare_netemed_app_txt()),
				"share the Netmeds app download link & Referral code with your friends and family");

			System.out.println(m.getShare_netemed_app_txt().getText());
		Assert.assertEquals(gettext(m.getYouget_txt()), "You get");
		
		System.out.println(m.getYouget_txt().getText());

		Assert.assertEquals(gettext(m.getNMSSupercash_txt()), "Rs.150 NMS SuperCash - after your Friend’s first order is delivered!");
		
		System.out.println(m.getNMSSupercash_txt().getText());

		Assert.assertEquals(gettext(m.getYourfrndsget_txt()), "Your Friends Get");

		System.out.println(m.getYourfrndsget_txt().getText());
		
	
		Assert.assertTrue(gettext(m.getFlat20offer_txt()).contains("Flat 20% off"));

		System.out.println(m.getFlat20offer_txt().getText());
		

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");
//Step 6: Referral code check//
		Thread.sleep(3000);
		String Actualreferralcodenumber = m.getYourreferralcode().getText();

		String Originalreferralcodenumber = "AMUD9230";//TEST1932

		Assert.assertEquals(Actualreferralcodenumber, Originalreferralcodenumber);

		System.out.println(Actualreferralcodenumber);

		Thread.sleep(3000);
		
		//Step 9 : Click share link

		btnclick(m.getsharelink());
		Thread.sleep(3000);

		logger.log(Status.PASS, "Share link was opened successfully");
		System.out.println("Share link was opened successfully");

driver.navigate().back();
	//	driver.findElement(By.id("miui:id/buttonPanel")).click();

		
		//Copy Code
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Copy']")).click();
		Thread.sleep(3000);
		System.out.println("Code was succesfully copied");


		

		//btnclick(m.getTermscondition_link());



		driver.navigate().back();
		Thread.sleep(3000);


		logger.log(Status.PASS, "refer and earn page is working properly");
		System.out.println("refer and earn page is working properly");
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
