package com.Nm.Pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Nm.Base.MsiteBaseClass;

import io.appium.java_client.MobileElement;

public class MsitePOM extends MsiteBaseClass{
	public MsitePOM() {
		PageFactory.initElements(driver, this);
		
	}
	


	@FindBy(xpath = "//span[@class='app_close']|//*[@class='app_close']")
	private WebElement Msite_HomeScreen_POP_UP;
    public WebElement getMsite_HomeScreen_POP_UP() {
		return Msite_HomeScreen_POP_UP;
	}

    
    @FindBy(xpath = "//*[@content-desc='Order Now']|//*[@text='Order Now' ]")
    private WebElement Msite_OrderNow;
	public WebElement getMsite_OrderNow() {
		return Msite_OrderNow;
	}
	//******************	M2
		@FindBy(xpath = "//span[@class='app_close']")
		private WebElement Msite_HomeScreen_POP_UP1;
	    public WebElement getMsite_HomeScreen_POP_UP1() {
			return Msite_HomeScreen_POP_UP;
		}
	    

	    @FindBy(xpath = "//android.view.View[@content-desc=\"Order Now\"]")
	    private WebElement Msite_OrderNow1;
		public WebElement getMsite_OrderNow1() {
			return Msite_OrderNow;
			
			
		}
		
		//@FindBy(xpath = "//android.widget.Button[@text='UPLOAD PRESCRIPTION']")
	   // private WebElement Msite_Upload_Prescription1;
		//public WebElement getMsite_Upload_Prescription1() {
		//	return Msite_Upload_Prescription1;
		//}	

	

		
		
		@FindBy(xpath = "//android.widget.Button[@text='Choose Files']")
	    private WebElement Msite_Upload_Gallery;
		public WebElement getMsite_Upload_Gallery() {
			return Msite_Upload_Gallery;
		}
		
		

		@FindBy(xpath = "//android.widget.RadioButto[@text='Search and Add medicines']")
	    private WebElement Msite_M2_searchMedicine1;
		public WebElement getMsite_M2_searchMedicine1() {
			return Msite_M2_searchMedicine1;
		}

		
		@FindBy(xpath = "//android.widget.RadioButto[@text='Get call from Netmeds']")
	    private WebElement Msite_M2_Getcall;
		public WebElement getMsite_M2_Getcall() {
			return Msite_M2_Getcall;
		}

		@FindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
		private WebElement Msite_M2_SearcCall_ContinueButton1;
		public WebElement getMsite_M2_SearcCall_ContinueButton1() {
			return Msite_M2_SearcCall_ContinueButton1;
		}

		
	//*******************************	My rewards
		@FindBy(xpath = "//*[@id='nms_phonepe']")
		private WebElement Phonepe_pay;
		public WebElement getPhonepe_pay() {
			return Phonepe_pay;
		}
		@FindBy(xpath = "//*[@id='nms_cod' and @name='nmsmstr_paymethod']")
		private WebElement Cod_popoup;
		public WebElement getCod_popoup() {
			return Cod_popoup;
		}
		@FindBy(xpath = "//*[@class='ccardno']")
		private WebElement Cart_pay;
		public WebElement getCart_pay() {
			return Cart_pay;
		}
		@FindBy(xpath = "//*[@name='netbank_list']")
		private WebElement More_banks;
		public WebElement getMore_banks() {
			return More_banks;
		}
		@FindBy(xpath = "//*[@id='nms_nb_axis']")
		private WebElement Axis_bank;
		public WebElement getAxis_bank() {
			return Axis_bank;
		}
		@FindBy(xpath = "//*[@id='nms_nb_sbi']")
		private WebElement SBI_bank;
		public WebElement getSBI_bank() {
			return SBI_bank;
		}
		@FindBy(xpath = "//*[@id='nms_nb_kotak']")
		private WebElement Kotak_bank;
		public WebElement getKotak_bank() {
			return Kotak_bank;
		}
		@FindBy(xpath = "//*[@id='nms_nb_icici']")
		private WebElement Icici_bank;
		public WebElement getIcici_bank() {
			return Icici_bank;
		}
		@FindBy(xpath = "//*[@id='nms_nb_hdfc']")
		private WebElement Hdfc_bank;
		public WebElement getHdfc_bank() {
			return Hdfc_bank;
		}
		@FindBy(xpath = "//*[@id='nms_googlepay' and @name='nmsmstr_paymethod']")
		private WebElement Googlepay_pay;
		public WebElement getGooglepay_pay() {
			return Googlepay_pay;
		}
		@FindBy(xpath = "//*[@id='nms_simpl']")
		private WebElement Simpl_payment;
		public WebElement getSimpl_payment() {
			return Simpl_payment;
		}
		
