package com.Nm.Msite_stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Andriod_prod.RetryAnalyzer;
import com.Nm.Base.BaseClass;
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

public class Paymentpage extends MsiteBaseClass{


	@BeforeClass
	public void launchbrowser() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");

		capabilities.setCapability(MobileCapabilityType.UDID, "NBBY79GM5LTCJBJR");
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

		htmlReporter = new ExtentHtmlReporter(".//report//PaymentPage.html");

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
	//@Test(priority=1)
	@Test(priority=1,retryAnalyzer=RetryAnalyzer.class)
	public void paymentpage() throws Throwable {
		logger = report.createTest("Payment page");
		logger.log(Status.PASS, "*************Payment page********************");
		
		
		// launch the browser
		
		
		MsitePOM m = new MsitePOM();
			  driver.get("https://m.netmeds.com/");
			  
			  Thread.sleep(10000);
		
				
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
			
		}
		for (int i = 0; i < 10; i++) {
			Thread.sleep(5000);
			if (!(driver.findElements(By.xpath("//*[@title='Remove item']")).size() == 0)) {

				Thread.sleep(5000);
						try {
							driver.findElement(By.xpath("//android.view.View[@text='REMOVE']|//*[@title='Remove item']")).click();
						} catch (Exception e) {
						
						}

			} else {
				//logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		} 
		driver.navigate().to("https://m.netmeds.com");
		Thread.sleep(5000);
		
		
		
		//search the page

		Thread.sleep(5000);
				try {
					driver.findElement(By.xpath("//*[@text='✕' and @nodeName='SPAN']")).click();
				} catch (Exception e) {
					
				}
		
		
		driver.findElement(By.xpath("//*[@text='Search for medicine & wellness products...' and @nodeName='SPAN']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys( "Patanjali Lauh Bhasm Powder 5 gm");
		Thread.sleep(1500);
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text and @nodeName='DIV' and ./parent::*[@nodeName='A' and (./preceding-sibling::* | ./following-sibling::*)[@nodeName='DIV']]]")).click();
		// btncli(m.getSearchIcon());
		logger.log(Status.PASS, "Successfully navigate to search result page" );

		
		//add to the cart
		
		Thread.sleep(3000);
		 driver.swipe(0, 500, 0, 0, 1000);
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@text=' ADD TO CART ']")).click();
			
			}catch (Exception e) {
				
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
				
			}


			

Thread.sleep(3000);
//driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
//touchAction.tap(i-100,i1-100).perform();
driver.findElement(By.xpath("//*[@text='Pay']")).click();
Thread.sleep(10000);
	logger.log(Status.PASS, "Successfully navigate to search payment Details page" );
	btnclick(m.getPaytm_payment());

	Thread.sleep(3000);
	//WebDriverWait wait = new WebDriverWait(driver, 15);
	btnclick(m.getPaytm_paymentutton());
	
Thread.sleep(10000);
	driver.navigate().back();
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
	}catch (Exception e) {
		
	}
	Thread.sleep(5000);
	
