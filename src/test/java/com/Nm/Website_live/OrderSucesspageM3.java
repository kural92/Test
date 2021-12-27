   package com.Nm.Website_live;


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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.Nm.Website_live.RetryAnalyzer;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//********Extend Report**********//
public class OrderSucesspageM3 extends BaseClass {

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
		

		//*******************************************************************OrderSucessPageM3******************************************************************//
		@Test(enabled = true)
		public void OrderSucessPageM3() throws Throwable {

			logger = report.createTest(" Order Sucess Page M3");
			logger.log(Status.PASS, "*************Order Sucess Page M3********************");

			// Step1 :Launch Browser//
			Monepom m = new Monepom();

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
			// Step 3 : Navigate to user profile//
			driver.navigate().to("https://www.netmeds.com");
			Thread.sleep(3000);
			btncli(m.getUserprofile());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to userprofile");

			
			// Step 4 : Navigate to Mysubscription page//

			btncli(m.getMysubscriptionpage());
			Thread.sleep(5000);
			logger.log(Status.PASS, "Successfully navigate to mysubscriptionpage");

			// Step 5 :Click create new fill button//

			btncli(m.getCreatenewfill());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully button was clicked");
			
			try {
				driver.switchTo().frame("haptik-xdk");
				Actions acc = new Actions(driver);
				acc.moveToElement(driver.findElement(By.xpath("//div[@class='bot-prompt-minimal-textarea']//span"))).build()
						.perform();

				driver.findElement(By.xpath("(/html/body/div/div[1]/div[1])[1]")).click();

				driver.switchTo().defaultContent();

			} catch (Exception e) {

			}

			// Step 6:Search Product//

			for (int i = 0; i < 2; i++) {
				//Thread.sleep(5000);
				//btncli(m.getM3productsearch());
				
				
				//Thread.sleep(1500);
				type(m.getM3productsearch(), BaseClass.getExcelData("Rx", i, 0));

				//btncli(m.getSearchIcon());
				logger.log(Status.PASS, "Successfully navigate to search result page");

				String Cart_Excel = BaseClass.getExcelData("Rx", i, 1);

				// Step 7 : Add product to the cart//
				try {
					Thread.sleep(3000);

					WebDriverWait wait = new WebDriverWait(driver, 30);
					WebElement Cart_btn = wait.until(
							ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),\"Add to Cart\")]")));

					Thread.sleep(3000);

					btncli(Cart_btn);

				} catch (Exception e) {
					// TODO: handle exception
				}

				Thread.sleep(3000);
				driver.navigate().back();

				Thread.sleep(3000);
			}

			// Step 8 : Click view Cart//
