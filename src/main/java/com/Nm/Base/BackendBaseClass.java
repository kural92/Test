package com.Nm.Base;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class BackendBaseClass {
	
	public static WebDriver driver=null;
    public static  Actions a;
	public static Robot r;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static  ExtentTest logger;
	
	
	public static void  launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NMSLAP369\\eclipse-workspace\\ProjectNetmeds\\Driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");
		options.setExperimentalOption("debuggerAddress", "localhost:9222");
		driver=new ChromeDriver(options);
		driver.get("https://s1-meds.netmeds.com/");
		
	}
	
	public static void sendkeys(WebElement ele, String name) {
		ele.sendKeys(name);
	}
	
	public static void clk(WebElement elem) {
		elem.click();
	}
	
	public static void quit() {
		driver.quit();
	}
	public static void scrolldown(String Size) throws InterruptedException  {
		Thread.sleep(1500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", Element);
		js.executeScript("window.scrollBy(0,"+Size+")");
	}
	public static int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(".//Test Data//SMSTEST.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int rowIndex = wb.getSheet(sheetName).getLastRowNum();
	return rowIndex;
	}
	public static String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
		FileInputStream fis = new FileInputStream(".//Test Data//SMSTEST.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	String data = row.getCell(colNum).getStringCellValue();
	wb.close();
		return data;
	}
	public static void moveElement(WebElement url) {
		a = new Actions (driver);
		a.moveToElement(url).perform();
	}
	public static void pageTitle() {
		String titleName = driver.getTitle();
		System.out.println(titleName);
	}
	public static void pageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}
	public static void clickDouble(WebElement eleme) {
		a = new Actions (driver);
		a.doubleClick(eleme).perform();
	}
	public static void clickRight(WebElement elemen) {
		a = new Actions (driver);
		a.contextClick(elemen).perform();
	}
	
	public static void thread(long Value) throws InterruptedException {
		Thread.sleep(Value);
		
	}
	public static void back() {
		driver.navigate().back();
		
	}
	public static void handleWindows(String Url) {
		driver.switchTo().window(Url);
	}
	
	public static void buttonEnter() throws Throwable {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public static void Navi(String Url) {
		driver.navigate().to(Url);
	}
	
	
	public static void mail_report() {
		
		 report.flush();
	  final String username = "netmedsautomationreport@gmail.com";
	  final String password = "test@123"; 
	  
	  
	 /* final String username = "cbsautomationreport@gmail.com";
	final String password = "cbstest123"; */
	Date date=new Date();
	  Properties props = new Properties();
	  props.put("mail.smtp.auth", true);
	  props.put("mail.smtp.starttls.enable", true);
	  props.put("mail.smtp.host", "smtp.gmail.com");
	  props.put("mail.smtp.port", "587");

	  Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	          return new PasswordAuthentication(username, password);
	      }
	  });
	  Message message = new MimeMessage(session);

	  try {

	     // message.setFrom(new InternetAddress("cbsautomationreport@gmail.com"));
	      message.setFrom(new InternetAddress("qamanual21@gmail.com"));
	      message.setSubject("Take Action Alert Mail"+date);

	     message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("charumathi.babuanand@netmeds.com,charu4senti@gmail.com"));
	      //message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(,balasanthoshkumar.r@netmeds.com)
	      Multipart multipart = new MimeMultipart();

	      MimeBodyPart messageBodyPart = new MimeBodyPart();
	      messageBodyPart.setText("Hi Team,"+"\n\n"+"Please find the attached File for the Take Action Alert Message."+"\n"+"\n"+"\n"+"\n\n\n"+"Regards,"+"\n"+"Testing Team.");
	      MimeBodyPart attachmentBodyPart = new MimeBodyPart();


	     String file = ".//Report//get";  // File To Attach
	   //   String url=currentUrl;

	      //String fileName = "CBS-AutomationReport-Desktop";
	      DataSource source = new FileDataSource(file);
	      // messageBodyPart.setDataHandler(new DataHandler(source));
	      attachmentBodyPart.setDataHandler(new DataHandler(source));
	      attachmentBodyPart.setText(file);
	      //attachmentBodyPart.setFileName("Login.png");

	      multipart.addBodyPart(messageBodyPart);
	      multipart.addBodyPart(attachmentBodyPart);

	      message.setContent(multipart);
	      

	      System.out.println("Sending....");

	      Transport.send(message);

	      System.out.println("Mail Sent Successfully");

	  } catch (MessagingException e) {
	      e.printStackTrace();
	  }
		
	}
	
	
}
	