		//my Account 
		@FindBy(xpath = "//*[@id='nms_paytm' and @name='nmsmstr_paymethod']")
		private WebElement Paytm_payment;
		public WebElement getPaytm_payment() {
			return Paytm_payment;
		}
		@FindBy(xpath = "//*[@text and @nodeName='BUTTON']")
		private WebElement Paytm_paymentutton;
		public WebElement getPaytm_paymentutton() {
			return Paytm_paymentutton;
		}
		@FindBy(xpath = "//*[@id='nms_amazonpay']")
		private WebElement Amazon_pay;
		public WebElement getAmazon_pay() {
			return Amazon_pay;
		}
		@FindBy(xpath = "//*[@text and @nodeName='BUTTON']")
		private WebElement AMAZONPAY_paybutton;
		public WebElement getAMAZONPAY_paybutton() {
			return AMAZONPAY_paybutton;
		}
		@FindBy(xpath = "//*[@text='Retry']")
		private WebElement Payment_retry;
		public WebElement getPayment_retry() {
			return Payment_retry;
		}
		@FindBy(xpath = "//*[@text='Account']")
		private WebElement myaccount;
		public WebElement getmyaccount() {
			return myaccount;
		}
		
		
		@FindBy(xpath ="//*[@text='My Rewards']")
		private WebElement Myrewards;
		public WebElement getMyrewards() {
			return Myrewards;
		
		}
		
		
//*****************************M3 Flow
		
	@FindBy (xpath = "//android.view.View[@content-desc='Subscription']|//*[@text='Subscription']")	
	private WebElement Mysubscriptionpage;
	public WebElement getMysubscriptionpage() {
		return Mysubscriptionpage;
	}
	

	@FindBy(xpath = "//*[@text='Upload Prescription']")
    private WebElement Msite_Upload_Prescription;
	public WebElement getMsite_Upload_Prescription() {
		return Msite_Upload_Prescription;
	}	

	@FindBy(xpath = "//*[@text=' CREATE NEW SUBSCRIPTION ']|//android.widget.Button[@text='CREATE NEW SUBSCRIPTION']")
	private WebElement NewSubscription;
	public WebElement getNewSubscription() {
		return NewSubscription;
	}

	
	
	@FindBy(xpath = "//*[@class='ais-SearchBox-input']|//android.view.View[@resource-id='app']/android.view.View[2]/android.view.View/android.widget.EditText")
	private WebElement M3productsearch;
	public WebElement getM3productsearch() {
		return M3productsearch;
	}
	


	@FindBy(xpath = "(//*[@css='INPUT.m2checkbox.ng-untouched.ng-pristine.ng-valid'])[1]|//android.widget.RadioButto[@text='Search and Add medicines']")
    private WebElement Msite_M2_searchMedicine;
	public WebElement getMsite_M2_searchMedicine() {
		return Msite_M2_searchMedicine;
	}
	@FindBy(xpath = "//*[@class='action addcart']|//android.widget.Button[@text='ADD TO CART']")
	private WebElement Addtocart;
	public WebElement getAddtocart() {
		return Addtocart;

	}
		
	
	
	@FindBy(xpath = "//*[@class='btn-checkout btn btn_to_checkout']|//android.widget.Button[@text='PROCEED']")
	private WebElement Proceedtocheckout;
	public WebElement getProceedtocheckout() {
		return Proceedtocheckout;

	}

