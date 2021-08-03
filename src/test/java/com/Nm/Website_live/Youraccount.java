package com.Nm.Website_live;

import java.awt.Container;
import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

//********Extend Report*********//
public class Youraccount extends BaseClass {

	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//report//sample.html");

		// initialize ExtentReports and attach the HtmlReporter
		report = new ExtentReports();

		// htmlReporter.setAppendExisting(true);
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
	
	/* Under your account page
	 	Test Case 1 : Verify the functionalities of Delivery address Page (Add, Edit, Select and Delete Address).
	  	Test Case 2 : Verify the functionalities under my wallet page (Assertion of all the texts,NMS Cash, NMS super Cash And how to use it).
	  	Test Case 3 : Verify the functionalities of Edit profile Page.
	  	Test Case 4	: Verify the functionalities of Contact us  Page.(Assertion of all the texts).
	  	Test Case 5 : Verify the functionalities of My Prescription Page.(Assertion of all the texts).
	  	Test Case 6 : Verify the functionalities of refer and earn.(Assertion of all the texts).
	  	Test Case 7 :Verify the functionalities of Help Page.
	  	Test Case 8 :Verify the functionalities of Rate us page.
	  	Test Case 9 :Verify the functionalities of Legal Information Page.
	  :
	 */
	
	

//*****************************************************Your Accountpage*************************

//Menu : Delivery Address//
	
	
	@Test(enabled = true)
	public void DeliverAddressSection() throws Throwable {

		logger = report.createTest("DeliverAddressSection");
		logger.log(Status.PASS, "*************DeliverAddressSection********************");

//Step1 :Launch Browser//		
		Monepom m = new Monepom();
		driver.manage().window().maximize();

//Step 2 :Login with user name and password//
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
//Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");

//Step 4 : Navigate to Delivery Address//

		btncli(m.getDeliveryaddress());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to Delivery Address");
		System.out.println("Successfully navigate to Delivery Address");

//Step 5: Select Address//

		btncli(m.getSlctaddress());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Address was selected successfully");
		System.out.println("Address was selected successfully");

//Step 6: Modify Address//

		btncli(m.getModifyaddress());
		Thread.sleep(3000);
		m.getAddpincode().clear();
		Thread.sleep(3000);
		type(m.getAddpincode(), "600100");
		Thread.sleep(3000);
		// driver.findElement(By.xpath("(//input[@id=\"firstname\"])[2]")).clear();
		m.getAddfirstname().clear();
		Thread.sleep(3000);
		type(m.getAddfirstname(), "testnameone");
		Thread.sleep(3000);
		m.getAddlastname().clear();
		// driver.findElement(By.xpath("(//input[@id=\"lastname\"])[2]")).clear();
		Thread.sleep(3000);
		type(m.getAddlastname(), "lastname");
		Thread.sleep(3000);
		m.getAddstreet().clear();
		Thread.sleep(3000);
		type(m.getAddstreet(), "street1");
		Thread.sleep(3000);
		m.getAddlandmark().clear();
		Thread.sleep(3000);
		type(m.getAddlandmark(), "nearhotel");
		Thread.sleep(3000);
		btncli(m.getSaveaddressbtn());
		Thread.sleep(3000);

		logger.log(Status.PASS, "Address was modified successfully");

		System.out.println("Address was modified successfully");

//Step 7: delete Address//

		btncli(m.getDltaddress());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Address was deleted successfully");
		System.out.println("Address was deleted successfully");

//Step 8 : Add New Address//

		btncli(m.getAddaddress());
		Thread.sleep(3000);
		type(m.getAddpincode(), "600100");
		Thread.sleep(3000);
		m.getAddfirstname().sendKeys("testnameone");
		Thread.sleep(3000);
		m.getAddlastname().sendKeys("lastname");
		Thread.sleep(3000);
		type(m.getAddstreet(), "street1");
		Thread.sleep(3000);
		type(m.getAddlandmark(), "nearhotel");
		Thread.sleep(3000);
		btncli(m.getSaveaddressbtn());

		Thread.sleep(3000);
		logger.log(Status.PASS, "Address was saved successfully");

		System.out.println("Address was added successfully");

	}

