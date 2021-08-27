package com.Nm.Pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Nm.Base.MobileBaseClass;

import io.appium.java_client.MobileElement;

public class AndriodPom extends MobileBaseClass{
	public AndriodPom() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	//********************************************M3 FLow
		@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.NetmedsMarketplace.Netmeds:id/lets_start']")
		private WebElement Letsstarted;
		public WebElement getLetsstarted() {
			return Letsstarted;
		}
		
		
		@FindBy(xpath="//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/name']")
		private WebElement mobilenumber;
		public WebElement getMobilenumber() {
			return mobilenumber;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.NetmedsMarketplace.Netmeds:id/btn_use_password']")
		private WebElement usepwd;
		public WebElement getUsepwd() {
			return usepwd;
		}
		
		@FindBy(xpath ="//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/edt_password'or @resource-id='com.NetmedsMarketplace.Netmeds:id/password_edit']")
		private WebElement password;
		public WebElement getPassword() {
			return password;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/txtLogin']")
		private WebElement Login;
		public WebElement getLogin() {
			return Login;
		}
		
		@FindBy(xpath ="//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/subscription_image']")
		private WebElement Subscription;
		public WebElement getSubscription() {
			return Subscription;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_createSubscription']")
		private WebElement createnew_subscription;
		public WebElement getCreatenew_subscription() {
			return createnew_subscription;
		}
		
		//@FindBy(xpath = "//android.widget.EditText[@resourceid='com.NetmedsMarketplace.Netmeds:id/search_bar']")
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/search_bar")
		private WebElement M3productsearch;
		public WebElement getM3productsearch() {
			return M3productsearch;
		}
		

		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/proceedToCheckoutButton")
		private WebElement Proceedtocheckout;
		public WebElement getProceedtocheckout() {
			return Proceedtocheckout;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/cart_proceed_btn")
		private WebElement proceed_btn;
		public WebElement getProceed_btn() {
			return proceed_btn;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/first_checkbox")
		private WebElement delivery_30days;
		public WebElement getDelivery_30days() {
			return delivery_30days;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/second_checkbox")
		private WebElement delivery_45days;
		public WebElement getDelivery_45days() {
			return delivery_45days;
		}
		
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/third_checkbox")
		private WebElement delivery_60days;
		public WebElement getDelivery_60days() {
			return delivery_60days;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_button")
		private WebElement Proceedto_placeorder;
		public WebElement getProceedto_placeorder() {
			return Proceedto_placeorder;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/proceed_btn")
		private WebElement placeorder;
		public WebElement getPlaceorder() {
			return placeorder;
		}
		
		@FindBy(xpath ="//android.widget.Button[@index ='1']")
		private WebElement myorders;
		public WebElement getMyorders() {
			return myorders;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/btn_view_order")
		private WebElement viewdetails;
		public WebElement getViewdetails() {
			return viewdetails;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/btn_cancel_order")
		private WebElement cancelorder;
		public WebElement getCancelorder() {
			return cancelorder;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/btn_proceed")
		private WebElement yesbutton;
		public WebElement getYesbutton() {
			return yesbutton;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cb_drug_selected")
		private WebElement cancel_reason;
		public WebElement getCancel_reason() {
			return cancel_reason;
		}
		
		@FindBy(xpath ="//android.widget.Button[@index='1']")
		private WebElement submit_cancel;
		public WebElement getSubmit_cancel() {
			return submit_cancel;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/dontHavePrescriptionCheckBox")
		private WebElement doctor_consultation;
		public WebElement getDoctor_consultation() {
			return doctor_consultation;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_change_address")
		private WebElement Address_change;
		public WebElement getAddress_change() {
			return Address_change;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/uploadPrescription")
		private WebElement uploadPrescription;
		public WebElement getUploadPrescription() {
			return uploadPrescription;
		}
		
		@FindBy(id = "(//android.widget.ImageView[@content-desc=\"Past Rx\"])[1]")
		private WebElement pastrx;
		public WebElement getPastrx() {
			return pastrx;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/doneButton")
		private WebElement done;
		public WebElement getDone() {
			return done;
		}
		
		public WebElement getAllow() {
			return Allow;
		}


		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/setAddressButton")
		private WebElement Schedule_delivery;
		public WebElement getSchedule_delivery() {
			return Schedule_delivery;
		}
		@FindBy(xpath = "//android.widget.Button[@text='ALLOW']")
		private WebElement Allow;
		
		
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/pinCode")
		private WebElement pincode;
		public WebElement getPincode() {
			return pincode;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/firstName")
		private WebElement firstname;
		public WebElement getFirstname() {
			return firstname;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/lastName")
		private WebElement lastname;
		public WebElement getLastname() {
			return lastname;
		}
		
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/houseNumber")
		private WebElement address;
		public WebElement getAddress() {
			return address;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/landMark")
		private WebElement landmark;
		public WebElement getLandmark() {
			return landmark;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/saveAddressButton")
		private WebElement save_address;
		public WebElement getSave_address() {
			return save_address;
		}
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cart_tv_promo_code")
		private WebElement Subs20_promo;
		public WebElement getSubs20_promo() {
			return Subs20_promo;
		}
		
		
		@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_remove_product'])[2]")
		private WebElement removeitem;
		public WebElement getRemoveitem() {
			return removeitem;
		}
		
	
		

		public WebElement getSearchbar() {
			return Searchbar;
		}
		public WebElement getProductselect() {
			return productselect;
		}
		public WebElement getAddtoCartButton() {
			return addtoCartButton;
		}
		public WebElement getGotocart() {
			return gotocart;
		}


		@FindBy(xpath="//android.widget.TextView[@text='Search for medicine & wellness products…']")
		private WebElement Searchbar;
		@FindBy(xpath="//android.widget.EditText[@text='Search here…']")
		private WebElement Searchbarone;
		public WebElement getSearchbarone() {
			return Searchbarone;
		}


		@FindBy(xpath="//*[@id='alternateBrain_product_view']")
		private WebElement productselect;
		@FindBy(xpath="//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn']")
		private WebElement addtoCartButton;
		@FindBy(xpath="//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart']")
		private WebElement gotocart;

		@FindBy(xpath="//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_remove_product']")
		private WebElement RemoveButton;
		public WebElement getRemoveButton() {
			return RemoveButton;
		}
		@FindBy(xpath="//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/search']")
		private WebElement cart_search;
		@FindBy(xpath="//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/alternateBrain_drug_name']")
		private WebElement search_drugname;
		@FindBy(xpath="//android.widget.TextView[@text='COD']")
		private WebElement Payment_cod;
		@FindBy(xpath="//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_pay']")
		private WebElement Payment_paybutton;
		public WebElement getPayment_paybutton() {
			return Payment_paybutton;
		}





		public WebElement getPayment_cod() {
			return Payment_cod;
		}





		public WebElement getCart_search() {
			return cart_search;
		}





		public WebElement getSearch_drugname() {
			return search_drugname;
		}

		
		
		
		
		
		
		
		
		
		
		


		
		
		///////////////////////////////////////////////   M2 FLOW  ////////////////////////////////////////////////////////////////
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/order_medicine_button']")
		private WebElement m2_OrderNow;
		public WebElement getM2_OrderNow() {
			return m2_OrderNow;
		}
		
		
		@FindBy(id = "Gallery")
		private WebElement m2_Upload_Gallery;
		public WebElement getM2_Upload_Gallery() {
			return m2_Upload_Gallery;
		}
		
		@FindBy(id = "Gallery")
		private WebElement m2_Upload_PDF;
		public WebElement getM2_Upload_PDF() {
			return m2_Upload_PDF;
		}
		
		@FindBy(id = "Gallery")
		private WebElement m2_PastRX;
		public WebElement getM2_PastRX() {
			return m2_PastRX;
		}
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/continueButton']")
		private WebElement m2_Upload_ContinueBtn;
		public WebElement getM2_Upload_ContinueBtn() {
			return m2_Upload_ContinueBtn;
		}
		
		
		@FindBy(xpath = "//android.widget.CheckBox[@resource-id='com.NetmedsMarketplace.Netmeds:id/searchAddCheckBox']")
		private WebElement m2_SearchMedicine;
		public WebElement getM2_SearchMedicine() {
			return m2_SearchMedicine;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/continueButton']" )
		private WebElement m2_Search_CAll_ContinueBtn;
		public WebElement getM2_Search_CAll_ContinueBtn() {
			return m2_Search_CAll_ContinueBtn;
		}
		
		
		@FindBy(xpath = "//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/search_bar']" )
		private WebElement m2_SearchBar;
		public WebElement getM2_SearchBar() {
			return m2_SearchBar;
		}
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn']" )
		private WebElement m2_Search_AddToCart;
		public WebElement getM2_Search_AddToCart() {
			return m2_Search_AddToCart;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/proceedToCheckoutButton']" )
		private WebElement m2_ProceedToCart;
		public WebElement getM2_ProceedToCart() {
			return m2_ProceedToCart;
		}
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/cart_proceed_btn']" )
		private WebElement m2_ProceedBtn;
		public WebElement getM2_ProceedBtn() {
			return m2_ProceedBtn;
		}
		
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/place_order']" )
		private WebElement m2_Place_Order;
		public WebElement getM2_Place_Order() {
			return m2_Place_Order;
		}
		
		
		@FindBy(xpath = "//android.widget.Button[@text='TRACK ORDER']" )
		private WebElement Track_Order;
		public WebElement getTrack_Order() {
			return Track_Order;
		}
		
		
		@FindBy(xpath = "//android.widget.Button[@resource-id='com.NetmedsMarketplace.Netmeds:id/btn_view_order']" )
		private WebElement View_Order_details;
		public WebElement getView_Order_details() {
			return View_Order_details;
		}
		
		
		@FindBy(xpath = "//android.widget.Button[@resource-id='com.NetmedsMarketplace.Netmeds:id/btn_cancel_order']")
		private WebElement Cancel_Order;
		public WebElement getCancel_Order() {
			return Cancel_Order;
		}
		
		
		@FindBy(xpath = "//android.widget.CheckBox[@resource-id='com.NetmedsMarketplace.Netmeds:id/cb_drug_selected']")
		private WebElement Cancel_Order_reason;
		public WebElement getCancel_Order_reason() {
			return Cancel_Order_reason;
		}
		
		@FindBy(xpath = "//android.widget.Button[@text='SUBMIT & CANCEL']")
		private WebElement Submit_cancelBtn;
		public WebElement getSubmit_cancelBtn() {
			return Submit_cancelBtn;
		}
		
		
		@FindBy(xpath = "//android.widget.CheckBox[@resource-id='com.NetmedsMarketplace.Netmeds:id/callCheckBox']")
		private WebElement m2_GetCallBtn;
		public WebElement getM2_GetCallBtn() {
			return m2_GetCallBtn;
		}
		


		@FindBy(xpath = "//android.widget.CheckBox[@resource-id='com.NetmedsMarketplace.Netmeds:id/prescriptionCheckBox']")
		private WebElement m2_RX_Checkbox;
		public WebElement getM2_RX_Checkbox() {
			return m2_RX_Checkbox;
		}
		
		@FindBy(id = "com.android.camera:id/done_button")
		private WebElement m2_RX_DoneBtn;
		public WebElement getM2_RX_DoneBtn() {
			return m2_RX_DoneBtn;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_change_address']")
		private WebElement m2_ChangeAddress;
		public WebElement getM2_ChangeAddress() {
			return m2_ChangeAddress;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/addAddress']")
		private WebElement m2_AddNewAddress;
		public WebElement getM2_AddNewAddress() {
			return m2_AddNewAddress;
		}
		
		
		@FindBy(xpath = "//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/pinCode']")
		private WebElement m2_PinCode;
		public WebElement getM2_PinCode() {
			return m2_PinCode;
		}
		
		
		@FindBy(xpath = "//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/firstName']")
		private WebElement m2_FirstName;
		public WebElement getM2_FirstName() {
			return m2_FirstName;
		}
		
		
		@FindBy(xpath = "//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/lastName']")
		private WebElement m2_Lastname;
		public WebElement getM2_Lastname() {
			return m2_Lastname;
		}
		
		
		@FindBy(xpath = "//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/houseNumber']")
		private WebElement m2_Adress;
		public WebElement getM2_Adress() {
			return m2_Adress;
		}
		
		
		@FindBy(xpath = "//android.widget.EditText[@resource-id='com.NetmedsMarketplace.Netmeds:id/landMark']")
		private WebElement m2_LandMark;
		public WebElement getM2_LandMark() {
			return m2_LandMark;
		}
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/saveAddressButton']")
		private WebElement m2_SaveAddress;
		public WebElement getM2_SaveAddress() {
			return m2_SaveAddress;
		}
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/edit']")
		private WebElement m2_ModifyAddress;
		public WebElement getM2_ModifyAddress() {
			return m2_ModifyAddress;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/delete']")
		private WebElement m2_DeleteAddress;
		public WebElement getM2_DeleteAddress() {
			return m2_DeleteAddress;
		}
		
		
		@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
		private WebElement m2_BackToCart;
		public WebElement getM2_BackToCart() {
			return m2_BackToCart;
		}
		

		
	//PDP
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/alternateBrain_drug_name']")
		private List<WebElement> search_results;
		public List<WebElement> getSearch_results() {
			return search_results;
		}
		
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/product_category_name']")
		private WebElement PDP_category_Name;
		public WebElement getPDP_category_Name() {
			return PDP_category_Name;
		}

		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/product_rx_required']")
		private WebElement PDP_Rx_Required;
		public WebElement getPDP_Rx_Required() {
			return PDP_Rx_Required;
		}
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/product_rx_required']")
		private List<WebElement> PDP_Rx_Required_List;
		public List<WebElement> getPDP_Rx_Required_List() {
			return PDP_Rx_Required_List;
		}
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/product_details_manufacturer_name']")
		private WebElement PDP_Manufacture_name;
		public WebElement getPDP_Manufacture_name() {
			return PDP_Manufacture_name;
		}

		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/product_algoliaPrice']")
		private WebElement PDP_Best_Price;
		public WebElement getPDP_Best_Price() {
			return PDP_Best_Price;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/product_details_strike_price']")
		private List<WebElement> PDP_MRP_Price_List;
		public List<WebElement> getPDP_MRP_Price_List() {
			return PDP_MRP_Price_List;
		}
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/product_details_strike_price']")
		private WebElement PDP_MRP_Price;
		public WebElement getPDP_MRP_Price() {
			return PDP_MRP_Price;
		}

		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_all_offer']")
		private WebElement PDP_OfferAvailable_Text;
		public WebElement getPDP_OfferAvailable_Text() {
			return PDP_OfferAvailable_Text;
		}
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_all_offer']")
		private List<WebElement> PDP_OfferAvailable_List;
		public List<WebElement> getPDP_OfferAvailable_List() {
			return PDP_OfferAvailable_List;
		}

		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/txtCouponCode']")
		private List<WebElement> PDP_Coupon_Code;
		public List<WebElement> getPDP_Coupon_Code() {
			return PDP_Coupon_Code;
		}

		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_save']")
		private List<WebElement> PDP_Coupon_Save_Percentage;
		public List<WebElement> getPDP_Coupon_Save_Percentage() {
			return PDP_Coupon_Save_Percentage;
		}
		
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/txtCouponMessage']")
		private List<WebElement> PDP_Coupon_Details;
		public List<WebElement> getPDP_Coupon_Details() {
			return PDP_Coupon_Details;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/title")
		private WebElement PDP_manufacture_Page;
		public WebElement getPDP_manufacture_Page() {
			return PDP_manufacture_Page;
		}

		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/search")
		private WebElement Search_X_button;
		public WebElement getSearch_X_button() {
			return Search_X_button;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/share_product")
		private WebElement PDP_Share_Icon;
		public WebElement getPDP_Share_Icon() {
			return PDP_Share_Icon;
		}
		
		@FindBy(id="android:id/icon")
		private WebElement PDP_Share_Message_Samsung;
		public WebElement getPDP_Share_Message_Samsung() {
			return PDP_Share_Message_Samsung;
		}

		@FindBy(id="android:id/button_once")
		private WebElement Samsung_AllowOnce;
		public WebElement getSamsung_AllowOnce() {
			return Samsung_AllowOnce;
		}
		
		@FindBy(id="android:id/button_always")
		private WebElement Samsung_AllowAlways;
		public WebElement getSamsung_AllowAlways() {
			return Samsung_AllowAlways;
		}
		
		
		// Combo Pack
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/bundle_buy_pack")
		private List<WebElement> PDP_BuyPack_ComboList;
		public List<WebElement> getPDP_BuyPack_ComboList() {
			return PDP_BuyPack_ComboList;
		} 
		
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/bundle_price")
		private List<WebElement> PDP_BuyPack_Combo_PriceList;		
		public List<WebElement> getPDP_BuyPack_Combo_PriceList() {
			return PDP_BuyPack_Combo_PriceList;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/bundle_price")
		private WebElement PDP_BuyPack_Combo_Price;
		public WebElement getPDP_BuyPack_Combo_Price() {
			return PDP_BuyPack_Combo_Price;
		}


		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/bundle_buy_pack")
		private WebElement PDP_BuyPack_ComboBtn;
		public WebElement getPDP_BuyPack_ComboBtn() {
			return PDP_BuyPack_ComboBtn;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/tv_pack_of_buy_title")
		private WebElement PDP_ComboPack_text;
		public WebElement getPDP_ComboPack_text() {
			return PDP_ComboPack_text;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/similarProductTitle")
		private WebElement PDP_FrequentlyBrought_text;
		public WebElement getPDP_FrequentlyBrought_text() {
			return PDP_FrequentlyBrought_text;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn")
		private WebElement PDP_FrequentlyBrought_AddToCart;
		public WebElement getPDP_FrequentlyBrought_AddToCart() {
			return PDP_FrequentlyBrought_AddToCart;
		}
		
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/sp_similar_product_name")
		private WebElement PDP_FrequentlyBrought_Productname;
		public WebElement getPDP_FrequentlyBrought_Productname() {
			return PDP_FrequentlyBrought_Productname;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/snackbar_action")
		private WebElement SnackBar_GotIT_btn;
		public WebElement getSnackBar_GotIT_btn() {
			return SnackBar_GotIT_btn;
		}
		
		
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/proceed_to_checkout_btn")
		private WebElement PDP_ProceedToCart;
		public WebElement getPDP_ProceedToCart() {
			return PDP_ProceedToCart;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/cart_algoliaPrice")
		private WebElement Cart_Price;
		public WebElement getCart_Price() {
			return Cart_Price;
		}
		//com.NetmedsMarketplace.Netmeds:id/cart_tv_item_qty
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/cart_tv_item_qty")
		private WebElement Cart_Quantity;		
		public WebElement getCart_Quantity() {
			return Cart_Quantity;
		}
		
		
		// Alternate brand
		@FindBy(xpath="//android.widget.TextView[@text='ALTERNATE BRANDS']")
		private WebElement PDP_AlternateBrand_Text;
		public WebElement getPDP_AlternateBrand_Text() {
			return PDP_AlternateBrand_Text;
		}
		
		
		
		@FindBy(xpath="com.NetmedsMarketplace.Netmeds:id/alternateBrain_drug_name")
		private List<WebElement> PDP_AlternateBrand_Name_List;
		public List<WebElement> getPDP_AlternateBrand_Name_List() {
			return PDP_AlternateBrand_Name_List;
		}
		
		
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/alternateBrain_drug_name")
		private WebElement PDP_AlternateBrand_Name;
		public WebElement getPDP_AlternateBrand_Name() {
			return PDP_AlternateBrand_Name;
		}
		
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/cart")
		private WebElement PDP_Cart_btn;
		public WebElement getPDP_Cart_btn() {
			return PDP_Cart_btn;
		}
		
		
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/cart_adapter_drug_name")
		private List<WebElement> Cart_drug_name_List;
		public List<WebElement> getCart_drug_name_List() {
			return Cart_drug_name_List;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/cart_adapter_drug_name")
		private WebElement Cart_drug_name;
		public WebElement getCart_drug_name() {
			return Cart_drug_name;
		}
		
		@FindBy(xpath="//android.widget.TextView[@text='MOST SELLING PRODUCTS']")
		private WebElement Most_Selling_text;
		public WebElement getMost_Selling_text() {
			return Most_Selling_text;
		}
		
		
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/most_selling_product_name")
		private List<WebElement> MostSelling_drug_name_List;
		public List<WebElement> getMostSelling_drug_name_List() {
			return MostSelling_drug_name_List;
		}
		
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/most_selling_product_name")
		private WebElement MostSelling_drug_name;
		public WebElement getMostSelling_drug_name() {
			return MostSelling_drug_name;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn")
		private WebElement Add_To_cart;
		public WebElement getAdd_To_cart() {
			return Add_To_cart;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn")
		private List<WebElement> Add_To_cart_List;
		public List<WebElement> getAdd_To_cart_List() {
			return Add_To_cart_List;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


		@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.android.camera:id/shutter_button']")
		private WebElement camera_clickbutton;
		@FindBy(xpath = "//android.widget.TextView[@text='Camera']")
		private WebElement camera_button;
		@FindBy(xpath = "//android.widget.Button[@text='OK']")
		private WebElement camera_okbutton;
		public WebElement getCamera_clickbutton() {
			return camera_clickbutton;
		}

		public WebElement getCamera_button() {
			return camera_button;
		}

		public WebElement getCamera_okbutton() {
			return camera_okbutton;
		}

		@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.NetmedsMarketplace.Netmeds:id/continueUpload']")
		private WebElement continueUpload;
		@FindBy(xpath = "//android.widget.TextView[@text='Gallery']")
		private WebElement Gallery_button;
		@FindBy(xpath = "//android.widget.TextView[@text='Past Rx']")
		private WebElement PastRx_button;
		@FindBy(xpath = "//android.widget.TextView[@text='PDF']")
		private WebElement PDF_button;
		@FindBy(xpath = "(//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/prescriptionCheckBox'])[1]")
		private WebElement prescriptionImage;
		@FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/title']")
		private WebElement Pdf_Click;
		public WebElement getPdf_Click() {
			return Pdf_Click;
		}


		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		


		public WebElement getPrescriptionImage() {
			return prescriptionImage;
		}

		public WebElement getContinueUpload() {
			return continueUpload;
		}

		public WebElement getGallery_button() {
			return Gallery_button;
		}

		public WebElement getPastRx_button() {
			return PastRx_button;
		}

		public WebElement getPDF_button() {
			return PDF_button;
		}
}


