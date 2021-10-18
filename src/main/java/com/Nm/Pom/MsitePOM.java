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
}