	@FindBy(xpath = "//*[@text='Continue']|//android.widget.Button[@text='CONTINUE']")
	private WebElement Msite_M2_SearcCall_ContinueButton;
	public WebElement getMsite_M2_SearcCall_ContinueButton() {
		return Msite_M2_SearcCall_ContinueButton;

	}
	

		
		@FindBy(xpath = "//*[@text='Next']|//android.widget.Button[@text='NEXT']")
		private WebElement Nextbutton;
		public WebElement getNextbutton() {
			return Nextbutton;
	
		}
	@FindBy(xpath = "//*[@text='Netmeds First Membership' and @nodeName='H2']")
	private WebElement Homepage_netmeds_first_title;
	@FindBy(xpath = "//*[@text='Get special discounts and offers on Netmeds services.' and @nodeName='LI']")
	private WebElement Get_special_discounts;
	@FindBy(xpath = "//*[@text='Get 2.5% NMS Cash on all orders.' and @nodeName='LI']")
	private WebElement NMS_Cash_on_all_orders;
	@FindBy(xpath = "//*[@text='Starting at ₹299' and @nodeName='DIV']")
	private WebElement Starting;
	public WebElement getHomepage_netmeds_first_title() {
		return Homepage_netmeds_first_title;
	}
	public WebElement getGet_special_discounts() {
		return Get_special_discounts;
	}
	public WebElement getNMS_Cash_on_all_orders() {
		return NMS_Cash_on_all_orders;
	}
	public WebElement getStarting() {
		return Starting;
	}
	public WebElement getExplore_Plans() {
		return Explore_Plans;
	}
	@FindBy(xpath = "//*[@text='REMOVE']")
	private WebElement RemoveButton;

	
	public WebElement getRemoveButton() {
		return RemoveButton;
	}
	@FindBy(xpath = "//*[@nodeName='SPAN' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@nodeName='DIV' and ./*[@nodeName='DIV']]]]")
	private WebElement Cart_search;
	@FindBy(xpath = "//*[@name='customerNotesByOrder']")
	private WebElement Orderreview_textArea;
	@FindBy(xpath = "//*[@text='CUSTOMER NOTES' and @nodeName='H5']")
	private WebElement Orderreview_customerNotes;
	public WebElement getOrderreview_customerNotes() {
		return Orderreview_customerNotes;
	}
	public WebElement getOrderreview_textArea() {
		return Orderreview_textArea;
	}
	public WebElement getCart_search() {
		return Cart_search;
	}
	@FindBy(xpath = "//*[@class='prodname']")
	private List<WebElement> 	Orderreview_productList;

	@FindBy(xpath = "//*[contains(@id,'row_itmdiscprice')]")
	private List<WebElement> Orderreview_price;
	@FindBy(xpath = "//*[@text=' Qty: ']/span")
	private List<WebElement> 	Orderreview_quantity;
	@FindBy(xpath = "//*[@class='sellerinfo']")
	private List<WebElement> 	Orderreview_sellerinfo;
	@FindBy(xpath = "//*[@text=' Qty: ']")
	private List<WebElement> 	getOrderreview_quantitycount;
	@FindBy(xpath = "//*[@class='manfname']")
	private List<WebElement> 	Orderreview_mfr;
	@FindBy(xpath = "//*[@class='expinfo']")
	private List<WebElement> 	Orderreview_exprity_date;
	public List<WebElement> getOrderreview_price() {
		return Orderreview_price;
	}
	public List<WebElement> getOrderreview_quantity() {
		return Orderreview_quantity;
	}
	public List<WebElement> getOrderreview_sellerinfo() {
		return Orderreview_sellerinfo;
	}
	public List<WebElement> getGetOrderreview_quantitycount() {
		return getOrderreview_quantitycount;
	}
	public List<WebElement> getOrderreview_mfr() {
		return Orderreview_mfr;
	}
	public List<WebElement> getOrderreview_exprity_date() {
		return Orderreview_exprity_date;
	}
	public WebElement getMyaccount() {
		return myaccount;
	}
	public List<WebElement> getOrderreview_productList() {
		return Orderreview_productList;
	}

