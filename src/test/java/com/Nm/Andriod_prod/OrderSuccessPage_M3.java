package com.Nm.Andriod_prod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
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

public class OrderSuccessPage_M3 extends MobileBaseClass {

	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.UDID, UDID);//"c195de14" //07c55fe10406
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
	
//*****************************************************************M3 -Order success page	*********************************************************
	@Test(enabled = true)
	public void OrderSuccessPageM3() throws Throwable {
		
		logger =  report.createTest("Order Success Page ");
		logger.log(Status.PASS, "*************Order Success Page********************" );
		
		AndriodPom m = new AndriodPom();
		
		driver.launchApp();
			
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Orders']")).click();
		Thread.sleep(5000);
		
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
			try{
				
				driver.hideKeyboard();
			
			}catch (Exception e) {
				
				System.out.println("no keyboard available to hide");
			}

			// btncli(m.getSearchIcon());
			logger.log(Status.PASS, "Successfully navigate to search result page");

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

//Proceed
btnclick(m.getProceed_btn());
Thread.sleep(2000);

//Deliveries
WebElement deliveries = driver.findElement(By.xpath("//*[@class = 'android.widget.SeekBar']"));
	
TouchAction action = new TouchAction((MobileDriver)driver); 
action.longPress(deliveries).moveTo(deliveries,100,100).release().perform();
action.perform();	

logger.log(Status.PASS, "Delivery  selected successfully");
System.out.println("Delivery  selected successfully");
Thread.sleep(2000);

//Delivery Interval
btnclick(m.getDelivery_30days());
Thread.sleep(2000);
	
btnclick(m.getDelivery_45days());
Thread.sleep(2000);

btnclick(m.getDelivery_60days());
Thread.sleep(2000);

logger.log(Status.PASS, "Delivery intervalselected successfully");
System.out.println("Delivery interval selected successfully");
//proceed

btnclick(m.getProceedto_placeorder());
Thread.sleep(5000);

//place order

btnclick(m.getPlaceorder());

Thread.sleep(3000);

logger.log(Status.PASS, "Order was placed successfully");
System.out.println("Order was placed successfully");
//payment page

for (int i = 0; i < 10; i++) {
	
	Thread.sleep(3000);
	driver.swipe(0, 1300, 0, 0, 1000);
	
	if (m.getPayment_cod_list().size()==1) {
		
		Thread.sleep(3000);
		 btnclick(m.getPayment_cod());
		break;
	} else {
		
		System.out.println("Swipe Down to click on pay Button");

	}}
driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
btnclick(m.getPayment_paybutton());
Thread.sleep(10000);
//Order success page
//Step 14 : Order status//

String Actual_orderstatus = m.getOrder_status().getText();

System.out.println("order status is  "+ Actual_orderstatus);

logger.log(Status.PASS, "order status is  "+ Actual_orderstatus);
Thread.sleep(3000);


//Pharmacists Verification//

String Actual_pharmacists_verfication = m.getPharmacists_verfication().getText();

System.out.println(Actual_pharmacists_verfication);

logger.log(Status.PASS, Actual_pharmacists_verfication);
		
Thread.sleep(3000);

//Delivery by

WebElement Deliveryby = m.getDeliverby_text(); //driver.findElement(By.xpath("//div[@class=\"deltitle\"]"));

System.out.println(Deliveryby.getText());

//Delivery by date

WebElement delivery_btwn =m.getDelivery_date(); //driver.findElement(By.xpath("//div[@class=\"deldate\"]"));

System.out.println("delivery date is between  "+delivery_btwn.getText());

Thread.sleep(3000);
try {
WebElement congrats = m.getCongrats();

System.out.println(congrats.getText());

Thread.sleep(3000);

WebElement scratch_cards_text = m.getScratch_card();

System.out.println(scratch_cards_text.getText());

Thread.sleep(3000);

driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/img_scratch")).click();



Thread.sleep(3000);

driver.swipe(345, 1029, 900, 1029, 1000);


Thread.sleep(3000);

driver.swipe(370, 1160, 700, 1160, 1000);
//System.out.println(congrats.getText());

Thread.sleep(3000);



driver.findElement(By.xpath("(//android.widget.ImageView[@index='1'])[1]")).click();

Thread.sleep(3000);
}catch (Exception e) {
	System.out.println("No Scratch card ");
}

Assert.assertEquals(gettext(m.getGrab_text()),"GRAB YOUR");

System.out.println(m.getGrab_text().getText());
Thread.sleep(3000);
Assert.assertEquals(gettext(m.getFree_medicines()),"Free Medicines");

System.out.println(m.getFree_medicines().getText());
Thread.sleep(3000);
Assert.assertEquals(gettext(m.getInvite_friends()),"Invite your friends and get");
Thread.sleep(3000);
System.out.println(m.getInvite_friends().getText());

Thread.sleep(3000);

/*
driver.swipe(790, 1100, 800, 70, 1000);
//Assert.assertEquals(gettext(m.getOffer_code()),"TEST1932");

System.out.println(m.getOffer_code().getText());


Thread.sleep(3000);

Assert.assertEquals(gettext(m.getShare_with_friends()),"Tap to share code with your friends");

System.out.println(m.getShare_with_friends().getText());

Thread.sleep(3000);
m.getOffer_code().click();

Thread.sleep(3000);
driver.findElement(By.id("android:id/button2")).click();

Thread.sleep(3000);

*/

//My rewards
//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/btn_view_reward")).click();


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
try {
	driver.swipe(790, 1100, 800, 70, 1000);
} catch (Exception e) {
	Thread.sleep(3000);
	driver.swipe(0, 400, 0, 0, 1000);
}

Thread.sleep(2000);

//Submit and cancel

btnclick(m.getSubmit_cancel());
logger.log(Status.PASS, "Order was cancelled successfully");
System.out.println("Order was cancelled successfully");



System.out.println("M3 Order Success is working properly");
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
	}

}

 @AfterTest
 	private void quitbrowser() {
	 report.flush();

	 driver.quit();
}

}
