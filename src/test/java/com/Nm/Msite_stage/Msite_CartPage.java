package com.Nm.Msite_stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

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
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Msite_CartPage extends MsiteBaseClass {
	/*  private String reportDirectory = "reports";
	    private String reportFormat = "xml";
	    private String testName = "Untitled";
	    protected AndroidDriver<AndroidElement> driver = null;

	    DesiredCapabilities dc = new DesiredCapabilities();
	    
	    @BeforeTest
	    public void setUp() throws MalformedURLException {
	        dc.setCapability("reportDirectory", reportDirectory);
	        dc.setCapability("reportFormat", reportFormat);
	        dc.setCapability("testName", testName);
	        dc.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA");
	        dc.setBrowserName(MobileBrowserType.CHROMIUM);
	        dc.setCapability("noReset", true);
	        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
	        driver.setLogLevel(Level.INFO);
	         }
	 
	        */
	

static String totalamt;
	
static String mrp;
String dlcharge ;

Float delcharge;
Float 	Netcharge;
String discount;

String additional_discount;
String savings;

Float total_discount;
@SuppressWarnings("removal")
Float Additional_total_discount = new Float(0);
Float total_savings;
String Nmswallet;
String Wallet;
Float Total_NMSWallet;
Float mrpcharge;
Float total_amt;
Float total_Wallet_amt;
	
	
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
		//	capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");//"c195de14"
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
		//	capabilities.setCapability(MobileCapabilityType.VERSION,"11 RP1A.200720.011" );
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
	

	@Test(priority = 1,enabled = true)
	public void cartPage() throws Throwable {
		
		MsitePOM ms = new MsitePOM();
		  driver.get("http://m.netmeds.com");
	        
		  driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);
	        Thread.sleep(10000);
			  try {
			  driver.findElement(By.xpath("//span[@class='app_close']|//*[@class='app_close']")).click();
			  }catch (Exception e) {
				// TODO: handle exception
			}			  	  
			  // Remove From Cart
				driver.navigate().to("https://m.netmeds.com/checkout/cart");

				Thread.sleep(10000);

				letschat();
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
						System.err.println("Successfully Product Removed from Cart");
						break;

					}
				} 
				
				//////
				Thread.sleep(5000);
				ms.getMsite_Cart_Search().click();
				Thread.sleep(3000);
				type(ms.getMsite_Search_box(), MsiteBaseClass.getExcelData("Msite", 0, 1));
				Thread.sleep(2000);
                 driver.hideKeyboard();
                 
                 WebDriverWait wait = new WebDriverWait(driver, 30);
					
							//wait.until(.elementToBeClickable(By.id("//*[@css='BUTTON.btn.btn_to_cart.m-0']")));

					Thread.sleep(3000);
driver.findElement(By.xpath("//*[@css='DIV.leftside-icons.col-2.p-0']|//*[@class='product-item-name col-8 pl-0']|//*[@css='DIV.product-item-name.col-8.pl-0']|//*[@css='DIV.product-itemdetails.row.m-0.ng-star-inserted']")).click();
				//	btnclick(Cart_btn);
