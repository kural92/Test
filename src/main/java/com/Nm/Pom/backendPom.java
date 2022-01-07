package com.Nm.Pom;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Nm.Base.BackendBaseClass;
import com.Nm.Base.BaseClass;

public class backendPom extends BackendBaseClass{
	
	public backendPom() {
		PageFactory.initElements(driver, this);
	}
	
	    @FindBy(xpath="(//a[text()=' Sign in / Sign up '])")
	    private WebElement login;
	 
	    @FindBy(xpath="//input[@placeholder='Enter your mobile no']")
	    private WebElement mobileno;
	 
		@FindBy(xpath="(//button[@type='submit'])[6]")
		private WebElement click;
		
		@FindBy(id="login_received_pwd" )
		private WebElement pwd;
		
		@FindBy(xpath = "(//button[text()='Sign in'])")
		private WebElement sign;
		
		@FindBy(xpath="//a[text()=' Medicine']")
		private WebElement medi;
		
		@FindBy(xpath = "(//a[@href='/prescriptions'][1])")
		private WebElement allmedi;
		
		@FindBy(xpath ="(//a[@href='/customer/buyagain'])" )
		private WebElement buyagain;
		
		@FindBy(xpath = "//a[@class='logo']")
		private WebElement logo;
		
		@FindBy(xpath = "(//a[@class='h-pro'])")
		private WebElement wellness;
		
		@FindBy(xpath = "(//a[text()='Lab Tests'][1])")
		private WebElement labtest;
		
		@FindBy(xpath = "(//a[text()='Beauty'][1])")
		private WebElement beauty;
		
		@FindBy(xpath = "(//a[text()='Body Care'])")
		private WebElement bodycare;
		
		@FindBy(xpath ="(//a[text()='Face Care'])")
		private WebElement facecare;
		
		@FindBy(xpath = "(//a[text()='Fragrances'])")
		private WebElement fragnance;
		
		@FindBy(xpath = "(//a[text()='Hands and Feet'])")
		private WebElement handfeet;
		
		@FindBy(xpath = "(//a[text()='Home Care'])")
		private WebElement homecare;
		
		@FindBy(xpath = "(//a[text()='Eye Care'])")
		private WebElement eyecare;
		
		@FindBy(linkText = "Men's Care")
		private WebElement menscare;
		
		@FindBy(xpath = "(//a[text()='Senior Care'])")
		private WebElement seniorcare;
		
		@FindBy(xpath = "//a[text()=' Health Corner']")
		private WebElement healthcorner;
		
		@FindBy(xpath = "//a[contains(text(),'Health Library')]")
		private WebElement healthlib;
		
		@FindBy(xpath = "//a[contains(text(),'PatientsAlike')]")
		private WebElement patients;
		
		@FindBy(xpath = "//div[@class='cat-list'][1]")
		private WebElement catordermed;
		
		@FindBy(xpath = "//div[@class='cat-list'][2]")
		private WebElement catbeaut;
		
		@FindBy(xpath = "//div[@class='cat-list'][3]")
		private WebElement catwellness;
		
		@FindBy(xpath = "(//div[@class='slide-section'])[1]")
		private WebElement paytm;
		
		@FindBy(xpath = "(//div[@class='slide-section'])[2]")
		private WebElement mobiqwik;
		
		@FindBy(xpath = "//div[@class='cat-list'][3]")
		private WebElement simpl;
		
		@FindBy(xpath = "//a[text()=' View All '][1]")
		private WebElement payviewll;
		
		@FindBy(xpath = "//input[@value='medicine']")
		private WebElement chkmed;
		
		@FindBy(xpath = "//input[@value='diagnostics']")
		private WebElement chkdiag;
		
		@FindBy(xpath = "//input[@value='consultation']")
		private WebElement chckconsult;
		
		@FindBy(xpath = "//span[text()=' Deliver to ']")
		private WebElement deliver;
		
		@FindBy(xpath = "//input[@placeholder='Enter Pincode']")
		private WebElement pincode;
		
