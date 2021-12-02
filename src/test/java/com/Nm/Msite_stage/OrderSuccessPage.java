package com.Nm.Msite_stage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

import com.Nm.Base.BaseClass;
import com.Nm.Base.MobileBaseClass;
import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.AndriodPom;
import com.Nm.Pom.Monepom;
import com.Nm.Pom.MsitePOM;
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

public class OrderSuccessPage extends MsiteBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		
		//@BeforeClass
		public void launchbrowser2()   {
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
			
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}


		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");//"c195de14"
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
			capabilities.setCapability(MobileCapabilityType.VERSION,"11 RP1A.200720.011" );
			//for m-site
			capabilities.setCapability("chromedriverExecutable", "D:\\Automation\\Driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
			//capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
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
	

	/*
	@BeforeMethod
	  public void setUp1() throws MalformedURLException {
	      System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Driver\\chromedriver.exe");
	      Map<String, String> mobileEmulation = new HashMap<String, String>();
	      mobileEmulation.put("deviceName", "Moto G4");

	      ChromeOptions chromeOptions = new ChromeOptions();
	      chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	      chromeOptions.addArguments("--disable-notifications");
	      driver = new ChromeDriver(chromeOptions);
	     
	     
	  }  */
//*******************************************************M3 Rx**********************************************************************//
	@Test (enabled = true)
	public void M3OrderSuccessPage() throws Throwable {

		logger = report.createTest("M3OrderSuccessPage");
		logger.log(Status.PASS, "*************M3OrderSuccessPage*******************");

		// Step1 :Launch Browser//
		
				MsitePOM m = new MsitePOM();
				//driver.manage().window().maximize();
				driver.get("https://m.netmeds.com/");
			/*	try {

				//	btnclick(m.getSignin());
					Thread.sleep(5000);
				
					Thread.sleep(3000);
				//	btnclick(m.getUsepwdbtn());
					Thread.sleep(3000);
				//	type(m.getPassword(), "test@123");
				//	btnclick(m.getSignInpage());
				//	Thread.sleep(3000);
					logger.log(Status.PASS, "Successfully navigate to home page");
				} catch (Exception e) {
					
					System.out.println("Already Logged in");
					
				}*/
				
				Thread.sleep(6000);
				
				popupclose() ;


		//Let's chat handle//
				letschat();
				Thread.sleep(5000);
						
		// Step 4 : Navigate to Mysubscription page//
				Thread.sleep(5000);
				btnclick(m.getMysubscriptionpage());
				Thread.sleep(5000);
				logger.log(Status.PASS, "Successfully navigate to mysubscriptionpage");
				System.out.println("Successfully navigate to mysubscriptionpage");
				
		//Let's chat handle//
				letschat();
				Thread.sleep(5000);	
		//create NewSubscription
				
				btnclick(m.getNewSubscription());

		// Step 6:Search Product//

				Thread.sleep(5000);
				for (int i = 0; i < 3; i++) {

					type(m.getM3productsearch(), MobileBaseClass.getExcelData("Rx", i, 0));
					
					logger.log(Status.PASS, "Successfully navigate to search result page");

		// Step 7 : Add product to the cart//
					try {
						Thread.sleep(5000);

						WebDriverWait wait = new WebDriverWait(driver, 30);
						WebElement Cart_btn = wait.until(
								ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='btn btn_to_cart m-0'])[1]|//android.view.View[@resource-id='app']/android.view.View[2]/android.view.View[2]/android.view.View[3]/android.view.View[4]/android.view.View/android.widget.Button")));

						Thread.sleep(5000);

						btnclick(Cart_btn);
						
						System.out.println("successfully Items are added");
					} catch (Exception e) {
						// TODO: handle exception
					}

					
			//Let's chat handle//
					letschat();
					
					Thread.sleep(5000);
		//Add to cart	
					btnclick(m.getAddtocart());
				}

				try {
				driver.findElement(By.xpath("//android.widget.TextView[@text='PROCEED']")).click();
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				
				driver.navigate().to("https://m.netmeds.com/checkout/cart/subscription");
				
				
				Thread.sleep(5000);
				logger.log(Status.PASS, "Successfully navigate to cartpage");

				driver.swipe(530, 1500, 530, 0, 1000);
				
		//driver.swipe(530, 1500, 530, 550, 1000);
				
				//Let's chat handle//
				letschat();

				// Step 13 : Click Proceed Button//
				Thread.sleep(5000);
				//driver.findElement(By.xpath("//*[@class='btn-checkout btn btn_to_checkout']|//android.widget.Button[@text='PROCEED']")).click();
				btnclick(m.getProceedtocheckout());
				Thread.sleep(5000);
				
				//driver.swipe(530, 1500, 530, 550, 1000);
				Thread.sleep(5000);

				//Let's chat handle//
						letschat();
	
		//Upload Prescription
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@text='Upload Prescription']|//android.widget.Button[@text='UPLOAD PRESCRIPTION']")).click();

				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//*[@class='ng-untouched ng-pristine ng-valid']|//android.widget.Button[@text='Choose files']")).click();
				
				Thread.sleep(3000);
				//driver.findElement(By.xpath("//android.widget.TextView[@text='Browse']")).click();
				
				Thread.sleep(3000);
//Switch to Native_App
				
				
		        Set<String> contextNames = driver.getContextHandles();
		        for (String strContextName : contextNames) {
		            if (strContextName.contains("NATIVE_APP")) {
		                driver.context("NATIVE_APP");
		                break;
		            }
		        }
			  
		        //
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("(//*[@id='bitmap_view'])[3]|(//android.widget.ImageView[@resource-id='com.android.chrome:id/bitmap_view'])[3]")).click(); //(//*[@knownSuperClass='android.widget.ImageView'])[5]")).click();
				
		        Thread.sleep(5000);
				  driver.findElement(By.id("done")).click();
				  
		        
		        //Switch to Chrome browser
		        Set<String> contextNames1 = driver.getContextHandles();
		        for (String strContextName : contextNames1) {
		            if (strContextName.contains("CHROMIUM")) {
		                driver.context("CHROMIUM");
		                break;
		            }
		        }
			  
			//driver.findElement(By.xpath("(//*[@resource-id='android:id/title'])[6]")).click();
				
				//Past Rx
				
				//driver.findElement(By.xpath("//android.view.View[@text='Past Rx']")).click();
				Thread.sleep(3000);
				driver.swipe(82, 1750, 82, 0, 1000);
				Thread.sleep(5000);
				
	//Actions action = new Actions(driver);	
