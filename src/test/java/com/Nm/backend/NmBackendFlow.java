
package com.Nm.backend;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Base.BackendBaseClass;
import com.Nm.Pom.backendPom;

public class NmBackendFlow extends BackendBaseClass{
	
	@BeforeClass
	public  void browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NMSLAP369\\Downloads\\nm.webFlow\\input\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		options.setExperimentalOption("debuggerAddress", "localhost:9222");
		driver=new ChromeDriver(options);
		driver.get("https://s1-meds.netmeds.com/");
		
	}
	@Test
	public void test() throws Throwable {
		backendPom s = new backendPom();
		thread(3000);
		try {
			sendkeys(s.getSearch(), "Pan d");
			buttonEnter();
			
		} catch (Exception e) {
			
			// TODO: handle exception
		}
		
		thread(3000);
		
		clk(s.getPDP_AddtoCart_btn());
		clk(s.getHomecart());
		thread(2000);
		clk(s.getCart_Proceed());
		thread(3000);
		
		clk(s.getPastRx_button());
		thread(3000);
		
		clk(s.getPastRx_Image());

		
		clk(s.getPastRx_close());
		clk(s.getReview_button());
		
		clk(s.getPay_button());
		
		
		Navi("https://s1-meds.netmeds.com/checkout/payment-information");
		thread(3000);
		try {
			clk(s.getCOD_Radio());
			clk(s.getPay_COD());
		} catch (Exception e) {
			
		}
		
	
		thread(3000);
		Navi("https://s1-meds.netmeds.com/");
		driver.navigate().refresh();
		thread(2000);
		clk(s.getUserprofile());
		clk(s.getYourAcc_MediOrder());
		thread(2000);
		clk(s.getDetails_Button());
		
		
		thread(3000);
		WebElement cusName = s.getCustomerName_OrderDet();
		String AppName = cusName.getAttribute("innerText");
		System.out.println(AppName);
		
		WebElement orderID = s.getOrderID_OrderDet();
		String AppID = orderID.getAttribute("innerText");
		System.out.println(AppID);
		
		WebElement orderStatus = s.getStatus_OrderDet();
		String AppStatus = orderStatus.getAttribute("innerText");
		System.out.println(AppStatus);
		
		WebElement orderAdd = s.getAddress_OrderDet();
		String AppAdd  = orderAdd.getAttribute("innerText");
		System.out.println(AppAdd);
		
		WebElement OrderAmnt = s.getAmount_OrderDet(); 
		String AppAmount  = OrderAmnt.getAttribute("innerText");
		System.out.println(AppAmount);
		
		WebElement ModePay = s.getPaymentMode_OrderDet(); 
		String AppPayMode  = ModePay.getAttribute("innerText");
		System.out.println(AppPayMode);
		
		((JavascriptExecutor)driver).executeScript("window.open()");
	    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	    
	    driver.switchTo().window(tabs.get(1));
		Navi("https://stg-win.netmeds.com/s1-bo/login.aspx");
		
		sendkeys(s.getUserName_View(), "view");
		sendkeys(s.getPassword_View(), "view123");
		clk(s.getLoginButton_View());
		
		sendkeys(s.getOrderCode_View(), AppID);
		thread(1000);
		
		clk(s.getChck1_View());
		clk(s.getChck2_View());
		clk(s.getChck3_View());
		clk(s.getChck4_View());
		clk(s.getChck5_View());
		clk(s.getChck6_View());
		clk(s.getChck7_View());
		clk(s.getChck8_View());
		clk(s.getChck9_View());
		clk(s.getChck10_View());
		clk(s.getChck11_View());
		clk(s.getChck12_View());
		clk(s.getChck13_View());
		clk(s.getChck14_View());
		
	
		clk(s.getSubmit_View());
		
		WebElement NameView = s.getCustName_View();
		String ViewName = NameView.getText();
		System.out.println(ViewName);
		
		WebElement IDView = s.getOrderID_View();
		String ViewOrderId = IDView.getText();
		System.out.println(ViewOrderId);
		
		WebElement ModeView = s.getPayMode_View();
		String ViewPayMode = ModeView.getText();
		System.out.println(ViewPayMode);
		
		WebElement StatuView = s.getStatus_View();
		String ViewStatus = StatuView.getText();
		System.out.println(ViewStatus);
		
		WebElement IDPay = s.getAmount_View();
		String ViewPaymnt = IDPay.getText();
		System.out.println(ViewPaymnt);
		
		WebElement AddView = driver.findElement(By.xpath("//span[@id='lblsfirstname']"));
		String ViewAddress = AddView.getText();
		System.out.println(ViewAddress);
		
		SoftAssert sof = new SoftAssert();
		
		sof.assertEquals(ViewName, AppName);
		System.out.println("Customer Name is true");
		sof.assertEquals(IDView, AppID);
		System.out.println("ID is equal");
		sof.assertEquals(ViewPayMode, AppPayMode);
		System.out.println("Payment mode is cash on deivery");
		sof.assertEquals(ViewPaymnt, AppAmount);
		System.out.println("Price of the product is equal");
		sof.assertEquals(ViewStatus, AppStatus);
		System.out.println("Mode of payment is equal");
		sof.assertEquals(ViewAddress, AppAdd);
		System.out.println("Order Address is Equal");
		
		Navi("https://stg-win.netmeds.com/s1-nmsbackpanel/UI/Common/Login_new.aspx");
		
		thread(3000);
		
		sendkeys(s.getUsername_BO(), "test");
		sendkeys(s.getPassword_BO(), "test123");
		clk(s.getBtnLogin_BO());
		
		thread(2000);
		clk(s.getOrderUpd_BO());
		
		sendkeys(s.getOrderCode_BO(), AppID);
		
		clk(s.getViewButton_BO());
		
		clk(s.getViewButton1_BO());
		
		thread(2000);
		
		WebElement OrdDes = driver.findElement(By.id("ContentPlaceHolder1_ddlstatus"));
		
		thread(3000);
		
		Select se = new Select (OrdDes);
		
		se.selectByVisibleText("Processing");
		
		clk(s.getUpdateButton_BO());
		
		driver.switchTo().window(tabs.get(0));
		Navi("https://stg-win.netmeds.com/s1-bo/login.aspx");
		sendkeys(s.getUserName_View(), "view");
		sendkeys(s.getPassword_View(), "view123");
		clk(s.getLoginButton_View());
		
		sendkeys(s.getOrderCode_View(), AppID);
		thread(1000);
		
		clk(s.getChck1_View());
		clk(s.getChck2_View());
		clk(s.getChck3_View());
		clk(s.getChck4_View());
		clk(s.getChck5_View());
		clk(s.getChck6_View());
		clk(s.getChck7_View());
		clk(s.getChck8_View());
		clk(s.getChck9_View());
		clk(s.getChck10_View());
		clk(s.getChck11_View());
		clk(s.getChck12_View());
		clk(s.getChck13_View());
		clk(s.getChck14_View());
		
		clk(s.getSubmit_View());
		
		WebElement StatuView1 = s.getStatus_View();
		String ViewStatusChange = StatuView1.getText();
		System.out.println("Status of the order has been changed to"+ ViewStatusChange);
		
		driver.switchTo().window(tabs.get(1));
		Navi("https://stg-win.netmeds.com/ccpanel/Dashboard");
		
		thread(10000);
		try {
			sendkeys(s.getUsername_FC(), "karthik.d@netmeds.com");
			sendkeys(s.getPassword_FC(), "Netmeds@123");
			clk(s.getLoginButton_FC());
		} catch (Exception e) {
			// TODO: handle exception
		}
		thread(3000);
		try {
			clk(s.getManuSubmit_FC());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		driver.navigate().to("https://stg-win.netmeds.com/ccpanel/OrderSubmit/FcSelection");
		thread(3000);
		
		sendkeys(s.getOrderID_FC(),AppID);
		clk(s.getSubmit1_FC());
		thread(1000);
		WebElement FC = driver.findElement(By.xpath("//select[@id='drpfcvals']"));
		
		Select Sel = new Select (FC);
		Sel.selectByValue("20008");
		clk(s.getUpdate_FC());
		thread(1000);
		
		driver.switchTo().window(tabs.get(0));
		driver.navigate().refresh();
		thread(3000);
		WebElement Suborder = s.getSuborderID_View();
		String subOrID = Suborder.getText();
		System.out.println("Sub Order ID:" + subOrID);
		
	}

}