	@FindBy(xpath = "//*[@nodeName='INPUT']")
	private WebElement Searchbarone;
	@FindBy(xpath = "//*[@text='Patanjali Lauh Bhasm Powder 5 gm' and @nodeName='A']")
	private WebElement getSearch_drugname;
	@FindBy(xpath = "((((//*[@id='app']/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View']])[2]/*[@class='android.view.View'])[2]/*[@class='android.view.View'])[1]/*[@text and @class='android.view.View'])[3]")
	private WebElement geCart_img_circle_arrow;
	@FindBy(xpath = "//*[@text='Add to Cart' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Rs. 299']]]]")
	private WebElement NetmedsFirstPage_6month;
	public WebElement getNetmedsFirstPage_6month() {
		return NetmedsFirstPage_6month;
	}
	public WebElement getGeCart_img_circle_arrow() {
		return geCart_img_circle_arrow;
	}
	public WebElement getCart_prime_header_text() {
		return Cart_prime_header_text;
	}
	public WebElement getCart_prime_sub_header_text() {
		return Cart_prime_sub_header_text;
	}


	@FindBy(xpath = "//*[@text=' ADD TO CART ']")
	private WebElement AddtoCartButton;
	@FindBy(xpath = "//*[@text='  ' and @nodeName='DIV' and @width>0 and ./*[@text='0']]|//*[@class='counter']")
	private WebElement Gotocart;
	@FindBy(xpath = "//*[@text='Become Netmeds First Member' and @nodeName='H4']")
	private WebElement Cart_prime_header_text;
	@FindBy(xpath = "//*[@text='Join membership to save much more! Exclusive offers designed for you']")
	private WebElement Cart_prime_sub_header_text;
	public WebElement getGetSearch_drugname() {
		return getSearch_drugname;
	}
	public WebElement getAddtoCartButton() {
		return AddtoCartButton;
	}
	public WebElement getGotocart() {
		return Gotocart;
	}
	public WebElement getSearchbarone() {
		return Searchbarone;
	}
	public void setSearchbarone(WebElement searchbarone) {
		Searchbarone = searchbarone;
	}


	@FindBy(xpath = "//*[@text='Explore Plans' and @nodeName='A']")
	private WebElement Explore_Plans;
	@FindBy(xpath = "//*[@text='Save more with exclusive membership' and @nodeName='H4']")
	private WebElement Save_more_with_exclusive_membership;
	@FindBy(xpath = "//*[@text='Recommended' and @nodeName='DIV']")
	private WebElement Recommended;
	@FindBy(xpath = "//*[@text='6 months' and @nodeName='DIV']")
	private WebElement six_months;
	@FindBy(xpath = "//*[@text='12 months' and @nodeName='DIV']")
	private WebElement twleve_months;
	@FindBy(xpath = "//*[@text='Rs. 299' and @nodeName='SPAN']")
	private WebElement Rs299;
	@FindBy(xpath = "//*[@text='Rs.999' and @nodeName='SPAN']")
	private WebElement Rs999;
	@FindBy(xpath = "//*[@text='Rs.1499' and @nodeName='SPAN']")
	private WebElement Rs1499;
	@FindBy(xpath = "//*[@text='Rs. 499' and @nodeName='SPAN']")
	private WebElement Rs499;
	@FindBy(xpath = "//*[@text=' Add to Cart ' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Rs. 299']]]]")
	private WebElement Add_to_Cart_sixmonth ;
	@FindBy(xpath = "//*[@text=' Add to Cart ' and ./parent::*[(./preceding-sibling::* | ./following-sibling::*)[./*[@text='Rs. 499']]]]")
	private WebElement Add_to_Cart_twlevemonth;
	public WebElement getSave_more_with_exclusive_membership() {
		return Save_more_with_exclusive_membership;
	}
	public WebElement getRecommended() {
		return Recommended;
	}
	public WebElement getSix_months() {
		return six_months;
	}
	public WebElement getTwleve_months() {
		return twleve_months;
	}
	public WebElement getRs299() {
		return Rs299;
	}
	public WebElement getRs999() {
		return Rs999;
	}
	public WebElement getRs1499() {
		return Rs1499;
	}
	public WebElement getRs499() {
		return Rs499;
	}
	public WebElement getAdd_to_Cart_sixmonth() {
		return Add_to_Cart_sixmonth;
	}
	public WebElement getAdd_to_Cart_twlevemonth() {
		return Add_to_Cart_twlevemonth;
	}
	
