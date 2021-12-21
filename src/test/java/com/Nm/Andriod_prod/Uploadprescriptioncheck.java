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

public class Uploadprescriptioncheck extends MobileBaseClass {

	
	
	
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

//**************Test case :Upload Prescription and Past Rx ******************//
	
	/*
	 Scenarios covered : 
	  1.Uploading more than 12 prescription(attaching\pastrx) and ensuring proper error message is getting displayed.
	  2.Uploading unsupported file and ensuring proper error message is getting displayed.
	  3.Uploading jpg,gif,png file and ensuring files are supported and uploaded successfully.
	 */
	@Test(enabled = true,retryAnalyzer=RetryAnalyzer.class)
	public void uploadprescription() throws Throwable {
		
		
		logger = report.createTest(" uploadprescription");
		logger.log(Status.PASS, "*************uploadprescription********************");

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
		
		
	
	
	
		Thread.sleep(5000);
		btnclick(m.getSubscription());
		Thread.sleep(6000);
		btnclick(m.getCreatenew_subscription());
		Thread.sleep(6000);
		btnclick(m.getM3productsearch());
		Thread.sleep(3000);
		
		//type(m.getM3productsearch(),"Folvite Tablet 45'S");
		//driver.findElement(By.xpath("//android.widget.TextView[@resourceid='com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn']")).click();
		
		
		for (int i = 0; i < 2; i++) {

			type(m.getM3productsearch(), MobileBaseClass.getExcelData("Rx", i, 0));

			// btncli(m.getSearchIcon());
			logger.log(Status.PASS, "Successfully navigate to search result page");

			//String Cart_Excel = MobileBaseClass.getExcelData("Otcandnonrx", i, 1);

			// Step 7 : Add product to the cart//
			try {
				Thread.sleep(3000);

				WebDriverWait wait = new WebDriverWait(driver, 30);
				WebElement Cart_btn = wait.until(
						ExpectedConditions.elementToBeClickable(By.id("com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn")));

				Thread.sleep(3000);

				btnclick(Cart_btn);
				
				System.out.println("successfully Items are added");
			} catch (Exception e) {
				// TODO: handle exception
			}

			Thread.sleep(3000);
			

			//Thread.sleep(3000);
			
			//driver.navigate().back();
		}

		btnclick(m.getProceedtocheckout());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully proceed to checkout");
		System.out.println("Successfully proceed to checkout");
		
		//Proceed
		btnclick(m.getProceed_btn());
		Thread.sleep(3000);
		
//Upload Prescription
		
		btnclick(m.getUploadPrescription());
		Thread.sleep(3000);
		
		
//Upload Image 
		
		driver.findElementByAccessibilityId("Gallery").click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id ='com.google.android.documentsui:id/icon_thumb'])[2]")).click();
		
		Thread.sleep(2000);
// Rx 
		for (int i = 0; i < 11; i++) 
		{	
			
			if (i>3) {
				
				Thread.sleep(2000);
				//driver.swipe(925, 0, 430, 0, 5000);
				
				new TouchAction(driver).press(950, 1050) .waitAction(2000) .moveTo(430, 1050) .release().perform();
				
			// Long Press gesture using TouchAction class
				//new TouchAction(driver).long_press(element).release().perform()

			//Scroll/Swipe gesture using TouchAction class
				//new TouchAction(driver).press(430,0).wait(1000).move_to(925,0).release().perform();
				
			}
			Thread.sleep(3000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/continueUpload")).click();
			
			Thread.sleep(2000);
			
			driver.findElementByAccessibilityId("Gallery").click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id ='com.google.android.documentsui:id/icon_thumb'])[3]")).click();
 
			System.out.println("prescription uploaded");
 
	}

		/*new TouchAction(driver).press(950, 1050) .waitAction(2000) .moveTo(430, 1050) .release().perform();

		Thread.sleep(3000);
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/continueUpload")).click();
		Thread.sleep(2000);
		driver.findElementByAccessibilityId("Gallery").click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id ='com.google.android.documentsui:id/icon_thumb'])[3]")).click();*/
 
 
 logger.log(Status.PASS, "Prescription was uploaded successfully");
	System.out.println("Prescription was uploaded successfully");
 
	
	//Step 3: Delete existing prescription if any//
			try {
				
				for (int i=0;i<12;i++) {
					
					 Thread.sleep(3000);
					driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/removePrescription']")).click();
					
					Thread.sleep(3000);
					System.out.println("Attached prescriptions are deleted");
				}
				
			} catch (Exception e) {
				System.out.println("No Prescription is already added");
			}
			Thread.sleep(3000);
	
			btnclick(m.getUploadPrescription());
			Thread.sleep(3000);
	driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Past Rx\"])[1]")).click();
	
	Thread.sleep(3000);
	
