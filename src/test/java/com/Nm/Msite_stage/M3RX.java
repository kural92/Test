package com.Nm.Msite_stage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;

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
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class M3RX extends MobileBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		
		//@BeforeClass
		public void launchbrowser2()   {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			//capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA"); //RZ8R20GLXTA //GBT4C19326001968

			capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");  //fc95d519 //RZ8R20GLXTA

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
			
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}


		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");//"c195de14"
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
			capabilities.setCapability(MobileCapabilityType.VERSION,"11 RP1A.200720.011" );
			//for m-site
			capabilities.setCapability("chromedriverExecutable", "D:\\Automation\\Driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
			//capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			
					
			//capabilities.setCapability("autoDismissAlerts", true);  
			
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
	

	/*
	@BeforeMethod
	  public void setUp1() throws MalformedURLException {
	      System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Driver\\chromedriver.exe");
	      Map<String, String> mobileEmulation = new HashMap<String, String>();
	      mobileEmulation.put("deviceName", "Moto G4");

	      ChromeOptions chromeOptions = new ChromeOptions();
	      chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	      chromeOptions.addArguments("--disable-notifications");
	      driver = new ChromeDriver(chromeOptions);
	     
	     
	  }  */
//*******************************************************M3 Rx**********************************************************************//
	@Test
	public void M3OTCandnonrxSubscription() throws Throwable {

		logger = report.createTest("M3RX");
		logger.log(Status.PASS, "*************M3RX*******************");

		// Step1 :Launch Browser//
		MsitePOM m = new MsitePOM();
		//driver.manage().window().maximize();
		driver.get("https://m.netmeds.com/");
		try {

		//	btnclick(m.getSignin());
			Thread.sleep(5000);
		//	type(m.getMobileno(), "8072281468");
			Thread.sleep(3000);
		//	btnclick(m.getUsepwdbtn());
			Thread.sleep(3000);
		//	type(m.getPassword(), "test@123");
		//	btnclick(m.getSignInpage());
		//	Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to home page");
		} catch (Exception e) {
			
			System.out.println("Already Logged in");
			
		}
		
		Thread.sleep(3000);
		try {
			driver.findElement(By.xpath("//span[@class='app_close']")).click();
		} catch (Exception e) {
			System.out.println("No Popup to close");
		}


		
		//Let's chat handle//
		Thread.sleep(3000);
		try {
			driver.switchTo().frame("haptik-xdk");
			Actions acc = new Actions(driver);
			acc.moveToElement(driver.findElement(By.xpath("//div[@class='bot-prompt-minimal-textarea']//span"))).build()
					.perform();
			driver.findElement(By.xpath("//*[@android.widget.Image='This image isn‘t labelled. Open the 'More options' menu at the top right to get image descriptions.']")).click();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println("Successfully closed let's chat");
		}

		Thread.sleep(3000);
				
	
// Step 4 : Navigate to Mysubscription page//

		//btnclick(m.getMysubscriptionpage());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//android.view.View[@content-desc='Subscription']")).click();
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to mysubscriptionpage");
		System.out.println("Successfully navigate to mysubscriptionpage");
		// Step 5 :Click create new fill button//

		
//Let's chat handle//
		Thread.sleep(3000);
		try {
			MobileElement netty = (MobileElement) driver.findElement(By.xpath("//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
			}catch (Exception e) {
				// TODO: handle exception
			}

		Thread.sleep(3000);
		
		
		
		
		driver.findElement(By.xpath("//android.widget.Button[@text='CREATE NEW SUBSCRIPTION']")).click();

		// Step 6:Search Product//

		Thread.sleep(3000);
		for (int i = 0; i < 2; i++) {

			//type(m.getM3productsearch(), BaseClass.getExcelData("Otcandnonrx", i, 0));
			
			//m.getM3productsearch().click();
			
			type(driver.findElement(By.xpath("//android.view.View[@resource-id='app']/android.view.View[2]/android.view.View/android.widget.EditText")), MobileBaseClass.getExcelData("Rx", i, 0));

			// btncli(m.getSearchIcon());
			logger.log(Status.PASS, "Successfully navigate to search result page");

		//	String Cart_Excel = BaseClass.getExcelData("Otcandnonrx", i, 1);

			// Step 7 : Add product to the cart//
			try {
				Thread.sleep(3000);

				WebDriverWait wait = new WebDriverWait(driver, 30);
				WebElement Cart_btn = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@resource-id='app']/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View[4]/android.view.View/android.widget.Button")));

				Thread.sleep(3000);

				btnclick(Cart_btn);
				
				System.out.println("successfully Items are added");
			} catch (Exception e) {
				// TODO: handle exception
			}

			Thread.sleep(5000);
			//driver.navigate().back();

			driver.findElement(By.xpath("//android.widget.Button[@text='ADD TO CART']")).click();
		}

		try {
		driver.findElement(By.xpath("//android.widget.TextView[@text='PROCEED']")).click();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		driver.navigate().to("https://m.netmeds.com/checkout/cart/subscription");
		
		
		Thread.sleep(5000);
		logger.log(Status.PASS, "Successfully navigate to cartpage");

		driver.swipe(530, 1500, 530, 0, 1000);
		
//driver.swipe(530, 1500, 530, 550, 1000);
				

		// Step 13 : Click Proceed Button//
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text='PROCEED']")).click();
		Thread.sleep(3000);
		
		//driver.swipe(530, 1500, 530, 550, 1000);
		Thread.sleep(3000);

		
		//Upload Prescription
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//android.widget.Button[@text='UPLOAD PRESCRIPTION']")).click();

				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//android.widget.Button[@text='Choose files']")).click();
				
				Thread.sleep(3000);
				//driver.findElement(By.xpath("//android.widget.TextView[@text='Browse']")).click();
				
				Thread.sleep(3000);
				
				
				driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.android.chrome:id/bitmap_view'])[3]")).click();
				
				//driver.findElement(By.xpath("(//android.widget.ImageView[resource-id='com.google.android.documentsui:id/icon_thumb'])[1]")).click();
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.chrome:id/done']")).click();
				
				//Past Rx
				
				//driver.findElement(By.xpath("//android.view.View[@text='Past Rx']")).click();
				Thread.sleep(3000);
				driver.swipe(82, 1750, 82, 0, 1000);
				Thread.sleep(5000);
				
	//Actions action = new Actions(driver);	
//	WebElement Schedule =			driver.findElement(By.xpath("//android.widget.Button[@text='SCHEDULE DELIVERY']"));
	
	
	//action.moveToElement(Schedule).click();
				
				driver.navigate().to("https://m.netmeds.com/checkout/subscription");
				
				
		//driver.findElement(By.xpath("//android.view.View[@text='Repeat every 60 days']/android.widget.RadioButton")).click();
		
	//	Thread.sleep(3000);
	//	btnclick(m.getSelectduration30());
	//	Thread.sleep(3000);
	//	btnclick(m.getSelectduration60());
		Thread.sleep(3000);
		//logger.log(Status.PASS, "Successfully Proceed button  was clicked");

		// Step 14 : Click Next Button//

	//	btnclick(m.getNextbutton());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='NEXT']")).click();
		
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully Next button was clicked");

		// Step 15: Click Subscribe//

	//	btnclick(m.getSubscribe());
		
		driver.swipe(530, 1440, 530, 0, 1000);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='SUBSCRIBE']")).click();
		logger.log(Status.PASS, "Successfully Subscribe button was clicked");
		

		// Step 16 : Ensure order is placed successfully//

		Thread.sleep(3000);

				String confirmation = driver.findElement(By.xpath("//android.view.View[@text='Order Placed Successfully!']")).getText(); 
				
				System.out.println(confirmation);

				
//	String	Status	=	driver.findElement(By.xpath("//android.view.View[@text='Order Placed Successfully!']/android.view.View[7]")).getText();
				//m.getOrder_Placed_text().getText();
				//
					//System.out.println(Status);
							String	Orderid	=	driver.findElement(By.xpath("//android.widget.Button[@text='VIEW REWARDS']/following-sibling::android.view.View[2]")).getText();

								System.out.println(Orderid);

				String order_status = driver.findElement(By.xpath("//android.widget.Button[@text='VIEW REWARDS']/following-sibling::android.view.View[3]")).getText(); // m.getOrderid().getAttribute("innerText");

				System.out.println(order_status);
				
				String orderconfirmation = "Order Placed Successfully!";

				Assert.assertEquals(orderconfirmation, confirmation);

				System.out.println(confirmation + "and the id is " + Orderid);

		// Tracking order//
		
		

	//	btnclick(m.getMysubscription());
		
	

	//	btnclick(m.getMedicineorders());
	
		
		driver.navigate().to("https://m.netmeds.com/customer/orderhistory");
		

			
		
		Thread.sleep(5000);
		try {
		MobileElement	 netty =  (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
		} catch (Exception e) {
			
		}
		
		Thread.sleep(5000);
		driver.swipe(82, 1179, 82, 1160, 1000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text='VIEW DETAILS']")).click();
		Thread.sleep(5000);
	
		driver.swipe(82, 900, 82, 0, 1000);
		Thread.sleep(3000);
		driver.swipe(82, 900, 82, 0, 1000);
		Thread.sleep(3000);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']")).click();

//		btnclick(m.getCancel_Order());
		Thread.sleep(5000);
//
		driver.swipe(82, 939, 82, 6, 1000);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text='YES']")).click();
	//	btnclick(m.getCancelyes());
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//input[@class=\"ng-untouched ng-pristine ng-valid\"])[1]")).click();
		Thread.sleep(3000);
//		btnclick(m.getSubmit_Cancel());
		
		driver.findElement(By.xpath("//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
		
		//logger.log(Status.PASS, "Successfully Order was Cancelled");
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
