package com.Nm.Website;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Predicate;

//********Extend Report*********//
public class OfferPage extends BaseClass {

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

//**************M3 Non Rx & OTC flow*******************//
	@Test
	public void takeAction() throws Throwable {
		
		
		logger = report.createTest(" All Categories");
		logger.log(Status.PASS, "*************Take Action Fail Alert********************");

//Step1 :Launch Browser//		
		Monepom m = new Monepom();
		driver.manage().window().maximize();

//Step 2 :Login with user name and password//
		btncli(m.getSignin());
		Thread.sleep(5000);

		type(m.getMobileno(), "8072281468");
		Thread.sleep(3000);

		//btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
		btncli(m.getUsepwdbtn());
		Thread.sleep(3000);
		type(m.getPassword(), "test@123");

		btncli(m.getSignInpage());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to home page");

//Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		
//Step 4 : Navigate to offer 
		
		driver.findElement(By.xpath("//a[@href=\"/offers\"]")).click();
		Thread.sleep(3000);
		
		 String offerpagetext = driver.findElement(By.xpath("//h1[contains(text(),\"Netmeds Coupons and Offers\")]")).getText();
		 
		 String Expectedofftext = "Netmeds Coupons and Offers";
		 
		 Assert.assertEquals(offerpagetext, Expectedofftext);
		
		
	}

	private Predicate<WebDriver> ExpectedConditions(By xpath) {
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

	// @AfterTest
	// private void quitbrowser() {
	// report.flush();

	// driver.quit();
	// }

}
