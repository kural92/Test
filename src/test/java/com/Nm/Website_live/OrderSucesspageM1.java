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

public class OrderSucesspageM1 extends BaseClass {


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
	@Test(enabled = true)
	public  void OrderSucessPageM1() throws Throwable  {
		logger =  report.createTest(" OrderSucessPageM1");
		logger.log(Status.PASS, "*************OrderSucessPageM1********************" );
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
			Thread.sleep(3000);
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
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
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
		driver.navigate().to("https://www.netmeds.com");

		Thread.sleep(3000);
		
//Adding Product to the cart//
		
			
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Patanjali Lauh Bhasm Powder 5 gm");
		
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
		
		

			Thread.sleep(3000);
			
			System.out.println("Items are added to the cart");
		
			WebElement Cart_btn = driver.findElement(By.id("product-addtocart-button"));
			Thread.sleep(3000);
			btncli(Cart_btn);
//Click mini cart//
		
		btncli(m.getMinicart());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigated to cart page");
		System.out.println("Successfully navigated to cart page");

// handle Lets chat button
		try {
			driver.switchTo().frame("haptik-xdk");
			Actions acc = new Actions(driver);
			acc.moveToElement(driver.findElement(By.xpath("//div[@class='bot-prompt-minimal-textarea']//span"))).build()
					.perform();
			driver.findElement(By.xpath("(/html/body/div/div[1]/div[1])[1]")).click();
			driver.switchTo().defaultContent();
		} catch (Exception e) {

		}

		Thread.sleep(5000);
		btncli(m.getProceedbutton());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to search order review page" );
		btncli(m.getPaybutton());
		Thread.sleep(3000);
		String gettext = gettext(m.getPaydeatailText());
		Assert.assertEquals(gettext, "Payment Details");
		logger.log(Status.PASS, "Successfully navigate to search payment Details page" );
		Thread.sleep(3000);
		scrolldown("700");
		Thread.sleep(3000);
		scrolldown("700");
		if (!(driver.findElement(By.id("nms_cod")).isSelected())) {
			Thread.sleep(3000);
			btncli(driver.findElement(By.id("nms_cod")));
			logger.log(Status.PASS, "Successfully Clicked on Cash on Delivery");
			
			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("(//div[@id='title_COD']//button[contains(text(),'Pay Rs')])")));
			
			Thread.sleep(8000);
		
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
		
		String Original_Order_status = "PROCESSING";
		
		Assert.assertEquals(Actual_orderstatus,Original_Order_status );
		
		System.out.println("order status is  "+ Actual_orderstatus);
		
		logger.log(Status.PASS, "order status is  "+ Actual_orderstatus);
		Thread.sleep(3000);
		
		
		//Pharmacists Verification//
		
		String Actual_pharmacists_verfication = m.getPharmacists_verfication().getAttribute("innerText");
			
		
		String Original__pharmacists_verfication ="Your order is being processed by our team";
	
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
			
			SoftAssert  SoftAssert = new SoftAssert();
			
			/*SoftAssert.assertEquals(gettext(m.getGrab_text()),"GRAB YOUR");
			
			System.out.println(m.getGrab_text().getText());
			
			SoftAssert.assertEquals(gettext(m.getFree_medicines()),"Free Medicines");
			
			System.out.println(m.getFree_medicines().getText());
			
			SoftAssert.assertEquals(gettext(m.getInvite_friends()),"Invite your friends and get");
			
			System.out.println(m.getInvite_friends().getText());
			
			SoftAssert.assertEquals(gettext(m.getOffer_code()),"TEST1932");
			
			System.out.println(m.getOffer_code().getText());
			
			SoftAssert.assertEquals(gettext(m.getShare_with_friends()),"Tap to share Code with your friends");
			
			System.out.println(m.getShare_with_friends().getText());*/
			
			SoftAssert.assertEquals(gettext(m.getBenefits()),"Benefits");
			
			System.out.println(m.getBenefits().getText());
			
			SoftAssert.assertEquals(gettext(m.getAuto_monthly_order()),"Automatic monthly order");
			
			System.out.println(m.getAuto_monthly_order().getText());
			
			//SoftAssert.assertEquals(gettext(m.getMonthfree()),"1 month FREE*");
			