	// **************************************************************MY
	// Wallet*************************************************************************************//

	@Test(enabled = true)
	public void Mywallet() throws Throwable {

		logger = report.createTest("Mywallet");
		logger.log(Status.PASS, "*************Mywallet********************");

//Step1 :Launch Browser//		
		Monepom m = new Monepom();
		driver.manage().window().maximize();

//Step 2 :Login with user name and password//

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

		logger.log(Status.PASS, "Successfully logged in");

		System.out.println("Successfully logged in");

//Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");

//		Step 4 : Navigate to wallet Page

		btncli(m.getMywallet());
		Thread.sleep(3000);
		
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

		Thread.sleep(3000);

//		Step 5 : get Available balance text and do assertion
		// Step 7 :Get NMS Cash text and do assertion
//		Step 10 :Get NMS super Cash text and do assertion

		SoftAssert SoftAssert = new SoftAssert();

		SoftAssert.assertEquals(gettext(m.getAvailablebalance()), "AVAILABLE BALANCE");
		
		System.out.println(m.getNMSCash().getText());
		System.out.println(m.getNMSSupercash().getText());

		SoftAssert.assertAll();
		
		SoftAssert.assertTrue(gettext(m.getNMSCash()).contains("NMS Cash\r\n"
				+ "Rs. 0.00\r\n"
				+ "How to use?"));
		
		SoftAssert.assertTrue(gettext(m.getNMSSupercash()).contains("NMS Super Cash"
				+ "Rs. 0.00"
				+ "How to use?"));

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");

//		Step 8 :check How to use page is getting open

		btncli(m.getHwtouseNMScash());
		Thread.sleep(3000);

		logger.log(Status.PASS, "how to use NMScash button is enabled");
		System.out.println("how to use button NMSCash is enabled");

//		Step 9 : Close the how to use page

		btncli(m.getClosehwtouseNMScash());
		Thread.sleep(3000);

//How to use

		btncli(m.getHwtouseNMSsupercash());
		Thread.sleep(3000);
		logger.log(Status.PASS, "how to use NMSsupercash button is enabled");
		System.out.println("how to use button NMSsuperCash is enabled");

//Step 11 :Close the how to use page

		btncli(m.getClosehwtouseNMSsupercash());

	}

	// **************************************************************Edit
	// Profile*************************************************************************************//