try {
	Thread.sleep(3000);
driver.findElement(By.xpath("//*[@css='DIV.leftside-icons.col-2.p-0']|//*[@class='product-item-name col-8 pl-0']|//*[@css='DIV.product-item-name.col-8.pl-0']|//*[@css='DIV.product-itemdetails.row.m-0.ng-star-inserted']")).click();
			
} catch (Exception e) {
	// TODO: handle exception
}
					try {
					Thread.sleep(3000);
					driver.findElement(By.xpath("//*[@class='search-text search-bg']")).click();
					}catch (Exception e) {
						// TODO: handle exception
					}
					Thread.sleep(3000);
				//	WebElement Cart_btn = driver.findElement(By.xpath("//*[@class='btn btn_to_cart m-0']"));
				//	btnclick(Cart_btn);

					Thread.sleep(3000);
					btnclick(ms.getMsite_AddToCart());
				
                 /*
				for (int i = 0; i < 1; i++) {
					type(ms.getMsite_Search_box(), MsiteBaseClass.getExcelData("Msite", i, 1));
					Thread.sleep(2000);
                     driver.hideKeyboard();
									//	logger.log(Status.PASS, "Successfully navigate to search result page");

					//String Cart_Excel = MobileBaseClass.getExcelData("Otcandnonrx", i, 1);

					// Step 7 : Add product to the cart//
					try {
						Thread.sleep(3000);

						WebDriverWait wait = new WebDriverWait(driver, 30);
						WebElement Cart_btn = wait.until(
								ExpectedConditions.elementToBeClickable(By.id("//*[@css='BUTTON.btn.btn_to_cart.m-0']")));

						Thread.sleep(3000);

						btnclick(Cart_btn);
						
						Thread.sleep(3000);

						btnclick(ms.getMsite_AddToCart());
						
						
						System.out.println("successfully Items are added");
						
						logger.log(Status.PASS, "Items are added successfully");
						
						Thread.sleep(3000);
						
						ms.getMsite_Cart_Search().clear();
						Thread.sleep(3000);
						
					} catch (Exception e) {
						// TODO: handle exception
					}
				}	
*/
				
				Thread.sleep(3000);
				//Click mini cart//
				
				ms.getMsite_ViewCart().click();
				Thread.sleep(10000);

				
				letschat();
				Thread.sleep(3000);
			//	ms.getMsite_SaveForLater().click();
				try {
				driver.findElement(By.xpath("//*[@text=' Move To Cart ']")).click();
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
				//	driver.swipe(50, 300, 0, 0, 1000);
					Thread.sleep(3000);
				} catch (Exception e) {
					
				}
				//ms.getMsite_SaveForLater().click();

				Thread.sleep(3000);
			//	logger.log(Status.PASS, "Successfully navigated to cart page");
				System.out.println("Successfully navigated to cart page");

				
				//qty increase//
		/*		
				Thread.sleep(3000);
				
			     ms.getMsite_QtyBtn().click();
				
				Thread.sleep(6000);
						
				WebElement qty_increase = driver.findElement(By.xpath("(//*[@id='text1'])[10]"));//|//*[@text='10' and @top='true']
					
				Thread.sleep(3000);
				qty_increase.click();
						
				Thread.sleep(3000);
						
			//	logger.log(Status.PASS, " quantity increased Successfully");
				System.out.println(" quantity increased Successfully");
*/
		Thread.sleep(3000);
		
		// Step  :Remove item//
		
	//	btnclick(ms.getMsite_RemoveItem());
		Thread.sleep(3000);
		
	//	logger.log(Status.PASS, " item removed Successfully");
//		System.out.println(" item removed Successfully");
		
		// Step : Decrease qty//
