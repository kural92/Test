package com.Nm.Website_live;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Paymentpage extends BaseClass{


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
	@Test(priority=1)
	//@Test(priority=1,retryAnalyzer=RetryAnalyzer.class)
	public void paymentpage() throws Throwable {
		logger =  report.createTest("Payment page");
	logger.log(Status.PASS, "*************Decline case********************" );
	Monepom m=new Monepom();
	try {
		//driver.manage().window().maximize();

	btncli(m.getSignin());
	Thread.sleep(5000);
	type(m.getMobileno(),"9677159095");
	btncli(m.getPass());
	Thread.sleep(3000);
	type(m.getPassword(),"test4nm");
	btncli(m.getSignInpage());
	}catch (Exception e) {
		System.out.println("alredy logged in");
		driver.navigate().to("https://www.netmeds.com");

	}
	Thread.sleep(3000);
	logger.log(Status.PASS, "Successfully navigate to home page" );
	Thread.sleep(3000);
	btncli(m.getMinicart());
	
	for (int i = 0; i < 16; i++) {
		Thread.sleep(3000);
		if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size()==0)) {
			
			try {
				btncli(m.getRemovebutton());
				}catch (Exception e) {
					// TODO: handle exception
				}
			
		} else {
			 break;

		}
		
		
	}
	driver.navigate().to("https://www.netmeds.com/");
	Thread.sleep(3000);
	m.getSearch().sendKeys( "Patanjali Lauh Bhasm Powder 5 gm",Keys.ENTER);
	
	// btncli(m.getSearchIcon());
	logger.log(Status.PASS, "Successfully navigate to search result page" );

	Thread.sleep(3000);
	try {
	btncli(m.getAddtocart());
	}catch (Exception e) {
		// TODO: handle exception
	}
	btncli(m.getMinicart());
	Thread.sleep(3000);
	/*driver.findElement(By.xpath("//a[@title='Save For Later']")).click();
	 String text = driver.findElement(By.xpath("//span[text()='Saved For Later']")).getText();
	System.out.println(text);*/
	logger.log(Status.PASS, "Successfully navigate to cart page" );
	btncli(m.getProceedbutton());
	Thread.sleep(3000);
	logger.log(Status.PASS, "Successfully navigate to search order review page" );
	btncli(m.getPaybutton());
	Thread.sleep(3000);
	logger.log(Status.PASS, "Successfully navigate to search payment Details page" );
	
	Thread.sleep(3000);

	btncli(m.getPaytm_payment());
	
	//WebDriverWait wait = new WebDriverWait(driver, 15);
	btncli(m.getPaytm_paymentutton());
	
Thread.sleep(10000);
	driver.navigate().back();
	Thread.sleep(5000);
	btncli(m.getPayment_retry());
Thread.sleep(3000);
logger.log(Status.FAIL, "paytm decline scenario is verified " );

/*btncli(m.getMobikwik_payment());
	Thread.sleep(3000);
	btncli(m.getMobikiwik_paymentutton());
	
	Thread.sleep(10000);
	driver.navigate().back();
	Thread.sleep(5000);
	btncli(m.getPayment_retry())
	logger.log(Status.FAIL, "Mobikiwik decline scenario is verified " );

	*/;
	Thread.sleep(3000);
	scrolldown("300");
	Thread.sleep(3000);
	btncli(m.getAmazon_pay());
	Thread.sleep(3000);
	btncli(m.getAMAZONPAY_paybutton());
	Thread.sleep(15000);
	driver.navigate().to("https://www.netmeds.com/checkout/payment-information");
	Thread.sleep(5000);
	btncli(m.getPayment_retry());
	logger.log(Status.FAIL, "amazon pay decline scenario is verified " );

	Thread.sleep(3000);
	scrolldown("400");
	btncli(m.getFreecharge_pay());
	/*Thread.sleep(3000);
	btncli(m.getFREECHARGE_paybutton());
	Thread.sleep(15000);
	driver.navigate().back();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='abortPaymentYes']")).click();
	Thread.sleep(5000);

	btncli(m.getPayment_retry());*/
	Thread.sleep(3000);
	btncli(m.getSimpl_payment());
	try {
		m.getSIMPL_paybutton().isDisplayed();
		System.out.println("simple payment is displayed");
		logger.log(Status.FAIL, "simple decline scenario is verified " );

	} catch (Exception e) {
		// TODO: handle exception
	}
	scrolldown("600");
	Thread.sleep(3000);
	btncli(m.getPhonepe_pay());
	Thread.sleep(3000);
