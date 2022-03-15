package com.Nm.Msite_stage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.remote.CapabilityType;
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

import com.Nm.Base.BaseClass;
import com.Nm.Base.MobileBaseClass;
import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.AndriodPom;
import com.Nm.Pom.Monepom;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class OrderSuccessPage_M1 extends MsiteBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		
		public void launchbrowser()   {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			//capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA"); //RZ8R20GLXTA //GBT4C19326001968

		//	capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");  //fc95d519 //RZ8R20GLXTA

			capabilities.setCapability("platformName", "Android");
		//	capabilities.setCapability("deviceName", "vivo 1819");
		//	capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			/*capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			*/
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE ,"com.android.chrome");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY ,"com.google.android.apps.chrome.Main");
			capabilities.setCapability("noReset", true);
			
			capabilities.setCapability("autoDismissAlerts", true);  
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("newCommandTimeout", 100);
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}

	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//AlternateBrand.html");
       
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

       //htmlReporter.config().setTheme(Theme.STANDARD);
   	
   }
	

//*****************	M1 Order Success page
	
	
	@Test(enabled = true)
				public void M1rderSuccessPage() throws Throwable {
	
	
	
	logger = report.createTest("M1 Order Success Page");
	logger.log(Status.PASS, "*************M1 Order Success Page********************");
	
	
	// launch the browser
	
	
	// Step1 :Launch Browser//
	
	MsitePOM m = new MsitePOM();
	//driver.manage().window().maximize();
	driver.get("https://m.netmeds.com/");
	driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);
/*	try {

	//	btnclick(m.getSignin());
		Thread.sleep(5000);
	
		Thread.sleep(3000);
	//	btnclick(m.getUsepwdbtn());
		Thread.sleep(3000);
	//	type(m.getPassword(), "test@123");
	//	btnclick(m.getSignInpage());
	//	Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to home page");
	} catch (Exception e) {
		
		System.out.println("Already Logged in");
		
	}*/
	
	Thread.sleep(6000);
	
	popupclose() ;


//Let's chat handle//
	letschat();
	Thread.sleep(5000);
		  
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
	driver.findElement(By.xpath("//*[@name='q']")).sendKeys( "Horlicks Health Drink Powder Classic Malt 500 gm (Refill Pack)");//Patanjali Lauh Bhasm Powder 5 gm
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
			
			System.out.println("successfully item added");
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000);
		
		//add the product
		
	//	driver.findElement(By.xpath("//*[@text and @nodeName='SPAN' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='A']]]")).click();
	//	logger.log(Status.PASS, "Successfully navigate to cart page" );
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@text='Proceed To Cart']")).click();
		System.out.println("Successfully navigate to search order review page");
		logger.log(Status.PASS, "Successfully navigate to search order review page" );
	
	//	try {
		//	Thread.sleep(2000);
		//	driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
	//	}catch (Exception e) {
			// TODO: handle exception
	//	}

		Thread.sleep(15000);
	WebElement Test =	driver.findElement(By.xpath("//*[@text='Proceed']|//*[@class='btn-checkout btn btn_to_checkout']"));
	
	Test.click();
		

Thread.sleep(3000);
//driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
//touchAction.tap(i-100,i1-100).perform();
driver.findElement(By.xpath("//*[@text='Pay']")).click();
Thread.sleep(3000);



for (int i = 0; i < 5; i++) {
	
	Thread.sleep(3000);
	driver.swipe(0, 900, 0, 0, 1000);
	
	if (m.getPayment_cod_list().size()==1) {
		
		Thread.sleep(3000);
		 btnclick(m.getPayment_cod());
		break;
	} else {
		
		System.out.println("Swipe Down to click on pay Button");

	}}

Thread.sleep(3000);
btnclick(m.getPayment_paybutton());
/*
driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
MobileElement cod = (MobileElement) driver.findElement(By.xpath("//*[@id='nms_cod' and @name='nmsmstr_paymethod']"));cod.click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text and @nodeName='BUTTON']")).click();*/





 


/*Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);*/


//Step 16 : Ensure order is placed successfully//

Thread.sleep(10000);
driver.swipe(0, 500, 0, 0, 1000);
WebDriverWait wait = new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@text='Track Order']"))));
Thread.sleep(1000);


