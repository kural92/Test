package com.Nm.Andriod_prod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.MobileBaseClass;
import com.Nm.Pom.AndriodPom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class Frequently_Bought extends MobileBaseClass{
	


	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.UDID, UDID); //RZ8R20GLXTA //GBT4C19326001968
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
	//		capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
   public void startReport() {
   	
      htmlReporter = new ExtentHtmlReporter(".//Report//Moneflow.html");
       
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
	
	
	@Test
	public void freqBought() throws Throwable {
		

		logger =  report.createTest("Adding Alternate Brands and Most Selling Products to Cart");
		logger.log(Status.PASS, "*************AlterNate and Most Selling Product********************" );
		
		AndriodPom m = new AndriodPom();
		
		Thread.sleep(10000);
		popupclose();
		popupclose();
		try {
			Thread.sleep(2000);
			btnclick(m.getLetsstarted());
			Thread.sleep(10000);
			driver.hideKeyboard();
		} catch (Exception e) {
			driver.launchApp();
		}
		
		
		popupclose();
		popupclose();
		try {
			
			Thread.sleep(2000);
			m.getMobilenumber().sendKeys(" ");
			Thread.sleep(3000);
			btnclick(m.getUsepwd());
			Thread.sleep(5000);
		
			m.getPassword().sendKeys(" ");
			
			btnclick(m.getLogin());
			Thread.sleep(2000);
		}catch(Exception e) {
				System.out.println("Already logged in");
			}
		Thread.sleep(10000);
		btnclick(m.getGotocart()); 
		for (int i = 0; i < 16; i++) {
			Thread.sleep(3000);
			if ((driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_no_result']")).size() == 0)) {

				try {
					btnclick(m.getRemoveButton());
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else {
				logger.log(Status.PASS, "Successfully Product Removed from Cart");
				break;

			}
		}
		Thread.sleep(5000);
		btnclick(m.getCart_search());
		Thread.sleep(2000);
		
		
		Thread.sleep(5000);
		m.getSearchbarone().sendKeys(MobileBaseClass.getExcelData("AndPDP", 0, 0));
		
		Thread.sleep(5000);
		driver.hideKeyboard();
		
		Thread.sleep(5000);
		Thread.sleep(2000);
				btnclick(m.getSearch_drugname());
				Thread.sleep(5000);
		
				Thread.sleep(3000);
				
				for (int i = 0; i < 10; i++) {
					Thread.sleep(2000);
					driver.swipe(0, 900, 0, 0, 1000);
					Thread.sleep(2000);
					if (m.getPDP_FrequentlyBrought_text().isDisplayed()|m.getPDP_FrequentlyBrought_text_Lst().size()==1) {
						System.out.println("Swipe down to check Frequently Brought");
						break;
					} else {

					}
				}
				
				
				Thread.sleep(3000);
				Thread.sleep(2000);
				//driver.swipe(0, 700, 0, 0, 1000);
				
				
				Thread.sleep(3000);
				if (m.getPDP_FrequentlyBrought_text().isDisplayed()) {
					
					try {
						Thread.sleep(3000);
						btnclick(m.getSnackBar_GotIT_btn());
						}catch (Exception e) {
							// TODO: handle exception
						}
				
				Thread.sleep(3000);
				btnclick(m.getPDP_FrequentlyBrought_AddToCart());
				
				Thread.sleep(3000);
				btnclick(m.getPDP_FrequentlyBrought_Productname());
				
				Thread.sleep(3000);
				driver.findElementByAccessibilityId("Navigate up").click();
				
				Thread.sleep(3000);
				driver.findElementByAccessibilityId("Navigate up").click();
				
				} else {
					
					System.out.println("There is no frequently Brought Product");
				}
				
				//////
				
				Thread.sleep(2000);
				try {
				btnclick(m.getSearch_X_button());
				}catch (Exception e) {
					// TODO: handle exception
				}
				Thread.sleep(7000);
			
						Thread.sleep(2000);
						m.getSearchbarone().sendKeys("Horlicks");
						
						Thread.sleep(5000);
						driver.hideKeyboard();
						
						Thread.sleep(5000);
						btnclick(m.getSearch_drugname());
						Thread.sleep(5000);
						
			
				
						for (int i = 0; i < 10; i++) {
							Thread.sleep(2000);
							driver.swipe(0, 500, 0, 0, 1000);
							Thread.sleep(2000);
							if (m.getPDP_BuyPack_ComboList().size()==2|m.getPDP_BuyPack_ComboList().size()==1) {
								System.out.println("Swipe Down Check the Combo Pack");
								break;
								
							} else {

							}
						}
						
						Thread.sleep(3000);
						if (m.getPDP_ComboPack_text().getText().contains("COMBO PACKS")) {
							
							Thread.sleep(3000);
							if (m.getPDP_BuyPack_ComboList().size()==2) {
								
								Thread.sleep(3000);
								String Mrp = gettext(m.getPDP_BuyPack_Combo_PriceList().get(1));
								System.out.println(Mrp);
								Thread.sleep(2000);
								driver.swipe(0, 400, 0, 0, 1000);
								Thread.sleep(3000);
							//	btnclick(m.getPDP_BuyPack_ComboList().get(1));
								driver.findElement(By.xpath("(//android.widget.TextView[@text='BUY PACK'])[2]")).click();
								try {
								Thread.sleep(3000);
								btnclick(m.getSnackBar_GotIT_btn());
								}catch (Exception e) {
									// TODO: handle exception
								}
								Thread.sleep(3000);
								btnclick(m.getPDP_ProceedToCart());
								
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
								
								
								///
								Thread.sleep(3000);
								btnclick(m.getRemoveButton());
								
								
								Thread.sleep(3000);
								//driver.findElementByAccessibilityId("Navigate up").click();
								Thread.sleep(3000);
								
							} else if (m.getPDP_BuyPack_ComboList().size()==1) {
								
								Thread.sleep(3000);
								String Mrp = gettext(m.getPDP_BuyPack_Combo_PriceList().get(0));
								Thread.sleep(2000);
								try {
									Thread.sleep(3000);
									btnclick(m.getSnackBar_GotIT_btn());
									}catch (Exception e) {
										// TODO: handle exception
									}
								Thread.sleep(3000);
								driver.swipe(0, 400, 0, 0, 1000);
								Thread.sleep(3000);
								//btnclick(m.getPDP_BuyPack_ComboList().get(0));
								driver.findElement(By.xpath("//android.widget.TextView[@text='BUY PACK']")).click();
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
}

}