		@FindBy(xpath = "//*[@text='Subscribe']|//android.widget.Button[@text='SUBSCRIBE']")
		private WebElement Subscribe;
		public WebElement getSubscribe() {
			return Subscribe;
	
		}	
		@FindBy(xpath = "//*[@text='Delete']|//android.widget.Button[@text='DELETE']")
		private WebElement Deleteaddress;
		public WebElement getDeleteaddress() {
			return Deleteaddress;
	
		}
		
		@FindBy(xpath = "(//*[@class='editbtn btn'])[1]|//android.widget.Button[@text='Modify']|(//*[@text='Modify'])[1]")
		private WebElement Modifyaddressbtn;
		public WebElement getModifyaddressbtn() {
			return Modifyaddressbtn;
	
		}
		
		@FindBy(xpath = "//*[@id='pin']")
		private WebElement pincode;
		public WebElement getPincode() {
			return pincode;
	
		}
		@FindBy(xpath = "//*[@id='firstname']")
		private WebElement firstname;
		public WebElement getFirstname() {
			return firstname;
	
		}
		@FindBy(xpath = "//*[@id='lastname']")
		private WebElement lastname;
		public WebElement getLastname() {
			return lastname;
	
		}
		
		@FindBy(xpath = "//*[@id='street']")
		private WebElement street;
		public WebElement getStreet() {
			return street;
	
		}
		
		@FindBy(xpath = "//*[@id='landmark']")
		private WebElement landmark;
		public WebElement getLandmark() {
			return landmark;
	
		}
		
		
		@FindBy(xpath = "//*[@text='Save Address']|//android.widget.Button[@text='SAVE ADDRESS']")
		private WebElement saveaddress;
		public WebElement getSaveaddress() {
			return saveaddress;
	
		}
		
		@FindBy(xpath = "//*[@text='+ ADD NEW ADDRESS']|//android.widget.TextView[@text='+ ADD NEW ADDRESS']|//*[@class='add-address ng-star-inserted']")
		private WebElement addaddress;
		public WebElement getAddaddress() {
			return addaddress;
	
		}
		
		
		@FindBy(xpath = "(//*[@name='customeraddress'])[2]")
		private WebElement selectaddress;
		public WebElement getSelectaddress() {
			return selectaddress;
	
		}
		
		
//*********************************************Your Account
		
		
//delivery address
		
		@FindBy(xpath = "//*[@text='Delivery Addresses ']")
		private WebElement Deliveryaddress;
		public WebElement getDeliveryaddress() {
			return Deliveryaddress;
	
		}
		
		
//My wallet		
		@FindBy(xpath = "//*[@href='/customer/nmswallet']")
		private WebElement Mywallet;
		public WebElement getMywallet() {
			return Mywallet;
}	

		@FindBy(xpath ="//*[@class='editinfo personalinfor d-block d-sm-none ng-star-inserted']")
		private WebElement Editprofile;
		public WebElement getEditprofile() {
			return Editprofile;
		
		}
			
		@FindBy(xpath ="//*[@text='My Prescription ']")
		private WebElement Myprescription_page;
		public WebElement getMyprescription_page() {
			return Myprescription_page;
		
}
//****************************************Category
		
		@FindBy(css = "DIV.arrow_link")////*[@class='arrow_link']|
		private List<WebElement> Category_list;

