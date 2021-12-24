package com.Nm.Andriod_prod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MobileBaseClass;
import com.Nm.Pom.AndriodPom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class AlternateProduct extends MobileBaseClass {
	
	

	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.UDID, UDID); //RZ8R20GLXTA //GBT4C19326001968
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
	//		capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//Moneflow.html");
       
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
	
	
	@Test
	public void alterPro() throws Throwable {
		

		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		AndriodPom m = new AndriodPom();
		
		Thread.sleep(10000);
		popupclose();
		popupclose();
		try {
			Thread.sleep(2000);
			btnclick(m.getLetsstarted());
			Thread.sleep(10000);
			driver.hideKeyboard();
		} catch (Exception e) {
			driver.launchApp();
		}
		
		
		popupclose();
		popupclose();
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys(" ");
			Thread.sleep(3000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys(" ");
			
			btnclick(m.getLogin());
			Thread.sleep(2000);
		}catch(Exception e) {
				System.out.println("Already logged in");
			}
		Thread.sleep(10000);
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
		Thread.sleep(5000);
		btnclick(m.getCart_search());
		Thread.sleep(2000);
		
		
		Thread.sleep(3000);
		Thread.sleep(2000);
		m.getSearchbarone().sendKeys("Trajenta 5mg Tablet 10");
		
		Thread.sleep(5000);
		driver.hideKeyboard();
		
		Thread.sleep(5000);

		Thread.sleep(2000);
				btnclick(m.getSearch_drugname());
				Thread.sleep(5000);
				
				Thread.sleep(3000);
				for (int i = 0; i < 10; i++) {
					Thread.sleep(2000);
					driver.swipe(0, 1000, 0, 0, 1000);
					Thread.sleep(2000);
					if (m.getPDP_AlternateBrand_TextList().size()==1) {
						System.out.println("Swipe down to check Alternate  Brand");
						break;
					} else {

					}
				}
				Thread.sleep(2000);
			//	driver.swipe(0, 800, 0, 0, 1000);
				
				
				Thread.sleep(2000);
			//	driver.swipe(0, 800, 0, 0, 1000);
				
				Thread.sleep(3000);
				if (m.getPDP_AlternateBrand_Text().isDisplayed()) {
					
					Thread.sleep(2000);
					List<WebElement> CART_SIZE = driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn"));
					int aa = CART_SIZE.size();
					
					btnclick(CART_SIZE.get(aa-1));
					
					Thread.sleep(3000);
					String abText = gettext(m.getPDP_AlternateBrand_Name());
					
					Thread.sleep(3000);
					btnclick(m.getPDP_Cart_btn());
					
					
					Thread.sleep(5000);
					String cart_drug = gettext(m.getCart_drug_name());
					
					Thread.sleep(2000);
					if (abText.contains(cart_drug)) {
						
						System.out.println("Alternate Brand Added to  the Cart Successfully");
						
					} else {

						System.out.println("Alternate Brand Not  Added to  the Cart Successfully");
						
					}
					
				} else {
					
					System.out.println("There is no Alternate brand Available");

				}
				
/////////////////////////////////////////
		// Most Selling Product
		Thread.sleep(3000);
		Thread.sleep(3000);
		for (int i = 0; i < 10; i++) {
			Thread.sleep(2000);
			driver.swipe(0, 800, 0, 0, 1000);
			Thread.sleep(2000);
			if (m.getMost_Selling_text_List().size()==1) {
				System.out.println("Swipe down to check Most Selling  Brand");
				break;
			} else {

			}
		}
		Thread.sleep(2000);
//	/	driver.swipe(0, 1000, 0, 0, 1000);
		
		Thread.sleep(2000);
		if (m.getMost_Selling_text().isDisplayed()) {
			
			Thread.sleep(3000);
			System.out.println(m.getAdd_To_cart_List().size());
			
			Thread.sleep(3000);
			btnclick(m.getAdd_To_cart_List().get(0));
			
			Thread.sleep(3000);
			btnclick(m.getMostSelling_drug_name_List().get(1));
			
			Thread.sleep(5000);
			btnclick(m.getAdd_To_cart());
			
			
			Thread.sleep(2000);
			btnclick(m.getPDP_ProceedToCart());
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		


	}
	

}