//	WebElement Schedule =			driver.findElement(By.xpath("//android.widget.Button[@text='SCHEDULE DELIVERY']"));
	
	
	//action.moveToElement(Schedule).click();
				
				driver.findElement(By.xpath("//*[@text='Schedule Delivery']")).click();
				
				
		//driver.findElement(By.xpath("//android.view.View[@text='Repeat every 60 days']/android.widget.RadioButton")).click();
		
	//	Thread.sleep(3000);
	//	btnclick(m.getSelectduration30());
	//	Thread.sleep(3000);
	//	btnclick(m.getSelectduration60());
		Thread.sleep(3000);
		//logger.log(Status.PASS, "Successfully Proceed button  was clicked");

// Step 14 : Click Next Button//

		btnclick(m.getNextbutton());
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@class='action']|//android.widget.Button[@text='NEXT']")).click();
		
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully Next button was clicked");

		// Step 15: Click Subscribe//

	//	btnclick(m.getSubscribe());
		
		driver.swipe(530, 1440, 530, 0, 1000);
		Thread.sleep(3000);
		btnclick(m.getSubscribe());
		logger.log(Status.PASS, "Successfully Subscribe button was clicked");;
		

		// Step 16 : Ensure order is placed successfully//

				Thread.sleep(5000);

						String confirmation = driver.findElement(By.xpath("//*[@text='Order Placed Successfully!']|//android.view.View[@text='Order Placed Successfully!']")).getText(); 
						
						System.out.println(confirmation);

						
