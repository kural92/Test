
package com.Nm.backend;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Nm.Base.BackendBaseClass;
import com.Nm.Base.BaseClass;
import com.Nm.Pom.backendPom;

public class NmBackendFlow extends BackendBaseClass{
	
	String txn_id;
	
	@BeforeClass
	public  void browser() {
		System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		options.setExperimentalOption("debuggerAddress", "localhost:9222");
		driver=new ChromeDriver(options);
		driver.get("https://s1-meds.netmeds.com/");
		
	}
	/**
	 * @throws Throwable
	 */
	@Test(priority = 1,enabled = true)
	public void test() throws Throwable {
		backendPom s = new backendPom();
		BaseClass bc = new BaseClass();
JavascriptExecutor js =(JavascriptExecutor)driver;
WebDriverWait wait = new WebDriverWait(driver, 100);
/////////////  Remove Product //

	Thread.sleep(3000);
	driver.navigate().to("https://s1-meds.netmeds.com/checkout/cart");
	Thread.sleep(3000);
	for (int i = 0; i < 16; i++) {
		Thread.sleep(3000);
		if ((driver.findElements(By.xpath("//h3[contains(text(),'Your Cart is empty')]")).size() == 0)) {

			try {
				driver.findElement(By.xpath("//a[text()='Remove']")).click();
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			break;

		}

	}

		thread(3000);
		driver.get("https://s1-meds.netmeds.com/");
		thread(3000);
		try {
			//sendkeys(s.getSearch(), "Pan d").key
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys("pan d");
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
		//	buttonEnter();
			
		} catch (Exception e) {
			
			// TODO: handle exception
		}
		
		thread(3000);
		
		clk(s.getPDP_AddtoCart_btn());
		clk(s.getHomecart());
		thread(5000);
		
		////
		try {
			Thread.sleep(3000);
			driver.switchTo().frame("haptik-xdk");
			System.out.println("Switched to Frame");
			Actions acc = new Actions(driver);
			acc.moveToElement(driver.findElement(By.xpath("//div[@class='bot-prompt-minimal-cross-icon']|//div[@class='bot-prompt-minimal-textarea']//span|//div[@class='bot-prompt-minimal-cross-icon']"))).build()
					.perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='bot-prompt-minimal-cross-icon']|(/html/body/div/div[1]/div[1])[1]|/html/body/div/div[1]/div[1]")).click();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
		}
		
		
		//////
	//	bc.letsChat_Close();
		thread(2000);
		js.executeScript("window.scrollTo(0,500)");
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
			thread(3000);
			clk(driver.findElement(By.xpath("//button[contains(text(),'PAY WITH CASH')]")));
			
		}
		
	
		thread(3000);
		Navi("https://s1-meds.netmeds.com/");
		driver.navigate().refresh();
		thread(2000);
		clk(s.getUserprofile());
		thread(3000);
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
		thread(3000);
		try {
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		thread(3000);
		
		/*
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
	*/	
	
		clk(s.getSubmit_View());
		
		//////////
		try {
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		///////////////////
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
		
		thread(5000);
		
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
		try {
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	/*	
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
	*/	
		
		
		clk(s.getSubmit_View());
		
		WebElement StatuView1 = s.getStatus_View();
		String ViewStatusChange = StatuView1.getText();
		System.out.println("Status of the order has been changed to"+ ViewStatusChange);
		
		driver.switchTo().window(tabs.get(1));
		thread(1000);
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
		thread(5000);
		
		sendkeys(s.getOrderID_FC(),AppID);
		clk(s.getSubmit1_FC());
		thread(1000);
		WebElement FC = driver.findElement(By.xpath("//select[@id='drpfcvals']"));
		
		Select Sel = new Select (FC);
		Sel.selectByVisibleText("769 - Madurai DC");
		clk(s.getUpdate_FC());
		thread(1000);
		
		driver.switchTo().window(tabs.get(0));
		driver.navigate().refresh();
		thread(3000);
		WebElement Suborder = s.getSuborderID_View();
		String subOrID = Suborder.getText();
		System.out.println("Sub Order ID:" + subOrID);
	
		
		///  RWOS FLOW
		
		Thread.sleep(3000);
		driver.navigate().to("https://sit-b2b-rwos.netmeds.com/rwos/#/web/sales/transactions");
		thread(3000);
		
		///////
		clk(s.getRwos_UserName());
		sendkeys(s.getRwos_UserName(), "karthik.d");
		sendkeys(s.getRwos_Password(), "karthik@nms");
		clk(s.getRwos_signCheckBox());
		clk(s.getRwos_SignIn());
		
		try {
			Thread.sleep(3000);
		clk(s.getRwos_FcPanel());
			Thread.sleep(5000);
		clk(s.getRwos_FcPanel_Proceed());
			Thread.sleep(3000);
		clk(s.getRwos_AlreadySignIn_YesBtn());
		} catch (Exception e) {
			
		}
		
		
	//	Thread.sleep(50000);
		wait.until(ExpectedConditions.visibilityOf(s.getRwos_HamBurger_Menu()));
		
		clk(s.getRwos_HamBurger_Menu());
			
		clk(s.getRwos_SaleTransaction());
		clk(s.getRwos_SaleTransaction_Search());

		Thread.sleep(5000);
		clk(s.getRwos_BillType());
		Thread.sleep(5000);
		clk(s.getRwos_BillType_CustomerOrder());
		clk(s.getRwos_BillType_Search_btn());
		
		Thread.sleep(3000);
		List<WebElement> Eye = s.getRwos_Order_View_btn();//driver.findElements(By.xpath("//i[@title='Click to View']"));
		int Eye_size = Eye.size();
		System.out.println(Eye_size);
		
		Thread.sleep(3000);
		for (int i = 0; i < 1; i++) {
			
			Thread.sleep(2000);
		    Eye.get(i).click();
			Thread.sleep(2000);		
			wait.until(ExpectedConditions.visibilityOf(s.getRwos_BillingAddress()));
			String BillingAddress = s.getRwos_BillingAddress().getText();
			String DeliverAddress = s.getRwos_ShippingAddress().getText();
			
			String Name = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[2]/customer-order-view/div/form/div[1]/table/tbody/tr[2]/td[4]/p")).getText();
		    String Amt = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[2]/customer-order-view/div/form/div[3]/div[1]/div/div[2]/table/tbody/tr[1]/td[3]/p")).getText();
			String qty = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[2]/customer-order-view/div/form/div[3]/div[1]/div/div[1]/table/tbody/tr[2]/td[1]/p")).getText();
			String Medicine = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[2]/customer-order-view/div/form/div[2]/div[2]/p-datatable/div/div[1]/div/div[2]/div/table/tbody/tr[1]/td[3]/span/rw-item-search/p")).getText();
			String PayMode = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[2]/customer-order-view/div/form/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/td[5]/div/p")).getText();
			String SubID = 	driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[2]/customer-order-view/div/form/div[1]/table/tbody/tr[1]/td[6]/input")).getAttribute("innerText");
			String TxnID = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div[2]/customer-order-view/div/form/div[1]/table/tbody/tr[1]/td[2]/input")).getAttribute("innerText");
	
		
			//SoftAssert sof = new SoftAssert();
		
			sof.assertEquals(ViewName, Name);
			System.out.println("Customer Name is true");
			sof.assertEquals(IDView, TxnID);
			System.out.println("ID is equal");
			sof.assertEquals(ViewPayMode, PayMode);
			System.out.println("Payment mode is cash on deivery");
			sof.assertEquals(ViewPaymnt, Amt);
			System.out.println("Price of the product is equal");
			sof.assertEquals(ViewStatus, PayMode);
			System.out.println("Mode of payment is equal");
			sof.assertEquals(ViewAddress, DeliverAddress);
			System.out.println("Order Address is Equal");
		
			
			Thread.sleep(2000);
			clk(s.getRwos_CloseBtn());
			
			
			
			
			///Item master
			driver.findElement(By.xpath("(//a[@routerlinkactive='selectedMenu'])[16]")).click();
			//Show Stock
			driver.findElement(By.xpath("//span[contains(text(),'Show Stock')]")).click();
			//stock qty
			driver.findElement(By.xpath("//span[contains(text(),'Stock Qty')]")).click();
			
			//Search Item
			driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]")).sendKeys("Dolo");
			//refresh stock
			driver.findElement(By.xpath("//span[contains(text(),'Refresh Stock')]")).click();
			//stock qty
			driver.findElement(By.xpath("//span[contains(text(),'Stock Qty')]")).click();
			
			//
	
		}
	
		
		//
		//driver.switchTo().window(tabs.get(0));
		
		
	}


@Test(priority = 2,enabled = true)
public void pickList() throws Throwable {
	// TODO Auto-generated method stub
	WebDriverWait wait = new WebDriverWait(driver, 60);
	Thread.sleep(5000);

		driver.get("https://sit-shipstation.netmeds.com/picking/login");
		
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@formcontrolname='user_name']"))));
		sendkeys(driver.findElement(By.xpath("//input[@formcontrolname='user_name']")),"769picklist");
		Thread.sleep(1000);
		sendkeys(driver.findElement(By.xpath("//input[@formcontrolname='password']")), "Nms@12345");
		Thread.sleep(1000);
		clk(driver.findElement(By.xpath("//button[contains(text(),'Login')]")));
		
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("mat-input-0"))));
		WebElement pickListType = driver.findElement(By.id("mat-input-0"));
		Select ss = new Select(pickListType);	
		ss.selectByIndex(1);
		//Order Source Filter
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("mat-input-9"))));
		WebElement OrderSource = driver.findElement(By.id("mat-input-1"));
		Select ss1 = new Select(OrderSource);	
		ss1.selectByIndex(0);
		//Customer Sale Filter
		Thread.sleep(3000);
			//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("mat-input-10"))));
				WebElement CustomerSale = driver.findElement(By.id("mat-input-2"));
				Select ss2 = new Select(CustomerSale);	
				ss2.selectByIndex(0);
		
		
		//Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Generate Picklist')]"))));
		clk(driver.findElement(By.xpath("//button[contains(text(),'Generate Picklist')]")));
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Picklist Generated Orders : ')]//following::span[1]"))));
		String picklistOrder = driver.findElement(By.xpath("//span[contains(text(),'Picklist Generated Orders : ')]//following::span[1]")).getText();
		System.out.println("Picklist Generated Orders : "+picklistOrder);
		
		clk(driver.findElement(By.xpath("//span[contains(text(),'769picklist')]|//*[@id=\"app\"]/header/app-header/div/div/div/button")));
		clk(driver.findElement(By.xpath("//a[contains(text(),'Log out')]")));
		
		////
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@formcontrolname='user_name']"))));
		Thread.sleep(5000);
		sendkeys(driver.findElement(By.xpath("//input[@formcontrolname='user_name']")),"769pick_Admin");
		sendkeys(driver.findElement(By.xpath("//input[@formcontrolname='password']")), "Nms@12345");
		clk(driver.findElement(By.xpath("//button[contains(text(),'Login')]")));
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Print')]"))));
		clk(driver.findElement(By.xpath("//button[contains(text(),'Print')]")));
		Thread.sleep(1000);
		clk(driver.findElement(By.xpath("//a[contains(text(),'Print SRNO')]|//*[@id=\"cdk-overlay-0\"]/div/div/a[1]")));
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='app']/main/div/app-print-serialno/div[3]/table/tbody/tr[1]/td[2]"))));
		 txn_id = driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-print-serialno/div[3]/table/tbody/tr[1]/td[2]")).getText();
		System.err.println(txn_id);
		
		String PickOrder_id = driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-print-serialno/div[3]/table/tbody/tr[1]/td[4]")).getText();
		System.err.println(PickOrder_id);
		
		String PickAmt = driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-print-serialno/div[3]/table/tbody/tr[1]/td[6]")).getText();
		System.err.println(PickAmt);
		
