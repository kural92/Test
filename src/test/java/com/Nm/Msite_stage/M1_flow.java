package com.Nm.Msite_stage;

import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Andriod_prod.RetryAnalyzer;
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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.FileAndEnv;

public class M1_flow extends MsiteBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() throws IOException {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability(MobileCapabilityType.UDID, "NBBY79GM5LTCJBJR"); //RZ8R20GLXTA //GBT4C19326001968//07c55fe10406//RZ8R20GLXTA


			//capabilities.setCapability(MobileCapabilityType.UDID, FileAndEnv.envAndFile().get("UDID"));  //fc95d519 //RZ8R20GLXTA

			//capabilities.setCapability(MobileCapabilityType.UDID,"NBBY79GM5LTCJBJR" );  //fc95d519 // //FileAndEnv.envAndFile().get("UDID")


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
			capabilities.setBrowserName(MobileBrowserType.CHROMIUM);

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
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//Moneflow.html");
       
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
	@Test(enabled = true,retryAnalyzer=RetryAnalyzer.class)
	public void Mone_otc() throws Throwable {
		
		logger = report.createTest("Netmeds First");
		logger.log(Status.PASS, "*************Netmeds First********************");
		
		
		// launch the browser
		
		
		MsitePOM m = new MsitePOM();
			  driver.get("https://m.netmeds.com/");

			  driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);
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
driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
MobileElement cod = (MobileElement) driver.findElement(By.xpath("//*[@id='nms_cod' and @name='nmsmstr_paymethod']"));cod.click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text and @nodeName='BUTTON']")).click();
Thread.sleep(5000);
driver.swipe(0, 900, 0, 0, 1000);
/*Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);*/


Thread.sleep(3000);

WebDriverWait wait = new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@text='Track Order']")))).click();
Thread.sleep(1000);


try {
	Thread.sleep(5000);
	
	
	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")))).click();
	Thread.sleep(1000);

	//driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
}catch (Exception e) {
	// TODO: handle exception
}
Thread.sleep(5000);
//Let's chat handle//
letschat();

Thread.sleep(5000);
btnclick(m.getViewdetails());
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