		public List<WebElement> getCategory_list() {
			return Category_list;
		}

		@FindBy(xpath="//*[@css='DIV.catitem']")
		private List<WebElement> SubCategory_list;

		public List<WebElement> getSubCategory_list() {
			return SubCategory_list;
		}

		@FindBy(xpath="//*[@class='filter-options-title']")////*[@class='filter-options-item']
		private List<WebElement> Filterby;

		public List<WebElement> getFilterby() {
			return Filterby;


		}
//********************************My Orders Page
		
		@FindBy(xpath = "//*[@text='ORDER DETAILS']")
		private WebElement OrderDetails_text;
		public WebElement getOrderDetails_text() {
			return OrderDetails_text;
}	
	
		
		@FindBy(xpath = "(//*[@class='col-lg-5 col-5 pl-0'])[1]")
		private WebElement Customer_name_text;
		public WebElement getCustomer_name_text() {
			return Customer_name_text;
}		
		
		
		@FindBy(xpath = "(//*[@class='col-lg-7 col-7 p-0 text-right'])[1]")
		private WebElement Customer_name;
		public WebElement getCustomer_name() {
			return Customer_name;
				}		
		
		@FindBy(xpath = "(//*[@class='col-lg-7 col-7 p-0 text-right'])[2]")
		private WebElement OrderId;
		public WebElement getOrderId() {
			return OrderId;
				}	
		
		@FindBy(xpath = "(//*[@class='col-lg-5 col-5 pl-0'])[3]")
		private WebElement Order_placed_text;
		public WebElement getOrder_placed_text() {
			return Order_placed_text;
				}
		
		
		@FindBy(xpath = "(//*[@class='col-lg-7 col-7 p-0 text-right'])[3]")
		private WebElement Order_placed;
		public WebElement getOrder_placed() {
			return Order_placed;
				}	
		
			
		@FindBy(xpath = "//*[@class='btn btn-help btnhelpdark ng-star-inserted' and @top='true']")
		private WebElement NeedHelp_page;
		public WebElement getNeedHelp_page() {
			return NeedHelp_page;
				}
		

		
		@FindBy(xpath = "//*[@class='action order nmsreorder btn primary-btn ng-star-inserted' and @top='true']")
		private WebElement Reorder;
		public WebElement getReorder() {
			return Reorder;
				}	
		
		@FindBy(xpath = "//*[@class='btn-checkout btn btn_to_checkout']")
		private WebElement Proceed_btn;
		public WebElement getProceed_btn() {
			return Proceed_btn;
				}
		
	
		@FindBy(xpath = "//*[@text='Show Status Details']")
		private WebElement Show_Status_Details;
		public WebElement getShow_Status_Details() {
			return Show_Status_Details;
				}
		
		@FindBy(xpath = "//*[@nodeName='SPAN' and @top='true']")
		private WebElement Prescription_open;
		public WebElement getPrescription_open() {
			return Prescription_open;
				}
		
		
		@FindBy(xpath = "//*[@class='item ng-star-inserted' and @top='true'])[1]")
		private WebElement Prescription_closed;
		public WebElement getPrescription_closed() {
			return Prescription_closed;
				}

		
		@FindBy(xpath = "//*[@text='Medicine Orders']")
		private WebElement Myorders;
		public WebElement getMyorders() {
			return Myorders;
				}
		
		
		@FindBy(xpath = "(//*[@class='btn-view ord-btn'])[1]")
		private WebElement Viewdetails;
		public WebElement getViewdetails() {
			return Viewdetails;
				}
		
