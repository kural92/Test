package com.Nm.Andriod_prod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
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
import com.Nm.Pom.AndriodPom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CartPage_Scenario_2 extends MobileBaseClass {

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
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();


			capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA");//"c195de14" //07c55fe10406//RZ8R20GLXTA

			//capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA");//"c195de14" //07c55fe10406//RZ8R20GLXTA


			//capabilities.setCapability(MobileCapabilityType.UDID, UDID);//"c195de14" //07c55fe10406

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
			capabilities.setCapability("noReset", true);
			
					
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
	
//*****************************************************************Cart Page	*********************************************************




	/*,
	 BELOW LISTED SCENARIOS ARE COEVRED// 
		Scenario 1: Quantity increased,Quantity decreased and quantity removed/
		Scenario 2:	Item added though continue shopping/
		Scenario 3:	Item added through most selling products(directly clicking the add to cart of an item)
		Scenario 4: All the listed promo codes are able to applied
		Scenario 5:	Item added through most selling products (open the item and added)
		
	Note : In the below test cases, Validation has been included for the delivery charge check,Mrp check, Discount amount,NMS Wallet check and the total amount)
		*/

	
//Test case 2 : Verify Cart page when the Total amount is more than lessthan 150 
		
		
		
	@Test(enabled = true)
				//,retryAnalyzer=RetryAnalyzer.class)
		public void CartPageScenario2() throws Throwable {
			
			logger =  report.createTest("Cart Page Scenario2 ");
			logger.log(Status.PASS, "*************Cart Page Scenario2********************" );
			
			AndriodPom m = new AndriodPom();
			
			driver.launchApp();
			
			try {
				popupclose();
				Thread.sleep(5000);
				popupclose();
			btnclick(m.getLetsstarted());
			} catch (Exception e) {
				//driver.resetApp();
			
			}
			
			Thread.sleep(1000);
			
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys("8072281468");
			popupclose();
			Thread.sleep(10000);
			popupclose();
			Thread.sleep(10000);
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
			

	//  Remove existing items from the cart  //
		
		
		
		driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart")).click();
		
			Thread.sleep(3000);
			for (int i = 0; i < 7; i++) {
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
			
			
	//Adding Product to the cart//
			
			driver.findElement(By.xpath("//android.widget.TextView[@text='GO TO SEARCH']")).click();
			Thread.sleep(3000);
			btnclick(m.getM3productsearch());
			Thread.sleep(3000);
			
			//type(m.getM3productsearch(),"Folvite Tablet 45'S");
			//driver.findElement(By.xpath("//android.widget.TextView[@resourceid='com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn']")).click();
			
			
			for (int i = 0; i < 2; i++) {

				type(m.getM3productsearch(), MobileBaseClass.getExcelData("Otcandnonrx", i, 0));

				// btncli(m.getSearchIcon());
				logger.log(Status.PASS, "Successfully navigate to search result page");

				//String Cart_Excel = MobileBaseClass.getExcelData("Otcandnonrx", i, 1);

				// Step 7 : Add product to the cart//
				try {
					Thread.sleep(3000);

					WebDriverWait wait = new WebDriverWait(driver, 30);
					WebElement Cart_btn = wait.until(
							ExpectedConditions.elementToBeClickable(By.id("com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn")));

					Thread.sleep(3000);

					btnclick(Cart_btn);
					
					System.out.println("successfully Items are added");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}	

	//Click mini cart//
			Thread.sleep(3000);
			driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart")).click();
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigated to cart page");
			System.out.println("Successfully navigated to cart page");
			Thread.sleep(3000);
			driver.swipe(0, 1100, 0, 0, 1000);


	//Delivery Charge//
			
			if (!(driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/cart_deliveryCharges")).size()==0))
			{
				dlcharge = driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart_deliveryCharges")).getText();
				System.out.println(dlcharge);
				logger.log(Status.PASS, "Ordered Product price was "+dlcharge);
				
				String[] total_dlcharge = dlcharge.split("₹"); 	
				System.out.println(total_dlcharge);
				
				dlcharge = total_dlcharge[1].toString();
				System.out.println(dlcharge);
				
				 delcharge = Float.parseFloat(dlcharge);
				System.out.println("total delivery charge is ===" +delcharge);
			
		} else {
			
			System.out.println("Total amount is more the Rs.500");
		}
			
			
	//Netmeds Discount//
			

			
			if (!(driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/cart_netmedsDiscount")).size()==0))
			{
				discount = driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart_netmedsDiscount")).getText();
				System.out.println(discount);
				logger.log(Status.PASS, "Discount is "+ discount);
				
				String[] discount_amt = discount.split("₹ -"); 	
				System.out.println(discount_amt);
				
				discount = discount_amt[1].toString();
				System.out.println(discount);
				
				 total_discount = Float.parseFloat(discount);
				 
				System.out.println("total discount amount is ===" +discount);
			
		} else {
			
			System.out.println("No discount amount");
		}	
			
			
						
	//Total Mrp//
			String totalmrp = driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart_mrpTotal")).getText();
			
			//String totalmrp = m.getTotalmrp().getText();
			
			logger.log(Status.PASS, "mrp is "+totalmrp);
			
			String[] total_mrp1 = totalmrp.split("₹"); 
			
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
				
				String totalamount = driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart_orderAmount")).getText();
				
				//String totalamount = m.getTotal_amount().getText();
				
				logger.log(Status.PASS, "Ordered Product price was "+totalamount);
				String[] total_amt1 = totalamount.split("₹");  //String a = element.getText();  String[] id = a.split(" : ");  String ab = id[1].toString();
				
			
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
			
			
			if (!(driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/cart_additionalDiscount")).size()==0))
			{
				additional_discount = driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart_additionalDiscount")).getText();
				System.out.println(additional_discount);
				logger.log(Status.PASS, "Discount is "+ additional_discount);
				
				String[] add_discount_amt = additional_discount.split("₹ -"); 	
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
			
			if (!(driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/cart_totalSaving")).size()==0))
			{
				savings = driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/cart_totalSaving")).getText();
				System.out.println(savings);
				logger.log(Status.PASS, "saving is "+ savings);
				
				String save = savings.replaceAll(" ","");
				System.out.println("total==="+save);
				
				String[] savings_amt = save.split("₹"); 
				
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
		
  driver.quit();
	}


		}
