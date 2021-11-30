package com.Nm.Msite_stage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Msite_Cols_Storage extends MsiteBaseClass{
	
	

	

	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		
		
		@BeforeClass
		public void launchbrowser2()   {
			DesiredCapabilities capabilities = new DesiredCapabilities();

		    capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE ,"com.android.chrome");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY ,"com.google.android.apps.chrome.Main");
			capabilities.setCapability("noReset", true);			
			capabilities.setCapability("autoDismissAlerts", true);  			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(MobileCapabilityType.VERSION,"11 RP1A.200720.011" );
			capabilities.setCapability("chromedriverExecutable", "D:\\Automation\\Driver\\chromedriver.exe");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
			capabilities.setCapability("noReset", true);
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);						
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage()); 
			}				
		}
		
		
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//AlternateBrand.html");
    report = new ExtentReports();
      report.attachReporter(htmlReporter);
       report.setSystemInfo("Host name", "localhost");
       report.setSystemInfo("Environemnt", "QA");
       report.setSystemInfo("user", "Automation Team");

       htmlReporter.config().setDocumentTitle("Extent Report ");
       htmlReporter.config().setReportName("NetMeds.com");

       //htmlReporter.config().setTheme(Theme.STANDARD);
   	
   }
	
	
	@Test
	public void cold_Storage() throws Throwable {
		
		
		logger =  report.createTest("Cash On Delivery Logic");
		logger.log(Status.PASS, "COD Processing Order" );
		
		MsitePOM m = new MsitePOM();
		
		 driver.get("http://m.netmeds.com");
	        

	        Thread.sleep(10000);
			  try {
			  driver.findElement(By.xpath("//span[@class='app_close'] | //*[@class='app_close']")).click();
			  }catch (Exception e) {
				// TODO: handle exception
			}			  	  
			  // Remove From Cart
				driver.navigate().to("https://m.netmeds.com/checkout/cart");
				for (int i = 0; i < 10; i++) {
					Thread.sleep(10000);
					letschat();
					Thread.sleep(2000);
					if (!(driver.findElements(By.xpath("//*[@title='Remove item']")).size() == 0)) {

						Thread.sleep(5000);
						try {
							driver.findElement(By.xpath("//android.view.View[@text='REMOVE']|//*[@title='Remove item']")).click();
						} catch (Exception e) {
							// TODO: handle exception
						}

					} else {
						System.err.println("Successfully Product Removed from Cart");
						break;

					}
				} 
				
				//////
				Thread.sleep(5000);
				driver.get("https://m.netmeds.com");
				

				Thread.sleep(3000);
				String aa = "Boostrix Injection";
				String [] spl = aa.split(",");
				System.out.println(spl.length);
				
				Thread.sleep(3000);
				btnclick(m.getHeader_SearchBar());
				Thread.sleep(5000);
				//type(m.getSearchBar(), spl[i]);
				m.getHeader_SearchBar().sendKeys(aa);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='search-text search-bg']")).click();
				//m.getHeader_SearchBar().sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				
				Thread.sleep(5000);
				
				driver.hideKeyboard();

				Thread.sleep(2000);
				//btnclick(m.getMsite_SearchResult_drugName());
		btnclick(m.getMsite_Search_Results().get(0));
		
				Thread.sleep(10000);
			
				Thread.sleep(3000);
				String ab = "600055,600100,180001";
				String [] spll = aa.split(",");
				System.out.println(spll.length);
				Thread.sleep(2000);
				btnclick(m.getPDP_CheckAvailabilty_btn());
				
				Thread.sleep(2000);
				//	driver.hideKeyboard();
					
for (int i = 0; i < spll.length; i++) {
	

					Thread.sleep(2000);
					type(m.getPDP_ColdStorage_PinCheck(), spll[i]);
					

					Thread.sleep(3000);
					btnclick(m.getPDP_CheckAvailabilty_CheckBtn());
					
					Thread.sleep(2000);
//					System.out.println(m.getPDP_Colstorage_DeliveryError().getText());
					

					Thread.sleep(2000);
					m.getPDP_ColdStorage_PinCheck().clear();
					
					Thread.sleep(2000);
}

	}
				
}
