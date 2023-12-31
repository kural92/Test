package com.Nm.website_stage;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.Nm.Website_live.RetryAnalyzer;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




/*
 Scenario 1: Combo Pack
 1.Login
 2.Remove Product
 3.Search the Product and landed into PDP page
 4.From PDP page check the Pack 4 and Pack 2.
 5.Choose those Pack 4 or Pack 2 and landed into cart
 6.In cart page verify for the Quantity and the Price was matches with PDP page
 
 Scenario 2:Frequently Bought Together
 1.Login
 2.Remove Product
 3.Search the Product and landed into PDP page
 4.From PDP page check the Individual Bought pack
 5.Click on Add to cart from individual pack and click on another product landed into PDP page
 6.From PDP page Click on Add to cart.
 
 
 */
public class PDP_Combo extends BaseClass{
	
	static String price;
	static int Quantiys;
	
	
	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//report//GuestLogin.html");

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

		 htmlReporter.config().setTheme(Theme.DARK);

	}
	
	
	
	@Test(priority=1)
	public void offersAvail() throws Throwable {
		
		
		Monepom m = new Monepom();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions acc =  new Actions(driver);
		Robot r = new Robot();
				  
try {
			driver.manage().window().maximize();
			btncli(m.getSignin());
			Thread.sleep(5000);
			type(m.getMobileno(), "7010752043");
			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
			Thread.sleep(3000);
			type(m.getPassword(), "Change@92");
			btncli(m.getSignInpage());
		
} catch (Exception e) {
	// TODO: handle exception
}
		//////////////

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
				break;
				

			}

		}

		Thread.sleep(3000);
		driver.navigate().to("https://s1-meds.netmeds.com/");
		  
		  
		  
		
		// search
		btncli(m.getSearch());
		type(m.getSearch(),"Pro360");  //Pro360 //Horlicks
		m.getSearch().sendKeys(Keys.ENTER);
		
		//btncli(m.getSearchIcon());
		
		Thread.sleep(5000);
		btncli(m.getProduct_List());
		
		
		Thread.sleep(3000);
		if (!(m.getPDP_OfferText().size()==0)) {
			
			Thread.sleep(3000);
			String Offer=m.getPDP_OfferPercentage().getText();
			System.out.println(Offer);
			
		} else {
			
			
			
		}
		
		/////
		
		if (m.getPDP_Pack4_text().size()==1) {
			
			Thread.sleep(3000);
			m.getPDP_Pack4_BuyBtn().click();
			
			Thread.sleep(3000);
			price = m.getPDP_ComboPack4_Price().getText();
			System.out.println(price);
			
			Thread.sleep(3000);
			btncli(m.getMinicart());
			//span[contains(text(),'Rs.')])[2]
			Thread.sleep(3000);
			String Cart_Price = driver.findElement(By.xpath("(//span[contains(text(),'Rs.')])[2]")).getText();
			System.out.println(Cart_Price);
			
			
			Thread.sleep(3000);
			WebElement Cart_Quantity = driver.findElement(By.xpath("//select[@name='quantity']"));
			
			org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(Cart_Quantity);
			int quantity = s.getOptions().size();

			System.out.println(quantity);
			
			Thread.sleep(3000);
			if (price.contains(Cart_Price)) {
				System.out.println("The Product Price in PDP and Cart Page Matched");
			} else {
				System.err.println("The Product Price in PDP and Cart Page is not Matched");
			}
			
			
			Thread.sleep(3000);
			if (Quantiys==quantity) {
				System.out.println("The Product Quantity  in PDP and Cart Page Matched");
			} else {
				System.err.println("The Product Quantity in PDP and Cart Page is not Matched");
			}
			
			
			
		} else if (m.getPDP_Pack2_text().size()==1){
			
			Thread.sleep(3000);
			m.getPDP_Pack2_BuyBtn().click();
			
			Thread.sleep(3000);
			price = m.getPDP_ComboPack2_Price().getText();
			System.out.println(price);
			
			Thread.sleep(3000);
			btncli(m.getMinicart());
			//span[@id='row_itmdiscprice_889030']
			Thread.sleep(3000);
			String Cart_Price = driver.findElement(By.xpath("(//span[contains(text(),'Rs.')])[2]")).getText();
			System.out.println(Cart_Price);
			
			
			Thread.sleep(3000);
			WebElement Cart_Quantity = driver.findElement(By.xpath("//select[@name='quantity']"));
			
			org.openqa.selenium.support.ui.Select s = new org.openqa.selenium.support.ui.Select(Cart_Quantity);
			int quantity = s.getOptions().size();

			System.out.println(quantity);
			

			Thread.sleep(3000);
			if (price.contains(Cart_Price)) {
				System.out.println("The Product Price in PDP and Cart Page Matched");
			} else {
				System.err.println("The Product Price in PDP and Cart Page is not Matched");
			}
			
			
			Thread.sleep(3000);
			if (Quantiys==quantity) {
				System.out.println("The Product Quantity  in PDP and Cart Page Matched");
			} else {
				System.err.println("The Product Quantity in PDP and Cart Page is not Matched");
			}
			
			
			
		} else {
		
				System.out.println("There is No Combo Offer Available");
				
				
		
			
		}
		
		
		
		
		

	}
	
	
	
	

	@Test(priority=2)
	public void ferquentlyBought() throws Throwable {

	Monepom m = new Monepom();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions acc =  new Actions(driver);
		Robot r = new Robot();
				  
try {
			driver.manage().window().maximize();
			btncli(m.getSignin());
			Thread.sleep(5000);
			type(m.getMobileno(), "7010752043");
			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
			Thread.sleep(3000);
			type(m.getPassword(), "Change@92");
			btncli(m.getSignInpage());
} catch (Exception e) {
	
}

		//////////////

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
				break;

			}

		}

		Thread.sleep(3000);
		driver.navigate().to("https://s1-meds.netmeds.com/");
		  
		  
		  
		
		// search
		btncli(m.getSearch());
		type(m.getSearch(),"Horlicks Health Drink Powder Classic Malt 500 gm");  //Pro360 //Horlicks
		m.getSearch().sendKeys(Keys.ENTER);
		//btncli(m.getSearchIcon());
		
		Thread.sleep(5000);
		btncli(m.getProduct_List());
		
		Thread.sleep(3000);
		String fre = driver.findElement(By.xpath("//h5[contains(text(),'FREQUENTLY BOUGHT TOGETHER ')]")).getText();
		
		if (fre.contains("FREQUENTLY BOUGHT TOGETHER")) {
			
			
			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("//h5[contains(text(),'FREQUENTLY BOUGHT TOGETHER ')]//following::button[contains(text(),'ADD TO CART')]")));
			
			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("(//h5[contains(text(),'FREQUENTLY BOUGHT TOGETHER ')]//following::span[@class='clsgetname'])[2]")));
			
			Thread.sleep(3000);
			btncli(driver.findElement(By.xpath("//button[@class='toCart cartbag addtocartbtnpdp prodbtn']")));
			
		} else {
			
			System.out.println("There is no Frequently Brought Link");
			
			
		}
		
		
		/////
		
		
		
	}
	
	

	//@AfterMethod()
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
	//	report.flush();
		
      driver.quit();
      
	}


	
	
	
	

}
