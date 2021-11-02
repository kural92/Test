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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MobileBaseClass;
import com.Nm.Pom.AndriodPom;
import com.Nm.Pom.Monepom;
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
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.FileAndEnv;

public class M1_flow extends MobileBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() throws IOException {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406"); //RZ8R20GLXTA //GBT4C19326001968//07c55fe10406//RZ8R20GLXTA


			//capabilities.setCapability(MobileCapabilityType.UDID, FileAndEnv.envAndFile().get("UDID"));  //fc95d519 //RZ8R20GLXTA

			capabilities.setCapability(MobileCapabilityType.UDID,"RZ8R20GLXTA" );  //fc95d519 // //FileAndEnv.envAndFile().get("UDID")


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
	@Test(enabled=true)
	public void Mone_otc() throws Throwable {
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		AndriodPom m = new AndriodPom();
		driver.get("https://m.netmeds.com");
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
<<<<<<< HEAD
		Thread.sleep(5000);
=======

		Thread.sleep(5000);

		Thread.sleep(10000);

>>>>>>> c7193f0ebf6edd9ef81f778a6917516992818544
				String s="Patanjali Lauh Bhasm Powder 5 gm";
		Thread.sleep(2000);
		driver.navigate().to("https://m.netmeds.com/checkout/cart");
		for (int i = 0; i < 10; i++) {
			Thread.sleep(5000);
			if ((driver.findElements(By.xpath("//android.view.View[@text='ADD PRODUCTS']")).size() == 0)) {

				try {
					driver.findElement(By.xpath("//android.view.View[@text='REMOVE']")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else {
				logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		} 
<<<<<<< HEAD
=======

>>>>>>> c7193f0ebf6edd9ef81f778a6917516992818544
		try {
			
		Thread.sleep(5000);
		MobileElement netty = (MobileElement) driver.findElement(By.xpath("//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
		netty.click();
		}catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(3000);
<<<<<<< HEAD
=======


>>>>>>> c7193f0ebf6edd9ef81f778a6917516992818544
		driver.findElement(By.xpath("//android.view.View[@resource-id='page-header']/android.view.View[@index='1']/android.view.View/android.view.View")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text='Submit']/preceding-sibling::android.widget.EditText")).sendKeys(s);
		Thread.sleep(7000);
		driver.findElement(By.xpath("//android.view.View[@text='"+s+"']|//android.widget.TextView[@text='"+s+"']")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='product-addtocart-button']")).click();
		Thread.sleep(8000);
driver.findElement(By.xpath("//android.view.View[@resource-id='top_search_icon']/following-sibling::android.view.View[@index='3']")).click();	
		Thread.sleep(10000);
<<<<<<< HEAD
//MobileElement netty1 = (MobileElement) driver.findElement(By.xpath("//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));

//netty1.click();
=======

//MobileElement netty1 = (MobileElement) driver.findElement(By.xpath("//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));

//netty1.click();

		try {
			MobileElement netty = (MobileElement) driver.findElement(By.xpath("//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
			netty.click();
			} catch (Exception e) {
				// TODO: handle exception
			}


>>>>>>> c7193f0ebf6edd9ef81f778a6917516992818544
Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);

Thread.sleep(4000);
	
Dimension location = driver.manage().window().getSize();
String ss = location.toString();
System.out.println(location);
String replace = ss.replace("(", "").replace(")", "").replace(" ", "");
String[] split = replace.split(",");

System.out.println(split[0]);
System.out.println(split[1]);
int i=Integer.parseInt(split[0]);
int i1=Integer.parseInt(split[1]);
Thread.sleep(3000);
TouchAction touchAction = new TouchAction(driver);

touchAction.tap(i-100,i1-150).tap(i-100,i1-150).perform();


Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
touchAction.tap(i-100,i1-100).perform();
//MobileElement PAY=(MobileElement)driver.findElement(By.xpath("//android.widget.Button[@text='PAY']"));PAY.click();
Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
MobileElement cod = (MobileElement) driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='nms_cod']"));cod.click();
Thread.sleep(3000);
driver.findElement(By.xpath("//android.view.View[@resource-id='title_COD']/android.widget.Button[@index='2']")).click();
Thread.sleep(5000);
driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);


Thread.sleep(3000);
driver.findElement(By.xpath("//android.widget.Button[@text='TRACK ORDER']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//android.widget.Button[@text='VIEW DETAILS']")).click();
Thread.sleep(3000);
MobileElement netty2 = (MobileElement) driver.findElement(By.xpath("//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));

netty2.click();
Thread.sleep(5000);
driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
TouchAction touchAction1 = new TouchAction(driver);
touchAction1.tap(250,i1-100).perform();
//MobileElement co = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']"));co.click();
//driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//android.widget.RadioButton[@text='Delay in delivery']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
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
