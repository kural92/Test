package com.Nm.Andriod_prod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
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

public class MyOrdersPage extends MobileBaseClass {

static String totalamt;
	
	static String subtotal;
	String shipping_charge ;
	String payable_amt;
	Float Shippingcharge =new Float(0);
	Float 	Netcharge;
	String discount;
	String savings;
	Float Netamountpayable;
	Float total_discount;
	Float total_savings;
	Float NetPayable;
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
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
	
//*****************************************************************MyOrdersPage	*********************************************************
	@Test(enabled = true,retryAnalyzer=RetryAnalyzer.class)
	public void MyOrdersPage() throws Throwable {
		
		logger =  report.createTest("My Orders Page");
		logger.log(Status.PASS, "*************My Orders Page********************" );
		
		AndriodPom m = new AndriodPom();
		
		driver.launchApp();
			
			try {
				popupclose();
				Thread.sleep(5000);
				popupclose();
			btnclick(m.getLetsstarted());
			} catch (Exception e) {
				//driver.resetApp();
				//driver.launchApp();
			
			}
			
			Thread.sleep(1000);
			
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys(" ");
			popupclose();
			Thread.sleep(10000);
			popupclose();
			Thread.sleep(10000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys(" ");
			
			Thread.sleep(2000);
		
			
			Thread.sleep(5000);
			btnclick(m.getLogin());
		}
		
		catch(Exception e) {
			System.out.println("Already logged in");
		}
		 
			popupclose();
		
		
	//Step 3 : Navigate to user profile//

			btnclick(m.getUserprofile());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to userprofile");
			System.out.println("Successfully navigate to userprofile");


		
//Cancel order//
		
		btnclick(m.getMyorders());
		
		Thread.sleep(3000);
		
		
		if (!(driver.findElements(By.xpath("//android.widget.TextView[@text='CANCELLED']")).size() ==0))
			
		{
			logger.log(Status.PASS, " Order was already Cancelled" );
			System.out.println(" order is already cancelled ");
			Thread.sleep(3000);
			btnclick(m.getViewdetails());
			Thread.sleep(3000);
			
			
		}else
		
		
		{
			
			//cancel order


			btnclick(m.getCancelorder());
			Thread.sleep(3000);
			//yes


			try {
			btnclick(m.getYesbutton());
			Thread.sleep(2000);
			}catch (Exception e) {
				// TODO: handle exception
			}

			//Cancel reason


			btnclick(m.getCancel_reason());
			driver.swipe(0, 1000, 0, 0, 1000);

			Thread.sleep(2000);
			
		}
		
	//Track Order//		
		
		Thread.sleep(3000);
			//btnclick(m.getViewdetails());	
			
			System.out.println("Successfully Navigated to View details page");
			logger.log(Status.PASS, " Successfully Navigated to View details page" );
			Thread.sleep(3000);
				
				
				Assert.assertEquals(gettext(m.getOrderDetails_text()),"ORDER DETAILS");
				
				System.out.println(m.getOrderDetails_text().getText());
				
				
			
				
				
				Assert.assertTrue(gettext(m.getCustomer_name_text()).contains("Customer Name"));
				
				System.out.println((m.getCustomer_name_text()).getText());
				
				System.out.println((m.getCustomer_name()).getText());
				
				Thread.sleep(3000);
				//Assert.assertTrue(gettext(m.getOrderId_text()).contains("Order ID :"));
				
				//System.out.println((m.getOrderId_text()).getText());
				
				System.out.println((m.getOrderId()).getText());
				
				Assert.assertTrue(gettext(m.getOrder_placed_text()).contains("Order Placed"));
				
				System.out.println((m.getOrder_placed_text()).getText());
				
				System.out.println((m.getOrder_placed()).getText());
				
				//Assert.assertEquals(gettext(m.getPayment_mode_text()),"Payment Mode");
				
				//System.out.println("Payment mode is  "  + (m.getPayment_mode_text().getText()));
				
				
				
				logger.log(Status.PASS, "Assertions are successfully completed" );
				
			//System.out.println(m.getPayment_mode().getText());	
				
			//WebElement Address_details  = driver.findElement(By.xpath("//div[@class=\"adddetails\"]"));
			
			//System.out.println("Delivery Address is   " + Address_details.getText());
				
				driver.swipe(0, 1000, 0, 0, 1000);
				
			List<WebElement> Druglist = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_drug_name']"));
			
			
			int drug_list = Druglist.size();
			
			System.out.println("element size is " + drug_list);
			
			System.out.println("Medicine details are as follows");
			
		List<	WebElement> Drugname = 	driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_drug_name']"));
			
	List	<WebElement> Drugprice = 	driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/tv_algoliaPrice"));
	
List  <WebElement> Drugqty = driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/tv_drug_quantity"));
	
			for (int i=0;i<drug_list;i++) {
				
				
				//WebElement order=	driver.findElement(By.xpath("//android.widget.LinearLayout[@index='0']"));
				
			
			Thread.sleep(2000);
			System.out.println("Drug name is" +Drugname.get(i).getText());
				
			Thread.sleep(2000);
			
			System.out.println("Drug price is" +Drugprice.get(i).getText());
			
			Thread.sleep(3000);
			
			System.out.println("Drug qty is" +Drugqty.get(i).getText());
			
			
				//System.out.println("medicines"  +  order.getText());
				
				logger.log(Status.PASS, " Drug list was successfully captured" );
				
				
			}
	
			
			driver.swipe(0, 1200, 0, 0, 1000);
			//Assert.assertTrue(gettext(m.getDelivery_address_text()).contains("DELIVERY ADDRESS"));
			
		//system.out.println(m.getDelivery_address_text().getText());
			Thread.sleep(2000);
			
		System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='DELIVERY ADDRESS']")).getText());
			