//			String	Status	=	driver.findElement(By.xpath("//android.view.View[@text='Order Placed Successfully!']/android.view.View[7]")).getText();
						//m.getOrder_Placed_text().getText();
						//
							//System.out.println(Status);
									String	Orderid	=	driver.findElement(By.xpath("//*[@text=' Order id - ']|//android.widget.Button[@text='VIEW REWARDS']/following-sibling::android.view.View[2]")).getText();

										System.out.println(Orderid);

										String order_status = driver.findElement(By.xpath("//*[@class='ordstatus']|//*[@text='CONSULTATION SCHEDULED']|//android.widget.Button[@text='VIEW REWARDS']/following-sibling::android.view.View[3]")).getText(); // m.getOrderid().getAttribute("innerText");

						System.out.println(order_status);
						
						String orderconfirmation = "Order Placed Successfully!";

						Assert.assertEquals(orderconfirmation, confirmation);

						System.out.println(confirmation + "and the id is " + Orderid);
						Thread.sleep(3000);
						driver.swipe(82, 1500, 82, 1420, 1000);
						
						Thread.sleep(3000);
						String	Deliverydate	=	driver.findElement(By.xpath("//*[@class='deldate']")).getText();

						System.out.println(Deliverydate);	
						
						Thread.sleep(3000);
						
						
			 driver.findElement(By.xpath("//*[@class='star']")).click();
						
			 Thread.sleep(3000);
			 
			 	btnclick(driver.findElement(By.xpath("//*[@class='star star-1 ng-star-inserted']")));
				Thread.sleep(2000);
				btnclick(driver.findElement(By.xpath("//*[@class='star star-2 ng-star-inserted']")));
				Thread.sleep(2000);
				btnclick(driver.findElement(By.xpath("//*[@class='star star-3 ng-star-inserted']")));
				Thread.sleep(2000);
				btnclick(driver.findElement(By.xpath("//*[@class='star star-2 ng-star-inserted']")));	
				Thread.sleep(2000);
				btnclick(driver.findElement(By.xpath("//*[@class='star star-1 ng-star-inserted']")));
				
				Thread.sleep(3000);	
				driver.findElement(By.xpath("//*[@text='SUBMIT FEEDBACK']")).click();
				// Tracking order//
				
				

			//	btnclick(m.getMysubscription());
				
			

			//	btnclick(m.getMedicineorders());
			
			Thread.sleep(3000);	
			driver.navigate().to("https://m.netmeds.com/customer/orderhistory");
				

				
			//Cancel Order			

			//Let's chat handle//
						letschat();
						
						Thread.sleep(5000);
				
						btnclick(m.getViewdetails());
						Thread.sleep(5000);
						
						//Switch to Native_App		
						 Set<String> contextNames4 = driver.getContextHandles();
					        for (String strContextName : contextNames4) {
					            if (strContextName.contains("NATIVE_APP")) {
					                driver.context("NATIVE_APP");
					                break;
					            }
					        }		
							
						
						 driver.swipe(82, 1600, 82, 0, 1000);
						Thread.sleep(3000);
						btnclick(m.getCancelorder());
						Thread.sleep(5000);
						driver.swipe(82, 939, 82, 6, 1000);
						Thread.sleep(5000);
						try{btnclick(m.getYesbutton());}
						catch (Exception e) {
							// TODO: handle exception
						}
						Thread.sleep(5000);
						btnclick(m.getCancel_reason());
						 Thread.sleep(3000);
						 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
			
				       
						logger.log(Status.PASS, "Successfully Order was Cancelled");
						System.out.println("Successfully Order was Cancelled");
						Thread.sleep(2000);
						driver.navigate().to("https://www.netmeds.com/customer/orderhistory");


		
	}	
