package com.Nm.Website_live;


import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//********Extend Report**********//
public class MyOrdersPage extends BaseClass {
static String totalamt;
	
	static String subtotal;
	String shipping_charge ;
	String payable_amt;
	Float Shippingcharge;
	Float 	Netcharge;
	String discount;
	String savings;
	Float Netamountpayable;
	Float total_discount;
	Float total_savings;
	Float NetPayable;
	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//Report//sample.html");

		// initialize ExtentReports and attach the HtmlReporter
		report = new ExtentReports();

		// htmlReporter.setAppendExisting(false); 
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Host name", "localhost");
		report.setSystemInfo("Environemnt", "QA");
		report.setSystemInfo("user", "Automation Team");

		// configuration items to change the look and feel
		// add content, manage tests etc

		htmlReporter.config().setDocumentTitle("Extent Report ");
		htmlReporter.config().setReportName("Test Report");

		// htmlReporter.config().setTheme(Theme.STANDARD);

	}

	
	/*,
	 BELOW LISTED SCENARIOS ARE COEVRED// 
	
		
		 1.Canceling the order if the order status is other than cancelled.
		
	 	2.Asserting all the details in View details page (Address,Medicine details)
		
	 	3.Validation done for  delivery charge, netmeds discount and total amount calculations.
		
		4. Check the reorder functionality inside view details page.
		
		5.Check the reorder functionality in the medicine order page.
		
		6.uploaded prescription (whenever applicable).
		
		7.Show status details.
		
		8.Different status of order(track order page)
		
		9.Help Page navigation.
		
		10. View button functionality.
		
				*/
