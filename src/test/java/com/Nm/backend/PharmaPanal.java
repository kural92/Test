package com.Nm.backend;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.BackendBaseClass;
import com.Nm.Pom.backendPom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class PharmaPanal extends BackendBaseClass {

	
	@BeforeClass
	public  void browser() {

		System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe"); //D:\\Automation\\Driver\\chromedriver.exe
	driver= new ChromeDriver();
		//driver.get("https://www.netmeds.com");
		
		driver.manage().window().maximize();
		
		
	
		
	}
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
	   public void startReport() {
	   	
	      htmlReporter = new ExtentHtmlReporter(".//Report//Backendorderflow.html");
	       
	       //initialize ExtentReports and attach the HtmlReporter
	       report = new ExtentReports();
	       
	     // htmlReporter.setAppendExisting(true);
	       report.attachReporter(htmlReporter);
	       report.setSystemInfo("Host name", "localhost");
	       report.setSystemInfo("Environemnt", "QA");
	       report.setSystemInfo("user", "Automation Team");
	   
	       //configuration items to change the look and feel
	       //add content, manage tests etc

	       htmlReporter.config().setDocumentTitle("Extent Report ");
	       htmlReporter.config().setReportName("NetMeds.com");

	      // htmlReporter.config().setTheme(Theme.DARK);
	   	
	   }
		
	@Test
	public void test() throws Throwable {
		backendPom s = new backendPom();
		logger =  report.createTest("pharmapanel login");
		logger.log(Status.PASS, "*************order move to control center********************" );
		int rowCount = BackendBaseClass.getRowCount("orderIds");
		System.out.println("total order'count ="+rowCount);
for (int i = 0; i <= rowCount; i++) {
	

		Navi("https://stg-win.netmeds.com/s1-bo/login.aspx");
		Thread.sleep(3000);
		sendkeys(s.getUserName_View(), "view");
		sendkeys(s.getPassword_View(), "view123");
		clk(s.getLoginButton_View());
		String AppID=getExcelData("orderIds", i, 0);
		logger.log(Status.PASS, "order id"+AppID );

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
		
		
		
		Thread.sleep(3000);
		
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
		
		thread(5000);
		
		Select se = new Select (OrdDes);
		
		se.selectByVisibleText("Processing");
		
		clk(s.getUpdateButton_BO());
		thread(5000);
		//driver.switchTo().window(tabs.get(0));
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
		
		//driver.switchTo().window(tabs.get(1));
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
		
			clk(s.getManuSubmit_FC());
			
		
			
		//driver.navigate().to("https://stg-win.netmeds.com/ccpanel/OrderSubmit/FcSelection");
		thread(3000);
		
		sendkeys(s.getOrderID_FC(),AppID);
		clk(s.getSubmit1_FC());
		thread(2000);
		WebElement FC = driver.findElement(By.xpath("//select[@id='drpfcvals']"));
		
		Select Sel = new Select (FC);
		Sel.selectByValue("20008");
		clk(s.getUpdate_FC());
		thread(1000);
		Navi("https://stg-win.netmeds.com/s1-bo/login.aspx");
		Thread.sleep(3000);
		
		try { 
			Thread.sleep(3000);
			sendkeys(s.getUserName_View(), "view");
			sendkeys(s.getPassword_View(), "view123");
			clk(s.getLoginButton_View());
		}catch (Exception e) {
			// TODO: handle exception
		}
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
		thread(3000);
		scrolldown("300");
		WebElement Suborder = s.getSuborderID_View();
		String subOrID = Suborder.getText();
		System.out.println("Sub Order ID:" + subOrID);
		logger.log(Status.PASS, "Sub Order ID:" + subOrID);

}	
	}

	@AfterMethod()
	public void screenShot(ITestResult result) throws Throwable {
		
	    if(result.getStatus() == ITestResult.FAILURE) {
	    	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	    	logger.fail(result.getThrowable());
	    	try {
				

				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src, new File("./Report/"+ result.getName()+".png"));
				System.out.println("Successfully captured a screenshot");
				//logger.log(Status.FAIL, result.getThrowable());
				logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath( result.getName()+".png"));
			
		
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	      }
	 
	    else if(result.getStatus() == ITestResult.SUCCESS) {
	    	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	    
	    }
	    else {
	    
	    	 // onFinish(context);
	    	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	    	logger.skip(result.getThrowable());
	    	report.removeTest(logger);
	    }
	    
	    
	    
	Thread.sleep(3000);
	if (result.getStatus() == ITestResult.FAILURE) {
		Thread.sleep(3000);
	//	BaseClass.mail_report();
	
		
	//	BaseClass.mail_report();
	}
	
	
	}	
		


	@AfterTest
	private void quitbrowser() {
		report.flush();
		
  //    driver.quit();
	}
}

