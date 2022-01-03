package com.Nm.Msite_stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Andriod_prod.RetryAnalyzer;
import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Diaganostic  extends MsiteBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		
		//@BeforeClass
		public void launchbrowser2()   {
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
			
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}


		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");//"c195de14"
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
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//diagnostic.html");
       
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
	

   
//*****************************************************************Diagnostics	*********************************************************
	//@Test(enabled = true)
	@Test(priority = 1,retryAnalyzer=RetryAnalyzer.class)

	public void CategoryPage() throws Throwable {
		
		logger =  report.createTest("dignostic Page");
		logger.log(Status.PASS, "*************dignostic********************" );
		
		MsitePOM m = new MsitePOM();
		//driver.manage().window().maximize();
		driver.get("https://m.netmeds.com/");
		driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);
		Thread.sleep(6000);
		
		popupclose() ;

		/*
//Let's chat handle//
		letschat();
		Thread.sleep(5000);
	
//  Remove existing items from the cart  //

		driver.findElement(By.xpath("//*[@class='counter']")).click();
		Thread.sleep(5000);
		
		
//Let's chat handle//
		Thread.sleep(5000);
		letschat();
		Thread.sleep(3000);
	//	driver.swipe(82, 1275, 82, 1152, 1000);
		//Switch to Native_App
		
		
        Set<String> contextNames = driver.getContextHandles();
        for (String strContextName : contextNames) {
            if (strContextName.contains("NATIVE_APP")) {
                driver.context("NATIVE_APP");
                break;
            }
        }
		for (int i = 0; i < 25; i++) {
			Thread.sleep(3000);
			if (!(driver.findElements(By.xpath("//*[@text='REMOVE']")).size() == 0)) {
				

				try {

					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@text='REMOVE']")).click();
					
					Thread.sleep(3000);
					logger.log(Status.PASS, "Items are removed successfully");
					System.out.println("Items are removed from the cart");
				} catch (Exception e) {
					System.out.println("No items in the cart ");
				}

			} else {
				break;

			}

		}
			
		 //Switch to Chrome browser
	    Set<String> contextNames1 = driver.getContextHandles();
	    for (String strContextName : contextNames1) {
	        if (strContextName.contains("CHROMIUM")) {
	            driver.context("CHROMIUM");
	            break;
	        }
	    }
			
	
	driver.navigate().to("https://m.netmeds.com");
	*/
	//Wellness page
	
	Thread.sleep(7000);
	driver.findElement(By.xpath("//*[@text='Diagnostics' and @nodeName='SPAN']")).click();
	System.out.println("Successfully Naviagted to Diagnostics Page");
	logger.log(Status.PASS, "Successfully Naviagted to Wellness Page");
	//View all
	Thread.sleep(4000);
driver.findElement(By.xpath("//*[@text and @nodeName='SPAN' and (./preceding-sibling::* | ./following-sibling::*)[@nodeName='SPAN' and ./*[@nodeName='IMG']]]")).click();
		
	System.out.println("Category Page is working properly");
	/*driver.findElement(By.xpath("//*[@class='closeicon layout-align-center-center layout-column']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@text and @nodeName='SPAN' and (./preceding-sibling::* | ./following-sibling::*)[@nodeName='SPAN' and ./*[@nodeName='IMG']]]")).click();
	*/Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@text='Use current location']")).click();
			
try {
	driver.findElement(By.xpath("//*[@text and @nodeName='SPAN' and (./preceding-sibling::* | ./following-sibling::*)[@nodeName='SPAN' and ./*[@nodeName='IMG']]]")).click();

} catch (Exception e) {
	
}
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@name='pincode']")).sendKeys("624709");
	driver.findElement(By.xpath("//*[@name='pincode']")).clear();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@name='pincode']")).sendKeys("600001");
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//*/*/*/*[@nodeName='IMG' and ./parent::*[@text and @nodeName='SPAN']])[1]")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[@text='Book Test']")).click();
	Thread.sleep(4000);
	/*driver.findElement(By.xpath("//*[@id='input_8' and @nodeName='INPUT']")).click();
	driver.findElement(By.xpath("//*[@name='medName']")).sendKeys("Complete Blood Count (CBC)/ Hemogram");
	driver.findElement(By.xpath("(//*[@name='cart[]'])[1]")).click();*/
	try {
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//*/*/*/*[@nodeName='IMG' and ./parent::*[@text and @nodeName='SPAN']])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@text='Book Test']")).click();
	} catch (Exception e) {
		
	}SoftAssert SoftAssert=new SoftAssert();
	Thread.sleep(4000);
