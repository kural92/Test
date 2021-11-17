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
	
	@FindBy(xpath = "//*[@text=' CREATE NEW SUBSCRIPTION ']|//android.widget.Button[@text='CREATE NEW SUBSCRIPTION']")
	private WebElement NewSubscription;
	public WebElement getNewSubscription() {
		return NewSubscription;
	}
	
	
	@FindBy(xpath = "//*[@class='ais-SearchBox-input']|//android.view.View[@resource-id='app']/android.view.View[2]/android.view.View/android.widget.EditText")
	private WebElement M3productsearch;
	public WebElement getM3productsearch() {
		return M3productsearch;
	}
	
	
	@FindBy(xpath = "//*[@class='action addcart']|//android.widget.Button[@text='ADD TO CART']")
	private WebElement Addtocart;
	public WebElement getAddtocart() {
		return Addtocart;
	}
		
	
	
	@FindBy(xpath = "//*[@class='btn-checkout btn btn_to_checkout']|//android.widget.Button[@text='PROCEED']")
	private WebElement Proceedtocheckout;
	public WebElement getProceedtocheckout() {
		return Proceedtocheckout;
	
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
		
		@FindBy(xpath = "(//*[@class='editbtn btn'])[1]|//android.widget.Button[@text='Modify']|(//*[@text='Modify'])[1]")
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
		
		@FindBy(xpath = "//*[@text='+ ADD NEW ADDRESS']|//android.widget.TextView[@text='+ ADD NEW ADDRESS']|//*[@class='add-address ng-star-inserted']")
		private WebElement addaddress;
		public WebElement getAddaddress() {
			return addaddress;
	
		}
		
		
		@FindBy(xpath = "(//*[@name='customeraddress'])[2]")
		private WebElement selectaddress;
		public WebElement getSelectaddress() {
			return selectaddress;
	
		}
		
		
//*********************************************Your Account
		
		
//delivery address
		
		@FindBy(xpath = "//*[@text='Delivery Addresses ']")
		private WebElement Deliveryaddress;
		public WebElement getDeliveryaddress() {
			return Deliveryaddress;
	
		}
		
		
//My wallet		
		@FindBy(xpath = "//*[@href='/customer/nmswallet']")
		private WebElement Mywallet;
		public WebElement getMywallet() {
			return Mywallet;
}	

		@FindBy(xpath ="//*[@class='editinfo personalinfor d-block d-sm-none ng-star-inserted']")
		private WebElement Editprofile;
		public WebElement getEditprofile() {
			return Editprofile;
		
		}
			
		@FindBy(xpath ="//*[@text='My Prescription ']")
		private WebElement Myprescription_page;
		public WebElement getMyprescription_page() {
			return Myprescription_page;
		
}
//****************************************Category
		
		@FindBy(css = "DIV.arrow_link")////*[@class='arrow_link']|
		private List<WebElement> Category_list;

		public List<WebElement> getCategory_list() {
			return Category_list;
		}

		@FindBy(xpath="//*[@css='DIV.catitem']")
		private List<WebElement> SubCategory_list;

		public List<WebElement> getSubCategory_list() {
			return SubCategory_list;
		}

		@FindBy(xpath="//*[@class='filter-options-title']")////*[@class='filter-options-item']
		private List<WebElement> Filterby;

		public List<WebElement> getFilterby() {
			return Filterby;


		}
		
}


		
	




