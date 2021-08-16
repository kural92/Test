package com.Nm.Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Nm.Base.MobileBaseClass;

import io.appium.java_client.MobileElement;

public class AndriodPom extends MobileBaseClass{
	public AndriodPom() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	//********************************************M3 FLow
		@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.NetmedsMarketplace.Netmeds:id/lets_start']")
		private WebElement Letsstarted;
		public WebElement getLetsstarted() {
			return Letsstarted;
		}

		@FindBy(xpath="//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/name']")
		private WebElement mobilenumber;
		public WebElement getMobilenumber() {
			return mobilenumber;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.NetmedsMarketplace.Netmeds:id/btn_use_password']")
		private WebElement usepwd;
		public WebElement getUsepwd() {
			return usepwd;
		}
		
		@FindBy(xpath ="//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/edt_password']")
		private WebElement password;
		public WebElement getPassword() {
			return password;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/txtLogin']")
		private WebElement Login;
		public WebElement getLogin() {
			return Login;
		}
		
		@FindBy(xpath ="//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/subscription_image']")
		private WebElement Subscription;
		public WebElement getSubscription() {
			return Subscription;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_createSubscription']")
		private WebElement createnew_subscription;
		public WebElement getCreatenew_subscription() {
			return createnew_subscription;
		}
		
		//@FindBy(xpath = "//android.widget.EditText[@resourceid='com.NetmedsMarketplace.Netmeds:id/search_bar']")
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/search_bar")
		private WebElement M3productsearch;
		public WebElement getM3productsearch() {
			return M3productsearch;
		}
}
