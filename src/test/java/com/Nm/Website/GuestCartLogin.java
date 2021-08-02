package com.Nm.Website;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

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
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




/*
 * Scenario : 1
 
1.Landed into Main Page
2.Search the Product and added to cart
3.From cart page click on Proceed button.
4.Login SCreen was dispalyed from that given username , password and Login was Successfully
5.Check Landed into Order Review Page
6.Logout

* Scenario : 2
1.Landed into Main Page
2.Search the Product and added to cart
3.Search the Product in search result page .
4.Print the first 10 Product name with the below details
  i.Best Price, Final Price
  ii.Manufacture details
  iii.Drug Category
  iv. RX required text
5.From the search list click on Add to cart
6.Increase the  quantity for 10 times for search result page
7.Decrease the quantity for 10 times for search result page
8.Again decrease 1 quantity and check for Add to cart visible.
9.From Cart click on proceed and Login screen landed
10.Enter the username and passowrd check for the landing page.
11.Logout

* Scenario : 3
1.Landed into main page
2.Search the Product and Open PDP page
3.From PDP page Added the Product to the Cart
4.Check for Alternate brand . if present click on the Add to cart Symbol
5.In cart Page. Click and Add Most Selling Product to cart
6.Click on Most Selling Product and landed into the PDP page 
7.From PDP page product was added to cart.
8.From cart Click on proceed and Login screen landed
9.Enter the username and passowrd check for the landing page.
10.Logout



 */
public class GuestCartLogin extends BaseClass{
	
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
	
	@Test(enabled = true,priority = 1)
	public void search_guestLogin() throws Throwable {
		// TODO Auto-generated method stub

	Monepom m = new Monepom();
	driver.manage().window().maximize();
	
	Thread.sleep(3000);
	for (int i = 1; i <3; i++) {
		Thread.sleep(5000);
	type(m.getSearch(), BaseClass.getExcelData("TakeAction", i, 0));
	//btncli(m.getSearchIcon());
	m.getSearch().sendKeys(Keys.ENTER);
	//logger.log(Status.PASS, "Successfully Added  " +  BaseClass.getExcelData("TakeAction", i, 0));
	
	String Cart_Excel = BaseClass.getExcelData("TakeAction", i, 1);
	try {
	Thread.sleep(3000);
	
	WebElement Cart_btn = driver.findElement(By.xpath("//div[contains(text(),'"+Cart_Excel+"')]//following::span[contains(text(),'ADD TO CART')]"));
	Thread.sleep(3000);
	btncli(Cart_btn);
	//btncli(m.getAddtocart());
	} catch (Exception e) {
		// TODO: handle exception
	}
	Thread.sleep(3000);
	driver.navigate().back();
	}
	Thread.sleep(3000);
	
	
	
	
	btncli(m.getMinicart());
	Thread.sleep(3000);
	//logger.log(Status.PASS, "Successfully navigated to cart page" );
	
	
	Thread.sleep(3000);
	btncli(m.getProceedbutton());
	
	Thread.sleep(3000);
	// btncli(m.getSignin());
	  Thread.sleep(5000);
	  type(m.getMobileno(),"7010752043"); //customer id:20888070
	  Thread.sleep(3000);
	  btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
	  Thread.sleep(3000);
	  type(m.getPassword(),"Change@92"); 
	  btncli(m.getSignInpage());
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"page-header\"]/div/div/div[5]/a")).click();
	//m.getUserProfile_btn();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"app\"]/main/app-account/div[1]/div[3]/div[1]/left-menu/div/div/a[13]")).click();
  //  m.getLogout_btn();


	}
	
	
	@Test(enabled = true, priority = 2)
	public void pdp_guestLogin() throws Throwable {
		
		
		Monepom m = new Monepom();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions acc =  new Actions(driver);
		Robot r = new Robot();
		
		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com");
		 driver.manage().window().maximize();
		 

		
		// search
		Thread.sleep(3000);
		btncli(m.getSearch());
		type(m.getSearch(),"Dolo");
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		//btncli(m.getSearchIcon());
		
		Thread.sleep(5000);
		
		// List OF Product
		List<WebElement> pd = m.getProductList(); //driver.findElements(By.xpath("//div[@class='info']"));
		//System.out.println(pd.size()); 
		
		// Product Final Price
		List<WebElement> price = m.getProductList_Price();//driver.findElements(By.xpath("//span[@class='best-price']//following::span[@class='final-price']"));
		
		//Product manufacture Details
		List<WebElement> manu =m.getManufacture_detailsList(); //driver.findElements(By.xpath("//span[@class='drug-manu']"));
		
		// Drug category
		List<WebElement> drug = m.getDrug_categoryList();//driver.findElements(By.xpath("//span[@class='gen_drug ellipsis']"));
		
		// Rx If Required
		List<WebElement> rx =m.getRx_requiredList(); //driver.findElements(By.xpath("//span[@class='req_Rx']"));
		//System.out.println(rx.size());
		
		if (pd.size()>1) {
			
			for (int i = 1; i <pd.size(); i++) {
				Thread.sleep(3000);
				String Pds = pd.get(i).getText();
		//		System.err.println(Pds);
				
				
				String drug_details = drug.get(i).getText();
		//		System.out.println(drug_details);
				
				String Final_price = price.get(i).getText();
		//		System.err.println(Final_price);
				
				String Manufacture = manu.get(i).getText();
				System.out.println(Pds+" "+drug_details+" "+Final_price+" "+Manufacture + "\n");
			
				
				Thread.sleep(5000);
				try {
					String Rx = rx.get(i).getText();
					System.err.println(Pds+" - "+Rx);
				} catch (Exception e) {
					
				}
				
			}
			
		} else {
			
			System.out.println("There is no product in List to display");
			
		}
		
		
		Thread.sleep(3000);
		String Cart_details = driver.findElement(By.id("product_page_cart_count")).getText();
		System.out.println(Cart_details);
		
		
		Thread.sleep(3000);
		btncli(m.getSearch_AddtoCart_btn());//driver.findElement(By.id("product-addtocart-button")));
		
		Thread.sleep(3000); // Button + Increase Quantity 
		for (int i = 0; i < 10; i++) {
			btncli(m.getSearch_IncreaseQuantity_btn());//driver.findElement(By.xpath("//button[@class='qtybtn qty_add qty_plus']")));
			
		}
		
		
		Thread.sleep(3000); // Button + Decrease Quantity 
		for (int i = 0; i < 10; i++) {
			btncli(m.getSearch_DecreaseQuantity_btn());//driver.findElement(By.xpath("//button[@class='qtybtn qty_add qty_minus prodminus']")));
			
		}
		
		Thread.sleep(3000);
		String Text = driver.findElement(By.id("product-addtocart-button")).getText();
		System.out.println(Text);
		
		
		////////////////////////
		
		
		Thread.sleep(3000);
		
		
		
		
		btncli(m.getMinicart());
		Thread.sleep(3000);
		//logger.log(Status.PASS, "Successfully navigated to cart page" );
		
		
		
		
		Thread.sleep(3000);
		btncli(m.getProceedbutton());
		
		Thread.sleep(3000);
		// btncli(m.getSignin());
		  Thread.sleep(5000);
		  type(m.getMobileno(),"7010752043"); //customer id:20888070
		  Thread.sleep(3000);
		  btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
		  Thread.sleep(3000);
		  type(m.getPassword(),"Change@92"); 
		  btncli(m.getSignInpage());
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"page-header\"]/div/div/div[5]/a")).click();
		//m.getUserProfile_btn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/app-account/div[1]/div[3]/div[1]/left-menu/div/div/a[13]")).click();