/*
		Thread.sleep(3000);
		ms.getMsite_QtyBtn().click();
		
		Thread.sleep(3000);
		WebElement qty_decrease = driver.findElement(By.xpath("(//*[@id='text1'])[3]"));//|//*[@text='2' and @top='true']
			
		qty_decrease.click();
				
		Thread.sleep(3000);
		
		//logger.log(Status.PASS, " quantity decreased Successfully");
		System.out.println(" quantity decreased Successfully");
	*/	
	////

		driver.swipe(50, 500, 0, 0, 1000);
		
		////
		
		int n = 1;
		Thread.sleep(3000);
	
		
		for (int i = 0;i<n; i++)
			
		{
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@css='SPAN.arricon']|//*[@text='Apply Promo Code']|((//*[@class='android.view.View' and ./parent::*[@class='android.view.View' and ./parent::*[@id='app']]]/*[@class='android.view.View'])[1]/*[@class='android.view.View'])[4]")).click();
			Thread.sleep(3000);
			List<WebElement> radiobtn = driver.findElements(By.xpath("//*[@name='livecoupon_popup']"));
			Thread.sleep(3000);
		//	System.out.println("Total element size is  "+ radiobtn.size());
			n = radiobtn.size();
		
		try {
			
			
			Thread.sleep(3000);
			for (int j = 0; j < n; j++) {
				
				Thread.sleep(3000);
				if (radiobtn.get(j).isDisplayed()) {
					
					Thread.sleep(3000);
					radiobtn.get(j).click();
					
					Thread.sleep(3000);
				} else {

					System.out.println("Promo code was unable to avail");
					
				}
			}
				
			
			
		}catch (Exception e) {
		
		}
		
		
		
		}
		
		
		/////////////////////////
	//	driver.swipe(0, 0, 0, 1000, 1000);
		
		driver.swipe(50, 500, 0, 0, 1000);	

		//Delivery Charge//
		
				if (!(driver.findElements(By.id("cart_del_charges")).size()==0))
				{
					dlcharge = driver.findElement(By.id("icart_del_charge")).getText();
					System.out.println(dlcharge);
					//logger.log(Status.PASS, "Ordered Product price was "+dlcharge);
					
					String[] total_dlcharge = dlcharge.split("Rs."); 	
					System.out.println(total_dlcharge);
					
					dlcharge = total_dlcharge[1].toString();
					System.out.println(dlcharge);
					
					 delcharge = Float.parseFloat(dlcharge);
					System.out.println("total delivery charge is ===" +delcharge);
				
			} else {
				
			//	System.out.println("Total amount is more than Rs.500");
				System.out.println("Delivery Charge is not Applicable");
			
			}
				
				
		//Netmeds Discount//
				

				
				if (!(driver.findElements(By.id("cart_total_disc1")).size()==0))
				{
					discount = driver.findElement(By.id("cart_total_disc1")).getText();
					System.out.println(discount);
				//	logger.log(Status.PASS, "Discount is "+ discount);
					
					String[] discount_amt = discount.split("Rs."); 	
					System.out.println(discount_amt[1]);
					
					discount = discount_amt[1].toString();
					System.out.println(discount);
					
					 total_discount = Float.parseFloat(discount);
					 
					 
					 
					System.out.println("total discount amount is ===" +discount);
				
			} else {
				
				System.out.println("No discount amount");
			}	
				
				
							
		//Total Mrp//
					 
					String totalmrp = driver.findElement(By.id("cart_sub_total")).getText();
					
					//String totalmrp = m.getTotalmrp().getText();
					
				//	logger.log(Status.PASS, "mrp is "+totalmrp);
					
					String[] total_mrp1 = totalmrp.split("Rs."); 
					
					if (total_mrp1[1].contains(",")) {
						
						 mrp = total_mrp1[1].replace(",", "");
						 
					} else 
					
					{
						
					mrp = total_mrp1[1].toString();
						
					}
					
					String total_mrp2 =mrp.toString();
					
					Float mrpcharge = Float.parseFloat(total_mrp2);
					
					System.out.println("total mrp charge is ===" +mrpcharge);	
					
					
					
		//Total Amount//	
					
					String totalamount = driver.findElement(By.id("cart_netpay_amt1")).getText();
					
					//String totalamount = m.getTotal_amount().getText();
					
			//		logger.log(Status.PASS, "Ordered Product price was "+totalamount);
					String[] total_amt1 = totalamount.split("Rs.");  //String a = element.getText();  String[] id = a.split(" : ");  String ab = id[1].toString();
					
				
					if (total_amt1[1].contains(",")) {
						
						 totalamt = total_amt1[1].replace(",", "");
						
					} else {
						
					totalamt = total_amt1[1].toString();
						
					}
					
					String total_amt2 =totalamt.toString();
						
					System.out.println(total_amt2);
					
					Float total_amt = Float.parseFloat(total_amt2);
			
					System.out.println("Total amt is=== "+ total_amt);
					
					Thread.sleep(3000);
					
		//Mrp charge(net charge) calculation//