	btnclick(m.getPayment_retry());
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
	Thread.sleep(5000);
	btnclick(m.getAmazon_pay());
	Thread.sleep(3000);
	btnclick(m.getAMAZONPAY_paybutton());
	Thread.sleep(15000);
	driver.navigate().to("https://www.netmeds.com/checkout/payment-information");
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
	}catch (Exception e) {
		
	}
	Thread.sleep(10000);
	btnclick(m.getPayment_retry());
	logger.log(Status.FAIL, "amazon pay decline scenario is verified " );

	Thread.sleep(3000);
	scrolldown("400");
	/*btncli(m.getFreecharge_pay());
	Thread.sleep(3000);
	btncli(m.getFREECHARGE_paybutton());
	Thread.sleep(15000);
	driver.navigate().back();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='abortPaymentYes']")).click();
	Thread.sleep(5000);

	btncli(m.getPayment_retry());*/
	Thread.sleep(3000);
	btnclick(m.getSimpl_payment());
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
	}catch (Exception e) {
		
	}
	try {
		m.getAMAZONPAY_paybutton().isDisplayed();
		System.out.println("simple payment is displayed");
		logger.log(Status.FAIL, "simple decline scenario is verified " );

	} catch (Exception e) {
		
	}
	scrolldown("600");
	Thread.sleep(3000);
	btnclick(m.getPhonepe_pay());
	Thread.sleep(3000);
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
	}catch (Exception e) {
		
	}
	try {
		m.getAMAZONPAY_paybutton().isDisplayed();
		System.out.println("phone pay payment is displayed");
		logger.log(Status.FAIL, "simple decline scenario is verified " );

	} catch (Exception e) {
		
	}
		scrolldown("300");
	Thread.sleep(3000);
		logger.log(Status.FAIL, "Phone pay decline scenario is verified " );

	btnclick(m.getGooglepay_pay());
	Thread.sleep(3000);
	try {
		m.getAMAZONPAY_paybutton().isDisplayed();
		System.out.println("gogle pay payment is displayed");
		logger.log(Status.FAIL, "simple decline scenario is verified " );

	} catch (Exception e) {
		// TODO: handle exception
	}
	
			logger.log(Status.FAIL, "GooglePay decline scenario is verified " );

		
	Thread.sleep(3000);
	/*scrolldown("700");
	btnclick(m.getCart_pay());
	Thread.sleep(3000);
	try {
		m.getAMAZONPAY_paybutton().isDisplayed();
		System.out.println("cart payment is displayed");
	} catch (Exception e) { 
		// TODO: handle exception
	}*/
	scrolldown("900");
	Thread.sleep(3000);
		btnclick(m.getAxis_bank());
	Thread.sleep(10000);
	driver.navigate().back();
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
	}catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(10000);
		btnclick(m.getPayment_retry());
		scrolldown("900");
		Thread.sleep(5000);
		/*btnclick(m.getHdfc_bank());
		Thread.sleep(15000);
		driver.navigate().back();
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
		}catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000);
			btnclick(m.getPayment_retry());
			scrolldown("900");
			Thread.sleep(5000);
			btnclick(m.getIcici_bank());
			Thread.sleep(10000);
			driver.navigate().back();
			try {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
			}catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(5000);
				btnclick(m.getPayment_retry());
				scrolldown("900");
				Thread.sleep(5000);
				btnclick(m.getKotak_bank());
				Thread.sleep(10000);
				driver.navigate().to("https://www.netmeds.com/checkout/payment-information");
				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
				}catch (Exception e) {
					// TODO: handle exception
				}
				Thread.sleep(7000);
					btnclick(m.getPayment_retry());
					scrolldown("900");*/
					Thread.sleep(5000);
					btnclick(m.getSBI_bank());
					Thread.sleep(10000);
					driver.navigate().back();
					try {
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
					}catch (Exception e) {
						// TODO: handle exception
					}
					Thread.sleep(7000);
						btnclick(m.getPayment_retry());
						Thread.sleep(3000);
						
						scrolldown("900");
						/*Thread.sleep(3000);
						btnclick(m.getMore_banks());
driver.findElement(By.xpath("//*[@text='Bank of India']")).click();
						//select_text(m.getMore_banks(), "Bank of India");
						Thread.sleep(10000);
						driver.navigate().to("https://www.netmeds.com/checkout/payment-information");*/
						try {
							Thread.sleep(2000);
							driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
						}catch (Exception e) {
							// TODO: handle exception
						}
						Thread.sleep(3000);
							btnclick(m.getCod_popoup());
							Thread.sleep(6000);
							
							driver.findElement(By.xpath("//*[@text and @nodeName='BUTTON']")).click();
							 Thread.sleep(3000);
							scrolldown("900");
							 logger.log(Status.PASS, "Successfully Placed the Order" );
							 Thread.sleep(3000);
							 driver.findElement(By.xpath("//*[@text='Track Order']")).click();
							 try {
							 	Thread.sleep(2000);
							 	driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
							 }catch (Exception e) {
							 	// TODO: handle exception
							 }
							 Thread.sleep(3000);
							 driver.findElement(By.xpath("//*[@text=' View Details ' and @top='true']")).click();
							 try {
							 	Thread.sleep(2000);
							 	driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
							 }catch (Exception e) {
							 	// TODO: handle exception
							 }
							 Thread.sleep(5000);
							 driver.swipe(0, 900, 0, 0, 1000);
							 Thread.sleep(3000);
							 driver.swipe(0, 900, 0, 0, 1000);
							 Thread.sleep(3000);

							 //MobileElement co = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']"));co.click();
							 driver.findElement(By.xpath("//*[@text='Cancel Order']")).click();
							 Thread.sleep(3000);
							 driver.findElement(By.xpath("//*[@text='Delay in delivery ']")).click();
							 Thread.sleep(3000);
							 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL' and @nodeName='BUTTON' and @top='true']")).click();
							 //touchAction.tap(100,i1).perform();
							 logger.log(Status.PASS, "Successfully Order was Cancelled" );
							
								
	}
	//@Test(priority=2)
	//@Test(priority=2,retryAnalyzer=RetryAnalyzer.class)
	public void nmscash() throws Throwable {
		//logger =  report.createTest("Payment page");
		
	Monepom m=new Monepom();
	try {
	//	driver.manage().window().maximize();

	btnclick(m.getSignin());
	Thread.sleep(5000);
	type(m.getMobileno(),"9677159095");
	btnclick(m.getPass());
	Thread.sleep(3000);
	type(m.getPassword(),"test4nm");
	btnclick(m.getSignInpage());
	}catch (Exception e) {
		System.out.println("alredy logged in");
		driver.navigate().to("https://www.netmeds.com");

	}
	Thread.sleep(3000);
	logger.log(Status.PASS, "Successfully navigate to home page" );
	Thread.sleep(3000);
	btnclick(m.getMinicart());
	
	for (int i = 0; i < 16; i++) {
		Thread.sleep(3000);
		if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size()==0)) {
			
			try {
				btnclick(m.getRemovebutton());
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
	btnclick(m.getAddtocart());
	}catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(3000);
	btnclick(m.getMinicart());
	Thread.sleep(5000);
	logger.log(Status.PASS, "Successfully navigate to cart page" );
	btnclick(m.getProceedbutton());
	Thread.sleep(5000);
	logger.log(Status.PASS, "Successfully navigate to search order review page" );
	btnclick(m.getPaybutton());
	Thread.sleep(3000);
	logger.log(Status.PASS, "Successfully navigate to search payment Details page" );
	try {
		btnclick(m.getNmscash());
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
							btnclick(m.getTrack_Order());
							Thread.sleep(10000);
							
							
							btnclick(m.getView_Details());
							Thread.sleep(6000);
							
							
							btnclick(m.getCancel_Order());
							Thread.sleep(3000);
							btnclick(m.getCancel_reason());
							Thread.sleep(3000);
							btnclick(m.getSubmit_Cancel());
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
