package com.Nm.Pom;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Base {
	
	public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;
	

	public static WebDriver driver=null;
	@BeforeClass
	public WebDriver launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\nm.webFlow\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
		 driver = new ChromeDriver(options);
		driver.get("https://www.netmeds.com");
		
		return driver;
	}
	public void loadurl(String url) {
	driver.get(url);
	}
	
	public void type(WebElement element ,String name) {
		element.sendKeys(name);
	}
	
	public void btncli(WebElement element) {
	element.click();	
	}
	public void selectbyvalue(WebElement element,String name) {
		new Select (element).selectByValue(name);
	}
	public void selectbyindex(WebElement element,int index) {
		new Select (element).selectByIndex(index);
	}
	public void selectbytext(WebElement element,String text) {
		new Select (element).selectByValue(text);
	}
	public void mouse(WebElement element) {
	new Actions(driver).moveToElement(element).perform();
	}
	public void right(WebElement element) {
		new Actions(driver).contextClick(element).perform();
		}
	public void doubleclick(WebElement element) {
		new Actions(driver).doubleClick(element).perform();
		}
	public void action(WebElement element,WebElement des) {
		new Actions(driver).dragAndDrop(element,des ).perform();
	}
	public void actionClick(WebElement element) {
		new Actions(driver).click(element).perform();
	}
	public void quit() {
		driver.quit();

	}
	public void close() {
		driver.close();

	}
	public String gettext(WebElement element ) {
	String text = element.getText();
return text;
	}
	public String getattribute(WebElement element,String value ) {
		String attribute = element.getAttribute(value);
		return attribute;
	}

	
	
	 ////////////////////////////
	 
	 public  static void waits(WebElement element) {	
	
	 WebDriverWait ww = new WebDriverWait(driver, 30);
	ww.until(ExpectedConditions.visibilityOf(element));
	 
	 }
    
	 
	 
////////////////Drop Down Base//////////////////
		
public static void select_string(WebElement element, String Value) {
Select s = new Select(element);
s.selectByValue(Value);
}


public static void select_index(WebElement element, int Value) {
Select s = new Select(element);
s.selectByIndex(Value);	
}


public static void select_text(WebElement element, String text) {
Select s = new Select(element);
s.selectByVisibleText(text);
}


public static void select_deselectAll(WebElement element) {
	Select s = new Select(element);
	s.deselectAll();
}


//////////   Excel    COde   ///////////////////////
public static String getExcelDataUrl(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
String data = row.getCell(colNum).getStringCellValue();
wb.close();
	return data;
}



public static String getExcelData(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("D:\\Automation\\Test Data\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
String data = row.getCell(colNum).getStringCellValue();
wb.close();
	return data;
}


public static int getExcelRandomRowNum(String sheetName) throws Throwable{
	FileInputStream fis = new FileInputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Random rand = new Random();
int rowNum = rand.nextInt(sh.getLastRowNum());
return rowNum;
}
public static void setExcelData(String sheetName, int rowNum, int colNum,String data) throws Throwable{
	FileInputStream fis = new FileInputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
Cell cel = row.createCell(colNum);
cel.setCellValue(data);
FileOutputStream fos = new FileOutputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
	wb.write(fos);
	wb.close();
}



public static void setExcelDataUrl(String sheetName, int rowNum, int colNum,String data) throws Throwable{
	FileInputStream fis = new FileInputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
Cell cel = row.createCell(colNum);
cel.setCellValue(data);
FileOutputStream fos = new FileOutputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
	wb.write(fos);
	wb.close();
}



public static int getRowCount(String sheetName) throws Throwable {
	FileInputStream fis = new FileInputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
int rowIndex = wb.getSheet(sheetName).getLastRowNum();
return rowIndex;
}

public static void setExcelDataInteg(String sheetName, int rowNum, int colNum,String data) throws Throwable{
	FileInputStream fis = new FileInputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
Cell cel = row.createCell(colNum);
cel.setCellValue(data);
FileOutputStream fos = new FileOutputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
	wb.write(fos);
	wb.close();

}


public static int getCellCount(String sheetName) throws Throwable {
	FileInputStream fis = new FileInputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(0);
int cell = row.getLastCellNum();
return cell;
}



public static void writeexcel(String Result,int RowNum ,int ColNum) throws Throwable
{
	FileInputStream fis = new FileInputStream("D:\\nm.webFlow\\input\\SMSTEST.xlsx");
   //Blank workbook
   XSSFWorkbook workbook = new XSSFWorkbook(fis);

   //Create a blank sheet
   XSSFSheet sheet = workbook.getSheet("Sheet1");
   XSSFSheet ExcelWSheet = sheet;
   XSSFCell Cell;
   XSSFRow Row;

   try
       {


           Row  = ExcelWSheet.createRow(RowNum);

           Cell = Row.getCell(ColNum);

           if (Cell == null) {

               Cell = Row.createCell(ColNum);

               Cell.setCellValue(Result);

               } else {

                   Cell.setCellValue(Result);

               }

           FileOutputStream out = new FileOutputStream(new File("D:\\nm.webFlow\\input\\SMSTEST.xlsx"));
           workbook.write(out);
           out.close();
           System.out.println("  ");
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

}


//////  Mail Code

public static void mail_report() {
	
	//report.flush();
  final String username = "balasanthoshkumar90@gmail.com";
  final String password = "9677159095"; 
  
  
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
      message.setFrom(new InternetAddress("balasanthoshkumar90@gmail.com"));
      message.setSubject("Take Action Alert Mail"+date);

     message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("balasanthoshr@gmail.com,amukural@gmail.com,amudhan.nagarajan@netmeds.com,balasanthoshkumar.r@netmeds.com"));
      //message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(,balasanthoshkumar.r@netmeds.com)
      Multipart multipart = new MimeMultipart();

      BodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setText("Hi Team,"+"\n\n"+"Please find the attached File for the Take Action Alert Message."+"\n"+"\n"+"\n"+"\n\n\n"+"Regards,"+"\n"+"Testing Team.");
     BodyPart attachmentBodyPart = new MimeBodyPart();
   //  messageBodyPart.setText("Hi Team,"+"\n\n"+"Please find the attached File for the Take Action Alert Message."+"\n"+"\n"+"\n"+"\n\n\n"+"Regards,"+"\n"+"Testing Team.");


     String file = System.getProperty("user.dir")+"//report//AlternateBrand.html";  // File To Attach
     
     String file1 = System.getProperty("user.dir")+"//report//autoIt_Upload_SearchMedicine.png";
     BodyPart attachmentBodyPart1 = new MimeBodyPart();
     DataSource source1 = new FileDataSource(file1);
     // messageBodyPart.setDataHandler(new DataHandler(source));
     attachmentBodyPart1.setDataHandler(new DataHandler(source1));
      DataSource source = new FileDataSource(file);
      // messageBodyPart.setDataHandler(new DataHandler(source));
      attachmentBodyPart.setDataHandler(new DataHandler(source));
      //attachmentBodyPart.setText(file);
      attachmentBodyPart.setFileName(file);
      attachmentBodyPart1.setFileName(file1);

      multipart.addBodyPart(messageBodyPart);
      multipart.addBodyPart(attachmentBodyPart);
      multipart.addBodyPart(attachmentBodyPart1);

      message.setContent(multipart);
      

      System.out.println("Sending....");

      Transport.send(message);

      System.out.println("Mail Sent Successfully");

  } catch (MessagingException e) {
      e.printStackTrace();
  }
	

}

public static void main(String[] args) {
	Base b= new Base();
	b.mail_report();
}
}