//m.getLogout_btn();


	}
	
	@Test(enabled=true,priority = 3)
	public void cartPage_Guestlogin() throws Throwable {
		
		
        Monepom m = new Monepom();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Robot r = new Robot();
		
		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com");
		driver.manage().window().maximize();
		  
		  //////////////////////
	

	
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
	//	logger.log(Status.PASS, gettext(m.getSearch_Product_Info()));
		
		Thread.sleep(3000);
		btncli(m.getAlternate_AddToCart());//driver.findElement(By.xpath("//button[@title='Add to Cart']")));
	//	logger.log(Status.PASS, "Successfully Product Added from Alternate Brands ");
		
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(600,0)");
		
		
		btncli(m.getMinicart());
		Thread.sleep(3000);
//		logger.log(Status.PASS, "Successfully navigated to cart page");
		
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
	//	logger.log(Status.PASS, "Successfully Added Most Selling Product ");
		
		
		Thread.sleep(3000);
		Most_sell_Product.get(2).click();
//		logger.log(Status.PASS, "Successfully Opened the Most Selling Product PDP Page");
		
		
		Thread.sleep(3000);
		btncli(m.getSearch_AddtoCart_btn());//driver.findElement(By.id("product-addtocart-button")));
//		logger.log(Status.PASS, "Successfully Added the Most Selling Product from PDP Page ");
		
		Thread.sleep(3000);
		btncli(m.getMinicart());
		
		

		
		
		Thread.sleep(3000);
		btncli(m.getProceedbutton());
		
		Thread.sleep(3000);
		// btncli(m.getSignin());
		  Thread.sleep(5000);
		  type(m.getMobileno(),"7010752043"); //customer id:20888070
		  Thread.sleep(3000);
		  btncli(driver.findElement(By.xpath("//button[contains(text(),'USE PASSWORD')]")));
		  Thread.sleep(3000);
		  type(m.getPassword(),"Change@92"); 
		  btncli(m.getSignInpage());
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"page-header\"]/div/div/div[5]/a")).click();
	//	m.getUserProfile_btn();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/main/app-account/div[1]/div[3]/div[1]/left-menu/div/div/a[13]")).click();
//m.getLogout_btn();

		
		

	}
	
	
	
	
	@AfterMethod()
	public void screenShot(ITestResult result) throws Throwable {
		
	    if(result.getStatus() == ITestResult.FAILURE) {
	   // 	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	  //  	logger.fail(result.getThrowable());
	    	try {
				

				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Report/"+ result.getName()+".png"));
				System.out.println("Successfully captured a screenshot");
				//logger.log(Status.FAIL, result.getThrowable());
			//	logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath( result.getName()+".png"));
			
		
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	      }
	 
	    else if(result.getStatus() == ITestResult.SUCCESS) {
	//    	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	    
	    }
	    else {
	    
	    	 // onFinish(context);
	 //   	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	//    	logger.skip(result.getThrowable());
	 //   	report.removeTest(logger);
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