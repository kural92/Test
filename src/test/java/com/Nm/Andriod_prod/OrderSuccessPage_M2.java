package com.Nm.Andriod_prod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
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

import com.Nm.Base.BaseClass;
import com.Nm.Base.MobileBaseClass;
import com.Nm.Pom.AndriodPom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class OrderSuccessPage_M2 extends MobileBaseClass {

	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.UDID, UDID);//"c195de14" //07c55fe10406
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
	

					
//***********************************Order Success Page M2*****************************************************************

@Test(enabled = true)
//retryAnalyzer=RetryAnalyzer.class)
public void OrderSuccesspageM2() throws Throwable {

		
		
		AndriodPom m = new AndriodPom();
		
		
		 
		try {
			
			
			
			
			try {
				Thread.sleep(5000);
			btnclick(m.getLetsstarted());
			} catch (Exception e) {
				driver.launchApp();
			}
			
			
			
			popupclose();
			popupclose();
			
			Thread.sleep(5000);
			try {
				btnclick(m.getLetsstarted());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
			Thread.sleep(2000);
			driver.hideKeyboard();
			
			Thread.sleep(2000);
			btnclick(m.getMobilenumber());
			
			Thread.sleep(2000);
			type(m.getMobilenumber(), "7010752043");
			
			
			//com.NetmedsMarketplace.Netmeds:id/btn_use_password
			
			Thread.sleep(2000);
			btnclick(m.getUsepwd());
			
			Thread.sleep(5000);
			Thread.sleep(2000);
			type(m.getPassword(), "Change@92");
			
			Thread.sleep(2000);
			btnclick(m.getLogin());
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
			Thread.sleep(10000);
			btnclick(driver.findElement(By.xpath("//android.widget.TextView[index='0']")));
			} catch (Exception e) {
				// TODO: handle exception
			}

			
			
			
		} catch (Exception e) {
			System.err.println("Already Logged in");
		}
		
		
	
		
		Thread.sleep(2000);
		btnclick(m.getM2_OrderNow());
		
		
		Thread.sleep(10000); // PAST RX
		btnclick(driver.findElementByAccessibilityId("Past Rx"));
		
		
		
		Thread.sleep(2000);
		btnclick(driver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id='com.NetmedsMarketplace.Netmeds:id/prescriptionCheckBox'])[2]")));
		
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/doneButton")).click();
		//btnclick(m.getM2_RX_DoneBtn());
		
		
	//	Thread.sleep(15000);
		//btncli(driver.findElement(By.xpath("//android.view.View[@index='0']")));
		
	//	btncli(driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]")));
		
		Thread.sleep(15000);
		btnclick(m.getM2_Upload_ContinueBtn());
		
		Thread.sleep(15000);
		btnclick(m.getM2_SearchMedicine());
		
		Thread.sleep(15000);
		btnclick(m.getM2_Search_CAll_ContinueBtn());
		
		Thread.sleep(5000);
		btnclick(m.getM2_SearchBar());
		
		Thread.sleep(2000);
		type(m.getM2_SearchBar(), "Dolo");
		
		Thread.sleep(5000);
		btnclick(m.getM2_Search_AddToCart());
		
		Thread.sleep(5000);
		btnclick(m.getM2_ProceedToCart());
	
		Thread.sleep(5000);
		btnclick(m.getM2_ProceedBtn());
		
		Thread.sleep(5000);
//		btncli(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_proceed_btn']")));
		

		
		Thread.sleep(5000);
		btnclick(m.getM2_Place_Order());
Thread.sleep(3000);
//Step 14 : Order status//

		String Actual_orderstatus = m.getOrder_status().getText();

		System.out.println("order status is  "+ Actual_orderstatus);

		//logger.log(Status.PASS, "order status is  "+ Actual_orderstatus);
		Thread.sleep(3000);
		
		Assert.assertEquals(gettext(m.getGrab_text()),"GRAB YOUR");

		System.out.println(m.getGrab_text().getText());

		Assert.assertEquals(gettext(m.getFree_medicines()),"Free Medicines");

		System.out.println(m.getFree_medicines().getText());

		Assert.assertEquals(gettext(m.getInvite_friends()),"Invite your friends and get");

		System.out.println(m.getInvite_friends().getText());

		Thread.sleep(3000);

	
		//Assert.assertEquals(gettext(m.getOffer_code()),"TEST1932");

		System.out.println(m.getOffer_code().getText());




		Assert.assertEquals(gettext(m.getShare_with_friends()),"Tap to share code with your friends");

		System.out.println(m.getShare_with_friends().getText());


		m.getOffer_code().click();

		Thread.sleep(3000);
		driver.findElement(By.id("android:id/button2")).click();

		Thread.sleep(5000);



		//My rewards
		//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/btn_view_reward")).click();


		//my orders


		btnclick(m.getMyorders());

		Thread.sleep(3000);
			
		//View details


		btnclick(m.getViewdetails());
		Thread.sleep(3000);

		//cancel order


		btnclick(m.getCancelorder());
		Thread.sleep(3000);
		
		//Cancel reason


		btnclick(m.getCancel_reason());
		driver.swipe(790, 1100, 800, 70, 1000);

		Thread.sleep(2000);

		//Submit and cancel

		btnclick(m.getSubmit_cancel());
		Thread.sleep(3000);
		//logger.log(Status.PASS, "Order was cancelled successfully");
		System.out.println("Order was cancelled successfully");


		System.out.println("M2 Order Success is working properly");
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
	//	BaseClass.mail_report();
	}

}

 @AfterTest
 	private void quitbrowser() {
	 report.flush();

	 driver.quit();
}

}
