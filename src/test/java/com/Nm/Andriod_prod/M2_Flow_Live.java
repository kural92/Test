package com.Nm.Andriod_prod;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MobileBaseClass;
import com.Nm.Pom.AndriodPom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class M2_Flow_Live extends MobileBaseClass{
	

	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		
		
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA");  //fc95d519 //RZ8R20GLXTA
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
			capabilities.setCapability("noReset", true);
			
			
			
			//capabilities.setCapability("autoDismissAlerts", true);  
			
			
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
	@Test(priority = 1, enabled = false)
	public void m2_getSearchMedicine() throws Throwable {
		
		
		AndriodPom m = new AndriodPom();
		
		try {
			Thread.sleep(5000);
		btnclick(m.getLetsstarted());
		} catch (Exception e) {
			driver.launchApp();
		}
		

		
	popupclose();
	popupclose();
	
		Thread.sleep(10000);
	try {	
		Thread.sleep(2000);
		driver.hideKeyboard();
		
		Thread.sleep(2000);
		btnclick(m.getMobilenumber());
		
		Thread.sleep(2000);
		type(m.getMobilenumber(), "7010752043");
		
		
		//com.NetmedsMarketplace.Netmeds:id/btn_use_password
		
		Thread.sleep(2000);
		btnclick(m.getUsepwd());
		
		Thread.sleep(5000);
		Thread.sleep(2000);
		type(m.getPassword(), "Change@92");
		
		Thread.sleep(2000);
		btnclick(m.getLogin());
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
		try {
		Thread.sleep(10000);
		btnclick(driver.findElement(By.xpath("//android.widget.TextView[index='0']")));
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		
		
		Thread.sleep(2000);
		btnclick(m.getM2_OrderNow());
		
		
		Thread.sleep(30000);
		btnclick(driver.findElementByAccessibilityId("Gallery"));
		
		
		/*
		Thread.sleep(2000);
		btncli(driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='com.NetmedsMarketplace.Netmeds:id/prescriptionCheckBox']")));
		
		
		Thread.sleep(2000);
		btncli(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/doneButton']")));
		*/
		
		Thread.sleep(25000);
		//btncli(driver.findElement(By.xpath("//android.view.View[@index='0']")));
		
		btnclick(driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]")));
		
		Thread.sleep(25000);
		btnclick(m.getM2_Upload_ContinueBtn());
		
		Thread.sleep(25000);
		btnclick(m.getM2_SearchMedicine());
		
		Thread.sleep(25000);
		btnclick(m.getM2_Search_CAll_ContinueBtn());
		
		Thread.sleep(5000);
		btnclick(m.getM2_SearchBar());
		
		Thread.sleep(2000);
		type(m.getM2_SearchBar(), MobileBaseClass.getExcelData("AndM2", 0, 0));
		
		Thread.sleep(5000);
		btnclick(m.getM2_Search_AddToCart());
		
		Thread.sleep(5000);
	//	btncli(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn']")));
		

		
		Thread.sleep(5000);
//		btncli(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/btn_proceed_to_checkout']")));
		
		Thread.sleep(5000);
		btnclick(m.getM2_ProceedBtn());
		
		Thread.sleep(5000);
	//	btnclick(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_proceed_btn']")));
		
		Thread.sleep(5000);
		if (gettext(driver.findElement(By.xpath("//android.widget.TextView[@text='AO40']"))).contains("AO40")) {
			
			System.out.println("AO40 - Promo Code Matches");
			
		} else {
			
			System.err.println("AO40 - Promo not Code Matches");

		}
		
		
		Thread.sleep(5000);
		btnclick(m.getM2_Place_Order());
		
		Thread.sleep(5000);
		btnclick(m.getTrack_Order());
		
		
		Thread.sleep(5000);
		btnclick(m.getView_Order_details());
		
		
		Thread.sleep(5000);
		btnclick(m.getCancel_Order());
		
		
		Thread.sleep(5000);
		btnclick(m.getCancel_Order_reason());
		
		Thread.sleep(3000);
		driver.swipe(0, 100, 0, 0, 1000);
		
		Thread.sleep(5000);
		btnclick(m.getSubmit_cancelBtn());
		
		try {
		Thread.sleep(5000);
		btnclick(driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")));
		} catch (Exception e) {
			Thread.sleep(5000);
			btnclick(driver.findElementByAccessibilityId("Navigate up"));
			
		}
		
		
		
		
	}
	
	
	public ExtentHtmlReporter getHtmlReporter() {
		return htmlReporter;
	}



	public static ExtentReports getReport() {
		return report;
	}



	public static ExtentTest getLogger() {
		return logger;
	}



	@Test(priority = 2, enabled = false)
	public void m2_getCall() throws Throwable {
	
		AndriodPom m = new AndriodPom();
		

		/*
		 * Thread.sleep(5000); btncli(driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout[@index='0']")));
		 * 
		 * 
		 * AndriodPom m = new AndriodPom();
		 */
		
		
		
		try {
			
			
			
			try {
				Thread.sleep(5000);
			btnclick(m.getLetsstarted());
			} catch (Exception e) {
				driver.launchApp();
			}
			
			
			
			popupclose();
			popupclose();
			Thread.sleep(5000);
			try {
				btnclick(m.getLetsstarted());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
			Thread.sleep(2000);
			driver.hideKeyboard();
			
			Thread.sleep(2000);
			btnclick(m.getMobilenumber());
			
			Thread.sleep(2000);
			type(m.getMobilenumber(), "7010752043");
			
			
			//com.NetmedsMarketplace.Netmeds:id/btn_use_password
			
			Thread.sleep(2000);
			btnclick(m.getUsepwd());
			
			Thread.sleep(5000);
			Thread.sleep(2000);
			type(m.getPassword(), "Change@92");
			
			Thread.sleep(2000);
			btnclick(m.getLogin());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
			Thread.sleep(10000);
			btnclick(driver.findElement(By.xpath("//android.widget.TextView[index='0']")));
			} catch (Exception e) {
				// TODO: handle exception
			}

			
			
			
		} catch (Exception e) {
			System.err.println("Already Logged in");
		}
		

		Thread.sleep(2000);
		btnclick(m.getM2_OrderNow());
		
		
		Thread.sleep(30000);
		btnclick(driver.findElementByAccessibilityId("Gallery"));
		
		
		Thread.sleep(5000);
		btnclick(driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]")));
		
		
		Thread.sleep(5000);
		btnclick(m.getM2_Upload_ContinueBtn());
		
		
		Thread.sleep(10000);
		
		/*
		if (m.getM2_GetCallBtn().isSelected()==true) {
			
			System.out.println("Get Call From NetMeds Checkbox was Already Selected");
			

		} else {

			btncli(m.getM2_GetCallBtn());
		}
		
		*/
		Thread.sleep(10000);
		btnclick(m.getM2_Search_CAll_ContinueBtn());
		
		
		Thread.sleep(5000);
if (gettext(driver.findElement(By.xpath("//android.widget.TextView[@text='AO40']"))).contains("AO40")) {
			
			System.out.println("AO40 - Promo Code Matches");
			
		} else {
			
			System.err.println("AO40 - Promo not Code Matches");

		}
		
		
		Thread.sleep(5000);
		btnclick(m.getM2_Place_Order());
		

		Thread.sleep(5000);
		btnclick(m.getTrack_Order());
		
		
		Thread.sleep(5000);
		btnclick(m.getView_Order_details());
		
		
		Thread.sleep(5000);
		btnclick(m.getCancel_Order());
		
		
		Thread.sleep(5000);
		btnclick(m.getCancel_Order_reason());
		
		Thread.sleep(3000);
		driver.swipe(0, 100, 0, 0, 1000);
		
		Thread.sleep(5000);
		btnclick(m.getSubmit_cancelBtn());
		
		try {
			Thread.sleep(5000);
			btnclick(driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")));
			} catch (Exception e) {
				Thread.sleep(5000);
				btnclick(driver.findElementByAccessibilityId("Navigate up"));
				
			}
		
		

	}
	
	
	@Test(priority = 3,enabled = true)
	public void pastRX_search() throws Throwable {
		
		
		AndriodPom m = new AndriodPom();
		
		
		
		try {
			
			
			
			
			try {
				Thread.sleep(5000);
			btnclick(m.getLetsstarted());
			} catch (Exception e) {
				driver.launchApp();
			}
			
			
			
			popupclose();
			popupclose();
			
			Thread.sleep(5000);
			try {
				btnclick(m.getLetsstarted());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
			Thread.sleep(2000);
			driver.hideKeyboard();
			
			Thread.sleep(2000);
			btnclick(m.getMobilenumber());
			
			Thread.sleep(2000);
			type(m.getMobilenumber(), "7010752043");
			
			
			//com.NetmedsMarketplace.Netmeds:id/btn_use_password
			
			Thread.sleep(2000);
			btnclick(m.getUsepwd());
			
			Thread.sleep(5000);
			Thread.sleep(2000);
			type(m.getPassword(), "Change@92");
			
			Thread.sleep(2000);
			btnclick(m.getLogin());
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
			Thread.sleep(10000);
			btnclick(driver.findElement(By.xpath("//android.widget.TextView[index='0']")));
			} catch (Exception e) {
				// TODO: handle exception
			}

			
			
			
		} catch (Exception e) {
			System.err.println("Already Logged in");
		}
		
		
	
		
		Thread.sleep(2000);
		btnclick(m.getM2_OrderNow());
		
		
		Thread.sleep(10000); // PAST RX
		btnclick(driver.findElementByAccessibilityId("Past Rx"));
		
		
		
		Thread.sleep(2000);
		btnclick(driver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id='com.NetmedsMarketplace.Netmeds:id/prescriptionCheckBox'])[2]")));
		
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/doneButton")).click();
		//btnclick(m.getM2_RX_DoneBtn());
		
		
		Thread.sleep(25000);
		//btncli(driver.findElement(By.xpath("//android.view.View[@index='0']")));
		
	//	btncli(driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.documentsui:id/icon_thumb'])[1]")));
		
		Thread.sleep(25000);
		btnclick(m.getM2_Upload_ContinueBtn());
		
		Thread.sleep(25000);
		btnclick(m.getM2_SearchMedicine());
		
		Thread.sleep(25000);
		btnclick(m.getM2_Search_CAll_ContinueBtn());
		
		Thread.sleep(5000);
		btnclick(m.getM2_SearchBar());
		
		Thread.sleep(2000);
		type(m.getM2_SearchBar(), "Dolo");
		
		Thread.sleep(5000);
		btnclick(m.getM2_Search_AddToCart());
		
		Thread.sleep(5000);
		btnclick(m.getM2_ProceedToCart());
	
		Thread.sleep(5000);
		btnclick(m.getM2_ProceedBtn());
		
		Thread.sleep(5000);
//		btncli(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_proceed_btn']")));
		
if (gettext(driver.findElement(By.xpath("//android.widget.TextView[@text='AO40']"))).contains("AO40")) {
			
			System.out.println("AO40 - Promo Code Matches");
			
		} else {
			
			System.err.println("AO40 - Promo not Code Matches");

		}
		
		Thread.sleep(5000);
		btnclick(m.getM2_Place_Order());
		
		Thread.sleep(5000);
		btnclick(m.getTrack_Order());
		
		
		Thread.sleep(5000);
		btnclick(m.getView_Order_details());
		
		
		Thread.sleep(5000);
		btnclick(m.getCancel_Order());
		
		
		Thread.sleep(5000);
		btnclick(m.getCancel_Order_reason());
		
		Thread.sleep(3000);
		driver.swipe(0, 100, 0 , 0, 1000);
		
		
		Thread.sleep(5000);
		btnclick(m.getSubmit_cancelBtn());
		
		try {
			Thread.sleep(5000);
			btnclick(driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")));
			} catch (Exception e) {
				Thread.sleep(5000);
				btnclick(driver.findElementByAccessibilityId("Navigate up"));
				
			}
		
		
	}
	
	
	@Test(priority = 4,enabled = true)
	public void pastRX_getCall() throws Throwable {
		

		
		
		AndriodPom m = new AndriodPom();
		
		
		
		try {
			
			
			
			
			try {
				Thread.sleep(5000);
			btnclick(m.getLetsstarted());
			} catch (Exception e) {
				driver.launchApp();
				
				
			}
			
			
			
			
			popupclose();
			popupclose();
			Thread.sleep(5000);
			try {
				btnclick(m.getLetsstarted());
			} catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(2000);
			driver.hideKeyboard();
			
			Thread.sleep(2000);
			btnclick(m.getMobilenumber());
			
			Thread.sleep(2000);
			type(m.getMobilenumber(), "7010752043");
			
			
			//com.NetmedsMarketplace.Netmeds:id/btn_use_password
			
			Thread.sleep(2000);
			btnclick(m.getUsepwd());
			
			Thread.sleep(5000);
			Thread.sleep(2000);
			type(m.getPassword(), "Change@92");
			
			Thread.sleep(2000);
			btnclick(m.getLogin());
			
			
			try {
			Thread.sleep(10000);
			btnclick(driver.findElement(By.xpath("//android.widget.TextView[index='0']")));
			} catch (Exception e) {
				// TODO: handle exception
			}

			
			
			
		} catch (Exception e) {
			System.err.println("Already Logged in");
		}
		
		

		Thread.sleep(2000);
		btnclick(m.getM2_OrderNow());
		
		
		Thread.sleep(10000); // PAST RX
		btnclick(driver.findElementByAccessibilityId("Past Rx"));
		
		
		
		Thread.sleep(2000);
		btnclick(driver.findElement(By.xpath("(//android.widget.CheckBox[@resource-id='com.NetmedsMarketplace.Netmeds:id/prescriptionCheckBox'])[3]")));
		
		
		//Thread.sleep(5000);
		//btnclick(m.getM2_RX_DoneBtn());

		Thread.sleep(5000);
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/doneButton")).click();
		
		
		Thread.sleep(5000);
		btnclick(m.getM2_Upload_ContinueBtn());
		
		
		Thread.sleep(2000);
	/*	
		
		if (m.getM2_GetCallBtn().isSelected()) {
			
			System.out.println("Get Call From NetMeds Checkbox was Already Selected");
			
		} else {

			btncli(m.getM2_GetCallBtn());
		}
		
		*/
		Thread.sleep(25000);
		btnclick(m.getM2_Search_CAll_ContinueBtn());
		
		
		// Address Change
		
		//Click on Change
		
		Thread.sleep(5000);
		btnclick(m.getM2_ChangeAddress());
		
		// Add New Address
		Thread.sleep(5000);
		btnclick(m.getM2_AddNewAddress());
		
		
		//PINCODE
		Thread.sleep(5000);
		type(m.getM2_PinCode(), "311003");
		
		//Firstname
		Thread.sleep(5000);
		m.getM2_FirstName().clear();
		
		Thread.sleep(5000);
		type(m.getM2_FirstName(), "Testing ");
		
		//LastName
		Thread.sleep(5000);
		m.getM2_Lastname().clear();
				
		Thread.sleep(5000);
		type(m.getM2_Lastname(), "Testingg");
				
				
		//Address
		Thread.sleep(5000);
		m.getM2_Adress().clear();
						
		Thread.sleep(5000);
		type(m.getM2_Adress(), "Test Address");
						
						
		//land mark
		Thread.sleep(5000);
		m.getM2_LandMark().clear();
								
		Thread.sleep(5000);
		type(m.getM2_LandMark(), "Test Land");
								
						
		
		//Save Address
		Thread.sleep(5000);
		btnclick(m.getM2_SaveAddress());
		
		// Click on Change to Modify Address
		//Click on Change
		
		Thread.sleep(5000);
		btnclick(m.getM2_ChangeAddress());
		
		Thread.sleep(5000);
		btnclick(m.getM2_ModifyAddress());
				

		//PINCODE
		Thread.sleep(5000);
		m.getM2_PinCode().clear();
		Thread.sleep(5000);
		type(m.getM2_PinCode(), "311003");
		
		//Firstname
		Thread.sleep(5000);
		m.getM2_FirstName().clear();
		
		Thread.sleep(5000);
		type(m.getM2_FirstName(), "Testing ");
		
		//LastName
		Thread.sleep(5000);
		m.getM2_Lastname().clear();
				
		Thread.sleep(5000);
		type(m.getM2_Lastname(), "Testingg");
				
				
		//Address
		Thread.sleep(5000);
		m.getM2_Adress().clear();
						
		Thread.sleep(5000);
		type(m.getM2_Adress(), "Test Address");
						
						
		//land mark
		Thread.sleep(5000);
		m.getM2_LandMark().clear();
								
		Thread.sleep(5000);
		type(m.getM2_LandMark(), "Test Land");
								
						
		
		//Save Address
		Thread.sleep(5000);
		btnclick(m.getM2_SaveAddress());
		// Click on Change to Delete Address
		//Click on Change
		
		Thread.sleep(5000);
	//	btncli(m.getM2_ChangeAddress());
				
		////////////////////////////////
		Thread.sleep(3000);
		btnclick(m.getM2_DeleteAddress());
		
		//Back to Place Order page
		Thread.sleep(3000);
		btnclick(m.getM2_BackToCart());
		
		Thread.sleep(3000);
if (gettext(driver.findElement(By.xpath("//android.widget.TextView[@text='AO40']"))).contains("AO40")) {
			
			System.out.println("AO40 - Promo Code Matches");
			
		} else {
			
			System.err.println("AO40 - Promo not Code Matches");

		}
		
		
		
		Thread.sleep(5000);
		btnclick(m.getM2_Place_Order());
		

		Thread.sleep(5000);
		btnclick(m.getTrack_Order());
		
		
		Thread.sleep(5000);
		btnclick(m.getView_Order_details());
		
		
		Thread.sleep(5000);
		btnclick(m.getCancel_Order());
		
		
		Thread.sleep(5000);
		btnclick(m.getCancel_Order_reason());
		
		Thread.sleep(5000);
		btnclick(m.getSubmit_cancelBtn());
		
		
		try {
			Thread.sleep(5000);
			btnclick(driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']")));
			} catch (Exception e) {
				Thread.sleep(5000);
				btnclick(driver.findElementByAccessibilityId("Navigate up"));
				
			}
		

	}
	
	
	
	@AfterTest
	public void tearDown() {

	//	driver.quit();
		

	}


}
