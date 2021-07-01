package com.Nm.Website;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class M2_Flow_Search extends BaseClass {

	
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
	   public void startReport() {
	   	
	      htmlReporter = new ExtentHtmlReporter(".//report//M2_Flow.html");
	       
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
	       htmlReporter.config().setReportName("Netmeds.com");

	       //htmlReporter.config().setTheme(Theme.STANDARD);
	   	
	   }
	
	
	
		@Test(enabled = true)
		public  void m2_searchMedicine() throws Throwable  {
			logger =  report.createTest("M2 Search and Add Medicine - Past RX");
			logger.log(Status.PASS, "************* Search Medicine Flow********************" );
			Monepom m=new Monepom();
			
		
			try {
			 driver.manage().window().maximize();
			 btncli(m.getSignin());
			  Thread.sleep(5000);
			  type(m.getMobileno(),"7010752043");
			  Thread.sleep(3000);
			  btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
			  Thread.sleep(3000);
			  type(m.getPassword(),"Change@92"); 
			  btncli(m.getSignInpage());
			} catch (Exception e) {
				System.out.println("Already Logged In");
			}
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigated to home page" );
			Thread.sleep(3000);
			
			
			btncli(m.getUpload_cta());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigated to Add Prescription page" );
			/*
			type(mm.getUpload_Rx(), "C:\\Users\\NMSLAP356\\Desktop\\Screen-Net\\M2 Pay");
			Thread.sleep(3000);
			*/
			btncli(m.getPast_Rx());
			Thread.sleep(3000);
			
			if (driver.findElement(By.xpath("//input[@name='m2pastVerifiedRx']")).isSelected()) {
				 System.out.println("Prescription already Selected with Past RX");
			} else {
				btncli(driver.findElement(By.xpath("//input[@name='m2pastVerifiedRx']")));
			
			}
		//	btncli(driver.findElement(By.xpath("//input[@name='m2pastVerifiedRx']")));
			Thread.sleep(3000);
			
			
			btncli(driver.findElement(By.xpath("(//button[@class='close'])[2]")));
			Thread.sleep(3000);
			logger.log(Status.PASS, "Added the Past RX Prescription" );
			
			
		//////////// Get Call From Netmeds	
			
			
			
		/*
			btncli(mm.getGet_call());
			Thread.sleep(3000);
			
				btncli(m.getContinue_cta());
			Thread.sleep(5000);
			
			*/
			
			
			////////////  Search Medicines
			
			
			
			if (!(m.getSearch_Medicines().isSelected())) {
				
				btncli(m.getSearch_Medicines());
				 Thread.sleep(3000);
			} else {
				
				
			}
			logger.log(Status.PASS, "Successfully Clicked on Search Medicines" );
			 
				btncli(m.getContinue_cta());
				Thread.sleep(5000);
				
				logger.log(Status.PASS, "Successfully navigated to Search Medicine Page" );
			 
			 btncli(driver.findElement(By.xpath("(//input[@type='text'])[3]")));
			 Thread.sleep(3000);
			 
			 type(driver.findElement(By.xpath("(//input[@type='text'])[3]")), "telma");
			 Thread.sleep(3000);
			 
			 btncli(driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")));
			 Thread.sleep(3000);
			 
			 logger.log(Status.PASS, "Successfully Product was searched and added to the cart" );
			 
			 btncli(driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")));
			 Thread.sleep(10000);
			
		//////////////////////////////
			
			btncli(m.getConfirm_Order_cta());
			Thread.sleep(6000);
			
			 logger.log(Status.PASS, "Successfully Placed the Order" );
			/*
			String Order_message =  mm.getOrder_Placed_text().getText();
			System.err.println(Order_message);
			Thread.sleep(3000);
			*/
			btncli(m.getTrack_Order());
			Thread.sleep(10000);
			
			
			btncli(m.getView_Details());
			Thread.sleep(6000);
			
			
			btncli(m.getCancel_Order());
			Thread.sleep(3000);
			btncli(m.getCancel_reason());
			Thread.sleep(3000);
			btncli(m.getSubmit_Cancel());
			Thread.sleep(3000);
			 logger.log(Status.PASS, "Successfully Order was Cancelled" );
			
			
			
			
			
			

		}
		
		
		
		
		@Test(enabled = true)
		public void m2_getCall() throws Throwable {
			
			logger =  report.createTest("M2 Get Call From netmeds Past RX");
			logger.log(Status.PASS, "************* Get Call Flow********************" );
			Monepom m=new Monepom();
			//M2_Flow_POM mm = new M2_Flow_POM();
			try {
				 driver.manage().window().maximize();
				 btncli(m.getSignin());
				  Thread.sleep(5000);
				  type(m.getMobileno(),"7010752043");
				  Thread.sleep(3000);
				  btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
				  Thread.sleep(3000);
				  type(m.getPassword(),"Change@92"); 
				  btncli(m.getSignInpage());
				} catch (Exception e) {
					System.out.println("Already Logged In");
				}
			logger.log(Status.PASS, "Successfully navigate to home page" );
			Thread.sleep(3000);
			
			
			btncli(m.getUpload_cta());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigated to Add Prescription page" );
			/*
			type(m.getUpload_Rx(), "C:\\Users\\NMSLAP356\\Desktop\\Screen-Net\\M2 Pay");
			Thread.sleep(3000);
			*/
			btncli(m.getPast_Rx());
			Thread.sleep(3000);
			
			if (driver.findElement(By.xpath("//input[@name='m2pastVerifiedRx']")).isSelected()) {
				 System.out.println("Prescription already Selected with Past RX");
			} else {
				btncli(driver.findElement(By.xpath("//input[@name='m2pastVerifiedRx']")));
			
			}
		//	btncli(driver.findElement(By.xpath("//input[@name='m2pastVerifiedRx']")));
			Thread.sleep(3000);
			
			
			btncli(driver.findElement(By.xpath("(//button[@class='close'])[2]")));
			Thread.sleep(3000);
			logger.log(Status.PASS, "Added the Past RX Prescription" );
			
			
		//////////// Get Call From Netmeds	
			
			
			
		
			btncli(m.getGet_call());
			Thread.sleep(3000);
			
				btncli(m.getContinue_cta());
			Thread.sleep(5000);
			
		
			logger.log(Status.PASS, "Successfully Clicked on Search Medicines" );
			
			////////////  Search Medicines
			
			
		
		//////////////////////////////
			
			btncli(m.getConfirm_Order_cta());
			Thread.sleep(6000);
			
			 logger.log(Status.PASS, "Successfully Placed the Order" );
			/*
			String Order_message =  m.getOrder_Placed_text().getText();
			System.err.println(Order_message);
			Thread.sleep(3000);
			*/
			btncli(m.getTrack_Order());
			Thread.sleep(10000);
			
			
			btncli(m.getView_Details());
			Thread.sleep(6000);
			
			
			btncli(m.getCancel_Order());
			Thread.sleep(3000);
			btncli(m.getCancel_reason());
			Thread.sleep(3000);
			btncli(m.getSubmit_Cancel());
			Thread.sleep(3000);
			
			 logger.log(Status.PASS, "Successfully Order was Cancelled" );
			 
			 
			 
			
			

		}
		
		
		
		@Test(enabled = true)
		public void autoIt_Upload() throws Throwable {
			
			logger =  report.createTest("M2 Get Call From netmeds - Upload Prescription");
			logger.log(Status.PASS, "************* Get Call Flow********************" );
			Monepom m=new Monepom();
			//M2_Flow_POM mm = new M2_Flow_POM();
			
			try {
				 driver.manage().window().maximize();
				 btncli(m.getSignin());
				  Thread.sleep(5000);
				  type(m.getMobileno(),"7010752043");
				  Thread.sleep(3000);
				  btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
				  Thread.sleep(3000);
				  type(m.getPassword(),"Change@92"); 
				  btncli(m.getSignInpage());
				} catch (Exception e) {
					System.out.println("Already Logged In");
				}
			
			logger.log(Status.PASS, "Successfully navigate to home page" );
			Thread.sleep(5000);
			
			
			btncli(m.getUpload_cta());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigated to Add Prescription page" );
			
			
			Thread.sleep(5000);
			btncli(driver.findElement(By.xpath("//label[@class='up-fileupload']")));
			
			// Auto IT Script
			Thread.sleep(5000);
			Runtime.getRuntime().exec("D:\\AutoIT\\FileUpload.exe");
			
			
			Thread.sleep(3000);
			logger.log(Status.PASS, "Prescription Uploaded Sucessfully" );
			
			
		//////////// Get Call From Netmeds	
			
			
			
		
			btncli(m.getGet_call());
			Thread.sleep(3000);
			
				btncli(m.getContinue_cta());
			Thread.sleep(5000);
			
		
			logger.log(Status.PASS, "Successfully Clicked on Search Medicines" );
			
			////////////  Search Medicines
			
			
		
		//////////////////////////////
			
			btncli(m.getConfirm_Order_cta());
			Thread.sleep(6000);
			
			 logger.log(Status.PASS, "Successfully Placed the Order" );
			/*
			String Order_message =  mm.getOrder_Placed_text().getText();
			System.err.println(Order_message);
			Thread.sleep(3000);
			*/
			btncli(m.getTrack_Order());
			Thread.sleep(10000);
			
			
			btncli(m.getView_Details());
			Thread.sleep(6000);
			
			
			btncli(m.getCancel_Order());
			Thread.sleep(3000);
			btncli(m.getCancel_reason());
			Thread.sleep(3000);
			btncli(m.getSubmit_Cancel());
			Thread.sleep(3000);
			
			 logger.log(Status.PASS, "Successfully Order was Cancelled" );
			 
			 
			 
			
			
			
			
			
		}
		
		@Test(enabled = true)
		public void autoIt_Upload_SearchMedicine() throws Throwable {
			
			logger =  report.createTest("M2 Search and Add Medicine - Upload Prescription");
			logger.log(Status.PASS, "************* Get Call Flow********************" );
			Monepom m=new Monepom();
		//	M2_Flow_POM mm = new M2_Flow_POM();
			
			try {
				 driver.manage().window().maximize();
				 btncli(m.getSignin());
				  Thread.sleep(5000);
				  type(m.getMobileno(),"7010752043");
				  Thread.sleep(3000);
				  btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
				  Thread.sleep(3000);
				  type(m.getPassword(),"Change@92"); 
				  btncli(m.getSignInpage());
				} catch (Exception e) {
					System.out.println("Already Logged In");
				}
			
			logger.log(Status.PASS, "Successfully navigate to home page" );
			Thread.sleep(5000);
			
			
			btncli(m.getUpload_cta());
			Thread.sleep(3000);
			logger.log(Status.PASS, "Successfully navigated to Add Prescription page" );
			
			
			Thread.sleep(5000);
			btncli(driver.findElement(By.xpath("//label[@class='up-fileupload']")));
			
			// Auto IT Script
			Thread.sleep(5000);
			Runtime.getRuntime().exec("D:\\AutoIT\\FileUpload.exe");
			
			
			Thread.sleep(3000);
			logger.log(Status.PASS, "Prescription Uploaded Sucessfully" );
			
			Thread.sleep(5000);
		//////////// Get Call From Netmeds	
	if (!(m.getSearch_Medicines().isSelected())) {
				
				btncli(m.getSearch_Medicines());
				 Thread.sleep(3000);
			} else {
				
				
			}
			logger.log(Status.PASS, "Successfully Clicked on Search Medicines" );
			 
				btncli(m.getContinue_cta());
				Thread.sleep(5000);
				
				logger.log(Status.PASS, "Successfully navigated to Search Medicine Page" );
			 
			 btncli(driver.findElement(By.xpath("(//input[@type='text'])[3]")));
			 Thread.sleep(3000);
			 
			 type(driver.findElement(By.xpath("(//input[@type='text'])[3]")), "telma");
			 Thread.sleep(3000);
			 
			 btncli(driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]")));
			 Thread.sleep(3000);
			 
			 logger.log(Status.PASS, "Successfully Product was searched and added to the cart" );
			 
			 btncli(driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")));
			 Thread.sleep(10000);
			
		//////////////////////////////
			
			btncli(m.getConfirm_Order_cta());
			Thread.sleep(6000);
			
			 logger.log(Status.PASS, "Successfully Placed the Order" );
			/*
			String Order_message =  mm.getOrder_Placed_text().getText();
			System.err.println(Order_message);
			Thread.sleep(3000);
			*/
			btncli(m.getTrack_Order());
			Thread.sleep(10000);
			
			
			btncli(m.getView_Details());
			Thread.sleep(6000);
			
			
			btncli(m.getCancel_Order());
			Thread.sleep(3000);
			btncli(m.getCancel_reason());
			Thread.sleep(3000);
			btncli(m.getSubmit_Cancel());
			Thread.sleep(3000);
			 logger.log(Status.PASS, "Successfully Order was Cancelled" );
			
			
			
			
			
			
			
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


		
		
		
		