//*****************	M1 Order Success page
	
	
	@Test(enabled = true)
				public void M1OrderSuccessPage() throws Throwable {
	
	
	
	logger = report.createTest("M1 Order Success Page");
	logger.log(Status.PASS, "*************M1 Order Success Page********************");
	
	
	// launch the browser
	
	
	// Step1 :Launch Browser//
	
	MsitePOM m = new MsitePOM();
	//driver.manage().window().maximize();
	driver.get("https://m.netmeds.com/");
/*	try {

	//	btnclick(m.getSignin());
		Thread.sleep(5000);
	
		Thread.sleep(3000);
	//	btnclick(m.getUsepwdbtn());
		Thread.sleep(3000);
	//	type(m.getPassword(), "test@123");
	//	btnclick(m.getSignInpage());
	//	Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to home page");
	} catch (Exception e) {
		
		System.out.println("Already Logged in");
		
	}*/
	
	Thread.sleep(6000);
	
	popupclose() ;


//Let's chat handle//
	letschat();
	Thread.sleep(5000);
		  
		  Thread.sleep(10000);
			String s="Patanjali Lauh Bhasm Powder 5 gm";
	Thread.sleep(2000);
	
	
	//remove from the cart
	
	
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
	Thread.sleep(5000);
	
	
	
	//search the page
	
	
	
	driver.findElement(By.xpath("//*[@text='Search for medicine & wellness products...' and @nodeName='SPAN']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@name='q']")).sendKeys( "Patanjali Lauh Bhasm Powder 5 gm");
	Thread.sleep(1500);
	driver.pressKeyCode(AndroidKeyCode.ENTER);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@text and @nodeName='DIV' and ./parent::*[@nodeName='A' and (./preceding-sibling::* | ./following-sibling::*)[@nodeName='DIV']]]")).click();
	// btncli(m.getSearchIcon());
	logger.log(Status.PASS, "Successfully navigate to search result page" );

	
	//add to the cart
	
	Thread.sleep(3000);
	 driver.swipe(0, 500, 0, 0, 1000);
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@text=' ADD TO CART ']")).click();
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000);
		
		//add the product
		
		driver.findElement(By.xpath("//*[@text and @nodeName='SPAN' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='A']]]")).click();
		logger.log(Status.PASS, "Successfully navigate to cart page" );
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@text='Proceed']")).click();
		logger.log(Status.PASS, "Successfully navigate to search order review page" );
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
		}catch (Exception e) {
			// TODO: handle exception
		}


		

Thread.sleep(3000);
//driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
//touchAction.tap(i-100,i1-100).perform();
driver.findElement(By.xpath("//*[@text='Pay']")).click();
Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);
Thread.sleep(3000);
MobileElement cod = (MobileElement) driver.findElement(By.xpath("//*[@id='nms_cod' and @name='nmsmstr_paymethod']"));cod.click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text and @nodeName='BUTTON']")).click();
Thread.sleep(5000);
driver.swipe(0, 900, 0, 0, 1000);
/*Thread.sleep(3000);
driver.swipe(0, 900, 0, 0, 1000);*/


//Step 16 : Ensure order is placed successfully//

Thread.sleep(5000);

		String confirmation = driver.findElement(By.xpath("//*[@text='Order Placed Successfully!']|//android.view.View[@text='Order Placed Successfully!']")).getText(); 
		
		System.out.println(confirmation);

					String	Orderid	=	driver.findElement(By.xpath("//*[@text=' Order id - ']|//android.widget.Button[@text='VIEW REWARDS']/following-sibling::android.view.View[2]")).getText();

						System.out.println(Orderid);

						String order_status = driver.findElement(By.xpath("//*[@class='ordstatus']|//*[@text='CONSULTATION SCHEDULED']|//android.widget.Button[@text='VIEW REWARDS']/following-sibling::android.view.View[3]")).getText(); // m.getOrderid().getAttribute("innerText");

		System.out.println(order_status);
		
		String orderconfirmation = "Order Placed Successfully!";

		Assert.assertEquals(orderconfirmation, confirmation);

		System.out.println(confirmation + "and the id is " + Orderid);
		Thread.sleep(3000);
		driver.swipe(82, 1500, 82, 1420, 1000);
		
		Thread.sleep(3000);
		String	Deliverydate	=	driver.findElement(By.xpath("//*[@class='deldate']")).getText();

		System.out.println(Deliverydate);	
		
		Thread.sleep(3000);
		
		
