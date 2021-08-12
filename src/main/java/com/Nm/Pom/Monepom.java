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
	@FindBy(xpath="//button[text()='USE PASSWORD']")
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
	@FindBy(xpath="//div[@class='process-checkout col-7 pl-1 ng-star-inserted']/button|//button[@class=\"btn-checkout btn btn_to_checkout m-0 ng-star-inserted\"]")
	private WebElement paybutton;
	@FindBy(xpath="//span[@class='title col-md-4']")
	private WebElement paydeatailText;
	@FindBy(xpath="//a[text()='Remove']")
	private WebElement Removebutton;
	public WebElement getRemovebutton() {
		return Removebutton;
	}
	public WebElement getAMAZONPAY_paybutton() {
		return AMAZONPAY_paybutton;
	}


	public WebElement getSIMPL_paybutton() {
		return SIMPL_paybutton;
	}


	public WebElement getFREECHARGE_paybutton() {
		return FREECHARGE_paybutton;
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
	
	@FindBy(xpath="//button[contains(text(),\"CREATE NEW REFILL\")]|//a[@class =\"refillbtn\"]|//button[.=\"CREATE NEW SUBSCRIPTION\"]")
	private WebElement createnewfill;
	
	public WebElement getCreatenewfill() {
		return createnewfill;
	}
	
	@FindBy(xpath ="//ais-search-box[@class='searchinner']//input[@placeholder='Search here...']")
	private WebElement m3productsearch;
	
	public WebElement getM3productsearch() {
		return m3productsearch;
	}
	@FindBy(xpath ="//a[normalize-space()='View cart']|//a[@class =\"view-subscription\"]")
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
	
	@FindBy(xpath = "//button[contains(text(),\"Select Duration\")]|//button[.=\"Schedule Delivery\"]")
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
	
	@FindBy(xpath ="(//button[contains(.,'My Subscription')])[2]|(//button[.=\"My Subscription\"])[2]")
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
	@FindBy(xpath="//h5[text()='Additional 5% off on Pathology Lab Tests']|//h5[text()='Additional 5% off on Lab Tests']")
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
	@FindBy (xpath = "//h4[.=\"Invite your friends and family\"]|//h4[.=\"Invite your friends and families\"]")
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
	
	@FindBy(xpath = "//div[.=\"TEST1932\"]|//div[.=\"Infinite\"]")
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
	
	
	//@FindBy(xpath= "//input[@class=\"rdbtn auto_apply_coupon_popup\"]")
	@FindBy(xpath="//input[@id=\"webcoupon_1\"]")
	private List<WebElement> Promo;
	public List<WebElement> getPromo() {
		return Promo;
	}
	
	@FindBy(xpath= "//input[@id='nms_paytm']")
	private WebElement paytm_payment;
	@FindBy(xpath= "//input[@id='nms_mobikwik']")
	private WebElement mobikwik_payment;
	@FindBy(xpath= "//input[@id='nms_simpl']")
	private WebElement simpl_payment;
	@FindBy(xpath= "//input[@id='nms_amazonpay']")
	private WebElement amazonpay_payment;
	@FindBy(xpath= "//input[@id='nms_freecharge']")
	private WebElement freecharge_payment;
	@FindBy(xpath= "//input[@id='nms_phonepe']")
	private WebElement phonepe_payment;
	@FindBy(xpath= "//input[@id='nms_googlepay']")
	private WebElement googlepay_payment;
	@FindBy(xpath= "//input[@id='nmspay_card_0_555153']")
	private WebElement cart_payment;
	@FindBy(xpath= "//button[@class='float-right process-orderplace col-md-4 col-12']")
	private WebElement pay_button;
	@FindBy(xpath= "//div[@class='retry']")
	private WebElement payment_retry;
	public WebElement getPayment_retry() {
		return payment_retry;
	}


	public WebElement getPay_button() {
		return pay_button;
	}


	public WebElement  getPaytm_payment() {
		return paytm_payment;
	}


	public WebElement  getMobikwik_payment() {
		return mobikwik_payment;
	}


	public WebElement  getSimpl_payment() {
		return simpl_payment;
	}


	public WebElement  getAmazonpay_payment() {
		return amazonpay_payment;
	}


	public WebElement  getFreecharge_payment() {
		return freecharge_payment;
	}


	public WebElement  getPhonepe_payment() {
		return phonepe_payment;
	}


	public WebElement  getGooglepay_payment() {
		return googlepay_payment;
	}


	public WebElement  getCart_payment() {
		return cart_payment;
	}
	@FindBy(xpath= "//div[@id='title_PAYTM']/div/div/div[3]/div/button")
	private WebElement paytm_paymentutton;
	@FindBy(xpath= "//div[@id='title_MOBIKWIK']/div/div/div[3]/div/button")
	private WebElement mobikiwik_paymentutton;
	public WebElement getMobikiwik_paymentutton() {
		return mobikiwik_paymentutton;
	}


	public WebElement getPaytm_paymentutton() {
		return paytm_paymentutton;
	}
	@FindBy(xpath= "//input[@id='nms_simpl']")
	private WebElement simply_pay;
	@FindBy(xpath= "//input[@id='nms_amazonpay']")
	private WebElement amazon_pay;
	@FindBy(xpath= "//input[@id='nms_freecharge']")
	private WebElement freecharge_pay;
	@FindBy(xpath= "//input[@id='nms_phonepe']")
	private WebElement phonepe_pay;
	public WebElement getPHONEPE_paybutton() {
		return PHONEPE_paybutton;
	}


	public WebElement getGOOGLEPAY_paybutton() {
		return GOOGLEPAY_paybutton;
	}
	@FindBy(xpath= "//input[@id='nms_googlepay']")
	private WebElement googlepay_pay;
	@FindBy(xpath= "//input[contains(@id, 'nmspay_card')]")
	private WebElement cart_pay;
	@FindBy(xpath= "//*[@id='credit&debitcards']/div[2]/div/div[1]/div/div/div[2]/div[2]/button")
	private WebElement cart_paymentutton;
	@FindBy(xpath= "//a[@id='newcardlink']")
	private WebElement Add_new_cart;
	@FindBy(xpath= "//*[@id='title_AMAZONPAY']/div/div/div[3]/div/button")
	private WebElement AMAZONPAY_paybutton;
	@FindBy(xpath= "//*[@id='title_SIMPL']/div/div/div[3]/div/button")
	private WebElement SIMPL_paybutton;
	@FindBy(xpath= "//*[@id='title_FREECHARGE']/div/div/div[3]/div/button")
	private WebElement FREECHARGE_paybutton;
	@FindBy(xpath= "//*[@id='title_PHONEPE']/div/div/div[3]/div/button")
	private WebElement PHONEPE_paybutton;
	@FindBy(xpath= "//*[@id='title_GOOGLEPAY']/div/div/div[3]/div/button")
	private WebElement GOOGLEPAY_paybutton;
	@FindBy(xpath= "//label[@for='nms_nb_axis']/img")
	private WebElement axis_bank;
	@FindBy(xpath= "//label[@for='nms_nb_hdfc']/img")
	private WebElement hdfc_bank;
	@FindBy(xpath= "//label[@for='nms_nb_icici']/img")
	private WebElement icici_bank;
	@FindBy(xpath= "//label[@for='nms_nb_kotak']/img")
	private WebElement kotak_bank;
	@FindBy(xpath= "//label[@for='nms_nb_sbi']/img")
	private WebElement SBI_bank;
	@FindBy(xpath= "//input[@id='nmscash']")
	private WebElement nmscash;
	@FindBy(xpath= "//button[@class='action-cod']")
	private WebElement cod_popoup;
	public WebElement getCod_popoup() {
		return cod_popoup;
	}


	public WebElement getNmscash() {
		return nmscash;
	}


	public WebElement getHdfc_bank() {
		return hdfc_bank;
	}


	public WebElement getIcici_bank() {
		return icici_bank;
	}


	public WebElement getKotak_bank() {
		return kotak_bank;
	}


	public WebElement getSBI_bank() {
		return SBI_bank;
	}


	public WebElement getMore_banks() {
		return More_banks;
	}
	@FindBy(xpath= "//*[@id='netbank_list']")
	private WebElement More_banks;
	public WebElement getAxis_bank() {
		return axis_bank;
	}


	public WebElement getSimply_pay() {
		return simply_pay;
	}


	public WebElement getAmazon_pay() {
		return amazon_pay;
	}


	public WebElement getFreecharge_pay() {
		return freecharge_pay;
	}


	public WebElement getPhonepe_pay() {
		return phonepe_pay;
	}


	public WebElement getGooglepay_pay() {
		return googlepay_pay;
	}


	public WebElement getCart_pay() {
		return cart_pay;
	}


	public WebElement getCart_paymentutton() {
		return cart_paymentutton;
	}


	public WebElement getAdd_new_cart() {
		return Add_new_cart;
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
	

	//PDP PAGE
	@FindBy(xpath = "//div[@class='product-detail']")
	private WebElement PDP_ProductDetail;
	public WebElement getPDP_ProductDetail() {
		return PDP_ProductDetail;
	}
	
	
	
	@FindBy(xpath = "//h3[contains(text(),'OFFERS APPLICABLE')]")
	private List<WebElement> PDP_OfferText;
	public List<WebElement> getPDP_OfferText() {
		return PDP_OfferText;
	}
	
	@FindBy(xpath = "//span[@class='off_save']")
	private WebElement PDP_OfferPercentage;
	public WebElement getPDP_OfferPercentage() {
		return PDP_OfferPercentage;
	}
	
	
	@FindBy(xpath = "//div[contains(text(),'Pack of 4')]")
	private List<WebElement> PDP_Pack4_text;
	public List<WebElement> getPDP_Pack4_text() {
		return PDP_Pack4_text;
	}
	
	
	@FindBy(xpath = "(//div[contains(text(),'Pack of 4')]//following::button)[1]")
	private WebElement PDP_Pack4_BuyBtn;
	public WebElement getPDP_Pack4_BuyBtn() {
		return PDP_Pack4_BuyBtn;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Pack of 4')]//following::span[@class='final_price']")
	private WebElement PDP_ComboPack4_Price;
	public WebElement getPDP_ComboPack4_Price() {
		return PDP_ComboPack4_Price;
	}
	
	
	@FindBy(xpath = "//div[contains(text(),'Pack of 2')]")
	private List<WebElement> PDP_Pack2_text;
	public List<WebElement> getPDP_Pack2_text() {
		return PDP_Pack2_text;
	}
	
	
	
	@FindBy(xpath = "(//div[contains(text(),'Pack of 2')]//following::button)[1]")
	private WebElement PDP_Pack2_BuyBtn;
	public WebElement getPDP_Pack2_BuyBtn() {
		return PDP_Pack2_BuyBtn;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Pack of 2')]//following::span[@class='final_price']")
	private WebElement PDP_ComboPack2_Price;
	public WebElement getPDP_ComboPack2_Price() {
		return PDP_ComboPack2_Price;
	}
	
	
	@FindBy(xpath = "//*[@id=\"page-header\"]/div/div/div[5]/a")
	private WebElement UserProfile_btn;
	public WebElement getUserProfile_btn() {
		return UserProfile_btn;
	}
	
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/main/app-account/div[1]/div[3]/div[1]/left-menu/div/div/a[13]")
	private WebElement Logout_btn;
	public WebElement getLogout_btn() {
		return Logout_btn;
	}
	
	
	@FindBy(xpath = "//button[contains(text(),' View Details ')]")
	private List<WebElement> View_DetailsList;
	public List<WebElement> getView_DetailsList() {
		return View_DetailsList;
	}
	//************************************************Order Success Page*****************************************************************//

		@FindBy (xpath = "//div[.=\"RATE YOUR EXPERIENCE\"]")
		private WebElement Rate_your_exp;
		public WebElement getRate_your_exp() {
			return Rate_your_exp;
		}
		
		
		@FindBy(xpath = "//div[@class=\"ordstatus\"]")
		private WebElement order_status;
		public WebElement getOrder_status() {
			return order_status;
		}
		
		@FindBy(xpath = "//div[@class=\"orddesc\"]")
		private WebElement pharmacists_verfication;
		public WebElement getPharmacists_verfication() {
			return pharmacists_verfication;
		}
		
		@FindBy(xpath ="//div[@class=\"ng-star-inserted\"]")
		private WebElement important_update;
		public WebElement getImportant_update() {
			return important_update;
		}
		
		@FindBy(xpath ="//div[@class=\"deltitle\"]")
		private WebElement Deliverby_text;
		public WebElement getDeliverby_text() {
			return Deliverby_text;
		}
		
		@FindBy(xpath = "//div[@class=\"deldate\"]")
		private WebElement delivery_date;
		public WebElement getDelivery_date() {
			return delivery_date;
		}
		
		@FindBy(xpath ="//h5[.=\"GRAB YOUR\"]")
		private WebElement Grab_text;
		public WebElement getGrab_text() {
			return Grab_text;
		}
		
		@FindBy(xpath="//h3[.=\"Free Medicines\"]")
		private WebElement Free_medicines;
		public WebElement getFree_medicines() {
			return Free_medicines;
		}
		
		@FindBy(xpath ="//p[.=\"Invite your friends and get\"]")
		private WebElement invite_friends;
		public WebElement getInvite_friends() {
			return invite_friends;
		}
		
		@FindBy (xpath ="//div[.=\"TEST1932\"]")
		private WebElement offer_code;
		public WebElement getOffer_code() {
			return offer_code;
		}
		
		@FindBy (xpath ="//a[.=\"Tap to share Code with your friends\"]")
		private WebElement share_with_friends;
		public WebElement getShare_with_friends() {
			return share_with_friends;
		}
		
		@FindBy (xpath ="(//h3[.=\"Benefits\"])[2]")	
		private WebElement Benefits;
		public WebElement getBenefits() {
			return Benefits;
		}
		
		@FindBy(xpath ="(//div[.=\"Automatic monthly order\"])[2]")
		private WebElement Auto_monthly_order;
		public WebElement getAuto_monthly_order() {
			return Auto_monthly_order;
		}
		
		@FindBy(xpath ="(//div[.=\"1 month FREE*\"])[2]")
		private WebElement monthfree;
		public WebElement getMonthfree() {
			return monthfree;
		}
		
		@FindBy(xpath ="(//a[@class=\"subscribe\"])[3]")
		private WebElement Subscription;
		public WebElement getSubscription() {
			return Subscription;
		}
		
		@FindBy(xpath ="//h4[.=\"Never miss your Medicines\"]")
		private WebElement Never_miss_your_Medicines;
		public WebElement getNever_miss_your_Medicines() {
			return Never_miss_your_Medicines;
		}
		
		@FindBy(xpath ="//p[@class=\"deliver-cnt\"]")
		private WebElement refill_msg;
		public WebElement getRefill_msg() {
			return refill_msg;
		}
		
		@FindBy(xpath = "//span[.=\"Payment Mode\"]")
		private WebElement paymentmode_text;
		public WebElement getPaymentmode_text() {
			return paymentmode_text;
		}
		
		@FindBy(xpath ="//span[.=\"Online Payment / COD \"]")
		private WebElement paymentmethod_text;
		public WebElement getPaymentmethod_text() {
			return paymentmethod_text;
		}
		
		@FindBy(xpath ="//p[.=\"Payment link will be generated every month.\"]")
		private WebElement paymentlink_text;
		public WebElement getPaymentlink_text() {
			return paymentlink_text;
		}
		
		@FindBy(xpath ="//span[.=\"Promo Code\"]")
		private WebElement promocode_text;
		public WebElement getPromocode_text() {
			return promocode_text;
		}
		
		@FindBy(xpath ="//span[.=\"SUBS20\"]")
		private WebElement promocode_subs20;
		public WebElement getPromocode_subs20() {
			return promocode_subs20;
		}
		
		
		@FindBy(xpath ="//p[@class=\"promo-txt\"]")
		private WebElement Promo_percentage;
		public WebElement getPromo_percentage() {
			return Promo_percentage;
		}
		
		@FindBy(xpath ="//p[@class=\"modify-txt\"]")
		private WebElement modify_or_reschedule;
		public WebElement getModify_or_reschedule() {
			return modify_or_reschedule;
		}
		
		//************************************************My Orders Page****************************************************************//
		
				@FindBy(xpath = "(//h3[@class=\"title\"])[1]")
				private WebElement OrderDetails_text;
				public WebElement getOrderDetails_text() {
					return OrderDetails_text;
				}
				
				@FindBy(xpath ="(//h3[@class=\"title\"])[2]")
				private WebElement Delivery_address_text;
				public WebElement getDelivery_address_text() {
					return Delivery_address_text;
				}
				
				@FindBy(xpath ="(//div[@class=\"col-lg-5 col-5 pl-0\"])[1]")
				private WebElement customer_name_text;
				public WebElement getCustomer_name_text() {
					return customer_name_text;
				}
				
				@FindBy(xpath ="(//div[@class=\"col-lg-5 col-5 pl-0\"])[2]")
				private WebElement OrderId_text;
				public WebElement getOrderId_text() {
					return OrderId_text;
				}
				
				@FindBy(xpath ="(//div[@class=\"col-lg-5 col-5 pl-0\"])[3]")
				private WebElement Order_placed_text;
				public WebElement getOrder_placed_text() {
					return Order_placed_text;
				}
				
				@FindBy(xpath ="(//div[@class=\"col-lg-7 col-7 p-0 text-right\"])[1]")
				private WebElement customer_name;
				public WebElement getCustomer_name() {
					return customer_name;
				}
				
				
				@FindBy(xpath ="(//div[@class=\"col-lg-7 col-7 p-0 text-right\"])[2]")
				private WebElement order_number;
				public WebElement getOrder_number() {
					return order_number;
				}
				
				
				@FindBy(xpath = "(//div[@class=\"col-lg-7 col-7 p-0 text-right\"])[3]")
				private WebElement order_placed_date;
				public WebElement getOrder_placed_date() {
					return order_placed_date;
				}
				
				
				@FindBy(xpath ="(//h4[@class=\"cusname\"])[1]")
				private WebElement cusname;
				public WebElement getCusname() {
					return cusname;
				}
				
				
				@FindBy(xpath = "//div[.=\"Payment Mode\"]")
				private WebElement Payment_mode_text;
				public WebElement getPayment_mode_text() {
					return Payment_mode_text;
				}
				
				@FindBy(xpath ="(//div[@class=\"col-5 pr-0 text-right\"])[3]")
				private WebElement Payment_mode;
				public WebElement getPayment_mode() {
					return Payment_mode;
				}
				
				@FindBy(xpath="//img[@class=\"rxviewimg\"]")
				private WebElement Prescription_open;
				public WebElement getPrescription_open() {
					return Prescription_open;
				}
				
				@FindBy(xpath = "(//button[@class=\"close\"])[3]")
				private WebElement Prescription_closed;
				public WebElement getPrescription_closed() {
					return Prescription_closed;
				}
				
				@FindBy(xpath ="//a[.=\"Show Status Details\"]")
				private WebElement Show_Status_Details;
				public WebElement getShow_Status_Details() {
					return Show_Status_Details;
				}
				
				@FindBy(xpath ="//a[.=\"Need Help\"]")
				private WebElement NeedHelp_page;
				public WebElement getNeedHelp_page() {
					return NeedHelp_page;
				}
				
				@FindBy(xpath ="//a[.=\" Reorder \"]")
				private WebElement Reorder;
				public WebElement getReorder() {
					return Reorder;
				}
				
//***********************************************************Offers Page***************************************************************************
				
				@FindBy(xpath ="//a[@href=\"/offers\"]")
				private WebElement offer_page;
				public WebElement getOffer_page() {
					return offer_page;
				}
				
				@FindBy(xpath ="(//button[@class=\"copy_code_btn\"])[1]")
				private WebElement copy_code;
				public WebElement getCopy_code() {
					return copy_code;
				}
				
				@FindBy(xpath ="//span[@class=\"arricon downarrow\"]")
				private WebElement Promo_apply;
				public WebElement getPromo_apply() {
					return Promo_apply;
				}
				
				@FindBy(xpath = "(//input[@id=\"couponcode\"])[1]")
				private WebElement coupon_code;
				public WebElement getCoupon_code() {
					return coupon_code;
				}
				
				@FindBy(xpath ="(//button[@class=\"apply-coupon\"])[1]")
				private WebElement apply_code;
				public WebElement getApply_code() {
					return apply_code;
				}
				
				
				@FindBy(xpath = "(//input[@class=\"offer-checkbox\"])[1]")
				private WebElement medicine_checkbox;
				public WebElement getMedicine_checkbox() {
					return medicine_checkbox;
				}
				
				
				@FindBy(xpath = "(//input[@class=\"offer-checkbox\"])[2]")
				private WebElement Diagnostics_checkbox;
				public WebElement getDiagnostics_checkbox() {
					return Diagnostics_checkbox;
				}
				
				@FindBy(xpath = "(//input[@class=\"offer-checkbox\"])[3]")
				private WebElement Consultation_checkbox;
				public WebElement getConsultation_checkbox() {
					return Consultation_checkbox;
				}
			
				@FindBy(xpath="//div[@class='prodname']")
				private List<WebElement> orderreview_productList;
				@FindBy(xpath="//p[@class='form m-0']")
				private List<WebElement> orderreview_mfr;
				@FindBy(xpath="//span[@class='sellerinfo']")
				private List<WebElement> orderreview_sellerinfo;
				@FindBy(xpath="//div[@class='row m-0 qtydelinfomain ng-star-inserted']/div[1]")
				private List<WebElement> orderreview_quantity;
				@FindBy(xpath="//div[@class='row m-0 qtydelinfomain ng-star-inserted']/div[1]/span")
				private List<WebElement> orderreview_quantitycount;
				@FindBy(xpath="//div[@class='discount-val']/span")
				private List<WebElement> orderreview_price;
				@FindBy(xpath="//div[@class='deldateinfo col-4 p-0 text-right']/span")
				private List<WebElement> orderreview_exprity_date;
				@FindBy(xpath="//div[@class='addressinfomain']/h5")
				private WebElement orderreview_customerNotes;
				@FindBy(xpath="//textarea[@name='customerNotesByOrder']")
				private WebElement orderreview_textArea;
				@FindBy(xpath="//h4[@class='paymentdetails-title']")
				private WebElement orderreview_paymentdetails;
				@FindBy(xpath="//div[@class='subtoal']/label")
				private WebElement orderreview_mrpTotal;
				@FindBy(xpath="//div[@class='subtoal']/span")
				private WebElement orderreview_mrpTotalprice;
				@FindBy(xpath="//div[@class='shipping-charges ng-star-inserted']/label")
				private WebElement orderreview_Delivery_Charges;
				@FindBy(xpath="//div[@class='shipping-charges ng-star-inserted']/span")
				private WebElement orderreview_Delivery_Chargesprice;
				@FindBy(xpath="//div[@class='net-amount']/label")
				private WebElement orderreview_TotalAmout;
				@FindBy(xpath="//div[@class='net-amount']/span")
				private WebElement orderreview_TotalAmoutprice;
				@FindBy(xpath="//div[@class='totalamt col-5 pr-0']/span[1]")
				private WebElement orderreview_TotalAmoutcontent;
				@FindBy(xpath="//div[@class='totalamt col-5 pr-0']/span[2]")
				private WebElement orderreview_TotalAmoutprices;
				@FindBy(xpath="//button[text()='Review Order']")
				private WebElement orderreview_revieworder;
				@FindBy(xpath="//img[@class='rxviewimg']")
				private WebElement orderreview_rxviewimg;
				@FindBy(xpath="//div[@id='frameModalTop']/div/div/div/button")
				private WebElement orderreview_close;
				public WebElement getOrderreview_close() {
					return orderreview_close;
				}


				public WebElement getOrderreview_rxviewimg() {
					return orderreview_rxviewimg;
				}


				public WebElement getOrderreview_revieworder() {
					return orderreview_revieworder;
				}


				public List<WebElement> getOrderreview_productList() {
					return orderreview_productList;
				}


				public List<WebElement> getOrderreview_mfr() {
					return orderreview_mfr;
				}


				public List<WebElement> getOrderreview_sellerinfo() {
					return orderreview_sellerinfo;
				}


				public List<WebElement> getOrderreview_quantity() {
					return orderreview_quantity;
				}


				public List<WebElement> getOrderreview_quantitycount() {
					return orderreview_quantitycount;
				}


				public List<WebElement> getOrderreview_price() {
					return orderreview_price;
				}


				public List<WebElement> getOrderreview_exprity_date() {
					return orderreview_exprity_date;
				}


				public WebElement getOrderreview_customerNotes() {
					return orderreview_customerNotes;
				}


				public WebElement getOrderreview_textArea() {
					return orderreview_textArea;
				}


				public WebElement getOrderreview_paymentdetails() {
					return orderreview_paymentdetails;
				}


				public WebElement getOrderreview_mrpTotal() {
					return orderreview_mrpTotal;
				}


				public WebElement getOrderreview_mrpTotalprice() {
					return orderreview_mrpTotalprice;
				}


				public WebElement getOrderreview_Delivery_Charges() {
					return orderreview_Delivery_Charges;
				}


				public WebElement getOrderreview_Delivery_Chargesprice() {
					return orderreview_Delivery_Chargesprice;
				}


				public WebElement getOrderreview_TotalAmout() {
					return orderreview_TotalAmout;
				}


				public WebElement getOrderreview_TotalAmoutprice() {
					return orderreview_TotalAmoutprice;
				}


				public WebElement getOrderreview_TotalAmoutcontent() {
					return orderreview_TotalAmoutcontent;
				}


				public WebElement getOrderreview_TotalAmoutprices() {
					return orderreview_TotalAmoutprices;
				}
				//*****************************************Cards and wallets*************************************
				
				@FindBy(xpath ="//a[@class=\"payment-link\"]")
				private WebElement Payment_method;
				public WebElement getPayment_method() {
					return Payment_method;
				}
				
				@FindBy(xpath ="//h4[.=\"SAVED CARDS\"]")
				private WebElement Saved_card_text;
				public WebElement getSaved_card_text() {
					return Saved_card_text;
				}
				
				
				@FindBy(xpath = "//div[@class=\"empty ng-star-inserted\"]")
				private WebElement card_details_text;
				public WebElement getCard_details_text() {
					return card_details_text;
				}
				
				@FindBy(xpath = "//h4[.=\"LINKED WALLETS\"]")
				private WebElement Linked_wallets_details_text;
				public WebElement getLinked_wallets_details_text() {
					return Linked_wallets_details_text;
				}

				@FindBy(xpath ="//div[@class=\"empty nowallets ng-star-inserted\"]")
				private WebElement Linked_wallet_text;
				public WebElement getLinked_wallet_text() {
					return Linked_wallet_text;
				}
				
				@FindBy(xpath ="//ul[@class=\"savedcards ng-star-inserted\"]")
				private WebElement saved_card;
				public WebElement getSaved_card() {
					return saved_card;
				}
				
				@FindBy(xpath = "//div[@class=\"linkedlist ng-star-inserted\"]")
				private List<WebElement> Linked_wallets;
				public List<WebElement> getLinked_wallets() {
					return Linked_wallets;
				}
				
				
				@FindBy(xpath ="//span[@class=\"link ng-star-inserted\"]")
				private List<WebElement> Links;
				public List<WebElement> getLinks() {
					return Links;
				}
				
				
				
				//////////////////////////////////////////////////////////////////////////
				////////////////  HOME PAGE ELEMEMT   /////////////////////////////
				
				
				

				 @FindBy(xpath="(//a[text()=' Sign in / Sign up '])")
				    private WebElement login;
					
					@FindBy(xpath="//button[contains(text(),'USE PASSWORD')]")
					private WebElement click;
					
					@FindBy(id = "loginfirst_mobileno")
					private WebElement Mobilenos;  
					
					@FindBy(id="login_received_pwd" )
					private WebElement pwd;
					
					@FindBy(xpath = "(//button[contains(text(),'Sign in')])")
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

					public WebElement getLogin() {
						return login;
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


					public WebElement getMobilenos() {
						return Mobilenos;
					}

					

					
					
////////////////////////////////////////////////////
				
				
				

}