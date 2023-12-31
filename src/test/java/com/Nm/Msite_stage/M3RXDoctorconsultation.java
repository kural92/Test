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
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class M3RXDoctorconsultation extends MsiteBaseClass {

	
	
	
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
	

//*******************************************************M3 Rx**********************************************************************//
	@Test
	public void M3Doctorconsultation() throws Throwable {

		logger = report.createTest("M3Doctorconsultation");
		logger.log(Status.PASS, "*************M3Doctorconsultation********************");

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
				
// Step 4 : Navigate to Mysubscription page//
		Thread.sleep(5000);
		btnclick(m.getMysubscriptionpage());
		Thread.sleep(5000);
		logger.log(Status.PASS, "Successfully navigate to mysubscriptionpage");
		System.out.println("Successfully navigate to mysubscriptionpage");
		
//Let's chat handle//
		letschat();
		Thread.sleep(5000);	
//create NewSubscription
		
		btnclick(m.getNewSubscription());

// Step 6:Search Product//

		Thread.sleep(5000);
		for (int i = 0; i < 2; i++) {

			type(m.getM3productsearch(), MobileBaseClass.getExcelData("Rx", i, 0));
			
			logger.log(Status.PASS, "Successfully navigate to search result page");

// Step 7 : Add product to the cart//
			try {
				Thread.sleep(5000);

				WebDriverWait wait = new WebDriverWait(driver, 30);
				WebElement Cart_btn = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='btn btn_to_cart m-0'])[1]|//android.view.View[@resource-id='app']/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View[4]/android.view.View/android.widget.Button")));

				Thread.sleep(5000);

				btnclick(Cart_btn);
				
				System.out.println("successfully Items are added");
			} catch (Exception e) {
				// TODO: handle exception
			}

			
	//Let's chat handle//
			letschat();
			
			Thread.sleep(5000);
//Add to cart	
			btnclick(m.getAddtocart());
		}

		try {
		driver.findElement(By.xpath("//android.widget.TextView[@text='PROCEED']")).click();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		driver.navigate().to("https://m.netmeds.com/checkout/cart/subscription");
		
		
		Thread.sleep(5000);
		logger.log(Status.PASS, "Successfully navigate to cartpage");

		driver.swipe(0, 1500, 0, 0, 1000);
		

		
//Let's chat handle//
		letschat();

		// Step 13 : Click Proceed Button//
		Thread.sleep(5000);
		btnclick(m.getProceedtocheckout());
		Thread.sleep(5000);

//Let's chat handle//
				letschat();
				Thread.sleep(5000);
//Doctor consulation 
				
				try {
				if (!(driver.findElement(By.xpath("//*[@class='extcheckbox']|//*[@nodeName='INPUT']|//android.widget.CheckBox[@resource-id='externaldoctr']|//*[@resource-id='externaldoctr']")).isSelected())) {
					driver.findElement(By.xpath("//*[@class='extcheckbox']|//*[@nodeName='INPUT']|//android.widget.CheckBox[@resource-id='externaldoctr']|//*[@resource-id='externaldoctr']")).click();
					Thread.sleep(5000);
				} else {
					
					System.out.println("Schedule doctor Already Selected");
				}
				}catch (Exception e) {
					driver.findElement(By.xpath("//*[@class='extcheckbox']|//android.widget.CheckBox[@resource-id='externaldoctr']")).click();
				}
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//*[@text='Schedule Delivery']")).click();
				
				
		//driver.findElement(By.xpath("//android.view.View[@text='Repeat every 60 days']/android.widget.RadioButton")).click();
		
	//	Thread.sleep(5000);
	//	btnclick(m.getSelectduration30());
	//	Thread.sleep(5000);
	//	btnclick(m.getSelectduration60());
		Thread.sleep(5000);
		//logger.log(Status.PASS, "Successfully Proceed button  was clicked");

		// Step 14 : Click Next Button//

		btnclick(m.getNextbutton());
		Thread.sleep(5000);
		logger.log(Status.PASS, "Successfully Next button was clicked");
		
		driver.swipe(0, 1500, 0, 0, 1000); 

// Change address
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='addchange']|//android.widget.TextView[@text='CHANGE']")).click();
		Thread.sleep(5000);
		
