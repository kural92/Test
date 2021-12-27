package com.Nm.Website_live;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import org.openqa.selenium.JavascriptExecutor;






/*
 
 1.Login
 2.Removed Product from cart
 3.Search the product and add to the cart
 4.From cart proceed the order and Choose Schedule Doctor consultation if RX required
 5.From Payment page check the COD option and choosed the COD option and the order was placed.
 6.From step 3 to 5 again repeat for 2 more time/
 7.Again step 3 to 5 was repeated and in payment page it was check for COD . Verify the condition
 8.From your account section landed into Medicine order
 9.Check for processing order, then click on view details and cancel the order with reason .

 
 
 */

public class Cod_ProcessingCheck extends BaseClass {

	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//report//M1_COD_3Orders.html");

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
		htmlReporter.config().setReportName("Netmeds.com");

		// htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@Test//(retryAnalyzer=RetryAnalyzer.class)
	public void cod_process3() throws Throwable {

		logger = report.createTest("Cash on Delivery Check for More than 3 Processing Order ");
		logger.log(Status.PASS, "************* Cash On Delivery - Processing Orders ********************");
		Monepom m = new Monepom();
		JavascriptExecutor js = (JavascriptExecutor)driver;

// Login

		try {
			driver.manage().window().maximize();
			btncli(m.getSignin());
			Thread.sleep(5000);
			type(m.getMobileno(), " ");
			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
			Thread.sleep(3000);
			type(m.getPassword(), " ");
			btncli(m.getSignInpage());
		} catch (Exception e) {
			// TODO: handle exception
		}

//////////////

/////////////  Remove Product //

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
		Thread.sleep(3000);
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size() == 0)) {

				try {
					btncli(m.getRemovebutton());
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else {
				break;

			}

		}

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/");

//////////////////////////

//////////////////////////

		Thread.sleep(3000);
		for (int i = 0; i < 4; i++) {
			Thread.sleep(3000);
			type(m.getSearch(), BaseClass.getExcelData("COD_Process", i, 0));
			m.getSearch().sendKeys(Keys.ENTER);
			logger.log(Status.PASS, "Successfully Added  " + BaseClass.getExcelData("COD_Process", i, 0));

			String Cart_Excel = BaseClass.getExcelData("COD_Process", i, 1);
			try {
				Thread.sleep(3000);

				WebElement Cart_btn = driver.findElement(By.xpath("//div[contains(text(),'" + Cart_Excel
						+ "')]//following::span[contains(text(),'ADD TO CART')]"));
				Thread.sleep(3000);
				btncli(Cart_btn);
				// btncli(m.getAddtocart());
			} catch (Exception e) {

			}

			Thread.sleep(3000);
			btncli(m.getMinicart());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigated to cart page");

			

			//////////////////////////////////
			Thread.sleep(3000);
			letsChat_Close();
			Thread.sleep(3000);
			js.executeScript("window.scrollTo(0,200)");
			Thread.sleep(7000);
			btncli(m.getProceedbutton());

			try {
				
				if (!(driver.findElement(By.id("externaldoctr")).isSelected())) {
					Thread.sleep(3000);
					btncli(driver.findElement(By.id("externaldoctr")));
					logger.log(Status.PASS, "Successfully navigated to Attach Prescription page");
					logger.log(Status.PASS, "Successfully Selected the Schedule FREE doctor Consultation");

				} else {
					
				}
				
				
				Thread.sleep(3000);
				btncli(driver.findElement(By.xpath("//button[contains(text(),'Review Order')]")));

			} catch (Exception e) {

			}
			
			
			Thread.sleep(3000);

			logger.log(Status.PASS, "Successfully navigated to  order review page");

			Thread.sleep(6000);
			btncli(m.getPaybutton());
			logger.log(Status.PASS, "Successfully navigated to Payment Page");

			Thread.sleep(5000);
			String Net = driver.findElement(By.id("cart_netpay_amt1")).getText();
			logger.log(Status.PASS, "Ordered Product price was " + Net);
			String[] Net_P = Net.split("Rs.");
			String Net_Pa = Net_P[1].toString();
			/*
			 * String[] Net_pa = Net_Pa.split("."); String Net_pay = Net_pa[0].toString();
			 */

			// String Net_P = Net.substring(3, 6);
			System.out.println(Net_Pa);
			Thread.sleep(1000);
if (Net_Pa.contains(",")) {
	String NetPa = Net_Pa.replace(",", "");
} else {}
Thread.sleep(1000);
			Float Net_Pay = Float.parseFloat(Net_Pa);
			// int Net_Pay = Integer.parseInt(Net_Pa);
			System.out.println(Net_Pay);

			Thread.sleep(3000);

			// Check Cash On Deleivery Enabled
			Thread.sleep(3000);
			if (driver.findElements(By.id("nms_cod")).size() == 1) {
				Thread.sleep(2000);
				if (!(driver.findElement(By.id("nms_cod")).isSelected())) {
					Thread.sleep(3000);

					try {
						btncli(driver.findElement(By.id("nms_cod")));
						logger.log(Status.PASS, "Successfully Clicked on Cash on Delivery");
						js.executeScript("window.scrollTo(0,1000)");
						Thread.sleep(5000);
						Thread.sleep(3000);
						js.executeScript("window.scrollTo(0,500)");
						Thread.sleep(3000);
						js.executeScript("window.scrollTo(0,200)");
						btncli(driver.findElement(By.xpath("(//button[contains(text(),'Pay Rs')])[10]")));
					} catch (Exception e) {
						Thread.sleep(3000);
						//JavaScriptExecutor js = (JavaScriptExecutor)driver;
						js.executeScript("window.scrollTo(0,500)");
						Thread.sleep(3000);
						js.executeScript("window.scrollTo(0,500)");
						Thread.sleep(3000);
						js.executeScript("window.scrollTo(0,200)");
						btncli(driver.findElement(By.xpath("//button[contains(text(),'PAY WITH CASH')]")));
					}
				} else {

					System.out.println("The COD Option was Already Selected");
				}

				///

			} else {

				System.out.println("There are 3 Processing Orders , so COD option was not dispalyed");
				logger.log(Status.PASS, "There are 3 Processing Orders , so COD option was not dispalyed");
			}

			Thread.sleep(3000);
			driver.navigate().to("https://www.netmeds.com");

			Thread.sleep(3000);
		}

		Thread.sleep(3000);
		btncli(driver.findElement(By.id("logged_user")));

		Thread.sleep(3000);
		btncli(driver.findElement(By.xpath("//span[contains(text(),'Medicine Orders')]")));

		Thread.sleep(3000);
		List<WebElement> process = driver.findElements(By.xpath("//span[contains(text(),'PROCESSING')]"));

		Thread.sleep(3000);
		for (int i = 0; i < process.size(); i++) {

			Thread.sleep(3000);

			btncli(m.getView_DetailsList().get(i));
			Thread.sleep(6000);

			btncli(m.getCancel_Order());
			Thread.sleep(3000);
			btncli(m.getCancel_reason());
			Thread.sleep(3000);
			btncli(m.getSubmit_Cancel());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully Order was Cancelled");

			Thread.sleep(5000);
			btncli(driver.findElement(By.xpath("//*[@id=\"app\"]/main/app-order-detail/div[1]/div[1]/a")));

			Thread.sleep(3000);

		
		
		

		}

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

//	BaseClass.mail_report();
		}

	}

	@AfterTest
	private void quitbrowser() {
		report.flush();

		// driver.quit();
	}

}
