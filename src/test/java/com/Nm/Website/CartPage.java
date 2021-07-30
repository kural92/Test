package com.Nm.Website;



import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

//********Extend Report*********//
public class CartPage extends BaseClass {

static String totalamt;
	
	static String mrp;
	String dlcharge ;
	
	Float delcharge;
	Float 	Netcharge;
	String discount;
	String savings;
	
	Float total_discount;
	Float total_savings;
	String Nmswallet;
	String Wallet;
	Float Total_NMSWallet;
	@BeforeTest(groups = { "forgetPassword", "sanity", "reg" })
	public void startReport() {

		htmlReporter = new ExtentHtmlReporter(".//report//sample.html");

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
		htmlReporter.config().setReportName("Test Report");

		// htmlReporter.config().setTheme(Theme.STANDARD);

	}



	/*,
	 BELOW LISTED SCENARIOS ARE COEVRED// 
		Scenario 1: Quantity increased,Quantity decreased and quantity removed/
		Scenario 2:	Item added though continue shopping/
		Scenario 3:	Item added through most selling products(directly clicking the add to cart of an item)
		Scenario 4: All the listed promo codes are able to applied
		Scenario 5:	Item added through most selling products (open the item and added)
		
	Note : Validation has been included for the delivery charge check,Mrp check, Discount amount,NMS Wallet check and the total amount)
		*/

	//******************************Test case 1: Verify Cart page when the Total amount is more than 500 and promo code is applied
	@Test(enabled = true)
	public void cartpagescenarioone() throws Throwable {

		logger = report.createTest("cartpage scenario one ");
		logger.log(Status.PASS, "************* cartpage scenario 2********************");
		Monepom m = new Monepom();
		

		// Login
		
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
			System.out.println("Already Logged In");
		}

		try {
			btncli(m.getNetmedshome());
		} catch (Exception e) {

		}
		

		

//  Remove existing items from the cart  //

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
		Thread.sleep(3000);
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size() == 0)) {

				try {
					btncli(m.getRemovebutton());
					Thread.sleep(3000);
					driver.findElement(By.xpath("//span[@class=\"arricon downarrow\"]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[.=\"Remove\"]")).click();
				} catch (Exception e) {
					System.out.println("Items are removed from the cart");
				}

			} else {
				break;

			}

		}

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/");

		Thread.sleep(3000);
		
//Adding Product to the cart//
		
			
			for (int i = 0; i < 5; i++) {
				
				type(m.getSearch(), BaseClass.getExcelData("Otcandnonrx", i, 0));
				m.getSearch().sendKeys(Keys.ENTER);

				// btncli(m.getSearchIcon());
				logger.log(Status.PASS, "Successfully navigate to search result page");
			
			try {
				Thread.sleep(3000);

				WebElement Cart_btn = driver.findElement(By.id("product-addtocart-button"));
				Thread.sleep(3000);
				btncli(Cart_btn);
				//btncli(m.getAddtocart());
			} catch (Exception e) {

			}
			Thread.sleep(3000);
			driver.navigate().back();

			Thread.sleep(3000);
			
			System.out.println("Items are added to the cart");
		}

//Click mini cart//
		
		btncli(m.getMinicart());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigated to cart page");
		System.out.println("Successfully navigated to cart page");

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
		
