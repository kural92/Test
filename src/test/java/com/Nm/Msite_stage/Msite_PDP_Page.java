package com.Nm.Msite_stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MobileBaseClass;
import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.AndriodPom;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Msite_PDP_Page extends MsiteBaseClass{
	
	

	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		
		//@BeforeClass
		public void launchbrowser2()   {
			DesiredCapabilities capabilities = new DesiredCapabilities();

		    capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE ,"com.android.chrome");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY ,"com.google.android.apps.chrome.Main");
			capabilities.setCapability("noReset", true);			
			capabilities.setCapability("autoDismissAlerts", true);  			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(MobileCapabilityType.VERSION,"11 RP1A.200720.011" );
			capabilities.setCapability("chromedriverExecutable", "D:\\Automation\\Driver\\chromedriver.exe");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
			capabilities.setCapability("noReset", true);
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);						
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage()); 
			}				
		}
		
		
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//AlternateBrand.html");
    report = new ExtentReports();
      report.attachReporter(htmlReporter);
       report.setSystemInfo("Host name", "localhost");
       report.setSystemInfo("Environemnt", "QA");
       report.setSystemInfo("user", "Automation Team");

       htmlReporter.config().setDocumentTitle("Extent Report ");
       htmlReporter.config().setReportName("NetMeds.com");

       //htmlReporter.config().setTheme(Theme.STANDARD);
   	
   }
	
	@Test
	public void productDetails() throws Throwable {
		
		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		MsitePOM m = new MsitePOM();
		
		 driver.get("http://m.netmeds.com");
		  driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);
	        

	        Thread.sleep(10000);
			  try {
			  driver.findElement(By.xpath("//span[@class='app_close'] | //*[@class='app_close']")).click();
			  }catch (Exception e) {
				// TODO: handle exception
			}			  	  
			  // Remove From Cart
				driver.navigate().to("https://m.netmeds.com/checkout/cart");
				for (int i = 0; i < 10; i++) {
					Thread.sleep(10000);
					if (!(driver.findElements(By.xpath("//*[@title='Remove item']")).size() == 0)) {

						Thread.sleep(5000);
						try {
							driver.findElement(By.xpath("//android.view.View[@text='REMOVE']|//*[@title='Remove item']")).click();
						} catch (Exception e) {
							// TODO: handle exception
						}

					} else {
						System.err.println("Successfully Product Removed from Cart");
						break;

					}
				} 
				
				//////
				Thread.sleep(5000);
				m.getMsite_Cart_Search().click();
				Thread.sleep(3000);
				
				int a = MobileBaseClass.getRowCount("AndPDP");
				for (int i = 0; i < a; i++) {
				
					Thread.sleep(3000);
					type(m.getMsite_Search_box(), MsiteBaseClass.getExcelData("AndPDP", i, 0));
					Thread.sleep(2000);
	              driver.hideKeyboard();
	              
	              Thread.sleep(5000);
	      		
	      		List<WebElement> search_result  =  m.getMsite_Search_Results();
	      		
	      		System.out.println(search_result.size());
	      		
	      		
	    		Thread.sleep(2000);
	    				//btnclick(m.getMsite_SearchResult_drugName());
	    		btnclick(m.getMsite_Search_Results().get(0));
	    				Thread.sleep(10000);
	    				
	    				String PDP_category_Name = m.getPDP_category_Name().getText();
						System.out.println(PDP_category_Name);
				
						Thread.sleep(2000);
						if (m.getPDP_Rx_Required_List().size()==1) {
							
							Thread.sleep(2000);
							String PDP_Rx_Required = m.getPDP_Rx_Required().getText();
							System.out.println(PDP_Rx_Required);
							
						}
						
						
						Thread.sleep(2000);
						String PDP_Manufacture_name = m.getPDP_Manufacture_name().getText();
						System.out.println(PDP_Manufacture_name);
						
						
						Thread.sleep(2000);
						String PDP_Best_Price = m.getPDP_Best_Price().getText();
						System.out.println(PDP_Best_Price);
						
						Thread.sleep(2000);
						if (m.getPDP_MRP_Price_List().size()==1) {
							Thread.sleep(2000);
							String PDP_MRP_Price = m.getPDP_MRP_Price().getText();
							System.out.println(PDP_MRP_Price);
						} else {

							
						}
						
						
						Thread.sleep(2000);
						driver.swipe(0, 300, 0, 0, 1000);
						
						Thread.sleep(2000);
						Thread.sleep(2000);
						if (m.getPDP_OfferAvailable_List().size()==1) {
							
							Thread.sleep(2000);
							 btnclick(m.getPDP_OfferAvailable_Text());
							 Thread.sleep(2000);
								driver.swipe(0, 300, 0, 0, 1000);
								
								Thread.sleep(2000);
								
								List<WebElement> Coupon_code = m.getPDP_Coupon_Code();
										Thread.sleep(2000);
								List<WebElement> Coupon_Save_Per = m.getPDP_Coupon_Save_Percentage();
								Thread.sleep(2000);
								List<WebElement> Coupon_Details = m.getPDP_Coupon_Details();
							    Thread.sleep(2000);
								
								if (!(Coupon_code.size()==0)) {
									
									for (int j = 0; j <Coupon_code.size() ; j++) {
										
										Thread.sleep(2000);
										System.out.println(gettext(Coupon_code.get(j)));
										
										Thread.sleep(2000);
										System.out.println(gettext(Coupon_Save_Per.get(j)));
										
										Thread.sleep(2000);
										System.out.println(gettext(Coupon_Details.get(j)));
										
									}
									
								} else {

								}
								
								
								
						}
						
						Thread.sleep(2000);
						btnclick(m.getPDP_Manufacture_name());
						
						Thread.sleep(15000);
						String manufac = m.getPDP_manufacture_Page().getText();
						
						if (PDP_Manufacture_name.contains(manufac)) {
							
							System.out.println("Manufacture Matches");
							
						} else {

							
							System.err.println("Manufacture not Matches");
						}
						
						
						////
						//*[@class='back-icon']
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@class='back-icon']")).click();
						
						
						Thread.sleep(10000);
						try {
						driver.findElement(By.xpath("//*[@class='back-icon']")).click();
						}catch (Exception e) {
							// TODO: handle exception
						}
						
					//	Thread.sleep(10000);
					//	driver.findElement(By.xpath("//*[@class='back-icon']|//*[@css='DIV.backlink.ng-star-inserted']")).click();
						
						Thread.sleep(10000);
						try {
							btnclick(m.getMsite_Cart_Search());
							Thread.sleep(2000);
						btnclick(m.getSearch_X_button());
						Thread.sleep(2000);
						
						} catch (Exception e) {
							// TODO: handle exception
						}
						Thread.sleep(2000);
						Thread.sleep(2000);
						Thread.sleep(2000);
	              
				}
				
				
				 //Share ICON
				/////////////////
				Thread.sleep(2000);
				m.getSearchbarone().sendKeys(MobileBaseClass.getExcelData("AndPDP", 2, 0));
				
				Thread.sleep(5000);
				driver.hideKeyboard();
				
				Thread.sleep(5000);
				Thread.sleep(2000);
				letschat();
				try {
					Thread.sleep(2000);
					//	btnclick(m.getMsite_SearchResult_drugName());
					//	m.getMsite_SearchResult_drugName().click();
						driver.findElement(By.xpath("//*[@class='leftside-icons col-2 p-0']|(//*[@nodeName='A'])[5]|(//*[@nodeName='A'])[6]")).click();
						
				} catch (Exception e) {
					Thread.sleep(2000);
				//	btnclick(m.getMsite_Search_Results().get(0));
				//	m.getMsite_Search_Results().get(1).click();
				}
						Thread.sleep(5000);
						
						Thread.sleep(3000);
						btnclick(m.getPDP_Share_Icon());
						
						Thread.sleep(3000);
						btnclick(m.getPDP_Share_Close_Button());
						
					
					//	driver.findElement(By.xpath("//*[@class='back-icon']")).click();
					///////  Alternade // combo // frequently 
						Thread.sleep(3000);
						
						driver.swipe(0, 500, 0, 0, 1000);
						for (int i = 0; i <10; i++) {
							Thread.sleep(2000);
							driver.swipe(50, 500, 0, 0, 1000);
							if (m.getPDP_ComboPack_text().isDisplayed()) {
								break;
							}else {
								
							}
						}
							
						Thread.sleep(3000);
						if (m.getPDP_ComboPack_text().getText().contains("COMBO PACKS")) {
							
							Thread.sleep(3000);
							if (m.getPDP_BuyPack_ComboList().size()==2) {
								
								Thread.sleep(3000);
								String Mrp = gettext(m.getPDP_BuyPack_Combo_PriceList().get(1));
								System.out.println(Mrp);
								Thread.sleep(3000);
								btnclick(m.getPDP_BuyPack_ComboList().get(1));
								
								Thread.sleep(3000);
						//		btnclick(m.getSnackBar_GotIT_btn());
								
								Thread.sleep(5000);
								btnclick(m.getPDP_ProceedToCart());
								
								Thread.sleep(10000);
							letschat();
								
								Thread.sleep(5000);
								String Mrp1 = gettext(m.getCart_Price());
								System.out.println(Mrp1);
								Thread.sleep(2000);
								String qty = gettext(m.getCart_Quantity());
								System.out.println(qty);
								Thread.sleep(2000);
								if (Mrp.contains(Mrp1)) {
									
									System.out.println("The Combo Buy Pack 4 Price Matched with PDP Page and Cart Page");
									
								} else {
									
									System.err.println("The Combo Buy Pack 4 Price is not Matched with PDP Page and Cart Page");

								}
								Thread.sleep(2000);
								if (qty.contains("Qty : 4")) {
									
									System.out.println("The Combo Buy Pack 4 Quantity Matched with PDP Page and Cart Page");
									
								} else {
									
									System.err.println("The Combo Buy Pack 4 Quantity is not Matched with PDP Page and Cart Page");

								}
								
								Thread.sleep(3000);
								btnclick(driver.findElement(By.xpath("//*[@text='Remove']")));
								
								Thread.sleep(3000);
								//driver.findElementByAccessibilityId("Navigate up").click();
								Thread.sleep(3000);
								
							} else if (m.getPDP_BuyPack_ComboList().size()==1) {
								
								Thread.sleep(3000);
								String Mrp = gettext(m.getPDP_BuyPack_Combo_PriceList().get(0));
								
								Thread.sleep(3000);
								btnclick(m.getPDP_BuyPack_ComboList().get(0));
								
								Thread.sleep(3000);
							//	btnclick(m.getSnackBar_GotIT_btn());
								
								Thread.sleep(3000);
								btnclick(m.getPDP_ProceedToCart());
								
								Thread.sleep(5000);
								String Mrp1 = gettext(m.getCart_Price());
								
								Thread.sleep(2000);
								String qty = gettext(m.getCart_Quantity());
								
								Thread.sleep(2000);
								if (Mrp.contains(Mrp1)) {
									
									System.out.println("The Combo Buy Pack 4 Price Matched with PDP Page and Cart Page");
									
								} else {
									
									System.err.println("The Combo Buy Pack 4 Price is not Matched with PDP Page and Cart Page");

								}
								
								
								Thread.sleep(2000);
								if (qty.contains("Qty : 2")) {
									
									System.out.println("The Combo Buy Pack 4 Quantity Matched with PDP Page and Cart Page");
									
								} else {
									
									System.err.println("The Combo Buy Pack 4 Quantity is not Matched with PDP Page and Cart Page");

								}
								
								
								///
								Thread.sleep(3000);
								btnclick(m.getRemoveButton());
								
								
								Thread.sleep(3000);
							//	driver.findElementByAccessibilityId("Navigate up").click();
								
								
							} else {
								
								
							}

							
							
							
						} else {
							
							System.out.println("There is no Combo Pack Available");

						}
						
						
						/////

						////////////////////////
				/*		
						////Frequently Bought
		Thread.sleep(2000);
						
						Thread.sleep(10000);
						btnclick(m.getMsite_Cart_Search());
						Thread.sleep(2000);
						
						Thread.sleep(2000);
						m.getMsite_Cart_Search().sendKeys("Gemer");
						
						Thread.sleep(5000);
						driver.hideKeyboard();
						
						Thread.sleep(5000);
						Thread.sleep(2000);
								btnclick(m.getMsite_SearchResult_drugName());
								Thread.sleep(5000);
						
								Thread.sleep(3000);
								Thread.sleep(2000);
								driver.swipe(0, 1000, 0, 0, 1000);
								
								Thread.sleep(3000);
								Thread.sleep(2000);
								driver.swipe(0, 500, 0, 0, 1000);
								
								
								Thread.sleep(3000);
								if (m.getPDP_FrequentlyBrought_text().isDisplayed()) {
									
								
								
								Thread.sleep(3000);
								btnclick(m.getPDP_FrequentlyBrought_AddToCart());
								
								Thread.sleep(3000);
								btnclick(m.getPDP_FrequentlyBrought_Productname());
								
								Thread.sleep(2000);
								driver.findElement(By.xpath("//*[@class='back-icon']")).click();
								
								
								Thread.sleep(10000);
							//	driver.findElement(By.xpath("//*[@class='back-icon']")).click();
								
								} else {
									
									System.out.println("There is no frequently Brought Product");
								}
								
								
								//// Alternade Brands
								Thread.sleep(2000);
								Thread.sleep(5000);
								m.getMsite_Cart_Search().click();
								Thread.sleep(3000);
								type(m.getMsite_Search_box(), "Trajenta 5mg Tablet 10");
								Thread.sleep(2000);
				               
								
								Thread.sleep(5000);
								driver.hideKeyboard();
								
								Thread.sleep(5000);

								Thread.sleep(2000);
										btnclick(m.getMsite_SearchResult_drugName());
										Thread.sleep(5000);
										
										Thread.sleep(3000);
										Thread.sleep(2000);
										driver.swipe(0, 1000, 0, 0, 1000);
										
										
										Thread.sleep(2000);
										driver.swipe(0, 1000, 0, 0, 1000);
										
										Thread.sleep(3000);
										if (m.getPDP_AlternateBrand_Text().isDisplayed()) {
											
											Thread.sleep(2000);
											List<WebElement> CART_SIZE = driver.findElements(By.xpath("//*[@text=' Add to Cart ']"));
											int aa = CART_SIZE.size();
											
										//	btnclick(CART_SIZE.get(aa-1));
											
											Thread.sleep(3000);
											String abText = gettext(m.getPDP_AlternateBrand_Name());
											
											Thread.sleep(3000);
											btnclick(driver.findElement(By.xpath("//*[@text=' Add to Cart ']")));
											
											
											Thread.sleep(10000);
											String cart_drug = gettext(m.getCart_drug_name());
											
											Thread.sleep(2000);
											if (abText.contains(cart_drug)) {
												
												System.out.println("Alternate Brand Added to  the Cart Successfully");
												
											} else {

												System.out.println("Alternate Brand Not  Added to  the Cart Successfully");
												
											}
											
										} else {
											
											System.out.println("There is no Alternate brand Available");

										}
										
										
						
						
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
		    
		    
	 }
			


		@AfterTest
		private void quitbrowser() {
			report.flush();
			
	 //     driver.quit();
		}
	
	

}