		@FindBy(xpath = "//*[@text='Cancel Order']|//android.widget.Button[@text='CANCEL ORDER']")
		private WebElement Cancelorder;
		public WebElement getCancelorder() {
			return Cancelorder;
				}
		
		
		@FindBy(xpath = "//*[@text='YES']|//android.widget.Button[@text='YES']")
		private WebElement Yesbutton;
		public WebElement getYesbutton() {
			return Yesbutton;
				}
		
		
		@FindBy(xpath = "(//*[@nodeName='LABEL' and @top='true'])[1]")
		private WebElement Cancel_reason;
		public WebElement getCancel_reason() {
			return Cancel_reason;
				}

		
		/// Msite Cart Page
		@FindBy(xpath = "//*[@css='SPAN.searchiconmobi.ng-star-inserted']")
		private WebElement Msite_Cart_Search;
		public WebElement getMsite_Cart_Search() {
			return Msite_Cart_Search;
		}
		
		@FindBy(xpath = "//*[@class='ais-SearchBox-input' and @top='true']")
		private WebElement Msite_Search_box;
		public WebElement getMsite_Search_box() {
			return Msite_Search_box;
		}
		
		@FindBy(xpath = "//*[@css='BUTTON.action.addcart']")
		private WebElement Msite_AddToCart;
		public WebElement getMsite_AddToCart() {
			return Msite_AddToCart;
		}
		
		
		@FindBy(xpath = "//*[@text='VIEW CART']")
		private WebElement Msite_ViewCart;
		public WebElement getMsite_ViewCart() {
			return Msite_ViewCart;
		}
		
		
		@FindBy(xpath = "//*[@title='Save For Later']")
		private WebElement Msite_SaveForLater;
		public WebElement getMsite_SaveForLater() {
			return Msite_SaveForLater;
		}
		
		
		@FindBy(xpath = "//*[@type='select-one']")
		private WebElement Msite_QtyBtn;
		public WebElement getMsite_QtyBtn() {
			return Msite_QtyBtn;
		}
		
		
		
		@FindBy(xpath = "(//*[@text='Remove'])[1]")
		private WebElement Msite_RemoveItem;
		public WebElement getMsite_RemoveItem() {
			return Msite_RemoveItem;
		}
		
		@FindBy(xpath = "")
		private WebElement Msite_Cart_Mostselling;
		
		////////////////////////////////////////////////////////////////////////////
		
		
		

	
//************************************************ Order Success Page
		
		
		@FindBy(xpath = "//*[@class='subscribe']")
		private WebElement Subscribe_now;
		public WebElement getSubscribe_now() {
			return Subscribe_now;
				}
		
		
		
		@FindBy(xpath = "//*[@class='deliver-cnt' and @top='true']")
		private WebElement Refill_msg;
		public WebElement getRefill_msg() {
			return Refill_msg;
				}
		
		@FindBy(xpath = "//*[@class='mode']")
		private WebElement Paymentmode_text;
		public WebElement getPaymentmode_text() {
			return Paymentmode_text;
	
		}
		
		@FindBy(xpath = "//*[@class='val']")
		private WebElement Paymentmethod_text;
		public WebElement getPaymentmethod_text() {
			return Paymentmethod_text;

		}
		
		@FindBy(xpath = "//*[@class='code-txt']")
		private WebElement Promocode;
		public WebElement getPromocode() {
			return Promocode;

		}
		
				
		@FindBy(xpath = "//*[@class='promo-txt']")
		private WebElement Promo_percentage;
		public WebElement getPromo_percentage() {
			return Promo_percentage;

		}

		
		@FindBy(xpath = "//*[@class='modify-txt']")
		private WebElement Modify_or_reschedule;
		public WebElement getModify_or_reschedule() {
			return Modify_or_reschedule;

		}
		@FindBy(xpath = "//*[@text='ENABLE SUBSCRIPTION']")
		private WebElement EnableSubscription;
		public WebElement getEnableSubscription() {
			return EnableSubscription;

		}

	//******************************************************************Consultation

		@FindBy(xpath="//*[@content-desc='Consult Now']|//*[@href='https://consult.netmeds.com/users/' and @top='true']")
		private WebElement Consultation_Btn;
		public WebElement getConsultation_Btn() {
			return Consultation_Btn;
		}
		
