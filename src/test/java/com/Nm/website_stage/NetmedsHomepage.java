package com.Nm.website_stage;

import java.util.Set;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.Nm.Website_live.RetryAnalyzer;


public class NetmedsHomepage extends BaseClass {
	
	
	
@Test//(retryAnalyzer=RetryAnalyzer.class)
public void homePage() throws Throwable {
	// TODO Auto-generated method stub



	Monepom hp = new Monepom();
	

		//launchbrowser();
		
		/*
		 * System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--disable-notifications"); driver=new
		 * ChromeDriver(options); driver.get("https://s1-meds.netmeds.com");
		 */
		driver.manage().window().maximize();
		
		//Homepage_GuestUser
		thread(3000);
		//Medicine
		moveElement(driver.findElement(By.xpath("//a[text()=' Medicine']")));
		clk(hp.getAllmedi());
		thread(3000);
		pageUrl();
		back();
		thread(3000);
		moveElement(hp.getMedi());
		clk(hp.getBuyagain());
		pageUrl();
		clk(hp.getLogo());
		
		//Wellness
		clk(hp.getWellness());
		pageUrl();
		back();
		
		//LabTest
		clk(hp.getLabtest());
		pageUrl();
		back();
		
		//Beauty
		moveElement(hp.getBeauty());
		clk(hp.getBodycare());
		pageUrl();
		moveElement(hp.getBeauty());
		clk(hp.getFacecare());
		pageUrl();
		moveElement(hp.getBeauty());
		clk(hp.getFragnance());
		pageUrl();
		moveElement(hp.getBeauty());
		clk(hp.getHandfeet());
		pageUrl();
		moveElement(hp.getBeauty());
		clk(hp.getHomecare());
		pageUrl();
		moveElement(hp.getBeauty());
		clk(hp.getEyecare());
		pageUrl();
		moveElement(hp.getBeauty());
		clk(hp.getMenscare());
		pageUrl();
		moveElement(hp.getBeauty());
		clk(hp.getSeniorcare());
		pageUrl();
		
		//HealthCorner
		moveElement(hp.getHealthcorner());
		clk(hp.getHealthlib());
		pageUrl();
		moveElement(hp.getHealthcorner());
		String Parent = driver.getWindowHandle();
		
		clk(hp.getPatients());
		pageUrl();
		
		Set<String> child = driver.getWindowHandles();
		for (String handle : child) {
			if (!(Parent.contains(handle))) {
				
				Thread.sleep(2000);
				driver.switchTo().window(handle);
			}
		}
			Thread.sleep(2000);
		driver.navigate().to("https://s1-meds.netmeds.com")	;	
		
		Thread.sleep(2000);
		//UserLogin
		try {
		clk(hp.getLogin());
		sendkeys(hp.getMobileno(), "7010752043");
		clk(hp.getClick());
	    thread(1000);
	    sendkeys(hp.getPwd(), "Change@92");
	    clk(hp.getSign());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	    //category
	    thread(3000);
	    clk(hp.getCatordermed());
		pageUrl();
		back();
		clk(hp.getCatbeaut());
		pageUrl();
		back();
		clk(hp.getCatwellness());
		pageUrl();
		back();
	    
	    //PaymentPartnerOffer
	    thread(3000);
	    clk(hp.getPaytm());
	    pageTitle();
	    back();
	    try {
	    clk(hp.getMobiqwik());
	    pageTitle();
	    back();
	    }catch (Exception e) {
			// TODO: handle exception
		}
	    try {
	    clk(hp.getSimpl());
	    pageTitle();
	    back();
	    } catch (Exception e) {
			// TODO: handle exception
		}
	    try {
	    clk(hp.getPayviewll());
	    pageTitle();
	    } catch (Exception e) {
			// TODO: handle exception
		}
	    try {
		clk(hp.getChkmed());
	    } catch (Exception e) {
			// TODO: handle exception
		}
	    
	    try {
		clk(hp.getChkdiag());
		
	    } catch (Exception e) {
			// TODO: handle exception
		}
	    
	    try {
		clk(hp.getChckconsult());
		
	    } catch (Exception e) {
			// TODO: handle exception
		}
	    
	    try {
		clk(hp.getChckconsult());
	    } catch (Exception e) {
			// TODO: handle exception
		}
	    
	    try {
		clk(hp.getChkdiag());
		back();
	    } catch (Exception e) {
			// TODO: handle exception
		}
	    try {
		clk(hp.getChkmed());
	    } catch (Exception e) {
			// TODO: handle exception
		}
	    
	    try {
		clk(hp.getDeliver());
		sendkeys(hp.getPincode(), "613201");
	    } catch (Exception e) {
			// TODO: handle exception
		}
		
	   
		
		
		quit();
		
	
	}

}
