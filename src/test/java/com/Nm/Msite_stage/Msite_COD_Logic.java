package com.Nm.Msite_stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Msite_COD_Logic extends MsiteBaseClass {
	
	

	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		
		
		@BeforeClass
			public void launchbrowser2()   {
					DesiredCapabilities capabilities = new DesiredCapabilities();

		    capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE ,"com.android.chrome");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY ,"com.google.android.apps.chrome.Main");
			capabilities.setCapability("noReset", true);			
		//	capabilities.setCapability("autoDismissAlerts", true);  			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "Android");
		//	capabilities.setCapability(MobileCapabilityType.VERSION,"11 RP1A.200720.011" );
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
	
	
	@Test(priority = 2,enabled = false)
	public void cod_Logic_2() throws Throwable {
		
		logger =  report.createTest("Cash On Delivery Logic");
		logger.log(Status.PASS, "COD for 60 to 500" );
		
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
					letschat();
					Thread.sleep(2000);
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
				driver.get("https://m.netmeds.com");
				
				Thread.sleep(5000);
				String aa = "Rxtor";
				String [] spl = aa.split(",");
				System.out.println(spl.length);
				
				
				
				for (int i = 0; i < spl.length; i++) {
					
				Thread.sleep(10000);
				//btnclick(m.getHeader_SearchBar());
				Thread.sleep(5000);
				//type(m.getSearchBar(), spl[i]);
				m.getHeader_SearchBar().sendKeys(spl[i]);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='search-text search-bg']")).click();
				//m.getHeader_SearchBar().sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				
				Thread.sleep(5000);
				
				driver.hideKeyboard();
				
				Thread.sleep(5000);
				btnclick(m.getMsite_Search_AddToCart());
				
				
				
				for (int j = 0; j < 5; j++) {
					
					Thread.sleep(3000);
					btnclick(m.getSearch_results_AddTocart_IncreaseQty());
					
					
				}
				
				Thread.sleep(5000);
				btnclick(m.getPDP_Cart_btn());
				

				Thread.sleep(3000);
				letschat();
				Thread.sleep(10000);
				btnclick(m.getMsite_m2_ProceedBtn());

				try {
				Thread.sleep(10000);
			//	btnclick(m.getMsite_m2_ProceedBtn());	
				}catch (Exception e) {
					Thread.sleep(15000);
			//		driver.findElement(By.xpath("//*[@text='Proceed']")).click();
				}
			

			try {	
				Thread.sleep(3000);
				letschat();
				Thread.sleep(6000);
				btnclick(m.getMsite_Doctor_Consultation());
				if (m.getMsite_Doctor_Consultation().isSelected()) {
				//	System.out.println(" Already Schedule Doctor Selected ");
				} else {
					Thread.sleep(3000);
				//	btnclick(m.getMsite_Doctor_Consultation());
				}
				
				
				Thread.sleep(3000);
			//	btnclick(m.getDoctorConsultation_CloseBtn());
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			try {
				Thread.sleep(3000);
				btnclick(m.getOrder_review_btn());
			} catch (Exception e) {
				// TODO: handle exception
			}
			float total ;
				Thread.sleep(3000);
				String Tot = m.getOrder_review_totalAmount().getText();
				System.out.println(Tot);
				try {
				String tota = Tot.substring(3, 9);
				System.out.println(tota);
				 total = Float.parseFloat(tota);
				System.out.println(total);
				} catch (Exception e) {
					String tota = Tot.substring(3, 10);
					System.out.println(tota);
					if (tota.contains(",")) {
						Thread.sleep(1000);
						String rep = tota.replace(",", "");
						total = Float.parseFloat(rep);
						System.out.println(total);
					} else {
						Thread.sleep(1000);
						 total = Float.parseFloat(tota);
							System.out.println(total);
					}
					
				}
				
				Thread.sleep(3000);
				btnclick(m.getOrder_review_payBtn());
				
				
				
				Thread.sleep(3000);
				if (total<60||total>5000) {
					
					System.out.println("Unable to Process the payment / Cash on Delivery Option.The Net Value was Below 60 or above 5000");
				try {	
					
					for (int j = 0; j < 10; j++) {
						
						Thread.sleep(3000);
						driver.swipe(50, 500, 0, 0, 1000);
						if (m.getCOD_CheckBox_List().size()!=0) {
						
							Thread.sleep(3000);
							break;
						} else {
							
						}
					}
					Thread.sleep(3000);

				}catch (Exception e) {
					// TODO: handle exception
				}
				
				/////
					
				} else {
					
                 for (int j = 0; j < 10; j++) {
						
						Thread.sleep(3000);
						driver.swipe(50, 500, 0, 0, 1000);
						if (m.getCOD_CheckBox_List().size()!=0) {
						
							Thread.sleep(3000);
							break;
						} else {
							
						}
						
                 }
						Thread.sleep(3000);
						letschat();
						
						
					Thread.sleep(3000);
					btnclick(m.getCOD_CheckBox());
					
					
					Thread.sleep(3000);
					btnclick(m.getCOD_PayBtn());
					
					Thread.sleep(10000);

		Thread.sleep(5000);
					driver.swipe(50, 750, 0, 0, 1000);
				//	btnclick(m.getTrack_Order());
					driver.findElement(By.xpath("//android.widget.Button[@text='TRACK ORDER']|//*[@text='TRACK ORDER']|//*[@text='Track Order']")).click();

					 Thread.sleep(10000);

Thread.sleep(5000);
btnclick(m.getViewdetails());
try {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
}catch (Exception e) {
	// TODO: handle exception
}
for (int ii = 0; ii < 10; ii++) {

	
	Thread.sleep(3000);
	driver.swipe(0, 900, 0, 0, 1000);
	try {
		if (driver.findElement(By.xpath("//*[@text='Cancel Order']")).isDisplayed()) {

			
			Thread.sleep(3000);
			//btnclick(m.getPackageImage());
			break;
		} else {
			
			System.out.println("Swipe Down to click on package Button");

		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

//MobileElement co = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']"));co.click();
driver.findElement(By.xpath("//*[@text='Cancel Order']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text='Delay in delivery ']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL' and @nodeName='BUTTON' and @top='true']")).click();
//touchAction.tap(100,i1).perform();
	}
					 
					 
					 /*
					 letschat();
					 driver.findElement(By.xpath("//*[@text=' View Details ']|//android.widget.Button[@text='VIEW DETAILS']")).click();
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@text='Cancel Order']|//android.widget.Button[@text='CANCEL ORDER']")).click();
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@css='INPUT.ng-untouched.ng-pristine.ng-valid']|//android.widget.RadioButton[@text='Delay in delivery']")).click();
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
					Thread.sleep(10000);
					*/
				//	driver.get("https://m.netmeds.com");
					
					Thread.sleep(6000);
					
					
					
				}
				
				}
				@Test(priority = 1)
				public void above5000() throws Throwable {

						
						logger =  report.createTest("Cash On Delivery Logic");
						logger.log(Status.PASS, "Above 5000" );
						
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
									letschat();
									Thread.sleep(2000);
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
						//		driver.get("https://m.netmeds.com");
								
								Thread.sleep(5000);
								String aa = "Malibu C Swimmers";
							//	String [] spl = aa.split(",");
						//		System.out.println(spl.length);
								
								
								
								for (int i = 0; i < 1; i++) {
									
								Thread.sleep(10000);
								driver.findElement(By.xpath("//*[@nodeName='SPAN' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@nodeName='DIV' and ./*[@nodeName='DIV']]]]")).click();
								//btnclick(m.getHeader_SearchBar());
							//	m.getHeader_SearchBar().click();
								Thread.sleep(3000);
								driver.findElement(By.xpath("//*[@text and @nodeName='DIV' and @width>0 and ./parent::*[@nodeName='APP-SHOPPING-CART']]")).click();
								Thread.sleep(5000);
							//	type(m.getSearchBar(), spl[i]);
								driver.findElement(By.xpath("//*[@placeholder='Search here...' and @top='true']|//*[@text and @nodeName='DIV' and @width>0 and ./parent::*[@nodeName='APP-SHOPPING-CART']]")).sendKeys("Malibu C Swimmers");
								//m.getHeader_SearchBar().sendKeys(aa);
								Thread.sleep(5000);
							//	driver.findElement(By.xpath("//*[@class='search-text search-bg']")).click();
								driver.findElement(By.xpath("//*[@css='BUTTON.btn.btn_to_cart.m-0']|//*[@css='BUTTON.search-cartbtn.toCart.addtocartbtn.prodbtn.addtocartdirctbtn']")).click();
								//m.getHeader_SearchBar().sendKeys(Keys.ENTER);
								Thread.sleep(5000);
								
								Thread.sleep(5000);
								
								//driver.hideKeyboard();
								
								Thread.sleep(5000);
							//	btnclick(m.getMsite_Search_AddToCart());
								
								
								
								for (int j = 0; j < 2; j++) {
									
									Thread.sleep(3000);
								//	btnclick(m.getSearch_results_AddTocart_IncreaseQty());
									driver.findElement(By.xpath("//*[@class='qtyplus']|(((((//*[@nodeName='DIV' and ./parent::*[@nodeName='DIV' and ./parent::*[@id='frameModalBottom']]]/*[@nodeName='DIV'])[2]/*[@nodeName='DIV'])[2]/*[@nodeName='DIV'])[2]/*[@nodeName='DIV'])[2]/*[@text and @nodeName='SPAN'])[2]|(//*/*[@nodeName='BUTTON'])[2]")).click();
									
								}
								
								Thread.sleep(5000);
								btnclick(m.getPDP_Cart_btn());
								Thread.sleep(5000);
								driver.navigate().to("https://m.netmeds.com/checkout/cart");

								Thread.sleep(3000);
								letschat();
								Thread.sleep(10000);
								btnclick(m.getMsite_m2_ProceedBtn());

								try {
								Thread.sleep(10000);
							//	btnclick(m.getMsite_m2_ProceedBtn());	
								}catch (Exception e) {
									Thread.sleep(15000);
							//		driver.findElement(By.xpath("//*[@text='Proceed']")).click();
								}
							

							try {	
								Thread.sleep(3000);
								letschat();
								Thread.sleep(6000);
								btnclick(m.getMsite_Doctor_Consultation());
								if (m.getMsite_Doctor_Consultation().isSelected()) {
								//	System.out.println(" Already Schedule Doctor Selected ");
								} else {
									Thread.sleep(3000);
								//	btnclick(m.getMsite_Doctor_Consultation());
								}
								
								
								Thread.sleep(3000);
							//	btnclick(m.getDoctorConsultation_CloseBtn());
								
								
								
							} catch (Exception e) {
								// TODO: handle exception
							}
							
							
							try {
								Thread.sleep(3000);
								btnclick(m.getOrder_review_btn());
							} catch (Exception e) {
								// TODO: handle exception
							}
							float total ;
								Thread.sleep(3000);
								String Tot = m.getOrder_review_totalAmount().getText();
								System.out.println(Tot);
								try {
								String tota = Tot.substring(3, 9);
								System.out.println(tota);
								 total = Float.parseFloat(tota);
								System.out.println(total);
								} catch (Exception e) {
									String tota = Tot.substring(3, 10);
									System.out.println(tota);
									if (tota.contains(",")) {
										Thread.sleep(1000);
										String rep = tota.replace(",", "");
										total = Float.parseFloat(rep);
										System.out.println(total);
									} else {
										Thread.sleep(1000);
										 total = Float.parseFloat(tota);
											System.out.println(total);
									}
									
								}
								
								Thread.sleep(3000);
								btnclick(m.getOrder_review_payBtn());
								
								
								
								Thread.sleep(3000);
								if (total<60||total>5000) {
									
									System.out.println("Unable to Process the payment / Cash on Delivery Option.The Net Value was Below 60 or above 5000");
								try {	
									
									for (int j = 0; j < 10; j++) {
										
										Thread.sleep(3000);
										driver.swipe(50, 500, 0, 0, 1000);
										if (m.getCOD_CheckBox_List().size()!=0) {
										
											Thread.sleep(3000);
											break;
										} else {
											
										}
									}
									Thread.sleep(3000);

								}catch (Exception e) {
									// TODO: handle exception
								}
								
								/////
									
								} else {
									
				                 for (int j = 0; j < 10; j++) {
										
										Thread.sleep(3000);
										driver.swipe(50, 500, 0, 0, 1000);
										if (m.getCOD_CheckBox_List().size()!=0) {
										
											Thread.sleep(3000);
											break;
										} else {
											
										}
										
				                 }
										Thread.sleep(3000);
										letschat();
										
										
									Thread.sleep(3000);
									btnclick(m.getCOD_CheckBox());
									
									
									Thread.sleep(3000);
									btnclick(m.getCOD_PayBtn());
									
									Thread.sleep(10000);

						Thread.sleep(5000);
									driver.swipe(50, 750, 0, 0, 1000);
								//	btnclick(m.getTrack_Order());
									driver.findElement(By.xpath("//android.widget.Button[@text='TRACK ORDER']|//*[@text='TRACK ORDER']|//*[@text='Track Order']")).click();

									 Thread.sleep(10000);

				Thread.sleep(5000);
				btnclick(m.getViewdetails());
				try {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
				}catch (Exception e) {
					// TODO: handle exception
				}
				for (int ii = 0; ii < 10; ii++) {

					
					Thread.sleep(3000);
					driver.swipe(0, 900, 0, 0, 1000);
					try {
						if (driver.findElement(By.xpath("//*[@text='Cancel Order']")).isDisplayed()) {

							
							Thread.sleep(3000);
							//btnclick(m.getPackageImage());
							break;
						} else {
							
							System.out.println("Swipe Down to click on package Button");

						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					}

				//MobileElement co = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']"));co.click();
				driver.findElement(By.xpath("//*[@text='Cancel Order']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@text='Delay in delivery ']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL' and @nodeName='BUTTON' and @top='true']")).click();
				//touchAction.tap(100,i1).perform();
					}
									 
									 
									 /*
									 letschat();
									 driver.findElement(By.xpath("//*[@text=' View Details ']|//android.widget.Button[@text='VIEW DETAILS']")).click();
									 Thread.sleep(3000);
									 driver.findElement(By.xpath("//*[@text='Cancel Order']|//android.widget.Button[@text='CANCEL ORDER']")).click();
									 Thread.sleep(3000);
									 driver.findElement(By.xpath("//*[@css='INPUT.ng-untouched.ng-pristine.ng-valid']|//android.widget.RadioButton[@text='Delay in delivery']")).click();
									 Thread.sleep(3000);
									 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
									Thread.sleep(10000);
									*/
								//	driver.get("https://m.netmeds.com");
									
									Thread.sleep(6000);
									
									
									
								}
								
								}
								
					
					
					

				

				
}
