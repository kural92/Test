 package com.Nm.Msite_stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Msite_Search extends MsiteBaseClass{
	


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
			//capabilities.setCapability(MobileCapabilityType.VERSION,"11 RP1A.200720.011" );
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
	public void searchPage() throws Throwable {
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		MsitePOM m = new MsitePOM();
		
		 driver.get("http://m.netmeds.com");
		  driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);

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
				
				Thread.sleep(5000);
				 driver.get("http://m.netmeds.com");
				//btnclick(m.getFooter_HomePage());
				
				
				Thread.sleep(3000);
				btnclick(m.getHeader_SearchBar());
				Thread.sleep(5000);
			//	type(m.getHeader_SearchBar(), "Gemer 2mg");
				m.getHeader_SearchBar().sendKeys("Gemer 2mg");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='search-text search-bg']")).click();
				//m.getHeader_SearchBar().sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				
				
				
				driver.hideKeyboard();
				
				Thread.sleep(5000);
				int a = m.getSearch_results().size();
				System.out.println(a+" : are the search result displayed in front to see more please scroll down");
				
				Thread.sleep(5000);
				for (int i = 0; i <a; i++) {
					Thread.sleep(5000);
					String det = m.getSearch_results().get(i).getText();
					System.out.println(det);
					
					try {
					String cate = m.getSearch_results_category_List().get(i).getText();
					System.out.println(cate);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
					String Drug = m.getSearch_results_Drug_List().get(i).getText();
					System.out.println(Drug);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
					String Deta = m.getSearch_results_Detail_List().get(i).getText();
					System.out.println(Deta);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					
				
				} 
				
				Thread.sleep(3000);
				btnclick(m.getMsite_Search_AddToCart());
				
				
				Thread.sleep(3000);
				for (int j = 0; j < 10; j++) {

					Thread.sleep(3000);
					btnclick(m.getSearch_results_AddTocart_IncreaseQty());
					
					
				}
				
				Thread.sleep(3000);
				for (int j = 0; j < 11; j++) {

					Thread.sleep(3000);
					btnclick(m.getSearch_results_AddTocart_DecreaseQty());
					
					
				}
				
				
				Thread.sleep(3000);
				btnclick(m.getSearch_results_Drug());
				
				
				Thread.sleep(5000);
				btnclick(m.getPDP_Search_btnn());
				
				Thread.sleep(3000);
				type(m.getHeader_SearchBar() , "Telma");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='search-text search-bg']")).click();
				//m.getSearchBar().sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				btnclick(m.getMsite_Search_AddToCart());
				
				Thread.sleep(3000);
				btnclick(m.getPDP_Cart_btn());
				
				Thread.sleep(3000);
				btnclick(m.getPDP_Search_btnn());
				
				Thread.sleep(3000);
				type(m.getSearchBar(), "Dolo");
				
				Thread.sleep(3000);
				btnclick(m.getSearch_results_Drug());
				
				Thread.sleep(3000);
				btnclick(m.getPDP_Manufacture_name());
				
				Thread.sleep(3000);
				btnclick(m.getPDP_Search_btnn());

		

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
		    
		    
	 }
			


		@AfterTest
		private void quitbrowser() {
			report.flush();
			
	 //     driver.quit();
		}

}
