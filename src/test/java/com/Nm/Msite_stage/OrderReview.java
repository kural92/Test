package com.Nm.Msite_stage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Andriod_prod.RetryAnalyzer;
import com.Nm.Base.BaseClass;
import com.Nm.Base.MobileBaseClass;
import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.Monepom;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;







/*Medicine List
Expire Date
Delivery Date
Seller name
Uploaded Prescription
Customer Notes
Order Confirmation Content for RX products*/
public class OrderReview extends MsiteBaseClass {

	@BeforeClass
	public void launchbrowser() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		capabilities.setCapability("platformName", "Android");

	//	capabilities.setCapability(MobileCapabilityType.UDID, "NBBY79GM5LTCJBJR");
		capabilities.setBrowserName(MobileBrowserType.CHROMIUM);

		capabilities.setCapability("noReset", true);
		
		capabilities.setCapability("autoDismissAlerts", true);  
		
		
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
}
	
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
	//@Test
	@Test(priority = 1,retryAnalyzer=RetryAnalyzer.class)
	public void cash_On_delivery_Check() throws Throwable {

	
		
		
		
		logger = report.createTest("Netmeds First");
		logger.log(Status.PASS, "*************Netmeds First********************");
		
		
		// launch the browser
		
		
		MsitePOM m = new MsitePOM();
			  driver.get("https://m.netmeds.com/");
			  driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);
			  
			 
			  Thread.sleep(4000);
				popupclose() ;
			  Thread.sleep(10000);
				String s="Patanjali Lauh Bhasm Powder 5 gm";
		Thread.sleep(2000);
		
		
		//remove from the cart
		
		
		driver.navigate().to("https://m.netmeds.com/checkout/cart");
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
		}catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; i < 10; i++) {
			Thread.sleep(5000);
			if (!(driver.findElements(By.xpath("//*[@title='Remove item']")).size() == 0)) {

				Thread.sleep(5000);
						try {
							driver.findElement(By.xpath("//android.view.View[@text='REMOVE']|//*[@title='Remove item']")).click();
						} catch (Exception e) {
							// TODO: handle exception
						}

			} else {
				//logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		} 
		driver.navigate().to("https://m.netmeds.com");
		Thread.sleep(5000);
		
		
		
		//search the page
		
		
		
		driver.findElement(By.xpath("//*[@text='Search for medicine & wellness products...' and @nodeName='SPAN']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys( "Patanjali Lauh Bhasm Powder 5 gm");
		Thread.sleep(1500);
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='                                     Patanjali Lauh Bhasm Powder 5 gm                                    ']")).click();
		// btncli(m.getSearchIcon());
		logger.log(Status.PASS, "Successfully navigate to search result page" );

		
		//add to the cart
		
		Thread.sleep(3000);
		 driver.swipe(0, 500, 0, 0, 1000);
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@text=' ADD TO CART ']")).click();
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(5000);
			
			//add the product
			
			driver.findElement(By.xpath("//*[@text and @nodeName='SPAN' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='A']]]")).click();
			logger.log(Status.PASS, "Successfully navigate to cart page" );
			Thread.sleep(15000);
			driver.findElement(By.xpath("//*[@text='Proceed']")).click();
			logger.log(Status.PASS, "Successfully navigate to search order review page" );
			try {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
method(m.getOrderreview_productList());
method(m.getOrderreview_mfr());
		
		Thread.sleep(3000);
		
		// order review page for otc
		
		
		logger.log(Status.PASS, "Successfully navigated to  order review page");
		SoftAssert SoftAssert=new SoftAssert();
		method(m.getOrderreview_productList());
		method(m.getOrderreview_mfr());
		method(m.getOrderreview_sellerinfo());
		method(m.getOrderreview_quantity());
		method(m.getGetOrderreview_quantitycount());
		method(m.getOrderreview_price());
		method(m.getOrderreview_exprity_date());
		type(m.getOrderreview_textArea(), "testing");
		SoftAssert.assertEquals(gettext(m.getOrderreview_customerNotes()), "CUSTOMER NOTES");
		driver.navigate().to("https://m.netmeds.com");
		Thread.sleep(5000);
		popupclose() ;
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Search for medicine & wellness products...' and @nodeName='SPAN']")).click();
		
		// rx product search
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys( "Rxtor 10mg Tablet 10'S");
		Thread.sleep(1500);
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@text and @nodeName='DIV' and ./parent::*[@nodeName='A' and (./preceding-sibling::* | ./following-sibling::*)[@nodeName='DIV']]]")).click();
		// btncli(m.getSearchIcon());
		logger.log(Status.PASS, "Successfully navigate to search result page" );

		Thread.sleep(5000);
		 driver.swipe(0, 500, 0, 0, 1000);
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@text and @nodeName='SPAN' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='A']]]")).click();
			logger.log(Status.PASS, "Successfully navigate to cart page" );
			Thread.sleep(15000);
			driver.findElement(By.xpath("//*[@text='Proceed']")).click();
			logger.log(Status.PASS, "Successfully navigate to search order review page" );
			try {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			// upload the prescription 
			
			driver.findElement(By.xpath("//*[@text='Upload Prescription']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@text='Past Rx' and @nodeName='SPAN']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//*[@name='uplpastRx'])[1]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@nodeName='BUTTON' and @width>0 and ./*[@nodeName='SPAN']]")).click();
			
			// review the order
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@text='Review Order']")).click();
for (int i = 0; i < 10; i++) {

				
				Thread.sleep(3000);
				driver.swipe(82, 939, 82, 6, 1000);				try {
					if (driver.findElement(By.xpath("//*[@class='rxviewimg']")).isDisplayed()) {

						
						Thread.sleep(3000);
						//btnclick(m.getPackageImage());
						break;
					} else {
						
						System.out.println("Swipe Down to click on package Button");

					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='rxviewimg']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@nodeName='BUTTON' and @width>0 and ./*[@nodeName='SPAN']]")).click();
			// Change address
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='addchange']|//android.widget.TextView[@text='CHANGE']")).click();
			Thread.sleep(5000);
			
	//Let's chat handle//
			letschat();
			
			
	//Delete Address
			for (int i = 0; i < 10; i++) {

				
				Thread.sleep(3000);
				driver.swipe(0, 1500, 0, 1300, 1000);
				try {
					if (m.getDeleteaddress().isDisplayed()) {

						
						Thread.sleep(3000);
						//btnclick(m.getPackageImage());
						break;
					} else {
						
						System.out.println("Swipe Down to click on package Button");

					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				}
			Thread.sleep(5000);
				btnclick(m.getDeleteaddress());
				System.out.println("Address was deleted successfully");
				logger.log(Status.PASS, "Address was deleted successfully");
				
	//Modify
				for (int i = 0; i < 10; i++) {

					
					Thread.sleep(3000);
					driver.swipe(0, 1800, 0, 1500,1000);
					try {
						if (driver.findElement(By.xpath("//*[@text='Modify' and @top='true']")).isDisplayed()) {

							
							Thread.sleep(3000);
							//btnclick(m.getPackageImage());
							break;
						} else {
							
							System.out.println("Swipe Down to click on package Button");

						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					}
				
				
			Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Modify' and @top='true']")).click();
			Thread.sleep(5000);
			type(m.getPincode(),"600093");
			Thread.sleep(5000);
			type(m.getFirstname(),"gmailone");
			Thread.sleep(5000);
			type(m.getLastname(),"gmailtwo");
			Thread.sleep(5000);
			type(m.getStreet(),"gmailstreet");
			Thread.sleep(5000);
			type(m.getLandmark(),"gmaillandmark");
			Thread.sleep(5000);
			btnclick(m.getSaveaddress());
			System.out.println("Address was modified successfully");
			logger.log(Status.PASS, "Address was modified successfully");
			
			Thread.sleep(4000);
		
			
	//Add address
			btnclick(m.getAddaddress());
			Thread.sleep(5000);
			
	driver.findElement(By.xpath("//*[@id='pin']|//android.widget.EditText[@resource-id='pin']")).sendKeys("600093");
			
			Thread.sleep(5000);
			
			type(m.getPincode(),"600093");
			Thread.sleep(5000);
			type(m.getFirstname(),"gmailnew");
			Thread.sleep(5000);
			type(m.getLastname(),"gmailnewtwo");
			Thread.sleep(5000);
			type(m.getStreet(),"gmailnewstreet");
			Thread.sleep(5000);
			type(m.getLandmark(),"gmailnewlandmark");
			Thread.sleep(5000);
			btnclick(m.getSaveaddress());
			
			System.out.println("Address was Added successfully");
			logger.log(Status.PASS, "Address was Added successfully");
			
			Thread.sleep(5000);

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
