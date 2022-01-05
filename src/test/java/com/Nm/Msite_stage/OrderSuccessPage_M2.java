package com.Nm.Msite_stage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.BaseClass;
import com.Nm.Base.MobileBaseClass;
import com.Nm.Base.MsiteBaseClass;
import com.Nm.Pom.AndriodPom;
import com.Nm.Pom.Monepom;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class OrderSuccessPage_M2 extends MsiteBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		
		public void launchbrowser()   {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			//capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA"); //RZ8R20GLXTA //GBT4C19326001968

		//	capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");  //fc95d519 //RZ8R20GLXTA

			capabilities.setCapability("platformName", "Android");
		//	capabilities.setCapability("deviceName", "vivo 1819");
		//	capabilities.setCapability("platformVersion","10.0.0" );
			//for m-site
			//capabilities.setCapability("chromedriverExecutable", "D:\\Eclipse\\nm_website\\driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			/*capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.NetmedsMarketplace.Netmeds");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			*/
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE ,"com.android.chrome");
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY ,"com.google.android.apps.chrome.Main");
			capabilities.setCapability("noReset", true);
			
			capabilities.setCapability("autoDismissAlerts", true);  
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("newCommandTimeout", 100);
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}

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
	

//********************************M2 Order Success page
		
		
		
		 @Test(enabled = true)
		  public void laucnh() throws Throwable {
			  
			  driver.get("https://m.netmeds.com/");
			  driver.manage().timeouts().pageLoadTimeout(60000, TimeUnit.MILLISECONDS);
			 // driver.manage().window().maximize();
			  MsitePOM m = new MsitePOM();
			  Thread.sleep(10000);
			 // driver.findElement(By.xpath("//android.view.View[@text()='INTRODUCING NETMEDS LITE']/preceding-sibling::android.view.View[@index='0']")).click();
			  try {

			  driver.findElement(By.xpath("//*[@class='app_close']")).click();
				//  m.getMsite_HomeScreen_POP_UP().click();

			//  driver.findElement(By.xpath("//android.view.View[@text='✕']")).click();

			  }catch (Exception e) {
				// TODO: handle exception
			}
			  
			  Thread.sleep(10000);

			  m.getMsite_OrderNow().click();

			  letschat();


			  letschat();
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='UPLOAD PRESCRIPTION']|//*[@text='Upload Prescription']")).click();
			//  m.getMsite_Upload_Prescription().click();
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='Choose Files']|//*[@css='INPUT.ng-untouched.ng-pristine.ng-valid']")).click();
			//  m.getMsite_Upload_Gallery().click();
			  Thread.sleep(5000);
		//	  driver.findElement(By.xpath("(//*[@knownSuperClass='android.widget.ImageView'])[5]")).click();//"(//*[@id='bitmap_view'])[3]|(//android.widget.ImageView[@resource-id='com.android.chrome:id/bitmap_view'])[3]")).click();
			// Auto IT Script
				
			  //Switch to Native_App
		        Set<String> contextNames = driver.getContextHandles();
		        for (String strContextName : contextNames) {
		            if (strContextName.contains("NATIVE_APP")) {
		                driver.context("NATIVE_APP");
		                break;
		            }
		        }
			  
		        //
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("(//*[@id='bitmap_view'])[3]|(//android.widget.ImageView[@resource-id='com.android.chrome:id/bitmap_view'])[3]")).click(); //(//*[@knownSuperClass='android.widget.ImageView'])[5]")).click();
				
		        Thread.sleep(5000);
				  driver.findElement(By.id("done")).click();
				  
		        
		        //Switch to Chrome browser
		        Set<String> contextNames1 = driver.getContextHandles();
		        for (String strContextName : contextNames1) {
		            if (strContextName.contains("CHROMIUM")) {
		                driver.context("CHROMIUM");
		                break;
		            }
		        }
	
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("(//*[@css='INPUT.m2checkbox.ng-untouched.ng-pristine.ng-valid'])[1]|//android.widget.RadioButton[@text='Search and Add medicines']")).click();
		//	m.getMsite_M2_searchMedicine().click();  


			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//*[@text='Continue']|//android.widget.Button[@text='CONTINUE']")).click();
		//	m.getMsite_M2_SearcCall_ContinueButton().click();  
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//*[@css='INPUT.ais-SearchBox-input']")).sendKeys("Telma");
			 
			 Thread.sleep(2000);
			 driver.hideKeyboard();
			 
			 
			 
			 Thread.sleep(5000);
			  driver.findElement(By.xpath("(//*[@css='BUTTON.btn.btn_to_cart.m-0'])[1]|/hierarchy/android.widget.FrameLayout/"
			  		+ "android.widget.LinearLayout/android.widget.FrameLayout/"
			  		+ "android.widget.FrameLayout/android.widget.FrameLayout/"
			  		+ "android.view.ViewGroup/android.widget.FrameLayout[1]/"
			  		+ "android.widget.FrameLayout[2]/android.webkit.WebView/"
			  		+ "android.view.View/android.view.View[2]/android.view.View[2]/"
			  		+ "android.view.View[5]/android.view.View[4]/android.widget.Button")).click();
			  
			  
			 Thread.sleep(5000);
			  driver.findElement(By.xpath("//*[@text=' Add to Cart ']|//android.widget.Button[@text='ADD TO CART']")).click();
			  
			 
			 Thread.sleep(5000);
			  driver.findElement(By.xpath("//*[@text='Proceed']|//android.widget.Button[@text='PROCEED']")).click();
			  
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//*[@text='Confirm Order']|//*[@text='Confirm Order' and @top='true']")).click();
	 
			 Thread.sleep(3000);
				
			//Order Success Page
						 
		letschat();

		System.out.println(driver.findElement(By.xpath("//*[@text='Order Placed Successfully!']")).getText());
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.xpath("//*[@class='ordstatus']")).getText());
		
		Thread.sleep(3000);
		driver.swipe(0, 1400, 0, 0, 1000);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Consult Now']")).click();
		
		driver.navigate().to("https://www.netmeds.com/customer/orderhistory");
		
		//Let's chat handle//
		letschat();
		
		Thread.sleep(5000);
		
		

		
		
       
		
	//	driver.findElement(By.xpath("//*[@class='btn-view ord-btn']|//android.widget.Button[@text='VIEW DETAILS']")).click();
		btnclick(m.getViewdetails());
		Thread.sleep(5000);
		
		//Switch to Native_App		
		 Set<String> contextNames4 = driver.getContextHandles();
	        for (String strContextName : contextNames4) {
	            if (strContextName.contains("NATIVE_APP")) {
	                driver.context("NATIVE_APP");
	                break;
	            }
	        }		
			
		try {
		 driver.swipe(82, 1600, 82, 0, 1000);
		}catch (Exception e) {
			 driver.swipe(0, 1500, 0, 0, 1000);
		}
			
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@text='Cancel Order']|//android.widget.Button[@text='CANCEL ORDER']")).click();
		btnclick(m.getCancelorder());


		Thread.sleep(5000);
