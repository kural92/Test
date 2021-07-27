package com.Nm.Website;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Predicate;

//********Extend Report**********//
public class M3_Subscription extends BaseClass {

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

//*******************************************************M3 Non Rx & OTC flow**********************************************************************//
	@Test(enabled = true)
	public void M3OTCandnonrxSubscription() throws Throwable {

		logger = report.createTest("M3OTCandnonrxSubscription");
		logger.log(Status.PASS, "*************M3OTCandnonrxSubscription********************");

		// Step1 :Launch Browser//
		Monepom m = new Monepom();
		driver.manage().window().maximize();

		try {

			// Step 2 :Login with user name and password//
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
		System.out.println("Successfully navigate to userprofile");
		
		

		// Step 4 : Navigate to Mysubscription page//

		btncli(m.getMysubscriptionpage());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to mysubscriptionpage");
		System.out.println("Successfully navigate to mysubscriptionpage");
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

		for (int i = 0; i < 4; i++) {

			type(m.getM3productsearch(), BaseClass.getExcelData("Otcandnonrx", i, 0));

			// btncli(m.getSearchIcon());
			logger.log(Status.PASS, "Successfully navigate to search result page");

			String Cart_Excel = BaseClass.getExcelData("Otcandnonrx", i, 1);

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

		btncli(m.getViewcart());
		Thread.sleep(2000);
		logger.log(Status.PASS, "Successfully navigate to cartpage");

		// Step 9 :Increase qty//

		Select qtyincrease = new Select(m.getQty_Incr_Decr());
		qtyincrease.selectByIndex(3);
		Thread.sleep(3000);
		
		logger.log(Status.PASS, " quantity increased Successfully");
		System.out.println(" quantity increased Successfully");

		// Step 10 :Remove qty//
		btncli(m.getRemoveitem());
		Thread.sleep(3000);
		logger.log(Status.PASS, " item removed Successfully");
		System.out.println(" item removed Successfully");
		
		// Step 11: Decrease qty//

		Select qtydecrease = new Select(m.getQty_Incr_Decr());
		qtydecrease.selectByIndex(1);
		Thread.sleep(3000);
		
		logger.log(Status.PASS, " quantity decreased Successfully");
		System.out.println(" quantity decareased Successfully");

		// Step 12:Promo Code Check//

		String Promocode = m.getSubs20_promo().getText();
		String actualpromocode = "SUBS20";
		Assert.assertEquals(Promocode, actualpromocode);
		System.out.println(Promocode);
		Thread.sleep(3000);

		// Step 13 : Click Proceed Button//

		btncli(m.getProceed());
		Thread.sleep(3000);
		btncli(m.getSelectduration45());
		Thread.sleep(3000);
		btncli(m.getSelectduration30());
		Thread.sleep(3000);
		btncli(m.getSelectduration60());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully Proceed button  was clicked");

		// Step 14 : Click Next Button//

		btncli(m.getNextbutton());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully Next button was clicked");

		// Step 15: Click Subscribe//

		btncli(m.getSubscribe());
		logger.log(Status.PASS, "Successfully Subscribe button was clicked");
		Thread.sleep(3000);

		// Step 16 : Ensure order is placed successfully//

		String confirmation = m.getOrder_Placed_text().getText();

		String orderid = m.getOrderid().getAttribute("innerText");

		String orderconfirmation = "Order Placed Successfully!";

		Assert.assertEquals(orderconfirmation, confirmation);

		System.out.println(confirmation + "and the id is " + orderid);

		// Tracking order//

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

	}

	// *********************************************M3 -Doctor consultation
	// **********************************************************************************************//
	
	@Test(enabled = true)
	public void M3Doctorconsultation() throws Throwable {

		logger = report.createTest("M3Doctorconsultation");
		logger.log(Status.PASS, "*************M3Doctorconsultation********************");

		Monepom m = new Monepom();
		driver.manage().window().maximize();

		// Step1 :Launch Browser//

		try {

			// Step 2 :Login with user name and password//
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

		// Step 4 : Navigate to Mysubscription page//

		btncli(m.getMysubscriptionpage());
		Thread.sleep(3000);
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

			type(m.getM3productsearch(), BaseClass.getExcelData("Rx", i, 0));

			// btncli(m.getSearchIcon());
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

		btncli(m.getViewcart());
		Thread.sleep(2000);
		logger.log(Status.PASS, "Successfully navigate to cartpage");

		// Step 09 : Click Proceed Button//

		btncli(m.getProceed());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully Proceed button  was clicked");
		Thread.sleep(3000);
		// Step 10: Doctor Consultation//

		btncli(m.getConsultdoctorcheck());

		logger.log(Status.PASS, "Doctor Consultation is sucessfully schedulded");
		
		

		// Step 11 : select duration//
		btncli(m.getSelectDuration());
		btncli(m.getSelectduration45());
		Thread.sleep(2000);
		logger.log(Status.PASS, "Sucessfully duration selected");
		// Step 12 : Click Next Button//

		btncli(m.getNextbutton());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully Next button was clicked");

		// Step 13 :Doctor confirmation Message//

		String doctorconfirmation = driver
				.findElement(By.xpath("//div[@class =\"info\"]")).getText();

		System.out.println(doctorconfirmation);

		Thread.sleep(3000);
		
		// Step 10 : Add New address

		btncli(m.getChangeaddbtn());
		Thread.sleep(3000);

		btncli(m.getM2_AddNewAddresss_btn());
		Thread.sleep(3000);
		type(m.getM2_Address_Pin(), "600100");

		Thread.sleep(3000);
		m.getM2_Address_FirstName().clear();
		Thread.sleep(1000);

		m.getM2_Address_FirstName().sendKeys("Testing");
		Thread.sleep(3000);

		m.getM2_Address_Lastname().clear();
		Thread.sleep(1000);

		m.getM2_Address_Lastname().sendKeys("Testing");
		Thread.sleep(3000);

		m.getM2_Address_Street().sendKeys("Testing");
		Thread.sleep(3000);

		m.getM2_Address_landMark().sendKeys("Testing");
		Thread.sleep(3000);

		btncli(m.getM2_SaveAddress_btn());

		Thread.sleep(3000);
		
		logger.log(Status.PASS, "Address was added successfully");
		
		System.out.println("Address was added successfully");
		
		//btncli(m.getBackto_Addrspage());
		btncli(driver.findElement(By.xpath("//div[@class='addressitem selected-item']")));
		Thread.sleep(3000);
		
		
		
		
		//btncli(m.getBackto_Addrspage());
		
		m.getBackto_Addrspage().isEnabled();

		System.out.println("yes enabled");

		// Step 14:Select address

		btncli(m.getChangeaddbtn());
		Thread.sleep(6000);

		btncli(m.getSelectaddress());
		Thread.sleep(3000);
		
		//btncli(m.getBackto_Addrspage());
		
		//btncli(driver.findElement(By.xpath("//div[@class='addressitem selected-item']")));
		
		logger.log(Status.PASS, "Address was selected successfully");
		
		System.out.println("Address was selected successfully");
		
		m.getBackto_Addrspage().isEnabled();

		System.out.println("yes enabled");
		Thread.sleep(3000);

		// Step 15 : modify Address

		btncli(m.getChangeaddbtn());
		Thread.sleep(3000);

		btncli(m.getModifyaddressbtn());
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='pin']")).clear();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='pin']")).sendKeys("600100");
		Thread.sleep(3000);

		driver.findElement(By.id("street")).clear();
		Thread.sleep(3000);

		type(m.getAddress(), "Modifyadd");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[contains(text(),'Save Address')]")).click();

		Thread.sleep(3000);

		//btncli(driver.findElement(By.xpath("//div[@class='addressitem selected-item']")));
		//Thread.sleep(3000);
		

		// Step 16 : Delete address

		//driver.findElement(By.xpath("//a[contains(@class,'addchangeweb col-md-4 text-right p-0 ng-star-inserted')]")).isEnabled();
		
		//btncli(m.getBackto_Addrspage());
		
		btncli(driver.findElement(By.xpath("//div[@class='addressitem selected-item']")));
		Thread.sleep(3000);
		
		logger.log(Status.PASS, "Address was modified successfully");
		
		System.out.println("Address was modified successfully");
		
		m.getBackto_Addrspage().isEnabled();
		Thread.sleep(3000);

		System.out.println("yes enabled");

		
		//Delete Address
		
		btncli(m.getChangeaddbtn());

		Thread.sleep(3000);

		btncli(m.getDeleteaddress());

		Thread.sleep(3000);

		//btncli(driver.findElement(By.xpath("//div[@class='addressitem selected-item']")));
		
		//btncli(m.getBackto_Addrspage());
		btncli(driver.findElement(By.xpath("//div[@class='addressitem selected-item']")));
		
		Thread.sleep(3000);

		logger.log(Status.PASS, "Address was deleted successfully");
		
		System.out.println("Address was deleted successfully");
		
		// Step 18 : Click Subscribe//

		btncli(m.getSubscribe());
		logger.log(Status.PASS, "Successfully Subscribe button was clicked");
		Thread.sleep(3000);

		// Step 19 : Ensure order is placed successfully//

		String confirmation = m.getOrder_Placed_text().getText();

		
		String orderid = m.getOrderid().getAttribute("innerText");

		String orderconfirmation = "Order Placed Successfully!";

		Assert.assertEquals(orderconfirmation, confirmation);

		System.out.println(confirmation + "and the id is " + orderid);

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

	}

//*******************************************************************M3  Rx  flow******************************************************************//
	@Test(enabled = true)
	public void M3RXflow() throws Throwable {

		logger = report.createTest(" M3RXflow");
		logger.log(Status.PASS, "*************M3RXflow********************");

		// Step1 :Launch Browser//
		Monepom m = new Monepom();
		driver.manage().window().maximize();

		try {

			// Step 2 :Login with user name and password//
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

		upload.sendKeys("D:\\Automation\\Prescription\\M3Subscription.png");
		Thread.sleep(3000);
		logger.log(Status.PASS, "Prescription added successfully");

		// Step 11 : select duration//
		btncli(m.getSelectDuration());
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


	}

//****************************************************************M3 -Past Rx flow***********************************************************************//
	@Test(enabled = true)
	public void pastrx() throws Throwable {

		logger = report.createTest(" Pastrx");
		logger.log(Status.PASS, "*************PastRx********************");

		// Step1 :Launch Browser//
		Monepom m = new Monepom();
		driver.manage().window().maximize();

		try {

			// Step 2 :Login with user name and password//
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
		
		

		// Step 4 : Navigate to Mysubscription page//

		btncli(m.getMysubscriptionpage());
		Thread.sleep(3000);
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

			type(m.getM3productsearch(), BaseClass.getExcelData("Pastrx", i, 0));

			// btncli(m.getSearchIcon());
			logger.log(Status.PASS, "Successfully navigate to search result page");

			String Cart_Excel = BaseClass.getExcelData("Pastrx", i, 1);

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

		btncli(m.getViewcart());
		Thread.sleep(2000);
		logger.log(Status.PASS, "Successfully navigate to cartpage");

		// Step 09 : Click Proceed Button//

		btncli(m.getProceed());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully Proceed button  was clicked");
		Thread.sleep(3000);
		// Step 10: Add past Rx Prescription//

		WebElement Uploadrx = driver
				.findElement(By.xpath("//ul[@class='d-flex justify-content-center']//span[@class='pastrx-icon']"));

		Uploadrx.click();

		Thread.sleep(3000);

		WebElement Selectrx = driver.findElement(By.xpath("(//input[@class=\"rx_image\"])[2]"));

		Selectrx.click();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//button[@class='close'])[2]")).click();

		// Step 10 : select duration//
		Thread.sleep(3000);
		btncli(m.getSelectDuration());
		btncli(m.getSelectduration45());
		Thread.sleep(2000);

		// Step 11 : Click Next Button//

		btncli(m.getNextbutton());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully Next button was clicked");

		// Step 12 : Click Subscribe//

		btncli(m.getSubscribe());
		logger.log(Status.PASS, "Successfully Subscribe button was clicked");
		Thread.sleep(3000);

		// Step 13 : Ensure order is placed successfully//

		String confirmation = m.getOrder_Placed_text().getText();

		String orderid = m.getOrderid().getAttribute("innerText");

		String orderconfirmation = "Order Placed Successfully!";

		Assert.assertEquals(orderconfirmation, confirmation);

		System.out.println(confirmation + "and the id is " + orderid);

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

	@AfterTest
	private void quitbrowser() {
		report.flush();

		// driver.quit();
	}

}