			Thread.sleep(2000);
			
		//WebElement cus_name =		driver.findElement(By.xpath("//android.widget.TextView[@bounds='[66,1546][1058,1596]']"));
		
		
		WebElement cus_name =		driver.findElement(By.xpath("(//android.widget.TextView[@text='DELIVERY ADDRESS']/parent::android.widget.LinearLayout/child::android.widget.TextView)[2]")); 
		
		System.out.println(cus_name.getText());
				
		
			//touchAction.tap(970, 1431).perform();
			
			Thread.sleep(2000);
			
			WebElement deliveryAddress = 	driver.findElement(By.xpath("(//android.widget.TextView[@text='DELIVERY ADDRESS']/parent::android.widget.LinearLayout/child::android.widget.TextView)[3]"));
			
		System.out.println(deliveryAddress.getText());
			
			Thread.sleep(2000);
			
			//Need Help page//
			 btnclick(m.getNeedHelp_page());
			 Thread.sleep(3000);
			 driver.navigate().back();
			 Thread.sleep(3000);
			 System.out.println("Successfully Navigated to Help Page");
			 logger.log(Status.PASS, " Successfully Navigated to Help Page" );
			 
	//Reorder//
			 
			 btnclick(m.getReorder());
			 Thread.sleep(3000);
			 System.out.println("Successfully Navigated to reorder Page");
			 logger.log(Status.PASS, " Successfully Navigated to reorder Page" );
			 Thread.sleep(3000);
			 
