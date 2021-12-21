package com.Nm.Andriod_prod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Base.MobileBaseClass;
import com.Nm.Pom.AndriodPom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DignosticRadiology extends MobileBaseClass {

	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();


			//capabilities.setCapability(MobileCapabilityType.UDID, UDID);  //fc95d519 //RZ8R20GLXTA

			capabilities.setCapability("platformName", "Android");
		//	capabilities.setCapability("deviceName", "vivo 1819");
		//	capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
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
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//DignosticRadiology.html");
       
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
	
	@Test(enabled=true,priority =1,retryAnalyzer=RetryAnalyzer.class)
	public void Dignostic_radiology() throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		logger =  report.createTest("DignosticRadiology");
		logger.log(Status.PASS, "*************DignosticRadiology********************" );
		
		Thread.sleep(10000);
		AndriodPom m = new AndriodPom();
	btnclick(m.getDiag_image());
	Thread.sleep(3000);
	btnclick(m.getTxtViewTitleRadio());	
	Thread.sleep(2000);
	driver.hideKeyboard();
	btnclick(m.getImgCheck());
	btnclick(m.getBtnNext());
	SoftAssert Assert=new SoftAssert();
	Thread.sleep(10000);
	for (int i = 0; i < m.getImgFilterCheck().size(); i++) {
		m.getImgFilterCheck().get(i).click();
	}
	
	//btnclick(m.getImgFilterCheck1());
	Thread.sleep(10000);
	btnclick(m.getTextTestCount());
	btnclick(m.getPopupclosebutton());
	btnclick(m.getBtnNext());
	Thread.sleep(10000);
	m.getDiagnosticPatientName().clear();
	m.getDiagnosticPatientName().sendKeys("testing netmeds");
	m.getDiagnosticMobileNumber().clear();
	m.getDiagnosticMobileNumber().sendKeys("9677159095");
	m.getDiagnosticAge().clear();
	m.getDiagnosticAge().sendKeys("20");
	m.getTextMale().click();
	m.getTextFeMale().click();
	m.getDiagnosticPatientEmail().clear();
	m.getDiagnosticPatientEmail().sendKeys("indujaudhayak@gmail.com");
	m.getTextTestCount().click();
	m.getPopupclosebutton().click();
	btnclick(m.getBtnNext());
	//add address flow 
		Thread.sleep(4000);
	btnclick(m.getDateslot());
	Thread.sleep(4000);
	btnclick(m.getImgSlotCheck());
	Thread.sleep(4000);
	btnclick(m.getBtnNext());
	Thread.sleep(4000);
	Assert.assertEquals(m.getLabselected().getText(),"LAB SELECTED");
	Assert.assertNotNull(m.getTextLabName().getText());
	Assert.assertNotEquals(m.getTextLabName().getText(), "");
	Assert.assertNotNull(m.getTextSlotTime().getText());
	Assert.assertNotEquals(m.getTextSlotTime().getText(), "");
	Assert.assertEquals(m.getTime_Slot().getText(),"Time Slot");
	Assert.assertEquals(m.getLAB_TESTS().getText(),"LAB TESTS");
	Assert.assertNotNull(m.getTextTestName().getText());
	Assert.assertNotEquals(m.getTextTestName().getText(), "");
	Assert.assertNotNull(m.getTextPrice().getText());
	Assert.assertNotEquals(m.getTextPrice().getText(), "");
	Assert.assertNotNull(m.getTextStrikePrice().getText());
	Assert.assertNotEquals(m.getTextStrikePrice().getText(), "");
	Assert.assertEquals(m.getTxtSamplePickUpAddress().getText(),"SAMPLE PICKUP ADDRESS");
	
	Assert.assertNotNull(m.getTextName().getText());
	Assert.assertNotEquals(m.getTextName().getText(), "");
	Assert.assertEquals(m.getTxtViewOfferApplied().getText(),"APPLY PROMO CODE");
	Assert.assertEquals(m.getTxtViewMyRewards().getText(),"My Rewards");
	Thread.sleep(4000);
	btnclick(m.getBtnProceed());
	Thread.sleep(4000);
	btnclick(m.getPhonepe());
	btnclick(m.getPhonepe());
	/*Thread.sleep(15000);
	driver.pressKeyCode(AndroidKeyCode.BACK);

	try {
		//btnclick(m.getPayment_paybutton());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} catch (Exception e) {
	}
	Thread.sleep(5000);
	btnclick(m.getRetry());*/

	Thread.sleep(5000);
	btnclick(m.getAmazon_pay_withoutLink());
	Thread.sleep(10000);
	driver.pressKeyCode(AndroidKeyCode.BACK);
	Thread.sleep(7000);
	btnclick(m.getRetry());
	Thread.sleep(5000);
	btnclick(m.getMobikwik_withoutLink());
	Thread.sleep(5000);
	driver.pressKeyCode(AndroidKeyCode.BACK);
	Thread.sleep(5000);
	btnclick(m.getRetry());
	Thread.sleep(5000);
	btnclick(m.getFreecharge_PayLater_Wallet());
	Thread.sleep(5000);
	try {
		btnclick(m.getPayment_paybutton());


	} catch (Exception e) {
	}
	Thread.sleep(15000);
	driver.pressKeyCode(AndroidKeyCode.BACK);
	try {
		//btnclick(m.getPayment_paybutton());
		Thread.sleep(10000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} catch (Exception e) {
	}
	Thread.sleep(5000);
	btnclick(m.getRetry());
	Thread.sleep(10000);
	btnclick(m.getSimplpay());
	Thread.sleep(5000);

	driver.swipe(0, 900, 0, 0, 1000);
		//btnclick(m.getPhonepe());
		Thread.sleep(5000);
		
		driver.swipe(0, 400, 0, 0, 1000);
			btnclick(m.getAddnewCard());
	type(m.getCart_name(), "4111 1111 1111 1111");
	type(m.getCardValidity(), "06/25");
	type(m.getCardCvv(), "123");
	type(m.getCardHolderName(), "Netmeds testing");
	btnclick(m.getChk_save_card());	
	btnclick(m.getTv_pay());	
	Thread.sleep(10000);
	driver.pressKeyCode(AndroidKeyCode.BACK);

	try {
	//btnclick(m.getPayment_paybutton());
	Thread.sleep(15000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} catch (Exception e) {
	}
	Thread.sleep(5000);
	btnclick(m.getRetry());
	Thread.sleep(5000);
	driver.swipe(0, 900, 0, 0, 1000);
	Thread.sleep(5000);
	btnclick(m.getAxis_Bank());
	Thread.sleep(10000);
	driver.pressKeyCode(AndroidKeyCode.BACK);

	try {
	//btnclick(m.getPayment_paybutton());
	Thread.sleep(15000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} 
	catch (Exception e) {
	}
	Thread.sleep(10000);
	btnclick(m.getRetry());
	Thread.sleep(5000);
	btnclick(m.getHDFC_Bank());
	Thread.sleep(20000);
	driver.pressKeyCode(AndroidKeyCode.BACK);

	try {
	//btnclick(m.getPayment_paybutton());
	Thread.sleep(10000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} catch (Exception e) {
	}
	Thread.sleep(10000);
	btnclick(m.getRetry());
	Thread.sleep(5000);
	Thread.sleep(5000);
	btnclick(m.getMORE_BANKS());
	Thread.sleep(5000);
	type(m.getSearchBank(), "Allahabad Bank");
	Thread.sleep(5000);
	btnclick(m.getMainLayout());
	Thread.sleep(20000);
	driver.pressKeyCode(AndroidKeyCode.BACK);

	try {
		//btnclick(m.getPayment_paybutton());
		Thread.sleep(10000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} catch (Exception e) {
	}
	Thread.sleep(10000);
	btnclick(m.getRetry());
	Thread.sleep(5000);

	driver.swipe(0, 900, 0, 0, 1000);
	Thread.sleep(5000);
		
		
		
		

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
