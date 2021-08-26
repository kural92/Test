package com.Nm.Andriod_prod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

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
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class NetmedsFirst extends MobileBaseClass {
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.UDID, "NBBY79GM5LTCJBJR");  //fc95d519 //RZ8R20GLXTA
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
			//capabilities.setCapability("noReset", true);
			
			
			
			//capabilities.setCapability("autoDismissAlerts", true);  
			
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//NetmedsFirst.html");
       
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
	public void netmedsFirstwitoutPrime() throws Throwable {
		
		logger =  report.createTest("Netmeds first without prime user");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		AndriodPom m = new AndriodPom();
		
		Thread.sleep(10000);
		popupclose();
		try {
			btnclick(m.getLetsstarted());
			Thread.sleep(10000);
			driver.hideKeyboard();
		} catch (Exception e) {
driver.resetApp();		}
		Thread.sleep(10000);
		
		popupclose();
		popupclose();
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys("9677159095");
			Thread.sleep(3000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys("test4nm");
			
			btnclick(m.getLogin());
			Thread.sleep(2000);
		
}catch(Exception e) {
				System.out.println("Already logged in");
			}
		Thread.sleep(10000);
				String s="Patanjali Lauh Bhasm Powder 5 gm";
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
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(5000);
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/netmeds_first_title']")).size() == 0)) {

				try {
					Thread.sleep(3000);
					 driver.swipe(0, 900, 0, 0, 1000);			
					 } catch (Exception e) {
					// TODO: handle exception
				}

			} else {
				logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		}
		SoftAssert Assert=new SoftAssert();
			Assert.assertEquals( m.getHomepage_netmeds_first_title().getText(),"Save more with Netmeds First Membership");
			Assert.assertNotNull(m.getHomepage_netmeds_first_sub_title().getText());
			Assert.assertEquals( m.getHomepage_netmeds_first_discount().getText(),"Starting at Rs.299");
			Assert.assertEquals( m.getHomepage_netmeds_first_action_button().getText(),"Explore Plans");
			btnclick(m.getHomepage_netmeds_first_action_button());
Thread.sleep(10000);
Assert.assertEquals( m.getNetmedsFirstPage_header_text().getText(),"Save more with exclusive membership");

Assert.assertEquals( m.getNetmedsFirstPage_benefits_header_text().getText(),"GET MOST FROM");
Assert.assertEquals(m.getNetmedsFirstPage_benefits_sub_header_text().getText(),"Netmeds First Membership");
Assert.assertEquals(m.getNetmedsFirstPage_benefits_tip_text().getText(),"Get special discounts and offers on Netmeds services");
Assert.assertNotNull(m.getNetmedsFirstPage_benefits_linkPage().getText());
Assert.assertNotNull(m.getNetmedsFirstPage_benefits_linkType().getText());
Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);	
Assert.assertNotNull(m.getNetmedsFirstPage_benefits_linkPage().getText());
Assert.assertNotNull(m.getNetmedsFirstPage_benefits_linkType().getText());
Thread.sleep(3000);
driver.swipe(500, 500, 500, 1500, 1000);
Thread.sleep(3000);
btnclick(m.getNetmedsFirstPage_6month());
try {
	Thread.sleep(2000);
	btnclick(m.getRemoveButton());
} catch (Exception e) {
	// TODO: handle exception
}
Thread.sleep(3000);
driver.navigate().back();
Thread.sleep(3000);
btnclick(m.getNetmedsFirstPage_12month());
try {
	Thread.sleep(3000);
	btnclick(m.getRemoveButton());
} catch (Exception e) {
	// TODO: handle exception
}
Thread.sleep(2000);

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
Assert.assertEquals("Become Netmeds First Member", m.getCart_prime_header_text().getText());
Assert.assertEquals("Join membership to save much more! Exclusive offers designed for you",m.getCart_prime_sub_header_text().getText());
btnclick(m.getCart_img_circle_arrow());
Thread.sleep(5000);
btnclick(m.getNetmedsFirstPage_6month());
Thread.sleep(5000);
driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
driver.swipe(0, 500, 0, 0, 1000);
Thread.sleep(3000);
driver.swipe(0, 500, 0, 0, 1000);
String text = m.getCart_deliveryCharges().getText();
String ss = text.substring(1);
System.out.println(ss);
Assert.assertEquals("0.00", ss);
Thread.sleep(3000);
driver.swipe(500, 500, 500, 1500, 1000);
Thread.sleep(3000);
driver.swipe(500, 500, 500, 1500, 1000);
Thread.sleep(3000);
driver.swipe(500, 500, 500, 1500, 1000);
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
	Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(5000);
	driver.navigate().back();
	Thread.sleep(5000);
	btnclick(m.getHome_accountPage());
	Thread.sleep(2000);
	btnclick(m.getAcountPage_NetmedsFirstmember());
	Thread.sleep(5000);
	btnclick(m.getNetmedsFirstPage_6month());
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
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		 driver.swipe(0, 1600, 0, 1100, 1000);
		 Thread.sleep(5000);
		 driver.swipe(0, 1600, 0, 1100, 1000);
		 Thread.sleep(5000);
		 driver.swipe(0, 1600, 0, 1100, 1000);
		 btnclick(m.getAcountPage_logout());
		 Thread.sleep(5000);
		 btnclick(m.getLetsstarted());
		 popupclose();
		 popupclose();

			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys("9941004810");
			Thread.sleep(3000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys("netmeds2020");
			
			btnclick(m.getLogin());
			Thread.sleep(2000);
		
			Thread.sleep(10000);
			
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
		Thread.sleep(5000);
		driver.swipe(0, 900, 0, 0, 1000);
		Thread.sleep(3000);
		driver.swipe(0, 500, 0, 0, 1000);
		Thread.sleep(3000);
		driver.swipe(0, 500, 0, 0, 1000);
		String text1 = m.getCart_deliveryCharges().getText();
		String sss = text1.substring(1);
		System.out.println(ss);
		Assert.assertEquals("0.00", ss);
		Thread.sleep(3000);
	}
	@Test(enabled=false)
	public void mone_precrption() throws Throwable {
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		AndriodPom m = new AndriodPom();
		
		Thread.sleep(10000);
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
		//driver.hideKeyboard();
		Thread.sleep(10000);
		popupclose();
		Thread.sleep(10000);
		popupclose();
		
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

			Thread.sleep(3000);
			 driver.swipe(0, 900, 0, 0, 1000);
			 Thread.sleep(3000);
			 driver.swipe(0, 900, 0, 0, 1000);
			 Thread.sleep(3000);
			 driver.swipe(0, 900, 0, 0, 1000);
			 Thread.sleep(3000);
			 driver.swipe(0, 900, 0, 0, 1000);
			 Thread.sleep(3000);
			 btnclick(m.getPayment_cod());
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
