package com.Nm.Website;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class NeetmedsFirst extends BaseClass{

	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//NeetmedsFirst.html");
       
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
       htmlReporter.config().setReportName("Test Report");

       //htmlReporter.config().setTheme(Theme.STANDARD);
   	
   }
	@Test(enabled = false)
	public  void NetmedsError() throws Throwable  {
		logger =  report.createTest(" All Categories");
		logger.log(Status.PASS, "*************Take Action Fail Alert********************" );
		Monepom m=new Monepom();

		try {
		 driver.manage().window().maximize();
		 btncli(m.getSignin());
		  Thread.sleep(5000);
		  type(m.getMobileno(),"7010752043");
		  Thread.sleep(3000);
		  btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
		  Thread.sleep(3000);
		  type(m.getPassword(),"Change@92"); 
		  btncli(m.getSignInpage());
		} catch (Exception e) {
			System.out.println("Already Logged In");
		}
		
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
		Thread.sleep(3000);
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size()==0)) {
				
				try {
					btncli(m.getRemovebutton());
					}catch (Exception e) {
						// TODO: handle exception
					}
				
			} else {
				 break;

			}
			
			
		}
		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/customer/netmeds-first");
		Thread.sleep(1500);
		btncli(m.getSix_months());
		Thread.sleep(3000);
		btncli(m.getCartformembership());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigated to cart page" );
		
		btncli(m.getProceedbutton());
		
		
		Thread.sleep(10000);
		//  (//div[@class='info'])[2] 
		if ((driver.findElements(By.xpath("(//div[contains(text(),'TAKE ACTION')])[2]")).size())!=0) {
			
		
			Thread.sleep(3000);
			WebElement takeAct = driver.findElement(By.xpath("(//div[contains(text(),'TAKE ACTION')])[2]//following::div[1]"));
			String acc = takeAct.getText();
			//System.out.println(acc);
			
			
			
			Thread.sleep(3000);
			if (acc.equalsIgnoreCase("Service to the selected pincode is temporarily unavailabe. We deeply regret the inconvenience")) {
				//we are unable to process the order at the moment. please try again later
				
				Thread.sleep(3000);
				//if (takeAct.isEnabled()) {
				logger.log(Status.PASS, "Take Action ! Service to the selected pincode is temporarily unavailabe. We deeply regret the inconvenience was displayed" );

					btncli(takeAct);
					Thread.sleep(3000);
					String Add = driver.findElement(By.xpath("//h4[contains(text(),'SELECT ADDRESS')]")).getText();
					System.out.println(Add);
					
					Thread.sleep(3000);
					btncli(driver.findElement(By.xpath("//div[@class='addressitem selected-item']")));
			
					
					Thread.sleep(3000);
					String Address = driver.findElement(By.xpath("//div[@class='adddetails ng-star-inserted']")).getText();
					System.out.println(Address);
					
					String[] split_add = Address.split(",");
					//System.out.println(split_add[1]);
					
					String[] split_add1 = split_add[2].split(", ");
					System.out.println(split_add1[0]);
					
					logger.log(Status.PASS, split_add1[0] );
					
					
					Thread.sleep(3000);
					Assert.assertTrue(false,"SELECT ADDRESS");  
					
						logger.log(Status.FAIL, "Take Action!, mail need to be Send to Alert" );
					
					
					
			} else {
				
			}	
				
		
			
			Thread.sleep(3000);
			
			
		} else {
			
			Thread.sleep(3000);
			btncli(m.getPaybutton());
			
			Thread.sleep(3000);
			String gettext = driver.findElement(By.xpath("//span[contains(text(),'Payment Details')]")).getText();
			System.out.println(gettext);
			Assert.assertEquals(gettext, "Payment Details");
			System.out.println("Pay Button is Displayed");
			Thread.sleep(3000);
			
			logger.log(Status.PASS, " Pay Button was  is Enabled  " );
			System.out.println("Pay Button Was Enabled");
			
		}
	
}
	
	@Test(enabled = true)
	public  void netmedsfirstcustomer() throws Throwable  {
		logger =  report.createTest("netmeds first customer");
		logger.log(Status.PASS, "*************netmedsfirstcustomer********************" );
		Monepom m=new Monepom();

		try {
		 driver.manage().window().maximize();
		 btncli(m.getSignin());
		  Thread.sleep(5000);
		  type(m.getMobileno(),"9677159095");
		  Thread.sleep(3000);
		  btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
		  Thread.sleep(3000);
		  type(m.getPassword(),"test4nmm"); 
		  btncli(m.getSignInpage());
		} catch (Exception e) {
			System.out.println("Already Logged In");
			driver.navigate().to("https://www.netmeds.com/");
		}
		
		//Netmeds First availability in MyAccount, Home Page and Cart Page.
		Thread.sleep(1500);
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");*/
		scrolldown("2900");
		SoftAssert SoftAssert=new SoftAssert();
		SoftAssert.assertEquals(gettext(m.getHome_getmostfrom()), "GET MOST FROM");
		
		SoftAssert.assertEquals(gettext(m.getGethome_netmedsfirst()), "Netmeds First");
		SoftAssert.assertEquals(gettext(m.getGethome_Getspecialdiscount()), "Get special discounts and offers on Netmeds services.");
		SoftAssert.assertEquals(gettext(m.getHome_savemore()), "Save more with Netmeds First membership");
		SoftAssert.assertEquals(gettext(m.getHome_getnms_cash()), "Get 2.5% NMS Cash on all orders.");
		SoftAssert.assertEquals(gettext(m.getHome_stating_price()), "Starting at Rs.299");
		SoftAssert.assertEquals(gettext(m.getHome_exploreplans()), "EXPLORE PLANS");
		SoftAssert.assertEquals(gettext(m.getHome_nmscash_section()), "2.5% NMS Cash");
		SoftAssert.assertEquals(gettext(m.getHome_allprepaid_orders()), "(Max 100) on all prepaid orders");
		SoftAssert.assertEquals(gettext(m.getHome_savemore()), "Save more with Netmeds First membership");
		SoftAssert.assertEquals(gettext(m.getHome_FreeDelivery()), "Free Delivery");
		SoftAssert.assertEquals(gettext(m.getHome_PriorityProcessing()), "Priority Processing");
		SoftAssert.assertEquals(gettext(m.getHome_BasicHealthCheckup()), "Basic Health Checkup");
		SoftAssert.assertEquals(gettext(m.getHome_only_with_12_month_plan()), "only with 12 month plan");
		SoftAssert.assertEquals(gettext(m.getHome_Additional_5_off_on_Pathology_Lab_Tests()), "Additional 5% off on Pathology Lab Tests");
		SoftAssert.assertEquals(gettext(m.getHome_Free_Unlimited_Consultation()), "Free Unlimited Consultation");
        btncli( m.getHome_exploreplans());
        SoftAssert.assertEquals(driver.getCurrentUrl(), "https://www.netmeds.com/customer/netmeds-first");
        
		logger.log(Status.PASS, "verfied home page netmeds first customer section" );
		driver.navigate().to("https://www.netmeds.com");

		SoftAssert.assertAll();
		
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
	
		
		//BaseClass.mail_report();
	}
	
	
	}	
		


	@AfterTest
	private void quitbrowser() {
		report.flush();
		
    //  driver.quit();
	}



}
