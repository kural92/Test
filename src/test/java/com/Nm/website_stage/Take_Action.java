package com.Nm.website_stage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.Nm.Website_live.RetryAnalyzer;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Take_Action extends BaseClass{
	
	
	
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//report//Take_Action.html");
       
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
	@Test(enabled = true,retryAnalyzer=RetryAnalyzer.class)
	public  void takeAction() throws Throwable  {
		logger =  report.createTest(" All Categories");
		logger.log(Status.PASS, "*************Take Action Fail Alert********************" );
		Monepom m=new Monepom();
		Robot r = new Robot();
		driver.manage().window().maximize();
		btncli(m.getSignin());
		Thread.sleep(5000);
		type(m.getMobileno(),"7010752043");
		Thread.sleep(3000);
		btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
		Thread.sleep(3000);
		type(m.getPassword(),"Change@92");
		btncli(m.getSignInpage());
		Thread.sleep(10000);
		logger.log(Status.PASS, "Successfully navigate to home page" );

		/////////////  Remove Product //
		
		Thread.sleep(3000);
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
		driver.navigate().to("https://www.netmeds.com/");
		
		//////////////////////////
		
		Thread.sleep(3000);
		for (int i = 1; i <5; i++) {
			Thread.sleep(5000);
		type(m.getSearch(), BaseClass.getExcelData("TakeAction", i, 0));
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//btncli(m.getSearchIcon());
		logger.log(Status.PASS, "Successfully Added  " +  BaseClass.getExcelData("TakeAction", i, 0));
		System.err.println("Successfully Added  " +  BaseClass.getExcelData("TakeAction", i, 0));
		String Cart_Excel = BaseClass.getExcelData("TakeAction", i, 1);
		try {
		Thread.sleep(3000);
		
		WebElement Cart_btn = driver.findElement(By.xpath("//div[contains(text(),'"+Cart_Excel+"')]//following::span[contains(text(),'ADD TO CART')]"));
		Thread.sleep(3000);
		btncli(Cart_btn);
		//btncli(m.getAddtocart());
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(3000);
		driver.navigate().back();
		
		Thread.sleep(3000);
		}
		
		
		
		btncli(m.getMinicart());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigated to cart page" );
		
		btncli(m.getProceedbutton());
		
	try {
		Thread.sleep(3000);
		btncli(driver.findElement(By.id("externaldoctr")));
		logger.log(Status.PASS, "Successfully navigated to Attach Prescription page" );
		logger.log(Status.PASS, "Successfully Selected the Schedule FREE doctor Consultation" );
		
		Thread.sleep(3000);
		btncli(driver.findElement(By.xpath("//button[contains(text(),'Review Order')]")));
	} catch (Exception e) {
		// TODO: handle exception
	}
		Thread.sleep(3000);
		
		logger.log(Status.PASS, "Successfully navigated to  order review page" );
	/*	
		Thread.sleep(3000);
		if (m.getPaybutton().isEnabled()) {
			Thread.sleep(3000);
			btncli(m.getPaybutton());
			Thread.sleep(3000);
		} else { }
*/
		
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

				//	boolean a = takeAct.isEnabled();
				//	System.out.println(a);
					//Assert.assertTrue(false,"We are unable to process the order at the moment. Please try again later"); - 
				 //Service to the selected pincode is temporarily unavailabe. We deeply regret the inconvenience
					
					
					
				// To check Clickable ( Otherwise Comment This )	
					btncli(takeAct);
					Thread.sleep(3000);
					String Add = driver.findElement(By.xpath("//h4[contains(text(),'SELECT ADDRESS')]")).getText();
					System.out.println(Add);
					
					Thread.sleep(3000);
					btncli(driver.findElement(By.xpath("//div[@class='addressitem selected-item']")));
			//		Assert.assertEquals(Add,"SELECT ADDRESS");
					
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
				
				
				
				
				/*
				 * Thread.sleep(3000); btncli(m.getPaybutton());
				 * 
				 * Thread.sleep(3000); String gettext = gettext(m.getPaybutton());
				 * System.out.println(gettext); Assert.assertEquals(gettext, "PAY");
				 * System.out.println("Pay Button is Displayed"); Thread.sleep(3000);
				 */
			
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
	/*	btncli(m.getPaybutton());
		Thread.sleep(3000);
		String gettext = gettext(m.getPaydeatailText());
		Assert.assertEquals(gettext, "Payment Details");
		logger.log(Status.PASS, "Successfully navigate to search payment Details page" );

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
		Thread.sleep(3000);
		for (int i = 0; i < 15; i++) {
			Thread.sleep(3000);
			try {
			btncli(m.getRemovebutton());
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		//btncli(m.getRemovebutton());
		logger.log(Status.PASS, "Successfully Removed the product " );
	*/	
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
		
      driver.quit();
	}

}



