package com.Nm.Msite_stage;



import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Consultation extends MsiteBaseClass {

	
	
	
	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
		@BeforeClass
		
		//@BeforeClass
		public void launchbrowser2()   {
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
			
			
			try {
				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage());
			}
					
		}


		public void launchbrowser() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setCapability(MobileCapabilityType.UDID, "07c55fe10406");//"c195de14"
			capabilities.setCapability("platformName", "Android");
			//capabilities.setCapability("deviceName", "vivo 1819");
			capabilities.setCapability(MobileCapabilityType.VERSION,"11 RP1A.200720.011" );
			//for m-site
			capabilities.setCapability("chromedriverExecutable", "D:\\Automation\\Driver\\chromedriver.exe");
			//for install Apk file
			//capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Admin\\Downloads\\wyth_SIT_s9.10.apk");
			// already installed app
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
			//capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.netmedsmarketplace.netmeds.AppUriSchemeHandler");
			capabilities.setCapability("noReset", true);
			
					
			//capabilities.setCapability("autoDismissAlerts", true);  
			
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
	

	
//*************************************************	
	
	@Test(priority = 1,enabled=false)
	public void Consult_Myself() throws Throwable {
		
		
		logger =  report.createTest("Consult_Myself_On Demand consulatation");
		logger.log(Status.PASS, "*************Consult_Myself_On Demand consulatation********************" );
		
		MsitePOM m = new MsitePOM();
		
		//driver.manage().window().maximize();
				driver.get("https://m.netmeds.com/");
			
	
				Thread.sleep(6000);
				
				popupclose() ;
				

		Thread.sleep(10000);
		
		btnclick(m.getGotocart()); 
		
		Thread.sleep(3000);
		letschat();
		
		
		 Set<String> contextNames = driver.getContextHandles();
	        for (String strContextName : contextNames) {
	            if (strContextName.contains("NATIVE_APP")) {
	                driver.context("NATIVE_APP");
	                break;
	            }
	        }
			for (int i = 0; i < 16; i++) {
				Thread.sleep(3000);
				if (!(driver.findElements(By.xpath("//*[@text='REMOVE']")).size() == 0)) {
					

					try {

						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@text='REMOVE']")).click();
						
						Thread.sleep(3000);
						logger.log(Status.PASS, "Items are removed successfully");
						System.out.println("Items are removed from the cart");
					} catch (Exception e) {
						System.out.println("No items in the cart ");
					}

				} else {
					break;

				}

			}
			 //Switch to Chrome browser
	        Set<String> contextNames1 = driver.getContextHandles();
	        for (String strContextName : contextNames1) {
	            if (strContextName.contains("CHROMIUM")) {
	                driver.context("CHROMIUM");
	                break;
	            }
	        }			
			driver.navigate().back();
		//btnclick(m.getFooter_HomePage());
	
		Thread.sleep(5000);
		
		Set<String> contextNames2 = driver.getContextHandles();
        for (String strContextName : contextNames2) {
            if (strContextName.contains("NATIVE_APP")) {
                driver.context("NATIVE_APP");
                break;
            }
        }
		  try {

			  driver.findElement(By.xpath("//*[@class='app_close']")).click();
				//  m.getMsite_HomeScreen_POP_UP().click();

			//driver.findElement(By.xpath("//android.view.View[@text='✕']")).click();

			  }catch (Exception e) {
				// TODO: handle exception
			}	
		  
		//Switch to Chrome browser
		    Set<String> contextNames3 = driver.getContextHandles();
		    for (String strContextName : contextNames3) {
		        if (strContextName.contains("CHROMIUM")) {
		            driver.context("CHROMIUM");
		            break;
		        }
		    }	  	  
		
		for (int i = 0; i < 10; i++) {
			
			Thread.sleep(3000);
			driver.swipe(0, 800, 0, 0, 1000);
			
			if (m.getConsultation_Btn_List().size()!=0) {
				
				Thread.sleep(3000);
				btnclick(m.getConsultation_Btn());
				break;
			} else {
				
				System.out.println("Swipe Down to click on Consult Now Button");

			}
			
			
			
		}
		
		WebDriverWait wait= new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(m.getStart_Consultation_Btn()));
		
		Thread.sleep(3000);
		btnclick(m.getStart_Consultation_Btn());
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_MySelf()));
		btnclick(m.getConsult_MySelf());
		
		Thread.sleep(3000);
		type(m.getConsult_Symptons_TextBox(), "Ear pain");
		
		driver.hideKeyboard();
		
		
		Thread.sleep(3000);
		btnclick(m.getConsult_Specialist_ViewAll());
		
		
		Thread.sleep(3000);
		btnclick(m.getConsult_ENT());
		
		
		Thread.sleep(3000);
		btnclick(m.getConsult_specilaisation_DoneBtn());

		Thread.sleep(3000);
		btnclick(m.getSTART_CONSULTATION_BTN());
		
		
		wait.until(ExpectedConditions.visibilityOf(m.getConsult_Chat_Text()));
		btnclick(m.getConsult_Chat_Text());
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@class='icon-class ng-star-inserted md hydrated' and @top='true'])[1]|(//*[@class='link' and @top='true'])[1]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_Doctor_select_btn()));
		Thread.sleep(3000);
		btnclick(m.getConsult_Doctor_select_btn());
		
		
		
// Payment Decline
		
//NetBanking	
		
		
	//Axis bank	
	String Url1 = 	(driver.getCurrentUrl());
		
	System.out.println(Url1);
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//*[@name='radio-button-off' and @top='true'])[1]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@text='Pay']")).click();
	Thread.sleep(5000);
	driver.navigate().back();
	Thread.sleep(8000);
	
	String Url2 = 	(driver.getCurrentUrl());
	
	System.out.println(Url2);
	
	

//Bank of india	
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//*[@name='radio-button-off' and @top='true'])[4]")).click();
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@text='Pay']")).click();
	Thread.sleep(5000);
	driver.navigate().back();
	Thread.sleep(5000);
	String Url3 = 	(driver.getCurrentUrl());
	
	System.out.println(Url2);
	
	
	/*	
	
	List<WebElement> Banks = m.getListofbanks();
	
	
	int Banklist = Banks.size();
	System.out.println(Banklist);
		
		
	String Url1 = 	(driver.getCurrentUrl());
	
	System.out.println(Url1);
	
	
	for (int i=0;i<=Banklist;i++) 
	
	{
		Thread.sleep(5000);
		Banks.get(i).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Pay']")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(5000);
		String Url2 = 	(driver.getCurrentUrl());
		
		System.out.println(Url2);
		
		if (Url1 ==Url2) {
			
			System.out.println("Url is same");
		}
		
		
		
		}
		
		*/
		
		
		
		
	}
	
	
