package com.Nm.Website_live;

import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

 1.Login
 2.Remove Product
 3.Search and Added "Boostrix Injection" Cold STorage Product
 4.From Cart clicked Proceed Button
 5.From Prescription screen choosed schedule doctor consultation
 6.Click on Change Address- change pincode from 600100 to 180001 and 600055
 7.Check the Take Action message for Cold Storage
 8.Check COLD STORAGE Text if the Pin Undeliverable
 9.Again changed the address pincode into 600100
 
 
 */

public class ColdStorage extends BaseClass {

	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//Report//ColdStorage_Deleivery_Check.html");

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

	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void coldStorage_DeliveryCheck() throws Throwable {
		
		
		

		logger = report.createTest("M1 Flow To Check Payment Method");
		logger.log(Status.PASS, "************* Cash On Delivery ********************");
		Monepom m = new Monepom();

		// Login

		driver.manage().window().maximize();
		btncli(m.getSignin());
		Thread.sleep(5000);
		type(m.getMobileno(), "8098882244");
		Thread.sleep(3000);
		//btncli(driver.findElement(By.xpath("//button[contains(text(),4'USE PASSWORD')]")));
		btncli(driver.findElement(By.xpath("//a[@class='btn-social btn-google']")));
		Thread.sleep(3000);
	//	type(m.getPassword(), "Netmeds123");
	//	btncli(m.getSignInpage());

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
		for (int i = 0; i < 1; i++) {
			Thread.sleep(5000);
			type(m.getSearch(), BaseClass.getExcelData("ColdStorage", i, 0));
			m.getSearch().sendKeys(Keys.ENTER);
			//btncli(m.getSearchIcon());
			logger.log(Status.PASS, "Successfully Added  " + BaseClass.getExcelData("ColdStorage", i, 0));

			String Cart_Excel = BaseClass.getExcelData("ColdStorage", i, 1);
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

			
		}
		
		
		Thread.sleep(3000);
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

		
		
		
		////////////////////
		
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
		

		logger.log(Status.PASS, "Successfully navigated to  order review page");
		
		/*
		Thread.sleep(3000);
		String Text = gettext(driver.findElement(By.xpath("(//div[@class='info ng-star-inserted'])[2]")));
		System.out.println(Text);
		logger.log(Status.PASS, Text);
		*/
		
		
		
		////////////
		
		
		
		
		
		
		
		
		
		
		
		//Change Address
		 Thread.sleep(3000);
		 btncli(m.getM2_ChangeAdress_btn());
		 logger.log(Status.PASS, "Successfully Clicked on Change Address" );
			
		// Modify Address 
			
				
				for (int i = 0; i < 3; i++) {
					
					try {
						 Thread.sleep(3000);
						 btncli(m.getM2_ChangeAdress_btn());
						} catch (Exception e) {
							// TODO: handle exception
						}
						 Thread.sleep(3000);
						 btncli(m.getM2_Addres_Modify());
							Thread.sleep(2000);
							
					Thread.sleep(3000);
					m.getM2_Address_Pin().clear();
					Thread.sleep(1000);
					type(m.getM2_Address_Pin(), BaseClass.getExcelData("ColdStorage", i, 2));
				
					Thread.sleep(3000);
					btncli(m.getM2_SaveAddress_btn()); 
					logger.log(Status.PASS, "Successfully Saved the New Address with Pincode :"+  BaseClass.getExcelData("ColdStorage", i, 2) );
					
				

					Thread.sleep(3000);
					btncli(driver.findElement(By.xpath("//div[@class='addressitem selected-item']")));
				
					try {
						Thread.sleep(3000);
						SoftAssert asser = new SoftAssert();
						asser.assertEquals(gettext(driver.findElement(By.xpath("//span[contains(text(),'COLD STORAGE')]"))), "COLD STORAGE");
						System.out.println(gettext(driver.findElement(By.xpath("//span[contains(text(),'COLD STORAGE')]"))));
						logger.log(Status.PASS, gettext(driver.findElement(By.xpath("//span[contains(text(),'COLD STORAGE')]"))));
						
					Thread.sleep(5000);
					String Text1 = gettext(driver.findElement(By.xpath("(//div[@class='info ng-star-inserted'])[2]")));
					System.out.println(Text1 +" : "+BaseClass.getExcelData("ColdStorage", i, 2));
					logger.log(Status.PASS, Text1+" : "+BaseClass.getExcelData("ColdStorage", i, 2));
					
					
					
					} catch (Exception e) {
						
						System.out.println("Cold Storage Product delivery Available at this pincode : "+ BaseClass.getExcelData("ColdStorage", i, 2));
						logger.log(Status.PASS, "Cold Storage Product delivery Available at this pincode : "+ BaseClass.getExcelData("ColdStorage", i, 2));
						
						
					}
					
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
	public void tearDown() throws Throwable {
		
		report.flush();
		
		driver.quit();

	}
	
	
	

}