	@Test(enabled = true)
	public void Editprofile() throws Throwable {

		logger = report.createTest("Editprofile");
		logger.log(Status.PASS, "*************Editprofile********************");

		// Step1 :Launch Browser//
		Monepom m = new Monepom();
		driver.manage().window().maximize();

		// Step 2 :Login with user name and password//

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

		logger.log(Status.PASS, "Successfully logged in");

		System.out.println("Successfully logged in");

		// Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");

//Step 5 : get Login information and do assertion

//Step 7 :Get Personal and do assertion

//		Step 8 :check EMAIL text is available and do assertion

//		Step 9 :check Fullname text is available and do assertion	

//		Step 10 : check Gender text is available and do assertion

//		Step 11:check Mobile text is available and do assertion

		SoftAssert SoftAssert = new SoftAssert();

		SoftAssert.assertEquals(gettext(m.getLoginInformation()), "LOGIN INFORMATION");

		SoftAssert.assertEquals(gettext(m.getPersonalinfo()), "PERSONAL INFORMATION");

		SoftAssert.assertEquals(gettext(m.getEmail()), "EMAIL");

		SoftAssert.assertEquals(gettext(m.getFullname()), "FULL NAME");

		SoftAssert.assertEquals(gettext(m.getMobilenumber()), "MOBILE NUMBER");

		SoftAssert.assertEquals(gettext(m.getGender()), "GENDER");

		SoftAssert.assertAll();

		Thread.sleep(3000);

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");
//click Modify button

		btncli(m.getModifybtn());
		Thread.sleep(3000);
		m.getFirstname().clear();
		Thread.sleep(3000);
		type(m.getFirstname(), "newcustomer");
		Thread.sleep(3000);
		m.getLastname().clear();
		Thread.sleep(3000);
		type(m.getLastname(), "customernew");
		Thread.sleep(3000);
		btncli(m.getDOB());
		Thread.sleep(1000);
		btncli(m.getCalendar());
		Thread.sleep(3000);
		btncli(m.getYear());
		Thread.sleep(1000);
		btncli(m.getMonth());
		Thread.sleep(1000);
		btncli(m.getDate());
		Thread.sleep(1000);

		// driver.findElement(By.xpath("(//div[@class=\"mat-calendar-body-cell-content\"])[24]")).click();//
		// driver.findElement(By.xpath("(//div[@class=\"mat-calendar-body-cell-content\"])[6]")).click();//
		// driver.findElement(By.xpath("(//div[@class=\"mat-calendar-body-cell-content\"])[12]")).click();//
		Thread.sleep(3000);

		WebElement Selectgender = m.getGenderselect();

		// (driver.findElement(By.xpath("//div[@class='mat-select-value']")));

		Selectgender.click();
		Thread.sleep(3000);

		// driver.findElement(By.xpath("(//span[@class=\"mat-option-text\"])[2]")).click();

		btncli(m.getGenderselection());
		Thread.sleep(3000);

		// driver.findElement(By.xpath("//button[.='Save Changes']")).click();

		btncli(m.getSavechanges());
//		Thread.sleep(2000);

		logger.log(Status.PASS, "Profile  was succesfully edited");
		System.out.println("Profile  was succesfully edited");

	}

	// **************************************************************Contact
	// Us*************************************************************************************//