/*	String paientName=driver.findElement(By.xpath("//*[@nodeName='LABEL' and (./preceding-sibling::* | ./following-sibling::*)[@id='input_2']]")).getText();
	
	SoftAssert.assertEquals(paientName, "Patient's Name");*/
	driver.findElement(By.xpath("//*[@name='patientname']")).clear();
	driver.findElement(By.xpath("//*[@name='patientname']")).sendKeys("testing testing");
	String Mobile_Number=driver.findElement(By.xpath("//*[@text='Mobile Number']")).getText();
	
	SoftAssert.assertEquals(Mobile_Number, "Mobile Number");
	driver.findElement(By.xpath("//*[@name='mobileno']")).clear();
	driver.findElement(By.xpath("//*[@name='mobileno']")).sendKeys("8012222872");

	driver.findElement(By.xpath("//*[@text='Age']")).clear();
	driver.findElement(By.xpath("//*[@text='Age']")).sendKeys("29");
	driver.findElement(By.xpath("//*[@text='Female' and @nodeName='DIV']")).click();
String Email_ID=driver.findElement(By.xpath("//*[@text='Email ID']")).getText();
	
	SoftAssert.assertNotNull(Email_ID);
	driver.findElement(By.xpath("//*[@name='email']")).clear();
	driver.findElement(By.xpath("//*[@name='email']")).sendKeys("testingnetmeds@gmail.com");
	driver.findElement(By.xpath("//*[@text='Next']")).click();
	Thread.sleep(5000);
	btnclick(m.getDeleteaddress());
	System.out.println("Address was deleted successfully");
	logger.log(Status.PASS, "Address was deleted successfully");
	
//Modify
driver.swipe(0, 1500, 0, 1300,1000);
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@text='Edit']")).click();
Thread.sleep(5000);
//type(m.getPincode(),"600093");
driver.findElement(By.xpath("//*[@name='postcode']")).sendKeys("600001");
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys("gmailone");
driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("gmailtwo");
driver.findElement(By.xpath("//*[@name='street1']")).sendKeys("gmailstreet");
driver.findElement(By.xpath("//*[@text='Landmark' and @nodeName='LABEL']")).sendKeys("gmaillandmark");

Thread.sleep(5000);
btnclick(m.getSaveaddress());
System.out.println("Address was modified successfully");
logger.log(Status.PASS, "Address was modified successfully");

Thread.sleep(4000);

driver.findElement(By.xpath("//*[@text='ADD NEW ADDRESS' and @nodeName='A']")).click();

Thread.sleep(5000);

driver.findElement(By.xpath("//*[@name='postcode' and @top='true']")).sendKeys("600001");

Thread.sleep(5000);
driver.findElement(By.xpath("//*[@name='firstname' and @top='true']")).sendKeys("gmailnew");


Thread.sleep(5000);
driver.findElement(By.xpath("//*[@name='lastname' and @top='true']")).sendKeys("gmailnewtwo");

Thread.sleep(5000);
driver.findElement(By.xpath("//*[@name='street1' and @top='true']")).sendKeys("gmailnewstreet");

Thread.sleep(5000);
driver.findElement(By.xpath("//*[@name='street2' and @top='true']")).sendKeys("gmailnewlandmark");
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@name='telephone' and @top='true']")).sendKeys("8012222872");
Thread.sleep(5000);
/*driver.swipe(0, 500, 0, 0, 1000);
Thread.sleep(5000);*/
btnclick(m.getSaveaddress());

System.out.println("Address was Added successfully");
logger.log(Status.PASS, "Address was Added successfully");

Thread.sleep(5000);
try {
	driver.findElement(By.xpath("//*[@id='cusadd_10101302' and @name='address']")).click();
}
catch (Exception e) {

}
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@text='NEXT']")).click();
	Thread.sleep(5000);
	String Some_tests=driver.findElement(By.xpath("//*[@text='Note: Some tests/packages may require fasting']")).getText();
	SoftAssert.assertEquals(Some_tests, "Note: Some tests/packages may require fasting");
