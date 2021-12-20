package com.Nm.Andriod_prod;

import java.awt.Robot;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class M1_flow extends MobileBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();

		//	capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA"); //RZ8R20GLXTA //GBT4C19326001968

		//	capabilities.setCapability(MobileCapabilityType.UDID, "NBBY79GM5LTCJBJR");  //fc95d519 //RZ8R20GLXTA

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
	@Test(enabled=false)
	public void Mone_otc() throws Throwable {
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		AndriodPom m = new AndriodPom();
		
		Thread.sleep(10000);
		popupclose();
		popupclose();
		/* */
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys("8012222872");
			Thread.sleep(3000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys("test4nmm");
			
			btnclick(m.getLogin());
			Thread.sleep(2000);
		}catch(Exception e) {
				System.out.println("Already logged in");
			}
		Thread.sleep(10000);
				String s="Patanjali Lauh Bhasm Powder 5 gm";
		Thread.sleep(2000);
		btnclick(m.getGotocart()); 
		for (int i = 0; i < 2; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_no_result']")).size() == 0)) {

				try {
					btnclick(m.getRemoveButton());
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else {
				logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		}
		Thread.sleep(2000);
		btnclick(m.getCart_search());
		Thread.sleep(2000);
	m.getSearchbarone().sendKeys(s);
		 
		 
		
	Thread.sleep(2000);
			btnclick(m.getSearch_drugname());
			Thread.sleep(5000);
			try {
			btnclick(m.getAddtoCartButton());
			}catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(2000);
			btnclick(m.getGotocart()); 
			Thread.sleep(2000);
			btnclick(m.getProceed_btn());
			Thread.sleep(3000);

			btnclick(m.getPlaceorder());
			for (int i = 0; i < 10; i++) {
				
				Thread.sleep(3000);
				driver.swipe(0, 900, 0, 0, 1000);
				
				if (m.getPayment_cod_list().size()==1) {
					
					Thread.sleep(3000);
					 btnclick(m.getPayment_cod());
					break;
				} else {
					
					System.out.println("Swipe Down to click on Consult Now Button");

				}}
			
			 Thread.sleep(3000);
			 btnclick(m.getPayment_paybutton());
			 Thread.sleep(3000);
			String Order_id =  driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/order_id")).getText();
					
					
			logger.log(Status.PASS, "Order was placed successfully" );
			System.out.println("Order was placed successfully and the "   + Order_id);
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

			//btnclick(m.getYesbutton());
			Thread.sleep(2000);


			//Cancel reason

			btnclick(m.getCancel_reason());

			Thread.sleep(2000);

			//Submit and cancel
			Thread.sleep(3000);
			
			 driver.swipe(0, 900, 0, 0, 1000);
			 Thread.sleep(3000);
			btnclick(m.getSubmit_cancel());
			logger.log(Status.PASS, "Order was cancelled successfully");
			System.out.println("Order was cancelled successfully");



	}
	@Test(enabled=true)
	public void mone_precrption() throws Throwable {
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		AndriodPom m = new AndriodPom();
		
		Thread.sleep(15000);
		popupclose();
		Thread.sleep(15000);
		popupclose();
		
		Thread.sleep(10000);

	/*try {

		try {

			btnclick(m.getLetsstarted());
			Thread.sleep(5000);
			driver.hideKeyboard();
		} catch (Exception e) {
			driver.resetApp();
			Thread.sleep(5000);
			btnclick(m.getLetsstarted());

			Thread.sleep(5000);
			driver.hideKeyboard();
		}

		driver.hideKeyboard();
		Thread.sleep(15000);

		//driver.hideKeyboard();
		Thread.sleep(10000);*/

		
		try {
			
			Thread.sleep(5000);
			m.getMobilenumber().sendKeys("9677159095");
			Thread.sleep(3000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys("test4nm");
			driver.hideKeyboard();
			btnclick(m.getLogin());
			Thread.sleep(2000);
		}catch(Exception e) {
				System.out.println("Already logged in");
			}
		Thread.sleep(10000);
				String s="Rxtor 10mg Tablet 10'S";
		Thread.sleep(2000);
		btnclick(m.getGotocart()); 
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_no_result']")).size() == 0)) {

				try {
					btnclick(m.getRemoveButton());
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else {
				logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		}
		btnclick(m.getCart_search());
		Thread.sleep(2000);
	m.getSearchbarone().sendKeys(s);
		 
		 
		
	Thread.sleep(2000);
			btnclick(m.getSearch_drugname());
			Thread.sleep(5000);
			
			 driver.swipe(0, 500, 0, 0, 1000);
			try {
				Thread.sleep(3000);
			btnclick(m.getAddtoCartButton());
			}catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(5000);
			btnclick(m.getGotocart()); 
			Thread.sleep(5000);
			btnclick(m.getProceed_btn());
			Thread.sleep(10000);
			try {
				try {
					btnclick(m.getUploadPrescription());
				} catch (Exception e) {
					// TODO: handle exception
				}try {
					btnclick(m.getContinueUpload());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}catch (Exception e) {
				// TODO: handle exception
			}


/*Thread.sleep(3000);
btnclick(m.getCamera_button());
Thread.sleep(3000);
btnclick(m.getAllow());
Thread.sleep(3000);
btnclick(m.getCamera_clickbutton());
Thread.sleep(3000);

	btnclick(m.getM2_RX_DoneBtn());	

Thread.sleep(3000);
btnclick(m.getContinueUpload());

Thread.sleep(3000);
btnclick(m.getGallery_button());
Thread.sleep(3000);
btnclick(driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.android.documentsui:id/icon_thumb'])[1]")));
Thread.sleep(3000);

btnclick(m.getContinueUpload());*/
Thread.sleep(3000);
btnclick(m.getPastRx_button());
Thread.sleep(3000);

btnclick(m.getPrescriptionImage());
Thread.sleep(3000);
driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/doneButton")).click();
Thread.sleep(3000);

/*btnclick(m.getContinueUpload());
Thread.sleep(3000);
btnclick(m.getPDF_button());
Thread.sleep(3000);
btnclick(m.getPdf_Click());*/
Thread.sleep(15000);
btnclick(m.getSchedule_delivery());
Thread.sleep(5000);
			btnclick(m.getPlaceorder());

for (int i = 0; i < 10; i++) {
				
				Thread.sleep(3000);
				driver.swipe(0, 900, 0, 0, 1000);
				
				if (m.getPayment_cod_list().size()==1) {
					
					Thread.sleep(3000);
					 btnclick(m.getPayment_cod());
					break;
				} else {
					
					System.out.println("Swipe Down to click on Consult Now Button");

				}}
			 Thread.sleep(3000);
			 btnclick(m.getPayment_paybutton());
			 Thread.sleep(3000);
			String Order_id =  driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/order_id")).getText();
					
					
			logger.log(Status.PASS, "Order was placed successfully" );
			System.out.println("Order was placed successfully and the "   + Order_id);
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

			//btnclick(m.getYesbutton());
			Thread.sleep(2000);


			//Cancel reason

			btnclick(m.getCancel_reason());

			Thread.sleep(2000);

			//Submit and cancel

			btnclick(m.getSubmit_cancel());
			logger.log(Status.PASS, "Order was cancelled successfully");
			System.out.println("Order was cancelled successfully");


	
	
		
	//} catch (Exception e) {
		// TODO: handle exception
	//}
	
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