//qty increase//
		
		Select qtyincrease = new Select(m.getQty_Incr_Decr());
		qtyincrease.selectByIndex(15);
		Thread.sleep(5000);
		
		
		logger.log(Status.PASS, " quantity increased Successfully");
		System.out.println(" quantity increased Successfully");
		
		driver.findElement(By.xpath("//span[@class=\"arricon downarrow\"]")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> radiobtn = m.getPromo();//driver.findElements(By.xpath("//input[@class='rdbtn auto_apply_coupon_popup']"));
		System.out.println("Total element size is  "+ radiobtn.size());
		
		for (int i = 0; (i< radiobtn.size()); i++)
		
			
		
		{

					
			Thread.sleep(3000);
			radiobtn.get(i).click();
			Thread.sleep(4000);
		
	} 
		
		System.out.println("promo code is successfully applied");
		Thread.sleep(3000);
// Step  :Remove item//
		
		btncli(m.getRemoveitem());
		Thread.sleep(3000);
		
		logger.log(Status.PASS, " item removed Successfully");
		System.out.println(" item removed Successfully");
		
// Step : Decrease qty//

		Select qtydecrease = new Select(m.getQty_Incr_Decr());
		qtydecrease.selectByIndex(11);
		Thread.sleep(3000);
		
		logger.log(Status.PASS, " quantity decreased Successfully");
		System.out.println(" quantity decreased Successfully");
		
		
//continue shopping//
		
		
		WebElement Continueshopping = m.getContinue_shopping();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", Continueshopping);
		
		btncli(m.getContinue_shopping());
		
		Thread.sleep(000);
		System.out.println("successfully clicked continue shopping button");	
		
		type(m.getSearch(),"Flavedon MR 35mg Tablet 10'S");
		Thread.sleep(3000);
		m.getSearch().sendKeys(Keys.ENTER)	;
		Thread.sleep(5000);
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(3000);
		System.out.println("item added sucessfully to the cart");
		btncli(m.getNetmedshome());
		Thread.sleep(3000);
		btncli(m.getMinicart());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigated to cart page");
		
//Most selling product//
		
		WebElement most_selling_product = m.getMost_Selling_products();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", most_selling_product);
		
		System.out.println(most_selling_product.getText());
		
		Thread.sleep(3000);
		
//click next/previous button to see the products in most selling page//
		
		btncli(m.getSwipe_right());
		Thread.sleep(3000);
		btncli(m.getSwipe_right());
		Thread.sleep(3000);
		
		logger.log(Status.PASS, "Successfully navigated to next page in similar product");
		System.out.println("Successfully navigated to next page in similar product");
		
		btncli(m.getSwipe_prev());
		Thread.sleep(3000);
		
		logger.log(Status.PASS, "Successfully navigated to previous page in similar product");
		System.out.println("Successfully navigated to previous page in similar product");
		
		btncli(m.getMost_selling_Addtocart());
		Thread.sleep(3000);
		System.out.println("Successfully item added to the cart");
		
//open the item from most selling product page and add the item to the cart though PDG page"
		
		driver.findElement(By.xpath("(//a[@class=\"productname\"])[3]")).click();
		Thread.sleep(3000);
		System.out.println("Successfully naviagted to PD page");
		driver.findElement(By.xpath("(//button[@id=\"product-addtocart-button\"])[1]")).click();
		System.out.println("Successfully item added to the cart");
		Thread.sleep(3000);
		m.getNetmedshome();
		Thread.sleep(3000);
		btncli(m.getMinicart());
		Thread.sleep(3000);
		
		

//Delivery Charge//
		
		if (!(driver.findElements(By.id("cart_del_charge")).size()==0))
		{
			dlcharge = driver.findElement(By.id("cart_del_charge")).getText();
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
			 
			//String totalmrp = driver.findElement(By.id("cart_sub_total")).getText();
			
			String totalmrp = m.getTotalmrp().getText();
			
			logger.log(Status.PASS, "mrp is "+totalmrp);
			
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
			
			//String totalamount = driver.findElement(By.id("cart_netpay_amt1")).getText();
			
			String totalamount = m.getTotal_amount().getText();
			
			logger.log(Status.PASS, "Ordered Product price was "+totalamount);
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

		if (mrpcharge<=150.00 && dlcharge.equals("50.00")) {
	    	
	  	Netcharge = mrpcharge + delcharge;
	   
	    }else if  (mrpcharge>150.00 && mrpcharge<=500.00 && dlcharge.equals("25.00")) {
	    	
		  	Netcharge = mrpcharge + delcharge;
	    }else if (mrpcharge>500.00) {
	    	
		  	Netcharge = mrpcharge ;
	    }
	    	
		System.out.println("netcharge==="+Netcharge);
		System.out.println("total_amt==="+total_amt);
		
//discount calculation//		
		
		if (discount!= null && !discount.isEmpty())
		
		{
			Netcharge = Netcharge -total_discount;
			
			System.out.println("Actual net charge after discount is =="+Netcharge);
		}
			
		
		if (Float.compare(Netcharge, total_amt) == 0) 
		{
		   System.out.println("Total amount matches with total netcharge");
		   
	   }else {
		   System.out.println("Total amount mismatch");
	   }


		
		
		
//saving amount calculation//
		
		if (!(driver.findElements(By.xpath("//div[@class=\"save-amount cart-savings ng-star-inserted\"]")).size()==0))
		{
			savings = driver.findElement(By.xpath("//div[@class=\"save-amount cart-savings ng-star-inserted\"]")).getText();
			System.out.println(savings);
			logger.log(Status.PASS, "saving is "+ savings);
			
			String save = savings.replaceAll(" ","");
			System.out.println("total==="+save);
			
			String[] savings_amt = save.split("RS."); 
			
			System.out.println(savings_amt);
			
			savings = savings_amt[1].toString();
			System.out.println(savings);
			
			 total_savings = Float.parseFloat(savings);
			 
			System.out.println("total saving amount is ===" +savings);
		
	} else {
		
		System.out.println("No savings amount");
	}
		if (total_savings!= null && total_discount!= null) {
		if (Float.compare(total_savings,total_discount) == 0) 
		{
		   System.out.println("Total savings is matched with discount amount");
		   
	   }else {
		   System.out.println("Total savings amount is not matched with discounts");
	   }
		
		
		 }
		
		
	}	

	//******************************Test case 2: Verify Cart page when the Total amount is more than 150 and less than 500 

		

	@Test(enabled = true)
	public void carpagescenariotwo() throws Throwable {

		logger = report.createTest("cartpage scenario two");
		logger.log(Status.PASS, "************* cartpage page scenario 2********************");
		Monepom m = new Monepom();
	
	
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
		System.out.println("Already Logged In");
	}

	try {
		btncli(m.getNetmedshome());
	} catch (Exception e) {

	}
	
//  Remove existing items from the cart  //

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
		Thread.sleep(3000);
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size() == 0)) {

				try {
					btncli(m.getRemovebutton());
					Thread.sleep(3000);
					driver.findElement(By.xpath("//span[@class=\"arricon downarrow\"]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[.=\"Remove\"]")).click();
				} catch (Exception e) {
					System.out.println("Items are removed from the cart");
				}

			} else {
				break;

			}

		}

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/");

		Thread.sleep(3000);
		
