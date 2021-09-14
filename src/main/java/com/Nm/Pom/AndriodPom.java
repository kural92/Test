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
		
		
		// Cold Storage
		
				@FindBy(xpath = "//android.widget.TextView[@text='Check Availability']")
				private WebElement PDP_CheckAvailabilty_btn;
				public WebElement getPDP_CheckAvailabilty_btn() {
					return PDP_CheckAvailabilty_btn;
				}
				
				
				@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/btn_dismiss")
				private WebElement PDP_CheckAvailabilty_Close_btn;
				public WebElement getPDP_CheckAvailabilty_Close_btn() {
					return PDP_CheckAvailabilty_Close_btn;
				}
				
				@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/pincode")
				private WebElement PDP_ColdStorage_PinCheck;
				public WebElement getPDP_ColdStorage_PinCheck() {
					return PDP_ColdStorage_PinCheck;
				}

				@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/check_availability")
				private WebElement PDP_CheckAvailabilty_CheckBtn;
				public WebElement getPDP_CheckAvailabilty_CheckBtn() {
					return PDP_CheckAvailabilty_CheckBtn;
				}
				
				@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/text_error")
				private WebElement PDP_Colstorage_DeliveryError;
				public WebElement getPDP_Colstorage_DeliveryError() {
					return PDP_Colstorage_DeliveryError;
				}
				
				@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/closeView")
				private WebElement DoctorConsultation_CloseBtn;
				public WebElement getDoctorConsultation_CloseBtn() {
					return DoctorConsultation_CloseBtn;
				}
				
				
				@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/setAddressButton")
				private WebElement Order_review_btn;
				public WebElement getOrder_review_btn() {
					return Order_review_btn;
				}
				
				
				@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_error_message")
				private WebElement Order_review_ColdStorage_text;
				public WebElement getOrder_review_ColdStorage_text() {
					return Order_review_ColdStorage_text;
				}
				 
				
				@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_split_post_error_description")
				private WebElement Take_Action_Description;
				public WebElement getTake_Action_Description() {
					return Take_Action_Description;
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
		@FindBy(xpath = "(//android.widget.CheckBox[@resource-id='com.NetmedsMarketplace.Netmeds:id/prescriptionCheckBox'])[1]")
		private WebElement prescriptionImage;
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.android.documentsui:id/file_type']")
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
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/netmeds_first_title")
		private WebElement Homepage_netmeds_first_title;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/netmeds_first_sub_title")
		private WebElement homepage_netmeds_first_sub_title;
		public WebElement getHomepage_netmeds_first_title() {
			return Homepage_netmeds_first_title;
		}

		public WebElement getHomepage_netmeds_first_sub_title() {
			return homepage_netmeds_first_sub_title;
		}

		public WebElement getHomepage_netmeds_first_discount() {
			return homepage_netmeds_first_discount;
		}

		public WebElement getHomepage_netmeds_first_action_button() {
			return homepage_netmeds_first_action_button;
		}


		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/netmeds_first_discount")
		private WebElement homepage_netmeds_first_discount;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/netmeds_first_action_button")
		private WebElement homepage_netmeds_first_action_button;
		public WebElement getNetmedsFirstPage_imageView() {
			return NetmedsFirstPage_imageView;
		}

		public WebElement getNetmedsFirstPage_header_text() {
			return NetmedsFirstPage_header_text;
		}

		public WebElement getNetmedsFirstPage_6month() {
			return NetmedsFirstPage_6month;
		}

		public WebElement getNetmedsFirstPage_12month() {
			return NetmedsFirstPage_12month;
		}

		public WebElement getNetmedsFirstPage_benefits_header_text() {
			return NetmedsFirstPage_benefits_header_text;
		}

		public WebElement getNetmedsFirstPage_benefits_sub_header_text() {
			return NetmedsFirstPage_benefits_sub_header_text;
		}

		public WebElement getNetmedsFirstPage_benefits_linkPage() {
			return NetmedsFirstPage_benefits_linkPage;
		}

		public WebElement getNetmedsFirstPage_benefits_linkType() {
			return NetmedsFirstPage_benefits_linkType;
		}

		public WebElement getNetmedsFirstPage_benefits_tip_text() {
			return NetmedsFirstPage_benefits_tip_text;
		}


		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/imageView")
		private WebElement NetmedsFirstPage_imageView;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/header_text")
		private WebElement NetmedsFirstPage_header_text;
		@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/btn_add_to_cart'])[1]")
		private WebElement NetmedsFirstPage_6month;
		@FindBy(xpath = "(//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/btn_add_to_cart'])[2]")
		private WebElement NetmedsFirstPage_12month;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/benefits_header_text")
		private WebElement NetmedsFirstPage_benefits_header_text;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/benefits_sub_header_text")
		private WebElement NetmedsFirstPage_benefits_sub_header_text;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/linkPage")
		private WebElement NetmedsFirstPage_benefits_linkPage;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/linkType")
		private WebElement NetmedsFirstPage_benefits_linkType;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/benefits_tip_text")
		private WebElement NetmedsFirstPage_benefits_tip_text;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cart_prime_header_text")
		private WebElement cart_prime_header_text;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cart_prime_sub_header_text")
		private WebElement cart_prime_sub_header_text;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cart_img_circle_arrow")
		private WebElement cart_img_circle_arrow;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cart_deliveryCharges")
		private WebElement cart_deliveryCharges;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/account_text")
		private WebElement Home_accountPage;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cl_elite")
		private WebElement acountPage_NetmedsFirstmember;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cl_log_out")
		private WebElement acountPage_logout;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/product_title")
		private WebElement OrP_product_title;
		public WebElement getOrP_product_title() {
			return OrP_product_title;
		}


		@FindBy(xpath = "//android.widget.TextView[@text='Delivery Estimate']")
		private WebElement OrP_Delivery_Estimate;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/txt_estimate_date")
		private WebElement OrP_txt_estimate_date;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/drug_name")
		private WebElement OrP_drug_name;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/algoliaPrice")
		private WebElement Orp_algoliaPrice;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/manufacturer_name")
		private WebElement Orp_manufacturer_name;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_item_seller")
		private WebElement Orp_tv_item_seller;	
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/qtyLabel")
		private WebElement Orp_qtyLabel;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/quantity")
		private WebElement Orp_quantity;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_item_expiry")
		private WebElement Orp_tv_item_expiry;
		@FindBy(xpath = "//android.widget.TextView[@text='PAYMENT DETAILS']")
		private WebElement Orp_PAYMENT_DETAIls;
		@FindBy(xpath = "//android.widget.TextView[@text='MRP Total']")
		private WebElement Orp_MRP_Total;
		@FindBy(xpath = "//android.widget.TextView[@text='Delivery Charges']")
		private WebElement Orp_Delivery_Charges;
		@FindBy(xpath = "//android.widget.TextView[@text='Total Amount']")
		private WebElement Orp_Total_Amount;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/mrpTotal")
		private WebElement Orp_mrpTotal_value;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_delivery_Charges")
		private WebElement Orp_tv_delivery_Charges_value;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_order_amount")
		private WebElement Orp_tv_order_amount_value;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/disclaimer_text")
		private WebElement Orp_disclaimer_text;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/prescriptionImage")
		private WebElement Orp_prescriptionImage;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/preview_close")
		private WebElement Orp_preview_close;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/retry")
		private WebElement retry;
		@FindBy(xpath = "//android.widget.TextView[@text='SIMPL Pay Later']/following-sibling::android.widget.CheckBox")
		private WebElement Simplpay;
		@FindBy(xpath = "//android.widget.TextView[@text='PhonePe']/following-sibling::android.widget.CheckBox")
		private WebElement Phonepe;
		@FindBy(xpath = "//android.widget.TextView[@text='ADD NEW CARD']")
		private WebElement AddnewCard;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cardNumber")
		private WebElement Cart_name;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cardValidity")
		private WebElement cardValidity;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cardCvv")
		private WebElement cardCvv;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cardHolderName")
		private WebElement cardHolderName;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/chk_save_card")
		private WebElement chk_save_card;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_pay")
		private WebElement tv_pay;
		public WebElement getCart_name() {
			return Cart_name;
		}

		public WebElement getCardValidity() {
			return cardValidity;
		}

		public WebElement getCardCvv() {
			return cardCvv;
		}

		public WebElement getCardHolderName() {
			return cardHolderName;
		}

		public WebElement getChk_save_card() {
			return chk_save_card;
		}

		public WebElement getTv_pay() {
			return tv_pay;
		}

		public WebElement getAddnewCard() {
			return AddnewCard;
		}

		public WebElement getPhonepe() {
			return Phonepe;
		}

		public WebElement getSimplpay() {
			return Simplpay;
		}

		public WebElement getRetry() {
			return retry;
		}


		@FindBy(xpath = "//android.widget.TextView[@text='Amazon Pay']")
		private WebElement Amazon_pay_withoutLink;
		@FindBy(xpath = "//android.widget.TextView[@text='Mobikwik']")
		private WebElement Mobikwik_withoutLink;
		@FindBy(xpath = "//android.widget.TextView[@text='Paytm']")
		private WebElement Paytm_withoutLink;
		
		@FindBy(xpath = "//android.widget.TextView[@text='Freecharge PayLater | Wallet']")
		private WebElement Freecharge_PayLater_Wallet;
		@FindBy(xpath = "//android.widget.TextView[@text='Axis Bank']")
		private WebElement Axis_Bank;
		@FindBy(xpath = "//android.widget.TextView[@text='HDFC Bank']")
		private WebElement HDFC_Bank;
		@FindBy(xpath = "//android.widget.TextView[@text='ICICI Netbanking']")
		private WebElement ICICI_Netbanking;
		@FindBy(xpath = "//android.widget.TextView[@text='Kotak Bank']")
		private WebElement Kotak_Bank;
		@FindBy(xpath = "//android.widget.TextView[@text='State Bank of India']")
		private WebElement SBI_Bank;
		@FindBy(xpath = "//android.widget.TextView[@text='MORE BANKS']")
		private WebElement MORE_BANKS;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/searchBank")
		private WebElement searchBank;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/mainLayout")
		private WebElement mainLayout;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/nmsCashCheckBox")
		private WebElement nmsCashCheckBox;
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_place_order")
		private WebElement tv_place_order;
		public WebElement getNmsCashCheckBox() {
			return nmsCashCheckBox;
		}

		public WebElement getTv_place_order() {
			return tv_place_order;
		}

		public WebElement getMainLayout() {
			return mainLayout;
		}

		public WebElement getMORE_BANKS() {
			return MORE_BANKS;
		}

		public WebElement getSearchBank() {
			return searchBank;
		}

		public WebElement getAxis_Bank() {
			return Axis_Bank;
		}

		public WebElement getHDFC_Bank() {
			return HDFC_Bank;
		}

		public WebElement getICICI_Netbanking() {
			return ICICI_Netbanking;
		}

		public WebElement getKotak_Bank() {
			return Kotak_Bank;
		}

		public WebElement getSBI_Bank() {
			return SBI_Bank;
		}

		public WebElement getSharelink() {
			return sharelink;
		}

		public WebElement getAmazon_pay_withoutLink() {
			return Amazon_pay_withoutLink;
		}

		public WebElement getMobikwik_withoutLink() {
			return Mobikwik_withoutLink;
		}

		public WebElement getPaytm_withoutLink() {
			return Paytm_withoutLink;
		}

		public WebElement getFreecharge_PayLater_Wallet() {
			return Freecharge_PayLater_Wallet;
		}

		public WebElement getOrp_preview_close() {
			return Orp_preview_close;
		}

		public WebElement getOrp_prescriptionImage() {
			return Orp_prescriptionImage;
		}


		
		public WebElement getOrp_disclaimer_text() {
			return Orp_disclaimer_text;
		}

		public WebElement getOrP_Delivery_Estimate() {
			return OrP_Delivery_Estimate;
		}

		public WebElement getOrP_txt_estimate_date() {
			return OrP_txt_estimate_date;
		}

		public WebElement getOrP_drug_name() {
			return OrP_drug_name;
		}

		public WebElement getOrp_algoliaPrice() {
			return Orp_algoliaPrice;
		}

		public WebElement getOrp_manufacturer_name() {
			return Orp_manufacturer_name;
		}

		public WebElement getOrp_tv_item_seller() {
			return Orp_tv_item_seller;
		}

		public WebElement getOrp_qtyLabel() {
			return Orp_qtyLabel;
		}

		public WebElement getOrp_quantity() {
			return Orp_quantity;
		}

		public WebElement getOrp_tv_item_expiry() {
			return Orp_tv_item_expiry;
		}

		public WebElement getOrp_PAYMENT_DETAIls() {
			return Orp_PAYMENT_DETAIls;
		}

		public WebElement getOrp_MRP_Total() {
			return Orp_MRP_Total;
		}

		public WebElement getOrp_Delivery_Charges() {
			return Orp_Delivery_Charges;
		}

		public WebElement getOrp_Total_Amount() {
			return Orp_Total_Amount;
		}

		public WebElement getOrp_mrpTotal_value() {
			return Orp_mrpTotal_value;
		}

		public WebElement getOrp_tv_delivery_Charges_value() {
			return Orp_tv_delivery_Charges_value;
		}

		public WebElement getOrp_tv_order_amount_value() {
			return Orp_tv_order_amount_value;
		}

		public WebElement getAcountPage_logout() {
			return acountPage_logout;
		}

		public WebElement getAcountPage_NetmedsFirstmember() {
			return acountPage_NetmedsFirstmember;
		}

		public WebElement getCart_deliveryCharges() {
			return cart_deliveryCharges;
		}

		public WebElement getHome_accountPage() {
			return Home_accountPage;
		}

		public WebElement getCart_prime_header_text() {
			return cart_prime_header_text;
		}

		public WebElement getCart_prime_sub_header_text() {
			return cart_prime_sub_header_text;
		}

		public WebElement getCart_img_circle_arrow() {
			return cart_img_circle_arrow;
		}
	
		//*******************************************Your Account

		//Delivery Address

		@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/account_image']")
			private WebElement userprofile;
			public WebElement getUserprofile() {
			return userprofile;
		}

			@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cl_delivery_address")
			private WebElement Deliveryaddress;
			public WebElement getDeliveryaddress() {
				return Deliveryaddress;
			}
			
			
			@FindBy(	xpath ="(//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/addressCheckbox'])[3]")
			private WebElement Slctaddress;
			public WebElement getSlctaddress() {
				return Slctaddress;
			}
			
			//My wallet
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/cl_wallet")
			private WebElement Mywallet;
			public WebElement getMywallet() {
				return Mywallet;
			}
			
			@FindBy(xpath ="//android.widget.TextView[@text ='AVAILABLE BALANCE']")
			private WebElement Availablebalance;
			public WebElement getAvailablebalance() {
				return Availablebalance;
			}
			
			
			@FindBy(xpath ="//android.widget.TextView[@index='2']")
			private WebElement Availableamount;
			public WebElement getAvailableamount() {
				return Availableamount;
			}
			
			
			
			@FindBy(xpath="//android.widget.TextView[@text='NMS Cash']")
			private WebElement NMSCash;
			public WebElement getNMSCash() {
				return NMSCash;
			}
			
			@FindBy (xpath="(//android.widget.TextView[@text ='How to use?'])[1]")
			private WebElement HwtouseNMScash;
			public WebElement getHwtouseNMScash() {
				return HwtouseNMScash;
			}
			
			@FindBy(xpath="//android.widget.ImageView[@index='0']")
			private WebElement ClosehwtouseNMScash;
			public WebElement getClosehwtouseNMScash() {
				return ClosehwtouseNMScash;
			}
			
			@FindBy(xpath="//android.widget.TextView[@text='NMS Super Cash']")
			private WebElement NMSSupercash;
			public WebElement getNMSSupercash() {
				return NMSSupercash;
			}
			
			@FindBy(xpath ="(//android.widget.TextView[@text ='How to use?'])[2]")
			private WebElement HwtouseNMSsupercash;
			public WebElement getHwtouseNMSsupercash() {
				return HwtouseNMSsupercash;
			}
			
			@FindBy (xpath="//android.widget.ImageView[@index='0']")
			private WebElement ClosehwtouseNMSsupercash;
			public WebElement getClosehwtouseNMSsupercash() {
				return ClosehwtouseNMSsupercash;
			}
			
//			******************************Edit Profile**************************************************************************
			
			@FindBy (id="com.NetmedsMarketplace.Netmeds:id/tv_edit_profile")
			private WebElement editprofile;
			public WebElement getEditprofile() {
				return editprofile;
			}
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/sp_gender")
			private WebElement 	Genderselect;
			public WebElement getGenderselect() {
				return Genderselect;
			}
				@FindBy(xpath ="//android.widget.CheckedTextView[@index='1']")
				private WebElement 	Genderselection;
				public WebElement getGenderselection() {
					return Genderselection;	
				
				
			}
			
			@FindBy(xpath="//android.widget.Button[@text='SAVE CHANGES']")
			private WebElement Savechanges;
			public WebElement getSavechanges() {
				return Savechanges;
			}
			//My Prescription//
			
				@FindBy (id ="com.NetmedsMarketplace.Netmeds:id/tv_prescription")	
				private WebElement myprescription_page;
				public WebElement getMyprescription_page() {
					return myprescription_page;
				}
				
				@FindBy (xpath="//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_orderId']")
				private WebElement Order_ID;
				public WebElement getOrder_ID() {
					return Order_ID;
				}
				@FindBy(xpath ="//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/order_date_tv']")
				private WebElement PrescriptionDate_text;
				public WebElement getPrescriptionDate_text() {
					return PrescriptionDate_text;
				}
				
				@FindBy(xpath ="//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/order_date']")
				private WebElement PrescriptionDate;
				public WebElement getPrescriptionDate() {
					return PrescriptionDate;
				}
				
				@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/pres_status_tv']")
				private WebElement PrescriptionStatus_text;
				public WebElement getPrescriptionStatus_text() {
					return PrescriptionStatus_text;
				}
				
				@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/prescription_status']")
				private WebElement PrescriptionStatus;
				public WebElement getPrescriptionStatus() {
					return PrescriptionStatus;
				}
				
				@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_order_desc']")
				private WebElement OrderStatus;
				public WebElement getOrderStatus() {
					return OrderStatus;
				}
				
				@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.NetmedsMarketplace.Netmeds:id/prescription_image']")
				private WebElement prescription_image;
				public WebElement getPrescription_image() {
					return prescription_image;
				}
				
				@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/download_pres']")
				private WebElement prescription_download;
				public WebElement getPrescription_download() {
					return prescription_download;
				}
				
				@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/preview_close")
				private WebElement close_image;
				public WebElement getClose_image() {
					return close_image;
				}
				
				//Refer and Earn//
				
				@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/refer_and_earn_button")
				private WebElement Referearnpage;
				public WebElement getReferearnpage() {
					return Referearnpage;
				}
				

			@FindBy(xpath = "//android.widget.TextView[@text ='GRAB YOUR']")
			private WebElement Grabyour;
			public WebElement getGrabyour() {
			return Grabyour;
		}
			
			@FindBy (xpath = "//android.widget.TextView[@text='A simpler way to earn and get discounts']")
			private WebElement simplerway_txt;

			public WebElement getSimplerway_txt() {
				return simplerway_txt;
			}
			
			@FindBy (xpath = "//android.widget.TextView[@text ='Instant Rewards']")
			private WebElement Instantrewards;
			public WebElement getInstantrewards() {
				return Instantrewards;
			}
			
			@FindBy (xpath = "//android.widget.TextView[@text='Invite your friends and family']")
			private WebElement invite;
			public WebElement getInvite() {
				return invite;
			}
			
			@FindBy (xpath = "//android.widget.TextView[@text ='share the Netmeds app download link & Referral code with your friends and family']")
			private WebElement share_netemed_app_txt;
			public WebElement getShare_netemed_app_txt() {
				return share_netemed_app_txt;
			}

			@FindBy (xpath = "//android.widget.TextView[@text='You get']")
				private WebElement Youget_txt;
		public WebElement getYouget_txt() {
			return Youget_txt;
		}
			
		@FindBy (xpath = "//android.widget.TextView[@text='Rs.150 NMS SuperCash - after your Friend’s first order is delivered!']")
		private WebElement NMSSupercash_txt;
		public WebElement getNMSSupercash_txt() {
			return NMSSupercash_txt;
		}
		@FindBy (xpath ="//android.widget.TextView[@text='Your Friends Get']")
		private WebElement yourfrndsget_txt;
		public WebElement getYourfrndsget_txt() {
			return yourfrndsget_txt;
		}


		@FindBy (xpath = "//android.widget.TextView[@text='Flat 20% off + 20% NMS Supercash on their first order (minimum order value Rs.500)']")
		private WebElement flat20offer_txt;
		public WebElement getFlat20offer_txt() {
			return flat20offer_txt;
		}


		@FindBy(xpath = "//android.widget.TextView[@text='TEST1932']")
		private WebElement yourreferralcode;
		public WebElement getYourreferralcode() {
			return yourreferralcode;
		}


		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/share_button")
		private WebElement sharelink;
		public WebElement getsharelink() {
			return sharelink;
		}


		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/terms")
		private WebElement Termscondition_link;
		public WebElement getTermscondition_link() {
			return Termscondition_link;
		}

		//help page//

		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/cl_help")
		private WebElement Helppage;
		public WebElement getHelppage() {
			return Helppage;
		}


		@FindBy (id = "com.NetmedsMarketplace.Netmeds:id/tv_title")
		private List<WebElement>  leftside_Link;
		public List<WebElement> getLeftside_Link() {
			return leftside_Link;
		}

		@FindBy (xpath = "//a[@class=\"need-btn\"]")
		private WebElement still_need_help;
		public WebElement getStill_need_help() {
			return still_need_help;
		}

			@FindBy (xpath = "(//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_title'])[13]")
					private WebElement  Helpage_link;
			public WebElement getHelpage_link() {
			return Helpage_link;
				}


			

		@FindBy (xpath = "(//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/tv_title'])[14]")
		private WebElement  Helpage_link_2;
		public WebElement getHelpage_link_2() {
		return Helpage_link_2;
		}

		//Legal Information

			@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_legal_info")
			private WebElement legalinfo;
			public WebElement getLegalinfo() {
				return legalinfo;
			}

			@FindBy (id = "com.NetmedsMarketplace.Netmeds:id/tv_title")
			private List<WebElement>  TC_Link;
			public List<WebElement> getTC_Link() {
				return TC_Link;
			
		}

		//Offers page
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/cl_language")
			private WebElement offers_page;
			public WebElement getOffers_page() {
				return offers_page;
			}
			
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/cart_remove_product")
			private WebElement Removebutton;
			public WebElement getRemovebutton() {
				return Removebutton;
			}
			
			


			//*****************************************************Order Success Page*****************************************************


			@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/order_status")
			private WebElement order_status;
			public WebElement getOrder_status() {
				return order_status;
			}

			@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_m2_desc")
			private WebElement pharmacists_verfication;
			public WebElement getPharmacists_verfication() {
				return pharmacists_verfication;
			}

			@FindBy(xpath ="//android.widget.TextView[@text='Expected delivery by']")
			private WebElement Deliverby_text;
			public WebElement getDeliverby_text() {
				return Deliverby_text;
			}


			@FindBy(xpath ="(//android.widget.TextView[@index='1'])[4]")
			private WebElement delivery_date;
			public WebElement getDelivery_date() {
				return delivery_date;
			}


			@FindBy(xpath ="//android.widget.TextView[@text='GRAB YOUR']")
			private WebElement Grab_text;
			public WebElement getGrab_text() {
				return Grab_text;
			}

			@FindBy(xpath="//android.widget.TextView[@text='Free Medicines']")
			private WebElement Free_medicines;
			public WebElement getFree_medicines() {
				return Free_medicines;
			}

			@FindBy(xpath ="//android.widget.TextView[@text='Invite your friends and get']")
			private WebElement invite_friends;
			public WebElement getInvite_friends() {
				return invite_friends;
			}

			@FindBy (xpath ="//android.widget.TextView[@text='TEST1932']")
			private WebElement offer_code;
			public WebElement getOffer_code() {
				return offer_code;
			}

			@FindBy (xpath ="//android.widget.TextView[@text='Tap to share code with your friends']")
			private WebElement share_with_friends;
			public WebElement getShare_with_friends() {
				return share_with_friends;
			}


			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/txt_scratch_card_message")
			private WebElement congrats;
			public WebElement getCongrats() {
				return congrats;
			}

			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/txt_scratch_card_description")
			private WebElement scratch_card;
			public WebElement getScratch_card() {
				return scratch_card;
			}
			
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_subscripe")
			private WebElement subscribe_now;
			public WebElement getSubscribe_now() {
				return subscribe_now;
			}
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_sub_delivery_desc")
			private WebElement refill_msg;
			public WebElement getRefill_msg() {
				return refill_msg;
			}
			
			@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_payment_mode")
			private WebElement paymentmode_text;
			public WebElement getPaymentmode_text() {
				return paymentmode_text;
			}
			
			
			@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/tv_payment_mode_desc")
			private WebElement paymentmode_desc;
			public WebElement getPaymentmode_desc() {
				return paymentmode_desc;
			}
			
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_online_payent")
			private WebElement paymentmethod_text;
			public WebElement getPaymentmethod_text() {
				return paymentmethod_text;
			}
			
			
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_promo_code")
			private WebElement promocode_text;
			public WebElement getPromocode_text() {
				return promocode_text;
			}
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_sub_promo_code")
			private WebElement promocode_subs20;
			public WebElement getPromocode_subs20() {
				return promocode_subs20;
			}
			
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_promo_code_desc")
			private WebElement Promo_percentage;
			public WebElement getPromo_percentage() {
				return Promo_percentage;
			}
			
			@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_sub_note")
			private WebElement modify_or_reschedule;
			public WebElement getModify_or_reschedule() {
				return modify_or_reschedule;
			}
			
			@FindBy(xpath ="//android.widget.Button[@text='SUBSCRIBE']")
			private WebElement Subscribe;
			public WebElement getSubscribe() {
				return Subscribe;
			
			}


	
			
//************************************************************Cart Page**********************************************************

	@FindBy(id="com.NetmedsMarketplace.Netmeds:id/imgChecked")	
	private List<WebElement> Promo;
	public List<WebElement> getPromo() {
		return Promo;
	}
	
	@FindBy(xpath ="//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/add_to_cart_btn']")
	private WebElement Most_Selling_products;
	public WebElement getMost_Selling_products() {
		return Most_Selling_products;
	}
		
	//************************************************My Orders Page****************************************************************//
	
		@FindBy(xpath = "//android.widget.TextView[@text='ORDER DETAILS']")
		private WebElement OrderDetails_text;
		public WebElement getOrderDetails_text() {
			return OrderDetails_text;
		}
		
		@FindBy(xpath ="//android.widget.TableRow[@index='4']")
		private WebElement Delivery_address_text;
		public WebElement getDelivery_address_text() {
			return Delivery_address_text;
		}
		
		@FindBy(xpath ="//android.widget.TextView[@text='Customer Name']")
		private WebElement customer_name_text;
		public WebElement getCustomer_name_text() {
			return customer_name_text;
		}
		
		@FindBy(xpath ="(//android.widget.TextView[@index='1'])[1]")
		private WebElement customer_name;
		public WebElement getCustomer_name() {
			return customer_name;
		}


		@FindBy(xpath ="//android.widget.TextView[@text='Order ID :']")
		private WebElement OrderId_text;
		public WebElement getOrderId_text() {
			return OrderId_text;
		}
		
		
		@FindBy(xpath ="(//android.widget.TextView[@index='1'])[2]")
		private WebElement OrderId;
		public WebElement getOrderId() {
			return OrderId;
		}
		
		
		@FindBy(xpath ="//android.widget.TextView[@text='Order Placed']")
		private WebElement Order_placed_text;
		public WebElement getOrder_placed_text() {
			return Order_placed_text;
		}
		
		
		
		@FindBy(xpath ="(//android.widget.TextView[@index='1'])[3]")
		private WebElement Order_placed;
		public WebElement getOrder_placed() {
			return Order_placed;
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
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/prescriptionImage")
		private WebElement Prescription_open;
		public WebElement getPrescription_open() {
			return Prescription_open;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/preview_close")
		private WebElement Prescription_closed;
		public WebElement getPrescription_closed() {
			return Prescription_closed;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/tv_bottom_text")
		private WebElement Show_Status_Details;
		public WebElement getShow_Status_Details() {
			return Show_Status_Details;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/btn_cancel_order")
		private WebElement NeedHelp_page;
		public WebElement getNeedHelp_page() {
			return NeedHelp_page;
		}
		
		@FindBy(id ="com.NetmedsMarketplace.Netmeds:id/btn_need_help")
		private WebElement Reorder;
		public WebElement getReorder() {
			return Reorder;
		}
		

	}


	




