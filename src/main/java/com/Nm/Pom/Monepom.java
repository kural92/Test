package com.Nm.Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Nm.Base.BaseClass;



public class Monepom extends BaseClass {
	public Monepom() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[@class='text m-rgt']")
	private WebElement cartformembership ;
	public WebElement getCartformembership() {
		return cartformembership;
	}
	@FindBy(xpath="(//button[@title='Add to Cart'])[1]")
	private WebElement six_months ;
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]")
	private WebElement twelve_months ;
	public WebElement getSix_months() {
		return six_months;
	}


	public WebElement getTwelve_months() {
		return twelve_months;
	}
//M3 Flow -//

	@FindBy(xpath="//a[text()=' Sign in / Sign up '] ")
	private WebElement signin ;
	
	@FindBy(xpath="//input[@id='loginfirst_mobileno']")
	private WebElement mobileno ;
	@FindBy(xpath = "//*[contains(@class, 'btn-signotp')]")
	private WebElement usepwdbtn;
	public WebElement getUsepwdbtn() {
		return usepwdbtn;
	}
	@FindBy(xpath="(//button[@type='submit'])[5]")
	private WebElement pass ;
	@FindBy(xpath="//input[@id='search']")
	private WebElement Search;
	public WebElement getAddtocart() {
		return addtocart;
	}
	@FindBy(xpath="//input[@id='login_received_pwd']")
	private WebElement password;
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signInpage;
	@FindBy(xpath="//form[@id='search_form']/button")
	private WebElement searchIcon;
	@FindBy(xpath="//button[@title='ADD TO CART']")
	private WebElement addtocart;
	@FindBy(xpath="//div[@id='minicart_btn']")
	private WebElement minicart;
	@FindBy(xpath="//div[@class='process-checkout']")
	private WebElement proceedbutton;
	@FindBy(xpath="//div[@class='process-checkout col-7 pl-1 ng-star-inserted']")
	private WebElement paybutton;
	@FindBy(xpath="//span[@class='title col-md-4']")
	private WebElement paydeatailText;
	@FindBy(xpath="//a[text()='Remove']")
	private WebElement Removebutton;
	public WebElement getRemovebutton() {
		return Removebutton;
	}
	public WebElement getPaydeatailText() {
		return paydeatailText;
	}


	public WebElement getPaybutton() {
		return paybutton;
	}


	public WebElement getProceedbutton() {
		return proceedbutton;
	}


	public WebElement getMinicart() {
		return minicart;
	}


	public WebElement getSearchIcon() {
		return searchIcon;
	}


	public WebElement getPassword() {
		return password;
	}
	
	 
	public WebElement getSignInpage() {
		return signInpage;
	}


	public WebElement getSearch() {
		return Search;
	}
	public WebElement getSignin() {
		return signin;
	}
	public WebElement getMobileno() {
		return mobileno;
	}
	public WebElement getPass() {
		return pass;
	}
	public WebElement getUserprofile() {
		return userprofile;
		
	}
	
	@FindBy(id = "logged_user")
	private WebElement userprofile;
	
	@FindBy(xpath ="//a[normalize-space()='My Subscriptions']")
	private WebElement mysubscriptionpage;
	public WebElement getMysubscriptionpage() {
		return mysubscriptionpage;
	}
	
	@FindBy(xpath="//button[contains(text(),\"CREATE NEW REFILL\")]")
	private WebElement createnewfill;
	
	public WebElement getCreatenewfill() {
		return createnewfill;
	}
	
	@FindBy(xpath ="//ais-search-box[@class='searchinner']//input[@placeholder='Search here...']")
	private WebElement m3productsearch;
	
	public WebElement getM3productsearch() {
		return m3productsearch;
	}
	@FindBy(xpath ="//a[normalize-space()='View cart']")
	private WebElement viewcart;
	
	public WebElement getViewcart() {
		return viewcart;

	}
	@FindBy(xpath = "//button[normalize-space()='Next']")
	private WebElement Nextbutton;
	
	public WebElement getNextbutton() {
		return Nextbutton;
	}
	@FindBy(xpath = "//*[contains(@class, 'btn-checkout btn btn_to_checkout')]")
	private WebElement Proceed;
	public WebElement getProceed() {
		return Proceed;
	}
	@FindBy (xpath = "//button[normalize-space()='Subscribe']")
	private WebElement subscribe;
	
	public WebElement getSubscribe() {
		return subscribe;
	}
	
	@FindBy(xpath = "//button[contains(text(),\"Select Duration\")]")
	private WebElement SelectDuration;
	public WebElement getSelectDuration() {
		return SelectDuration;
	}
	@FindBy(xpath = "//input[@id='externaldoctr']")
	private WebElement consultdoctorcheck;
	
	public WebElement getConsultdoctorcheck() {
		return consultdoctorcheck;
	}
	
	@FindBy(xpath = "//a[contains(@class,'addchangeweb col-md-4 text-right p-0 ng-star-inserted')]")
	private WebElement changeaddbtn;
	
	public WebElement getChangeaddbtn() {
		return changeaddbtn;
	}
	
		@FindBy(xpath ="//input[contains(@id,'customeraddress_9458992')]")
		private WebElement Selectaddress;
		
		public WebElement getSelectaddress() {
			return Selectaddress;
		}
		
		@FindBy(xpath =("//button[.='Modify']"))
		private WebElement Modifyaddressbtn;
		
		public WebElement getModifyaddressbtn() {
			return Modifyaddressbtn;
		}
	@FindBy(xpath = "//input[@id='pin']\"")
	private WebElement changepincode;
	
	public WebElement getChangepincode() {
		return changepincode;
	}
	
	@FindBy(xpath = "//input[@id='pin']\"")
	private WebElement pinclear;
	
	public WebElement getPinclear() {
		return pinclear;
	}
	
	@FindBy(id = "street")	
	private WebElement address;
	
	public WebElement getAddress() {
		return address;
	}
	
	@FindBy(xpath ="//button[contains(.,'Save Address')]")
	
	private WebElement saveaddress;
	
	public WebElement getSaveaddress() {
		return saveaddress;
	}
	
	@FindBy(xpath =("//button[.='Delete']"))
	private WebElement Deleteaddress;
	
	public WebElement getDeleteaddress() {
		return Deleteaddress;
	}
	
}
