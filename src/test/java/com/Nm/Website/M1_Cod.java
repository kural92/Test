package com.Nm.Website;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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



/*

Scenario 1 : Order Total was Above Rs.60 and below Rs.5000
1.login
2.Remove Product
3.Search and Added the product to cart
4.Click on Cart and and click on proceed .
5.Check and choose Schedule Doctor consultation if RX required
6.Click on pay and landed into payment page.
7.Check the total amount if it was above 60 and below 5000 .
8.Check for the condition and verify the COD was available and order the Product 
8.Click on track order--> View Details--> Cancel the order with reason.

Scenario 2 : Order Total was Above  Rs.5000
1.login
2.Remove Product
3.Search and Added the product to cart
4.Click on Cart and and click on proceed .
5.Check and choose Schedule Doctor consultation if RX required
6.Click on pay and landed into payment page.
7.Check the total amount if it was above 5000 .
8.Check for the condition and verify the COD was not available.




 */
public class M1_Cod extends BaseClass {

	static String amt;
	
	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//report//M1_COD_Flow.html");

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

	@Test(priority = 1)
	public void cash_On_delivery_Check() throws Throwable {

		logger = report.createTest("M1 Flow To Check Payment Method");
		logger.log(Status.PASS, "************* Cash On Delivery Below Rs.5000********************");
		Monepom m = new Monepom();
		Robot r = new Robot();

		// Login
		
			driver.manage().window().maximize();
			btncli(m.getSignin());
			Thread.sleep(5000);
			type(m.getMobileno(), "8098882244");
			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
			Thread.sleep(3000);
			type(m.getPassword(), "Netmeds123");
			btncli(m.getSignInpage());
		

		//////////////

/////////////  Remove Product //

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
		Thread.sleep(3000);
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size() == 0)) {

				try {
					btncli(m.getRemovebutton());
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else {
				break;

			}

		}

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/");

		//////////////////////////

		//////////////////////////

		Thread.sleep(3000);
		for (int i = 0; i < 3; i++) {
			Thread.sleep(5000);
			type(m.getSearch(), BaseClass.getExcelData("COD_Check", i, 0));
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			//btncli(m.getSearchIcon());
			logger.log(Status.PASS, "Successfully Added  " + BaseClass.getExcelData("COD_Check", i, 0));

			String Cart_Excel = BaseClass.getExcelData("COD_Check", i, 1);
			try {
				Thread.sleep(3000);

				WebElement Cart_btn = driver.findElement(By.xpath("//div[contains(text(),'" + Cart_Excel
						+ "')]//following::span[contains(text(),'ADD TO CART')]"));
				Thread.sleep(3000);
				btncli(Cart_btn);
				// btncli(m.getAddtocart());
			} catch (Exception e) {

			}
			Thread.sleep(3000);
			driver.navigate().back();

			Thread.sleep(3000);
		}

		btncli(m.getMinicart());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigated to cart page");

		

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

		//////////////////////////////////

		Thread.sleep(3000);
		btncli(m.getProceedbutton());

		try {
			Thread.sleep(3000);
			btncli(driver.findElement(By.id("externaldoctr")));
			logger.log(Status.PASS, "Successfully navigated to Attach Prescription page");
			logger.log(Status.PASS, "Successfully Selected the Schedule FREE doctor Consultation");

			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("//button[contains(text(),'Review Order')]")));

		} catch (Exception e) {

		}
		Thread.sleep(3000);

		logger.log(Status.PASS, "Successfully navigated to  order review page");
		
		Thread.sleep(3000);
		btncli(m.getPaybutton());
		logger.log(Status.PASS, "Successfully navigated to Payment Page");
		
		Thread.sleep(5000);
			String Net = driver.findElement(By.id("cart_netpay_amt1")).getText();
			System.out.println(Net);
			logger.log(Status.PASS, "Ordered Product price was "+Net);
			String[] Net_P = Net.split("Rs.");  //String a = element.getText();  String[] id = a.split(" : ");  String ab = id[1].toString();
			
			// Conditon to check the payment amount
			if (Net_P[1].contains(",")) {
				
				 amt = Net_P[1].replace(",", "");
				
			} else {
				
			amt = Net_P[1].toString();
				
			}
			
			String Net_Pa =amt.toString();
				
			System.out.println(Net_Pa);
			
			 
			Float Net_Pay = Float.parseFloat(Net_Pa);
		//	int Net_Pay = Integer.parseInt(Net_Pa);
			System.out.println(Net_Pay);
			
			Thread.sleep(3000);
		    if (Net_Pay>60.00 || Net_Pay<5000.00) {
				// Check Cash On Deleivery Enabled 
		    	Thread.sleep(3000);
		    	if (!(driver.findElements(By.id("nms_cod")).size()==0)) {
		    		
					if (!(driver.findElement(By.id("nms_cod")).isSelected())) {
						Thread.sleep(3000);
						btncli(driver.findElement(By.id("nms_cod")));
						logger.log(Status.PASS, "Successfully Clicked on Cash on Delivery");
						
						Thread.sleep(3000);
						btncli(driver.findElement(By.xpath("(//button[contains(text(),'Pay Rs')])[9]")));
						
						Thread.sleep(3000);
						//System.out.println(driver.findElement(By.xpath("(//span[@class='order-number'])[2]")).getText());
						
						Thread.sleep(6000);
						btncli(driver.findElement(By.xpath("(//button[contains(text(),'Track Order')])[2]")));
						
						Thread.sleep(10000);
						logger.log(Status.PASS, "Successfully navigated to Medicine Order page");
						
						btncli(m.getView_Details());
						Thread.sleep(6000);
						
						
						btncli(m.getCancel_Order());
						Thread.sleep(3000);
						btncli(m.getCancel_reason());
						Thread.sleep(3000);
						btncli(m.getSubmit_Cancel());
						Thread.sleep(3000);
						 logger.log(Status.PASS, "Successfully Order was Cancelled" );
						
					} else {
						
						System.out.println("The COD Option was Already Selected");
					}
					
		    		
				} else {
					Thread.sleep(3000);
					List<WebElement> cod = driver.findElements(By.xpath("//div[contains(text(),'Cash on Delivery')]"));
					int a = cod.size();
					
					Thread.sleep(3000);
					if (a==0) {
						System.out.println("There is no Cash on Delivery Option to Choose ");
						logger.log(Status.PASS, "There is no Cash on Delivery Option to Choose");
					}
					
					
					//SoftAssert asser = new SoftAssert();
				//	assertEquals(gettext(driver.findElement(By.xpath("//div[contains(text(),'Cash on Delivery')]"))), "Cash on Delivery");
					
				}
		    	
			} else {
				
				System.out.println("The Ordered Amount was less than Rs.60 or Greater that Rs.5000");
				logger.log(Status.PASS, "The Ordered Amount was less that Rs.60 or Greater that Rs.5000");

			}
		

	}
	
	
	

	@Test(priority = 2)
	public void cash_On_delivery_Check_5000() throws Throwable {
		
		logger = report.createTest("M1 Flow To Check Payment Method");
		logger.log(Status.PASS, "************* Cash On Delivery Above Rs.5000********************");
		Monepom m = new Monepom();
		Robot r = new Robot();

		// Login
		try {
			driver.manage().window().maximize();
			btncli(m.getSignin());
			Thread.sleep(5000);
			type(m.getMobileno(), "8098882244");
			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
			Thread.sleep(3000);
			type(m.getPassword(), "Netmeds123");
			btncli(m.getSignInpage());
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		//////////////

/////////////  Remove Product //
/*
		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
		Thread.sleep(3000);
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size() == 0)) {

				try {
					btncli(m.getRemovebutton());
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else {
				break;

			}

		}
*/
		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/");

		//////////////////////////

		//////////////////////////

		Thread.sleep(3000);
		for (int i = 3; i < 6; i++) {
			Thread.sleep(5000);
			type(m.getSearch(), BaseClass.getExcelData("COD_Check", i, 0));
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			//btncli(m.getSearchIcon());
			logger.log(Status.PASS, "Successfully Added  " + BaseClass.getExcelData("COD_Check", i, 0));

			String Cart_Excel = BaseClass.getExcelData("COD_Check", i, 1);
			try {
				Thread.sleep(3000);

				WebElement Cart_btn = driver.findElement(By.xpath("//div[contains(text(),'" + Cart_Excel
						+ "')]//following::span[contains(text(),'ADD TO CART')]"));
				Thread.sleep(3000);
				btncli(Cart_btn);
				// btncli(m.getAddtocart());
			} catch (Exception e) {

			}
			Thread.sleep(3000);
			driver.navigate().back();

			Thread.sleep(3000);
		}

		btncli(m.getMinicart());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigated to cart page");

		

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

		//////////////////////////////////

		Thread.sleep(3000);
		btncli(m.getProceedbutton());

		try {
			Thread.sleep(3000);
			btncli(driver.findElement(By.id("externaldoctr")));
			logger.log(Status.PASS, "Successfully navigated to Attach Prescription page");
			logger.log(Status.PASS, "Successfully Selected the Schedule FREE doctor Consultation");

			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("//button[contains(text(),'Review Order')]")));

		} catch (Exception e) {

		}
		Thread.sleep(3000);

		logger.log(Status.PASS, "Successfully navigated to  order review page");
		
		Thread.sleep(3000);
		btncli(m.getPaybutton());
		logger.log(Status.PASS, "Successfully navigated to Payment Page");
		
		Thread.sleep(5000);
			String Net = driver.findElement(By.id("cart_netpay_amt1")).getText();
			System.out.println(Net);
			logger.log(Status.PASS, "Ordered Product price was "+Net);
			String[] Net_P = Net.split("Rs.");  //String a = element.getText();  String[] id = a.split(" : ");  String ab = id[1].toString();
			
			// Conditon to check the payment amount
			if (Net_P[1].contains(",")) {
				
				 amt = Net_P[1].replace(",", "");
				
			} else {
				
			amt = Net_P[1].toString();
				
			}
			
			String Net_Pa =amt.toString();
				
			System.out.println(Net_Pa);
			
			 
			Float Net_Pay = Float.parseFloat(Net_Pa);
		//	int Net_Pay = Integer.parseInt(Net_Pa);
			System.out.println(Net_Pay);
			
			Thread.sleep(3000);
		    if (Net_Pay>60.00 || Net_Pay<5000.00) {
				// Check Cash On Deleivery Enabled 
		    	Thread.sleep(3000);
		    	if (!(driver.findElements(By.id("nms_cod")).size()==0)) {
		    		
					if (!(driver.findElement(By.id("nms_cod")).isSelected())) {
						Thread.sleep(3000);
						btncli(driver.findElement(By.id("nms_cod")));
						logger.log(Status.PASS, "Successfully Clicked on Cash on Delivery");
						
						Thread.sleep(3000);
						btncli(driver.findElement(By.xpath("(//button[contains(text(),'Pay Rs')])[9]")));
						
						Thread.sleep(3000);
						//System.out.println(driver.findElement(By.xpath("(//span[@class='order-number'])[2]")).getText());
						
						Thread.sleep(6000);
						btncli(driver.findElement(By.xpath("(//button[contains(text(),'Track Order')])[2]")));
						
						Thread.sleep(10000);
						logger.log(Status.PASS, "Successfully navigated to Medicine Order page");
						
						btncli(m.getView_Details());
						Thread.sleep(6000);
						
						
						btncli(m.getCancel_Order());
						Thread.sleep(3000);
						btncli(m.getCancel_reason());
						Thread.sleep(3000);
						btncli(m.getSubmit_Cancel());
						Thread.sleep(3000);
						 logger.log(Status.PASS, "Successfully Order was Cancelled" );
						
					} else {
						
						System.out.println("The COD Option was Already Selected");
					}
					
		    		
				} else {
					Thread.sleep(3000);
					List<WebElement> cod = driver.findElements(By.xpath("//div[contains(text(),'Cash on Delivery')]"));
					int a = cod.size();
					
					Thread.sleep(3000);
					if (a==0) {
						System.out.println("There is no Cash on Delivery Option to Choose ");
						logger.log(Status.PASS, "There is no Cash on Delivery Option to Choose");
					}
					
					
					//SoftAssert asser = new SoftAssert();
				//	assertEquals(gettext(driver.findElement(By.xpath("//div[contains(text(),'Cash on Delivery')]"))), "Cash on Delivery");
					
				}
		    	
			} else {
				
				System.out.println("The Ordered Amount was less than Rs.60 or Greater that Rs.5000");
				logger.log(Status.PASS, "The Ordered Amount was less that Rs.60 or Greater that Rs.5000");

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
