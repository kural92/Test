package com.Nm.Website;


import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

//********Extend Report**********//
public class Linkedaccounts extends BaseClass {

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
	 Test Case 1 : Verify the Payment Method page when there is no Card or wallet is Linked
	 			   Also,Verified user is able to link wallet.(Till clicking Link )
	 			   
	 Test case 2 : Verify the Payment Method page when the Card and  wallet is Linked
	 */
		
//*******************************************************************Payment Method Test Case 1 ******************************************************************//
	@Test(enabled = true) 
	public void LinkedAccountsScenario1() throws Throwable {

		logger = report.createTest(" Linked Accounts Scenario1");
		logger.log(Status.PASS, "*************Linked Accounts Scenario1********************");

// Step1 :Launch Browser//
		Monepom m = new Monepom();
		driver.manage().window().maximize();

		

			try {

				btncli(m.getSignin());
				Thread.sleep(5000);
				type(m.getMobileno(), "8072281468");
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

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
			
		
// Step 4:
			
		
			btncli(m.getPayment_method());
			Thread.sleep(3000);
			//driver.findElement(By.xpath("(//input[@class=\"offer-checkbox\"])[1]")).click();
			
			logger.log(Status.PASS, "Successfully navigate to payment methods");
// Card details check//
			
			SoftAssert SoftAssert = new SoftAssert();
			
			SoftAssert.assertEquals(gettext(m.getSaved_card_text()), "SAVED CARDS");
			
			System.out.println(m.getSaved_card_text().getText());
			
			SoftAssert.assertEquals(m.getCard_details_text().getAttribute("innerText"), "No Card details saved by you.");
			
			System.out.println(m.getCard_details_text().getAttribute("innerText"));
			
			SoftAssert.assertEquals(gettext(m.getLinked_wallets_details_text()), "LINKED WALLETS");
			
			System.out.println(m.getLinked_wallets_details_text().getText());
			
			SoftAssert.assertEquals(m.getLinked_wallet_text().getAttribute("innerText"), "No wallets linked by you.");
			
			System.out.println(m.getLinked_wallet_text().getAttribute("innerText"));
			
			SoftAssert.assertAll();
		
		Thread.sleep(3000);
		
		btncli(m.getNetmedshome());
		
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
		driver.navigate().to("https://www.netmeds.com/");

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

		System.out.println("Successfully closed let's chat");
//proceed button//		
		btncli(m.getProceedbutton());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to search order review page" );
		Thread.sleep(4000);
		
//get Pay button//
		
		btncli(m.getPaybutton());
		Thread.sleep(3000);

//Payment methods page//		
		String gettext = gettext(m.getPaydeatailText());
		Assert.assertEquals(gettext, "Payment Details");
		logger.log(Status.PASS, "Successfully navigate to search payment Details page" );
		
		List <WebElement> Links = m.getLinks();//driver.findElements(By.xpath("//span[@class=\"link ng-star-inserted\"]"));
		
		int total_links = Links.size();
		
		System.out.println("The element size is  "+total_links);
		
		for (int i=0;i<total_links;i++) {
			
			Thread.sleep(3000);
			Links.get(i).isEnabled();
			System.out.println("Link button is enabled ");
			Thread.sleep(3000);
			Links.get(i).click();
			System.out.println("Successfully opened the link");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//app-payment-info[@class=\"ng-star-inserted\"]")).click();
			System.out.println("Successfully closed the link");
			
			
		}
		
		btncli(m.getNetmedshome());
		Thread.sleep(3000);
		btncli(m.getUserprofile());
		Thread.sleep(3000);
		btncli(m.getLogout());
		Thread.sleep(3000);
		btncli(m.getNetmedshome());
		
		System.out.println("Payment test case 1 has been completed successfully");
	}
	
		 
//***********************************Payment Method Test Case 2************************************
		@Test(enabled = true)
		public void LinkedAccountsScenario2() throws Throwable {

			logger = report.createTest(" Linked AccountsScenario 2");
			logger.log(Status.PASS, "*************Linked Accounts Scenario 2********************");

	// Step1 :Launch Browser//
			Monepom m = new Monepom();
			driver.manage().window().maximize();

			
				try {

					btncli(m.getSignin());
					Thread.sleep(5000);
					type(m.getMobileno(), "9677159095");
					Thread.sleep(3000);
					btncli(m.getUsepwdbtn());
					Thread.sleep(3000);
					type(m.getPassword(), "test4nm");
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

			btncli(m.getUserprofile());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to userprofile");
				
			
	// Step 4:
				
			
				//driver.findElement(By.xpath("//a[@class=\"payment-link\"]")).click();
				//Thread.sleep(3000);	
				
				btncli(m.getPayment_method());
				Thread.sleep(3000);
				
				WebElement saved_card =	m.getSaved_card();//driver.findElement(By.xpath("//ul[@class=\"savedcards ng-star-inserted\"]"));
	
				System.out.println("Card Details are as follows  "+saved_card.getText());
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//button[@class=\"delete-card\"]")).isDisplayed();
				
				System.out.println("Yes Delete button is available");
				
				SoftAssert SoftAssert = new SoftAssert();
				
				SoftAssert.assertEquals(gettext(m.getLinked_wallets_details_text()), "LINKED WALLETS");
				
				System.out.println(m.getLinked_wallets_details_text().getText());
				
				List<WebElement> Linked_wallets = m.getLinked_wallets();//driver.findElements(By.xpath("//div[@class=\"linkedlist ng-star-inserted\"]"));
				
				int wallets = Linked_wallets.size();
				
				System.out.println("The element size is  "+wallets);
				
				for (int i=0; i<wallets; i++) {
					
					
					System.out.println("Wallet name  as follows  ");
					Thread.sleep(3000);
										
				
					System.out.println(Linked_wallets.get(i).getText());
					Thread.sleep(3000);
					
					driver.findElement(By.xpath("//a[@class=\"delete-wallet delink_wallet\"]")).isDisplayed();
					
					System.out.println("Yes Delete button is available");
					
					System.out.println("Payment test case 2 has been completed successfully");
					
				}
				
		
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
				BaseClass.mail_report();
			}

		}	

		//@AfterTest
		//private void quitbrowser() {
		//report.flush();
		//	driver.quit();
			
	}			
		