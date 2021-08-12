package com.Nm.website_stage;

import java.awt.Robot;
import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.Nm.Website_live.RetryAnalyzer;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


/*

1.Login
2.Remove the Product from Cart
3.Search the Product and Open PDP page
4.From PDP page Added the Product to the Cart
5.Check for Alternate brand . if present click on the Add to cart Symbol
6.In cart Page. Click and Add Most Selling Product to cart
7.Click on Most Selling Product and landed into the PDP page 
8.From PDP page product was added to cart.
9.Click on Proceed and choose the Schedule Doctor consulatation if RX product
10.Click on pay and landed into payment page



*/



public class AlterNate_MSProduct extends BaseClass{
	
	static String amt;
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		
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
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void alterNate_Product() throws Throwable {
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		Monepom m = new Monepom();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Robot r = new Robot();
		
		 driver.manage().window().maximize();
		 btncli(m.getSignin());
		  Thread.sleep(5000);
		  type(m.getMobileno(),"7010752043");
		  Thread.sleep(3000);
		  btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
		  Thread.sleep(3000);
		  type(m.getPassword(),"Change@92"); 
		  btncli(m.getSignInpage());
		  
		  //////////////////////
		  
		  
/////////////  Remove Product //

		Thread.sleep(3000);
		driver.navigate().to("https://s1-meds.netmeds.com/checkout/cart");
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
				logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}

		}
		

		Thread.sleep(3000);
		driver.navigate().to("https://s1-meds.netmeds.com/");

		//////////////////////////
		  
		  
		  
		  
		  
	
		  Thread.sleep(3000);
		btncli(m.getSearch());
		type(m.getSearch(), "Trajenta 5mg Tablet 10"); //Trajenta 5mg Tablet 10'S
         r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
         r.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		
		//btncli(m.getSearchIcon());
		Thread.sleep(5000);
		btncli(m.getSearch_Product_Info());//driver.findElement(By.xpath("//div[@class='info']")));
		
		Thread.sleep(5000);
	//	js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h5[contains(text(),'ALTERNATE BRANDS ')]")));
	
		
		Thread.sleep(3000);
		btncli(m.getSearch_AddtoCart_btn());//driver.findElement(By.id("product-addtocart-button")));
		
		
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(0,600)");
		
		Thread.sleep(3000);
		System.out.println(gettext(m.getSearch_Product_Info()));
		logger.log(Status.PASS, gettext(m.getSearch_Product_Info()));
		
		Thread.sleep(3000);
		btncli(m.getAlternate_AddToCart());//driver.findElement(By.xpath("//button[@title='Add to Cart']")));
		logger.log(Status.PASS, "Successfully Product Added from Alternate Brands ");
		
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(600,0)");
		
		
		btncli(m.getMinicart());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigated to cart page");

		/*
		driver.findElement(By.xpath("//span[@class='arricon downarrow']")).click();
		
		Thread.sleep(3000);
		List<WebElement> promo = m.getPromo();//driver.findElements(By.xpath("//input[@class='rdbtn auto_apply_coupon_popup']"));
		System.err.println(promo.size());
			
			for (int i = 0; i < (promo.size()/2); i++) {
				

				Thread.sleep(3000);
				promo.get(i).click();
				
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//button[@class='apply-coupon'])[1]")).click();
				
			}
		*/

		// handle Lets chat button-
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
		
		//Adding most Selling Product from cart page
		Thread.sleep(3000);
		List<WebElement> most_sell =m.getMost_Selling_AddToCart(); //driver.findElements(By.xpath("//div[contains(text(),' Add to Cart ')]"));
		System.out.println(most_sell.size());
		
		
		List<WebElement> Most_sell_Product =m.getMost_Selling_ProductName(); //driver.findElements(By.xpath("//a[@class='productname']"));
		System.out.println(Most_sell_Product.size());
		
			
		
		Thread.sleep(3000);
		most_sell.get(0).click();
		logger.log(Status.PASS, "Successfully Added Most Selling Product ");
		
		
		Thread.sleep(3000);
		Most_sell_Product.get(2).click();
		logger.log(Status.PASS, "Successfully Opened the Most Selling Product PDP Page");
		
		
		Thread.sleep(3000);
		btncli(m.getSearch_AddtoCart_btn());//driver.findElement(By.id("product-addtocart-button")));
		logger.log(Status.PASS, "Successfully Added the Most Selling Product from PDP Page ");
		
		Thread.sleep(3000);
		btncli(m.getMinicart());
		
		
		/////////////////////

		/////////////////////////////

		Thread.sleep(3000);
		btncli(m.getProceedbutton());

		try {
			Thread.sleep(3000);
			btncli(driver.findElement(By.id("externaldoctr")));
		//	logger.log(Status.PASS, "Successfully navigated to Attach Prescription page");
		//	logger.log(Status.PASS, "Successfully Selected the Schedule FREE doctor Consultation");

			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("//button[contains(text(),'Review Order')]")));

		} catch (Exception e) {

		}
		Thread.sleep(3000);

		logger.log(Status.PASS, "Successfully navigated to  order review page");
		
		Thread.sleep(3000);
		btncli(m.getPaybutton());
		logger.log(Status.PASS, "Successfully navigated to Payment Page");
		
		
		
		
		Thread.sleep(3000);
	//	driver.findElement(By.id("salts_view_all")).click();
		
		
		Thread.sleep(3000);
//		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[contains(text(),'DISCLAIMER')]")));
		
		try {
		Thread.sleep(3000);
//		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("salts_view_all")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*
		 * Thread.sleep(3000); java.util.List<WebElement> ab =
		 * driver.findElements(By.xpath("//div[@class='drug_lists']"));
		 * 
		 * System.out.println(ab.size());
		 * 
		 * 
		 * Thread.sleep(3000); for (int i = 1; i <ab.size(); i++) { Thread.sleep(3000);
		 * try {
		 * 
		 * driver.findElement(By.xpath("(//button[@title='Add to Cart'])["+i+"]")).click
		 * (); } catch (Exception e) { // TODO: handle exception } }
		 */


		
	
	
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
		
    //  driver.quit();
	}

}
