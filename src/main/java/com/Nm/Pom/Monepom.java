package com.Nm.Pom;

import java.util.List;

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
	//*********************************************************M3 Flow starts********************************************************************************
	
	@FindBy(id = "logged_user")
	private WebElement userprofile;
	public WebElement getUserprofile() {
		return userprofile;
	}
	
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
	
		@FindBy(xpath ="(//input[@class =\"radio rdbtn\"])[2]")
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
	
	@FindBy(xpath ="(//button[contains(.,'My Subscription')])[2]")
	private WebElement mysubscription;
	public WebElement getMysubscription() {
		return mysubscription;
	}
	
	@FindBy(xpath = ("//a[@class='orders-link']"))
	private WebElement medicineorders;
	public WebElement getMedicineorders() {
		return medicineorders;
	}
	
	@FindBy(xpath = ("//button[@class=\"btn btn-help ng-star-inserted\"]"))
	private WebElement cancelorder;
	public WebElement getCancelorder() {
		return cancelorder;
	}
	
	@FindBy(xpath = ("//button[contains(text(),\"YES\")]"))
	private WebElement cancelyes;
	public WebElement getCancelyes() {
		return cancelyes;
	}
	
	
	@FindBy(xpath = ("//button[contains(text(),\"SUBMIT & CANCEL\")]"))
	private WebElement cancelsubmit;
	public WebElement getCancelsubmit() {
		return cancelsubmit;
	}
	
	@FindBy(xpath = "(//div[@class=\"pro-qty qty-upt-evt ng-star-inserted\"]//select[@name='quantity'])[1]")
	private WebElement Qty_Incr_Decr;
	public WebElement getQty_Incr_Decr() {
		return Qty_Incr_Decr;
	}
	
	@FindBy(xpath = "(//a[@class = \"action action-delete removeitem\"])[2]")
	private WebElement removeitem;
	public WebElement getRemoveitem() {
		return removeitem;
	}
	
	@FindBy(xpath = "(//div[@class=\"applypromo appliedpromocpn ng-star-inserted\"])[2]")
	private WebElement Subs20_promo;
	public WebElement getSubs20_promo() {
		return Subs20_promo;
	}
	
	@FindBy(xpath = "//input[@value='45']")
	private WebElement Selectduration45;
	public WebElement getSelectduration45() {
		return Selectduration45;
	}

	@FindBy(xpath = "//input[@value='30']")
	private WebElement Selectduration30;
	public WebElement getSelectduration30() {
		return Selectduration30;
	}

	@FindBy(xpath = "//input[@value='60']")
	private WebElement Selectduration60;
	public WebElement getSelectduration60() {
		return Selectduration60;
	}
	
	@FindBy(xpath = "//h2[contains( text(),'Order Placed Successfully!')]")
	private WebElement orderplaced;
	public WebElement getOrderplaced() {
		return orderplaced;
	}
	
	@FindBy(xpath = "//span[contains(@class,'order-number')]")
	private WebElement orderid;
	public WebElement getOrderid() {
		return orderid;
	}
	@FindBy(xpath = "//a[contains(@class,'addchangeweb col-md-4 text-right p-0 ng-star-inserted')]")
	private WebElement backto_Addrspage;
	public WebElement getBackto_Addrspage() {
		return backto_Addrspage;
	}
	
	@FindBy(xpath = "//img[@alt='Netmeds.com, India ki Online Pharmacy']")
	private WebElement netmedshome;
	public WebElement getNetmedshome() {
		return netmedshome;
	}
	
	
	//*****************************************************M3 Flow Ends**********************************************************************************
	
	
	
	
	
	
	
	// m2 Flow
	@FindBy(xpath = "//a[contains(text(),'Upload')]")
	private WebElement Upload_cta;
	public WebElement getUpload_cta() {
		return Upload_cta;
	}
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/main/app-m2/div[1]/div/div[1]/div[1]/div[2]/div/form/div[1]/ul/li[1]/label/input")
	private WebElement Upload_Rx;
	public WebElement getUpload_Rx() {
		return Upload_Rx;
	}
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/main/app-m2/div[1]/div/div[1]/div[1]/div[2]/div/form/div[1]/ul/li[2]/span[1]")
	private WebElement Past_Rx;
	public WebElement getPast_Rx() {
		return Past_Rx;
	}
	
	
	@FindBy(xpath = "(//input[@name='m2optlist'])[1]")
	private WebElement Search_Medicines;
	public WebElement getSearch_Medicines() {
		return Search_Medicines;
	}
	
	@FindBy(xpath = "(//input[@name='m2optlist'])[2]")
	private WebElement get_call;
	public WebElement getGet_call() {
		return get_call;
	}
	
	
	@FindBy(xpath = "//a[contains(text(),'Valid Prescription?')]")
	private WebElement Valid_Prescription_Link;
	public WebElement getValid_Prescription_Link() {
		return Valid_Prescription_Link;
	}

	@FindBy(xpath = "(//button[@class='close'])[3]")
	private WebElement Valid_Prescription_Link_Close;
	public WebElement getValid_Prescription_Link_Close() {
		return Valid_Prescription_Link_Close;
	}


	@FindBy(xpath = "//a[@title='Remove']")
	private WebElement Remove_Prescription;
	public WebElement getRemove_Prescription() {
		return Remove_Prescription;
	}
	
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	private WebElement Continue_cta;
	public WebElement getContinue_cta() {
		return Continue_cta;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Confirm Order')]")
	private WebElement Confirm_Order_cta;
	public WebElement getConfirm_Order_cta() {
		return Confirm_Order_cta;
	}
	
	@FindBy(xpath = "//h2[contains(text(),'Order Placed Successfully!')]")
	private WebElement Order_Placed_text;
	public WebElement getOrder_Placed_text() {
		return Order_Placed_text;
	}
	
	
	@FindBy(xpath = "(//button[contains(text(),'Track Order')])[2]")
	private WebElement Track_Order;
	public WebElement getTrack_Order() {
		return Track_Order;
	}
	
	@FindBy(xpath = "//div[@class='ordcusinfomain']")
	private WebElement Order_Info;
	public WebElement getOrder_Info() {
		return Order_Info;
	}
	
	
	@FindBy(xpath = "//button[contains(text(),' View Details ')]")
	private WebElement View_Details;
	public WebElement getView_Details() {
		return View_Details;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Cancel Order')]")
	private WebElement Cancel_Order;
	public WebElement getCancel_Order() {
		return Cancel_Order;
	}
	
	
	@FindBy(xpath = "(//input[@name='reasonselect'])[1]")
	private WebElement Cancel_reason;
	public WebElement getCancel_reason() {
		return Cancel_reason;
	}
	
	@FindBy(xpath = "(//input[@name='reasonselect'])[2]")
	private WebElement Cancel_reason1;
	public WebElement getCancel_reason1() {
		return Cancel_reason1;
	}
	
	@FindBy(xpath = "(//input[@name='reasonselect'])[3]")
	private WebElement Cancel_reason2;
	public WebElement getCancel_reason2() {
		return Cancel_reason2;
	}
	
	@FindBy(xpath = "(//input[@name='reasonselect'])[4]")
	private WebElement Cancel_reason3;
	public WebElement getCancel_reason3() {
		return Cancel_reason3;
	}
	@FindBy(xpath = "//button[contains(text(),'SUBMIT & CANCEL')]")
	private WebElement Submit_Cancel;
	public WebElement getSubmit_Cancel() {
		return Submit_Cancel;
	}
	
	@FindBy(xpath="//div[@class='info']")
	private WebElement product_List;
	public WebElement getProduct_List() {
		return product_List;
	}
	
	
	@FindBy(xpath="//div[@class='info']")
	private List<WebElement> productList;
	public List<WebElement> getProductList() {
		return productList;
	}
	
	@FindBy(xpath="//span[@class='best-price']//following::span[@class='final-price']")
	private List<WebElement> productList_Price;
	public List<WebElement> getProductList_Price() {
		return productList_Price;
	}
	
	@FindBy(xpath="//span[@class='drug-manu']")
	private List<WebElement> manufacture_detailsList;
	public List<WebElement> getManufacture_detailsList() {
		return manufacture_detailsList;
	}
	
	
	@FindBy(xpath="//span[@class='gen_drug ellipsis']")
	private List<WebElement> drug_categoryList;
	public List<WebElement> getDrug_categoryList() {
		return drug_categoryList;
	}
	
	@FindBy(xpath="//span[@class='gen_drug ellipsis']")
	private List<WebElement> rx_requiredList;
	public List<WebElement> getRx_requiredList() {
		return rx_requiredList;
	}
	
	@FindBy(id="product_page_cart_count")
	private WebElement cart_details;
	public WebElement getCart_details() {
		return cart_details;
	}
	
	
	@FindBy(xpath = "//div[@class='cpncode_review']")
	private WebElement M2_CoupCode_text;
	public WebElement getM2_CoupCode_text() {
		return M2_CoupCode_text;
	}
	
	@FindBy(xpath = "(//a[contains(text(),'Change')])[1]")
	private WebElement M2_ChangeAdress_btn;
	public WebElement getM2_ChangeAdress_btn() {
		return M2_ChangeAdress_btn;
	}
	
	
	@FindBy(xpath  ="(//a[contains(text(),'+ ADD NEW ADDRESS')])[1]")
	private WebElement M2_AddNewAddresss_btn;
	public WebElement getM2_AddNewAddresss_btn() {
		return M2_AddNewAddresss_btn;
	}
	
	
	@FindBy(id="pin")
	private WebElement M2_Address_Pin;
	public WebElement getM2_Address_Pin() {
		return M2_Address_Pin;
	}
	
	@FindBy(id="firstname")
	private WebElement M2_Address_FirstName;
	public WebElement getM2_Address_FirstName() {
		return M2_Address_FirstName;
	}
	
	@FindBy(id="lastname")
	private WebElement M2_Address_Lastname;
	public WebElement getM2_Address_Lastname() {
		return M2_Address_Lastname;
	}
	
	@FindBy(id="street")
	private WebElement M2_Address_Street;
	public WebElement getM2_Address_Street() {
		return M2_Address_Street;
	}
	
	@FindBy(id="landmark")
	private WebElement M2_Address_landMark;
	public WebElement getM2_Address_landMark() {
		return M2_Address_landMark;
	}
	
	@FindBy(xpath="//button[contains(text(),'Save Address')]")
	private WebElement M2_SaveAddress_btn;
	public WebElement getM2_SaveAddress_btn() {
		return M2_SaveAddress_btn;
	}
	
	@FindBy(xpath="//button[contains(text(),'Modify')]")
	private WebElement M2_Addres_Modify;
	public WebElement getM2_Addres_Modify() {
		return M2_Addres_Modify;
	}
	
	@FindBy(xpath="//button[contains(text(),'Delete')]")
	private WebElement M2_Address_Delete;
	public WebElement getM2_Address_Delete() {
		return M2_Address_Delete;
	}
	
	@FindBy(xpath="//a[@class='explore-plans']")
	private WebElement Home_exploreplans;
	public WebElement getHome_exploreplans() {
		return Home_exploreplans;
	}
	@FindBy(xpath="//div[@class='membershipoffer']/h4")
	private WebElement Home_getmostfrom;
	public WebElement getHome_getmostfrom() {
		return Home_getmostfrom;
	}
	@FindBy(xpath="//span[text()='Netmeds First']")
	private WebElement gethome_netmedsfirst;
	public WebElement getGethome_netmedsfirst() {
		return gethome_netmedsfirst;
	}
	@FindBy(xpath="//li[text()='Get special discounts and offers on Netmeds services.']")
	private WebElement gethome_Getspecialdiscount;
	public WebElement getGethome_Getspecialdiscount() {
		return gethome_Getspecialdiscount;
	}
	@FindBy(xpath="//h2[text()='Save more with Netmeds First membership']")
	private WebElement home_savemore;
	@FindBy(xpath="//h2[text()='Netmeds First Membership']")
	private WebElement home_NetmedsFirst;
	public WebElement getHome_NetmedsFirst() {
		return home_NetmedsFirst;
	}
	@FindBy(xpath="//li[text()='Get 2.5% NMS Cash on all orders.']")
	private WebElement  home_getnms_cash;
	@FindBy(xpath="//div[text()='Starting at ₹299']")
	private WebElement home_stating_price;
	@FindBy(xpath="//h5[text()='2.5% NMS Cash']")
	private WebElement home_nmscash_section;
	@FindBy(xpath="//h5[text()='Free Delivery']")
	private WebElement home_FreeDelivery;
	@FindBy(xpath="//h5[text()='Priority Processing']")
	private WebElement home_PriorityProcessing;
	@FindBy(xpath="//h5[text()='Basic Health Checkup']")
	private WebElement home_BasicHealthCheckup;
	@FindBy(xpath="//p[text()='only with 12 month plan']")
	private WebElement home_only_with_12_month_plan;
	@FindBy(xpath="//h5[text()='Additional 5% off on Pathology Lab Tests']")
	private WebElement home_Additional_5_off_on_Pathology_Lab_Tests;
	@FindBy(xpath="//h5[text()='Free Unlimited Consultation']")
	private WebElement home_Free_Unlimited_Consultation;
	public WebElement getHome_FreeDelivery() {
		return home_FreeDelivery;
	}


	public WebElement getHome_PriorityProcessing() {
		return home_PriorityProcessing;
	}


	public WebElement getHome_BasicHealthCheckup() {
		return home_BasicHealthCheckup;
	}


	public WebElement getHome_only_with_12_month_plan() {
		return home_only_with_12_month_plan;
	}


	public WebElement getHome_Additional_5_off_on_Pathology_Lab_Tests() {
		return home_Additional_5_off_on_Pathology_Lab_Tests;
	}


	public WebElement getHome_Free_Unlimited_Consultation() {
		return home_Free_Unlimited_Consultation;
	}
	@FindBy(xpath="//p[text()='(Max 100) on all prepaid orders']")
	private WebElement home_allprepaid_orders;
	public WebElement getHome_savemore() {
		return home_savemore;
	}


	public WebElement getHome_getnms_cash() {
		return home_getnms_cash;
	}


	public WebElement getHome_stating_price() {
		return home_stating_price;
	}


	public WebElement getHome_nmscash_section() {
		return home_nmscash_section;
	}


	public WebElement getHome_allprepaid_orders() {
		return home_allprepaid_orders;
	}
	
	@FindBy(xpath="//a[@id='logged_user']")
	private WebElement home_logged_user;
	
	@FindBy(xpath="//a[text()='Netmeds First ']")
	private WebElement yourAccount_Netmeds_First;
	public WebElement getHome_logged_user() {
		return home_logged_user;
	}


	public WebElement getYourAccount_Netmeds_First() {
		return yourAccount_Netmeds_First;
	}
	@FindBy(xpath="//h4[text()='Save more with exclusive membership']")
	private WebElement youraccount_savemore;
	public WebElement getYouraccount_savemore() {
		return youraccount_savemore;
	}
	@FindBy(xpath="//h3[text()='Netmeds Membership']")
	private WebElement youraccount_NetmedsMembership;
	public WebElement getYouraccount_NetmedsMembership() {
		return youraccount_NetmedsMembership;
	}
	
	@FindBy(xpath="//div[@class='cart-rightside col-md-4']/div/h4")
	private WebElement cart_NetmedsMembership;
	@FindBy(xpath="//div[@class='cart-rightside col-md-4']/div/p")
	private WebElement cart_Netmedscontent;
	@FindBy(xpath="//div[@class='cart-rightside col-md-4']/div/a")
	private WebElement cart_NetmedsMembershiplink;
	public WebElement getCart_NetmedsMembershiplink() {
		return cart_NetmedsMembershiplink;
	}


	public WebElement getCart_NetmedsMembership() {
		return cart_NetmedsMembership;
	}
	@FindBy(xpath="//div[@class='cart-rightside col-md-4']/div/a")
	private WebElement cart_netmedsfirsticon;

	public WebElement getCart_netmedsfirsticon() {
		return cart_netmedsfirsticon;
	}


	public WebElement getCart_Netmedscontent() {
		return cart_Netmedscontent;
	}
	@FindBy(xpath="//div[@class='discountcol mobicpnmain d-none d-sm-block']/div/div/span")
	private WebElement Cart_promo_code;
	public WebElement getCart_promo_code() {
		return Cart_promo_code;
	}
	
	@FindBy(xpath="//span[@id='cart_netpay_amt1']")
	private WebElement Cart_TotalPay;
	public WebElement getCart_TotalPay() {
		return Cart_TotalPay;
	}
	public List<WebElement> getPromocode() {
		return promocode;
	}
	@FindBy(xpath="//li[@id='coupon_popup_1']/div/input[@class='rdbtn auto_apply_coupon_popup']")
	private List<WebElement> promocode;
	@FindBy(xpath="//a[@class='logout-link ng-star-inserted']")
	private WebElement logout;
	public WebElement getLogout() {
		return logout;
	}
}
