package com.Nm.Msite_stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Nm.Base.MobileBaseClass;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Msite_M2Flow extends MobileBaseClass {
	
	//static WebDriver driver;
	
	
		  
	@BeforeClass
	public void launchbrowser() throws IOException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//capabilities.setCapability(MobileCapabilityType.UDID, "RZ8R20GLXTA"); //RZ8R20GLXTA //GBT4C19326001968

		capabilities.setCapability(MobileCapabilityType.UDID, "NBBY79GM5LTCJBJR");  //fc95d519 //RZ8R20GLXTA

		capabilities.setCapability("platformName", "Android");
	//	capabilities.setCapability("deviceName", "vivo 1819");
	//	capabilities.setCapability("platformVersion","10.0.0" );
		//for m-site
		capabilities.setCapability("chromedriverExecutable", ".//input//chromedriver.exe");
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
	  
	  
	  @Test(enabled = true)
	  public void laucnh() throws Throwable {
		  
		  driver.get("https://m.netmeds.com/");
		 // driver.manage().window().maximize();
		  
		  Thread.sleep(10000);
		 // driver.findElement(By.xpath("//android.view.View[@text()='INTRODUCING NETMEDS LITE']/preceding-sibling::android.view.View[@index='0']")).click();
		  try {
		  driver.findElement(By.xpath("//android.view.View[@text='✕']")).click();
		  }catch (Exception e) {
			// TODO: handle exception
		}
		  
		  Thread.sleep(10000);

	
		  driver.findElement(By.xpath("//android.view.View[@text='Order Now']")).click();
		  try {
			  Thread.sleep(10000);
				MobileElement netty = (MobileElement) driver.findElement(By.xpath("//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
				netty.click();
				} catch (Exception e) {
					// TODO: handle exception
				}
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//android.widget.Button[@text='UPLOAD PRESCRIPTION']")).click();
		  
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//android.widget.Button[@text='Choose Files']")).click();
		  
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.android.chrome:id/bitmap_view'])[3]")).click();
		  
		  
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//android.widget.Button[@text='Done']")).click();
		  
		  Thread.sleep(15000);
		  driver.findElement(By.xpath("//android.widget.RadioButton[@text='Search and Add medicines']")).click();
		  
		  
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
		  
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/"
		 		+ "android.widget.LinearLayout/"
		 		+ "android.widget.FrameLayout/"
		 		+ "android.widget.FrameLayout/"
		 		+ "android.widget.FrameLayout/"
		 		+ "android.view.ViewGroup/"
		 		+ "android.widget.FrameLayout[1]/"
		 		+ "android.widget.FrameLayout[2]/"
		 		+ "android.webkit.WebView/"
		 		+ "android.view.View/"
		 		+ "android.view.View[2]/"
		 		+ "android.view.View[1]/"
		 		+ "android.widget.EditText")).sendKeys("Telma");
		 
		 Thread.sleep(5000);
		  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/"
		  		+ "android.widget.LinearLayout/android.widget.FrameLayout/"
		  		+ "android.widget.FrameLayout/android.widget.FrameLayout/"
		  		+ "android.view.ViewGroup/android.widget.FrameLayout[1]/"
		  		+ "android.widget.FrameLayout[2]/android.webkit.WebView/"
		  		+ "android.view.View/android.view.View[2]/android.view.View[2]/"
		  		+ "android.view.View[5]/android.view.View[4]/android.widget.Button")).click();
		  
		  
		 Thread.sleep(5000);
		  driver.findElement(By.xpath("//android.widget.Button[@text='ADD TO CART']")).click();
		  
		 
		 Thread.sleep(5000);
		  driver.findElement(By.xpath("//android.widget.Button[@text='PROCEED']")).click();
		  
		 
/*		 
		 Thread.sleep(10000);
		 MobileElement CONFIRM =  (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text='CONFIRM ORDER']"));
	//	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	//	 executor.executeScript("arguments[0].click();", CONFIRM);
		 TouchAction action = new TouchAction((MobileDriver) driver);
		 action.tap(CONFIRM);
		  CONFIRM.click();
	*/
		  
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
	  
	  @Test(enabled = false)
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
			  driver.findElement(By.xpath("//android.view.View[@content-desc='Order Now']")).click();
			  
			  Thread.sleep(10000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='UPLOAD PRESCRIPTION']")).click();
			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//android.view.View[@text='Past Rx']")).click();
			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("(//android.view.View[@content-desc=\"r0x\"])[1]")).click();
			  
			  
			  Thread.sleep(5000);
			  driver.findElement(By.id("com.android.chrome:id/done")).click();
			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//android.widget.RadioButton[@text='Search and Add medicines']")).click();
			  
			  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']")).click();
			  
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/"
			 		+ "android.widget.LinearLayout/"
			 		+ "android.widget.FrameLayout/"
			 		+ "android.widget.FrameLayout/"
			 		+ "android.widget.FrameLayout/"
			 		+ "android.view.ViewGroup/"
			 		+ "android.widget.FrameLayout[1]/"
			 		+ "android.widget.FrameLayout[2]/"
			 		+ "android.webkit.WebView/"
			 		+ "android.view.View/"
			 		+ "android.view.View[2]/"
			 		+ "android.view.View[1]/"
			 		+ "android.widget.EditText")).sendKeys("Telma");
			 
			 Thread.sleep(5000);
			  driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/"
			  		+ "android.widget.LinearLayout/android.widget.FrameLayout/"
			  		+ "android.widget.FrameLayout/android.widget.FrameLayout/"
			  		+ "android.view.ViewGroup/android.widget.FrameLayout[1]/"
			  		+ "android.widget.FrameLayout[2]/android.webkit.WebView/"
			  		+ "android.view.View/android.view.View[2]/android.view.View[2]/"
			  		+ "android.view.View[5]/android.view.View[4]/android.widget.Button")).click();
			  
			  
			 Thread.sleep(5000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='ADD TO CART']")).click();
			  
			 
			 Thread.sleep(5000);
			  driver.findElement(By.xpath("//android.widget.Button[@text='PROCEED']")).click();
			  
			 
			 
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
	  
	  

}