driver.findElement(By.xpath("//div[text()=' Add to Cart ']")).click();
Thread.sleep(3000);
			btncli(m.getViewcart());
			Thread.sleep(2000);
			logger.log(Status.PASS, "Successfully navigate to cartpage");

			// Step 09 : Click Proceed Button//

			btncli(m.getProceed());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully Proceed button  was clicked");
			Thread.sleep(6000);

			// Step 10: Add RXprescription//

			WebElement upload = driver.findElement(By.xpath("//input[@accept='image/png,image/gif,image/jpeg']"));

			upload.sendKeys(System.getProperty("user.dir")+"//Prescription//M3Subscription.png");
			Thread.sleep(5000);
			logger.log(Status.PASS, "Prescription added successfully");

			// Step 11 : select duration//
			
			
			btncli(m.getSelectDuration());
			Thread.sleep(3000);
			btncli(m.getSelectduration60());
			Thread.sleep(2000);
			logger.log(Status.PASS, "Duration has been selected successfully");

			// Step 12 : Click Next Button//

			btncli(m.getNextbutton());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully Next button was clicked");

			// Step 13 : Click Subscribe//

			btncli(m.getSubscribe());
			logger.log(Status.PASS, "Successfully Subscribe button was clicked");
			Thread.sleep(3000);

			// Step 14 : Ensure order is placed successfully//

			String confirmation = m.getOrder_Placed_text().getText();

			
			String orderid = m.getOrderid().getAttribute("innerText");

			String orderconfirmation = "Order Placed Successfully!";

			Assert.assertEquals(orderconfirmation, confirmation);

			System.out.println(confirmation + "and the id is " + orderid);
			
			logger.log(Status.PASS, confirmation + "and the id is " + orderid);

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
					
			//Pharmacists Verification//
			
				WebElement important_update = m.getImportant_update();//driver.findElement(By.xpath("//div[@class=\"ng-star-inserted\"]"));
					
					System.out.println(important_update.getAttribute("innerText"));
					Thread.sleep(3000);
			
			//Step 15 :Rate your experience//
			
					
				WebElement delivery_btwn =m.getDelivery_date(); //driver.findElement(By.xpath("//div[@class=\"deldate\"]"));
				
				System.out.println("delivery date is between  "+delivery_btwn.getAttribute("innerText"));	
				
				Thread.sleep(3000);
				
				/*SoftAssert  SoftAssert = new SoftAssert();
				
				SoftAssert.assertEquals(gettext(m.getGrab_text()),"GRAB YOUR");
				
				System.out.println(m.getGrab_text().getText());
				
				SoftAssert.assertEquals(gettext(m.getFree_medicines()),"Free Medicines");
				
				System.out.println(m.getFree_medicines().getText());
				
				SoftAssert.assertEquals(gettext(m.getInvite_friends()),"Invite your friends and get");
				
				System.out.println(m.getInvite_friends().getText());
				
				SoftAssert.assertEquals(gettext(m.getOffer_code()),"TEST1932");
				
				System.out.println(m.getOffer_code().getText());
				
				SoftAssert.assertEquals(gettext(m.getShare_with_friends()),"Tap to share Code with your friends");
				
				System.out.println(m.getShare_with_friends().getText());
				
				SoftAssert.assertAll();*/
				
				WebElement rateexp = m.getRate_your_exp();// driver.findElement(By.xpath("//div[.=\"RATE YOUR EXPERIENCE\"]"));
				
				System.out.println(rateexp.getAttribute("innerText"));
				
				Thread.sleep(3000);
				

				WebElement Deliveryby = m.getDeliverby_text(); //driver.findElement(By.xpath("//div[@class=\"deltitle\"]"));
			
				System.out.println(Deliveryby.getAttribute("innerText"));
				
				
				Thread.sleep(3000);
			
				
				/*WebElement grab = m.getGrab_text(); //driver.findElement(By.xpath("//h5[.=\"GRAB YOUR\"]")).getText();
				
				System.out.println(grab.getText());
				
				
				WebElement free_mdeicines = m.getFree_medicines();//driver.findElement(By.xpath("//h3[.=\"Free Medicines\"]")).getText();
				
				System.out.println(free_mdeicines.getText());
				
				Thread.sleep(3000);
				
				WebElement invite_text =m.getInvite_friends();// driver.findElement(By.xpath("//p[.=\"Invite your friends and get\"]")).getText();
				
				System.out.println(invite_text.getText());
				
				WebElement offer_code = m.getOffer_code();//driver.findElement(By.xpath("//div[.=\"TEST1932\"]")).getText();
				
				System.out.println(offer_code.getText());
			
				WebElement share = 	m.getShare_with_friends();//driver.findElement(By.xpath("//a[.=\"Tap to share Code with your friends\"]"));
				
				System.out.println(share.getText());*/
				
				/*m.getShare_with_friends().click();
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("(//button[@class='close pull-right'])[2]")).click();
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//div[@class=\"rating cursor-pointer d-none d-sm-block ng-star-inserted\"]")).click();
				
				//List <WebElement> Star = driver.findElements(By.xpath("//input[@name=\"star\"]"));*/
				
				/*int star_rating = Star.size();
				System.out.println(star_rating);
				
				for (int i=0; i<star_rating; i++) {
					Thread.sleep(3000);
					Star.get(i).click();
					
				}*/
				
				
				driver.findElement(By.xpath("//div[@class=\"rating cursor-pointer d-none d-sm-block ng-star-inserted\"]")).click();
				Thread.sleep(3000);
				btncli(m.getStar1());
				Thread.sleep(2000);
				btncli(m.getStar2());
				Thread.sleep(2000);
				btncli(m.getStar3());
				Thread.sleep(2000);
				btncli(m.getStar4());
				Thread.sleep(2000);
				btncli(m.getStar5());
				Thread.sleep(3000);
				btncli(m.getStar4());
				Thread.sleep(2000);
				btncli(m.getStar3());
				Thread.sleep(2000);
				btncli(m.getStar2());
				Thread.sleep(3000);
				btncli(m.getStar1());
				Thread.sleep(3000);
				
				
				driver.findElement(By.xpath("//button[.=\"SUBMIT FEEDBACK\"]")).click();
				
				logger.log(Status.PASS, "Rating was given and Submitted");
				
				System.out.println("Rating was given and Submitted");
				
				Thread.sleep(3000);
				//driver.findElement(By.xpath("(//button[@class='close'])[2]")).click();
				
	//Tracking order//

					btncli(m.getMysubscription());

					Thread.sleep(3000);

					btncli(m.getMedicineorders());
					Thread.sleep(3000);

					btncli(m.getView_Details());
					Thread.sleep(3000);

					btncli(m.getCancel_Order());
					Thread.sleep(3000);

					btncli(m.getCancelyes());
					Thread.sleep(3000);

					driver.findElement(By.xpath("(//input[@class=\"ng-untouched ng-pristine ng-valid\"])[3]")).click();
					Thread.sleep(3000);
					
					btncli(m.getSubmit_Cancel());

					logger.log(Status.PASS, "Successfully Order was Cancelled");
							
					System.out.println("Successfully Order was Cancelled");
					
					System.out.println("M3-order Success Page is working Properly");


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
			// BaseClass.mail_report();
		}

	}

//@AfterTest
	//private void quitbrowser() {
		//report.flush();

		// driver.quit();
	}


