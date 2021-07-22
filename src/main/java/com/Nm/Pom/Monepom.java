package com.Nm.Pom;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "(//div[@class=\"pro-qty qty-upt-evt ng-star-inserted\"]//select[@name='quantity'])[2]")
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


//****************************Your Account************************************************************************

	//Refer and Earn//
	
	@FindBy(xpath = "//a[@href='/customer/invitation/send']")
	private WebElement Referearnpage;
	public WebElement getReferearnpage() {
		return Referearnpage;
	}


	public WebElement getSharelink() {
		return sharelink;
	}
	@FindBy(xpath = "//h3[.=\"Grab your\"]")
	private WebElement Grabyour;
	public WebElement getGrabyour() {
		return Grabyour;
	}
	
	@FindBy (xpath = "//h2[.=\"Instant Rewards\"]")
	private WebElement Instantrewards;
	public WebElement getInstantrewards() {
		return Instantrewards;
	}
	
	@FindBy (xpath = "//p[.=\"A simpler way to earn and get discounts\"]")
	private WebElement simplerway_txt;

	public WebElement getSimplerway_txt() {
		return simplerway_txt;
	}
	@FindBy (xpath = "//h4[.=\"Invite your friends and family\"]")
	private WebElement invite;
	public WebElement getInvite() {
		return invite;
	}

	@FindBy (xpath = "//p[.=\"share the Netmeds app download link & Referral code with your friends and family\"]")
	private WebElement share_netemed_app_txt;

	public WebElement getShare_netemed_app_txt() {
		return share_netemed_app_txt;
	}
	@FindBy (xpath = "//h4[.=\"You get\"]")
	private WebElement Youget_txt;
	public WebElement getYouget_txt() {
		return Youget_txt;
	}

	@FindBy (xpath = "//span[.=\"NMS SuperCash\"]")
	private WebElement NMSSupercash_txt;
	public WebElement getNMSSupercash_txt() {
		return NMSSupercash_txt;
	}
	
	@FindBy (xpath = "//h4[.=\"Your Friends Get\"]")
	private WebElement yourfrndsget_txt;
	public WebElement getYourfrndsget_txt() {
		return yourfrndsget_txt;
	}
	
	@FindBy (xpath = "//p[.=\"Flat 20% off + 20% NMS SuperCash on their first order (minimum order value Rs.500)\"]")
	private WebElement flat20offer_txt;
	public WebElement getFlat20offer_txt() {
		return flat20offer_txt;
	}
	
	@FindBy(xpath = "//div[.=\"Your Referral Code\"]")
	private WebElement yourreferralcode;
	public WebElement getYourreferralcode() {
		return yourreferralcode;
	}
	
	@FindBy(xpath = "//div[.=\"TEST1932\"]")
	private WebElement yourreferralcodenumber;
	public WebElement getYourreferralcodenumber() {
		return yourreferralcodenumber;
	
	}

	@FindBy(xpath = "//a[@id = \"referral\"]")
	private WebElement sharelink;
	public WebElement getsharelink() {
		return sharelink;
}

	@FindBy(xpath = "//p[@class = \"termsconditon\"]")
	private WebElement Termscondition_link;
	public WebElement getTermscondition_link() {
		return Termscondition_link;
}
	
	@FindBy(xpath = "//h3[.='Refer & Earn']")
	private WebElement referearnpage_TC;
	public WebElement getReferearnpage_TC() {
		return referearnpage_TC;
	}
	
	@FindBy(xpath = "//strong[.='TERMS AND CONDITIONS - Netmeds Refer & Earn Programme']")
	private WebElement Termsandcondition;
	public WebElement getTermsandcondition() {
		return Termsandcondition;
	}
	
	//DeliverAddressSection//
	
	@FindBy(xpath = "//a[@class=\"address-link\"]")
	private WebElement Deliveryaddress;
	public WebElement getDeliveryaddress() {
		return Deliveryaddress;
	}
	
	@FindBy(xpath ="(//input[@name= \"customeraddress\"])[2]")
	private WebElement Slctaddress;
	public WebElement getSlctaddress() {
		return Slctaddress;
	}
	@FindBy(xpath="(//a[@class=\"outline-btn\"])[4]")
	private WebElement modifyaddress;
	public WebElement getModifyaddress() {
		return modifyaddress;
	}
	
	@FindBy(xpath = "//input[@id=\"pin\"]")
	private WebElement Addpincode;
	public WebElement getAddpincode() {
		return Addpincode;
	}
	
	@FindBy(xpath = "(//input[@id=\"firstname\"])[2]")
	private WebElement Addfirstname;
	public WebElement getAddfirstname() {
		return Addfirstname;
	}
	
	@FindBy(xpath ="(//input[@id=\"lastname\"])[2]")
	private WebElement Addlastname;
	public WebElement getAddlastname() {
		return Addlastname;
	}
	
	@FindBy(xpath="(//input[@id=\"street\"])")
	private WebElement Addstreet;
	public WebElement getAddstreet() {
		return Addstreet;
	}
	
	@FindBy(xpath="//input[@id=\"landmark\"]")
	private WebElement Addlandmark;
	public WebElement getAddlandmark() {
		return Addlandmark;
	}
	
	@FindBy(xpath ="//button[.=\"Save Address\"]")
	private WebElement Saveaddressbtn;
	public WebElement getSaveaddressbtn() {
		return Saveaddressbtn;
	}
	@FindBy(xpath ="(//a[@class=\"second-btn ng-star-inserted\"])[3]")
	private WebElement dltaddress;
	public WebElement getDltaddress() {
		return dltaddress;
	}
	
	@FindBy(xpath ="//a[@class=\"add-address ng-star-inserted\"]")
	private WebElement Addaddress;
	public WebElement getAddaddress() {
		return Addaddress;
	}
	
	//My Wallet//
	
	
	@FindBy(xpath ="//a[@href= \"/customer/nmswallet\"]")
	private WebElement Mywallet;
	public WebElement getMywallet() {
		return Mywallet;
	}
	
	@FindBy(xpath ="//div[.='AVAILABLE BALANCE']")
	private WebElement Availablebalance;
	public WebElement getAvailablebalance() {
		return Availablebalance;
	}
	
	@FindBy(xpath="//span[contains(text(),'NMS Cash')]")
	private WebElement NMSCash;
	public WebElement getNMSCash() {
		return NMSCash;
	}
	
	@FindBy (xpath="//a[@class=\"howuse htunmscash\"]")
	private WebElement HwtouseNMScash;
	public WebElement getHwtouseNMScash() {
		return HwtouseNMScash;
	}
	
	@FindBy(xpath="(//button[@class=\"close pull-right\"])[2]")
	private WebElement ClosehwtouseNMScash;
	public WebElement getClosehwtouseNMScash() {
		return ClosehwtouseNMScash;
	}
	
	@FindBy(xpath="//span[contains(text(),'NMS Super Cash ')]")
	private WebElement NMSSupercash;
	public WebElement getNMSSupercash() {
		return NMSSupercash;
	}
	
	@FindBy(xpath ="//a[@class=\"howuse htusprcash\"]")
	private WebElement HwtouseNMSsupercash;
	public WebElement getHwtouseNMSsupercash() {
		return HwtouseNMSsupercash;
	}
	
	@FindBy (xpath="(//button[@class=\"close pull-right\"])[3]")
	private WebElement ClosehwtouseNMSsupercash;
	public WebElement getClosehwtouseNMSsupercash() {
		return ClosehwtouseNMSsupercash;
	}
	
	//edit profile//
	@FindBy (xpath="//div[.='LOGIN INFORMATION']")
	private WebElement LoginInformation;
	public WebElement getLoginInformation() {
		return LoginInformation;
	}
	
	@FindBy (xpath="//div[.='PERSONAL INFORMATION']")
	private WebElement Personalinfo;
	public WebElement getPersonalinfo() {
		return Personalinfo;
	}
	
	@FindBy (xpath = "//div[.='EMAIL']")
	private WebElement Email;
	public WebElement getEmail() {
		return Email;
	}
	
	@FindBy (xpath = "//div[.='FULL NAME']")
	private WebElement Fullname;
	public WebElement getFullname() {
		return Fullname;
	}
	
	@FindBy(xpath ="//div[.='MOBILE NUMBER']")
	private WebElement Mobilenumber;
	public WebElement getMobilenumber() {
		return Mobilenumber;
	}
	
	@FindBy(xpath ="//div[.='GENDER']")
	private WebElement Gender;
	public WebElement getGender() {
		return Gender;
	}
	@FindBy (xpath ="//a[.='Modify']")
	private WebElement Modifybtn;
	public WebElement getModifybtn() {
		return Modifybtn;
	}
	
	@FindBy(xpath ="(//input[@id=\"firstname\"])[1]")
	private WebElement Firstname;
	public WebElement getFirstname() {
		return Firstname;
	}
	
	@FindBy (xpath ="(//input[@id=\"lastname\"])[1]")
	private WebElement Lastname;
	public WebElement getLastname() {
		return Lastname;
	}
	
	@FindBy(id ="date_of_birth")
	private WebElement DOB;
	public WebElement getDOB() {
		return DOB;
	}
	
	@FindBy(xpath = "//div[@class=\"mat-calendar-arrow\"]")
	private WebElement calendar;
	public WebElement getCalendar() {
		return calendar;
	}
	
	@FindBy (xpath ="(//div[@class=\"mat-calendar-body-cell-content\"])[23]")
	private WebElement Year;
	public WebElement getYear() {
		return Year;
	}
	
	@FindBy(xpath = "(//div[@class=\"mat-calendar-body-cell-content\"])[6]")
	private WebElement Month;
	public WebElement getMonth() {
		return Month;
	}
	
	@FindBy (xpath = "(//div[@class=\"mat-calendar-body-cell-content\"])[12]")
	private WebElement Date;
	public WebElement getDate() {
		return Date;
	}
	
	@FindBy (xpath = "//div[@class='mat-select-value']")
	private WebElement genderselect;
	public WebElement getGenderselect() {
		return genderselect;
	}
	
	@FindBy (xpath = "(//span[@class=\"mat-option-text\"])[2]")
	private WebElement genderselection;
	public WebElement getGenderselection() {
		return genderselection;
	}
	
	@FindBy (xpath ="//button[.='Save Changes']")
	private WebElement Savechanges;
	public WebElement getSavechanges() {
		return Savechanges;
	}
	
	//Contact Us//
	
	@FindBy (xpath ="//a[@class=\"contactus-link\"]")
	private WebElement Contactus;
	public WebElement getContactus() {
		return Contactus;
	}
	
	@FindBy (xpath = "//span[.='How would you like us to contact you?*']")
	private WebElement Howtocontact;
	public WebElement getHowtocontact() {
		return Howtocontact;
	}
	
	@FindBy (xpath ="//label[@class=\"below-msg-damage\"]")
	private WebElement damged_item_mail;
	public WebElement getDamged_item_mail() {
		return damged_item_mail;
	}
	
	@FindBy (xpath ="//label[@class=\"below-msg-Incomplete\"]")
	private WebElement missing_item_email;
	public WebElement getMissing_item_email() {
		return missing_item_email;
	}
	
	
	@FindBy (xpath = "//span[.='Purpose of Contact*']")
	private WebElement Purposetext;
	public WebElement getPurposetext() {
		return Purposetext;
	}
	
	@FindBy(xpath ="//span[.='Please state your message here*']")
	private WebElement Message;
	public WebElement getMessage() {
		return Message;
	}
	
	@FindBy (xpath ="//textarea[@id='comments']")
	private WebElement Addcomments;
	public WebElement getAddcomments() {
		return Addcomments;
	}
	
	@FindBy (xpath = "//*[@id=\"contact-form\"]/div[2]/div/div/label/span")
	private WebElement copyme;
	public WebElement getCopyme() {
		return copyme;
	}
	
	@FindBy (xpath = "//button[@class=\"pink-btn contact-submit\"]")
	private WebElement contactus_submit;
	public WebElement getContactus_submit() {
		return contactus_submit;
	}
	
	//My Prescription//
	
	@FindBy (xpath ="//a[@class =\"myprescription-link ng-star-inserted\"]")	
	private WebElement myprescription_page;
	public WebElement getMyprescription_page() {
		return myprescription_page;
	}
	
	@FindBy (xpath="(//div[@class=\"order-id\"])[1]")
	private WebElement Order_ID;
	public WebElement getOrder_ID() {
		return Order_ID;
	}
	
	@FindBy(xpath ="(//span[.=\"Date :\"])[1]")
	private WebElement PrescriptionDate;
	public WebElement getPrescriptionDate() {
		return PrescriptionDate;
	}
	
	@FindBy(xpath = "(//span[.=\"Prescription Status :\"])[1]")
	private WebElement PrescriptionStatus;
	public WebElement getPrescriptionStatus() {
		return PrescriptionStatus;
	}
	
	@FindBy(xpath = "(//span[.=\"Order Status : \"])[1]")
	private WebElement OrderStatus;
	public WebElement getOrderStatus() {
		return OrderStatus;
	}
	
	@FindBy(xpath = "(//img[@class =\"rxviewimg\"])[1]")
	private WebElement prescription_image;
	public WebElement getPrescription_image() {
		return prescription_image;
	}
	
	@FindBy(xpath = "(//a[@class =\"download-link\"])[1]")
	private WebElement prescription_download;
	public WebElement getPrescription_download() {
		return prescription_download;
	}
	
	@FindBy(xpath ="//button[@class =\"close\"]")
	private WebElement close_image;
	public WebElement getClose_image() {
		return close_image;
	}
	
	//help page//
	
	@FindBy(xpath = "//a[@class=\"help-link\"]")
	private WebElement Helppage;
	public WebElement getHelppage() {
		return Helppage;
	}
	
	
	@FindBy (xpath = "//div[@class='left_content']//ul//li//a")
	private List<WebElement>  leftside_Link;
	public List<WebElement> getLeftside_Link() {
		return leftside_Link;
	}
	
	@FindBy (xpath = "//a[@class=\"need-btn\"]")
	private WebElement still_need_help;
	public WebElement getStill_need_help() {
		return still_need_help;
	}
	
	//Legal Information
	
	@FindBy(xpath = "(//a[@class=\"legal-link\"])[1]")
	private WebElement legalinfo;
	public WebElement getLegalinfo() {
		return legalinfo;
	}
	
	@FindBy (xpath ="//p[@class=\"atag\"]")
	private WebElement netmedspharmacy;
	public WebElement getNetmedspharmacy() {
		return netmedspharmacy;
	}
	
	@FindBy(xpath = "//h3[.=\"Terms and Conditions\"]")
	private WebElement termsandcondition_txt;
	public WebElement getTermsandcondition_txt() {
		return termsandcondition_txt;
	}
	@FindBy (xpath ="//b[.=\"Contact Information\"]")	
	private WebElement contact_info;
	public WebElement getContact_info() {
		return contact_info;
	}
	
	@FindBy (xpath ="//a[@href=\"/contact-us\"]")
	private WebElement contactus_link;
	public WebElement getContactus_link() {
		return contactus_link;
	}

	//a[contains(text()," for any questions or comments regarding these Terms and Conditions. ")]
	
	
	//Rateus
	
	
	
	
	
	@FindBy (xpath = "(//a[@Class=\"legal-link\"])[2]")
	private WebElement Rateus;
	public WebElement getRateus() {
		return Rateus;
	}
	@FindBy (xpath ="//div[.=\"RATE NETMEDS\"]" )
	private WebElement RateNedmeds_text;
	public WebElement getRateNedmeds_text() {
		return RateNedmeds_text;
	}
	
	@FindBy (xpath = "//label[@class=\"star star-1 ng-star-inserted\"]")
	private WebElement Star1;
	public WebElement getStar1() {
		return Star1;
	}
	
	@FindBy (xpath = "//label[@class=\"star star-2 ng-star-inserted\"]")
	private WebElement Star2;
	public WebElement getStar2() {
		return Star2;	
		
	}
	
	@FindBy (xpath = "//label[@class=\"star star-3 ng-star-inserted\"]")
	private WebElement Star3;
	public WebElement getStar3() {
		return Star3;	
}	
	
	@FindBy (xpath = "//label[@class=\"star star-4 ng-star-inserted\"]")
	private WebElement Star4;
	public WebElement getStar4() {
		return Star4;	
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

	


	
	
	@FindBy (xpath = "//label[@class=\"star star-5 ng-star-inserted\"]")
	private WebElement Star5;
	public WebElement getStar5() {
		return Star5;	
}
	
	@FindBy(xpath ="//div[@class=\"msg-txt\"]")
	private WebElement suggestions_txt;
	public WebElement getSuggestions_txt() {
		return suggestions_txt;
	}
	
	
	
	@FindBy (xpath ="//textarea[@class=\"msg\"]")
	private WebElement sugesstion_msg;
	public WebElement getSugesstion_msg() {
		return sugesstion_msg;
	}
	
	@FindBy (xpath = "//button[@class=\"primary-btn\"]")
	private WebElement Submitmsg;
	public WebElement getSubmitmsg() {
		return Submitmsg;
	}
	
	@FindBy (xpath ="//a[contains(text(),\" for any questions or comments regarding these Terms and Conditions. \")]")
	private WebElement contactus_legal;
	public WebElement getContactus_legal() {
		return contactus_legal;
	}
	
	@FindBy (xpath ="(//a[@href=\"mailto:cs@netmeds.com\"])[2]")
	private WebElement csnetmeds;
	public WebElement getCsnetmeds() {
		return csnetmeds;
	}
	
	//***************************************Cart Page***************************************************************//
	
	@FindBy (xpath = "//div[@class=\"swiper-button-next\"]")
	private WebElement swipe_right;
	public WebElement getSwipe_right() {
		return swipe_right;
	}
	

	@FindBy (xpath = "//div[@class=\"swiper-button-prev\"]")
	private WebElement swipe_prev;
	public WebElement getSwipe_prev() {
		return swipe_prev;
	}
	
	
	@FindBy(xpath ="//a[.=\"Continue Shopping\"]")
	private WebElement continue_shopping;
	public WebElement getContinue_shopping() {
		return continue_shopping;
	}
	
	@FindBy(xpath ="//span[.=\"Most Selling Products\"]")
	private WebElement Most_Selling_products;
	public WebElement getMost_Selling_products() {
		return Most_Selling_products;
	}
	
	@FindBy (xpath = "(//div[@class=\"add ng-star-inserted\"])[4]")
	private WebElement Most_selling_Addtocart;
	public WebElement getMost_selling_Addtocart() {
		return Most_selling_Addtocart;
	}
	
	@FindBy(id ="cart_sub_total")
	private WebElement totalmrp;
	public WebElement getTotalmrp() {
		return totalmrp;
	}
	
	@FindBy(id ="cart_netpay_amt1")
	private WebElement Total_amount;
	public WebElement getTotal_amount() {
		return Total_amount;
	}
	
	@FindBy(xpath= "//input[@class='rdbtn auto_apply_coupon_popup']")
	private List<WebElement> Promo;
	public List<WebElement> getPromo() {
		return Promo;
	}
	



//***********************************************Upload\attach\past rx scenarios********************************************************************

	@FindBy(xpath = "//input[@accept='image/png,image/gif,image/jpeg']")
	private WebElement uploadpresc;
	public WebElement getUploadpresc() {
		return uploadpresc;
	}
	
	@FindBy (xpath ="(//a[@class=\"cusup-delete\"])")
	private WebElement deletepresc;
	public WebElement getDeletepresc() {
		return deletepresc;
	}
	

	@FindBy(xpath ="//ul[@class='d-flex justify-content-center']//span[@class='pastrx-icon']")
	private WebElement pastrx;
	public WebElement getPastrx() {
		return pastrx;
	}
	
//******************************************Search and Alternate Brands and Most Selling Product*********************************************************//
	
	

	
	//Search
	 @FindBy(id="product-addtocart-button")
	 private WebElement Search_AddtoCart_btn;
	public WebElement getSearch_AddtoCart_btn() {
		return Search_AddtoCart_btn;
	}
	
	
	@FindBy(xpath = "//button[@class='qtybtn qty_add qty_plus']")
	private WebElement Search_IncreaseQuantity_btn;
	public WebElement getSearch_IncreaseQuantity_btn() {
		return Search_IncreaseQuantity_btn;
	}
	
	@FindBy(xpath = "//button[@class='qtybtn qty_add qty_minus prodminus']")
	private WebElement Search_DecreaseQuantity_btn;
	public WebElement getSearch_DecreaseQuantity_btn() {
		return Search_DecreaseQuantity_btn;
	}
	
	
	@FindBy(xpath = "//div[contains(text(),' Add to Cart ')]")
	private List<WebElement> Most_Selling_AddToCart;
	public List<WebElement> getMost_Selling_AddToCart() {
		return Most_Selling_AddToCart;
	}
	
	
	@FindBy(xpath = "//a[@class='productname']")
	private List<WebElement> Most_Selling_ProductName;
	public List<WebElement> getMost_Selling_ProductName() {
		return Most_Selling_ProductName;
	}
	
	
	@FindBy(xpath = "//div[@class='info']")
	private WebElement Search_Product_Info;
	public WebElement getSearch_Product_Info() {
		return Search_Product_Info;
	}
	
	
	@FindBy(xpath = "//button[@title='Add to Cart']")
	private WebElement Alternate_AddToCart;
	public WebElement getAlternate_AddToCart() {
		return Alternate_AddToCart;
	}
	
	
	
	
	
}