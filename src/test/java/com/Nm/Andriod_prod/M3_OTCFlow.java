package com.Nm.Andriod_prod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.codehaus.groovy.ast.stmt.TryCatchStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
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
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class M3_OTCFlow extends MobileBaseClass {

	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();

		//	capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA");//"c195de14" //07c55fe10406//RZ8R20GLXTA

			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
			//capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			
					
			capabilities.setCapability("autoDismissAlerts", true);  
			
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
	
//*****************************************************************M3 Subscription OTC Flow	*********************************************************
	@Test(enabled = true)//,retryAnalyzer = RetryAnalyzer.class)
	public void M3SubscriptionOTCflow() throws Throwable {
		
		logger =  report.createTest("M3 - Subscription OTC Flow");
		logger.log(Status.PASS, "*************M3 - Subscription OTCFlow********************" );
		
		AndriodPom m = new AndriodPom();
		
		driver.launchApp();
			
			try {
				popupclose();
				Thread.sleep(5000);
				popupclose();
			btnclick(m.getLetsstarted());
			} catch (Exception e) {
				//driver.resetApp();
				//driver.launchApp();
			
			}
			
			Thread.sleep(1000);
			
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys("8072281468");
			popupclose();
			Thread.sleep(10000);
			popupclose();
			Thread.sleep(10000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys("test@123");
			
			Thread.sleep(2000);
		
			
			Thread.sleep(5000);
			btnclick(m.getLogin());
		}
		
		catch(Exception e) {
			System.out.println("Already logged in");
		}
		 
			popupclose();
		
			driver.findElement(By.xpath("//android.widget.TextView[@text='Orders']")).click();
		Thread.sleep(5000);
		btnclick(m.getSubscription());
		Thread.sleep(6000);
		btnclick(m.getCreatenew_subscription());
		Thread.sleep(6000);
		btnclick(m.getM3productsearch());
		Thread.sleep(3000);
		
		//type(m.getM3productsearch(),"Folvite Tablet 45'S");
		//driver.findElement(By.xpath("//android.widget.TextView[@resourceid='com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn']")).click();
		
		
		for (int i = 0; i < 2; i++) {

			type(m.getM3productsearch(), MobileBaseClass.getExcelData("Otcandnonrx", i, 0));

			// btncli(m.getSearchIcon());
			logger.log(Status.PASS, "Successfully navigate to search result page");
			try{
				
				driver.hideKeyboard();
			
			}catch (Exception e) {
				
				System.out.println("no keyboard available to hide");
			}

			//String Cart_Excel = MobileBaseClass.getExcelData("Otcandnonrx", i, 1);

			// Step 7 : Add product to the cart//
			try {
				Thread.sleep(3000);

				WebDriverWait wait = new WebDriverWait(driver, 30);
				WebElement Cart_btn = wait.until(
						ExpectedConditions.elementToBeClickable(By.id("com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn")));

				Thread.sleep(3000);
				

				btnclick(Cart_btn);
				
				System.out.println("successfully Items are added");
			} catch (Exception e) {
				// TODO: handle exception
			}

			Thread.sleep(3000);
			

			//Thread.sleep(3000);
			
			//driver.navigate().back();
		}

//Proceed to checkout
		
btnclick(m.getProceedtocheckout());
Thread.sleep(3000);
logger.log(Status.PASS, "Successfully proceed to checkout");
System.out.println("Successfully proceed to checkout");

//Subs20 -promo code

String Promocode = m.getSubs20_promo().getText();
String actualpromocode = "SUBS20";
Assert.assertEquals(Promocode, actualpromocode);
System.out.println(Promocode);
Thread.sleep(3000);



		// Step 10 :Remove qty//
		btnclick(m.getRemoveitem());
		Thread.sleep(3000);
		logger.log(Status.PASS, " item removed Successfully");
		System.out.println(" item removed Successfully");
		
		// Step 11: Decrease qty//
		driver.findElement(By.xpath("(//android.widget.TextView[@resource-id ='com.NetmedsMarketplace.Netmeds:id/cart_tv_item_qty'])")).click();
		Thread.sleep(3000);
		WebElement qty_dec = 	driver.findElement(By.xpath("//android.widget.TextView[@text='13']|(//android.widget.LinearLayout[@resource-id='com.NetmedsMarketplace.Netmeds:id/cn_item_parent'])[6]"));
		qty_dec.click();
		//Select qtydecrease = new Select(m.getQty_Incr_Decr());
		//qtydecrease.selectByIndex(1);
	
		Thread.sleep(3000);
		
		logger.log(Status.PASS, " quantity decreased Successfully");
		System.out.println(" quantity decareased Successfully");

		//Step 9 :Increase qty//

				driver.findElement(By.xpath("(//android.widget.TextView[@resource-id ='com.NetmedsMarketplace.Netmeds:id/cart_tv_item_qty'])")).click();
				//Select qtyincrease = new Select(m.getQty_Incr_Decr());
				//qtyincrease.selectByIndex(3);
				Thread.sleep(3000);
		WebElement qty_increase = driver.findElement(By.xpath("//android.widget.TextView[@text='15']|(//android.widget.LinearLayout[@resource-id='com.NetmedsMarketplace.Netmeds:id/cn_item_parent'])[9]"));
		Thread.sleep(3000);
		qty_increase.click();
				//driver.findElement(By.xpath("(//android.widget.TextView[@resource-id ='com.NetmedsMarketplace.Netmeds:id/cart_tv_item_qty'])"));
				Thread.sleep(3000);
				
				logger.log(Status.PASS, " quantity increased Successfully");
				System.out.println(" quantity increased Successfully");



//Proceed
btnclick(m.getProceed_btn());
Thread.sleep(2000);

//Deliveries
WebElement deliveries = driver.findElement(By.xpath("//*[@class = 'android.widget.SeekBar']"));
	
TouchAction action = new TouchAction((MobileDriver)driver); 
action.longPress(deliveries).moveTo(deliveries,100,100).release().perform();
action.perform();	

logger.log(Status.PASS, "Delievery  selected successfully");
System.out.println("Delievery  selected successfully");
Thread.sleep(2000);

//Delivery Interval
btnclick(m.getDelivery_30days());
Thread.sleep(2000);
	
btnclick(m.getDelivery_45days());
Thread.sleep(2000);

btnclick(m.getDelivery_60days());
Thread.sleep(2000);

logger.log(Status.PASS, "Delievery intervalselected successfully");
System.out.println("Delievery interval selected successfully");
//proceed

btnclick(m.getProceedto_placeorder());
Thread.sleep(2000);

//place order

btnclick(m.getPlaceorder());

Thread.sleep(3000);

logger.log(Status.PASS, "Order was placed successfully");
System.out.println("Order was placed successfully");


//Order success page
for (int i = 0; i < 10; i++) {
	
	Thread.sleep(3000);
	driver.swipe(0, 900, 0, 0, 1000);
	
	if (m.getPayment_cod_list().size()==1) {
		
		Thread.sleep(3000);
		 btnclick(m.getPayment_cod());
		break;
	} else {
		
		System.out.println("Swipe Down to click on Pay Button");

	}}
driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
btnclick(m.getPayment_paybutton());
Thread.sleep(10000);


//my orders


btnclick(m.getMyorders());
Thread.sleep(3000);

driver.findElement(By.xpath("//android.widget.TextView[@text='Orders']")).click();

Thread.sleep(3000);
	
//View details


btnclick(m.getViewdetails());
Thread.sleep(3000);

//cancel order


btnclick(m.getCancelorder());
Thread.sleep(3000);
//yes

btnclick(m.getYesbutton());
Thread.sleep(2000);


//Cancel reason

btnclick(m.getCancel_reason());

Thread.sleep(2000);

//Submit and cancel

Thread.sleep(2000);
try {
driver.swipe(790, 1100, 800, 70, 1000);
}catch (Exception e) {
	driver.swipe(0, 500, 0, 0, 1000);
}
Thread.sleep(2000);



btnclick(m.getSubmit_cancel());
logger.log(Status.PASS, "Order was cancelled successfully");
System.out.println("Order was cancelled successfully");


System.out.println("M3 Subscription OTC Flow is working properly");
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
		
      //driver.quit();
	}


}