try {
				if (mrpcharge<=150.00 && dlcharge.equals("50.00")) {
			    	
			  	Netcharge = mrpcharge + delcharge;
			   
			    }else if  (mrpcharge>150.00 && mrpcharge<=500.00 && dlcharge.equals("25.00")) {
			    	
				  	Netcharge = mrpcharge + delcharge;
			    }else if (mrpcharge>500.00) {
			    	
				  	Netcharge = mrpcharge ;
			    }
} catch (Exception e) {
	// TODO: handle exception
}
				System.out.println("netcharge==="+Netcharge);
				System.out.println("total_amt==="+total_amt);
				
		//Additional Discount
				
				
				if (!(driver.findElements(By.id("cart_additionalDiscount")).size()==0))
				{
					additional_discount = driver.findElement(By.id("cart_additionalDiscount")).getText();
					System.out.println(additional_discount);
		//			logger.log(Status.PASS, "Discount is "+ additional_discount);
					
					String[] add_discount_amt = additional_discount.split("Rs."); 	
					System.out.println(add_discount_amt);
					
					additional_discount = add_discount_amt[1].toString();
					System.out.println(additional_discount);
					
					Additional_total_discount = Float.parseFloat(additional_discount);
					
			
					 
					System.out.println("total additional  discount amount is ===" + Additional_total_discount);
				
			} else {
				
				System.out.println("No additional discount amount");
			}	
				
				
		//discount calculation//		
				try {
				if (discount!= null && !discount.isEmpty())
				
				{
					Netcharge = Netcharge -(total_discount+Additional_total_discount);
					
					
					
					 String Netcharge1 = String.format("%.2f", Netcharge);
					
					 Netcharge= Netcharge.parseFloat(Netcharge1);
					System.out.println("Actual net charge after discount is =="+Netcharge);
				} else {}
					
				
				if (Float.compare(Netcharge, total_amt) == 0) 
				{
				   System.out.println("Total amount matches with total netcharge");
				   
			   }else {
				   System.out.println("Total amount mismatch");
			   }

				}catch (Exception e) {
					// TODO: handle exception
				}
				
				
				
		//saving amount calculation//
				
				if (!(driver.findElements(By.id("cart_totalSaving")).size()==0))
				{
					savings = driver.findElement(By.id("cart_totalSaving")).getText();
					System.out.println(savings);
			//		logger.log(Status.PASS, "saving is "+ savings);
					
					String save = savings.replaceAll(" ","");
					System.out.println("total==="+save);
					
					String[] savings_amt = save.split("Rs."); 
					
					System.out.println(savings_amt);
					
					savings = savings_amt[1].toString();
					System.out.println(savings);
					
					 total_savings = Float.parseFloat(savings);
					 
					System.out.println("total saving amount is ===" +total_savings);
				
			} else {
				
				System.out.println("No savings amount");
			}
				
				if (total_savings!= null && total_discount!= null) {
					
			Float	Discount_amount = Additional_total_discount+total_discount;
			
			 String Discount_amount_1 = String.format("%.2f", Discount_amount);
				
			 Discount_amount= Discount_amount.parseFloat(Discount_amount_1);
			
			System.out.println("Total Discount===="  +Discount_amount);
					
					if (Float.compare(total_savings,(Discount_amount)) == 0) 
					{
					   System.out.println("Total savings is matched with discount amount");
					   
				   }else {
					   System.out.println("Total savings amount is not matched with discounts");
				   }
					
					
					 } else {}
				
					
				System.out.println("cartpage Scenario 1 is working properly");
				}	
			
	
	
	@Test(enabled=false)
	public void cart_Page2() throws Throwable {
		
		MsitePOM ms = new MsitePOM();
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

				ms.getMsite_Cart_Search().click();
				Thread.sleep(3000);
				type(ms.getMsite_Search_box(),"Gemer 1");
				Thread.sleep(2000);
               driver.hideKeyboard();
               
               WebDriverWait wait = new WebDriverWait(driver, 30);
               WebElement Cart_btn = wait.until(
						ExpectedConditions.elementToBeClickable(By.id("//*[@css='BUTTON.btn.btn_to_cart.m-0']")));

				Thread.sleep(3000);

				btnclick(Cart_btn);
				
				Thread.sleep(3000);

				btnclick(ms.getMsite_AddToCart());
				
          
				
				Thread.sleep(3000);
				//Click mini cart//
				
				ms.getMsite_ViewCart().click();
				Thread.sleep(10000);
		

				//Delivery Charge//
						
						if (!(driver.findElements(By.id("cart_del_charge")).size()==0))
						{
							dlcharge = driver.findElement(By.id("cart_del_charges")).getText();
							System.out.println(dlcharge);
							logger.log(Status.PASS, "Ordered Product price was "+dlcharge);
							
							String[] total_dlcharge = dlcharge.split("Rs."); 	
							System.out.println(total_dlcharge);
							
							dlcharge = total_dlcharge[1].toString();
							System.out.println(dlcharge);
							
							 delcharge = Float.parseFloat(dlcharge);
							System.out.println("total delivery charge is ===" +delcharge);
						
					} else {
						
						System.out.println("Total amount is more the Rs.500");
					}
						
						
				//Netmeds Discount//
						

						
						if (!(driver.findElements(By.id("cart_total_disc1")).size()==0))
						{
							discount = driver.findElement(By.id("cart_total_disc1")).getText();
							System.out.println(discount);
							logger.log(Status.PASS, "Discount is "+ discount);
							
							String[] discount_amt = discount.split("- Rs."); 	
							System.out.println(discount_amt);
							
							discount = discount_amt[1].toString();
							System.out.println(discount);
							
							 total_discount = Float.parseFloat(discount);
							 
							System.out.println("total discount amount is ===" +discount);
						
					} else {
						
						System.out.println("No discount amount");
					}	
						
						
									
				//Total Mrp//
						String totalmrp = driver.findElement(By.id("cart_sub_total")).getText();
						
						//String totalmrp = m.getTotalmrp().getText();
						
						logger.log(Status.PASS, "mrp is "+totalmrp);
						
						String[] total_mrp1 = totalmrp.split("rs."); 
						
						if (total_mrp1[1].contains(",")) {
							
							 mrp = total_mrp1[1].replace(",", "");
							 
						} else 
						
						{
							
						mrp = total_mrp1[1].toString();
							
						}
						
						String total_mrp2 =mrp.toString();
						
						 mrpcharge = Float.parseFloat(total_mrp2);
						
						System.out.println("total mrp charge is ===" + mrpcharge);
							
							
							
				//Total Amount//	
							
							String totalamount = driver.findElement(By.id("cart_netpay_amt1")).getText();
							
							//String totalamount = m.getTotal_amount().getText();
							
							logger.log(Status.PASS, "Ordered Product price was "+totalamount);
							String[] total_amt1 = totalamount.split("Rs.");  //String a = element.getText();  String[] id = a.split(" : ");  String ab = id[1].toString();
							
						
							if (total_amt1[1].contains(",")) {
								
								 totalamt = total_amt1[1].replace(",", "");
								
							} else {
								
							totalamt = total_amt1[1].toString();
								
							}
							
							String total_amt2 =totalamt.toString();
								
							System.out.println(total_amt2);
							
							 total_amt = Float.parseFloat(total_amt2);
					
							System.out.println("Total amt is=== "+ total_amt);
							
							Thread.sleep(3000);
							
					//Mrp charge(net charge) calculation//
						
							if (mrpcharge<=150.00 && dlcharge.trim().equals("50.00")) {
							
								Netcharge =mrpcharge + delcharge;
								
						   
						    }
							else if  (mrpcharge>150.00 && mrpcharge<=500.00 && dlcharge.trim().equals("25.00")) {
						    	
							  	Netcharge = mrpcharge + delcharge;
							  	System.out.println(" net charge" + Netcharge);
						    }else if (mrpcharge>500.00) {
						    	
							 	Netcharge = mrpcharge ; 
						    }
						    	
							System.out.println("netcharge==="+Netcharge);
							System.out.println("total_amt==="+total_amt);
						
				//Additional Discount
						
						
						if (!(driver.findElements(By.id("cart_additionalDiscount")).size()==0))
						{
							additional_discount = driver.findElement(By.id("cart_additionalDiscount")).getText();
							System.out.println(additional_discount);
							logger.log(Status.PASS, "Discount is "+ additional_discount);
							
							String[] add_discount_amt = additional_discount.split("- Rs."); 	
							System.out.println(add_discount_amt);
							
							additional_discount = add_discount_amt[1].toString();
							System.out.println(additional_discount);
							
							Additional_total_discount = Float.parseFloat(additional_discount);
							 
							System.out.println("total additional  discount amount is ===" + Additional_total_discount);
						
					} else {
						
						System.out.println("No additional discount amount");
					}	
						
						
				//discount calculation//		
						
						if (discount!= null && !discount.isEmpty())
						
						{
							Netcharge = (Netcharge - total_discount);
							
							System.out.println("Actual net charge after discount is =="+Netcharge);
						}
						
						if (additional_discount!= null && !additional_discount.isEmpty()) {
							
							Netcharge = Netcharge -(total_discount+Additional_total_discount);
							
							System.out.println("Actual net charge after discount is =="+Netcharge);
							
						}
						
						
						if (Float.compare(Netcharge, total_amt) == 0) 
						{
						   System.out.println("Total amount matches with total netcharge");
						   
					   }else {
						   System.out.println("Total amount mismatch");
					   }


						
						
						
				//saving amount calculation//
						
						if (!(driver.findElements(By.id("cart_totalSaving")).size()==0))
						{
							savings = driver.findElement(By.id("cart_totalSaving")).getText();
							System.out.println(savings);
							logger.log(Status.PASS, "saving is "+ savings);
							
							String save = savings.replaceAll(" ","");
							System.out.println("total==="+save);
							
							String[] savings_amt = save.split("Rs."); 
							
							System.out.println(savings_amt);
							
							savings = savings_amt[1].toString();
							System.out.println(savings);
							
							 total_savings = Float.parseFloat(savings);
							 
							System.out.println("total saving amount is ===" +savings);
						
					} else {
						
						System.out.println("No savings amount");
					}
						if (total_savings!= null && total_discount!= null) {
							if (Float.compare(total_savings,(Additional_total_discount+total_discount)) == 0) 
							{
							   System.out.println("Total savings is matched with discount amount");
							   
						   }else {
							   System.out.println("Total savings amount is not matched with discounts");
						   }
							
							
							 }
						
						System.out.println("cartpage Scenario 2 is working properly");
							
						


	}
		
		

	
	@AfterMethod()
	public void screenShot(ITestResult result) throws Throwable {
	/*	
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
	
	*/
	}	
		


	@AfterTest
	private void quitbrowser() {
//		report.flush();
		
 //     driver.quit();
	}

	}


