package com.Nm.Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Nm.Base.BaseClass;

import bsh.This;

public class MsitePOM  extends BaseClass{
	
	public MsitePOM() {
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(xpath = "//span[@class='app_close']|//*[@class='app_close']")
	private WebElement Msite_HomeScreen_POP_UP;
    public WebElement getMsite_HomeScreen_POP_UP() {
		return Msite_HomeScreen_POP_UP;
	}
    
    @FindBy(xpath = "//*[@css=concat('A.view_btn[href=', \\\"'\\\", '/upload_prescription', \\\"'\\\", ']')]|//*[@class='app_close']//android.view.View[@content-desc=\"Order Now\"]")
    private WebElement Msite_OrderNow;
	public WebElement getMsite_OrderNow() {
		return Msite_OrderNow;
		
		
	}
	
	@FindBy(xpath = "//*[@text='Upload Prescription']|//android.widget.Button[@text='UPLOAD PRESCRIPTION']")
    private WebElement Msite_Upload_Prescription;
	public WebElement getMsite_Upload_Prescription() {
		return Msite_Upload_Prescription;
	}	
	
	
	@FindBy(xpath = "//android.widget.Button[@text='Choose Files']")
    private WebElement Msite_Upload_Gallery;
	public WebElement getMsite_Upload_Gallery() {
		return Msite_Upload_Gallery;
	}
	
	
	@FindBy(xpath = "(//*[@css='INPUT.m2checkbox.ng-untouched.ng-pristine.ng-valid'])[1]|//android.widget.RadioButto[@text='Search and Add medicines']")
    private WebElement Msite_M2_searchMedicine;
	public WebElement getMsite_M2_searchMedicine() {
		return Msite_M2_searchMedicine;
	}
	
	
	@FindBy(xpath = "//android.widget.RadioButto[@text='Get call from Netmeds']")
    private WebElement Msite_M2_Getcall;
	public WebElement getMsite_M2_Getcall() {
		return Msite_M2_Getcall;
	}
	
	@FindBy(xpath = "//*[@text='Continue']|//android.widget.Button[@text='CONTINUE']")
	private WebElement Msite_M2_SearcCall_ContinueButton;
	public WebElement getMsite_M2_SearcCall_ContinueButton() {
		return Msite_M2_SearcCall_ContinueButton;
	}
	
	
	
}
