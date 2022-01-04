package com.Nm.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.Nm.Pom.AndriodPom;
import com.Nm.Pom.MsitePOM;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MsiteBaseClass {

	
	public static ExtentHtmlReporter htmlReporter;
	 public static ExtentReports report;
		public static  ExtentTest logger;


		public static  String production_homeurl="https://m.netmeds.com/";

	//	public static  String production_homeurl="https://s1-meds.netmeds.com/";//https://s1-meds.netmeds.com/%20-%20msite



	public static AndroidDriver driver = null;
	
	public void loadurl(String url) {
	driver.get(url);
	}
	
	public void type(WebElement element ,String name) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
		element.sendKeys(name);
	}
	public void clrtxt(WebElement element) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
		element.clear();
			
	}
	
	public void btnclick(WebElement element) throws Throwable {
		/*
		  WebDriverWait wait = new WebDriverWait(driver, 30);
		  wait.until(ExpectedConditions.elementToBeClickable(element));
		  Thread.sleep(1000);
		 */
	    element.click();	
	}
	
	public void selectbyvalue(WebElement element,String name) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
		new Select (element).selectByValue(name);
	}
	
	public void selectbyindex(WebElement element,int index) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
		new Select (element).selectByIndex(index);
	}
	
	public void selectbytext(WebElement element,String text) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
		new Select (element).selectByValue(text);
	}
	
	public void mouse(WebElement element) throws Throwable {
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
	public String gettext(WebElement element ) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
	String text = element.getText();
return text;
	}
	public String getattribute(WebElement element,String value ) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		Thread.sleep(1000);
		String attribute = element.getAttribute(value);
		return attribute;
	}
	//Let's chat handle//
	public static void letschat() throws Throwable {
		
				Thread.sleep(5000);
				try {
					MobileElement netty = (MobileElement) driver.findElement(By.xpath("//*[@id='cross-button-polygon' and ./parent::*[./parent::*[./parent::*[@nodeName='DIV']]]]|//android.view.View[@resource-id='haptik-xdk']/android.view.View/android.view.View/android.view.View/android.view.View"));
					netty.click();
					}catch (Exception e) {
						System.out.println("No Netty popup available to close");
						
					}

	}
	
	
