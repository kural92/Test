package com.Nm.backend;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Base.BackendBaseClass;
import com.Nm.Pom.backendPom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BackendorderFlow extends BackendBaseClass {

	
	
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
	   public void startReport() {
	   	
	      htmlReporter = new ExtentHtmlReporter(".//Report//pharmapanel.html");
	       
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

	      // htmlReporter.config().setTheme(Theme.DARK);
	   	
	   }
		
	@Test
	public void test() throws Throwable {

		logger =  report.createTest("BackendFlow");
		logger.log(Status.PASS, "*************order move to control center********************" );
		int rowCount = BackendBaseClass.getRowCount("MV1");
		System.out.println("total order'count ="+rowCount);
for (int i = 10; i <= rowCount; i++) {
	System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe"); //D:\\Automation\\Driver\\chromedriver.exe
	driver= new ChromeDriver();
		//driver.get("https://www.netmeds.com");
		
		driver.manage().window().maximize();
		logger.log(Status.PASS, "usercount"+i );
		Thread.sleep(3000);
		long startTime = System.currentTimeMillis();
		driver.get("https://s1-labs.netmeds.com/v2pharma");
		
	
		String user=getExcelData("MV1", i, 0);
		String pass=getExcelData("MV1", i, 1);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);
		logger.log(Status.PASS, "username"+user );

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		logger.log(Status.PASS, "username"+pass );
		Select s = new Select(driver.findElement(By.xpath("//select[@id='usertype']")));
		s.selectByVisibleText("Pharmacy");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		try {
		String ss=driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
		assertTrue(ss.equalsIgnoreCase(user));
		}catch(Exception e) {

			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Report/"+ user+".png"));
			System.out.println("Successfully captured a screenshot");
			//logger.log(Status.FAIL, result.getThrowable());
			logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath(user+".png"));
		
	
			
			
		}
		
		
		
		////////////////////////// 
		Thread.sleep(3000);
		String orderId = driver.findElement(By.xpath("(//div[@class='col_secound'])[1]")).getText();
		System.out.println(orderId);
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		String orderId1 = driver.findElement(By.xpath("(//div[@class='col_secound'])[1]")).getText();
		System.out.println(orderId1);
		assertTrue(orderId.equals(orderId1));
		Thread.sleep(3000);
	/*	if (orderId.equals(orderId1)) {
			System.out.println("Refresh Scenario Successfull");
		} else {
			System.err.println("Refresh Scenario UN-Successfull");
		}
	*/	
		// Valid
		Thread.sleep(3000);
		driver.findElement(By.id("valid1")).click();
		
		/*
		// Rx
		Thread.sleep(3000);
		driver.findElement(By.id("invalid1")).click();
		
		// Transfer
		Thread.sleep(3000);
		driver.findElement(By.id("transfer_to_admin")).click();
		*/
		//Forward
		Thread.sleep(3000);
		driver.findElement(By.id("validate1_forward")).click();
		
		
		
		try {
			Thread.sleep(3000);
			driver.findElement(By.id("pharma_doctorname_customerorder")).sendKeys("Test");
			Thread.sleep(3000);
			driver.findElement(By.id("pharma_patientname_customerorder")).sendKeys("Test");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("No Confirmation Screen");
		}
		
		
		Thread.sleep(3000);
		String orderId2 = driver.findElement(By.xpath("(//div[@class='col_secound'])[1]")).getText();
		System.out.println(orderId2);
		assertFalse(orderId1.equals(orderId2));
		Thread.sleep(3000);
	/*	if (!(orderId1.contains(orderId2))) {
			System.out.println("Valid Scenario Successfull");
		} else {
			System.err.println("Valid Scenario Un-Successfull");
		}
		
		*/
		
		/*
		driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
		Thread.sleep(3000);
		
		Actions acc = new Actions(driver);
		acc.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"))).click().build().perform();
		//driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"))
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		System.out.println("Test 1 Ends");
*/
		
		
		
		///////////////////
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		logger.log(Status.PASS, "total excution time:" +totalTime);
		
}	
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
		
  //    driver.quit();
	}
}
