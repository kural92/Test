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

public class M3_DoctorConsultation_Flow extends MobileBaseClass {

	
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
	

//**************************************************M3 -Doctor consultation***************************************************
	
	@Test(enabled = true)
	public void M3Subscription_DoctorConsultationflow() throws Throwable {
		
		logger =  report.createTest("M3 - DoctorConsultation Flow");
		logger.log(Status.PASS, "*************M3 - DoctorConsultation Flow********************" );
		
		AndriodPom m = new AndriodPom();
		
		driver.launchApp();
			
		
			
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
		
		
		Thread.sleep(5000);
		btnclick(m.getSubscription());
		Thread.sleep(6000);
		btnclick(m.getCreatenew_subscription());
		Thread.sleep(6000);
		btnclick(m.getM3productsearch());
		Thread.sleep(3000);
		
		//type(m.getM3productsearch(),"Folvite Tablet 45'S");
		//driver.findElement(By.xpath("//android.widget.TextView[@resourceid='com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn']")).click();
		
		
		for (int i = 0; i < 3; i++) {

			type(m.getM3productsearch(), MobileBaseClass.getExcelData("Rx", i, 0));

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

		btnclick(m.getProceedtocheckout());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully proceed to checkout");
		System.out.println("Successfully proceed to checkout");
		
		//Proceed
		btnclick(m.getProceed_btn());
		Thread.sleep(3000);
	
	//Select doctor consultation
		btnclick(m.getDoctor_consultation());
		
	
 
 Thread.sleep(3000);
 
 driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/closeView")).click();
 Thread.sleep(3000);
 driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/setAddressButton")).click();
		 

//Delivery Interval
//btncli(m.getDelivery_30days());
Thread.sleep(5000);
	
btnclick(m.getDelivery_45days());
Thread.sleep(2000);

btnclick(m.getDelivery_60days());
Thread.sleep(2000);

logger.log(Status.PASS, "Delievery intervalselected successfully");
System.out.println("Delievery interval selected successfully");

//proceed

btnclick(m.getProceedto_placeorder());
Thread.sleep(4000);


//Address change

btnclick(m.getAddress_change());
Thread.sleep(3000);

//Modify address
driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edit")).click();

//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/pinCode")).sendKeys("600100");

type(m.getPincode(), "600100");
Thread.sleep(2000);


//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/firstName")).sendKeys("Testfirstname");

type(m.getFirstname(),"Firstname");
Thread.sleep(2000);

//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/lastName")).sendKeys("Lastname");
type(m.getLastname(),"Test");
Thread.sleep(2000);

//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/houseNumber")).sendKeys("Addressnewonetwo");
type(m.getAddress(),"Addressfirst");
Thread.sleep(2000);

//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/landMark")).sendKeys("nearplaza");

type(m.getLandmark(),"nearplaza");

Thread.sleep(2000);


//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/saveAddressButton")).click();

btnclick(m.getSave_address());

logger.log(Status.PASS, "Address was modified successfully");

System.out.println("Address was modified successfully");

//Delete address

Thread.sleep(5000);
List<WebElement> delete  = driver.findElements(By.xpath("(//android.widget.TextView[@text='DELETE'])"));
Thread.sleep(3000);
delete.get(0).click();




logger.log(Status.PASS, "Address was deleted successfully");
System.out.println("Address was deleted successfully");

//Add address

Thread.sleep(3000);

driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/addAddress")).click();
Thread.sleep(3000);
//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/pinCode")).sendKeys("600097");

type(m.getPincode(), "600097");
Thread.sleep(2000);


//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/firstName")).sendKeys("Testfirstname");

type(m.getFirstname(),"Firstaddress");
Thread.sleep(2000);

//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/lastName")).sendKeys("Lastname");
type(m.getLastname(),"Test");
Thread.sleep(2000);

//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/houseNumber")).sendKeys("Addressnewonetwo");
type(m.getAddress(),"Addressfirst");
Thread.sleep(2000);

//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/landMark")).sendKeys("nearplaza");

type(m.getLandmark(),"neartheatre");

Thread.sleep(2000);


//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/saveAddressButton")).click();

btnclick(m.getSave_address());

logger.log(Status.PASS, "Address was addedd successfully");
System.out.println("Address was added successfully");

//place order

Thread.sleep(5000);
btnclick(m.getPlaceorder());

Thread.sleep(3000);
logger.log(Status.PASS, "Order was placed successfully");
System.out.println("Order was placed successfully");


//Payment page
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
Thread.sleep(3000);
btnclick(m.getPayment_paybutton());
Thread.sleep(7000);

//my orders


btnclick(m.getMyorders());

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
driver.swipe(790, 1100, 800, 70, 1000);
Thread.sleep(2000);
btnclick(m.getSubmit_cancel());

logger.log(Status.PASS, "Order was cancelled successfully");
System.out.println("Order was cancelled successfully");


System.out.println("M3  Doctor consultation  is working properly");
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