//Let's chat handle//
		letschat();
		
		
//Delete Address
//		driver.swipe(0, 1500, 0, 1300,1000);
		driver.swipe(0, 500, 0, 0, 1000);
		Thread.sleep(5000);
			btnclick(m.getDeleteaddress());
			System.out.println("Address was deleted successfully");
			logger.log(Status.PASS, "Address was deleted successfully");
			
//Modify
			try {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='addchange']|//android.widget.TextView[@text='CHANGE']")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}
	//	driver.swipe(0, 1500, 0, 1300,1000);
			//driver.swipe(0, 500, 0, 0, 1000);
		Thread.sleep(5000);
		btnclick(m.getModifyaddressbtn());
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
		
//Select Address
				btnclick(m.getSelectaddress());
				System.out.println("Address was selected successfully");
				logger.log(Status.PASS, "Address was selected successfully");
				Thread.sleep(5000);
		
// Step 15: Click Subscribe//

		driver.swipe(0, 1500, 0, 0, 1000);
		Thread.sleep(5000);
		btnclick(m.getSubscribe());
		logger.log(Status.PASS, "Successfully Subscribe button was clicked");
		

		// Step 16 : Ensure order is placed successfully//

		Thread.sleep(5000);

				String confirmation = driver.findElement(By.xpath("//*[@text='Order Placed Successfully!']|//android.view.View[@text='Order Placed Successfully!']")).getText(); 
				
				System.out.println(confirmation);

				
//	String	Status	=	driver.findElement(By.xpath("//android.view.View[@text='Order Placed Successfully!']/android.view.View[7]")).getText();
				//m.getOrder_Placed_text().getText();
				//
					//System.out.println(Status);
							String	Orderid	=	driver.findElement(By.xpath("//*[@text=' Order id - ']|//android.widget.Button[@text='VIEW REWARDS']/following-sibling::android.view.View[2]")).getText();

								System.out.println(Orderid);

								String order_status = driver.findElement(By.xpath("//*[@class='ordstatus']|//*[@text='CONSULTATION SCHEDULED']|//android.widget.Button[@text='VIEW REWARDS']/following-sibling::android.view.View[3]")).getText(); // m.getOrderid().getAttribute("innerText");

				System.out.println(order_status);
				
				String orderconfirmation = "Order Placed Successfully!";

				Assert.assertEquals(orderconfirmation, confirmation);

				System.out.println(confirmation + "and the id is " + Orderid);
				Thread.sleep(3000);
			//	driver.swipe(82, 1500, 82, 1420, 1000);
				driver.swipe(0, 500, 0, 0, 1000);
				Thread.sleep(3000);
				String	Deliverydate	=	driver.findElement(By.xpath("//*[@class='deldate']")).getText();

				System.out.println(Deliverydate);	
				

		// Tracking order//
		
		

	//	btnclick(m.getMysubscription());
		
	

	//	btnclick(m.getMedicineorders());
	
		Thread.sleep(3000);
		driver.navigate().to("https://m.netmeds.com/customer/orderhistory");
		

		




//Cancel Order			

//Let's chat handle//
			letschat();
			
			Thread.sleep(5000);
	
			btnclick(m.getViewdetails());
			Thread.sleep(5000);
			
			//Switch to Native_App		
		/*	 Set<String> contextNames4 = driver.getContextHandles();
		        for (String strContextName : contextNames4) {
		            if (strContextName.contains("NATIVE_APP")) {
		                driver.context("NATIVE_APP");
		                break;
		            }
		        }	*/	
				
			
			 driver.swipe(0, 1600, 0, 0, 1000);
			Thread.sleep(3000);
			btnclick(m.getCancelorder());
			Thread.sleep(5000);
		//	driver.swipe(82, 939, 82, 6, 1000);
			driver.swipe(0, 500, 0, 0, 1000);
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
	    
	    
	    
	Thread.sleep(5000);
	if (result.getStatus() == ITestResult.FAILURE) {
		Thread.sleep(5000);
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
