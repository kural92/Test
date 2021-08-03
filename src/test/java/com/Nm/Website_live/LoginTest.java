package com.Nm.Website_live;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
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
public class LoginTest extends BaseClass {

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

	
	
	
	
	
	/*,
	 BELOW LISTED SCENARIOS ARE COEVRED// 
		Test case 1: Login Netemeds application with username and password
		Test case 2: As a guest user after uploading Prescription,Check the Login functionality .
		Test Case 3 : As a guest do search the product, add the product to the cart,Check the Login functionality .
		*/

//********************************************** Testcase1-Login with username and password ********************************************************************//
	@Test(enabled = true, priority = 0 )
	public void loginwithpwd() throws Throwable {

		logger = report.createTest("Loginwith username and password");
		logger.log(Status.PASS, "*************Loginwith username and password********************");

//Step1 :Launch Browser//
		
			Monepom m = new Monepom();
	
			driver.manage().window().maximize();
		
		//Step 2 :Login with user name and password//
				btncli(m.getSignin());
				Thread.sleep(5000);

				type(m.getMobileno(), "8072281468");
				Thread.sleep(3000);

				// btncli(driver.findElement(By.xpath("//button[contains(text(),'USE
				// PASSWORD')]")));
				btncli(m.getUsepwdbtn());
				Thread.sleep(3000);
				type(m.getPassword(), "test@123");

				btncli(m.getSignInpage());
				Thread.sleep(3000);
				logger.log(Status.PASS, "Successfully navigate to home page");
				
				btncli(m.getUserprofile());
				Thread.sleep(3000);
				logger.log(Status.PASS, "Successfully navigate to userprofile");
				
				driver.findElement(By.xpath("//a[@class=\"logout-link ng-star-inserted\"]")).click();
	}			
				
			
//****************************************** Testcase2-Login using  upload Prescription***************************************************************************************//
	@Test(enabled = true , priority = 1)
	public void Loginwithupload() throws Throwable {

		logger = report.createTest(" Loginwithupload");
		logger.log(Status.PASS, "*************Loginwithupload********************");

		// Step1 :Launch Browser//
		Monepom m = new Monepom();
		//driver.manage().window().maximize();

		// Step 2 :Click Upload//
		btncli(m.getNetmedshome());
		driver.findElement(By.xpath("//a[.='Upload Rx']")).click();
		logger.log(Status.PASS, "Successfully navigate to Login Page");
		Thread.sleep(3000);

		// Step 3 :Login with user name and password//

		type(m.getMobileno(), "8072281468");
		Thread.sleep(3000);

		
		btncli(m.getUsepwdbtn());
		Thread.sleep(3000);
		type(m.getPassword(), "test@123");

		btncli(m.getSignInpage());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to home page");
		
		btncli(m.getNetmedshome());
		
		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		
		driver.findElement(By.xpath("//a[@class=\"logout-link ng-star-inserted\"]")).click();
		
		
	}
	
	

//************** Testcase3-Login through cart  *******************//
		@Test (enabled = true , priority = 2)
		public void Loginthroughcart() throws Throwable {

			logger = report.createTest("Loginthroughcart");
			
			logger.log(Status.PASS, "*************Loginthroughcart********************");

	//Step1 :Launch Browser//		
			Monepom m = new Monepom();
			//driver.manage().window().maximize();
			
			btncli(m.getNetmedshome());
			
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Telmikind 40mg Tablet 10'S");
			
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
		
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//button[contains(@class,\"iconSearch\")]")).click();
			
			//driver.findElement(By.id("//button[contains(@id,\"product-addtocart-button\")] ")).click();
			
			btncli(m.getAddtocart());
			
			btncli(m.getMinicart());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to cart page" );
			btncli(m.getProceedbutton()); 
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to search order review page" );

					
	//Step 3 :Login with user name and password//
			
					type(m.getMobileno(), "8072281468");
					Thread.sleep(3000);

					// btncli(driver.findElement(By.xpath("//button[contains(text(),'USE
					// PASSWORD')]")));
					btncli(m.getUsepwdbtn());
					Thread.sleep(3000);
					type(m.getPassword(), "test@123");

					btncli(m.getSignInpage());
					Thread.sleep(3000);
					logger.log(Status.PASS, "Successfully navigate to home page");	
					
					btncli(m.getNetmedshome());
					
					btncli(m.getUserprofile());
					Thread.sleep(3000);
					logger.log(Status.PASS, "Successfully navigate to userprofile");
					
					driver.findElement(By.xpath("//a[@class=\"logout-link ng-star-inserted\"]")).click();
							
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

	//@AfterTest
	//private void quitbrowser() {
	//report.flush();
	//	driver.quit();
		
		
	}


