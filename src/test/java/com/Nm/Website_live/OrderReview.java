package com.Nm.Website_live;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
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
import org.testng.asserts.SoftAssert;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;







/*Medicine List
Expire Date
Delivery Date
Seller name
Uploaded Prescription
Customer Notes
Order Confirmation Content for RX products*/
public class OrderReview extends BaseClass {

	
	
	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//report//M1_COD_Flow.html");

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

	@Test(priority = 1,retryAnalyzer=RetryAnalyzer.class)
	public void cash_On_delivery_Check() throws Throwable {

		logger = report.createTest("Order review ");
		logger.log(Status.PASS, "************* Order review page********************");
		Monepom m = new Monepom();
		Robot r = new Robot();

		
		
		driver.manage().window().maximize();
		try {
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
		logger.log(Status.PASS, "Successfully navigate to cart page" );
		btncli(m.getProceedbutton());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to search order review page" );
		// handle Lets chat button
		try {
			driver.switchTo().frame("haptik-xdk");
			Actions acc = new Actions(driver);
			acc.moveToElement(driver.findElement(By.xpath("//div[@class='bot-prompt-minimal-textarea']//span"))).build()
					.perform();
			driver.findElement(By.xpath("(/html/body/div/div[1]/div[1])[1]")).click();
			driver.switchTo().defaultContent();
		} catch (Exception e) {

		}	Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigated to  order review page");
		SoftAssert SoftAssert=new SoftAssert();
		method(m.getOrderreview_productList());
		method(m.getOrderreview_mfr());
		method(m.getOrderreview_sellerinfo());
		method(m.getOrderreview_quantity());
		method(m.getOrderreview_quantitycount());
		method(m.getOrderreview_price());
		method(m.getOrderreview_exprity_date());
		type(m.getOrderreview_textArea(), "testing");
		SoftAssert.assertEquals(gettext(m.getOrderreview_customerNotes()), "CUSTOMER NOTES");
		SoftAssert.assertEquals(gettext(m.getOrderreview_paymentdetails()), "PAYMENT DETAILS");
		SoftAssert.assertNotNull(m.getOrderreview_mrpTotal());
		SoftAssert.assertNotNull(m.getOrderreview_mrpTotalprice());
		SoftAssert.assertNotNull(m.getOrderreview_Delivery_Charges());
		SoftAssert.assertNotNull(m.getOrderreview_Delivery_Chargesprice());
		SoftAssert.assertNotNull(m.getOrderreview_TotalAmout());
		SoftAssert.assertNotNull(m.getOrderreview_TotalAmoutprice());
		SoftAssert.assertNotNull(m.getOrderreview_TotalAmoutcontent());
		SoftAssert.assertNotNull(m.getOrderreview_TotalAmoutprices());
driver.navigate().to("https://www.netmeds.com/");
		
Thread.sleep(3000);
m.getSearch().sendKeys( "Rxtor 10mg Tablet 10'S",Keys.ENTER);

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
logger.log(Status.PASS, "Successfully navigate to cart page" );
btncli(m.getProceedbutton());
Thread.sleep(3000);
logger.log(Status.PASS, "Successfully navigate to search order review page" );
// handle Lets 
WebElement Uploadrx = driver
.findElement(By.xpath("//ul[@class='d-flex justify-content-center']//span[@class='pastrx-icon']"));

Uploadrx.click();

Thread.sleep(3000);

WebElement Selectrx = driver.findElement(By.xpath("(//input[@class=\"rx_image\"])[2]"));

Selectrx.click();

Thread.sleep(2000);

driver.findElement(By.xpath("(//button[@class='close'])[2]")).click();

Thread.sleep(3000);
// Step 10: Doctor Consultation//

btncli(m.getConsultdoctorcheck());

logger.log(Status.PASS, "Doctor Consultation is sucessfully schedulded");



Thread.sleep(2000);
btncli(m.getOrderreview_revieworder());
Thread.sleep(2000);
btncli(m.getOrderreview_rxviewimg());
Thread.sleep(2000);
btncli(m.getOrderreview_close());

String s=driver.findElement(By.xpath("//div[@class='review_extdocmain d-none d-sm-block ng-star-inserted']/div[2]/div[1]")).getText();
SoftAssert.assertEquals(s, "ORDER CONFIRMATION");
String ss=driver.findElement(By.xpath("//div[@class='review_extdocmain d-none d-sm-block ng-star-inserted']/div[2]/div[2]")).getText();
SoftAssert.assertEquals(ss, "Our Pharmacist/Doctor will call you to confirm the medicines.");
SoftAssert.assertAll();
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
		
 //     driver.quit();
	}

public void method(List<WebElement> element) {
	for (int i = 0; i < element.size(); i++) {
		WebElement x = element.get(i);
		SoftAssert SoftAssert=new SoftAssert();

		SoftAssert.assertNotNull(x);
		System.out.println(x.getText());

	}
}


}