//Adding Product to the cart//
		
			
			for (int i = 0; i < 2; i++) {
				
				type(m.getSearch(), BaseClass.getExcelData("Otcandnonrx", i, 0));
				m.getSearch().sendKeys(Keys.ENTER);

				// btncli(m.getSearchIcon());
				logger.log(Status.PASS, "Successfully navigate to search result page");
			
			try {
				Thread.sleep(3000);

				WebElement Cart_btn = driver.findElement(By.id("product-addtocart-button"));
				Thread.sleep(3000);
				btncli(Cart_btn);
				//btncli(m.getAddtocart());
			} catch (Exception e) {

			}
			Thread.sleep(3000);
			driver.navigate().back();

			Thread.sleep(3000);
			
			System.out.println("Items are added to the cart");
		}

//Click mini cart//
		
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

		Thread.sleep(5000);
		System.out.println("successfully closed letschat");
		
//Delivery Charge//
		
				if (!(driver.findElements(By.id("cart_del_charge")).size()==0))
				{
					dlcharge = driver.findElement(By.id("cart_del_charge")).getText();
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
		
//Netmeds Discount
		

		
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
					 
					//String totalmrp = driver.findElement(By.id("cart_sub_total")).getText();
					
					String totalmrp = m.getTotalmrp().getText();
					
					logger.log(Status.PASS, "mrp is "+totalmrp);
					
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
					
					//String totalamount = driver.findElement(By.id("cart_netpay_amt1")).getText();
					
					String totalamount = m.getTotal_amount().getText();
					
					logger.log(Status.PASS, "Ordered Product price was "+totalamount);
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
					
		//System.out.println("mrpcharge==="+mrpcharge);
		//System.out.println("dlcharge==="+dlcharge);

			
//Mrp/net charge calculation//
					
				if (mrpcharge<=150.00 && dlcharge.equals("50.00")) {
			    	
			  	Netcharge = mrpcharge + delcharge;
			   
			    }else if  (mrpcharge>150.00 && mrpcharge<=500.00 && dlcharge.equals("25.00")) {
			    	
				  	Netcharge = mrpcharge + delcharge;
			    }else if (mrpcharge>500.00) {
			    	
				  	Netcharge = mrpcharge ;
			    }
			    	
				System.out.println("netcharge==="+Netcharge);
				System.out.println("total_amt==="+total_amt);
				
				
//Discount calculation//				
				if (discount!= null && !discount.isEmpty())
				
				{
					Netcharge = Netcharge -total_discount;
					
					System.out.println("Actual net charge after discount is =="+Netcharge);
				}else {
					System.out.println("there is no discount in this order");
				}
					
				
				if (Float.compare(Netcharge, total_amt) == 0) 
				{
				   System.out.println("Total amount matches with total netcharge");
				   
			   }else {
				   System.out.println("Total amount mismatch");
			   }
				 		
//savings amount calculation//
				
				if (!(driver.findElements(By.xpath("//div[@class=\"save-amount cart-savings ng-star-inserted\"]")).size()==0))
				{
					savings = driver.findElement(By.xpath("//div[@class=\"save-amount cart-savings ng-star-inserted\"]")).getText();
					System.out.println(savings);
					logger.log(Status.PASS, "saving is "+ savings);
					
					String save = savings.replaceAll(" ","");
					System.out.println("total==="+save);
					
					String[] savings_amt = save.split("RS."); 
					
					System.out.println(savings_amt);
					
					savings = savings_amt[1].toString();
					System.out.println(savings);
					
					 total_savings = Float.parseFloat(savings);
					 
					System.out.println("total saving amount is ===" +savings);
				
			} else {
				
				System.out.println("No savings amount");
			}
				
				
				if (total_savings!= null && total_discount!= null)
				{
				if (Float.compare(total_savings,total_discount) == 0) 
				{
				   System.out.println("Total savings is matched with discount amount");
				   
			   }else {
				   System.out.println("Total savings amount is not matched with discounts");
			   }
				
				
				 }
//header Menu validation//

				btncli(m.getNetmedshome());
				Thread.sleep(3000);
				btncli(m.getMinicart());
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@class=\"ng-star-inserted\"]")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='counter-number']")).click();
				Thread.sleep(3000);
				btncli(m.getUpload_cta());
				Thread.sleep(3000);
				btncli(m.getNetmedshome());
				Thread.sleep(3000);
				btncli(m.getMinicart());
	}
	
	
	//******************************Test case 3: Verify Cart page when the Total amount is less than 150

			

	@Test(enabled = true)
	public void carpagescenariothree() throws Throwable {

		logger = report.createTest("cartpage scenario three");
		logger.log(Status.PASS, "************* cartpage page scenario 3********************");
		Monepom m = new Monepom();
	
	
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
		System.out.println("Already Logged In");
	}

	try {
		btncli(m.getNetmedshome());
	} catch (Exception e) {

	}
	
