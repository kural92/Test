package com.Nm.Msite_stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Andriod_prod.RetryAnalyzer;
import com.Nm.Base.MobileBaseClass;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class NetmedsFirst extends MobileBaseClass  {
	//static WebDriver driver;
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
	  
		@BeforeClass
		public void launchbrowser() throws IOException {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			capabilities.setCapability("platformName", "Android");

		//	capabilities.setCapability(MobileCapabilityType.UDID, "NBBY79GM5LTCJBJR");
			capabilities.setBrowserName(MobileBrowserType.CHROMIUM);

			capabilities.setCapability("noReset", true);
			
			capabilities.setCapability("autoDismissAlerts", true);  
			
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
}
		@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
		public void startReport() {

			htmlReporter = new ExtentHtmlReporter(".//report//NetmedsFirst.html");

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
			htmlReporter.config().setReportName("Netmeds.com");

			// htmlReporter.config().setTheme(Theme.STANDARD);

		}
		@Test(priority = 1,retryAnalyzer=RetryAnalyzer.class)
		public void laucnh() throws Throwable {
		logger = report.createTest("Netmeds First");
		logger.log(Status.PASS, "*************Netmeds First********************");
		MsitePOM m = new MsitePOM();
			  driver.get("https://m.netmeds.com/");
			  
			  Thread.sleep(10000);
				popupclose() ;
			  Thread.sleep(10000);	String s="Patanjali Lauh Bhasm Powder 5 gm";
		Thread.sleep(2000);
		driver.navigate().to("https://m.netmeds.com/checkout/cart");
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
		}catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; i < 10; i++) {
			Thread.sleep(5000);
			if (!(driver.findElements(By.xpath("//*[@title='Remove item']")).size() == 0)) {

				Thread.sleep(5000);
						try {
							driver.findElement(By.xpath("//android.view.View[@text='REMOVE']|//*[@title='Remove item']")).click();
						} catch (Exception e) {
							// TODO: handle exception
						}

			} else {
				//logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		} 
		driver.navigate().to("https://m.netmeds.com");
		for (int i = 0; i < 10; i++) {

			
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			try {
				if (driver.findElement(By.xpath("//*[@text='Netmeds First Membership' and @nodeName='H2']|//*[@text='Explore Plans']")).isDisplayed()) {

					
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
		
				Thread.sleep(2000);
		
				driver.findElement(By.xpath("//*[@text='Netmeds First Membership' and @nodeName='H2']")).getText().equalsIgnoreCase("Netmeds First Membership");
				driver.findElement(By.xpath("//*[@text='Get special discounts and offers on Netmeds services.' and @nodeName='LI']")).getText().equalsIgnoreCase("Get special discounts and offers on Netmeds services.");
				driver.findElement(By.xpath("//*[@text='Get 2.5% NMS Cash on all orders.' and @nodeName='LI']")).getText().equalsIgnoreCase("Get 2.5% NMS Cash on all orders.");

driver.findElement(By.xpath("//*[@text='Explore Plans' and @nodeName='A']")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@text='Save more with exclusive membership' and @nodeName='H4']")).getText().equalsIgnoreCase("Save more with exclusive membership");
	driver.findElement(By.xpath("//*[@text='Recommended' and @nodeName='DIV']")).getText().equalsIgnoreCase("Recommended");
	driver.findElement(By.xpath("//*[@text='6 months' and @nodeName='DIV']")).getText().equalsIgnoreCase("6 months");
	driver.findElement(By.xpath("//*[@text='12 months' and @nodeName='DIV']")).getText().equalsIgnoreCase("12 months");
	
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
	}catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@text=' Add to Cart ' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Rs. 299']]]]")).click();
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
	}catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(5000);
	try {
		driver.findElement(By.xpath("//android.view.View[@text='REMOVE']|//*[@title='Remove item']")).click();
	} catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(3000);
	driver.navigate().back();
	Thread.sleep(5000);
	for (int i = 0; i < 10; i++) {

		
		Thread.sleep(3000);
		driver.swipe(0, 500, 0, 0, 1000);
		try {
			if (driver.findElement(By.xpath("//*[@text=' Add to Cart ' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Rs. 499']]]]")).isDisplayed()) {

				
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
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@text=' Add to Cart ' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Rs. 499']]]]")).click();
	try {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
	}catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(5000);
	for (int i = 0; i < 10; i++) {
		Thread.sleep(5000);
		if (!(driver.findElements(By.xpath("//*[@title='Remove item']")).size() == 0)) {

			Thread.sleep(5000);
					try {
						driver.findElement(By.xpath("//android.view.View[@text='REMOVE']|//*[@title='Remove item']")).click();
						driver.navigate().refresh();
					} catch (Exception e) {
						// TODO: handle exception
					}

		} else {
			//logger.log(Status.PASS, "Successfully Product Removed from Cart");
			break;

		}
	} 
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@nodeName='SPAN' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@nodeName='DIV' and ./*[@nodeName='DIV']]]]")).click();

	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@nodeName='INPUT']")).sendKeys(s);


		 
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@text='Patanjali Lauh Bhasm Powder 5 gm' and @nodeName='A']")).click();
	
	Thread.sleep(5000);

	 driver.swipe(0, 500, 0, 0, 1000);
	try {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text=' ADD TO CART ']")).click();
	
	}catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@text and @nodeName='SPAN' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='A']]]")).click();

	Thread.sleep(15000);

	//driver.findElement(By.xpath("//*[@text='Become Netmeds First Member' and @nodeName='H4']")).getText().equalsIgnoreCase("Become Netmeds First Member");
	//driver.findElement(By.xpath("//*[@text='Join membership to save much more! Exclusive offers designed for you']")).getText().equalsIgnoreCase("Join membership to save much more! Exclusive offers designed for you");

	WebElement findElement =  driver.findElement(By.xpath("//*[@nodeName='A' and (./preceding-sibling::* | ./following-sibling::*)[@text='Become Netmeds First Member']]|//android.view.View[@text='javascript:void(0)']"));
	findElement.click();
	TouchAction touchAction = new TouchAction(driver);


	//touchAction.tap(i-100,i1-100).perform();

	touchAction.tap(findElement).tap(findElement).perform();
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
	}catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@nodeName='DIV' and @width>0 and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Rs. 299']] and ./*[@text=' Add to Cart ' and @nodeName='BUTTON']]")).click();
	for (int i = 0; i < 10; i++) {

		
		Thread.sleep(3000);
		driver.swipe(82, 939, 82, 6, 1000);
		try {
			if (driver.findElement(By.xpath("//*[@id='cart_del_charge' and @nodeName='SPAN']")).isDisplayed()) {

				
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
	if ((driver.findElements(By.xpath("//*[@id='cart_del_charge' and @nodeName='SPAN']")).size()==0)) {
		
		System.out.println("delevery charge is not displayed");
	} else {
		
		System.out.println("delevery charge is displayed");
	}
for (int i = 0; i < 10; i++) {

		
		Thread.sleep(3000);
		driver.swipe(500, 500, 500, 1500, 1000);
		try {
			if (driver.findElement(By.xpath("//*[@id='cart_del_charge' and @nodeName='SPAN']")).isDisplayed()) {

				
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
	
	for (int i = 0; i < 16; i++) {
		Thread.sleep(3000);
		if ((driver.findElements(By.xpath("//*[@nodeName='A']")).size() == 0)) {
			try {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
			}catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(5000);
			try {
				driver.findElement(By.xpath("//android.view.View[@text='REMOVE']|//*[@title='Remove item']")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			//logger.log(Status.PASS, "Successfully Product Removed from Cart");
			break;

		}
	}
		
			/* btnclick(m.getAcountPage_logout());
			 Thread.sleep(5000);
			 btnclick(m.getLetsstarted());
			 popupclose();
			 popupclose();

				
				Thread.sleep(2000);
				m.getMobilenumber().sendKeys("9941004810");
				Thread.sleep(3000);
				btnclick(m.getUsepwd());
				Thread.sleep(5000);
			
				m.getPassword().sendKeys("netmeds2020");
				
				btnclick(m.getLogin());
				Thread.sleep(2000);
			
				Thread.sleep(10000);
				
		Thread.sleep(2000);
		btnclick(m.getGotocart()); 
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_no_result']")).size() == 0)) {

				try {
					btnclick(m.getRemoveButton());
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else {
				logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		}
		btnclick(m.getCart_search());
		Thread.sleep(2000);
	m.getSearchbarone().sendKeys(s);
		 
		 
		
	Thread.sleep(2000);
			btnclick(m.getSearch_drugname());
			Thread.sleep(5000);
			
			 driver.swipe(0, 500, 0, 0, 1000);
			try {
				Thread.sleep(3000);
			btnclick(m.getAddtoCartButton());
			}catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(5000);
			btnclick(m.getGotocart()); 
			Thread.sleep(5000);
			Thread.sleep(5000);
			driver.swipe(0, 900, 0, 0, 1000);
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			Thread.sleep(3000);
			driver.swipe(0, 500, 0, 0, 1000);
			String text1 = m.getCart_deliveryCharges().getText();
			String sss = text1.substring(1);
			System.out.println(ss);
			Assert.assertEquals("0.00", ss);*/
			Thread.sleep(3000);
		}
		  

}