/*	btncli(m.getPHONEPE_paybutton());
	Thread.sleep(10000);
	driver.navigate().back();
	Thread.sleep(3000);
		btncli(m.getPayment_retry());
		scrolldown("600");
	Thread.sleep(3000);
		logger.log(Status.FAIL, "Phone pay decline scenario is verified " );

	btncli(m.getGooglepay_pay());
	Thread.sleep(3000);
	btncli(m.getGOOGLEPAY_paybutton());
	Thread.sleep(10000);
	driver.navigate().back();
	Thread.sleep(3000);
		btncli(m.getPayment_retry());
			logger.log(Status.FAIL, "GooglePay decline scenario is verified " );

		*/
	Thread.sleep(3000);
	scrolldown("700");
	btncli(m.getCart_pay());
	Thread.sleep(3000);
	try {
		m.getCart_payment().isDisplayed();
		System.out.println("cart payment is displayed");
	} catch (Exception e) {
		// TODO: handle exception
	}
	scrolldown("900");
	Thread.sleep(3000);
	btncli(m.getAxis_bank());
	Thread.sleep(10000);
	driver.navigate().back();
	Thread.sleep(5000);
		btncli(m.getPayment_retry());
		scrolldown("900");
		Thread.sleep(5000);
		btncli(m.getHdfc_bank());
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(5000);
			btncli(m.getPayment_retry());
			scrolldown("900");
			Thread.sleep(5000);
			btncli(m.getIcici_bank());
			Thread.sleep(10000);
			driver.navigate().back();
			Thread.sleep(5000);
				btncli(m.getPayment_retry());
				scrolldown("900");
				Thread.sleep(5000);
				btncli(m.getKotak_bank());
				Thread.sleep(10000);
				driver.navigate().to("https://www.netmeds.com/checkout/payment-information");
				Thread.sleep(5000);
					btncli(m.getPayment_retry());
					scrolldown("900");
					Thread.sleep(5000);
					btncli(m.getSBI_bank());
					Thread.sleep(10000);
					driver.navigate().back();
					Thread.sleep(5000);
						btncli(m.getPayment_retry());
						Thread.sleep(3000);
						scrolldown("900");
						select_text(m.getMore_banks(), "Bank of India");
						Thread.sleep(10000);
						driver.navigate().to("https://www.netmeds.com/checkout/payment-information");
						Thread.sleep(3000);
							btncli(m.getCod_popoup());
							Thread.sleep(6000);
							
							 logger.log(Status.PASS, "Successfully Placed the Order" );
							/*
							String Order_message =  mm.getOrder_Placed_text().getText();
							System.err.println(Order_message);
							Thread.sleep(3000);
							*/
								
								
							btncli(m.getTrack_Order());
							Thread.sleep(10000);
							
							
							btncli(m.getView_Details());
							Thread.sleep(6000);
							
							
							btncli(m.getCancel_Order());
							Thread.sleep(3000);
							btncli(m.getCancel_reason());
							Thread.sleep(3000);
							btncli(m.getSubmit_Cancel());
							Thread.sleep(3000);
							 logger.log(Status.PASS, "Successfully Order was Cancelled" );
							
								
	}
	@Test(priority=2)
	//@Test(priority=2,retryAnalyzer=RetryAnalyzer.class)
	public void nmscash() throws Throwable {
		//logger =  report.createTest("Payment page");
		
	Monepom m=new Monepom();
	try {
	//	driver.manage().window().maximize();

	btncli(m.getSignin());
	Thread.sleep(5000);
	type(m.getMobileno(),"9677159095");
	btncli(m.getPass());
	Thread.sleep(3000);
	type(m.getPassword(),"test4nm");
	btncli(m.getSignInpage());
	}catch (Exception e) {
		System.out.println("alredy logged in");
		driver.navigate().to("https://www.netmeds.com");

	}
	Thread.sleep(3000);
	logger.log(Status.PASS, "Successfully navigate to home page" );
	Thread.sleep(3000);
	btncli(m.getMinicart());
	
	for (int i = 0; i < 16; i++) {
		Thread.sleep(3000);
		if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size()==0)) {
			
			try {
				btncli(m.getRemovebutton());
				}catch (Exception e) {
					// TODO: handle exception
				}
			
		} else {
			 break;

		}
		
		
	}
	driver.navigate().to("https://www.netmeds.com/");
	Thread.sleep(3000);
	m.getSearch().sendKeys( "Patanjali Lauh Bhasm Powder 5 gm",Keys.ENTER);
	
	// btncli(m.getSearchIcon());
	logger.log(Status.PASS, "Successfully navigate to search result page" );

	Thread.sleep(3000);
	try {
		Thread.sleep(3000);
	btncli(m.getAddtocart());
	}catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(3000);
	btncli(m.getMinicart());
	Thread.sleep(5000);
	logger.log(Status.PASS, "Successfully navigate to cart page" );
	btncli(m.getProceedbutton());
	Thread.sleep(5000);
	logger.log(Status.PASS, "Successfully navigate to search order review page" );
	btncli(m.getPaybutton());
	Thread.sleep(3000);
	logger.log(Status.PASS, "Successfully navigate to search payment Details page" );
	try {
		btncli(m.getNmscash());
		Thread.sleep(3000);
		WebElement w=driver.findElement(By.xpath("//button[@class='btn-checkout btn btn_to_checkout m-0 ng-star-inserted']"));
		if (w.isDisplayed()) {
		System.out.println("nms cash is working ");	
		 logger.log(Status.PASS, "verify the Nms cash " );
w.click();
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
								
	Thread.sleep(5000);
		scrolldown("400");
		Thread.sleep(5000);
							btncli(m.getTrack_Order());
							Thread.sleep(10000);
							
							
							btncli(m.getView_Details());
							Thread.sleep(6000);
							
							
							btncli(m.getCancel_Order());
							Thread.sleep(3000);
							btncli(m.getCancel_reason());
							Thread.sleep(3000);
							btncli(m.getSubmit_Cancel());
							Thread.sleep(3000);
							 logger.log(Status.PASS, "Successfully Order was Cancelled" );
							
							
	
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
			//BaseClass.mail_report();
		}

	}

	@AfterTest
	private void quitbrowser() {
		report.flush();

		//driver.quit();
	}


}
