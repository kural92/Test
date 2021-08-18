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
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/proceedToCheckoutButton")
		private WebElement Proceedtocheckout;
		public WebElement getProceedtocheckout() {
			return Proceedtocheckout;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/cart_proceed_btn")
		private WebElement proceed_btn;
		public WebElement getProceed_btn() {
			return proceed_btn;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/first_checkbox")
		private WebElement delivery_30days;
		public WebElement getDelivery_30days() {
			return delivery_30days;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/second_checkbox")
		private WebElement delivery_45days;
		public WebElement getDelivery_45days() {
			return delivery_45days;
		}
		
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/third_checkbox")
		private WebElement delivery_60days;
		public WebElement getDelivery_60days() {
			return delivery_60days;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_button")
		private WebElement Proceedto_placeorder;
		public WebElement getProceedto_placeorder() {
			return Proceedto_placeorder;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/proceed_btn")
		private WebElement placeorder;
		public WebElement getPlaceorder() {
			return placeorder;
		}
		
		@FindBy(xpath ="//android.widget.Button[@index ='1']")
		private WebElement myorders;
		public WebElement getMyorders() {
			return myorders;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/btn_view_order")
		private WebElement viewdetails;
		public WebElement getViewdetails() {
			return viewdetails;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/btn_cancel_order")
		private WebElement cancelorder;
		public WebElement getCancelorder() {
			return cancelorder;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/btn_proceed")
		private WebElement yesbutton;
		public WebElement getYesbutton() {
			return yesbutton;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cb_drug_selected")
		private WebElement cancel_reason;
		public WebElement getCancel_reason() {
			return cancel_reason;
		}
		
		@FindBy(xpath ="//android.widget.Button[@index='1']")
		private WebElement submit_cancel;
		public WebElement getSubmit_cancel() {
			return submit_cancel;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/dontHavePrescriptionCheckBox")
		private WebElement doctor_consultation;
		public WebElement getDoctor_consultation() {
			return doctor_consultation;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_change_address")
		private WebElement Address_change;
		public WebElement getAddress_change() {
			return Address_change;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/uploadPrescription")
		private WebElement uploadPrescription;
		public WebElement getUploadPrescription() {
			return uploadPrescription;
		}
		
		@FindBy(id = "(//android.widget.ImageView[@content-desc=\"Past Rx\"])[1]")
		private WebElement pastrx;
		public WebElement getPastrx() {
			return pastrx;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/doneButton")
		private WebElement done;
		public WebElement getDone() {
			return done;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/setAddressButton")
		private WebElement Schedule_delivery;
		public WebElement getSchedule_delivery() {
			return Schedule_delivery;
		}
		
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/pinCode")
		private WebElement pincode;
		public WebElement getPincode() {
			return pincode;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/firstName")
		private WebElement firstname;
		public WebElement getFirstname() {
			return firstname;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/lastName")
		private WebElement lastname;
		public WebElement getLastname() {
			return lastname;
		}
		
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/houseNumber")
		private WebElement address;
		public WebElement getAddress() {
			return address;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/landMark")
		private WebElement landmark;
		public WebElement getLandmark() {
			return landmark;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/saveAddressButton")
		private WebElement save_address;
		public WebElement getSave_address() {
			return save_address;
		}
		
		
	
		
}