driver.findElement(By.xpath("//*[@class='star']")).click();
		
Thread.sleep(3000);

	btnclick(driver.findElement(By.xpath("//*[@class='star star-1 ng-star-inserted']")));
Thread.sleep(2000);
btnclick(driver.findElement(By.xpath("//*[@class='star star-2 ng-star-inserted']")));
Thread.sleep(2000);
btnclick(driver.findElement(By.xpath("//*[@class='star star-3 ng-star-inserted']")));
Thread.sleep(2000);
btnclick(driver.findElement(By.xpath("//*[@class='star star-2 ng-star-inserted']")));	
Thread.sleep(2000);
btnclick(driver.findElement(By.xpath("//*[@class='star star-1 ng-star-inserted']")));


driver.findElement(By.xpath("//*[@text='SUBMIT FEEDBACK']")).click();

Thread.sleep(3000);

//Subscribe Now

driver.swipe(82, 1602, 82, 0, 1000);

Thread.sleep(3000);

//driver.findElement(By.xpath("//*[@class='subscribe']"));

Thread.sleep(3000);

//Subscribe now

		m.getSubscribe_now().click();
		
		Thread.sleep(3000);
		
		String Refill = ((m.getRefill_msg()).getAttribute("innerText"));
		System.out.println(Refill);
		Assert.assertTrue((Refill).contains("Get medicine refill’s delivered on the set duration of every month") );
		
		//WebElement time_period =
		driver.findElement(By.xpath("//*[@class='mat-select-value' and @top='true']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='mat-option-text' and @top='true'])[2]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@class='ng-tns-c17-4 ng-star-inserted' and @top='true']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[@class='mat-option-text' and @top='true'])[2]")).click();
		
		
		
		
		Assert.assertEquals((m.getPaymentmode_text().getAttribute("innerText")),"Payment Mode");
		
		System.out.println((m.getPaymentmode_text().getAttribute("innerText")));
		
		Assert.assertEquals((m.getPaymentmethod_text().getAttribute("innerText")),"Online Payment / COD");
		
		System.out.println(m.getPaymentmethod_text().getAttribute("innerText"));
		
	
		Assert.assertEquals((m.getPromocode().getAttribute("innerText")),"Promo Code");
		
		System.out.println(m.getPromocode().getAttribute("innerText"));
		
		Assert.assertEquals(m.getPromo_percentage().getAttribute("innerText"),"20% Off Applied to all order plus last month free medicine");
		
		System.out.println(m.getPromo_percentage().getAttribute("innerText"));
		
		Assert.assertEquals((m.getModify_or_reschedule().getAttribute("innerText")),"You can modify or reschedule the subsequent orders later.");
		
		System.out.println(m.getModify_or_reschedule().getAttribute("innerText"));
		
		Thread.sleep(3000);
		
		driver.swipe(0, 1790, 0, 1550, 1000);
		
	btnclick(m.getEnableSubscription());
	
	//Order cancellation
		
	Thread.sleep(3000);	
	driver.navigate().to("https://m.netmeds.com/customer/orderhistory");
		

		
	//Cancel Order			

	//Let's chat handle//
				letschat();
				
				Thread.sleep(5000);
		
				btnclick(m.getViewdetails());
				letschat();
				Thread.sleep(5000);
				
				//Switch to Native_App		
				 Set<String> contextNames4 = driver.getContextHandles();
			        for (String strContextName : contextNames4) {
			            if (strContextName.contains("NATIVE_APP")) {
			                driver.context("NATIVE_APP");
			                break;
			            }
			        }		
					
				
				 driver.swipe(82, 1600, 82, 0, 1000);
				Thread.sleep(3000);
				btnclick(m.getCancelorder());
				Thread.sleep(5000);
				driver.swipe(82, 939, 82, 6, 1000);
				Thread.sleep(5000);
				try{btnclick(m.getYesbutton());}
				catch (Exception e) {
					// TODO: handle exception
				}
				Thread.sleep(5000);
				btnclick(m.getCancel_reason());
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
	
		       
				logger.log(Status.PASS, "Successfully Order was Cancelled");
				System.out.println("Successfully Order was Cancelled");
				Thread.sleep(2000);
				driver.navigate().to("https://www.netmeds.com/customer/orderhistory");

}
		