//  Remove existing items from the cart  //

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
		Thread.sleep(3000);
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size() == 0)) {

				try {
					btncli(m.getRemovebutton());
					Thread.sleep(3000);
					driver.findElement(By.xpath("//span[@class=\"arricon downarrow\"]")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[.=\"Remove\"]")).click();
				} catch (Exception e) {
					System.out.println("Items are removed from the cart");
				}

			} else {
				break;

			}

		}

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/");

		Thread.sleep(3000);
		
//Adding Product to the cart//
		
			
			for (int i = 0; i < 1; i++) {
				
				type(m.getSearch(), BaseClass.getExcelData("Otcandnonrx", i, 0));
				m.getSearch().sendKeys(Keys.ENTER);

				// btncli(m.getSearchIcon());
				logger.log(Status.PASS, "Successfully navigate to search result page");
			
			try {
				Thread.sleep(3000);

				WebElement Cart_btn = driver.findElement(By.id("product-addtocart-button"));
				Thread.sleep(3000);
				btncli(Cart_btn);
				//btncli(m.getAddtocart());
			} catch (Exception e) {

			}
			Thread.sleep(3000);
			driver.navigate().back();

			Thread.sleep(3000);
			
			System.out.println("Items are added to the cart");
		}

//Click mini cart//
		
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

		Thread.sleep(5000);
		System.out.println("successfully closed letschat");
		