//Popupclose
	
	public static void popupclose() throws Throwable {
		
		try {
			driver.findElement(By.xpath("//span[@class='app_close']|//span[@class='app_close']")).click();
		} catch (Exception e) {
			System.out.println("No Popup to close");
		}
}

	
	//Navigating to category
	
	public static void Navigating_to_category() throws Throwable {
		
		
		MsitePOM m = new MsitePOM();
		
		Thread.sleep(4000);
		
	//List <WebElement> Category_list = m.getCategory_list();
		
	//System.out.println("The element size is"+  Category_list.size());
	
	Thread.sleep(4000);

	
	//driver.navigate().to("https://m.netmeds.com/non-prescriptions");
		
		for (int j=0;j<=0;j++) {
			
			Thread.sleep(2000);
			driver.swipe(0, 1900, 0, 2200, 1000);
			Thread.sleep(2000);
			
			
			
			if (j==1) {
				
				System.out.println("Beauty page is working fine");{
				
				continue;
			}
			
			} 
			
			else {
				
				
				m.getCategory_list().get(j+1).click();
				
				try {
					
					m.getCategory_list().get(j+1).click();
				}catch (Exception e) {
					System.out.println("already clicked");
				}
				
				if (j==6) {
					
					System.out.println("Beauty page is working fine");{
					
					break;
				}
				
				}
				
			}
			System.out.println("Successfull navigated to  category page");
			
			
			Thread.sleep(5000);
			Navigating_to_subcategory();
			
			Navigating_to_Sortby();
			Navigating_to_Filter();
			
		driver.navigate().to("https://m.netmeds.com/non-prescriptions");
		
	}
		
	}
	
	
	//Sub Category
	
	public static void Navigating_to_subcategory() throws Throwable {
	
		MsitePOM m = new MsitePOM();
			List<WebElement> SubCategory_list = m.getSubCategory_list();
			System.out.println("The element size is"+  SubCategory_list.size());
			
					for (int i1=0;i1<=0;i1++) {
						
						Thread.sleep(5000);
						if (i1>2) {
							 try {
							 driver.swipe(950, 1050, 430, 1050, 1000);
							 } catch (Exception e) {
								driver.swipe(500, 0, 0, 0, 1000);
							}
							// new TouchAction(driver).press(950, 1050) .waitAction(2000) .moveTo(430, 1050) .release().perform();
						 }
						Thread.sleep(5000);
						SubCategory_list.get(i1).click();
						System.out.println("Successfull navigated to sub category page");
						 
						Thread.sleep(5000);
						try {
						driver.findElement(By.xpath("(//*[@class='toCart addtocartbtn addtocartdirctbtn prodbtn'])[1]")).click();
						System.out.println("Successfully item added to cart");
						}catch (Exception e) {
						//System.out.println("Item is  "+ driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.NetmedsMarketplace.Netmeds:id/stock_info']")).getText());
						}
						Thread.sleep(5000);
						driver.navigate().back();
						Thread.sleep(5000);
					
				}
	
	
	}
	
	
	
	
	//Sort By		
	
	
	public static void Navigating_to_Sortby() throws Throwable {
		
		
		MsitePOM m = new MsitePOM();
	
	int n = 1;
	Thread.sleep(5000);

	
	for (int i2 = 0;i2<2; i2++)
	
	{
		try {
		driver.swipe(82, 1897, 82, 1465, 1000);
		}catch (Exception e) {
			driver.swipe(0, 1500, 0, 0, 1000);
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='list_sort_btn']")).click();
		Thread.sleep(5000);
		List<WebElement> Sortby = driver.findElements(By.xpath("//*[@class='sort-button']"));
		Thread.sleep(3000);
		System.out.println("Total element size is  "+ Sortby.size());
		n = Sortby.size();
	
	
	
	Thread.sleep(3000);
	//if (i2>2) {
	//	driver.swipe(950, 1050, 430, 1050, 1000);
	//}
	Sortby.get(i2).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@text='APPLY']")).click();
	 Thread.sleep(5000);
	 
	 try {
			System.out.println("Category name is" + driver.findElement(By.xpath("(//*[@class='gen_drug ellipsis'])[1]")).getText());
			}catch (Exception e) {
				System.out.println("No category name");
			}	
			Thread.sleep(5000);
				
			try {
				System.out.println("Sub Category name is" + driver.findElement(By.xpath("(//*[@class='gen_drug ellipsis'])[2]")).getText());
				}catch (Exception e) {
					System.out.println("No sub category name");
				}
			 
			 
			Thread.sleep(5000);
				
			System.out.println("Best Price is " + driver.findElement(By.xpath("(//*[@class='final-price'])[1]")).getText());
			 
			
			Thread.sleep(5000);
			
			System.out.println("Manufacturer name is" + driver.findElement(By.xpath("(//*[@class='drug-manu ellipsis'])[1]")).getText());
			 
			try {
			Thread.sleep(5000);
			
			System.out.println("dsicount percentage is " + driver.findElement(By.xpath("(//*[@class='save-price'])[1]")).getText());
			
			}catch (Exception e) {
				System.out.println("No Discount");
			}
			
	
	
	}		
	}
	
	
	//Filter By	
	
	public static void Navigating_to_Filter() throws Throwable {
	
		
		MsitePOM m = new MsitePOM();
			int p = 1;
			Thread.sleep(5000);
		

	for (int i3 = 0;i3<2; i3++)
			
			{
		try {
		driver.swipe(82, 1897, 82, 1465, 1000);
		}catch (Exception e) {
			driver.swipe(0, 1500, 0, 0, 1000);
		}
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='filter-btn']")).click();
				Thread.sleep(5000);
				List<WebElement> Filterby =m.getFilterby();
				Thread.sleep(5000);
				System.out.println("Total element size is  "+ Filterby.size());
				p = Filterby.size();
			
			
			
			Thread.sleep(3000);
			//if (i2>2) {
			//	driver.swipe(950, 1050, 430, 1050, 1000);
			//}
			Filterby.get(i3+1).click();
			
			
			if (i3>=2) {
	
	driver.findElement(By.xpath("(//*[@nodeName='INPUT'])[1]")).click();
			}

			else {
		
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("(//*[@class='ais-RefinementList-item'])[1]")).click();
			 
			}	
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//*[@css='BUTTON.apl-btn']")).click();
			 Thread.sleep(5000);
			 System.out.println ("drug name is "+ driver.findElement(By.xpath("(//*[@class='category_name'])[1]")).getText());
			 Thread.sleep(5000);
			 
			 Thread.sleep(5000);
				try {
				System.out.println("Category name is" + driver.findElement(By.xpath("(//*[@class='gen_drug ellipsis'])[1]")).getText());
				}catch (Exception e) {
					System.out.println("No category name");
				}	
				Thread.sleep(5000);
					
				try {
					System.out.println("Sub Category name is" + driver.findElement(By.xpath("(//*[@class='gen_drug ellipsis'])[2]")).getText());
					}catch (Exception e) {
						System.out.println("No sub category name");
					}
				 
				 
				Thread.sleep(5000);
					
				System.out.println("Best Price is " + driver.findElement(By.xpath("(//*[@class='final-price'])[1]")).getText());
				 
				
				Thread.sleep(5000);
				
				System.out.println("Manufacturer name is" + driver.findElement(By.xpath("(//*[@class='drug-manu ellipsis'])[1]")).getText());
				 
				try {
				Thread.sleep(5000);
				
				System.out.println("dsicount percentage is " + driver.findElement(By.xpath("(//*[@class='save-price'])[1]")).getText());
				
				}catch (Exception e) {
					System.out.println("No Discount");
				}
				
			 
			 
				driver.findElement(By.xpath("//*[@id='filter-btn']")).click();
			 //driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/checked")).click();
			 Thread.sleep(5000);
			 driver.findElement(By.xpath("//*[@class='ais-ClearRefinements-button clr-btn action clear filter-clear']")).click();
			// driver.findElement(By.id("com.NetmedsMarketplace.Netmeds:id/btn_dismiss")).click();
			 Thread.sleep(5000);
			}	
			
			
			
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