// 
		try {
		driver.swipe(82, 939, 82, 6, 1000);
		}catch (Exception e) {
		driver.swipe(0, 500, 0, 6, 1000);
		}
		
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@text='YES']|//android.widget.Button[@text='YES']")).click();
		try{btnclick(m.getYesbutton());}
		catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@text='Delay in delivery ' and @top='true']|//*[@text='Delay in delivery']")).click();
		
		
//		
		
		
//Switch to Chrome browser
        Set<String> contextNames5 = driver.getContextHandles();
        for (String strContextName : contextNames5) {
            if (strContextName.contains("CHROMIUM")) {
                driver.context("CHROMIUM");
                break;
            }
            	
         //   btnclick(m.getCancel_reason());
			Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
		//logger.log(Status.PASS, "Successfully Order was Cancelled");
		System.out.println("Successfully Order was Cancelled");
		Thread.sleep(2000);
		driver.navigate().to("https://www.netmeds.com/customer/orderhistory");
		
		
			

			
		//Cancel Order			

		//Let's chat handle//
					letschat();
					
					/*	Thread.sleep(5000);
		
					btnclick(m.getViewdetails());
					Thread.sleep(5000);
					
					//Switch to Native_App		
					 Set<String> contextNames51 = driver.getContextHandles();
				        for (String strContextName5 : contextNames51) {
				            if (strContextName.contains("NATIVE_APP")) {
				                driver.context("NATIVE_APP");
				                break;
				            }
				        }		
						
				    try    {
					 driver.swipe(82, 1600, 82, 0, 1000);
				    }catch (Exception e) {
				    	 driver.swipe(0, 1600, 0, 0, 1000);
					}
					Thread.sleep(3000);
					btnclick(m.getCancelorder());
					Thread.sleep(5000);
					 try    {
						 driver.swipe(82, 1600, 82, 0, 1000);
					    }catch (Exception e) {
					    	 driver.swipe(0, 1600, 0, 0, 1000);
						}
					Thread.sleep(5000);
					try{btnclick(m.getYesbutton());}
					catch (Exception e) {
						// TODO: handle exception
					}
					
					letschat();
					Thread.sleep(5000);
					btnclick(m.getCancel_reason());
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
		
			       
					logger.log(Status.PASS, "Successfully Order was Cancelled");
					System.out.println("Successfully Order was Cancelled");
					Thread.sleep(2000);
					driver.navigate().to("https://www.netmeds.com/customer/orderhistory");



        }*/
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
