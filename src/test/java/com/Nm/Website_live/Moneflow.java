package com.Nm.Website_live;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Nm.Base.BaseClass;
import com.Nm.Pom.Monepom;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Moneflow extends BaseClass {

	ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
	@BeforeTest(groups = {"forgetPassword","sanity","reg"})
    public void startReport() {
    	
       htmlReporter = new ExtentHtmlReporter("C:\\Users\\Admin\\eclipse-workspace\\sample\\report\\sample.html");
        
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
        htmlReporter.config().setReportName("Test Report");

        //htmlReporter.config().setTheme(Theme.STANDARD);
    	
    }
	@Test
	public  void test1() throws Throwable  {
		logger =  report.createTest(" All Categories");
		logger.log(Status.PASS, "*************m1 flow********************" );
		Monepom m=new Monepom();
		driver.manage().window().maximize();
		btncli(m.getSignin());
		Thread.sleep(5000);
		type(m.getMobileno(),"9677159095");
		btncli(m.getPass());
		Thread.sleep(3000);
		type(m.getPassword(),"test4nm");
		btncli(m.getSignInpage());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to home page" );

		type(m.getSearch(), "Patanjali Lauh Bhasm Powder 5 gm");
		btncli(m.getSearchIcon());
		logger.log(Status.PASS, "Successfully navigate to search result page" );

		Thread.sleep(3000);
		btncli(m.getAddtocart());
		btncli(m.getMinicart());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to cart page" );
		btncli(m.getProceedbutton());
		Thread.sleep(3000);
		logger.log(Status.PASS, "Successfully navigate to search order review page" );
		btncli(m.getPaybutton());
		Thread.sleep(3000);
		String gettext = gettext(m.getPaydeatailText());
		Assert.assertEquals(gettext, "Payment Details");
		logger.log(Status.PASS, "Successfully navigate to search payment Details page" );

		Thread.sleep(3000);
		driver.navigate().to("https://www.netmeds.com/checkout/cart");
		Thread.sleep(3000);
		btncli(m.getRemovebutton());
		logger.log(Status.PASS, "Successfully Removed the product " );
		/*WebElement signin = driver.findElement(By.xpath("//a[text()=' Sign in / Sign up '] "));
        signin.click();
        Thread.sleep(5000);
WebElement mob = driver.findElement(By.id("loginfirst_mobileno"));
mob.sendKeys("9677159095");
WebElement pass = driver.findElement(By.xpath("(//button[@type='submit'])[5]"));
pass.click();*/
}
	@AfterMethod()
	public void screenShot(ITestResult result) {
		
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
	    }}	
		


	@AfterTest
	private void quitbrowser() {
		report.flush();
driver.quit();
	}

}
