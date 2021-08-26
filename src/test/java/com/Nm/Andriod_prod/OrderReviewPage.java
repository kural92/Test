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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class OrderReviewPage extends MobileBaseClass {


	
	
	
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
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//OrderReview.html");
       
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
	public void orderReview() throws Throwable {
		
		logger =  report.createTest("Order review page");
		logger.log(Status.PASS, "*************Order review page ********************" );
		
		AndriodPom m = new AndriodPom();
		
		Thread.sleep(10000);
		popupclose();
		try {
			btnclick(m.getLetsstarted());
			Thread.sleep(5000);
			driver.hideKeyboard();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		popupclose();
		popupclose();
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
			SoftAssert Assert=new SoftAssert();
			Thread.sleep(5000);
			//Assert.assertEquals( m.getOrP_product_title().getText(),"PRODUCTS");
			Assert.assertEquals( m.getOrP_Delivery_Estimate().getText(),"Delivery Estimate");
			Assert.assertNotNull(m.getOrP_txt_estimate_date().getText());
			Assert.assertNotNull(m.getOrP_drug_name().getText());
			Assert.assertNotNull(m.getOrp_manufacturer_name().getText());
			Assert.assertNotNull(m.getOrp_tv_item_seller().getText());
			Assert.assertNotNull(m.getOrp_tv_item_expiry().getText());
			Assert.assertEquals( m.getOrp_qtyLabel().getText(),"Quantity :");
			Assert.assertNotNull(m.getOrp_tv_item_expiry().getText());
			Assert.assertEquals( m.getOrp_PAYMENT_DETAIls().getText(),"PAYMENT DETAILS");
			Assert.assertEquals( m.getOrp_MRP_Total().getText(),"MRP Total");
			Assert.assertEquals( m.getOrp_Delivery_Charges().getText(),"Delivery Charges");
			Assert.assertEquals( m.getOrp_Total_Amount().getText(),"Total Amount");
			Assert.assertNotNull(m.getOrp_mrpTotal_value().getText());
			Assert.assertNotNull(m.getOrp_tv_delivery_Charges_value().getText());
			Assert.assertNotNull(m.getOrp_tv_order_amount_value().getText());
			Assert.assertEquals( m.getOrp_disclaimer_text().getText(),"Netmeds is a technology platform to facilitate transaction of business. The products and services are offered for sale by the sellers. The user authorizes the delivery personnel to be his agent for delivery of the goods. For details read Terms and Conditions");

			Thread.sleep(4000);
			driver.navigate().back();
			Thread.sleep(2000);
			String ss="Rxtor 10mg Tablet 10'S";
			Thread.sleep(2000);
			
			btnclick(m.getCart_search());
			Thread.sleep(2000);
		m.getSearchbarone().sendKeys(ss);
			 
			 
			
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


				Thread.sleep(3000);
				btnclick(m.getPastRx_button());
				Thread.sleep(3000);

				btnclick(m.getPrescriptionImage());
				Thread.sleep(3000);
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/doneButton")).click();
				Thread.sleep(3000);
	Thread.sleep(6000);
	
	btnclick(m.getSchedule_delivery());
	Thread.sleep(5000);
	
	 driver.swipe(0, 900, 0, 0, 1000);
	Thread.sleep(3000);
	btnclick(m.getOrp_prescriptionImage());
	Thread.sleep(3000);
	btnclick(m.getOrp_preview_close());
	Thread.sleep(3000);
			Thread.sleep(4000);

			//Address change

			btnclick(m.getAddress_change());
			Thread.sleep(3000);

			//Modify address
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edit")).click();
			type(m.getPincode(), "600100");
			Thread.sleep(2000);
			type(m.getFirstname(),"Firstname");
			Thread.sleep(2000);
			type(m.getLastname(),"Test");
			Thread.sleep(2000);
			type(m.getAddress(),"Addressfirst");
			Thread.sleep(2000);
			type(m.getLandmark(),"nearplaza");
			Thread.sleep(2000);
			btnclick(m.getSave_address());
			logger.log(Status.PASS, "Address was modified successfully");
			System.out.println("Address was modified successfully");
			Thread.sleep(3000);
			List<WebElement> delete  = driver.findElements(By.xpath("(//android.widget.TextView[@text='DELETE'])"));

			delete.get(1).click();




			logger.log(Status.PASS, "Address was deleted successfully");
			System.out.println("Address was deleted successfully");

			//Add address

			Thread.sleep(3000);

			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/addAddress")).click();
			Thread.sleep(3000);

			type(m.getPincode(), "600097");
			Thread.sleep(2000);
			type(m.getFirstname(),"Firstaddress");
			Thread.sleep(2000);
			type(m.getLastname(),"Test");
			Thread.sleep(2000);
			type(m.getAddress(),"Addressfirst");
			Thread.sleep(2000);
			type(m.getLandmark(),"neartheatre");
			Thread.sleep(2000);
			btnclick(m.getSave_address());
			logger.log(Status.PASS, "Address was addedd successfully");
			System.out.println("Address was added successfully");

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