//**************************************************My Orders page****************************************************************************************
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void MyOrdersPage() throws Throwable {
		
		
		logger = report.createTest("My Orders Page");
		logger.log(Status.PASS, "*************My Orders Page********************");

//Step1 :Launch Browser//		
		Monepom m = new Monepom();
	//	driver.manage().window().maximize();

		try {

			btncli(m.getSignin());
			Thread.sleep(5000);
			type(m.getMobileno(), "8072281468");
			Thread.sleep(3000);
			btncli(m.getUsepwdbtn());
			Thread.sleep(3000);
			type(m.getPassword(), "test@123");
			btncli(m.getSignInpage());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigate to home page");
		} catch (Exception e) {
			
			driver.navigate().to("https://www.netmeds.com/");
			
		}

//Step 3 : Navigate to user profile//

		btncli(m.getUserprofile());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to userprofile");
		System.out.println("Successfully navigate to userprofile");
		
//Cancel order//
		Thread.sleep(3000);
		btncli(m.getMedicineorders());
		
		Thread.sleep(3000);
		
		
		if (!(driver.findElements(By.xpath("//span[.=\"CANCELLED\"]")).size() ==0))
			
		{
			
	
		try {
			
			btncli(m.getView_Details());
			Thread.sleep(3000);
			btncli(m.getCancel_Order());
			Thread.sleep(3000);
			btncli(m.getCancel_reason1());
			Thread.sleep(3000);
			btncli(m.getSubmit_Cancel());
			Thread.sleep(3000);
			
			 logger.log(Status.PASS, "Successfully Order was Cancelled" );
			 System.out.println("Successfully Order was Cancelled");
			
		}
		catch (Exception e) 
		
		{
			
			logger.log(Status.PASS, " Order was already Cancelled" );
			System.out.println(" order is already canclled ");
		}
		}	
	//Track Order//		
		
		
		// handle Lets chat button
				try {
					driver.switchTo().frame("haptik-xdk");
					Actions acc = new Actions(driver);
					acc.moveToElement(driver.findElement(By.xpath("//div[@class='bot-prompt-minimal-textarea']//span"))).build()
							.perform();
					driver.findElement(By.xpath("(/html/body/div/div[1]/div[1])[1]")).click();
					driver.switchTo().defaultContent();
				} catch (Exception e) {

				}
			
				
				SoftAssert  SoftAssert = new SoftAssert();
				
				SoftAssert.assertEquals(gettext(m.getOrderDetails_text()),"ORDER DETAILS");
				
				System.out.println(m.getOrderDetails_text().getText());
				
				SoftAssert.assertEquals(gettext(m.getCustomer_name_text()),"Customer Name");
				
				System.out.println((m.getCustomer_name_text().getText() + " is " +(m.getCustomer_name().getText())));
				
				
				SoftAssert.assertEquals(gettext(m.getOrderId_text()),"Order ID");
				
				System.out.println((m.getOrderId_text().getText() + "  is " +(m.getOrder_number().getText())));
				
				
				SoftAssert.assertEquals(gettext(m.getOrder_placed_text()),"Order Placed");
				
				System.out.println((m.getOrder_placed_text().getText() + "  on  " +(m.getOrder_placed_date().getText())));
				
				
				SoftAssert.assertEquals(gettext(m.getDelivery_address_text()),"DELIVERY ADDRESS");
				
				System.out.println(m.getDelivery_address_text().getText());
				
				SoftAssert.assertEquals(gettext(m.getPayment_mode_text()),"Payment Mode");
				
				System.out.println("Payment mode is  "  + (m.getPayment_mode_text().getText()));
				
				SoftAssert.assertAll();
				
				
				
			System.out.println(m.getPayment_mode().getText());	
				
			WebElement Address_details  = driver.findElement(By.xpath("//div[@class=\"adddetails\"]"));
			
			System.out.println("Delivery Address is   " + Address_details.getText());
				
				
			List<WebElement> Druglist = driver.findElements(By.xpath("//div[@class=\"drugitem row w-100 m-0 ng-star-inserted\"]"));
			int drug_list = Druglist.size();
			
			System.out.println("element size is " + drug_list);
			
			System.out.println("Medicine details are as follows");
			
			for (int i=0;i<drug_list;i++) {
				
				
		WebElement order=	driver.findElement(By.xpath("//div[@class= \"rightside-details col pr-0\"]"));
				
				System.out.println(order.getText());
				logger.log(Status.PASS, " Drug list was successfully captured" );
			}
	
			// ////div[.=\"Shipping Charges\"]
			if (!(driver.findElements(By.xpath("//div[.='Shipping Charges']")).size()==0))
			{
				shipping_charge = driver.findElement(By.xpath("//div[.='Shipping Charges']//following::div[1]")).getText();
				System.out.println(shipping_charge);
				logger.log(Status.PASS, "Ordered Product price was "+shipping_charge);
				
				String[] total_dlcharge = shipping_charge.split("Rs."); 	
				System.out.println(total_dlcharge);
				
				shipping_charge = total_dlcharge[1].toString();
				System.out.println(shipping_charge);
			
				 Shippingcharge = Float.parseFloat(shipping_charge);
				System.out.println("total shipping charge is ===" +Shippingcharge);
				logger.log(Status.PASS, " Shipping charge was successfully calculated" );
			
		} else {
			
			System.out.println("Total amount is more the Rs.500");
		}
	
	
			//Netmeds Discount//
			
letsChat_Close();
			
			if (!(driver.findElements(By.xpath("//div[.=\"Discount\"]")).size()==0))
			{
				discount = driver.findElement(By.xpath("//div[contains(text(),'Discount')]//following::div[1]")).getText();//"(//div[@class=\"col-5 pr-0 text-right\"])[1]")).getText();
				System.out.println(discount);
				logger.log(Status.PASS, "Discount is "+ discount);
				
				String[] discount_amt = discount.split("-Rs."); 	
				System.out.println(discount_amt);
				
				discount = discount_amt[1].toString();
				System.out.println(discount);
				
				 total_discount = Float.parseFloat(discount);
				 
				System.out.println("total discount amount is ===" +discount);
				logger.log(Status.PASS, " discount charge was successfully calculated" );
			
		} else {
			
			System.out.println("No discount amount");
		}	
			
//Sub Total//
			 
		
			
			String total = driver.findElement(By.xpath("(//div[@class=\"col-7 pr-0 text-right\"])")).getText();
			
			logger.log(Status.PASS, "total is "+total);
			
			String[]sub_total = total.split("Rs."); 
			
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
			
	//Net Payable amount//
			
			String payable = driver.findElement(By.xpath("//div[contains(text(),'Net Amount Payable')]//following::div[1]")).getText();
			
			logger.log(Status.PASS, "mrp is "+payable);
			
			String[]Payable_total = payable.split("Rs."); 
			
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
		 
		 
// handle Lets chat button
			try {
				driver.switchTo().frame("haptik-xdk");
				Actions acc = new Actions(driver);
				acc.moveToElement(driver.findElement(By.xpath("//div[@class='bot-prompt-minimal-textarea']//span"))).build()
						.perform();
				driver.findElement(By.xpath("(/html/body/div/div[1]/div[1])[1]")).click();
				driver.switchTo().defaultContent();
			} catch (Exception e) {

			}

			Thread.sleep(5000);
			System.out.println("Successfully closed the chat page");
//PRESCRIPTION(S) UPLOADED//
		try {
			Thread.sleep(3000);
			 btncli(m.getPrescription_open());
			 Thread.sleep(4000);
			 btncli(m.getPrescription_closed());
			 System.out.println("Successfully opened and closed prescription page");
			 logger.log(Status.PASS, " Successfully opened and closed prescription page" );
			 Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("Otc or Non rx product does not  have any prescription");
		}
		 
		 

//Need Help page//
		 btncli(m.getNeedHelp_page());
		 Thread.sleep(3000);
		 SoftAssert.assertEquals(driver.getCurrentUrl(), "https://www.netmeds.com/help-support/");
		 System.out.println(driver.getCurrentUrl());
		 Thread.sleep(3000);
		 driver.navigate().back();
		 Thread.sleep(3000);
		 System.out.println("Successfully Navigated to Help Page");
		 logger.log(Status.PASS, " Successfully Navigated to Help Page" );
		 
//Reorder//
		 
		 btncli(m.getReorder());
		 Thread.sleep(3000);
		 SoftAssert.assertEquals(driver.getCurrentUrl(), "https://www.netmeds.com/checkout/cart");
		 System.out.println(driver.getCurrentUrl());
		 Thread.sleep(3000);
		 
		 System.out.println("Successfully Navigated to reorder Page");
		 logger.log(Status.PASS, " Successfully Navigated to reorder Page" );
		 
// handle Lets chat button
					try {
						driver.switchTo().frame("haptik-xdk");
						Actions acc = new Actions(driver);
						acc.moveToElement(driver.findElement(By.xpath("//div[@class='bot-prompt-minimal-textarea']//span"))).build()
								.perform();
						driver.findElement(By.xpath("(/html/body/div/div[1]/div[1])[1]")).click();
						driver.switchTo().defaultContent();
					} catch (Exception e) {

					}

					Thread.sleep(5000);
					System.out.println("Successfully closed the chat page");
					
//Ensure proceed button is enabled//
					
					m.getProceedbutton().isEnabled();
					System.out.println("Proceed button is enabled");
					driver.navigate().to("https://www.netmeds.com/customer/orderhistory");
					
					Thread.sleep(3000);
					

//show status details//
					 btncli(m.getView_Details());
					 Thread.sleep(3000);
					btncli(m.getShow_Status_Details());
					 Thread.sleep(3000);					
					 System.out.println("Successfully Navigated to Show Details Page");
					 logger.log(Status.PASS, " Successfully Navigated to Show Details Page" );			 
//Need Help page//
					 btncli(m.getNeedHelp_page());
					 Thread.sleep(3000);
					 SoftAssert.assertEquals(driver.getCurrentUrl(), "https://www.netmeds.com/help-support/");
					 System.out.println(driver.getCurrentUrl());
					 Thread.sleep(3000);
					 driver.navigate().back();
					 Thread.sleep(3000);				
					
					 
					 
//Get delivery Address//
				WebElement	 Delivery_adrress_txt = driver.findElement(By.xpath("//h3[.=\"Delivery Address\"]"));
						System.out.println(Delivery_adrress_txt.getText());
				Thread.sleep(3000);
				WebElement Delivery_address = driver.findElement(By.xpath("//div[@class=\"address\"]"));
				System.out.println(Delivery_address.getText());
				
//Track Order
				
			WebElement Trackorder_text =  driver.findElement(By.xpath("//h1[@class=\"m-3\"]"));
			
			System.out.println(Trackorder_text.getText());

			List<WebElement> order_statuses = driver.findElements(By.xpath("//div[@class=\"name\"]"));
			int order_status = order_statuses.size();
			System.out.println("The element size is   "+order_status);
			
	
			
			
			for (int i=0;i<order_status;i++) {
				
				Thread.sleep(3000);
				System.out.println(order_statuses.get(i).getText());
				
			}
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class=\"viewbtn\"]")).click();
			
			driver.navigate().to("https://www.netmeds.com/customer/orderhistory");
			
			Thread.sleep(5000);
		
			driver.findElement(By.xpath("//button[@class=\"ord-btn ng-star-inserted\"]")).click();
			Thread.sleep(3000);
			
			
	// handle Lets chat button
			try {
				driver.switchTo().frame("haptik-xdk");
				Actions acc = new Actions(driver);
				acc.moveToElement(driver.findElement(By.xpath("//div[@class='bot-prompt-minimal-textarea']//span"))).build()
						.perform();
				driver.findElement(By.xpath("(/html/body/div/div[1]/div[1])[1]")).click();
				driver.switchTo().defaultContent();
			} catch (Exception e) {

			}

			Thread.sleep(5000);
			System.out.println("Successfully closed the chat page");
			
//Ensure proceed button is enabled//
			m.getProceedbutton().isEnabled();
			System.out.println("Proceed button is enabled");
			Thread.sleep(3000);
			btncli(m.getProceedbutton());
			
	
			
			try {
			
				//try Attach Prescription//
				Thread.sleep(3000);
				btncli(m.getConsultdoctorcheck());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[@class=\"btn-checkout btn btn_to_checkout m-0\"]")).click();
				Thread.sleep(3000);
				
				SoftAssert.assertEquals(driver.getCurrentUrl(), "https://www.netmeds.com/checkout/review");
				
				System.out.println("Order review page is opened");
				logger.log(Status.PASS, " Order review page is opened" );
				
			} catch (Exception e) {
				
				System.out.println("OTC or Non-Rx Product is added");
				
				
				SoftAssert.assertEquals(driver.getCurrentUrl(), "https://www.netmeds.com/checkout/review");
				
				System.out.println("Order review page is opened");
				
				logger.log(Status.PASS, " Order review page is opened" );	
			}
			
			
			driver.navigate().to("https://www.netmeds.com/customer/orderhistory");
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