//Delivery Charge//
		
				if (!(driver.findElements(By.id("cart_del_charge")).size()==0))
				{
					dlcharge = driver.findElement(By.id("cart_del_charge")).getText();
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
		
//Netmeds Discount
		

		
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
					 
					//String totalmrp = driver.findElement(By.id("cart_sub_total")).getText();
					
					String totalmrp = m.getTotalmrp().getText();
					
					logger.log(Status.PASS, "mrp is "+totalmrp);
					
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
					
					//String totalamount = driver.findElement(By.id("cart_netpay_amt1")).getText();
					
					String totalamount = m.getTotal_amount().getText();
					
					logger.log(Status.PASS, "Ordered Product price was "+totalamount);
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
					
		//System.out.println("mrpcharge==="+mrpcharge);
		//System.out.println("dlcharge==="+dlcharge);

			
//Mrp/net charge calculation//
					
				if (mrpcharge<=150.00 && dlcharge.equals("50.00")) {
			    	
			  	Netcharge = mrpcharge + delcharge;
			   
			    }else if  (mrpcharge>150.00 && mrpcharge<=500.00 && dlcharge.equals("25.00")) {
			    	
				  	Netcharge = mrpcharge + delcharge;
			    }else if (mrpcharge>500.00) {
			    	
				  	Netcharge = mrpcharge ;
			    }
			    	
				System.out.println("netcharge==="+Netcharge);
				System.out.println("total_amt==="+total_amt);
				
				
//Discount calculation//				
				if (discount!= null && !discount.isEmpty())
				
				{
					Netcharge = Netcharge -total_discount;
					
					System.out.println("Actual net charge after discount is =="+Netcharge);
				}else {
					System.out.println("there is no discount in this order");
				}
					
				
				if (Float.compare(Netcharge, total_amt) == 0) 
				{
				   System.out.println("Total amount matches with total netcharge");
				   
			   }else {
				   System.out.println("Total amount mismatch");
			   }
				 		
//savings amount calculation//
				
				if (!(driver.findElements(By.xpath("//div[@class=\"save-amount cart-savings ng-star-inserted\"]")).size()==0))
				{
					savings = driver.findElement(By.xpath("//div[@class=\"save-amount cart-savings ng-star-inserted\"]")).getText();
					System.out.println(savings);
					logger.log(Status.PASS, "saving is "+ savings);
					
					String save = savings.replaceAll(" ","");
					System.out.println("total==="+save);
					
					String[] savings_amt = save.split("RS."); 
					
					System.out.println(savings_amt);
					
					savings = savings_amt[1].toString();
					System.out.println(savings);
					
					 total_savings = Float.parseFloat(savings);
					 
					System.out.println("total saving amount is ===" +savings);
				
			} else {
				
				System.out.println("No savings amount");
			}
				
				
				if (total_savings!= null && total_discount!= null)
				{
				if (Float.compare(total_savings,total_discount) == 0) 
				{
				   System.out.println("Total savings is matched with discount amount");
				   
			   }else {
				   System.out.println("Total savings amount is not matched with discounts");
			   }
				
				}
				 
	}
				
