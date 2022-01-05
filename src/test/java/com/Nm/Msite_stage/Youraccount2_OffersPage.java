package com.Nm.Msite_stage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Base.BaseClass;
import com.Nm.Base.MobileBaseClass;
import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.AndriodPom;
import com.Nm.Pom.Monepom;
import com.Nm.Pom.MsitePOM;
import com.Nm.Website_live.RetryAnalyzer;
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

public class Youraccount2_OffersPage extends MsiteBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		
		public void launchbrowser()   {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			//capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA"); //RZ8R20GLXTA //GBT4C19326001968

		//	capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");  //fc95d519 //RZ8R20GLXTA

			capabilities.setCapability("platformName", "Android");
		//	capabilities.setCapability("deviceName", "vivo 1819");
		//	capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			/*capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			*/
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE ,"com.android.chrome");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY ,"com.google.android.apps.chrome.Main");
			capabilities.setCapability("noReset", true);
			
			capabilities.setCapability("autoDismissAlerts", true);  
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("newCommandTimeout", 100);
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


	
	// **************************************************************offers
		// page*************************************************************************************//

		@Test(enabled = true)
		public void offersPage() throws Throwable {

			logger = report.createTest("Offers Page");
			logger.log(Status.PASS, "*************Offers Page********************");

			//Step1 :Launch Browser//		
			MsitePOM m = new MsitePOM();
			//driver.manage().window().maximize();
			driver.get("https://m.netmeds.com/");
			driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);
			try {

			//	btnclick(m.getSignin());
				Thread.sleep(5000);
			//	type(m.getMobileno(), "8072281468");
				Thread.sleep(5000);
			//	btnclick(m.getUsepwdbtn());
				Thread.sleep(5000);
			//	type(m.getPassword(), "test@123");
			//	btnclick(m.getSignInpage());
			//	Thread.sleep(5000);
				logger.log(Status.PASS, "Successfully navigate to home page");
			} catch (Exception e) {
				
				System.out.println("Already Logged in");
				
			}
			
			Thread.sleep(5000);
			popupclose();



			
			
		

					driver.findElement(By.xpath("//*[@class='counter']")).click();
					Thread.sleep(5000);
					
					
					//Let's chat handle//
					Thread.sleep(5000);
					letschat();
					Thread.sleep(3000);
				//	driver.swipe(82, 1275, 82, 1152, 1000);
					//Switch to Native_App
					
					
			        Set<String> contextNames = driver.getContextHandles();
			        for (String strContextName : contextNames) {
			            if (strContextName.contains("NATIVE_APP")) {
			                driver.context("NATIVE_APP");
			                break;
			            }
			        }
					for (int i = 0; i < 16; i++) {
						Thread.sleep(3000);
						if (!(driver.findElements(By.xpath("//*[@text='REMOVE']")).size() == 0)) {
							

							try {
	
								Thread.sleep(3000);
								driver.findElement(By.xpath("//*[@text='REMOVE']")).click();
								
								Thread.sleep(3000);
								logger.log(Status.PASS, "Items are removed successfully");
								System.out.println("Items are removed from the cart");
							} catch (Exception e) {
								System.out.println("No items in the cart ");
							}

						} else {
							break;

						}

					}
					 //Switch to Chrome browser
			        Set<String> contextNames1 = driver.getContextHandles();
			        for (String strContextName : contextNames1) {
			            if (strContextName.contains("CHROMIUM")) {
			                driver.context("CHROMIUM");
			                break;
			            }
			        }			
					driver.navigate().back();
					
					//Step 3 : Navigate to user profile//

					//btnclick(m.getUserprofile());
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@text='Account']")).click();
					Thread.sleep(3000);
					logger.log(Status.PASS, "Successfully navigate to userprofile");
					System.out.println("Successfully navigate to userprofile");



			//Let's chat handle//
			Thread.sleep(5000);
		letschat();
				
	//Step 4 : Offers Page
				Thread.sleep(3000);
				btnclick(driver.findElement(By.xpath("//*[@text='Offers ']")));
				Thread.sleep(3000);
				
	//Medicine
				
				driver.findElement(By.xpath("(//*[@class='offer_sub_img'])[1]")).click();
				Thread.sleep(3000);
		String couponcode =		driver.findElement(By.xpath("(//*/*/*[@nodeName='P' and (./preceding-sibling::* | ./following-sibling::*)[@nodeName='H3'] and ./parent::*[@nodeName='DIV']])[1]")).getText();
		
			driver.findElement(By.xpath("//*[@text=' COPY CODE ']")).click();
			
			
			
		//	driver.findElement(By.xpath("//android.widget.TextView[@text='GO TO SEARCH']"));
			
			
				Thread.sleep(3000);
				
					
					type(driver.findElement(By.xpath("//*[@class='input-text aa-input']")),"Duphaston 10mg Tablet 10'S" );

					// btncli(m.getSearchIcon());
					logger.log(Status.PASS, "Successfully navigate to search result page");

				//	String Cart_Excel = BaseClass.getExcelData("Otcandnonrx", i, 1);

					// Step 7 : Add product to the cart//
					try {
						Thread.sleep(5000);

						WebDriverWait wait = new WebDriverWait(driver, 30);
						WebElement Cart_btn = wait.until(
								ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='search-cartbtn toCart addtocartbtn prodbtn addtocartdirctbtn']")));

						Thread.sleep(5000);

						btnclick(Cart_btn);
						
						System.out.println("successfully Items are added");
					} catch (Exception e) {
						// TODO: handle exception
					}
		
		Thread.sleep(3000);	
					
		driver.navigate().to("https://m.netmeds.com/checkout/cart");
		Thread.sleep(3000);
		
		//Let's chat handle//
		Thread.sleep(5000);
		letschat();   
		try{
		driver.swipe(82, 1300, 82, 450, 1000);	
		
		driver.swipe(82, 1300, 82, 450, 1000);	
		}catch (Exception e) {
			driver.swipe(0, 1300, 0, 450, 1000);	
			
			driver.swipe(0, 1300, 0, 450, 1000);
		}
		
		
	//Apply Promo
	if ((driver.findElements(By.xpath("//*[@class='discountamt ng-star-inserted']"))).size()!=0) {
				
	//remove code 
			
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='arricon']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='apply-coupon']")).click();
				Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@css='BUTTON.close']")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='arricon']")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='cpninput' and @top='true']")).sendKeys(couponcode);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='apply-coupon' and @top='true']")).click();
			}catch (Exception e) {
				
				//driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/chk_apply_promo_code")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@css='BUTTON.close']")).click();
				
			}
			
			
		}
		else  {
			
		
		
		
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='arricon']")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='cpninput' and @top='true']")).sendKeys(couponcode);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='apply-coupon' and @top='true']")).click();
		
		
		Thread.sleep(3000);  
		
		
		
}	
	
	driver.navigate().to("https://m.netmeds.com/offers");
//Diagonstics	
		
		driver.findElement(By.xpath("//*[@href='#diagnostics']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@class='offer_sub_img'])[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@text=' Book Now ']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Successfully navigated to diagonistics page");
		
		driver.navigate().back();
		
		
//Consultation
		
	driver.navigate().to("https://m.netmeds.com/offers");
		

		Thread.sleep(3000);
	//	btnclick(m.getOffers_page());
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@href='#consultation']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@class='offer_sub_img'])[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@text=' Consult Now ']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Successfully navigated to consultation page");
		
		driver.navigate().back();
		
		
		System.out.println("Offer Page is working properly");
		
				
		
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
				
		 //     driver.quit();
			}


		}