/////////////////////////////   
/////////////////////////////////////

public static void sendkeys(WebElement ele, String name) {
ele.sendKeys(name);
}

public static void clk(WebElement ele) {
ele.click();

}

public static void moveElement(WebElement url) {
Actions    a = new Actions (driver);
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
Actions    a = new Actions (driver);
a.doubleClick(eleme).perform();
}
public static void clickRight(WebElement elemen) {
Actions    a = new Actions (driver);
a.contextClick(elemen).perform();
}

public static void thread(long Value) throws InterruptedException {
Thread.sleep(Value);

}
public static void back() {
driver.navigate().back();

}
public static void handleWindows(String Url, String parent) throws Throwable 
{
Set<String> child = driver.getWindowHandles();
for (String handle : child) {
if (!(parent.contains(handle))) {

Thread.sleep(2000);
driver.switchTo().window(handle);
}

}


driver.switchTo().window(Url);
}

////////////////////////////////////////////////////
















//////////   Excel    COde   ///////////////////////
public static String getExcelDataUrl(String sheetName, int rowNum, int colNum) throws Throwable{
	FileInputStream fis = new FileInputStream("//Excel//LoginTestData.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
String data = row.getCell(colNum).getStringCellValue();
wb.close();
	return data;
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


public static int getExcelRandomRowNum(String sheetName) throws Throwable{
	FileInputStream fis = new FileInputStream(".//Test Data//SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Random rand = new Random();
int rowNum = rand.nextInt(sh.getLastRowNum());
return rowNum;
}
public static void setExcelData(String sheetName, int rowNum, int colNum,String data) throws Throwable{
	FileInputStream fis = new FileInputStream(".//Test Data//SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
Cell cel = row.createCell(colNum);
cel.setCellValue(data);
FileOutputStream fos = new FileOutputStream(".//Test Data//SMSTEST.xlsx");
	wb.write(fos);
	wb.close();
}



public static void setExcelDataUrl(String sheetName, int rowNum, int colNum,String data) throws Throwable{
	FileInputStream fis = new FileInputStream(".//Test Data//SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
Cell cel = row.createCell(colNum);
cel.setCellValue(data);
FileOutputStream fos = new FileOutputStream(".//Test Data//SMSTEST.xlsx");
	wb.write(fos);
	wb.close();
}



public static int getRowCount(String sheetName) throws Throwable {
	FileInputStream fis = new FileInputStream(".//Test Data//SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
int rowIndex = wb.getSheet(sheetName).getLastRowNum();
return rowIndex;
}

public static void setExcelDataInteg(String sheetName, int rowNum, int colNum,String data) throws Throwable{
	FileInputStream fis = new FileInputStream(".//Test Data//SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(rowNum);
Cell cel = row.createCell(colNum);
cel.setCellValue(data);
FileOutputStream fos = new FileOutputStream(".//Test Data//SMSTEST.xlsx");
	wb.write(fos);
	wb.close();

}


public static int getCellCount(String sheetName) throws Throwable {
	FileInputStream fis = new FileInputStream(".//Test Data//SMSTEST.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sh = wb.getSheet(sheetName);
Row row = sh.getRow(0);
int cell = row.getLastCellNum();
return cell;
}



public static void writeexcel(String Result,int RowNum ,int ColNum) throws Throwable
{
	FileInputStream fis = new FileInputStream("  ");
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

           FileOutputStream out = new FileOutputStream(new File("  "));
           workbook.write(out);
           out.close();
           System.out.println("  ");
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }

}

public static void scrolldown(String Size) throws InterruptedException  {
	Thread.sleep(1500);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("arguments[0].scrollIntoView();", Element);
	js.executeScript("window.scrollBy(0,"+Size+")");
}
//////  Mail Code

public static void mail_report() {
	
	 report.flush();
  final String username = "cbsautomationreport@gmail.com";
  final String password = "cbstest123"; 
  
  
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
      message.setFrom(new InternetAddress("cbsautomationreport@gmail.com"));
      message.setSubject("Take Action Alert Mail"+date);

     message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("amudhan.nagarajan@netmeds.com,kuralamudhan92@gmail.com"));
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