			 try {
				 
				 btnclick(driver.findElementByAccessibilityId("Gallery"));
				 
				 Thread.sleep(3000);
				 
				 btnclick(driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.google.android.documentsui:id/icon_thumb'])[2]")));
				 Thread.sleep(3000);

				 driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/continueButton")).click();
				 
				 Thread.sleep(3000);
				 driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/continueButton")).click();
				 
				 Thread.sleep(3000);
				 
				
				 
			 }catch (Exception e) {
				// TODO: handle exception
			}
			 try {
				 
				 driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/btn_dismiss")).click();
				
			} catch (Exception e) {
				System.out.println("No Popup is there to close");
			}
//Ensure proceed button is enabled//
			 try {
				Thread.sleep(3000);
			 m.getProceed_btn().isEnabled();
				System.out.println("Proceed button is enabled");
				
				Thread.sleep(3000);
				 driver.navigate().back();
			 }catch (Exception e) {
				// TODO: handle exception
			}

				
				 
				 if (!(driver.findElements(By.id("com.NetmedsMarketplace.Netmeds:id/place_order")).size()==0))
				 {
					 try {
					 driver.navigate().back();
					 
					 driver.navigate().back();
					 
					 driver.navigate().back();
					 } catch (Exception e) {
					// TODO: handle exception
					 	}
						 }
				 
				 
				 driver.swipe(0, 500, 0, 1200, 1000);
//show status details//
				try {
					Thread.sleep(3000);
				
				btnclick(m.getShow_Status_Details());
				 Thread.sleep(3000);					
				 System.out.println("Successfully Navigated to Show Details Page");
				 logger.log(Status.PASS, " Successfully Navigated to Show Details Page" );	
				}catch (Exception e) {
					// TODO: handle exception
				}

	//Track Order
					
				WebElement Orderstatus_text =  driver.findElement(By.xpath("(//android.widget.TextView[@index='0'])[1]"));
				
				System.out.println(Orderstatus_text.getText());

				List<WebElement> order_statuses = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_status_label']"));
				int order_status = order_statuses.size();
				System.out.println("The element size is   "+order_status);
				
		
				
				
				for (int i=0;i<order_status;i++) {
					
					Thread.sleep(3000);
					System.out.println(order_statuses.get(i).getText());
					
				}
				 
				Thread.sleep(3000);
				driver.navigate().back();
				
//PRESCRIPTION(S) UPLOADED//
				try {
					Thread.sleep(3000);
					 btnclick(m.getPrescription_open());
					 Thread.sleep(4000);
					 btnclick(m.getPrescription_closed());
					 System.out.println("Successfully opened and closed prescription page");
					 logger.log(Status.PASS, " Successfully opened and closed prescription page" );
					 Thread.sleep(3000);
				} catch (Exception e) {
					System.out.println("Otc or Non rx product does not  have any prescription");
				}
			
				
	//Sub Total//
				 try {
				driver.swipe(0, 1600, 0, 500, 1000);
				 } catch (Exception e) {
					 driver.swipe(0, 1100, 0, 0, 1000);
				}
				 Thread.sleep(3000);
				String total = driver.findElement(By.xpath("//android.widget.TextView[@text='Sub Total']/parent::android.widget.LinearLayout/parent::android.widget.TableRow/child::android.widget.TextView")).getText();
				
				logger.log(Status.PASS, "total is "+total);
				
				String[]sub_total = total.split("₹ "); 
				
				if (sub_total[1].contains(",")) {
					
					 subtotal = sub_total[1].replace(",", "");
					 
				} else 
				
				{
					
					subtotal = sub_total[1].toString();
					
				}
				
				String total_amt =subtotal.toString();
				
				Float subtotal_charge = Float.parseFloat(total_amt);
				
				System.out.println("total subtotal charge is ===" +subtotal_charge);	
				
				logger.log(Status.PASS, " Subtotal charge was successfully calculated" );
			
//shipping Charge//
			
			if (!(driver.findElements(By.xpath("//android.widget.TextView[@text='Shipping Charges']")).size()==0)&& subtotal_charge<500)
			{
				shipping_charge = driver.findElement(By.xpath("//android.widget.TextView[@text='Shipping Charges']/parent::android.widget.LinearLayout/parent::android.widget.TableRow/child::android.widget.TextView")).getText();
				System.out.println(shipping_charge);
				logger.log(Status.PASS, "Ordered Product price was "+shipping_charge);
				
				String[] total_dlcharge = shipping_charge.split("₹ "); 	
				System.out.println(total_dlcharge);
				
				shipping_charge = total_dlcharge[1].toString();
				System.out.println(shipping_charge);
			
				 Shippingcharge = Float.parseFloat(shipping_charge);
				System.out.println("total shipping charge is ===" +Shippingcharge);
				logger.log(Status.PASS, " Shipping charge was successfully calculated" );
			
		} else {
			
			System.out.println("Total amount is more the Rs.500");
			
			
			System.out.println("Shipping charge is " + Shippingcharge);
		} 
	
//Netmeds Discount//
			

			
			if (!(driver.findElements(By.xpath("//android.widget.TextView[@text='Discount']")).size()==0))
			{
				discount = driver.findElement(By.xpath("//android.widget.TextView[@text='Discount']/parent::android.widget.LinearLayout/parent::android.widget.TableRow/child::android.widget.TextView")).getText();
				System.out.println(discount);
				logger.log(Status.PASS, "Discount is "+ discount);
				
				String[] discount_amt = discount.split("- ₹"); 	
				System.out.println(discount_amt);
				
				discount = discount_amt[1].toString();
				System.out.println(discount);
				
				 total_discount = Float.parseFloat(discount);
				 
				System.out.println("total discount amount is ===" +discount);
				logger.log(Status.PASS, " discount charge was successfully calculated" );
			
		} else {
			
			System.out.println("No discount amount");
		}			
			

			

			
	//Net Payable amount//
			
			String payable = driver.findElement(By.xpath("//android.widget.TextView[@text='Net Amount']/parent::android.widget.LinearLayout/parent::android.widget.TableRow/child::android.widget.TextView")).getText();
			
			logger.log(Status.PASS, "mrp is "+payable);
			
			String[]Payable_total = payable.split("₹ "); 
			
			if (Payable_total[1].contains(",")) {
				
				 payable_amt = Payable_total[1].replace(",", "");
				 
			} else 
			
			{
				
				payable_amt = Payable_total[1].toString();
				
			}
			
			String payableamount =payable_amt.toString();
			
			NetPayable = Float.parseFloat(payableamount);
			
			System.out.println("total payable amount is ===" +NetPayable);	
			logger.log(Status.PASS, " Netpayable was successfully calculated" );
			
		
			if (Shippingcharge!= null) {
		    	
			  	Netamountpayable = Shippingcharge + subtotal_charge;
			   
			    }else if (total_discount!= null)   {
			    	
			    	Netamountpayable = subtotal_charge -total_discount ;
			    	
			    	
			  }
			
			System.out.println("total net payable is Rs." + Netamountpayable);
			
		 if (NetPayable==Netamountpayable) {
			 
			 System.out.println("Netpayble is matched with Net amount payble");
			 
		 }
		 
//Payment mode
		 
		 String Payment_mode = driver.findElement(By.xpath("//android.widget.TextView[@text='Payment Mode']/parent::android.widget.LinearLayout/parent::android.widget.TableRow/child::android.widget.TextView")).getText();
		 
		 System.out.println("Payment mode is " +Payment_mode);

			System.out.println("My Order page is working fine");
			


	
	}	

@AfterMethod()
public void screenShot(ITestResult result) throws Throwable {

	if (result.getStatus() == ITestResult.FAILURE) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
		logger.fail(result.getThrowable());
		try {

			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Report/" + result.getName() + ".png"));
			System.out.println("Successfully captured a screenshot");
			// logger.log(Status.FAIL, result.getThrowable());
			logger.log(Status.FAIL,
					"Snapshot below: " + logger.addScreenCaptureFromPath(result.getName() + ".png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	else if (result.getStatus() == ITestResult.SUCCESS) {
		logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));

	} else {

		// onFinish(context);
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
		logger.skip(result.getThrowable());
		report.removeTest(logger);
	}
	Thread.sleep(3000);
	if (result.getStatus() == ITestResult.FAILURE) {
		Thread.sleep(3000);
		// BaseClass.mail_report();
	}

}

@AfterTest
private void quitbrowser() {
	report.flush();

	 driver.quit();
}

}