//********************************M2 Order Success page
		
		
		
		 @Test(enabled = true)
		  public void laucnh() throws Throwable {
			  
			  driver.get("https://m.netmeds.com/");
			 // driver.manage().window().maximize();
			  MsitePOM m = new MsitePOM();
			  Thread.sleep(10000);
			 // driver.findElement(By.xpath("//android.view.View[@text()='INTRODUCING NETMEDS LITE']/preceding-sibling::android.view.View[@index='0']")).click();
			  try {

			  driver.findElement(By.xpath("//*[@class='app_close']")).click();
				//  m.getMsite_HomeScreen_POP_UP().click();

			//  driver.findElement(By.xpath("//android.view.View[@text='✕']")).click();

			  }catch (Exception e) {
				// TODO: handle exception
			}
			  
			  Thread.sleep(10000);

			  m.getMsite_OrderNow().click();

			  letschat();


			  letschat();
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='UPLOAD PRESCRIPTION']|//*[@text='Upload Prescription']")).click();
			//  m.getMsite_Upload_Prescription().click();
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='Choose Files']|//*[@css='INPUT.ng-untouched.ng-pristine.ng-valid']")).click();
			//  m.getMsite_Upload_Gallery().click();
			  Thread.sleep(5000);
		//	  driver.findElement(By.xpath("(//*[@knownSuperClass='android.widget.ImageView'])[5]")).click();//"(//*[@id='bitmap_view'])[3]|(//android.widget.ImageView[@resource-id='com.android.chrome:id/bitmap_view'])[3]")).click();
			// Auto IT Script
				
			  //Switch to Native_App
		        Set<String> contextNames = driver.getContextHandles();
		        for (String strContextName : contextNames) {
		            if (strContextName.contains("NATIVE_APP")) {
		                driver.context("NATIVE_APP");
		                break;
		            }
		        }
			  
		        //
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("(//*[@id='bitmap_view'])[3]|(//android.widget.ImageView[@resource-id='com.android.chrome:id/bitmap_view'])[3]")).click(); //(//*[@knownSuperClass='android.widget.ImageView'])[5]")).click();
				
		        Thread.sleep(5000);
				  driver.findElement(By.id("done")).click();
				  
		        
		        //Switch to Chrome browser
		        Set<String> contextNames1 = driver.getContextHandles();
		        for (String strContextName : contextNames1) {
		            if (strContextName.contains("CHROMIUM")) {
		                driver.context("CHROMIUM");
		                break;
		            }
		        }
	
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("(//*[@css='INPUT.m2checkbox.ng-untouched.ng-pristine.ng-valid'])[1]|//android.widget.RadioButton[@text='Search and Add medicines']")).click();
		//	m.getMsite_M2_searchMedicine().click();  


			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//*[@text='Continue']|//android.widget.Button[@text='CONTINUE']")).click();
		//	m.getMsite_M2_SearcCall_ContinueButton().click();  
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//*[@css='INPUT.ais-SearchBox-input']")).sendKeys("Telma");
			 
			 Thread.sleep(2000);
			 driver.hideKeyboard();
			 
			 
			 
			 Thread.sleep(5000);
			  driver.findElement(By.xpath("(//*[@css='BUTTON.btn.btn_to_cart.m-0'])[1]|/hierarchy/android.widget.FrameLayout/"
			  		+ "android.widget.LinearLayout/android.widget.FrameLayout/"
			  		+ "android.widget.FrameLayout/android.widget.FrameLayout/"
			  		+ "android.view.ViewGroup/android.widget.FrameLayout[1]/"
			  		+ "android.widget.FrameLayout[2]/android.webkit.WebView/"
			  		+ "android.view.View/android.view.View[2]/android.view.View[2]/"
			  		+ "android.view.View[5]/android.view.View[4]/android.widget.Button")).click();
			  
			  
			 Thread.sleep(5000);
			  driver.findElement(By.xpath("//*[@text=' Add to Cart ']|//android.widget.Button[@text='ADD TO CART']")).click();
			  
			 
			 Thread.sleep(5000);
			  driver.findElement(By.xpath("//*[@text='Proceed']|//android.widget.Button[@text='PROCEED']")).click();
			  
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//*[@text='Confirm Order']|//*[@text='Confirm Order' and @top='true']")).click();
	 
			 Thread.sleep(3000);
				
			//Order Success Page
						 
		letschat();

		System.out.println(driver.findElement(By.xpath("//*[@text='Order Placed Successfully!']")).getText());
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.xpath("//*[@class='ordstatus']")).getText());
		
		Thread.sleep(3000);
		driver.swipe(0, 1400, 0, 0, 1000);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Consult Now']")).click();
		
		driver.navigate().to("https://www.netmeds.com/customer/orderhistory");
		
		//Let's chat handle//
		letschat();
		
		Thread.sleep(5000);
		
		

		
		
       
		
	//	driver.findElement(By.xpath("//*[@class='btn-view ord-btn']|//android.widget.Button[@text='VIEW DETAILS']")).click();
		btnclick(m.getViewdetails());
		Thread.sleep(5000);
		
		//Switch to Native_App		
		 Set<String> contextNames4 = driver.getContextHandles();
	        for (String strContextName : contextNames4) {
	            if (strContextName.contains("NATIVE_APP")) {
	                driver.context("NATIVE_APP");
	                break;
	            }
	        }		
			
		
		 driver.swipe(82, 1600, 82, 0, 1000);
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@text='Cancel Order']|//android.widget.Button[@text='CANCEL ORDER']")).click();
		btnclick(m.getCancelorder());


		Thread.sleep(5000);