		@FindBy(xpath="//input[@id='search']")
		private WebElement search;
		
		@FindBy(xpath = "//div[contains(text(),' 828 Franboise Frenzy 5 Gm')]")
		private WebElement lorealLip;
		
		@FindBy(xpath = "//label[text()='838 Berry Cherie']")
		private WebElement variantlor1;
		
		@FindBy(xpath = "//label[text()='820 Praline Of Paris']")
		private WebElement variantlor2;
		
		@FindBy(xpath = "//label[text()='834 Infinite Spice']")
		private WebElement variantlor3;
		
		@FindBy(xpath = "//label[text()='824 Guava Gush']")
		private WebElement variantlor4;
		
		@FindBy(xpath = "//label[@title='Add to Wishlist.']")
		private WebElement wishlist;
		
		@FindBy(id="product-addtocart-button")
		 private WebElement PDP_AddtoCart_btn;
		
		@FindBy(xpath = "//div[text()=' Cart ']")
		private WebElement homecart;
		
		@FindBy(xpath = "//a[@id='logged_user']")
		private WebElement userprofile;
		
		@FindBy(xpath = "//a[text()='My WishList ']")
		private WebElement wishlist_youraccount;
		
		@FindBy(xpath = "//button[text()='Proceed']|//button[contains(text(),'Proceed')]")
		private WebElement Cart_Proceed;
		
		@FindBy(xpath = "(//span[text()='Past Rx'])")
		private WebElement pastRx_button;
		
		@FindBy(xpath = "(//input[@name='uplpastRx'])[1]")
		private WebElement pastRx_Image;
		
		@FindBy(xpath = "(//button[@class='close'])[2]")
		private WebElement pastRx_close;
		
		@FindBy(xpath = "//button[text()='Review Order']")
		private WebElement Review_button;
		
		@FindBy(xpath = "//button[text()='Pay']")
		private WebElement Pay_button;
		
		@FindBy(xpath = "//input[@id='nms_cod']")
		private WebElement COD_Radio;
		
		@FindBy(xpath = "//button[@class='float-right process-orderplace col-md-5 col-12']")
		private WebElement Pay_COD;
		
		@FindBy(xpath = "(//button[@class='btn-track btn m-0'])[2]")
		private WebElement Track_button;
		
		@FindBy(xpath = "(//button[@class='btn-view ord-btn'])[1]")
		private WebElement Details_Button;
		
		@FindBy(xpath = "//span[text()='Medicine Orders']")
		private WebElement YourAcc_MediOrder;
		
		@FindBy(xpath = "//body/app-root[1]/app-layout[1]/div[1]/main[1]/app-order-detail[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]")
		private WebElement CustomerName_OrderDet;
		
		@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-layout[1]/div[1]/main[1]/app-order-detail[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]")
		private WebElement OrderID_OrderDet;
		
		@FindBy(xpath = "//div[contains(text(),'PRESCRIPTION VERIFICATION PENDING')]")
		private WebElement Status_OrderDet;
		
		@FindBy(xpath = "//body/app-root[1]/app-layout[1]/div[1]/main[1]/app-order-detail[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]")
		private WebElement Address_OrderDet;
		
		@FindBy(xpath = "//body/app-root[1]/app-layout[1]/div[1]/main[1]/app-order-detail[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]")
		private WebElement Amount_OrderDet;
		