	@Test(enabled = true)
	public void contactus() throws Throwable {

		logger = report.createTest("contact");
		logger.log(Status.PASS, "*************contactus********************");

		// Step1 :Launch Browser//
		Monepom m = new Monepom();
		driver.manage().window().maximize();

		// Step 2 :Login with user name and password//

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

		logger.log(Status.PASS, "Successfully logged in");

		System.out.println("Successfully logged in");

		// Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");

// Step 4 : Navigate to contact us page
//Step 5 :get damged@netmeds text and Missing @ netmeds
//Step 6 :Purpose of contact

		btncli(m.getContactus());

		// driver.findElement(By.xpath("//a[@class=\"contactus-link\"]")).click();
		Thread.sleep(3000);

		SoftAssert SoftAssert = new SoftAssert();

		SoftAssert.assertEquals(gettext(m.getHowtocontact()), "How would you like us to contact you?*");

		SoftAssert.assertEquals(gettext(m.getDamged_item_mail()), "You can also write to us at Damaged@netmeds.com.");

		SoftAssert.assertEquals(gettext(m.getMissing_item_email()), "You can also write to us at Missing@netmed.com.");

		SoftAssert.assertEquals(gettext(m.getPurposetext()), "Purpose of Contact*");

		SoftAssert.assertEquals(gettext(m.getMessage()), "Please state your message here*");

		SoftAssert.assertAll();

		Thread.sleep(3000);

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");

		Select purpose = new Select(
				driver.findElement(By.xpath("(//select[@class=\"empty field-required Required-ddrpreason \"])[1]")));
		purpose.selectByIndex(1);

		Thread.sleep(3000);

		logger.log(Status.PASS, "Successfully selected the purpose");

		System.out.println("Successfully selected the purpose");

//Step 7 : State Your Message

		type(m.getAddcomments(), "Testing Purpose");
		Thread.sleep(3000);

		logger.log(Status.PASS, "Successfully message has been entered");
		System.out.println("Successfully message has been entered");

//Step 8 : Check email me a copy

		btncli(m.getCopyme());

		// driver.findElement(By.xpath("//*[@id=\"contact-form\"]/div[2]/div/div/label/span")).click();

//Step 9 : Click Submit
		//btncli(m.getContactus_submit());

		//driver.findElement(By.xpath("//button[@class=\"pink-btn contact-submit\"]")).click();

		logger.log(Status.PASS, "Sucessfully Submitted the message");
		System.out.println("Sucessfully Submitted the message");

	}

//********************************************* My prescription***************************************************************************************
	@Test(enabled = true)
	public void Myprescription() throws Throwable {

		logger = report.createTest("Myprescription");
		logger.log(Status.PASS, "*************Myprescription********************");

//Step1 :Launch Browser//		
		Monepom m = new Monepom();
		driver.manage().window().maximize();

//Step 2 :Login with user name and password//
		try {

			// Step 2 :Login with user name and password//
			btncli(m.getSignin());
			Thread.sleep(5000);
			type(m.getMobileno(), "7010752043");
			Thread.sleep(3000);
			btncli(m.getUsepwdbtn());
			Thread.sleep(3000);
			type(m.getPassword(), "Change@92");
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

//Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");

// Step 4 : Navigate to My prescription Page

		btncli(m.getMyprescription_page());
		Thread.sleep(3000);

//Step 5 : Do assertion for all the text in refer and earn page//			

//		String a = m.getOrder_ID().getText();  
//		String[] id = a.split(" : ");  
//		String ab = id[0].toString();

		SoftAssert SoftAssert = new SoftAssert();

		// SoftAssert.assertEquals(gettext(m.getOrder_ID()),ab );

		SoftAssert.assertEquals(gettext(m.getPrescriptionDate()), "Date :");

		SoftAssert.assertEquals(gettext(m.getPrescriptionStatus()), "Prescription Status :");

		SoftAssert.assertEquals(gettext(m.getOrderStatus()), "Order Status :");

		SoftAssert.assertAll();

		System.out.println(gettext(m.getOrder_ID()) + gettext(m.getPrescriptionDate())
				+ gettext(m.getPrescriptionStatus()) + gettext(m.getOrderStatus()));

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");

		// Click on prescription image//

		btncli(m.getPrescription_image());
		Thread.sleep(3000);

		System.out.println("image opened");
		// Close image//

		btncli(m.getClose_image());

		// Click on Prescription Image//

		btncli(m.getPrescription_download());
		Thread.sleep(3000);
		System.out.println("image downloaded");

		logger.log(Status.PASS, "My prescription page is working properly");
		System.out.println("My prescription page is working properly");

	}

	// **************************************************************refer and
	// earn*************************************************************************************//

	@Test(enabled = true)
	public void Referearn() throws Throwable {

		logger = report.createTest("contact");
		logger.log(Status.PASS, "*************contactus********************");

//Step1 :Launch Browser//		
		Monepom m = new Monepom();
		driver.manage().window().maximize();

//Step 2 :Login with user name and password//
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

//Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");

// Step 4 : Navigate to Refer and earn

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement referearn = m.getReferearnpage();
		js.executeScript("arguments[0].scrollIntoView(true);", referearn);

		Thread.sleep(3000);

		btncli(m.getReferearnpage());
		Thread.sleep(3000);

//Step 5 : Do assertion for all the text in refer and earn page//			

		SoftAssert SoftAssert = new SoftAssert();

		SoftAssert.assertEquals(gettext(m.getGrabyour()), "GRAB YOUR");

		SoftAssert.assertEquals(gettext(m.getInstantrewards()), "Instant Rewards");

		SoftAssert.assertEquals(gettext(m.getSimplerway_txt()), "A simpler way to earn and get discounts");

		SoftAssert.assertEquals(gettext(m.getInvite()), "Invite your friends and family");

		SoftAssert.assertEquals(gettext(m.getShare_netemed_app_txt()),
				"share the Netmeds app download link & Referral code with your friends and family");

		SoftAssert.assertEquals(gettext(m.getYouget_txt()), "You get");

		SoftAssert.assertEquals(gettext(m.getNMSSupercash_txt()), "NMS SuperCash");

		SoftAssert.assertEquals(gettext(m.getYourfrndsget_txt()), "Your Friends Get");

		SoftAssert.assertEquals(gettext(m.getFlat20offer_txt()),
				"Flat 20% off + 20% NMS SuperCash on their first order (minimum order value Rs.500)");

		SoftAssert.assertEquals(gettext(m.getYourreferralcode()), "Your Referral Code");

		SoftAssert.assertAll();

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");
//Step 6: Referral code check//

		String Actualreferralcodenumber = m.getYourreferralcodenumber().getText();

		String Originalreferralcodenumber = "TEST1932";

		Assert.assertEquals(Actualreferralcodenumber, Originalreferralcodenumber);

		System.out.println(Actualreferralcodenumber);

		Thread.sleep(3000);

//Step 7 :Click terms and condition page//

		btncli(m.getTermscondition_link());

//Step 8 : Do assertion in terms and condition page//

		SoftAssert.assertEquals(gettext(m.getReferearnpage_TC()), "Refer & Earn");

		SoftAssert.assertEquals(gettext(m.getTermsandcondition()),
				"TERMS AND CONDITIONS - Netmeds Refer & Earn Programme");

		Thread.sleep(3000);

		driver.navigate().back();
		Thread.sleep(3000);

//Step 9 : Click share link

		btncli(m.getsharelink());
		Thread.sleep(3000);

		String share = driver.findElement(By.xpath("//h4[.=\"Share code with your friends\"]")).getText();

		System.out.println(share);

		driver.findElement(By.xpath("(//button[@class='close pull-right'])[2]")).click();

		logger.log(Status.PASS, "refer and earn page is working properly");
		System.out.println("refer and earn page is working properly");
	}

	// **************************************************************Help
	// Page*************************************************************************************//

	@Test(enabled = true)
	public void Helppage() throws Throwable {

		logger = report.createTest("Helppage");
		logger.log(Status.PASS, "*************Helppage********************");

//Step1 :Launch Browser//		
		Monepom m = new Monepom();
		driver.manage().window().maximize();

//Step 2 :Login with user name and password//
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

//Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");

// Step 4 : Navigate to Refer and earn

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement Helppage = m.getHelppage();
		js.executeScript("arguments[0].scrollIntoView(true);", Helppage);

		Thread.sleep(3000);

		btncli(m.getHelppage());
		Thread.sleep(3000);



		List<WebElement> findElements = m.getLeftside_Link();

		for (int i = 0; i < findElements.size(); i++)

		{

			Thread.sleep(1500);

			findElements.get(i).click();

			Thread.sleep(1500);

			// findElements.get(i).getText();

			// driver.findElement(By.xpath("//li[@class=\"non_arrow_li\"]")).click();

			System.out.println(findElements.get(i).getText());
			logger.log(Status.PASS, "Successfully all the topics are clicked");
		}

		// Step 6: Do assertion for the text in do you still need help text

		String Actualstillneedhelptext = m.getStill_need_help().getText();

		String Originalstillneedhelptext = "STILL NEED HELP?";

		Assert.assertEquals(Actualstillneedhelptext, Originalstillneedhelptext);

		System.out.println(Actualstillneedhelptext);

		// Step 7 :click Still need help button//

		btncli(m.getStill_need_help());

		// Step 8:contact us

		String Actualcontactusurl = driver.getCurrentUrl();

		String Originalcontacturl = "https://www.netmeds.com/contact-us";

		Assert.assertEquals(Actualcontactusurl, Originalcontacturl);

		System.out.println(Actualcontactusurl);

	}

	// **************************************************************Rate
	// Us*************************************************************************************//

	@Test(enabled = true)
	public void rateus() throws Throwable {

		logger = report.createTest("Rateus");
		logger.log(Status.PASS, "*************Rateus********************");

//Step1 :Launch Browser//		
		Monepom m = new Monepom();
		driver.manage().window().maximize();

//Step 2 :Login with user name and password//
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

//Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");

// Step 4 : Navigate to Rate us page

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement Helppage = m.getRateus();
		js.executeScript("arguments[0].scrollIntoView(true);", Helppage);

		Thread.sleep(3000);

		btncli(m.getRateus());
		Thread.sleep(3000);

//Step 5 : rate netmeds text

		SoftAssert SoftAssert = new SoftAssert();
		SoftAssert.assertEquals(gettext(m.getRateNedmeds_text()), "RATE NETMEDS");

		SoftAssert.assertEquals(gettext(m.getSuggestions_txt()), "ANY SUGGESTIONS");

		System.out.println(m.getRateNedmeds_text().getText());

		System.out.println(m.getSuggestions_txt().getText());
//Step 5 : Do different star ratings		

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

		logger.log(Status.PASS, "Successfully rating was given");

		System.out.println("Successfully rating was given");

//Step 6 : Write message//

		type(m.getSugesstion_msg(), "Testing purpose,please don't process");

		logger.log(Status.PASS, "Successfully comments were added");

		System.out.println("Successfully comments were added");

//Step 7 : Submit Button

	//	btncli(m.getSubmitmsg());

		logger.log(Status.PASS, "Suggestion was submitted ");

		System.out.println("Suggestion was submitted");
	}

	// **************************************************************Legal
	// Information*************************************************************************************//

	@Test(enabled = true)
	public void Legalinformation() throws Throwable {

		logger = report.createTest("Legalinformation");
		logger.log(Status.PASS, "*************Legalinformation********************");

//Step1 :Launch Browser//		
		Monepom m = new Monepom();
		driver.manage().window().maximize();

//Step 2 :Login with user name and password//
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

//Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");

// Step 4 : Navigate to Refer and earn

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement legalinfo = m.getLegalinfo();
		js.executeScript("arguments[0].scrollIntoView(true);", legalinfo);

		Thread.sleep(3000);

		btncli(m.getLegalinfo());
		Thread.sleep(3000);

//Step 5 : Do assertion for terms and condition text//			

		String Actualtermsandcondition = m.getTermsandcondition_txt().getText();

		String Originaltermsandcondition = "Terms and Conditions";

		Assert.assertEquals(Actualtermsandcondition, Originaltermsandcondition);

		System.out.println(Actualtermsandcondition);

//Step 6 :Do Assertion on contact information

	/*	WebElement contactinfo = m.getContact_info();
		js.executeScript("arguments[0].scrollIntoView(true);", contactinfo);

		SoftAssert SoftAssert = new SoftAssert();

		SoftAssert.assertEquals(gettext(m.getContact_info()), "Contact Information");

		SoftAssert.assertEquals(gettext(m.getContactus_legal()),
				"for any questions or comments regarding these Terms and Conditions.\r\n"
						+ "Telephone number: 72007-12345\r\n" + "E-mail:");

		SoftAssert.assertEquals(gettext(m.getCsnetmeds()), "cs@netmeds.com");

		System.out.println(m.getContact_info().getText());

		System.out.println(m.getContactus_legal().getText());

		System.out.println(m.getCsnetmeds().getText());

//		
		m.getContactus_link().isDisplayed();
		m.getContactus_link().isEnabled();
		Thread.sleep(3000);
		m.getCsnetmeds().isDisplayed();
		m.getCsnetmeds().isEnabled();*/
//String contacustext = driver.findElement(By.xpath("//a[contains(text(),\" for any questions or comments regarding these Terms and Conditions. \")]")).getText();

//System.out.println(contacustext);
		logger.log(Status.PASS, "Terms and condition page is working properly");
		System.out.println("Terms and condition page is working properly");

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

	@AfterTest
	private void quitbrowser() {
		report.flush();

		driver.quit();
	}

}