//
		driver.swipe(82, 939, 82, 6, 1000);
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@text='YES']|//android.widget.Button[@text='YES']")).click();
		try{btnclick(m.getYesbutton());}
		catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@text='Delay in delivery ']")).click();
		
		
//		
		
		
//Switch to Chrome browser
        Set<String> contextNames5 = driver.getContextHandles();
        for (String strContextName : contextNames5) {
            if (strContextName.contains("CHROMIUM")) {
                driver.context("CHROMIUM");
                break;
            }
            	
         //   btnclick(m.getCancel_reason());
			Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
		//logger.log(Status.PASS, "Successfully Order was Cancelled");
		System.out.println("Successfully Order was Cancelled");
		Thread.sleep(2000);
		driver.navigate().to("https://www.netmeds.com/customer/orderhistory");
		
		Thread.sleep(3000);	
		driver.navigate().to("https://m.netmeds.com/customer/orderhistory");
			

			
		//Cancel Order			

		//Let's chat handle//
					letschat();
					
					Thread.sleep(5000);
			
					btnclick(m.getViewdetails());
					Thread.sleep(5000);
					
					//Switch to Native_App		
					 Set<String> contextNames51 = driver.getContextHandles();
				        for (String strContextName5 : contextNames51) {
				            if (strContextName.contains("NATIVE_APP")) {
				                driver.context("NATIVE_APP");
				                break;
				            }
				        }		
						
					
					 driver.swipe(82, 1600, 82, 0, 1000);
					Thread.sleep(3000);
					btnclick(m.getCancelorder());
					Thread.sleep(5000);
					driver.swipe(82, 939, 82, 6, 1000);
					Thread.sleep(5000);
					try{btnclick(m.getYesbutton());}
					catch (Exception e) {
						// TODO: handle exception
					}
					Thread.sleep(5000);
					btnclick(m.getCancel_reason());
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
		
			       
					logger.log(Status.PASS, "Successfully Order was Cancelled");
					System.out.println("Successfully Order was Cancelled");
					Thread.sleep(2000);
					driver.navigate().to("https://www.netmeds.com/customer/orderhistory");



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
				
		 //     driver.quit();
			}


		}
