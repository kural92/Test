package com.Nm.Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Nm.Base.MsiteBaseClass;

import io.appium.java_client.MobileElement;

public class MsitePOM extends MsiteBaseClass{
	public MsitePOM() {
		PageFactory.initElements(driver, this);
		
	}
	
<<<<<<< HEAD
	@FindBy(xpath = "//span[@class='app_close']|//*[@class='app_close']")
	private WebElement Msite_HomeScreen_POP_UP;
    public WebElement getMsite_HomeScreen_POP_UP() {
		return Msite_HomeScreen_POP_UP;
	}
    
    @FindBy(xpath = "//*[@css=concat('A.view_btn[href=', \\\"'\\\", '/upload_prescription', \\\"'\\\", ']')]|//*[@class='app_close']//android.view.View[@content-desc=\"Order Now\"]")
    private WebElement Msite_OrderNow;
	public WebElement getMsite_OrderNow() {
		return Msite_OrderNow;
=======
	//******************	M2
		@FindBy(xpath = "//span[@class='app_close']")
		private WebElement Msite_HomeScreen_POP_UP;
	    public WebElement getMsite_HomeScreen_POP_UP() {
			return Msite_HomeScreen_POP_UP;
		}
	    
	    @FindBy(xpath = "//android.view.View[@content-desc=\"Order Now\"]")
	    private WebElement Msite_OrderNow;
		public WebElement getMsite_OrderNow() {
			return Msite_OrderNow;
			
			
		}
		
		@FindBy(xpath = "//android.widget.Button[@text='UPLOAD PRESCRIPTION']")
	    private WebElement Msite_Upload_Prescription;
		public WebElement getMsite_Upload_Prescription() {
			return Msite_Upload_Prescription;
		}	
		
		
		@FindBy(xpath = "//android.widget.Button[@text='Choose Files']")
	    private WebElement Msite_Upload_Gallery;
		public WebElement getMsite_Upload_Gallery() {
			return Msite_Upload_Gallery;
		}
		
		
		@FindBy(xpath = "//android.widget.RadioButto[@text='Search and Add medicines']")
	    private WebElement Msite_M2_searchMedicine;
		public WebElement getMsite_M2_searchMedicine() {
			return Msite_M2_searchMedicine;
		}
		
		
		@FindBy(xpath = "//android.widget.RadioButto[@text='Get call from Netmeds']")
	    private WebElement Msite_M2_Getcall;
		public WebElement getMsite_M2_Getcall() {
			return Msite_M2_Getcall;
		}
		
		@FindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
		private WebElement Msite_M2_SearcCall_ContinueButton;
		public WebElement getMsite_M2_SearcCall_ContinueButton() {
			return Msite_M2_SearcCall_ContinueButton;
		}
		
	//*******************************	My rewards
		
		//my Account 
>>>>>>> ca32e1987dfa277f2a3a90ce635ba4872013cade
		
		@FindBy(xpath = "//*[@text='Account']")
		private WebElement myaccount;
		public WebElement getmyaccount() {
			return myaccount;
		}
		
		
		@FindBy(xpath ="//*[@text='My Rewards']")
		private WebElement Myrewards;
		public WebElement getMyrewards() {
			return Myrewards;
		
		}
		
		
//*****************************M3 Flow
		
	@FindBy (xpath = "//android.view.View[@content-desc='Subscription']|//*[@text='Subscription']")	
	private WebElement Mysubscriptionpage;
	public WebElement getMysubscriptionpage() {
		return Mysubscriptionpage;
	}
	
<<<<<<< HEAD
	@FindBy(xpath = "//*[@text='Upload Prescription']|//android.widget.Button[@text='UPLOAD PRESCRIPTION']")
    private WebElement Msite_Upload_Prescription;
	public WebElement getMsite_Upload_Prescription() {
		return Msite_Upload_Prescription;
	}	
=======
	@FindBy(xpath = "//*[@text=' CREATE NEW SUBSCRIPTION ']|//android.widget.Button[@text='CREATE NEW SUBSCRIPTION']")
	private WebElement NewSubscription;
	public WebElement getNewSubscription() {
		return NewSubscription;
	}
>>>>>>> ca32e1987dfa277f2a3a90ce635ba4872013cade
	
	
	@FindBy(xpath = "//*[@class='ais-SearchBox-input']|//android.view.View[@resource-id='app']/android.view.View[2]/android.view.View/android.widget.EditText")
	private WebElement M3productsearch;
	public WebElement getM3productsearch() {
		return M3productsearch;
	}
	
	
<<<<<<< HEAD
	@FindBy(xpath = "(//*[@css='INPUT.m2checkbox.ng-untouched.ng-pristine.ng-valid'])[1]|//android.widget.RadioButto[@text='Search and Add medicines']")
    private WebElement Msite_M2_searchMedicine;
	public WebElement getMsite_M2_searchMedicine() {
		return Msite_M2_searchMedicine;
=======
	@FindBy(xpath = "//*[@class='action addcart']|//android.widget.Button[@text='ADD TO CART']")
	private WebElement Addtocart;
	public WebElement getAddtocart() {
		return Addtocart;
>>>>>>> ca32e1987dfa277f2a3a90ce635ba4872013cade
	}
		
	
	
	@FindBy(xpath = "//*[@class='btn-checkout btn btn_to_checkout']|//android.widget.Button[@text='PROCEED']")
	private WebElement Proceedtocheckout;
	public WebElement getProceedtocheckout() {
		return Proceedtocheckout;
	
<<<<<<< HEAD
	@FindBy(xpath = "//*[@text='Continue']|//android.widget.Button[@text='CONTINUE']")
	private WebElement Msite_M2_SearcCall_ContinueButton;
	public WebElement getMsite_M2_SearcCall_ContinueButton() {
		return Msite_M2_SearcCall_ContinueButton;
=======
>>>>>>> ca32e1987dfa277f2a3a90ce635ba4872013cade
	}
		
		
		
		@FindBy(xpath = "//*[@text='Next']|//android.widget.Button[@text='NEXT']")
		private WebElement Nextbutton;
		public WebElement getNextbutton() {
			return Nextbutton;
	
		}	
	
	
		@FindBy(xpath = "//*[@text='Subscribe']|//android.widget.Button[@text='SUBSCRIBE']")
		private WebElement Subscribe;
		public WebElement getSubscribe() {
			return Subscribe;
	
		}	
		@FindBy(xpath = "//*[@text='Delete']|//android.widget.Button[@text='DELETE']")
		private WebElement Deleteaddress;
		public WebElement getDeleteaddress() {
			return Deleteaddress;
	
		}
		
		@FindBy(xpath = "(//*[@class='editbtn btn'])[1]|//android.widget.Button[@text='Modify']")
		private WebElement Modifyaddressbtn;
		public WebElement getModifyaddressbtn() {
			return Modifyaddressbtn;
	
		}
		
		@FindBy(xpath = "//*[@id='pin']")
		private WebElement pincode;
		public WebElement getPincode() {
			return pincode;
	
		}
		@FindBy(xpath = "//*[@id='firstname']")
		private WebElement firstname;
		public WebElement getFirstname() {
			return firstname;
	
		}
		@FindBy(xpath = "//*[@id='lastname']")
		private WebElement lastname;
		public WebElement getLastname() {
			return lastname;
	
		}
		
		@FindBy(xpath = "//*[@id='street']")
		private WebElement street;
		public WebElement getStreet() {
			return street;
	
		}
		
		@FindBy(xpath = "//*[@id='landmark']")
		private WebElement landmark;
		public WebElement getLandmark() {
			return landmark;
	
		}
		
		
		@FindBy(xpath = "//*[@text='Save Address']|//android.widget.Button[@text='SAVE ADDRESS']")
		private WebElement saveaddress;
		public WebElement getSaveaddress() {
			return saveaddress;
	
		}
		
		@FindBy(xpath = "//*[@text='+ ADD NEW ADDRESS']|//android.widget.TextView[@text='+ ADD NEW ADDRESS']")
		private WebElement addaddress;
		public WebElement getAddaddress() {
			return addaddress;
	
		}
		
		
		@FindBy(xpath = "(//*[@name='customeraddress'])[2]")
		private WebElement selectaddress;
		public WebElement getSelectaddress() {
			return selectaddress;
	
		}
}	





		
	