//************************************************	
	@Test(priority = 2,enabled = true)
	public void premium_Consultation() throws Throwable {
		
		logger =  report.createTest("premium_Consultation");
		logger.log(Status.PASS, "*************premium_Consultation********************" );
		
		
	MsitePOM m = new MsitePOM();

				driver.get("https://m.netmeds.com/");
		
				
				Thread.sleep(6000);
				
				popupclose() ;
				

		Thread.sleep(10000);
		
		btnclick(m.getGotocart()); 
		
		Thread.sleep(3000);
		letschat();
		
		
		
			for (int i = 0; i < 16; i++) {
				Thread.sleep(3000);
				if (!(driver.findElements(By.xpath("//*[@text='REMOVE']")).size() == 0)) {
					

					try {

						Thread.sleep(3000);
						driver.findElement(By.xpath("//*[@text='REMOVE']")).click();
						
						Thread.sleep(3000);
						logger.log(Status.PASS, "Items are removed successfully");
						System.out.println("Items are removed from the cart");
					} catch (Exception e) {
						System.out.println("No items in the cart ");
					}

				} else {
					break;

				}

			}
						
			driver.navigate().back();
	
		Thread.sleep(5000);
		
		
		  try {

			  driver.findElement(By.xpath("//*[@class='app_close']")).click();


			  }catch (Exception e) {
				// TODO: handle exception
			}	
		  
		  	  
		
		for (int i = 0; i < 10; i++) {
			
			Thread.sleep(3000);
			driver.swipe(0, 800, 0, 0, 1000);
			
			if (m.getConsultation_Btn_List().size()!=0) {
				
				Thread.sleep(3000);
				btnclick(m.getConsultation_Btn());
				break;
			} else {
				
				System.out.println("Swipe Down to click on Consult Now Button");

			}
			
			
			
		}
		
		WebDriverWait wait= new WebDriverWait(driver, 60);
	
		Thread.sleep(5000);
	
		driver.swipe(82, 1870, 82, 900, 1000);

		driver.swipe(0, 1870, 82, 900, 1000);
		
		driver.swipe(0, 1870, 82, 900, 1000);
		
	 Thread.sleep(5000);
	 
	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@text='Consult now']"))));
	 btnclick(driver.findElement(By.xpath("//*[@text='Consult now']")));
	 
	 Thread.sleep(5000);
	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='filter-button showMobileLayout']"))));
	 driver.findElement(By.xpath("//*[@class='filter-button showMobileLayout']")).click();
	 
	 Thread.sleep(3000);
	 
	 List<WebElement> con_filter = driver.findElements(By.xpath("//*[@class='ng-untouched ng-pristine ng-valid md in-item interactive hydrated ion-untouched ion-pristine ion-valid' and @top='true']"));
	 
	 Thread.sleep(3000);
	 for (int i = 0; i < 1; i++) {
		
		 Thread.sleep(3000);
		 con_filter.get(i).click();
		 
	}

	 driver.swipe(0, 1000, 0, 0, 1000);
	 
	 
	 driver.swipe(0, 1000, 0, 0, 1000);
	 
	 
	 driver.swipe(0, 1000, 0, 0, 1000);
	 
	 
	 driver.swipe(0, 1000, 0, 0, 1000);
	 
	 Thread.sleep(6000);

	 
	 driver.findElement(By.xpath("//*[@text='Apply ']|//android.widget.Button[@text='APPLY']")).click();
	 
		
		Set<String> toremovefilter = driver.getContextHandles();
        for (String strtoremovefilter : toremovefilter) {
            if (strtoremovefilter.contains("NATIVE_APP")) {
                driver.context("NATIVE_APP");
                break;
            }
        }
	 Thread.sleep(8000);

	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@text='CONSULT'])[2]"))));
	 driver.findElement(By.xpath("(//*[@text='CONSULT'])[2]")).click();
	 
	 
	 Thread.sleep(5000);
	 try {
		wait.until(ExpectedConditions.elementToBeClickable(m.getConsult_MySelf()));
		btnclick(m.getConsult_MySelf());
	 
	
	
		Thread.sleep(5000);
		type(m.getConsult_Symptons_TextBox(), "Ear pain");
		
		driver.hideKeyboard();
	 }catch (Exception e) {
		// TODO: handle exception
	}
		
		
		
		Thread.sleep(3000);
		driver.swipe(0, 1800, 0, 0, 1000);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@text='START CONSULTATION']")).click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("(//span[@class='slot ng-tns-c8-0 ng-star-inserted'])[3]")).click();
		
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOf(m.getConsult_Chat_Text()));
		btnclick(m.getConsult_Chat_Text());
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='ng-star-inserted ion-color ion-color-secondary md button button-full button-large button-solid ion-activatable ion-focusable hydrated']")).click();
		Thread.sleep(3000);

		
		
		
// Payment Decline
		
//NetBanking	
		
		
	//Axis bank	
	String Url1 = 	(driver.getCurrentUrl());
		
	System.out.println(Url1);
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//*[@name='radio-button-off' and @top='true'])[1]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@text='Pay']")).click();
	Thread.sleep(5000);
	driver.navigate().back();
	Thread.sleep(8000);
	
	String Url2 = 	(driver.getCurrentUrl());
	
	System.out.println(Url2);
	
	

//Bank of india	
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//*[@name='radio-button-off' and @top='true'])[4]")).click();
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@class='ng-star-inserted ion-color ion-color-secondary md button button-full button-large button-solid ion-activatable ion-focusable hydrated']//*[@text='Pay']")).click();
	Thread.sleep(5000);
	driver.navigate().back();
	Thread.sleep(5000);
	String Url3 = 	(driver.getCurrentUrl());
	
	System.out.println(Url2);
	
		
		
		
	
		
		
	}

		
	
	
}
