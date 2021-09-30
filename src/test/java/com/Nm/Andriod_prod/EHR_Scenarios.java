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

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class EHR_Scenarios extends MobileBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");//"c195de14"
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
	


//*****************************************************EHR*************************


	
	
	@Test(enabled = true,retryAnalyzer=RetryAnalyzer.class,priority = 1)
	public void EHR1() throws Throwable {

		logger = report.createTest("EHR2");
		logger.log(Status.PASS, "*************EHR2********************");

	
		AndriodPom m = new AndriodPom();
		
		driver.launchApp();
		
		try {
			popupclose();
			Thread.sleep(5000);
			popupclose();
		btnclick(m.getLetsstarted());
		} catch (Exception e) {
			//driver.resetApp();
		
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
	

		
//Step 3 : consult button //
		Thread.sleep(3000);
		driver.swipe(620, 1250, 620, 0, 1000);
		Thread.sleep(3000);
		
		driver.swipe(620, 1250, 620, 0, 1000);
		
		driver.swipe(550, 1250, 620, 0, 1000);
		btnclick(m.getConsultnow());
		
		
		logger.log(Status.PASS, "Successfully Clicked the consult button");
		System.out.println("Successfully Clicked the consult button");
		
		
			
//Step 4 : 
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//android.widget.TextView[@text='Our Speciality']/parent::android.widget.LinearLayout/child::android.widget.TextView)[2]")).click();
		
		Thread.sleep(5000);
		
		driver.swipe(550, 519, 220, 0, 1000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Dentist']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/btn_specialization_done']")).click();
		
		logger.log(Status.PASS, "Successfully selected the specialist");
		
		System.out.println("Successfully selected the specialist");
		
	
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/text_myself'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_name")).sendKeys("Test");
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_contact")).sendKeys("1234567890");
		 
		Thread.sleep(3000);
		
		
		
		btnclick(m.getGenderselect());
		Thread.sleep(3000);

		btnclick(m.getGenderselection());
		Thread.sleep(3000);

	
		Thread.sleep(3000);
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_dob")).click();
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("//android.widget.TextView[@index='3']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("android:id/date_picker_header_year")).click();
		Thread.sleep(2000);
		
		driver.swipe(752, 1586, 752, 2000, 1000);
		
		driver.swipe(752, 1586, 752, 2000, 1000);
		
		driver.swipe(752, 1586, 752, 2000, 1000);
		
		driver.swipe(752, 1586, 752, 2000, 1000);
		driver.swipe(752, 1586, 752, 2000, 1000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='2000']")).click();
		
		driver.findElement(By.id("android:id/button1")).click();
		
		//driver.findElement(By.xpath("//android.view.View[@index='24']")).click();
		
		//driver.findElement(By.id("android:id/button1")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.NetmedsMarketplace.Netmeds:id/sp_relation']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Sister']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_height")).sendKeys("150");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_weight")).sendKeys("60");
		Thread.sleep(3000);
		driver.swipe(752, 1900, 752, 1100, 1000);
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_bp_systolic")).sendKeys("90");
		
		Thread.sleep(3000);
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_bp_diastolic")).sendKeys("100");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_pulse_rate")).sendKeys("120");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_temperature")).sendKeys("75");
		
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/tv_save_update_user")).click();
		Thread.sleep(3000);
		
		
		logger.log(Status.PASS, "Successfully EHR record has been added");
		System.out.println("Successfully EHR record has been added");
		
		
		
		
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/imgViewClose")).click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		//Step 3 : Navigate to user profile//

				btnclick(m.getUserprofile());
				Thread.sleep(3000);
				logger.log(Status.PASS, "Successfully navigate to userprofile");
				System.out.println("Successfully navigate to userprofile");
				
		//EHR
				
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/img_ehr")).click();
				Thread.sleep(3000);
	
				
		List	<WebElement> patient_list = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_hr_patient_name']"));
		
		System.out.println("The element size is"+patient_list.size());
		
		for (int i=0;i<patient_list.size();i++) {
			
			
			System.out.println(patient_list.get(i).getText());
		}
		
		
		logger.log(Status.PASS, "Successfully Listed the Patient names");
		System.out.println("Successfully Listed the Patient names");
		
		WebElement Listofpatients = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_hr_patient_name'])[2]"));

		TouchAction action = new TouchAction((MobileDriver)driver); 
		action.longPress(Listofpatients).release().perform();
		
		
	//Delete User
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/text_delete")).click();
		

		logger.log(Status.PASS, "Successfully deleted the Patient detail");
		System.out.println("Successfully deleted the Patient detail");
		
		System.out.println("EHR Scenario 1 is working properly");
	}					
	
	
	//*****************************************************EHR 2*************************


	
	
		@Test(enabled = true,retryAnalyzer=RetryAnalyzer.class,priority = 2)
		public void EHR2() throws Throwable {

			logger = report.createTest("EHR2");
			logger.log(Status.PASS, "*************EHR2********************");

		
			AndriodPom m = new AndriodPom();
			
			driver.launchApp();
			
			try {
				popupclose();
				Thread.sleep(5000);
				popupclose();
			btnclick(m.getLetsstarted());
			} catch (Exception e) {
				//driver.resetApp();
			
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
		
	//Step 3 : Navigate to user profile//

			btnclick(m.getUserprofile());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to userprofile");
			System.out.println("Successfully navigate to userprofile");
			
	//EHR
			
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/img_ehr")).click();
			Thread.sleep(3000);
			
			logger.log(Status.PASS, "Successfully navigated to EHR page");
			System.out.println("Successfully navigated to EHR page");
	//Step 4 : Add User
		
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/tv_add_new_user")).click();
			
			Thread.sleep(3000);

			logger.log(Status.PASS, "Successfully clicked add user button");
			System.out.println("Successfully clicked add user button");
			
			//driver.swipe(812, 100, 812, 400, 1000);
			
			
			
	//Step 5: Image Upload
			
		//	driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/imageViewProfile")).click();
			Thread.sleep(3000);
		//	driver.findElement(By.xpath("//android.widget.TextView[@text='Gallery']")).click();
			Thread.sleep(3000);
		//	driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id ='com.google.android.documentsui:id/icon_thumb'])[2]")).click();
		//	Thread.sleep(3000);
	//Add Name
			
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_name")).sendKeys("Name1");
			Thread.sleep(3000);
			
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_contact")).sendKeys("1234567890");
			 
			Thread.sleep(3000);
			
			
			
			btnclick(m.getGenderselect());
			Thread.sleep(3000);

			btnclick(m.getGenderselection());
			Thread.sleep(3000);

		
			Thread.sleep(3000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_dob")).click();
			Thread.sleep(3000);
		//	driver.findElement(By.xpath("//android.widget.TextView[@index='3']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.id("android:id/date_picker_header_year")).click();
			Thread.sleep(2000);
			
			driver.swipe(752, 1586, 752, 2000, 1000);
			
			driver.swipe(752, 1586, 752, 2000, 1000);
			
			driver.swipe(752, 1586, 752, 2000, 1000);
			
			driver.swipe(752, 1586, 752, 2000, 1000);
			driver.swipe(752, 1586, 752, 2000, 1000);
			
			driver.findElement(By.xpath("//android.widget.TextView[@text='2000']")).click();
			
			driver.findElement(By.id("android:id/button1")).click();
			
			//driver.findElement(By.xpath("//android.view.View[@index='24']")).click();
			
			//driver.findElement(By.id("android:id/button1")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.NetmedsMarketplace.Netmeds:id/sp_relation']")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Daughter']")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_height")).sendKeys("150");
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_weight")).sendKeys("60");
			Thread.sleep(3000);
			driver.swipe(752, 1900, 752, 1100, 1000);
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_bp_systolic")).sendKeys("90");
			
			Thread.sleep(3000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_bp_diastolic")).sendKeys("100");
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_pulse_rate")).sendKeys("120");
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_ud_temperature")).sendKeys("75");
			
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/tv_save_update_user")).click();
			
			logger.log(Status.PASS, "Successfully given the EHR patient details and saved");
			System.out.println("Successfully given the EHR patient details and saved");
			
			Thread.sleep(3000);
			
			WebElement Listofpatients = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_hr_patient_name'])[2]"));

			TouchAction action = new TouchAction((MobileDriver)driver); 
			action.longPress(Listofpatients).release().perform();
			
			Thread.sleep(3000);
		//Delete User
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/text_delete")).click();
			

			logger.log(Status.PASS, "Successfully deleted the Patient detail");
			System.out.println("Successfully deleted the Patient detail");
			
			
			
			System.out.println("EHR Scenario 2 is working properly");
			
		}					
	private WebElement findElement(By id) {
		// TODO Auto-generated method stub
		return null;
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