		@FindBy(xpath="//*[@content-desc='Consult Now']|//*[@href='https://consult.netmeds.com/users/' and @top='true']")
		private List<WebElement> Consultation_Btn_List;	
		public List<WebElement> getConsultation_Btn_List() {
			return Consultation_Btn_List;
		}


		@FindBy(xpath="//*[@text='START CONSULTATION ' and @top='true']")
		private WebElement Start_Consultation_Btn;
		public WebElement getStart_Consultation_Btn() {
			return Start_Consultation_Btn;
		}
		
		@FindBy(xpath = "//*[@text='Myself' and @top='true']")
		private WebElement Consult_MySelf;  
		public WebElement getConsult_MySelf() {
			return Consult_MySelf;
		}
		
		
		
		@FindBy(xpath = "//*[@text='Someone Else' and @top='true']")
		private WebElement Consult_Others;
		public WebElement getConsult_Others() {
			return Consult_Others;
		}
		
		@FindBy(xpath = "//*[@class='full-width text-area ng-untouched ng-pristine ng-valid' and @top='true']")
		private WebElement Consult_Symptons_TextBox;
		public WebElement getConsult_Symptons_TextBox() {
			return Consult_Symptons_TextBox;
		}
		
		@FindBy(xpath = "//*[@text='View All Specialisation']")
		private WebElement Consult_Specialist_ViewAll;
		public WebElement getConsult_Specialist_ViewAll() {
			return Consult_Specialist_ViewAll;
		}
		
		@FindBy(xpath = "//*[@text='ENT' and @top='true']")
		private WebElement Consult_ENT;
		public WebElement getConsult_ENT() {
			return Consult_ENT;
		}
		
		
		@FindBy(xpath = "//*[@text='Done' and @top='true']")
		private WebElement Consult_specilaisation_DoneBtn;
		public WebElement getConsult_specilaisation_DoneBtn() {
			return Consult_specilaisation_DoneBtn;
		}
		
		@FindBy(xpath = "//*[@text='START CONSULTATION ' and @top='true']|//*[@text='START CONSULTATION ']")
		private WebElement START_CONSULTATION_BTN;
		public WebElement getSTART_CONSULTATION_BTN() {
			return START_CONSULTATION_BTN;
		}
		
		@FindBy(xpath = "//*[@text='Chat' and @top='true']")
		private WebElement Consult_Chat_Text;
		public WebElement getConsult_Chat_Text() {
			return Consult_Chat_Text;
		}
		
		
		
		@FindBy(xpath = "//*[@text='Select' and @top='true']")
		private WebElement Consult_Doctor_select_btn;
		public WebElement getConsult_Doctor_select_btn() {
			return Consult_Doctor_select_btn;
		}
		
		@FindBy(xpath = "//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/text_chat']|//android.widget.TextView[@text='Chat']")
		private WebElement Consult_Chat;
		public WebElement getConsult_Chat() {
			return Consult_Chat;
		}
		
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/text_audio")
		private WebElement Consult_Audio;
		public WebElement getConsult_Audio() {
			return Consult_Audio;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/text_video")
		private WebElement Consult_Video;
		public WebElement getConsult_Video() {
			return Consult_Video;
		}
		
		@FindBy(id = "com.NetmedsMarketplace.Netmeds:id/text_video")
		private List<WebElement> Consult_Payment_Package_List;
		public List<WebElement> getConsult_Payment_Package_List() {
			return Consult_Payment_Package_List;
		}
		
		
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/btn_make_payment")
		private WebElement Consult_Pay_Btn;
		public WebElement getConsult_Pay_Btn() {
			return Consult_Pay_Btn;
		}
		
		@FindBy(id="com.NetmedsMarketplace.Netmeds:id/txtViewGeneralPhy")
		private WebElement Consult_general_Physician;
		public WebElement getConsult_general_Physician() {
			return Consult_general_Physician;
		}
				
		@FindBy(xpath="//*[@name='radio-button-off']")
		private List<WebElement> listofbanks;
		public List<WebElement> getListofbanks() {
			return listofbanks;
		}
		
		
}











		
	




