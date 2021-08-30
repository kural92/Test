package com.Nm.Andriod_prod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Youraccount extends MobileBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");//"c195de14"
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
			//capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			//capabilities.setCapability("noReset", true);
			
					
			capabilities.setCapability("autoDismissAlerts", true);  
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//AlternateBrand.html");
       
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
	
	
	@Test(enabled = false,retryAnalyzer=RetryAnalyzer.class)
	public void DeliverAddressSection() throws Throwable {

		logger = report.createTest("DeliverAddressSection");
		logger.log(Status.PASS, "*************DeliverAddressSection********************");

	
		AndriodPom m = new AndriodPom();
		
		
		try {
			Thread.sleep(5000);
		btnclick(m.getLetsstarted());
		} catch (Exception e) {
			driver.resetApp();
			
			
		}
		

//Step 2 :Login with user name and password//

		Thread.sleep(1000);
		
	try {
		btnclick(m.getLetsstarted());
		Thread.sleep(2000);
		m.getMobilenumber().sendKeys("8072281468");
		try {
			Thread.sleep(10000);
			driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
			System.out.println("Popup is closed successfully");
			Thread.sleep(10000);
			driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
			System.out.println("Popup is closed successfully");
			//driver.findElement(By.xpath("//*[@class='android.widget.TextView' and ./parent::*[@class='android.view.View']")).click();
		} catch (Exception e) {
			System.out.println("No Popup is available to close");
		}
		Thread.sleep(3000);
		btnclick(m.getUsepwd());
		Thread.sleep(5000);
	
		m.getPassword().sendKeys("test@123");
		
		Thread.sleep(2000);
	
		
		Thread.sleep(5000);
		btnclick(m.getLogin());
	}
	
	catch(Exception e) {
		System.out.println("Already logged in");
	}
	
//Step 3 : Navigate to user profile//

		btnclick(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");

//Step 4 : Navigate to Delivery Address//

		btnclick(m.getDeliveryaddress());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to Delivery Address");
		System.out.println("Successfully navigate to Delivery Address");

//Step 5: Select Address//

		btnclick(m.getSlctaddress());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Address was selected successfully");
		System.out.println("Address was selected successfully");

//Step 6: Modify Address//

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

		//Delete address

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


		System.out.println("Delivery Address Section is working properly ");
	}

	// **************************************************************MY
	// Wallet*************************************************************************************//

	@Test(enabled = false,retryAnalyzer=RetryAnalyzer.class)
	public void Mywallet() throws Throwable {

		logger = report.createTest("Mywallet");
		logger.log(Status.PASS, "*************Mywallet********************");

		AndriodPom m = new AndriodPom();
		

		//Step 2 :Login with user name and password//

		try {
			Thread.sleep(5000);
		btnclick(m.getLetsstarted());
		} catch (Exception e) {
			driver.resetApp();
			
			
		}
		
				
			try {
				btnclick(m.getLetsstarted());
				Thread.sleep(2000);
				m.getMobilenumber().sendKeys("8072281468");
				try {
					Thread.sleep(10000);
					driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
					System.out.println("Popup is closed successfully");
					Thread.sleep(10000);
					driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
					System.out.println("Popup is closed successfully");
					//driver.findElement(By.xpath("//*[@class='android.widget.TextView' and ./parent::*[@class='android.view.View']")).click();
				} catch (Exception e) {
					System.out.println("No Popup is available to close");
				}
				Thread.sleep(3000);
				btnclick(m.getUsepwd());
				Thread.sleep(5000);
			
				m.getPassword().sendKeys("test@123");
				
				Thread.sleep(2000);
			
				
				Thread.sleep(5000);
				btnclick(m.getLogin());
			}
			
			catch(Exception e) {
				System.out.println("Already logged in");
			}

//Step 3 : Navigate to user profile//

		btnclick(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");

//		Step 4 : Navigate to wallet Page

		btnclick(m.getMywallet());
		Thread.sleep(3000);
		
		

		

//		Step 5 : get Available balance text and do assertion
		// Step 7 :Get NMS Cash text and do assertion
//		Step 10 :Get NMS super Cash text and do assertion

		//SoftAssert SoftAssert = new SoftAssert();

		Assert.assertEquals(gettext(m.getAvailablebalance()), "AVAILABLE BALANCE");
		System.out.println(m.getAvailablebalance().getText());
		
		System.out.println(m.getAvailableamount().getText());
		
		System.out.println(m.getNMSCash().getText());
		System.out.println(m.getNMSSupercash().getText());

		
		
		Assert.assertTrue(gettext(m.getNMSCash()).contains("NMS Cash"));
		
		Assert.assertTrue(gettext(m.getNMSSupercash()).contains("NMS Super Cash"));

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");

//		Step 8 :check How to use page is getting open

		btnclick(m.getHwtouseNMScash());
		Thread.sleep(3000);

		logger.log(Status.PASS, "how to use NMScash button is enabled");
		System.out.println("how to use button NMSCash is enabled");

//		Step 9 : Close the how to use page

		btnclick(m.getClosehwtouseNMScash());
		Thread.sleep(3000);
		logger.log(Status.PASS, "how to use NMScash button is closed");
		System.out.println("how to use button NMSCash is closed");
//How to use

		btnclick(m.getHwtouseNMSsupercash());
		Thread.sleep(3000);
		logger.log(Status.PASS, "how to use NMSsupercash button is enabled");
		System.out.println("how to use button NMSsuperCash is enabled");

//Step 11 :Close the how to use page

		btnclick(m.getClosehwtouseNMSsupercash());

		
		System.out.println("My wallet page is working fine");
	}

	// **************************************************************Edit
	// Profile*************************************************************************************//

	@Test(enabled = false,retryAnalyzer=RetryAnalyzer.class)
	public void Editprofile() throws Throwable {

		logger = report.createTest("Editprofile");
		logger.log(Status.PASS, "*************Editprofile********************");

		
		AndriodPom m = new AndriodPom();
		

		//Step 2 :Login with user name and password//

		try {
			Thread.sleep(5000);
		btnclick(m.getLetsstarted());
		} catch (Exception e) {
			driver.resetApp();
			
			
		}
		
				
			try {
				btnclick(m.getLetsstarted());
				Thread.sleep(2000);
				m.getMobilenumber().sendKeys("8072281468");
				try {
					Thread.sleep(10000);
					driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
					System.out.println("Popup is closed successfully");
					Thread.sleep(10000);
					driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
					System.out.println("Popup is closed successfully");
					//driver.findElement(By.xpath("//*[@class='android.widget.TextView' and ./parent::*[@class='android.view.View']")).click();
				} catch (Exception e) {
					System.out.println("No Popup is available to close");
				}
				Thread.sleep(3000);
				btnclick(m.getUsepwd());
				Thread.sleep(5000);
			
				m.getPassword().sendKeys("test@123");
				
				Thread.sleep(2000);
			
				
				Thread.sleep(5000);
				btnclick(m.getLogin());
			}
			
			catch(Exception e) {
				System.out.println("Already logged in");
			}

//Step 3 : Navigate to user profile//

		btnclick(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");
//click Modify button

		btnclick(m.getEditprofile());
		Thread.sleep(3000);
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_first_name")).sendKeys("testing");
		Thread.sleep(3000);
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_last_name")).sendKeys("test");
		
		
		
		Thread.sleep(3000);

		btnclick(m.getGenderselect());
		Thread.sleep(3000);

		btnclick(m.getGenderselection());
		Thread.sleep(3000);

		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edt_age")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("android:id/date_picker_header_year")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@index='3']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//android.view.View[@index='24']")).click();
		
		driver.findElement(By.id("android:id/button1")).click();

		btnclick(m.getSavechanges());
//		Thread.sleep(2000);

		logger.log(Status.PASS, "Profile  was succesfully edited");
		System.out.println("Profile  was succesfully edited");

	}

	

//********************************************* My prescription***************************************************************************************
	@Test(enabled = false,retryAnalyzer=RetryAnalyzer.class)
	public void Myprescription() throws Throwable {

		logger = report.createTest("Myprescription");
		logger.log(Status.PASS, "*************Myprescription********************");

//Step1 :Launch Browser//		
AndriodPom m = new AndriodPom();
		

		//Step 2 :Login with user name and password//

		try {
			Thread.sleep(5000);
		btnclick(m.getLetsstarted());
		} catch (Exception e) {
			driver.resetApp();
			
			
		}
		
				
			try {
				btnclick(m.getLetsstarted());
				Thread.sleep(2000);
				m.getMobilenumber().sendKeys("8072281468");
				try {
					Thread.sleep(10000);
					driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
					System.out.println("Popup is closed successfully");
					Thread.sleep(10000);
					driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
					System.out.println("Popup is closed successfully");
					//driver.findElement(By.xpath("//*[@class='android.widget.TextView' and ./parent::*[@class='android.view.View']")).click();
				} catch (Exception e) {
					System.out.println("No Popup is available to close");
				}
				Thread.sleep(3000);
				btnclick(m.getUsepwd());
				Thread.sleep(5000);
			
				m.getPassword().sendKeys("test@123");
				
				Thread.sleep(2000);
			
				
				Thread.sleep(5000);
				btnclick(m.getLogin());
			}
			
			catch(Exception e) {
				System.out.println("Already logged in");
			}
//Step 3 : Navigate to user profile//

		btnclick(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");

// Step 4 : Navigate to My prescription Page

		btnclick(m.getMyprescription_page());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to My prescription Page");

		System.out.println("Successfully navigate to My prescription Page");
//Step 5 : Do assertion for all the text in refer and earn page//			

		Assert.assertTrue(gettext(m.getOrder_ID()).contains("Order ID"));
		System.out.println(m.getOrder_ID().getText());
	
		Assert.assertEquals(gettext(m.getPrescriptionDate_text()), "Order Date");
		
		System.out.println(m.getPrescriptionDate_text().getText());
		
		System.out.println(m.getPrescriptionDate().getText());
		
		Assert.assertEquals(gettext(m.getPrescriptionStatus_text()), "Prescription Status");
		
		System.out.println(m.getPrescriptionStatus_text().getText());
		
		System.out.println(m.getPrescriptionStatus().getText());

		System.out.println(m.getOrderStatus().getText());

		

		System.out.println(gettext(m.getOrder_ID()) + gettext(m.getPrescriptionDate())
				+ gettext(m.getPrescriptionStatus()) + gettext(m.getOrderStatus()));

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");

		// Click on prescription image//

		btnclick(m.getPrescription_image());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Prescription image opened successfully");

		System.out.println("Prescription image opened successfully");
		
		
		// Close image//

		btnclick(m.getClose_image());
		
		logger.log(Status.PASS, "Image closed successfully");

		System.out.println(" image closed successfully");
		// Click on Prescription Image//

		btnclick(m.getPrescription_download());
		Thread.sleep(3000);
		logger.log(Status.PASS, "image downloaded successfully");
		System.out.println("image downloaded");

		logger.log(Status.PASS, "My prescription page is working properly");
		System.out.println("My prescription page is working properly");

	}

	// **************************************************************refer and
	// earn*************************************************************************************//

	@Test(enabled = false,retryAnalyzer=RetryAnalyzer.class)
	public void Referearn() throws Throwable {

		logger = report.createTest("contact");
		logger.log(Status.PASS, "*************contactus********************");

//Step1 :Launch Browser//		
		AndriodPom m = new AndriodPom();
		

		//Step 2 :Login with user name and password//

		try {
			Thread.sleep(5000);
		btnclick(m.getLetsstarted());
		} catch (Exception e) {
			driver.resetApp();
			
			
		}
		
				
			try {
				btnclick(m.getLetsstarted());
				Thread.sleep(2000);
				m.getMobilenumber().sendKeys("8072281468");
				try {
					Thread.sleep(10000);
					driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
					System.out.println("Popup is closed successfully");
					Thread.sleep(10000);
					driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
					System.out.println("Popup is closed successfully");
					//driver.findElement(By.xpath("//*[@class='android.widget.TextView' and ./parent::*[@class='android.view.View']")).click();
				} catch (Exception e) {
					System.out.println("No Popup is available to close");
				}
				Thread.sleep(3000);
				btnclick(m.getUsepwd());
				Thread.sleep(5000);
			
				m.getPassword().sendKeys("test@123");
				
				Thread.sleep(2000);
			
				
				Thread.sleep(5000);
				btnclick(m.getLogin());
			}
			
			catch(Exception e) {
				System.out.println("Already logged in");
			}

//Step 3 : Navigate to user profile//

		btnclick(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");

// Step 4 : Navigate to Refer and earn

		driver.swipe(790, 1100, 800, 70, 1000);
		
		Thread.sleep(3000);

		btnclick(m.getReferearnpage());
		Thread.sleep(3000);
		
		logger.log(Status.PASS, "Successfully navigate to refer and earn page");

		System.out.println("Successfully navigate to refer and earn page");

//Step 5 : Do assertion for all the text in refer and earn page//			

		Assert.assertEquals(gettext(m.getGrabyour()), "GRAB YOUR");
		
		System.out.println(m.getGrabyour().getText());
		Assert.assertEquals(gettext(m.getInstantrewards()), "Instant Rewards");
		
		System.out.println(m.getInstantrewards().getText());

		Assert.assertEquals(gettext(m.getSimplerway_txt()), "A simpler way to earn and get discounts");
		
		System.out.println(m.getSimplerway_txt().getText());

		Assert.assertEquals(gettext(m.getInvite()), "Invite your friends and family");
		
		System.out.println(m.getInvite().getText());

		Assert.assertEquals(gettext(m.getShare_netemed_app_txt()),
				"share the Netmeds app download link & Referral code with your friends and family");

			System.out.println(m.getShare_netemed_app_txt().getText());
		Assert.assertEquals(gettext(m.getYouget_txt()), "You get");
		
		System.out.println(m.getYouget_txt().getText());

		Assert.assertEquals(gettext(m.getNMSSupercash_txt()), "Rs.150 NMS SuperCash - after your Friend’s first order is delivered!");
		
		System.out.println(m.getNMSSupercash_txt().getText());

		Assert.assertEquals(gettext(m.getYourfrndsget_txt()), "Your Friends Get");

		System.out.println(m.getYourfrndsget_txt().getText());
		
	
		Assert.assertTrue(gettext(m.getFlat20offer_txt()).contains("Flat 20% off"));

		System.out.println(m.getFlat20offer_txt().getText());
		

		logger.log(Status.PASS, "all the texts were asserted successfully");
		System.out.println("all the texts are asserted successfully");
//Step 6: Referral code check//

		String Actualreferralcodenumber = m.getYourreferralcode().getText();

		String Originalreferralcodenumber = "TEST1932";

		Assert.assertEquals(Actualreferralcodenumber, Originalreferralcodenumber);

		System.out.println(Actualreferralcodenumber);

		Thread.sleep(3000);
		
		//Step 9 : Click share link

		btnclick(m.getsharelink());
		Thread.sleep(3000);

		logger.log(Status.PASS, "Share link was opened successfully");
		System.out.println("Share link was opened successfully");


		driver.findElement(By.id("miui:id/buttonPanel")).click();

		
		//Copy Code
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Copy']")).click();
		Thread.sleep(3000);
		System.out.println("Code was succesfully copied");


		

		//btnclick(m.getTermscondition_link());



		driver.navigate().back();
		Thread.sleep(3000);


		logger.log(Status.PASS, "refer and earn page is working properly");
		System.out.println("refer and earn page is working properly");
	}

	// **************************************************************Help
	// Page*************************************************************************************//

	@Test(enabled = false,retryAnalyzer=RetryAnalyzer.class)
	public void Helppage() throws Throwable {

		logger = report.createTest("Helppage");
		logger.log(Status.PASS, "*************Helppage********************");

//Step1 :Launch Browser//		
	AndriodPom m = new AndriodPom();
		

		//Step 2 :Login with user name and password//

		try {
			Thread.sleep(5000);
		btnclick(m.getLetsstarted());
		} catch (Exception e) {
			driver.resetApp();
			
			
		}
		
				
			try {
				btnclick(m.getLetsstarted());
				Thread.sleep(2000);
				m.getMobilenumber().sendKeys("8072281468");
				try {
					Thread.sleep(10000);
					driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
					System.out.println("Popup is closed successfully");
					Thread.sleep(10000);
					driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
					System.out.println("Popup is closed successfully");
					//driver.findElement(By.xpath("//*[@class='android.widget.TextView' and ./parent::*[@class='android.view.View']")).click();
				} catch (Exception e) {
					System.out.println("No Popup is available to close");
				}
				Thread.sleep(3000);
				btnclick(m.getUsepwd());
				Thread.sleep(5000);
			
				m.getPassword().sendKeys("test@123");
				
				Thread.sleep(2000);
			
				
				Thread.sleep(5000);
				btnclick(m.getLogin());
			}
			
			catch(Exception e) {
				System.out.println("Already logged in");
			}

//Step 3 : Navigate to user profile//

		btnclick(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");

// Step 4 : Navigate to Refer and earn

		driver.swipe(790, 1100, 800, 70, 1000);
		
		 btnclick(m.getHelppage());
		 
		 Thread.sleep(3000);
		 
		 driver.swipe(800, 250, 800, 250, 3000);	 
		 
	List<WebElement>	list =  m.getLeftside_Link();
	
	int help = list.size();
	
	System.out.println("the element size is   "+help);
	

		 for (int i = 0; i<13; i++)
			 
		 {

				Thread.sleep(3000);

		
				list.get(i).click();

				 driver.navigate().back();
				
				Thread.sleep(1500);
				driver.swipe(730, 330, 730, 240, 3000);

				System.out.println(list.get(i).getText());
				logger.log(Status.PASS, "Successfully all the topics are clicked");
			}

		 System.out.println("Successfully all the topics are clicked");

	}


	// **************************************************************Legal
	// Information*************************************************************************************//

	@Test(enabled = false,retryAnalyzer=RetryAnalyzer.class)
	public void Legalinformation() throws Throwable {

		logger = report.createTest("Legalinformation");
		logger.log(Status.PASS, "*************Legalinformation********************");

		//Step1 :Launch Browser//		
		AndriodPom m = new AndriodPom();
			

			//Step 2 :Login with user name and password//

			try {
				Thread.sleep(5000);
			btnclick(m.getLetsstarted());
			} catch (Exception e) {
				driver.resetApp();
				
				
			}
			
					
				try {
					btnclick(m.getLetsstarted());
					Thread.sleep(2000);
					m.getMobilenumber().sendKeys("8072281468");
					try {
						Thread.sleep(10000);
						driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
						System.out.println("Popup is closed successfully");
						Thread.sleep(10000);
						driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
						System.out.println("Popup is closed successfully");
						//driver.findElement(By.xpath("//*[@class='android.widget.TextView' and ./parent::*[@class='android.view.View']")).click();
					} catch (Exception e) {
						System.out.println("No popup is available to close ");
					}
					Thread.sleep(3000);
					btnclick(m.getUsepwd());
					Thread.sleep(5000);
				
					m.getPassword().sendKeys("test@123");
					
					Thread.sleep(2000);
				
					
					Thread.sleep(5000);
					btnclick(m.getLogin());
				}
				
				catch(Exception e) {
					System.out.println("Already logged in");
				}

	//Step 3 : Navigate to user profile//

			btnclick(m.getUserprofile());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to userprofile");

			System.out.println("Successfully navigate to userprofile");

	// Step 4 : Legal Information

			driver.swipe(790, 1100, 800, 70, 1000);
			btnclick(m.getLegalinfo());
		Thread.sleep(3000);
		List<WebElement>	list_tc =  m.getTC_Link();
		
		int help = list_tc.size();
		
		System.out.println("the element size is   "+help);
		

			 for (int i = 0; i<6; i++)
				 
			 {

					Thread.sleep(3000);

			
					list_tc.get(i).click();
					
					Thread.sleep(2000);

					//driver.findElementByAccessibilityId("Navigate up").click();
					
				//driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
				driver.navigate().back();
					
					Thread.sleep(1500);
					
					System.out.println(list_tc.get(i).getText());
					logger.log(Status.PASS, "Successfully all the topics are clicked");
				}
		

		logger.log(Status.PASS, "Terms and condition page is working properly");
		System.out.println("Terms and condition page is working properly");

	}

	
	// **************************************************************offers
		// page*************************************************************************************//

		@Test(enabled = true,retryAnalyzer=RetryAnalyzer.class)
		public void offersPage() throws Throwable {

			logger = report.createTest("Offers Page");
			logger.log(Status.PASS, "*************Offers Page********************");

			//Step1 :Launch Browser//		
			AndriodPom m = new AndriodPom();
				

				//Step 2 :Login with user name and password//

				try {
					Thread.sleep(5000);
				btnclick(m.getLetsstarted());
				} catch (Exception e) {
					driver.resetApp();
					
					
				}
				
						
					try {
						btnclick(m.getLetsstarted());
						Thread.sleep(2000);
						m.getMobilenumber().sendKeys("8072281468");
						try {
							Thread.sleep(10000);
							driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
							System.out.println("Popup is closed successfully");
							Thread.sleep(10000);
							driver.findElement(By.xpath("//android.view.View[@index='1']/android.widget.TextView")).click();
							System.out.println("Popup is closed successfully");
							//driver.findElement(By.xpath("//*[@class='android.widget.TextView' and ./parent::*[@class='android.view.View']")).click();
						} catch (Exception e) {
							System.out.println("No popup is available to close ");
						}
						Thread.sleep(3000);
						btnclick(m.getUsepwd());
						Thread.sleep(5000);
					
						m.getPassword().sendKeys("test@123");
						
						Thread.sleep(2000);
					
						
						Thread.sleep(5000);
						btnclick(m.getLogin());
					}
					
					catch(Exception e) {
				
					}

					driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart")).click();
					Thread.sleep(3000);
					
					for (int i = 0; i < 16; i++) {
						Thread.sleep(3000);
						if (!(driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/cart_remove_product")).size() == 0)) {
							

							try {
	
									
								btnclick(m.getRemovebutton());
								
								
								logger.log(Status.PASS, "Items are removed successfully");
								System.out.println("Items are removed from the cart");
							} catch (Exception e) {
								System.out.println("No items in the cart ");
							}

						} else {
							break;

						}

					}
							
					driver.navigate().back();
					
		//Step 3 : Navigate to user profile//

				btnclick(m.getUserprofile());
				Thread.sleep(3000);
				logger.log(Status.PASS, "Successfully navigate to userprofile");

				System.out.println("Successfully navigate to userprofile");
				
	//Step 4 : Offers Page
				Thread.sleep(3000);
				btnclick(m.getOffers_page());
				Thread.sleep(2000);
				
	//Medicine
				
				driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/img_offer_full_image'])[1]")).click();
				Thread.sleep(3000);
		String couponcode =		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/tv_offer_coupon")).getText();
		
			driver.findElement(By.xpath("//android.widget.Button[@text ='COPY CODE AND SHOP']")).click();
			
			
			
		//	driver.findElement(By.xpath("//android.widget.TextView[@text='GO TO SEARCH']"));
			
			
				Thread.sleep(3000);
				try {
					
					type(m.getM3productsearch(),"Flavedon MR 35mg Tablet 10'S");
					
					Thread.sleep(3000);
			WebElement		Cart_btn = (driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn")));

					btnclick(Cart_btn);
					
					Thread.sleep(3000);
					
					System.out.println("successfully Items are added");
					
				} catch (Exception e) {
					System.out.println("Items are available in the cart");
				}
				
				
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart")).click();
				Thread.sleep(3000);
				
				
				//Select qtyincrease = new Select(m.getQty_Incr_Decr());
				//qtyincrease.selectByIndex(3);
				
			driver.findElement(By.xpath("(//android.widget.TextView[@resource-id ='com.NetmedsMarketplace.Netmeds:id/cart_tv_item_qty'])")).click();	
		
			WebElement qty_increase = driver.findElement(By.xpath("//android.widget.TextView[@text='11']"));
			
			Thread.sleep(2000);
			qty_increase.click();
		
		
	//Apply Promo
	if ((driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/chk_apply_promo_code"))).size()!=0) {
				
	//remove code
			
			try {
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/chk_apply_promo_code")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/apply_remove_coupon_btn")).click();
				//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/btn_dismiss")).click();
			}catch (Exception e) {
				
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/chk_apply_promo_code")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/btn_dismiss")).click();
				
			}
			
			
		}
		else  {
			
		}
		
		
			Thread.sleep(2000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/chk_apply_promo_code")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/promo_code']")).sendKeys(couponcode);
			Thread.sleep(3000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/apply_remove_coupon_btn")).click();
		
		
		Thread.sleep(3000);  
		
		driver.navigate().back();
		
		driver.navigate().back();
		
		driver.navigate().back();
//Diagonstics	
		
		driver.findElement(By.xpath("//android.widget.TextView[@text ='Diagnostics']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/img_offer_full_image'])[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.Button[@text='BOOK NOW']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Successfully navigated to diagonistics page");
		
		driver.navigate().back();
		
		
//Consultation
		
		//Step 3 : Navigate to user profile//

		btnclick(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");

		System.out.println("Successfully navigate to userprofile");
		

		Thread.sleep(3000);
		btnclick(m.getOffers_page());
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text ='Consultation']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/img_offer_full_image'])[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.Button[@text='CONSULT NOW']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Successfully navigated to consultation page");
		
		driver.navigate().back();
		
		
		System.out.println("Offer Page is working properly");
		
	
		
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
