package com.Nm.website_stage;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

//********Extend Report**********//
public class OffersPage extends BaseClass {

	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//Report//sample.html");

		// initialize ExtentReports and attach the HtmlReporter
		report = new ExtentReports();

		// htmlReporter.setAppendExisting(false); 
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

		
//*******************************************************************Offer Page ******************************************************************//
	@Test(enabled = true)
	public void OffersPage() throws Throwable {

		logger = report.createTest(" Offers Page");
		logger.log(Status.PASS, "*************Offers page********************");

// Step1 :Launch Browser//
		Monepom m = new Monepom();
		driver.manage().window().maximize();

		

			try {

				btncli(m.getSignin());
				Thread.sleep(5000);
				type(m.getMobileno(), "8072281468");
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
			

			

//  Remove existing items from the cart  //

			Thread.sleep(3000);
			driver.navigate().to("https://s1-meds.netmeds.com/checkout/cart");
			Thread.sleep(3000);
			for (int i = 0; i < 16; i++) {
				Thread.sleep(3000);
				if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size() == 0)) {

					try {
						btncli(m.getRemovebutton());
						Thread.sleep(3000);
						driver.findElement(By.xpath("//span[@class=\"arricon downarrow\"]")).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[.=\"Remove\"]")).click();
					} catch (Exception e) {
						System.out.println("Items are removed from the cart");
					}

				} else {
					break;

				}

			}

			Thread.sleep(3000);
			driver.navigate().to("https://s1-meds.netmeds.com/");

			Thread.sleep(3000);
			
//Adding Product to the cart//
			
				
				for (int i = 0; i < 2; i++) {
					
					type(m.getSearch(), BaseClass.getExcelData("Otcandnonrx", i, 0));
					m.getSearch().sendKeys(Keys.ENTER);

					// btncli(m.getSearchIcon());
					logger.log(Status.PASS, "Successfully navigate to search result page");
				
				try {
					Thread.sleep(3000);

					WebElement Cart_btn = driver.findElement(By.id("product-addtocart-button"));
					Thread.sleep(3000);
					btncli(Cart_btn);
					//btncli(m.getAddtocart());
				} catch (Exception e) {

				}
				Thread.sleep(3000);
				driver.navigate().back();

				Thread.sleep(3000);
				
				System.out.println("Items are added to the cart");
			}

//Click mini cart//
			
			btncli(m.getMinicart());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigated to cart page");
			System.out.println("Successfully navigated to cart page");
			
			btncli(m.getNetmedshome());
			Thread.sleep(3000);

// Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
			
		
// Step 4:
			
		
			btncli(m.getOffer_page());
			Thread.sleep(3000);
			//driver.findElement(By.xpath("(//input[@class=\"offer-checkbox\"])[1]")).click();
			btncli(m.getMedicine_checkbox());
			Thread.sleep(3000);
			btncli(m.getCopy_code());
			Thread.sleep(3000);
			btncli(m.getMinicart());
			Thread.sleep(3000);
			btncli(m.getPromo_apply());
			Thread.sleep(3000);
			btncli(m.getCoupon_code());
			Thread.sleep(3000);
			System.out.println("coupon code was successfully copied");
			((m.getCoupon_code())).sendKeys(Keys.chord(Keys.CONTROL, "v"));
			Thread.sleep(3000);
			System.out.println("coupon code was successfully pasted");
			btncli(m.getApply_code());
			Thread.sleep(3000);
			System.out.println("Coupon code was sucessfully applied");
			driver.navigate().back();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//img[@class=\"offer_sub_img\"])[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h5[.=\"Terms and Conditions\"]")).click();
			Thread.sleep(3000);
			driver.navigate().to("https://s1-meds.netmeds.com/offers");
			Thread.sleep(3000);
		
			
		//	WebElement consultation= m.getMedicine_checkbox();

		//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", consultation);
			
		
			
			btncli(m.getConsultation_checkbox());
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//img[@class=\"offer_sub_img\"])[4]")).click();
			
			System.out.println("Coupon related to consultation offer was sucessfully opened");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h5[.=\"Terms and Conditions\"]")).click();
			driver.navigate().to("https://s1-meds.netmeds.com/offers");
			Thread.sleep(3000);
			
			btncli(m.getDiagnostics_checkbox());
			Thread.sleep(3000);
	
			driver.findElement(By.xpath("(//img[@class=\"offer_sub_img\"])[4]")).click();
			Thread.sleep(3000);
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h5[.=\"Terms and Conditions\"]")).click();
			System.out.println("Coupon related to diagonstics offer was sucessfully opened");
	
			
			driver.navigate().back();
			
			System.out.println("Offer page is working properly");
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

//	@AfterTest
//		private void quitbrowser() {
//		report.flush();
//			driver.quit();
			
	}			
	