Thread.sleep(9000);
		String confirmation = driver.findElement(By.xpath("//*[@text='Order Placed Successfully!']|//android.view.View[@text='Order Placed Successfully!']")).getText(); 
		
		System.out.println(confirmation);

					String	Orderid	=	driver.findElement(By.xpath("//*[@text=' Order id - ']|//android.widget.Button[@text='VIEW REWARDS']/following-sibling::android.view.View[2]")).getText();

						System.out.println(Orderid);

						String order_status = driver.findElement(By.xpath("//*[@class='ordstatus']|//*[@text='CONSULTATION SCHEDULED']|//android.widget.Button[@text='VIEW REWARDS']/following-sibling::android.view.View[3]")).getText(); // m.getOrderid().getAttribute("innerText");

		System.out.println(order_status);
		
		String orderconfirmation = "Order Placed Successfully!";

		Assert.assertEquals(orderconfirmation, confirmation);

		System.out.println(confirmation + "and the id is " + Orderid);
		Thread.sleep(3000);
		driver.swipe(82, 1500, 82, 1420, 1000);
		
		Thread.sleep(3000);
		String	Deliverydate	=	driver.findElement(By.xpath("//*[@class='deldate']")).getText();

		System.out.println(Deliverydate);	
		
		Thread.sleep(3000);
		
		
driver.findElement(By.xpath("//*[@class='star']")).click();
		
Thread.sleep(3000);

	btnclick(driver.findElement(By.xpath("//*[@class='star star-1 ng-star-inserted']")));
Thread.sleep(2000);
btnclick(driver.findElement(By.xpath("//*[@class='star star-2 ng-star-inserted']")));
Thread.sleep(2000);
btnclick(driver.findElement(By.xpath("//*[@class='star star-3 ng-star-inserted']")));
Thread.sleep(2000);
btnclick(driver.findElement(By.xpath("//*[@class='star star-2 ng-star-inserted']")));	
Thread.sleep(2000);
btnclick(driver.findElement(By.xpath("//*[@class='star star-1 ng-star-inserted']")));


driver.findElement(By.xpath("//*[@text='SUBMIT FEEDBACK']")).click();

Thread.sleep(3000);

//Subscribe Now

driver.swipe(82, 1602, 82, 0, 1000);

Thread.sleep(3000);

//driver.findElement(By.xpath("//*[@class='subscribe']"));

Thread.sleep(3000);

//Subscribe now

		m.getSubscribe_now().click();
		
		Thread.sleep(3000);
		
		String Refill = ((m.getRefill_msg()).getAttribute("innerText"));
		System.out.println(Refill);
		Assert.assertTrue((Refill).contains("Get medicine refill’s delivered on the set duration of every month") );
		
		//WebElement time_period =
		driver.findElement(By.xpath("//*[@class='mat-select-value' and @top='true']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='mat-option-text' and @top='true'])[2]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@class='ng-tns-c17-4 ng-star-inserted' and @top='true']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@class='mat-option-text' and @top='true'])[2]")).click();
		
		
		
		
		Assert.assertEquals((m.getPaymentmode_text().getAttribute("innerText")),"Payment Mode");
		
		System.out.println((m.getPaymentmode_text().getAttribute("innerText")));
		
		Assert.assertEquals((m.getPaymentmethod_text().getAttribute("innerText")),"Online Payment / COD");
		
		System.out.println(m.getPaymentmethod_text().getAttribute("innerText"));
		
	
		Assert.assertEquals((m.getPromocode().getAttribute("innerText")),"Promo Code");
		
		System.out.println(m.getPromocode().getAttribute("innerText"));
		
		Assert.assertEquals(m.getPromo_percentage().getAttribute("innerText"),"20% Off Applied to all order plus last month free medicine");
		
		System.out.println(m.getPromo_percentage().getAttribute("innerText"));
		
		Assert.assertEquals((m.getModify_or_reschedule().getAttribute("innerText")),"You can modify or reschedule the subsequent orders later.");
		
		System.out.println(m.getModify_or_reschedule().getAttribute("innerText"));
		
		Thread.sleep(3000);
		
		driver.swipe(0, 1790, 0, 1550, 1000);
		
	btnclick(m.getEnableSubscription());
	
	//Order cancellation
		
	Thread.sleep(3000);	
	driver.navigate().to("https://m.netmeds.com/customer/orderhistory");
		

		
	//Cancel Order			

	//Let's chat handle//
				letschat();
				
				Thread.sleep(5000);
		
				btnclick(m.getViewdetails());
				letschat();
				Thread.sleep(5000);
				
				//Switch to Native_App		
				 Set<String> contextNames4 = driver.getContextHandles();
			        for (String strContextName : contextNames4) {
			            if (strContextName.contains("NATIVE_APP")) {
			                driver.context("NATIVE_APP");
			                break;
			            }
			        }		
					
				
				 driver.swipe(82, 1600, 82, 0, 1000);
				Thread.sleep(3000);
				btnclick(m.getCancelorder());
				Thread.sleep(5000);
				driver.swipe(82, 939, 82, 6, 1000);
				Thread.sleep(5000);
				try{btnclick(m.getYesbutton());}
				catch (Exception e) {
					// TODO: handle exception
				}
				Thread.sleep(5000);
				btnclick(m.getCancel_reason());
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
	
		       
				logger.log(Status.PASS, "Successfully Order was Cancelled");
				System.out.println("Successfully Order was Cancelled");
				Thread.sleep(2000);
				driver.navigate().to("https://www.netmeds.com/customer/orderhistory");

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


		}
