package com.Nm.website_stage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
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

public class OrederSucesspageM2 extends BaseClass {


	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//Report//sample.html");

		// initialize ExtentReports and attach the HtmlReporter
		report = new ExtentReports();

		// htmlReporter.setAppendExisting(false); 
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Host name", "localhost");
		report.setSystemInfo("Environemnt", "QA");
		report.setSystemInfo("user", "Automation Team");

		// configuration items to change the look and feel
		// add content, manage tests etc

		htmlReporter.config().setDocumentTitle("Extent Report ");
		htmlReporter.config().setReportName("Test Report");

		// htmlReporter.config().setTheme(Theme.STANDARD);

	}

	/*
	 Test case 1 :Verify Order success page for M1 Flow(Assert all the text in the order sucess page).
	 			Also, Validated 
	 				1.Subscription functionality	 			
	 				2.Feedback Functionality
	 				3.track and Cancel the order
	 				
	 Test case 2 :Verify Order success page for M2 Flow(Assert all the text in the order sucess page) and cancel the order.
	 
	  Test case 3 :Verify Order success page for M3 Flow(Assert all the text in the order sucess page).
	 			Also, Validated 
	 					 			
	 				1.Feedback Functionality
	 				2.Cancel the order
	 */
		
//*******************************************************************Order Sucess Page M1******************************************************************//
	//**************************************************Order Success Page M2****************************************************************************************
		
		
		@Test(enabled = true)
		public  void OrderSuccessPageM2() throws Throwable  {
			logger =  report.createTest("OrderSuccessPageM2");
			logger.log(Status.PASS, "************* OrderSuccessPageM2********************" );
			Monepom m=new Monepom();
			
		
			try {

				// Step 2 :Login with user name and password//
				btncli(m.getSignin());
				Thread.sleep(5000);
				type(m.getMobileno(), "7200016627");
				Thread.sleep(3000);
				btncli(m.getUsepwdbtn());
				Thread.sleep(3000);
				type(m.getPassword(), "test@123");
				btncli(m.getSignInpage());
				Thread.sleep(3000);
				logger.log(Status.PASS, "Successfully navigate to home page");
			} catch (Exception e) {
				System.out.println("Already Logged In");
			}

			try {
				btncli(m.getNetmedshome());
			} catch (Exception e) {

			}
			
			Thread.sleep(3000);
			driver.navigate().to("https://s1-meds.netmeds.com/checkout/cart");
			Thread.sleep(3000);
			for (int i = 0; i < 16; i++) {
				Thread.sleep(3000);
				if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size() == 0)) {

					try {
						btncli(m.getRemovebutton());
						Thread.sleep(3000);
						driver.findElement(By.xpath("//span[@class=\"arricon downarrow\"]")).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath("//button[.=\"Remove\"]")).click();
					} catch (Exception e) {
						System.out.println("Items are removed from the cart");
					}

				} else {
					break;

				}

			}

			Thread.sleep(3000);
			driver.navigate().to("https://s1-meds.netmeds.com/");

			Thread.sleep(3000);
			btncli(m.getUpload_cta());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigated to Add Prescription page" );
			/*
			type(mm.getUpload_Rx(), "C:\\Users\\NMSLAP356\\Desktop\\Screen-Net\\M2 Pay");
			Thread.sleep(3000);
			*/
			WebElement upload = driver.findElement(By.xpath("//input[@accept='image/png,image/gif,image/jpeg']"));

			upload.sendKeys(System.getProperty("user.dir")+"//Prescription//M3Subscription.png");
			Thread.sleep(3000);
			logger.log(Status.PASS, "Prescription added successfully");
			
			
		
			
			
	//Search Medicines
			
			
			
			if (!(m.getSearch_Medicines().isSelected())) {
				
				btncli(m.getSearch_Medicines());
				 Thread.sleep(3000);
			} else {
				
				
			}
			logger.log(Status.PASS, "Successfully Clicked on Search Medicines" );
			 
				btncli(m.getContinue_cta());
				Thread.sleep(5000);
				
				logger.log(Status.PASS, "Successfully navigated to Search Medicine Page" );
			 
			 btncli(driver.findElement(By.xpath("(//input[@type='text'])[3]")));
			 Thread.sleep(3000);
			 
			 type(driver.findElement(By.xpath("(//input[@type='text'])[3]")), "Gemer");
			 Thread.sleep(6000);
			 
			 btncli(driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")));
			 Thread.sleep(3000);
			 
			 logger.log(Status.PASS, "Successfully Product was searched and added to the cart" );
			 
			 btncli(driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")));
			 Thread.sleep(10000);
			
		////////////////////////////// Promo code Check
			 Thread.sleep(3000);
			 String Pcode = m.getM2_CoupCode_text().getText();
			 System.out.println(Pcode); 	
			
			 
			btncli(m.getConfirm_Order_cta());
			Thread.sleep(6000);
			
			 logger.log(Status.PASS, "Successfully Placed the Order" );
			
			// Step 14 : Ensure order is placed successfully//

				String confirmation = m.getOrder_Placed_text().getText();


				String orderconfirmation = "Order Placed Successfully!";

				Assert.assertEquals(orderconfirmation, confirmation);

				System.out.println(confirmation );
				
				logger.log(Status.PASS, confirmation );

				Thread.sleep(3000);
				
				//Step 14 : Order status//

				String Actual_orderstatus = m.getOrder_status().getAttribute("innerText");
				
				String Original_Order_status = "Prescription Under Review";
				
				Assert.assertEquals(Actual_orderstatus,Original_Order_status );
				
				System.out.println("order status is  "+ Actual_orderstatus);
				
				logger.log(Status.PASS, "order status is  "+ Actual_orderstatus);
				Thread.sleep(3000);
				
				
				//Pharmacists Verification//
				
				String Actual_pharmacists_verfication = m.getPharmacists_verfication().getAttribute("innerText");
					
				
				String Original__pharmacists_verfication ="Our pharmacists are verifying your prescription(s).";
				
				Assert.assertTrue(Actual_pharmacists_verfication.contains(Original__pharmacists_verfication));
				
				System.out.println(Actual_pharmacists_verfication);
				
				logger.log(Status.PASS, Actual_pharmacists_verfication);
						
				Thread.sleep(3000);
						
		//Asserting texts in the order success page//
				
					SoftAssert  SoftAssert = new SoftAssert();
					
					SoftAssert.assertEquals(gettext(m.getGrab_text()),"GRAB YOUR");
					
					System.out.println(m.getGrab_text().getText());
					
					SoftAssert.assertEquals(gettext(m.getFree_medicines()),"Free Medicines");
					
					System.out.println(m.getFree_medicines().getText());
					
					SoftAssert.assertEquals(gettext(m.getInvite_friends()),"Invite your friends and get");
					
					System.out.println(m.getInvite_friends().getText());
					
				//	SoftAssert.assertEquals(gettext(m.getOffer_code()),"TEST1932");
					
					//System.out.println(m.getOffer_code().getText());
					
					SoftAssert.assertEquals(gettext(m.getShare_with_friends()),"Tap to share Code with your friends");
					
					System.out.println(m.getShare_with_friends().getText());
					
					SoftAssert.assertAll();
					
					Thread.sleep(3000);
					
	//share with Friends//
					m.getShare_with_friends().click();
					
					Thread.sleep(3000);
					
					driver.findElement(By.xpath("(//button[@class='close pull-right'])[2]")).click();
					
					Thread.sleep(3000);
					
		//Track Order//		
				
					btncli(m.getTrack_Order());
					Thread.sleep(10000);
					
					
					btncli(m.getView_Details());
					Thread.sleep(6000);
					
					
					btncli(m.getCancel_Order());
					Thread.sleep(3000);
					btncli(m.getCancel_reason());
					Thread.sleep(3000);
					btncli(m.getSubmit_Cancel());
					Thread.sleep(3000);
					logger.log(Status.PASS, "Successfully Order was Cancelled" );
					
					System.out.println("Successfully Order was Cancelled");
					
					System.out.println("M2-order Success Page is working Properly");	
		
	}	
	
		//*******************************************************************OrderSucessPageM3******************************************************************//
		
		
		
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
			// BaseClass.mail_report();
		}

	}

//@AfterTest
	//private void quitbrowser() {
		//report.flush();

		// driver.quit();
	
}