			//System.out.println(m.getMonthfree().getText());
			
			
			SoftAssert.assertAll();
			
			
			WebElement rateexp = m.getRate_your_exp();// driver.findElement(By.xpath("//div[.=\"RATE YOUR EXPERIENCE\"]"));
			
			System.out.println(rateexp.getAttribute("innerText"));
			
			Thread.sleep(3000);
			

			WebElement Deliveryby = m.getDeliverby_text(); //driver.findElement(By.xpath("//div[@class=\"deltitle\"]"));
		
			System.out.println(Deliveryby.getAttribute("innerText"));
			
			
			Thread.sleep(3000);
			
			//m.getShare_with_friends().click();
			
			//Thread.sleep(3000);
			
			//driver.findElement(By.xpath("(//button[@class='close pull-right'])[2]")).click();
			
			//Thread.sleep(3000);
			
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
			
			driver.findElement(By.xpath("(//img[@src=\"../../../msassets/images/subscribe-order-success.jpg\"])[2]")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("(//button[@class=\"close\"])[1]")).click();
			
			Thread.sleep(3000);
		
			btncli(m.getSubscription());
			
			
			
			SoftAssert.assertEquals(gettext(m.getNever_miss_your_Medicines()),"Never miss your Medicines");
			
			System.out.println(m.getNever_miss_your_Medicines().getText());
			
			SoftAssert.assertEquals(gettext(m.getPaymentmode_text()),"Payment Mode");
			
			System.out.println(m.getPaymentmode_text().getText());
			
			SoftAssert.assertEquals(gettext(m.getPaymentmethod_text()),"Online Payment / COD");
			
			System.out.println(m.getPaymentmethod_text().getText());
			
			SoftAssert.assertEquals(m.getPaymentlink_text().getAttribute("innerText"),"Payment link will be generated every month.");
			
			System.out.println(m.getPaymentlink_text().getAttribute("innerText"));
			
			
			SoftAssert.assertEquals(gettext(m.getPromocode_subs20()),"SUBS20");
			
			System.out.println(m.getPromocode_subs20().getText());
			
			SoftAssert.assertEquals(m.getPromo_percentage().getAttribute("innerText"),"20% Off Applied to all order plus last month free medicine");
			
			System.out.println(m.getPromo_percentage().getAttribute("innerText"));
			
			SoftAssert.assertEquals(m.getModify_or_reschedule().getAttribute("innerText"),"You can modify or reschedule the subsequent orders later.");
			
			System.out.println(m.getModify_or_reschedule().getAttribute("innerText"));
			
			SoftAssert.assertTrue(gettext(m.getRefill_msg()).contains("Get medicine refill’s delivered on the set duration of every month."));
			
			System.out.println(m.getRefill_msg().getText());
			
			WebElement days =	driver.findElement(By.xpath("//div[@class=\"mat-select-arrow-wrapper\"]"));
		
			days.click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//span[.=\"45 days\"]")).click();
			
			Thread.sleep(4000);
				
			WebElement Subs = driver.findElement(By.xpath("//button[@title=\"process\"]"));
			
			System.out.println(Subs.getText());
			
			Subs.click();
			Thread.sleep(3000);
			
			WebElement		Enabled_subscription =	driver.findElement(By.xpath("//p[.=\"Subscription enabled\"]"));
			
			System.out.println(Enabled_subscription .getText());
			
			Thread.sleep(3000);
			
			btncli(m.getTrack_Order());
			Thread.sleep(6000);
			
			
			btncli(m.getView_Details());
			Thread.sleep(3000);
			
			
			btncli(m.getCancel_Order());
			Thread.sleep(3000);
			btncli(m.getCancelyes());
			Thread.sleep(3000);

			Thread.sleep(3000);
			btncli(m.getCancel_reason1());
			Thread.sleep(3000);
			btncli(m.getSubmit_Cancel());
			Thread.sleep(3000);
			
			 logger.log(Status.PASS, "Successfully Order was Cancelled" );
			 
			 System.out.println("M1-order Success Page is working Properly");
			 
}
	
	}
		//**************************************************Order Success Page M2****************************************************************************************
		
	
		
		
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