String selectmsg=	driver.findElementByXPath("//*[@text=' Select your preferred time slot for the lab personnel to collect sample at your selected address']").getText();
SoftAssert.assertEquals(selectmsg, " Select your preferred time slot for the lab personnel to collect sample at your selected address");
driver.findElement(By.xpath("(//*[@nodeName='INPUT'])[1]")).click();
//String packaged=driver.findElement(By.xpath("(//*/*/*[@text and @nodeName='SPAN' and ./parent::*[@nodeName='DIV']])[7 and @top='true']")).getText();
//SoftAssert.assertNotNull(packaged);
//String packaged_price=driver.findElement(By.xpath("((//*/*/*[@text and @nodeName='SPAN' and ./parent::*[@nodeName='DIV']])[8 and @top='true'])[2]")).getText();
//SoftAssert.assertNotNull(packaged_price);
////driver.findElement(By.xpath("//*[@nodeName='SPAN' and ./parent::*[@text and @nodeName='DIV' and ./parent::*[@id='heading']] and @top='true']")).click();
//Thread.sleep(5000);
//driver.findElement(By.xpath("(//*[@nodeName='INPUT'])[1]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@text='Review order']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@text='Pay']")).click();
	
	
	}
	
		
	
	//*****************************************************************M3 Subscription OTC Flow	*********************************************************
		//@Test(enabled = true)
	@Test(priority = 2,retryAnalyzer=RetryAnalyzer.class)

		public void diganosticpage() throws Throwable {
			
			logger =  report.createTest("dignostic Page");
			logger.log(Status.PASS, "*************dignostic********************" );
			
			MsitePOM m = new MsitePOM();
			//driver.manage().window().maximize();
			driver.get("https://m.netmeds.com/");
			
			Thread.sleep(6000);
			
			popupclose() ;
		//Wellness page
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@text='Diagnostics' and @nodeName='SPAN']")).click();
		System.out.println("Successfully Naviagted to Diagnostics Page");
		logger.log(Status.PASS, "Successfully Naviagted to Wellness Page");
		//View all
		Thread.sleep(4000);
	driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
			
		System.out.println("select package is working properly");
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//*[@text='NEXT' and @nodeName='BUTTON']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
	
		/*Thread.sleep(4000);
		driver.findElement(By.xpath("(//*[@text='View Price Breakup'])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@nodeName='SPAN' and ./parent::*[@nodeName='MD-TOOLBAR' and ./parent::*[@id='dialogContent_4']]]")).click();
	*/	Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@text='Next' and @top='true']")).click();
				
		
Thread.sleep(4000);
		SoftAssert SoftAssert=new SoftAssert();
		Thread.sleep(4000);
	/*	String paientName=driver.findElement(By.xpath("//*[@nodeName='LABEL' and (./preceding-sibling::* | ./following-sibling::*)[@id='input_2']]")).getText();
		
		SoftAssert.assertEquals(paientName, "Patient's Name");*/
		driver.findElement(By.xpath("//*[@name='patientname']")).clear();
		driver.findElement(By.xpath("//*[@name='patientname']")).sendKeys("testing testing");
		String Mobile_Number=driver.findElement(By.xpath("//*[@text='Mobile Number']")).getText();
		
		SoftAssert.assertEquals(Mobile_Number, "Mobile Number");
		driver.findElement(By.xpath("//*[@name='mobileno']")).clear();
		driver.findElement(By.xpath("//*[@name='mobileno']")).sendKeys("8012222872");

		driver.findElement(By.xpath("//*[@text='Age']")).clear();
		driver.findElement(By.xpath("//*[@text='Age']")).sendKeys("29");
		driver.findElement(By.xpath("//*[@text='Female' and @nodeName='DIV']")).click();
	String Email_ID=driver.findElement(By.xpath("//*[@text='Email ID']")).getText();
		
		SoftAssert.assertNotNull(Email_ID);
		driver.findElement(By.xpath("//*[@name='email']")).clear();
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys("testingnetmeds@gmail.com");
		driver.findElement(By.xpath("//*[@text='Next']")).click();
		
	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='NEXT']")).click();
		Thread.sleep(5000);
		String Some_tests=driver.findElement(By.xpath("//*[@text='Note: Some tests/packages may require fasting']")).getText();
		SoftAssert.assertEquals(Some_tests, "Note: Some tests/packages may require fasting");
	String selectmsg=	driver.findElementByXPath("//*[@text=' Select your preferred time slot for the lab personnel to collect sample at your selected address']").getText();
	SoftAssert.assertEquals(selectmsg, " Select your preferred time slot for the lab personnel to collect sample at your selected address");
	driver.findElement(By.xpath("(//*[@nodeName='INPUT'])[1]")).click();
	//String packaged=driver.findElement(By.xpath("(//*/*/*[@text and @nodeName='SPAN' and ./parent::*[@nodeName='DIV']])[7 and @top='true']")).getText();
	//SoftAssert.assertNotNull(packaged);
	//String packaged_price=driver.findElement(By.xpath("((//*/*/*[@text and @nodeName='SPAN' and ./parent::*[@nodeName='DIV']])[8 and @top='true'])[2]")).getText();
	//SoftAssert.assertNotNull(packaged_price);
	////driver.findElement(By.xpath("//*[@nodeName='SPAN' and ./parent::*[@text and @nodeName='DIV' and ./parent::*[@id='heading']] and @top='true']")).click();
	//Thread.sleep(5000);
	//driver.findElement(By.xpath("(//*[@nodeName='INPUT'])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Review order']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@text='Pay']")).click();
		
		
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
