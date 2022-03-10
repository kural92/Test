package com.Nm.Msite_stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class M1_Cod extends MsiteBaseClass {
	
	
	
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
				public void M1O() throws Throwable {
	
	
	
	logger = report.createTest("M1 COD LOGIC");
	logger.log(Status.PASS, "*************M1 COD Logic********************");
	
	
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
		
		
		float total ;
		Thread.sleep(3000);
		String Tot = m.getOrder_review_totalAmount().getText();
		System.out.println(Tot);
		try {
		String tota = Tot.substring(3, 9);
		System.out.println(tota);
		 total = Float.parseFloat(tota);
		System.out.println(total);
		} catch (Exception e) {
			String tota = Tot.substring(3, 10);
			System.out.println(tota);
			if (tota.contains(",")) {
				Thread.sleep(1000);
				String rep = tota.replace(",", "");
				total = Float.parseFloat(rep);
				System.out.println(total);
			} else {
				Thread.sleep(1000);
				 total = Float.parseFloat(tota);
					System.out.println(total);
			}
			
		}
		/////
		

		
				
		
		
		
		
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
		}catch (Exception e) {
			// TODO: handle exception
		}


		

Thread.sleep(3000);
//driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
//touchAction.tap(i-100,i1-100).perform();
driver.findElement(By.xpath("//*[@text='Pay']")).click();
Thread.sleep(3000);


/*
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
*/

Thread.sleep(3000);
if (total<60||total>5000) {
	
	System.out.println("Unable to Process the payment / Cash on Delivery Option.The Net Value was Below 60 or above 5000");
	/*
	 * try {
	 * 
	 * for (int i = 0; i < 5; i++) {
	 * 
	 * Thread.sleep(3000); driver.swipe(0, 900, 0, 0, 1000);
	 * 
	 * if (m.getPayment_cod_list().size()==1) {
	 * 
	 * Thread.sleep(3000); btnclick(m.getPayment_cod()); break; } else {
	 * 
	 * System.out.println("Swipe Down to click on pay Button");
	 * 
	 * }} Thread.sleep(3000);
	 * 
	 * }catch (Exception e) { // TODO: handle exception }
	 */

/////
	
} else {
	
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
 }
		Thread.sleep(3000);
		letschat();
		

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

//////

Thread.sleep(5000);
driver.swipe(50, 750, 0, 0, 1000);
//	btnclick(m.getTrack_Order());
driver.findElement(By.xpath("//android.widget.Button[@text='TRACK ORDER']|//*[@text='TRACK ORDER']|//*[@text='Track Order']")).click();

 Thread.sleep(10000);

Thread.sleep(5000);
btnclick(m.getViewdetails());
try {
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
}catch (Exception e) {
// TODO: handle exception
}
for (int ii = 0; ii < 10; ii++) {


Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);
try {
if (driver.findElement(By.xpath("//*[@text='Cancel Order']")).isDisplayed()) {


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

//MobileElement co = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']"));co.click();
driver.findElement(By.xpath("//*[@text='Cancel Order']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text='Delay in delivery ']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL' and @nodeName='BUTTON' and @top='true']")).click();
//touchAction.tap(100,i1).perform();

 
 
 /*
 letschat();
 driver.findElement(By.xpath("//*[@text=' View Details ']|//android.widget.Button[@text='VIEW DETAILS']")).click();
 Thread.sleep(3000);
 driver.findElement(By.xpath("//*[@text='Cancel Order']|//android.widget.Button[@text='CANCEL ORDER']")).click();
 Thread.sleep(3000);
 driver.findElement(By.xpath("//*[@css='INPUT.ng-untouched.ng-pristine.ng-valid']|//android.widget.RadioButton[@text='Delay in delivery']")).click();
 Thread.sleep(3000);
 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
Thread.sleep(10000);
*/
//	driver.get("https://m.netmeds.com");

Thread.sleep(6000);





	
	}
	
	
	@Test(enabled = true)
	public void M1() throws Throwable {



logger = report.createTest("M1 COD FLOW");
logger.log(Status.PASS, "*************M1 COD LOGIC 2********************");


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
driver.findElement(By.xpath("//*[@name='q']")).sendKeys( "Malibu C swimmers Wellness Collection kit 560ml");//Patanjali Lauh Bhasm Powder 5 gm
Thread.sleep(1500);
driver.pressKeyCode(AndroidKeyCode.ENTER);
Thread.sleep(3000);
driver.findElement(By.xpath("(//*[@id='algolia_hits']/*/*/*/*/*[@text and @nodeName='DIV' and ./parent::*[@nodeName='A' and (./preceding-sibling::* | ./following-sibling::*)[@nodeName='DIV']]])[1]")).click();
// btncli(m.getSearchIcon());
logger.log(Status.PASS, "Successfully navigate to search result page" );


//add to the cart

Thread.sleep(3000);
driver.swipe(0, 500, 0, 0, 1000);
try {
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text=' ADD TO CART ']")).click();

Thread.sleep(3000);
driver.findElement(By.xpath("(//*/*[@nodeName='BUTTON'])[2]")).click();

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


float total ;
Thread.sleep(3000);
String Tot = m.getOrder_review_totalAmount().getText();
System.out.println(Tot);
try {
String tota = Tot.substring(3, 9);
System.out.println(tota);
total = Float.parseFloat(tota);
System.out.println(total);
} catch (Exception e) {
String tota = Tot.substring(3, 10);
System.out.println(tota);
if (tota.contains(",")) {
	Thread.sleep(1000);
	String rep = tota.replace(",", "");
	total = Float.parseFloat(rep);
	System.out.println(total);
} else {
	Thread.sleep(1000);
	 total = Float.parseFloat(tota);
		System.out.println(total);
}

}
/////



	




try {
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
}catch (Exception e) {
// TODO: handle exception
}




Thread.sleep(3000);
//driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
//touchAction.tap(i-100,i1-100).perform();
driver.findElement(By.xpath("//*[@text='Pay']")).click();
Thread.sleep(3000);


/*
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
*/

Thread.sleep(3000);
if (total<60||total>5000) {

System.out.println("Unable to Process the payment / Cash on Delivery Option.The Net Value was Below 60 or above 5000");
/*
* try {
* 
* for (int i = 0; i < 5; i++) {
* 
* Thread.sleep(3000); driver.swipe(0, 900, 0, 0, 1000);
* 
* if (m.getPayment_cod_list().size()==1) {
* 
* Thread.sleep(3000); btnclick(m.getPayment_cod()); break; } else {
* 
* System.out.println("Swipe Down to click on pay Button");
* 
* }} Thread.sleep(3000);
* 
* }catch (Exception e) { // TODO: handle exception }
*/

/////

} else {

for (int i = 0; i < 5; i++) {

Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);

if (m.getPayment_cod_list().size()==1) {

Thread.sleep(3000);
 btnclick(m.getPayment_cod());
break;
} else {

System.out.println("Swipe Down to click on pay Button");


Thread.sleep(3000);
letschat();


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

//////

Thread.sleep(5000);
driver.swipe(50, 750, 0, 0, 1000);
//btnclick(m.getTrack_Order());
driver.findElement(By.xpath("//android.widget.Button[@text='TRACK ORDER']|//*[@text='TRACK ORDER']|//*[@text='Track Order']")).click();

Thread.sleep(10000);

Thread.sleep(5000);
btnclick(m.getViewdetails());
try {
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
}catch (Exception e) {
//TODO: handle exception
}
for (int ii = 0; ii < 10; ii++) {


Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);
try {
if (driver.findElement(By.xpath("//*[@text='Cancel Order']")).isDisplayed()) {


Thread.sleep(3000);
//btnclick(m.getPackageImage());
break;
} else {

System.out.println("Swipe Down to click on package Button");

}
} catch (Exception e) {
//TODO: handle exception
}
}

//MobileElement co = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']"));co.click();
driver.findElement(By.xpath("//*[@text='Cancel Order']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text='Delay in delivery ']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL' and @nodeName='BUTTON' and @top='true']")).click();
//touchAction.tap(100,i1).perform();



/*
letschat();
driver.findElement(By.xpath("//*[@text=' View Details ']|//android.widget.Button[@text='VIEW DETAILS']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text='Cancel Order']|//android.widget.Button[@text='CANCEL ORDER']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@css='INPUT.ng-untouched.ng-pristine.ng-valid']|//android.widget.RadioButton[@text='Delay in delivery']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
Thread.sleep(10000);
*/
//driver.get("https://m.netmeds.com");

Thread.sleep(6000);

}}
}




}
	
	
	
	
	
	
	
	

}