//pastrx	
	List<WebElement> Selectpastrx = 
			driver.findElements(By.xpath("//android.widget.CheckBox[@resource-id ='com.NetmedsMarketplace.Netmeds:id/prescriptionCheckBox']"));
	
	
	for (int i=0;i<12;i++) {
		
	Thread.sleep(3000);
	
	Selectpastrx.get(i).click();
	

	Thread.sleep(3000);
	}
	

	System.out.println("Maximum number of prescription is uploaded");
	
	btnclick(m.getDone());
	
	// Delete existing prescription if any//
	try {
		
		for (int i=0;i<12;i++) {
			
			 Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/removePrescription']")).click();
			
			Thread.sleep(3000);
			
			System.out.println("Attached prescriptions are deleted");
		}
		
	} catch (Exception e) {
		System.out.println("No Prescription is already added");
	}
	
	
	//PDF
	
	btnclick(m.getUploadPrescription());
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Past Rx\"])[2]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id ='com.google.android.documentsui:id/icon_thumb'])[4]")).click();
		
	
	for (int i=0;i<10;i++) {
			
				if (i>3) {
				
				Thread.sleep(3000);
				
				
				new TouchAction(driver).press(950, 1050) .waitAction(2000) .moveTo(430, 1050) .release().perform();

				
			}
				
			Thread.sleep(3000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/continueUpload")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("(//android.widget.ImageView[@content-desc=\"Past Rx\"])[2]")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id ='com.google.android.documentsui:id/icon_thumb'])[4]")).click();
 
			
			
			System.out.println("PDF prescriptions are attached" );
			
	}
	
	/*
	//gif
	
	btnclick(m.getUploadPrescription());
	Thread.sleep(3000);
	driver.findElementByAccessibilityId("Gallery").click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id ='com.google.android.documentsui:id/icon_thumb'])[1]")).click();	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/removePrescription']")).click();
	
	
	}
	
	
//	Upload Pdf
	
	driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id ='com.google.android.documentsui:id/icon_thumb'])[4]")).click();
					
		
//uploading high resolution image//
					
					upload.sendKeys(System.getProperty("user.dir")+"//Prescription//10Mb.jpg");
					Thread.sleep(3000);
			WebElement image = driver.findElement(By.id("upl_err_msg"));
			System.out.println(image.getText());
			System.out.println("file type is jpg but file size more than 10 MB");
					
//Uploading unsupported files//
					
			upload.sendKeys(System.getProperty("user.dir")+"//Prescription//Prescription.pdf");
			Thread.sleep(3000);
			System.out.println(image.getText());
			System.out.println("file pdf type is unsupported");
			
//Uploading different types of image//
					

//jpg
					
			upload.sendKeys(System.getProperty("user.dir")+"//Prescription//jpg.jpg");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class=\"rxviewimg\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[@class=\"close\"])[1]")).click();
			Thread.sleep(3000);
			System.out.println("jpg file uploaded successfully");
//bmp
					
			upload.sendKeys(System.getProperty("user.dir")+"//Prescription//bmp.bmp");
			Thread.sleep(3000);
			System.out.println(image.getText());
			System.out.println("bmp file type is unsupported");
			

			
					
					
			System.out.println("Prescription & Past Rx attachment validation is completed and its working fine");*/
				
	
	System.out.println("Upload Prescription page is working properly");
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
