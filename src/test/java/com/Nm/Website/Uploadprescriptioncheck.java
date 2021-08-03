package com.Nm.Website;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//********Extend Report*********//
public class Uploadprescriptioncheck extends BaseClass {

	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//report//sample.html");

		// initialize ExtentReports and attach the HtmlReporter
		report = new ExtentReports();

		// htmlReporter.setAppendExisting(true);
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Host name", "localhost");
		report.setSystemInfo("Environemnt", "QA");
		report.setSystemInfo("user", "Automation Team");

		// configuration items to change the look and feel
		// add content, manage tests etc

		htmlReporter.config().setDocumentTitle("Extent Report ");
		htmlReporter.config().setReportName("Test Report");

		// htmlReporter.config().setTheme(Theme.STANDARD);

	}

//**************Test case :Upload Prescription and Past Rx ******************//
	
	/*
	 Scenarios covered : 
	  1.Uploading more than 12 prescription(attaching\pastrx) and ensuring proper error message is getting displayed.
	  2.Uploading unsupported file and ensuring proper error message is getting displayed.
	  3.Uploading jpg,gif,png file and ensuring files are supported and uploaded successfully.
	 */
	@Test
	public void uploadprescription() throws Throwable {
		
		
		logger = report.createTest(" uploadprescription");
		logger.log(Status.PASS, "*************uploadprescription********************");

//Step1 :Launch Browser//		
		Monepom m = new Monepom();
		driver.manage().window().maximize();

//Step 2 :Login with user name and password//
		try {

			btncli(m.getSignin());
			Thread.sleep(5000);
			type(m.getMobileno(), "8939818205");
			Thread.sleep(3000);
			btncli(m.getUsepwdbtn());
			Thread.sleep(3000);
			type(m.getPassword(), "test@123");
			btncli(m.getSignInpage());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to home page");
		} catch (Exception e) {
			System.out.println("Already Logged In");
		}

		try {
			btncli(m.getNetmedshome());
		} catch (Exception e) {

		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Upload Rx']")).click();
		Thread.sleep(3000);
			
//Step 3: Delete existing prescription if any//
		try {
			
			for (int i=0;i<12;i++) {
				
				 
				btncli(m.getDeletepresc());
				
				Thread.sleep(3000);
				System.out.println("Attached prescriptions are deleted");
			}
			
		} catch (Exception e) {
			System.out.println("No Prescription is already added");
		}
		
//attach prescription(Upload Prescription)				
		for (int i = 0; i < 12; i++) 
			
			{
				WebElement upload = m.getUploadpresc();
				
				upload.sendKeys(System.getProperty("user.dir")+"//Prescription//M3Subscription.png");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//img[@class=\"rxviewimg\"]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//button[@class=\"close\"])[1]")).click();
				Thread.sleep(3000);
				logger.log(Status.PASS, "Prescription added successfully");
			}
				
			WebElement upload =m.getUploadpresc();
			
			upload.sendKeys(System.getProperty("user.dir")+"//Prescription//M3Subscription.png");
			
			
			
			WebElement		error_message =	driver.findElement(By.id("upl_err_msg"));
			
				System.out.println(error_message.getText());
			
				Thread.sleep(3000);
				
// Delete Prescription added through upload prescription				
				for (int i=0;i<12;i++) {
					
					
					btncli(m.getDeletepresc());
					
					}
				
				System.out.println("Attached prescriptions are deleted");
//Upload Past Rx prescription
				
				WebElement Uploadrx = m.getPastrx();
				
				Uploadrx.click();
				
				Thread.sleep(3000);
				
				List<WebElement> Selectpastrx = driver.findElements(By.xpath("(//input[@class=\"rx_image\"])"));
				int rdbx= Selectpastrx.size();
				
				
						for (int i=0; i< rdbx; i++) 
				
	 			{
					
					Selectpastrx.get(i).click();
					
					Thread.sleep(2000);
					logger.log(Status.PASS, "Past RxPrescription added successfully");
				}
				
						driver.findElement(By.xpath("(//button[@class='close'])[2]")).click();
						
						Thread.sleep(3000);
						upload.sendKeys(System.getProperty("user.dir")+"//Prescription//M3Subscription.png");
						
						Thread.sleep(3000);
						System.out.println(error_message.getText());
						
					for (int i=0;i<12;i++) {
							
							
						btncli(m.getDeletepresc());
							
						}
					
					logger.log(Status.PASS, "Past rx Prescription added successfully");
					
					driver.findElement(By.xpath("//a[.=\"Valid Prescription?\"]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[@class='modal fade btmmodal in show']//span[@aria-hidden='true']")).click();
					
					
//uploading high resolution image//
					
					upload.sendKeys(System.getProperty("user.dir")+"//Prescription//10Mb.jpg");
					Thread.sleep(3000);
			WebElement image = driver.findElement(By.id("upl_err_msg"));
			System.out.println(image.getText());
			System.out.println("file type is jpg but file size more than 10 MB");
					
//Uploading unsupported files//
					
			upload.sendKeys(System.getProperty("user.dir")+"//Prescription.pdf");
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
			
//Excel file

			upload.sendKeys(System.getProperty("user.dir")+"//Prescription.xlsx");
			Thread.sleep(3000);
			System.out.println(image.getText());
			System.out.println("Excel file type is unsupported");
			
//gif
					
			upload.sendKeys(System.getProperty("user.dir")+"//Prescription//gif.gif");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class=\"rxviewimg\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[@class=\"close\"])[1]")).click();
			System.out.println("gif file uploaded successfully");
					
					
			System.out.println("Prescription & Past Rx attachment validation is completed and its working fine");
					
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