//******************************Test case 4: Verify Cart page when NMS wallet cash used*****************************************************************
				
				
				@Test(enabled = true)
				public void carpagescenariofour() throws Throwable {

					logger = report.createTest("cartpage scenario four");
					logger.log(Status.PASS, "************* cartpage page scenario 4********************");
					Monepom m = new Monepom();
				
				
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
					System.out.println("Already Logged In");
				}

				try {
					btncli(m.getNetmedshome());
				} catch (Exception e) {

				}
				
			//  Remove existing items from the cart  //

					Thread.sleep(3000);
					driver.navigate().to("https://www.netmeds.com/checkout/cart");
					Thread.sleep(3000);
					for (int i = 0; i < 16; i++) {
						Thread.sleep(3000);
						if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size() == 0)) {

							try {
								btncli(m.getRemovebutton());
								Thread.sleep(3000);
								driver.findElement(By.xpath("//span[@class=\"arricon downarrow\"]")).click();
								Thread.sleep(3000);
								driver.findElement(By.xpath("//button[.=\"Remove\"]")).click();
							} catch (Exception e) {
								System.out.println("Items are removed from the cart");
							}

						} else {
							break;

						}

					}

					Thread.sleep(3000);
					driver.navigate().to("https://www.netmeds.com/");

					Thread.sleep(3000);
					
			//Adding Product to the cart//
					
						
						for (int i = 0; i < 5; i++) {
							
							type(m.getSearch(), BaseClass.getExcelData("Otcandnonrx", i, 0));
							m.getSearch().sendKeys(Keys.ENTER);

							// btncli(m.getSearchIcon());
							logger.log(Status.PASS, "Successfully navigate to search result page");
						
						try {
							Thread.sleep(3000);

							WebElement Cart_btn = driver.findElement(By.id("product-addtocart-button"));
							Thread.sleep(3000);
							btncli(Cart_btn);
							//btncli(m.getAddtocart());
						} catch (Exception e) {

						}
						Thread.sleep(3000);
						driver.navigate().back();

						Thread.sleep(3000);
						
						System.out.println("Items are added to the cart");
					}

			//Click mini cart//
					
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

					Thread.sleep(5000);
					System.out.println("successfully closed letschat");
					
			//adding NMS wallet//
					
					Thread.sleep(3000);
					driver.findElement(By.id("nmssupercash")).click();
					
					WebElement Nmswallet_text = driver.findElement(By.xpath("(//p[.=\"Get flat 25% off from your NMS Super Cash wallet.\"])[1]"));
					
					System.out.println(Nmswallet_text.getText());
					
					Thread.sleep(5000);
					
			//Delivery Charge//
					
							if (!(driver.findElements(By.xpath("//label[.=\"Delivery Charges\"]")).size()==0))
							{
								dlcharge = driver.findElement(By.xpath("(//span[@id=\"cart_del_charge\"])[1]")).getText();
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
					
			//Netmeds Discount
					

					
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
								 
								//String totalmrp = driver.findElement(By.id("cart_sub_total")).getText();
								
								String totalmrp = m.getTotalmrp().getText();
								
								logger.log(Status.PASS, "mrp is "+totalmrp);
								
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
//Netmeds Wallet//
							if (mrpcharge>500) {
								
								if (!(driver.findElements(By.xpath("//label[.=\"NMS Wallet\"]")).size()==0))

								{
									Nmswallet = driver.findElement(By.xpath("(//span[@id=\"cart_del_charge\"])")).getText();
								System.out.println(Nmswallet);
								logger.log(Status.PASS, "Nmswallet is "+ Nmswallet);	
								
								String[] Nmswallet_amt = Nmswallet.split("- Rs."); 	
								System.out.println(Nmswallet_amt);
								
								Wallet = Nmswallet_amt[1].toString();
								System.out.println(Wallet);
								
								 Total_NMSWallet = Float.parseFloat(Wallet);
								 
								System.out.println("total NMS wallet amount is ===" +Total_NMSWallet);
						
								}
						} else {
							
							if (!(driver.findElements(By.xpath("//label[.=\"NMS Wallet\"]")).size()==0))

							{
								Nmswallet = driver.findElement(By.xpath("(//span[@id=\"cart_del_charge\"])[2]")).getText();
							System.out.println(Nmswallet);
							logger.log(Status.PASS, "Nmswallet is "+ Nmswallet);	
							
							String[] Nmswallet_amt = Nmswallet.split("- Rs."); 	
							System.out.println(Nmswallet_amt);
							
							Wallet = Nmswallet_amt[1].toString();
							System.out.println(Wallet);
							
							 Total_NMSWallet = Float.parseFloat(Wallet);
							 
							System.out.println("total NMS wallet amount is ===" +Total_NMSWallet);
					
							}
							
						}				
								
								
								
								
								
			//Total Amount//	
								
								//String totalamount = driver.findElement(By.id("cart_netpay_amt1")).getText();
								
								String totalamount = m.getTotal_amount().getText();
								
								logger.log(Status.PASS, "Ordered Product price was "+totalamount);
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
								
					//System.out.println("mrpcharge==="+mrpcharge);
					//System.out.println("dlcharge==="+dlcharge);

								
								
								
						
			//Mrp/net charge calculation//
								
							if (mrpcharge<=150.00 && dlcharge.equals("50.00")) {
						    	
						  	Netcharge = mrpcharge + delcharge-Total_NMSWallet;
						   
						    }else if  (mrpcharge>150.00 && mrpcharge<=500.00 && dlcharge.equals("25.00")) {
						    	
							  	Netcharge = mrpcharge + delcharge-Total_NMSWallet;
						    }else if (mrpcharge>500.00) {
						    	
							  	Netcharge = mrpcharge -Total_NMSWallet;
						    }
						    
							Netcharge = (float) Math.round(Netcharge * 100) / 100;
							System.out.println("netcharge==="+Netcharge);
							System.out.println("total_amt==="+total_amt);
							
							
			//Discount calculation//				
							if (discount!= null && !discount.isEmpty())
							
							{
								Netcharge = Netcharge -total_discount;
								
								System.out.println("Actual net charge after discount is =="+Netcharge);
							}else {
								System.out.println("there is no discount in this order");
							}
								
							
							if (Float.compare(Netcharge, total_amt) == 0) 
							{
							   System.out.println("Total amount matches with total netcharge");
							   
						   }else {
							   System.out.println("Total amount mismatch");
						   }
							 		
			//savings amount calculation//
							
							if (!(driver.findElements(By.xpath("//div[@class=\"save-amount cart-savings ng-star-inserted\"]")).size()==0))
							{
								savings = driver.findElement(By.xpath("//div[@class=\"save-amount cart-savings ng-star-inserted\"]")).getText();
								System.out.println(savings);
								logger.log(Status.PASS, "saving is "+ savings);
								
								String save = savings.replaceAll(" ","");
								System.out.println("total==="+save);
								
								String[] savings_amt = save.split("RS."); 
								
								System.out.println(savings_amt);
								
								savings = savings_amt[1].toString();
								System.out.println(savings);
								
								 total_savings = Float.parseFloat(savings);
								 
								System.out.println("total saving amount is ===" +savings);
							
						} else {
							
							System.out.println("No savings amount");
						}
							
							
							if (total_savings!= null && total_discount!= null)
							{
							if (Float.compare(total_savings,total_discount) == 0) 
							{
							   System.out.println("Total savings is matched with discount amount");
							   
						   }else {
							   System.out.println("Total savings amount is not matched with discounts");
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
	private void quitbrowser() {
		report.flush();
		
 //     driver.quit();
	}


}
