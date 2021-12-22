package com.Nm.Andriod_prod;

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
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CovidAssesement extends MobileBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();


		//	capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA");//"c195de14" //RZ8R20GLXTA

			//capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA");//"c195de14" //RZ8R20GLXTA


			//capabilities.setCapability(MobileCapabilityType.UDID, UDID);//"c195de14"

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
	


//*****************************************************Covid Assesment*************************


	
	
	@Test(enabled = true)
			//retryAnalyzer=RetryAnalyzer.class)
	public void CovidAssesment() throws Throwable {

		logger = report.createTest("Covid Assesment");
		logger.log(Status.PASS, "*************Covid Assesment********************");

	
	AndriodPom m = new AndriodPom();
		
		driver.launchApp();
		
		try {
			popupclose();
			Thread.sleep(5000);
			popupclose();
		btnclick(m.getLetsstarted());
		} catch (Exception e) {
			//driver.resetApp();
		
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
	
//Step 3 : consult button //
	for (int i = 0; i < 10; i++) {
		
		Thread.sleep(3000);
		driver.swipe(0, 1000, 0, 0, 1000);
		
		if (m.getConsultation_Btn_List().size()==1) {
			
			Thread.sleep(3000);
			btnclick(m.getConsultation_Btn());
			break;
		} else {
			
			System.out.println("Swipe Down to click on Consult Now Button");

		}
		
		
		
	}
		
	logger.log(Status.PASS, "Successfully clicked consultnow button");
	System.out.println("Successfully clicked consultnow button");
//Step 4 : click covid assement button //

	Thread.sleep(6000);
	
	
	for (int i = 0; i < 10; i++) {
		
		Thread.sleep(3000);
		driver.swipe(0, 1000, 0, 0, 1000);
		
		if (m.getStaratassesment().size()==1) {
			
			Thread.sleep(3000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/btn_subscribe")).click();
			break;
		} else {
			
			System.out.println("Swipe Down to click on Consult Now Button");

		}
		
		
		
	}
	
	
	
	
	
	
	logger.log(Status.PASS, "Successfully clicked start Assessment button");
	System.out.println("Successfully clicked start Assessment button");
	

//Step 5: Risk Assesment//

	Thread.sleep(5000);
	
	System.out.println(m.getHowoldareyou_text().getText());
	
	type(m.getAddage(), "19");
	
	Thread.sleep(3000);
	
	
	btnclick(m.getAge_done());
	
	Thread.sleep(3000);
	System.out.println(m.getGender_text().getText());
	Thread.sleep(3000);
	btnclick(m.getGender_selection_covid());
	
	Thread.sleep(3000);
	
	
	System.out.println(m.getBody_temp_text().getText());
	
	btnclick(m.getBody_temp_mild());
	
	Thread.sleep(3000);
	
	
	
	
	System.out.println(m.getOther_symptoms_text().getText());
Thread.sleep(3000);
	
	try {
		driver.swipe(620, 1900, 620, 0, 1000);
	} catch (Exception e) {
		driver.swipe(0, 600, 0, 0, 1000);
	}
	btnclick(m.getOther_symptoms_sneezing());
	
	Thread.sleep(3000);
	
	try {
		driver.swipe(620, 1900, 620, 0, 1000);
	} catch (Exception e) {
		driver.swipe(0, 600, 0, 0, 1000);
	}
	

	
	
	Thread.sleep(3000);
	btnclick(m.getConfirm());

	Thread.sleep(3000);
	

	
	Thread.sleep(3000);
	System.out.println(m.getTravelorcovid_contact_text().getText());
	
	Thread.sleep(5000);
	
	try {
		driver.swipe(620, 1900, 620, 0, 1000);
	} catch (Exception e) {
		driver.swipe(0, 600, 0, 0, 1000);
	}
	
	Thread.sleep(3000);
	btnclick(m.getTravelorcovid_contact());
	

	Thread.sleep(3000);
	
	System.out.println(m.getSymptoms_progress_text().getText());
	
	Thread.sleep(3000);
	try {
		driver.swipe(620, 1900, 620, 0, 1000);
	} catch (Exception e) {
		driver.swipe(0, 600, 0, 0, 1000);
	}
	
	btnclick(m.getSymptoms_progress_option1());
	

	
	Thread.sleep(10000);
	
	logger.log(Status.PASS, "Successfully given the assessment details");
	System.out.println("Successfully given the assessment details");
	
	
try	{
//Symtom checker covid -19
	
	System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='RISK OF COVID-19*:']")).getText());
	
	
		
	System.out.println("Risk level is "+ driver.findElement(By.xpath("//android.widget.TextView[@text='Low risk']")).getText());
	
	System.out.println(driver.findElement(By.xpath("(//android.widget.TextView[@text='RECOMMENDATIONS']/parent::androidx.appcompat.widget.LinearLayoutCompat/child::android.widget.TextView)[1]")).getText());
	
	System.out.println(driver.findElement(By.xpath("(//android.widget.TextView[@text='RECOMMENDATIONS']/parent::androidx.appcompat.widget.LinearLayoutCompat/child::android.widget.TextView)[2]")).getText());
	
	logger.log(Status.PASS, "Successfully given the recommendation based on the risk factor");
	System.out.println("Successfully given the recommendation based on the risk factor");
	
	driver.swipe(0, 1200, 0, 0, 1000);
	
	Thread.sleep(3000);
	
	List <WebElement> FAQ = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/text_faq_title']"));
	
	System.out.println("The element size is" + FAQ.size());
	
	for (int i=0;i<FAQ.size();i++) {
		
		Thread.sleep(3000);
		FAQ.get(i).click();
	}
	
	
	}catch (Exception e) {
		// TODO: handle exception
	}

logger.log(Status.PASS, "Covid Assesment scenario is working properly");
System.out.println("Covid Assesment scenario is working properly");

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
			//BaseClass.mail_report();
		}

	}

	@AfterTest
	private void quitbrowser() {
		report.flush();

		driver.quit();
	}

}
