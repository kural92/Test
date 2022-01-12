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


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Excelutlis;

public class Backflowapi extends BackendBaseClass  {

	
	//@BeforeClass
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
String mobilenumber="9677159095";
		
		 RequestSpecification noUserid = RestAssured.given();
			noUserid.queryParam("val", mobilenumber);
			noUserid.queryParam("channel", "web");
			
			Response response = noUserid.request(Method.GET, "https://s1-meds.netmeds.com/mst/rest/v1/session/create/using_mobileno");
		   // System.out.println(response.getBody().asString());
		    String id = response.jsonPath().get("result.session.id").toString();
		    String customer_id = response.jsonPath().get("result.session.customer_id").toString();
		    RequestSpecification noUserid1 = RestAssured.given();
		    noUserid1.header("userid",customer_id );
		    noUserid1.header("authtoken", id );
		    Response response1 = noUserid1.request(Method.GET, "https://s1-meds.netmeds.com/mst/rest/v1/cart/create");
System.out.println(response1.asString());
	
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
