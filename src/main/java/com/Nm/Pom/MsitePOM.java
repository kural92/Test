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
	@FindBy(xpath = "//*[@text='Netmeds First Membership' and @nodeName='H2']")
	private WebElement Homepage_netmeds_first_title;
	@FindBy(xpath = "//*[@text='Get special discounts and offers on Netmeds services.' and @nodeName='LI']")
	private WebElement Get_special_discounts;
	@FindBy(xpath = "//*[@text='Get 2.5% NMS Cash on all orders.' and @nodeName='LI']")
	private WebElement NMS_Cash_on_all_orders;
	@FindBy(xpath = "//*[@text='Starting at ₹299' and @nodeName='DIV']")
	private WebElement Starting;
	public WebElement getHomepage_netmeds_first_title() {
		return Homepage_netmeds_first_title;
	}
	public WebElement getGet_special_discounts() {
		return Get_special_discounts;
	}
	public WebElement getNMS_Cash_on_all_orders() {
		return NMS_Cash_on_all_orders;
	}
	public WebElement getStarting() {
		return Starting;
	}
	public WebElement getExplore_Plans() {
		return Explore_Plans;
	}
	@FindBy(xpath = "//*[@text='REMOVE']")
	private WebElement RemoveButton;

	
	public WebElement getRemoveButton() {
		return RemoveButton;
	}

	@FindBy(xpath = "//*[@nodeName='SPAN' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@nodeName='DIV' and ./*[@nodeName='DIV']]]]")
	private WebElement Cart_search;
	public WebElement getCart_search() {
		return Cart_search;
	}

	@FindBy(xpath = "//*[@nodeName='INPUT']")
	private WebElement Searchbarone;
	@FindBy(xpath = "//*[@text='Patanjali Lauh Bhasm Powder 5 gm' and @nodeName='A']")
	private WebElement getSearch_drugname;
	@FindBy(xpath = "((((//*[@id='app']/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View']])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[1]/*[@text and @class='android.view.View'])[3]")
	private WebElement geCart_img_circle_arrow;
	@FindBy(xpath = "//*[@text='Add to Cart' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Rs. 299']]]]")
	private WebElement NetmedsFirstPage_6month;
	public WebElement getNetmedsFirstPage_6month() {
		return NetmedsFirstPage_6month;
	}
	public WebElement getGeCart_img_circle_arrow() {
		return geCart_img_circle_arrow;
	}
	public WebElement getCart_prime_header_text() {
		return Cart_prime_header_text;
	}
	public WebElement getCart_prime_sub_header_text() {
		return Cart_prime_sub_header_text;
	}


	@FindBy(xpath = "//*[@text=' ADD TO CART ']")
	private WebElement AddtoCartButton;
	@FindBy(xpath = "//*[@text='  ' and @nodeName='DIV' and @width>0 and ./*[@text='0']]")
	private WebElement Gotocart;
	@FindBy(xpath = "//*[@text='Become Netmeds First Member' and @nodeName='H4']")
	private WebElement Cart_prime_header_text;
	@FindBy(xpath = "//*[@text='Join membership to save much more! Exclusive offers designed for you']")
	private WebElement Cart_prime_sub_header_text;
	public WebElement getGetSearch_drugname() {
		return getSearch_drugname;
	}
	public WebElement getAddtoCartButton() {
		return AddtoCartButton;
	}
	public WebElement getGotocart() {
		return Gotocart;
	}
	public WebElement getSearchbarone() {
		return Searchbarone;
	}
	public void setSearchbarone(WebElement searchbarone) {
		Searchbarone = searchbarone;
	}


	@FindBy(xpath = "//*[@text='Explore Plans' and @nodeName='A']")
	private WebElement Explore_Plans;
	@FindBy(xpath = "//*[@text='Save more with exclusive membership' and @nodeName='H4']")
	private WebElement Save_more_with_exclusive_membership;
	@FindBy(xpath = "//*[@text='Recommended' and @nodeName='DIV']")
	private WebElement Recommended;
	@FindBy(xpath = "//*[@text='6 months' and @nodeName='DIV']")
	private WebElement six_months;
	@FindBy(xpath = "//*[@text='12 months' and @nodeName='DIV']")
	private WebElement twleve_months;
	@FindBy(xpath = "//*[@text='Rs. 299' and @nodeName='SPAN']")
	private WebElement Rs299;
	@FindBy(xpath = "//*[@text='Rs.999' and @nodeName='SPAN']")
	private WebElement Rs999;
	@FindBy(xpath = "//*[@text='Rs.1499' and @nodeName='SPAN']")
	private WebElement Rs1499;
	@FindBy(xpath = "//*[@text='Rs. 499' and @nodeName='SPAN']")
	private WebElement Rs499;
	@FindBy(xpath = "//*[@text=' Add to Cart ' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Rs. 299']]]]")
	private WebElement Add_to_Cart_sixmonth ;
	@FindBy(xpath = "//*[@text=' Add to Cart ' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Rs. 499']]]]")
	private WebElement Add_to_Cart_twlevemonth;
	public WebElement getSave_more_with_exclusive_membership() {
		return Save_more_with_exclusive_membership;
	}
	public WebElement getRecommended() {
		return Recommended;
	}
	public WebElement getSix_months() {
		return six_months;
	}
	public WebElement getTwleve_months() {
		return twleve_months;
	}
	public WebElement getRs299() {
		return Rs299;
	}
	public WebElement getRs999() {
		return Rs999;
	}
	public WebElement getRs1499() {
		return Rs1499;
	}
	public WebElement getRs499() {
		return Rs499;
	}
	public WebElement getAdd_to_Cart_sixmonth() {
		return Add_to_Cart_sixmonth;
	}
	public WebElement getAdd_to_Cart_twlevemonth() {
		return Add_to_Cart_twlevemonth;
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





		
	




