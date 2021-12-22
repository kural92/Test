package com.Nm.Andriod_prod;

import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DiagnosticPathology extends MobileBaseClass {

	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			
			//capabilities.setCapability(MobileCapabilityType.UDID, UDID);  //fc95d519 //RZ8R20GLXTA

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
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//DiagnosticPathology.html");
       
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
	@Test()
	public void Diagostic_pathology() throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		logger =  report.createTest("Diagostic pathology flow");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		AndriodPom m = new AndriodPom();
		
		Thread.sleep(10000);
		/*popupclose();
		popupclose();
		 */
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys("8012222872");
			Thread.sleep(3000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys("test4nmm");
			
			btnclick(m.getLogin());
			Thread.sleep(2000);
		}catch(Exception e) {
				System.out.println("Already logged in");
			}
		Thread.sleep(10000);
	btnclick(m.getDiag_image());
	btnclick(m.getTextPinCode());	
	type(m.getEdtPinCode(), "624709");
	driver.hideKeyboard(); btnclick(m.getCHECK());	
	SoftAssert Assert=new SoftAssert();
	
	try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(m.getSnackbar_text()));
	Assert.assertEquals( m.getSnackbar_text().getText(),"Service not available");
	}catch(Exception e) {
		
	}
	clrtxt(m.getEdtPinCode());
	type(m.getEdtPinCode(), "600097");
	driver.hideKeyboard(); btnclick(m.getCHECK());
	btnclick(m.getTextPinCode());	
	btnclick(m.getAddressCheckbox());
	
	Assert.assertEquals( m.getTxtViewCatetories().getText(),"CATEGORIES");

	btnclick(m.getText_check_and_apply_coupon());
	Thread.sleep(3000);
	btnclick(m.getNavigate_up());
	Assert.assertEquals( m.getTxtViewTodayDeal().getText(),"Today's Deals");

	Assert.assertNotNull(m.getTxtTestPackageDesc().getText());
	Thread.sleep(3000);
	driver.swipe(0, 400, 0, 0, 1000);
	Assert.assertNotNull(m.getTxtViewTimer().getText());
	btnclick(m.getTxtViewBuyNow());
	Thread.sleep(3000);
	driver.hideKeyboard();
	Thread.sleep(3000);
	btnclick(m.getNavigate_up());
	Thread.sleep(3000);
	Assert.assertEquals( m.getOUR_MOST().getText(),"OUR MOST");
	Assert.assertEquals( m.getPopular_Packages().getText(),"Popular Packages");
	btnclick(m.getView_All_Popular_Packages());
	Thread.sleep(3000);
	driver.hideKeyboard();
	Thread.sleep(3000);
	btnclick(m.getNavigate_up());
	
	Thread.sleep(3000);
	btnclick(m.getPackageImage());
	Thread.sleep(3000);
	btnclick(m.getArrow_back());
	Thread.sleep(5000);
	for (int i = 0; i < 10; i++) {

		
		Thread.sleep(3000);
		driver.swipe(0, 500, 0, 0, 1000);
		
		if (m.getPackageImage_list().size()==1) {

	
	Thread.sleep(3000);
	driver.swipe(0, 900, 0, 0, 1000);
	try {
		if (m.getViewAllTest().isDisplayed()) {

			
			Thread.sleep(3000);
			//btnclick(m.getPackageImage());
			break;
		} else {
			
			System.out.println("Swipe Down to click on package Button");

		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

	btnclick(m.getViewAllTest());
	Thread.sleep(3000);
	driver.hideKeyboard();
	Thread.sleep(3000);
	btnclick(m.getNavigate_up());
	Thread.sleep(3000);
for (int i = 0; i < 10; i++) {
		
		Thread.sleep(3000);
		driver.swipe(0, 900, 0, 0, 1000);
		
		if (m.getImgFilterCheck().size()==1) {
			
			
			break;
		} else {
			
			System.out.println("Swipe Down to click on diganostic Now Button");

		}}

	
	Thread.sleep(3000);
	for (int i = 0; i < m.getImgFilterCheck().size(); i++) {
		m.getImgFilterCheck().get(i).click();
	}
for (int i = 0; i < 10; i++) {
		
		Thread.sleep(1000);
		driver.swipe(0, 900, 0, 0, 1000);
		
		if (m.getTextDesc_1_list().size()==1) {
			
			
			break;
		} else {
			
			System.out.println("Swipe Down to click on package Now Button");

		}}
	Assert.assertEquals( m.getTextDesc_1().getText(),"NABL, CAP, ISO Certified");
	Assert.assertEquals( m.getTv_desc_2().getText(),"Up to 80% Discount");
	Assert.assertEquals( m.getTv_desc_3().getText(),"Online Lab Report");
	Thread.sleep(5000);
	btnclick(m.getViewAllPackage());
	Thread.sleep(3000);
	driver.hideKeyboard();
	Thread.sleep(3000);
	btnclick(m.getNavigate_up());
	Thread.sleep(5000);
	btnclick(m.getTextPackageName());
	Thread.sleep(3000);
	btnclick(m.getArrow_back());
	btnclick(m.getTextTestCount());

	try {
		
		for (int i = 0; i <30; i++) {
			
			if(m.getImgClearTest().isDisplayed()) {
				Thread.sleep(4000);
			m.getImgClearTest().click();}else {
				break;
			}
		}
		
		
	}catch (Exception e) {
		// TODO: handle exception
	}
for (int i = 0; i < 10; i++) {
		
		Thread.sleep(1500);
		driver.swipe(0, 500, 0, 1000, 1000);
		try {
			if (m.getTxtViewTitleRadio().isDisplayed()) {
				
				Thread.sleep(5000);
				btnclick(m.getTxtViewTitleRadio());	
				break;
			} else {
				
				System.out.println("Swipe Down to click on Consult Now Button");

			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		}
	
	btnclick(m.getImgCheck());
	driver.hideKeyboard();
	Thread.sleep(5000);
	driver.navigate().back();
	btnclick(m.getTxtViewTitlePathology());	
	btnclick(m.getImgCheck());	
	Assert.assertEquals( m.getMessage().getText(),"Radiology & Pathology tests cannot be booked together. Would you like to clear the cart and select again?");
	btnclick(m.getDigansticsyesbutton());
	btnclick(m.getTxtFilterRadiology());
	btnclick(m.getImgCheck());
	Assert.assertEquals( m.getMessage().getText(),"Radiology & Pathology tests cannot be booked together. Would you like to clear the cart and select again?");
	btnclick(m.getDigansticsyesbutton());
	btnclick(m.getTxtFilterPathology());
	btnclick(m.getImgCheck());
	Assert.assertEquals( m.getMessage().getText(),"Radiology & Pathology tests cannot be booked together. Would you like to clear the cart and select again?");
	btnclick(m.getDigansticsyesbutton());
	btnclick(m.getBtnNext());
	btnclick(m.getTxtViewChangeAddress());
	Thread.sleep(3000);
	type(m.getEdtPinCode(), "624709");
	driver.hideKeyboard(); btnclick(m.getCHECK());	

	try {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(m.getSnackbar_text()));
	Assert.assertEquals( m.getSnackbar_text().getText(),"Service not available");
	}catch(Exception e) {
		
	}
	clrtxt(m.getEdtPinCode());
	Thread.sleep(3000);
	type(m.getEdtPinCode(), "600097");
	driver.hideKeyboard(); btnclick(m.getCHECK());
	btnclick(m.getTxtViewChangeAddress());	
	btnclick(m.getAddressCheckbox());	
	for (int i = 0; i < m.getView_Price_Breakup().size(); i++) {
		m.getView_Price_Breakup().get(i).click();
		Assert.assertEquals(m.getTextDialogHeader().getText(),"PRICE BREAKUP");
		Assert.assertNotEquals(m.getDiganostic_test_name().getText(), "");
		Assert.assertNotNull(m.getDiganostic_test_name().getText());
		Assert.assertNotEquals(m.getDiganostic_textPrice().getText(), "");
		Assert.assertNotNull(m.getDiganostic_textPrice().getText());
		Assert.assertNotEquals(m.getDiganostic_textStrikePrice().getText(), "");
		Assert.assertNotNull(m.getDiganostic_textStrikePrice().getText());
		try {
			Assert.assertEquals(m.getTOTAL_SAVINGS().getText(),"TOTAL SAVINGS");
			Assert.assertNotEquals(m.getDiganostic_savings().getText(), "");
			Assert.assertNotNull(m.getDiganostic_savings().getText());
		}catch(Exception e) {
			System.out.println("no total savings");
		}
		btnclick(m.getPopupclosebutton());	

	}
	for (int i = 0; i < m.getImgFilterCheck().size(); i++) {
		m.getImgFilterCheck().get(i).click();
	}
	Thread.sleep(3000);
	btnclick(m.getImgFilterCheck1());
	Thread.sleep(3000);
	btnclick(m.getTextTestCount());
	btnclick(m.getPopupclosebutton());
	btnclick(m.getBtnNext());
	String text = m.getInfoText().getText();
	Assert.assertEquals(text,"These details will appear on the final test reports");
	m.getDiagnosticPatientName().clear();
	m.getDiagnosticPatientName().sendKeys("testing netmeds");
	m.getDiagnosticMobileNumber().clear();
	m.getDiagnosticMobileNumber().sendKeys("9677159095");
	m.getDiagnosticAge().clear();
	m.getDiagnosticAge().sendKeys("20");
	m.getTextMale().click();
	m.getTextFeMale().click();
	m.getDiagnosticPatientEmail().clear();
	m.getDiagnosticPatientEmail().sendKeys("indujaudhayak@gmail.com");
	m.getTextTestCount().click();
	m.getPopupclosebutton().click();
	btnclick(m.getBtnNext());
	
	
	
	//add address flow 
	Thread.sleep(4000);

	
	Thread.sleep(3000);

	//Modify address
	driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/edit")).click();
	type(m.getPincode(), "600100");
	Thread.sleep(2000);
	type(m.getFirstname(),"Firstname");
	Thread.sleep(3000);
	type(m.getLastname(),"Test");
	Thread.sleep(2000);
	type(m.getAddress(),"Addressfirst");
	Thread.sleep(2000);
	type(m.getLandmark(),"nearplaza");
	Thread.sleep(2000);
	btnclick(m.getSave_address());
	logger.log(Status.PASS, "Address was modified successfully");
	System.out.println("Address was modified successfully");
	Thread.sleep(6000);
WebElement delete  = driver.findElement(By.xpath("(//android.widget.TextView[@text='DELETE'])"));

	delete.click();




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
	Thread.sleep(3000);
	type(m.getAddress(),"Addressfirst");
	Thread.sleep(2000);
	type(m.getLandmark(),"neartheatre");
	Thread.sleep(2000);
	btnclick(m.getSave_address());
	logger.log(Status.PASS, "Address was addedd successfully");
	System.out.println("Address was added successfully");
	Thread.sleep(5000);
btnclick(m.getBtnNext());
Thread.sleep(5000);
Assert.assertEquals(m.getTxtViewRequireFasting().getText(),"Note: Some tests/packages may require fasting");
Assert.assertEquals(m.getTvTimeSlotHint().getText(),"Select interval when you want the person to collect the sample.");
btnclick(m.getDateslot());Thread.sleep(2000);
btnclick(m.getImgSlotCheck());
Thread.sleep(2000);
btnclick(m.getBtnNext());
Assert.assertEquals(m.getLabselected().getText(),"LAB SELECTED");
Assert.assertNotNull(m.getTextLabName().getText());
Assert.assertNotEquals(m.getTextLabName().getText(), "");
Assert.assertNotNull(m.getTextSlotTime().getText());
Assert.assertNotEquals(m.getTextSlotTime().getText(), "");
Assert.assertEquals(m.getTime_Slot().getText(),"Time Slot");
Assert.assertEquals(m.getLAB_TESTS().getText(),"LAB TESTS");
Assert.assertNotNull(m.getTextTestName().getText());
Assert.assertNotEquals(m.getTextTestName().getText(), "");
Assert.assertNotNull(m.getTextPrice().getText());
Assert.assertNotEquals(m.getTextPrice().getText(), "");
Assert.assertNotNull(m.getTextStrikePrice().getText());
Assert.assertNotEquals(m.getTextStrikePrice().getText(), "");
Assert.assertEquals(m.getTxtSamplePickUpAddress().getText(),"SAMPLE PICKUP ADDRESS");
Assert.assertNotNull(m.getPatientName().getText());
Assert.assertNotEquals(m.getPatientName().getText(), "");
Assert.assertNotNull(m.getTextName().getText());
Assert.assertNotEquals(m.getTextName().getText(), "");
Assert.assertEquals(m.getTxtViewOfferApplied().getText(),"APPLY PROMO CODE");
Assert.assertEquals(m.getTxtViewMyRewards().getText(),"My Rewards");
btnclick(m.getBtnProceed());
try {
btnclick(m.getPhonepe());
/*Thread.sleep(15000);
driver.pressKeyCode(AndroidKeyCode.BACK);

try {
	//btnclick(m.getPayment_paybutton());
	Thread.sleep(5000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} catch (Exception e) {
}
Thread.sleep(5000);
btnclick(m.getRetry());*/

Thread.sleep(5000);
btnclick(m.getAmazon_pay_withoutLink());
Thread.sleep(10000);
driver.pressKeyCode(AndroidKeyCode.BACK);
Thread.sleep(7000);
btnclick(m.getRetry());
Thread.sleep(5000);
btnclick(m.getMobikwik_withoutLink());
Thread.sleep(5000);
driver.pressKeyCode(AndroidKeyCode.BACK);
Thread.sleep(5000);
btnclick(m.getRetry());
Thread.sleep(5000);
btnclick(m.getFreecharge_PayLater_Wallet());
Thread.sleep(5000);
try {
	btnclick(m.getPayment_paybutton());


} catch (Exception e) {
}
Thread.sleep(15000);
driver.pressKeyCode(AndroidKeyCode.BACK);
try {
	//btnclick(m.getPayment_paybutton());
	Thread.sleep(10000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} catch (Exception e) {
}
Thread.sleep(5000);
btnclick(m.getRetry());
Thread.sleep(5000);
btnclick(m.getSimplpay());
Thread.sleep(5000);
for (int i = 0; i < 10; i++) {
	
	Thread.sleep(3000);
	driver.swipe(0, 900, 0, 0, 1000);
	
	if (m.getAddnewCard_list().size()==1) {
		Thread.sleep(3000);

		btnclick(m.getAddnewCard());
		
		break;
	} else {
		
		System.out.println("Swipe Down to click on Consult Now Button");

	}}
		
type(m.getCart_name(), "4111 1111 1111 1111");
type(m.getCardValidity(), "06/25");
type(m.getCardCvv(), "123");
type(m.getCardHolderName(), "Netmeds testing");
btnclick(m.getChk_save_card());	
btnclick(m.getTv_pay());	
Thread.sleep(10000);
driver.pressKeyCode(AndroidKeyCode.BACK);

try {
//btnclick(m.getPayment_paybutton());
Thread.sleep(15000);
driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} catch (Exception e) {
}
Thread.sleep(5000);
btnclick(m.getRetry());
Thread.sleep(5000);
driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(5000);
btnclick(m.getAxis_Bank());
Thread.sleep(10000);
driver.pressKeyCode(AndroidKeyCode.BACK);

try {
//btnclick(m.getPayment_paybutton());
Thread.sleep(15000);
driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} 
catch (Exception e) {
}
Thread.sleep(10000);
btnclick(m.getRetry());
Thread.sleep(5000);
btnclick(m.getHDFC_Bank());
Thread.sleep(20000);
driver.pressKeyCode(AndroidKeyCode.BACK);

try {
//btnclick(m.getPayment_paybutton());
Thread.sleep(10000);
driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} catch (Exception e) {
}
Thread.sleep(10000);
btnclick(m.getRetry());
Thread.sleep(5000);
Thread.sleep(5000);
btnclick(m.getMORE_BANKS());
Thread.sleep(5000);
type(m.getSearchBank(), "Allahabad Bank");
Thread.sleep(5000);
btnclick(m.getMainLayout());
Thread.sleep(20000);
driver.pressKeyCode(AndroidKeyCode.BACK);

try {
	//btnclick(m.getPayment_paybutton());
	Thread.sleep(10000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();			} catch (Exception e) {
}
Thread.sleep(10000);
btnclick(m.getRetry());
Thread.sleep(5000);

driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(5000);
	
}catch(Exception e) {

}
	
	
	}
	
	
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
		
      //driver.quit();
	}




}
