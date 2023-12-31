package com.Nm.Msite_stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Msite_COD_Processing extends MsiteBaseClass {
	
	
	

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
	public void cod_Processing() throws Throwable {
		
		
		logger =  report.createTest("Cash On Delivery Logic");
		logger.log(Status.PASS, "COD Processing Order" );
		
		MsitePOM m = new MsitePOM();
		
		for (int k = 0; k < 4; k++) {
		
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

				driver.findElement(By.xpath("//*[@text='Search for medicine & wellness products...' and @nodeName='SPAN']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@name='q']")).sendKeys( "Horlicks Health Drink Powder Classic Malt 500 gm (Refill Pack)");//Patanjali Lauh Bhasm Powder 5 gm
				Thread.sleep(1500);
				driver.pressKeyCode(AndroidKeyCode.ENTER);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@text and @nodeName='DIV' and ./parent::*[@nodeName='A' and (./preceding-sibling::* | ./following-sibling::*)[@nodeName='DIV']]]")).click();
				// btncli(m.getSearchIcon());
				logger.log(Status.PASS, "Successfully navigate to search result page" );

				
				//add to the cart
				
				Thread.sleep(3000);
				 driver.swipe(0, 500, 0, 0, 1000);
					try {
						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@text=' ADD TO CART ']")).click();
					
					}catch (Exception e) {
						// TODO: handle exception
					}
					Thread.sleep(5000);
					
					//add the product
					
					driver.findElement(By.xpath("//*[@text and @nodeName='SPAN' and ./parent::*[@nodeName='DIV' and ./parent::*[@nodeName='A']]]")).click();
					logger.log(Status.PASS, "Successfully navigate to cart page" );
					Thread.sleep(15000);
					driver.findElement(By.xpath("//*[@text='Proceed']")).click();
					logger.log(Status.PASS, "Successfully navigate to search order review page" );
					try {
						Thread.sleep(2000);
						driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]")).click();
					}catch (Exception e) {
						// TODO: handle exception
					}


					

			Thread.sleep(3000);
			//driver.swipe(0, 900, 0, 0, 1000);
			Thread.sleep(3000);
			//touchAction.tap(i-100,i1-100).perform();
			driver.findElement(By.xpath("//*[@text='Pay']")).click();
			Thread.sleep(3000);



			for (int i = 0; i < 5; i++) {
				
				Thread.sleep(3000);
				driver.swipe(0, 900, 0, 0, 1000);
				
				if (m.getPayment_cod_list().size()==1) {
					
					Thread.sleep(3000);
					 btnclick(m.getPayment_cod());
					break;
				} else {
					
					System.out.println("Swipe Down to click on pay Button");

				}}
			
			Thread.sleep(3000);
			try {
				letschat();
			} catch (Exception e) {
				// TODO: handle exception
			}

			Thread.sleep(3000);
			try {
			btnclick(m.getPayment_paybutton());
			} catch (Exception e) {
				driver.findElement(By.xpath("//*[@text and @nodeName='BUTTON']|//*[@text='PAY WITH CASH']")).click();
			}
		}
			/*
			driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);driver.swipe(0, 900, 0, 0, 1000);
			Thread.sleep(3000);
			MobileElement cod = (MobileElement) driver.findElement(By.xpath("//*[@id='nms_cod' and @name='nmsmstr_paymethod']"));cod.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@text and @nodeName='BUTTON']")).click();*/





			 


			/*Thread.sleep(3000);
			driver.swipe(0, 900, 0, 0, 1000);*/


			//Step 16 : Ensure order is placed successfully//

			/*
			 * Thread.sleep(10000); driver.swipe(0, 500, 0, 0, 1000); WebDriverWait wait =
			 * new WebDriverWait(driver, 30);
			 * wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.
			 * xpath("//*[@text='Track Order']")))); Thread.sleep(1000);
			 */
				
				
				
				
				
				
				
				
	
				
				
				
				
				
				
		/*		
				

				Thread.sleep(3000);
				String aa = "Gemer 2mg";
				String [] spl = aa.split(",");
				System.out.println(spl.length);
				
				
				
				for (int i = 0; i < 4; i++) {
					
				Thread.sleep(3000);
				btnclick(m.getHeader_SearchBar());
				Thread.sleep(5000);
				//type(m.getSearchBar(), spl[i]);
				m.getHeader_SearchBar().sendKeys(aa);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='search-text search-bg']")).click();
				//m.getHeader_SearchBar().sendKeys(Keys.ENTER);
				Thread.sleep(5000);
				
				Thread.sleep(5000);
				
				driver.hideKeyboard();
				
				Thread.sleep(5000);
				btnclick(m.getMsite_Search_AddToCart());
				
				
				
				for (int j = 0; j < 2; j++) {
					
					Thread.sleep(3000);
					btnclick(m.getSearch_results_AddTocart_IncreaseQty());
					
					
				}
				
				Thread.sleep(5000);
				btnclick(m.getPDP_Cart_btn());
				
				
				Thread.sleep(10000);
				btnclick(m.getMsite_m2_ProceedBtn());
				try {
					Thread.sleep(3000);
					letschat();
				} catch (Exception e) {
					// TODO: handle exception
				}
			try {	
				
				
				Thread.sleep(6000);
				btnclick(m.getMsite_Doctor_Consultation());
				
				Thread.sleep(3000);
			//	btnclick(m.getDoctorConsultation_CloseBtn());
				
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
				
				
				
				Thread.sleep(10000);
				if (total<60||total>5000) {
					
					System.out.println("Unable to Process the payment / Cash on Delivery Option.The Net Value was Below 60 or above 5000");
				try {	
					Thread.sleep(3000);
					driver.swipe(0, 500, 0, 0, 1000);
					
					Thread.sleep(3000);
					driver.swipe(0, 500, 0, 0, 1000);
					
					Thread.sleep(3000);
					driver.swipe(0, 500, 0, 0, 1000);
					
					Thread.sleep(3000);
					driver.swipe(0, 500, 0, 0, 1000);
					
					
					Thread.sleep(3000);
					if (m.getCOD_CheckBox().isDisplayed()) {
						
					} else {
						System.err.println("COD Option  available ");
					}
					
					
				
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
					
					/////
					Thread.sleep(10000);
					if (!(m.getCOD_Not_Eligible_Text_List().size()==0)) {
						
				//	
						Thread.sleep(3000);
						letschat();
						Thread.sleep(3000);
						btnclick(m.getCOD_CheckBox());
						
						Thread.sleep(3000);
						btnclick(m.getCOD_PayBtn());
						
					Thread.sleep(6000);
					driver.get("https://m.netmeds.com");
					
					
					////
					
					

					Thread.sleep(3000);
				
					Thread.sleep(3000);
					driver.swipe(0, 200, 0, 0, 1000);
				//	btnclick(m.getTrack_Order());
				//	driver.findElement(By.xpath("//android.widget.Button[@text='TRACK ORDER']|//*[@text='TRACK ORDER']")).click();
					 Thread.sleep(10000);
					 letschat();
					 List<WebElement> view_Details =  driver.findElements(By.xpath("//*[@text=' View Details ']|//android.widget.Button[@text='VIEW DETAILS']"));
					 Thread.sleep(3000);
						for (int j = 0; j < 3; j++) {
							Thread.sleep(6000);
							btnclick(view_Details.get(j));
						
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@text='Cancel Order']|//android.widget.Button[@text='CANCEL ORDER']")).click();
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@css='INPUT.ng-untouched.ng-pristine.ng-valid']|//android.widget.RadioButton[@text='Delay in delivery']")).click();
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
					
					
					Thread.sleep(10000);
					driver.get("https://m.netmeds.com/customer/orderhistory");
					
					Thread.sleep(10000);
					
					
					
				}
				
				else {
					Thread.sleep(3000);
					System.out.println("There More Than 2 Order was in Proicessing.COD is not eligible for this order");
					
					
					
					Thread.sleep(13000);

					Thread.sleep(3000);
				
					Thread.sleep(3000);
					driver.swipe(50, 200, 0, 0, 1000);
				//	btnclick(m.getTrack_Order());
				//	driver.findElement(By.xpath("//android.widget.Button[@text='TRACK ORDER']|//*[@text='TRACK ORDER']")).click();
					 Thread.sleep(10000);
					 letschat();
					 List<WebElement> view_Details =  driver.findElements(By.xpath("//*[@text=' View Details ']|//android.widget.Button[@text='VIEW DETAILS']"));
					 Thread.sleep(3000);
						for (int jj = 0; jj < 3; jj++) {
							Thread.sleep(6000);
							btnclick(view_Details.get(jj));
						
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@text='Cancel Order']|//android.widget.Button[@text='CANCEL ORDER']")).click();
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@css='INPUT.ng-untouched.ng-pristine.ng-valid']|//android.widget.RadioButton[@text='Delay in delivery']")).click();
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
					
						Thread.sleep(10000);
						driver.get("https://m.netmeds.com/customer/orderhistory");
						
						Thread.sleep(10000);*/
					
		//		}
				
				
		
		

//	}

//}
//	}

/////
}

}
