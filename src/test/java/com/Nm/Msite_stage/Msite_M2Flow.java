package com.Nm.Msite_stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Nm.Pom.MsitePOM;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Msite_M2Flow {
	
	 private String reportDirectory = "reports";
	    private String reportFormat = "xml";
	    private String testName = "Untitled";
	    protected AndroidDriver<AndroidElement> driver = null;

	    DesiredCapabilities dc = new DesiredCapabilities();
	    
	    @BeforeMethod
	    public void setUp() throws MalformedURLException {
	        dc.setCapability("reportDirectory", reportDirectory);
	        dc.setCapability("reportFormat", reportFormat);
	        dc.setCapability("testName", testName);
	        dc.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA");
	        dc.setBrowserName(MobileBrowserType.CHROMIUM);
	        driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
	        driver.setLogLevel(Level.INFO);
	    }

	  
	  
	  @Test(enabled = true)
	  public void laucnh() throws Throwable {
		  
		  driver.get("https://m.netmeds.com/");
		 // driver.manage().window().maximize();
		  MsitePOM m = new MsitePOM();
		  Thread.sleep(10000);
		  try {
		  //driver.findElement(By.xpath("//span[@class='app_close']")).click();
			  m.getMsite_HomeScreen_POP_UP().click();
		  }catch (Exception e) {
			// TODO: handle exception
		}
		  
		  Thread.sleep(10000);
		 // driver.findElement(By.xpath("//android.view.View[@text=\"Order Now\"]|//*[@css=concat('A.view_btn[href=', \"'\", '/upload_prescription', \"'\", ']')]")).click();
		  m.getMsite_OrderNow().click();
		  Thread.sleep(10000);
		//  driver.findElement(By.xpath("//android.widget.Button[@text='UPLOAD PRESCRIPTION']|//*[@text='Upload Prescription']")).click();
		  m.getMsite_Upload_Prescription().click();
		  Thread.sleep(5000);
		//  driver.findElement(By.xpath("//android.widget.Button[@text='Choose Files']|//*[@css='INPUT.ng-untouched.ng-pristine.ng-valid']")).click();
		  m.getMsite_Upload_Gallery().click();
		  Thread.sleep(5000);
		//  driver.findElement(By.xpath("(//*[@knownSuperClass='android.widget.ImageView'])[5]")).click();//"(//*[@id='bitmap_view'])[3]|(//android.widget.ImageView[@resource-id='com.android.chrome:id/bitmap_view'])[3]")).click();
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
		  
			/////		
		  
		 
		  Thread.sleep(5000);
	//	  driver.findElement(By.xpath("(//*[@css='INPUT.m2checkbox.ng-untouched.ng-pristine.ng-valid'])[1]|//android.widget.RadioButton[@text='Search and Add medicines']")).click();
		m.getMsite_M2_searchMedicine().click();  
		  
		  Thread.sleep(5000);
		//  driver.findElement(By.xpath("//*[@text='Continue']|//android.widget.Button[@text='CONTINUE']")).click();
		m.getMsite_M2_SearcCall_ContinueButton().click();  
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
		//  driver.findElement(By.xpath("//*[@text='Confirm Order']|//*[@text='Confirm Order' and @top='true']"));
/*		 
		 Thread.sleep(10000);
		 MobileElement CONFIRM =  (MobileElement) 
	//	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	//	 executor.executeScript("arguments[0].click();", CONFIRM);
		 TouchAction action = new TouchAction((MobileDriver) driver);
		 action.tap(CONFIRM);
		  CONFIRM.click();
	
		  
		  Thread.sleep(4000);
			
		  Dimension location = driver.manage().window().getSize();
		  String ss = location.toString();
		  System.out.println(location);
		  String replace = ss.replace("(", "").replace(")", "").replace(" ", "");
		  String[] split = replace.split(",");

		  System.out.println(split[0]);
		  System.out.println(split[1]);
		  int i=Integer.parseInt(split[0]);
		  int i1=Integer.parseInt(split[1]);
		  Thread.sleep(3000);
		  TouchAction touchAction = new TouchAction((MobileDriver) driver);

		  touchAction.tap(i-100,i1-100).perform();
		 
		 
		 Thread.sleep(5000);
		 // driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		  
		 
		 
		 Thread.sleep(5000);
		 // driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
		  
	*/	 
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//*[@text='Track Order']|//android.widget.Button[@text='TRACK ORDER']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@text=' View Details ']|//android.widget.Button[@text='VIEW DETAILS']")).click();
		
		 //MobileElement co = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']"));co.click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@text='Cancel Order']|//android.widget.Button[@text='CANCEL ORDER']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@css='INPUT.ng-untouched.ng-pristine.ng-valid']|//android.widget.RadioButton[@text='Delay in delivery']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@text='SUBMIT & CANCEL']|//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
		 //touchAction.tap(100,i1).perform();
		 
	}
	  
	  
	  @Test(enabled = false )
	  public void m2_miste_getCall() throws Throwable {
		
		  driver.get("https://m.netmeds.com/");
			 // driver.manage().window().maximize();
			  
			  Thread.sleep(10000);
			  try {
			  driver.findElement(By.xpath("//span[@class='app_close']")).click();
			  }catch (Exception e) {
				// TODO: handle exception
			}
			  
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//android.view.View[@content-desc='Order Now']")).click();
			  
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='UPLOAD PRESCRIPTION']")).click();
			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='Choose Files']")).click();
			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.android.chrome:id/bitmap_view'])[3]")).click();
			  
			  
			  Thread.sleep(5000);
			  driver.findElement(By.id("com.android.chrome:id/done")).click();
			  
			  Thread.sleep(5000);
			//  driver.findElement(By.xpath("//android.widget.RadioButton[@text='Search and Add medicines']")).click();
			  
			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
			
			 Thread.sleep(10000);
			 MobileElement CONFIRM =  (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CONFIRM ORDER']"));
		//	 JavascriptExecutor executor = (JavascriptExecutor)driver;
		//	 executor.executeScript("arguments[0].click();", CONFIRM);
			 TouchAction action = new TouchAction((MobileDriver) driver);
			 action.tap(CONFIRM);
			  CONFIRM.click();
			  
			 
			 
			 Thread.sleep(5000);
			 // driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
			  
			 
			 
			 Thread.sleep(5000);
			 // driver.findElement(By.xpath("//android.widget.Button[@text='Submit']")).click();
			  
			 
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.Button[@text='TRACK ORDER']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.Button[@text='VIEW DETAILS']")).click();
			
			 //MobileElement co = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']"));co.click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.RadioButton[@text='Delay in delivery']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
			 //touchAction.tap(100,i1).perform();
			 
		  

	}
	  
	  @Test(enabled = true)
	  public void m2_msite_PastRXSearch() throws Throwable {
		  
		  driver.get("https://m.netmeds.com/");
			 // driver.manage().window().maximize();
			  
			  Thread.sleep(10000);
			  try {
			  driver.findElement(By.xpath("//span[@class='app_close']")).click();
			  }catch (Exception e) {
				// TODO: handle exception
			}
			  
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//*[@css=concat('A.view_btn[href=', \"'\", '/upload_prescription', \"'\", ']')]|//android.view.View[@text=\\\"Order Now\\\"]")).click();
			  
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='UPLOAD PRESCRIPTION']|//*[@text='Upload Prescription']")).click();
			  
			 
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//*[@css='SPAN.pastrx-icon']|//android.view.View[@text='Past Rx']")).click();
			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//*[@name='m2pastVerifiedRx']|(//android.view.View[@content-desc=\"r0x\"])[1]")).click();
			  
			  
			  Thread.sleep(5000);
			 // driver.findElement(By.id("com.android.chrome:id/done")).click();
			  driver.findElement(By.xpath("//*[@css='BUTTON.close']")).click();
			  
			///////////

			  Thread.sleep(5000);
			  driver.findElement(By.xpath("(//*[@css='INPUT.m2checkbox.ng-untouched.ng-pristine.ng-valid'])[1]|//android.widget.RadioButton[@text='Search and Add medicines']")).click();
			  
			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//*[@text='Continue']|//android.widget.Button[@text='CONTINUE']")).click();
			  
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
			  driver.findElement(By.xpath("//*[@text='Confirm Order']|//*[@text='Confirm Order' and @top='true']"));
			  

			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.Button[@text='TRACK ORDER']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.Button[@text='VIEW DETAILS']")).click();
			
			 //MobileElement co = (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']"));co.click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.Button[@text='CANCEL ORDER']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.RadioButton[@text='Delay in delivery']")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//android.widget.Button[@text='SUBMIT & CANCEL']")).click();
			 //touchAction.tap(100,i1).perform();
		
	}
	  
	  

}