		@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-layout[1]/div[1]/main[1]/app-order-detail[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/div[2]")
		private WebElement PaymentMode_OrderDet;
		
		@FindBy(xpath = "//input[@id='txtusername']")
		private WebElement UserName_View;
		
		@FindBy(xpath = "//input[@id='txtpassword']")
		private WebElement Password_View;
		
		@FindBy(xpath = "//input[@id='btnlogin']")
		private WebElement LoginButton_View;
		
		@FindBy(xpath = "//input[@id='txtordercode']")
		private WebElement OrderCode_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[4]")
		private WebElement chck1_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[5]")
		private WebElement chck2_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[6]")
		private WebElement chck3_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[7]")
		private WebElement chck4_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[8]")
		private WebElement chck5_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[9]")
		private WebElement chck6_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[10]")
		private WebElement chck7_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[11]")
		private WebElement chck8_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[12]")
		private WebElement chck9_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[13]")
		private WebElement chck10_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[14]")
		private WebElement chck11_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[15]")
		private WebElement chck12_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[16]")
		private WebElement chck13_View;
		
		@FindBy(xpath = "(//input[@type='checkbox'])[17]")
		private WebElement chck14_View;
		
		@FindBy(xpath = "//input[@id='Submit']")
		private WebElement Submit_View;
		
		@FindBy(xpath = "/html[1]/body[1]/form[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td")
		private WebElement CustName_View;
		
		@FindBy(xpath = "/html[1]/body[1]/form[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]")
		private WebElement orderID_View;
		
		@FindBy(xpath = "/html[1]/body[1]/form[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[7]")
		private WebElement PayMode_View;
		
		@FindBy(xpath = "/html[1]/body[1]/form[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[4]")
		private WebElement Status_View;
		
		@FindBy(xpath = "/html[1]/body[1]/form[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[5]")
		private WebElement Amount_View;
		
		@FindBy(xpath = "//input[@id='txtusername']")
		private WebElement Username_BO;
		
		@FindBy(xpath = "//input[@id='txtpassword']")
		private WebElement Password_BO;
		
		@FindBy(xpath = "//input[@id='btnlogin']")
		private WebElement BtnLogin_BO;
		
		@FindBy(xpath = "//a[text()='Order Updation ']")
		private WebElement OrderUpd_BO;
		
		@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtordercode']")
		private WebElement OrderCode_BO;
		
		@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnview']")
		private WebElement ViewButton_BO;
		
		@FindBy(xpath = "//input[@class='btn btn-success btn-xs']")
		private WebElement ViewButton1_BO;
		
		@FindBy(xpath = "//input[@id='ContentPlaceHolder1_Button1']")
		private WebElement UpdateButton_BO;
		
		@FindBy(xpath = "//input[@id='email']")
		private WebElement Username_FC;
		
		@FindBy(xpath = "//input[@id='password']")
		private WebElement Password_FC;
		
		@FindBy(xpath = "//button[text()='Sign in']")
		private WebElement LoginButton_FC;
		
		@FindBy(xpath = "//a[text()='Manual Submit']")
		private WebElement ManuSubmit_FC;
		
		@FindBy(xpath = "//input[@id='txt_orderId']")
		private WebElement OrderID_FC;
		
		@FindBy(xpath = "//button[text()='Submit']")
		private WebElement Submit1_FC;
		
		@FindBy(xpath = "(//a[text()='Order Submit'])[2]")
		private WebElement Update_FC;
		
		@FindBy(xpath = "/html[1]/body[1]/form[1]/div[4]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[3]/td[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]")
		private WebElement SuborderID_View;
		
		@FindBy(xpath = "(//a[@title='Save For Later'])")
		private WebElement saveforlater;
		
		@FindBy(xpath = "(//a[text()='Save for later '])[1]")
		private WebElement saveforlater_1;
		
		@FindBy(xpath = "(//div[text()=' Move To Cart '])[2]")
		private WebElement movetocart;
		
		@FindBy(xpath = "(//div[text()=' Move To Cart '])[2]")
		private WebElement movetocart_1;

		public WebElement getLogin() {
			return login;
		}

		public WebElement getMobileno() {
			return mobileno;
		}

		public WebElement getClick() {
			return click;
		}

		public WebElement getPwd() {
			return pwd;
		}

		public WebElement getSign() {
			return sign;
		}

		public WebElement getMedi() {
			return medi;
		}

		public WebElement getAllmedi() {
			return allmedi;
		}

		public WebElement getBuyagain() {
			return buyagain;
		}

		public WebElement getLogo() {
			return logo;
		}

		public WebElement getWellness() {
			return wellness;
		}

		public WebElement getLabtest() {
			return labtest;
		}

		public WebElement getBeauty() {
			return beauty;
		}

		public WebElement getBodycare() {
			return bodycare;
		}

		public WebElement getFacecare() {
			return facecare;
		}

		public WebElement getFragnance() {
			return fragnance;
		}

		public WebElement getHandfeet() {
			return handfeet;
		}

		public WebElement getHomecare() {
			return homecare;
		}

		public WebElement getEyecare() {
			return eyecare;
		}

		public WebElement getMenscare() {
			return menscare;
		}

		public WebElement getSeniorcare() {
			return seniorcare;
		}

		public WebElement getHealthcorner() {
			return healthcorner;
		}

		public WebElement getHealthlib() {
			return healthlib;
		}

		public WebElement getPatients() {
			return patients;
		}

		public WebElement getCatordermed() {
			return catordermed;
		}

		public WebElement getCatbeaut() {
			return catbeaut;
		}

		public WebElement getCatwellness() {
			return catwellness;
		}

		public WebElement getPaytm() {
			return paytm;
		}

		public WebElement getMobiqwik() {
			return mobiqwik;
		}

		public WebElement getSimpl() {
			return simpl;
		}

		public WebElement getPayviewll() {
			return payviewll;
		}

		public WebElement getChkmed() {
			return chkmed;
		}

		public WebElement getChkdiag() {
			return chkdiag;
		}

		public WebElement getChckconsult() {
			return chckconsult;
		}

		public WebElement getDeliver() {
			return deliver;
		}

		public WebElement getPincode() {
			return pincode;
		}

		public WebElement getSearch() {
			return search;
		}

		public WebElement getLorealLip() {
			return lorealLip;
		}

		public WebElement getVariantlor1() {
			return variantlor1;
		}

		public WebElement getVariantlor2() {
			return variantlor2;
		}

		public WebElement getVariantlor3() {
			return variantlor3;
		}

		public WebElement getVariantlor4() {
			return variantlor4;
		}

		public WebElement getWishlist() {
			return wishlist;
		}

		public WebElement getPDP_AddtoCart_btn() {
			return PDP_AddtoCart_btn;
		}

		public WebElement getHomecart() {
			return homecart;
		}

		public WebElement getUserprofile() {
			return userprofile;
		}

		public WebElement getWishlist_youraccount() {
			return wishlist_youraccount;
		}

		public WebElement getCart_Proceed() {
			return Cart_Proceed;
		}

		public WebElement getPastRx_button() {
			return pastRx_button;
		}

		public WebElement getPastRx_Image() {
			return pastRx_Image;
		}

		public WebElement getPastRx_close() {
			return pastRx_close;
		}

		public WebElement getReview_button() {
			return Review_button;
		}

		public WebElement getPay_button() {
			return Pay_button;
		}

		public WebElement getCOD_Radio() {
			return COD_Radio;
		}

		public WebElement getPay_COD() {
			return Pay_COD;
		}

		public WebElement getTrack_button() {
			return Track_button;
		}

		public WebElement getDetails_Button() {
			return Details_Button;
		}

		public WebElement getYourAcc_MediOrder() {
			return YourAcc_MediOrder;
		}

		public WebElement getCustomerName_OrderDet() {
			return CustomerName_OrderDet;
		}

		public WebElement getOrderID_OrderDet() {
			return OrderID_OrderDet;
		}

		public WebElement getStatus_OrderDet() {
			return Status_OrderDet;
		}

		public WebElement getAddress_OrderDet() {
			return Address_OrderDet;
		}

		public WebElement getAmount_OrderDet() {
			return Amount_OrderDet;
		}

		public WebElement getPaymentMode_OrderDet() {
			return PaymentMode_OrderDet;
		}

		public WebElement getUserName_View() {
			return UserName_View;
		}

		public WebElement getPassword_View() {
			return Password_View;
		}

		public WebElement getLoginButton_View() {
			return LoginButton_View;
		}

		public WebElement getOrderCode_View() {
			return OrderCode_View;
		}

		public WebElement getChck1_View() {
			return chck1_View;
		}

		public WebElement getChck2_View() {
			return chck2_View;
		}

		public WebElement getChck3_View() {
			return chck3_View;
		}

		public WebElement getChck4_View() {
			return chck4_View;
		}

		public WebElement getChck5_View() {
			return chck5_View;
		}

		public WebElement getChck6_View() {
			return chck6_View;
		}

		public WebElement getChck7_View() {
			return chck7_View;
		}

		public WebElement getChck8_View() {
			return chck8_View;
		}

		public WebElement getChck9_View() {
			return chck9_View;
		}

		public WebElement getChck10_View() {
			return chck10_View;
		}

		public WebElement getChck11_View() {
			return chck11_View;
		}

		public WebElement getChck12_View() {
			return chck12_View;
		}

		public WebElement getChck13_View() {
			return chck13_View;
		}

		public WebElement getChck14_View() {
			return chck14_View;
		}

		public WebElement getSubmit_View() {
			return Submit_View;
		}

		public WebElement getCustName_View() {
			return CustName_View;
		}

		public WebElement getOrderID_View() {
			return orderID_View;
		}

		public WebElement getPayMode_View() {
			return PayMode_View;
		}

		public WebElement getStatus_View() {
			return Status_View;
		}

		public WebElement getAmount_View() {
			return Amount_View;
		}

		public WebElement getUsername_BO() {
			return Username_BO;
		}

		public WebElement getPassword_BO() {
			return Password_BO;
		}

		public WebElement getBtnLogin_BO() {
			return BtnLogin_BO;
		}

		public WebElement getOrderUpd_BO() {
			return OrderUpd_BO;
		}

		public WebElement getOrderCode_BO() {
			return OrderCode_BO;
		}

		public WebElement getViewButton_BO() {
			return ViewButton_BO;
		}

		public WebElement getViewButton1_BO() {
			return ViewButton1_BO;
		}

		public WebElement getUpdateButton_BO() {
			return UpdateButton_BO;
		}

		public WebElement getUsername_FC() {
			return Username_FC;
		}

		public WebElement getPassword_FC() {
			return Password_FC;
		}

		public WebElement getLoginButton_FC() {
			return LoginButton_FC;
		}

		public WebElement getManuSubmit_FC() {
			return ManuSubmit_FC;
		}

		public WebElement getOrderID_FC() {
			return OrderID_FC;
		}

		public WebElement getSubmit1_FC() {
			return Submit1_FC;
		}

		public WebElement getUpdate_FC() {
			return Update_FC;
		}

		public WebElement getSuborderID_View() {
			return SuborderID_View;
		}

		public WebElement getSaveforlater() {
			return saveforlater;
		}

		public WebElement getSaveforlater_1() {
			return saveforlater_1;
		}

		public WebElement getMovetocart() {
			return movetocart;
		}

		public WebElement getMovetocart_1() {
			return movetocart_1;
		}

		
		/////////////////////
		// RWOS and PICKLIST 
		

		@FindBy(id="userName")
		private WebElement Rwos_UserName;
		public WebElement getRwos_UserName() {
			return Rwos_UserName;
		}
		
		
		@FindBy(id="password")
		private WebElement Rwos_Password;
		public WebElement getRwos_Password() {
			return Rwos_Password;
		}
		
		@FindBy(xpath="/html/body/div/rw-root/rw-login/div/table/tbody/tr/td[2]/table/tbody/tr[8]/td/p-checkbox/div/div[2]/span")
		private WebElement Rwos_signCheckBox;
		public WebElement getRwos_signCheckBox() {
			return Rwos_signCheckBox;
		}
		
		
		@FindBy(id="signIn")
		private WebElement Rwos_SignIn;
		public WebElement getRwos_SignIn() {
			return Rwos_SignIn;
		}
		
		
		@FindBy(xpath ="//label[contains(text(),'769 - RRL MDU')]|//label[contains(text(),'769  - HX0F - RRL MDU')]" )
		private WebElement Rwos_FcPanel;
		public WebElement getRwos_FcPanel() {
			return Rwos_FcPanel;
		}
		
		@FindBy(xpath ="//*[@id=\"ui-panel-2-content\"]/div/div/div" )
		private List<WebElement> Rwos_FcPanelList;
		public List<WebElement> getRwos_FcPanelList() {
			return Rwos_FcPanelList;
		}
		
		@FindBy(xpath ="//span[contains(text(),'Proceed')]" )
		private WebElement Rwos_FcPanel_Proceed;
		public WebElement getRwos_FcPanel_Proceed() {
			return Rwos_FcPanel_Proceed;
		}
		
		@FindBy(xpath ="(//span[contains(text(),'Yes')])[2]" )
		private WebElement Rwos_AlreadySignIn_YesBtn;
		public WebElement getRwos_AlreadySignIn_YesBtn() {
			return Rwos_AlreadySignIn_YesBtn;
		}
		
		@FindBy(xpath ="//*[@id=\"sidebar-wrapper\"]/div/a/span" )
		private WebElement Rwos_HamBurger_Menu;
		public WebElement getRwos_HamBurger_Menu() {
			return Rwos_HamBurger_Menu;
		}
		
		@FindBy(xpath ="(//a[@routerlinkactive='selectedMenu'])[3]" )
		private WebElement Rwos_SaleTransaction;
		public WebElement getRwos_SaleTransaction() {
			return Rwos_SaleTransaction;
		}
		
		@FindBy(xpath ="//a[contains(text(),'Search')]" )
		private WebElement Rwos_SaleTransaction_Search;
		public WebElement getRwos_SaleTransaction_Search() {
			return Rwos_SaleTransaction_Search;
		}
		
		@FindBy(xpath ="//label[contains(text(),'-Select-')]" )
		private WebElement Rwos_BillType;
		public WebElement getRwos_BillType() {
			return Rwos_BillType;
		}
		
		@FindBy(xpath ="//label[contains(text(),'Customer Order')]" )
		private WebElement Rwos_BillType_CustomerOrder;
		public WebElement getRwos_BillType_CustomerOrder() {
			return Rwos_BillType_CustomerOrder;
		}
		
		@FindBy(id ="searchTxn" )
		private WebElement Rwos_BillType_Search_btn;
		public WebElement getRwos_BillType_Search_btn() {
			return Rwos_BillType_Search_btn;
		}
		
		
		@FindBy(xpath = "//i[@title='Click to View']")
		private List<WebElement> Rwos_Order_View_btn;
		public List<WebElement> getRwos_Order_View_btn() {
			return Rwos_Order_View_btn;
		}
		
		
		@FindBy(xpath ="//input[@name='txnId']" )
		private WebElement Rwos_TransactionID;
		public WebElement getRwos_TransactionID() {
			return Rwos_TransactionID;
		}
		
		@FindBy(xpath ="(//div[@class='ui-panel-content ui-widget-content'])[2]" )
		private WebElement Rwos_ShippingAddress;
		public WebElement getRwos_ShippingAddress() {
			return Rwos_ShippingAddress;
		}
		
		@FindBy(xpath ="(//div[@class='ui-panel-content ui-widget-content'])[1]" )
		private WebElement Rwos_BillingAddress;
		public WebElement getRwos_BillingAddress() {
			return Rwos_BillingAddress;
		}
		
		
		@FindBy(xpath ="(//table[@class='billTotalSection'])[1]" )
		private WebElement Rwos_BillTable1;
		public WebElement getRwos_BillTable1() {
			return Rwos_BillTable1;
		}
		
		@FindBy(xpath ="(//table[@class='billTotalSection'])[2]" )
		private WebElement Rwos_BillTable2;
		public WebElement getRwos_BillTable2() {
			return Rwos_BillTable2;
		}
		
		
		@FindBy(xpath ="//span[contains(text(),'Close')]" )
		private WebElement Rwos_CloseBtn;
		public WebElement getRwos_CloseBtn() {
			return Rwos_CloseBtn;
		}
		
		
		
		
		

}