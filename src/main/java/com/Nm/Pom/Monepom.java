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
	@FindBy(xpath="//a[text()=' Sign in / Sign up '] ")
	private WebElement signin ;
	
	@FindBy(xpath="//input[@id='loginfirst_mobileno']")
	private WebElement mobileno ;
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
}