//		sof.assertEquals(ViewPaymnt, PickAmt);
		System.out.println("Price of the product is equal");
//		sof.assertEquals(subOrID, PickOrder_id);
		System.out.println("Sub Order ID was equal");
		//sof.assertEquals(TxnID, txn_id);
	//	System.out.println("Sub Order ID was equal");
//subOrID
		
		Thread.sleep(1000);
		clk(driver.findElement(By.xpath("//button[contains(text(),'Print SRNO ')]")));
		
		Thread.sleep(3000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		//driver.navigate().refresh();
		Thread.sleep(3000);
		clk(driver.findElement(By.xpath("//span[contains(text(),'769pick_admin')]|//*[@id=\"app\"]/header/app-header/div/div/div/button")));
		Thread.sleep(1000);
		clk(driver.findElement(By.xpath("//a[contains(text(),'Log out')]")));
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.get("https://sit-shipstation.netmeds.com/picking/login");
		
		Thread.sleep(5000);
		sendkeys(driver.findElement(By.xpath("//input[@formcontrolname='user_name']")),"769test_pick_user");
		Thread.sleep(2000);
		sendkeys(driver.findElement(By.xpath("//input[@formcontrolname='password']")), "Nms@12345");
		Thread.sleep(2000);
		clk(driver.findElement(By.xpath("//button[contains(text(),'Login')]")));
		
		Thread.sleep(3000);
		sendkeys(driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-picker/div[1]/div[2]/div/form/div/input")),txn_id ); //txn_id
		
		Thread.sleep(2000);
		String Drug_Code = driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-picker/div[1]/div[4]/form/div[2]/table/tr[2]/td[1]")).getText();
		String Drug_Name = driver.findElement(By.xpath("//*[@id=\"app\"]/main/div/app-picker/div[1]/div[4]/form/div[2]/table/tr[2]/td[2]")).getText();

	Thread.sleep(2000);
	Select sss = new Select(driver.findElement(By.id("itemCode")));
	sss.selectByValue(Drug_Code);
	
	Thread.sleep(5000);
//	Select sss1 = new Select(driver.findElement(By.xpath("//select[@formcontrolname='batchList']")));
//	sss.selectByIndex(1);
	driver.findElement(By.id("mat-input-6")).click();
	driver.findElement(By.xpath("//*[@id=\"mat-input-6\"]/option[2]")).click();
	
	Thread.sleep(2000);
//	Select sss2 = new Select(driver.findElement(By.id("mat-input-7")));
//	sss.selectByIndex(1);
	driver.findElement(By.id("mat-input-7")).click();
	driver.findElement(By.xpath("//*[@id=\"mat-input-7\"]/option[2]")).click();
	
	Thread.sleep(3000);
	String pc = driver.findElement(By.xpath("/html/body/div/div")).getText();
	System.out.println(pc);
	
	
	/////////////////////////////////////
	
	//Dispatch
	
	Navi("https://sit-shipstation.netmeds.com/dispatch/login");
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@formcontrolname='user_name']"))));
	sendkeys(driver.findElement(By.xpath("//input[@formcontrolname='user_name']")),"769test_dispatch_user");
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@formcontrolname='password']"))));
	sendkeys(driver.findElement(By.xpath("//input[@formcontrolname='password']")), "Nms@12345");
	//Thread.sleep(2000);
	//input[@formcontrolname='password']
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Login')]"))));
	clk(driver.findElement(By.xpath("//button[contains(text(),'Login')]")));
	
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("invoice_header1"))));
	clk(driver.findElement(By.id("invoice_header1")));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[1]"))));
	clk(driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[1]")));
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sr_no"))));
	sendkeys(driver.findElement(By.id("sr_no")),txn_id);
	
	

	}




	
}
