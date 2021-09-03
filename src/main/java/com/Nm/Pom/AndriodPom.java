package com.Nm.Pom;

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


		@FindBy(xpath = "//android.widget.TextView[@text='Amazon Pay']/following-sibling::android.widget.TextView[@text='LINK']")
		private WebElement Amazon_pay_withoutLink;
		@FindBy(xpath = "//android.widget.TextView[@text='Mobikwik']/following-sibling::android.widget.TextView[@text='LINK']")
		private WebElement Mobikwik_withoutLink;
		@FindBy(xpath = "//android.widget.TextView[@text='Paytm']/following-sibling::android.widget.TextView[@text='LINK']")
		private WebElement Paytm_withoutLink;
		@FindBy(xpath = "//android.widget.TextView[@text='Freecharge PayLater | Wallet']/following-sibling::android.widget.TextView[@text='LINK']")
		private WebElement Freecharge_PayLater_Wallet;
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
		
}


