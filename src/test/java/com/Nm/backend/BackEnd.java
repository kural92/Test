package com.Nm.backend;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.Nm.Base.BackendBaseClass;

public class BackEnd extends BackendBaseClass {

 
	
	 public static void parallel_test(int i) throws Throwable {

		System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe"); 
		 WebDriver driver = new ChromeDriver();
		// driver.get("https://www.netmeds.com");

		driver.manage().window().maximize();
		//Thread.sleep(3000);
		long startTime = System.currentTimeMillis();
		driver.get("https://s1-labs.netmeds.com/v2pharma");

	String user = getExcelData("MV1", i, 0);
		String pass = getExcelData("MV1", i, 1);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(user);


		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		Select s = new Select(driver.findElement(By.xpath("//select[@id='usertype']")));
		s.selectByVisibleText("Pharmacy");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
			
		try {
			String ss = driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).getText();
			assertTrue(ss.equalsIgnoreCase(user));

			//////////////////////////
			//Thread.sleep(3000);
			String orderId = driver.findElement(By.xpath("(//div[@class='col_secound'])[1]")).getText();
			System.out.println(orderId);

			//Thread.sleep(3000);
			driver.navigate().refresh();

			//Thread.sleep(3000);
			String orderId1 = driver.findElement(By.xpath("(//div[@class='col_secound'])[1]")).getText();
			System.out.println(orderId1);
			assertTrue(orderId.equals(orderId1));
			Thread.sleep(3000);
			/*
			 * if (orderId.equals(orderId1)) {
			 * System.out.println("Refresh Scenario Successfull"); } else {
			 * System.err.println("Refresh Scenario UN-Successfull"); }
			 */
			// Valid
		//	Thread.sleep(3000);
			driver.findElement(By.id("valid1")).click();

			/*
			 * // Rx Thread.sleep(3000); driver.findElement(By.id("invalid1")).click();
			 * 
			 * // Transfer Thread.sleep(3000);
			 * driver.findElement(By.id("transfer_to_admin")).click();
			 */
			// Forward
			//Thread.sleep(3000);
			driver.findElement(By.id("validate1_forward")).click();

			try {
				//Thread.sleep(3000);
				driver.findElement(By.id("pharma_doctorname_customerorder")).sendKeys("Test");
				//Thread.sleep(3000);
				driver.findElement(By.id("pharma_patientname_customerorder")).sendKeys("Test");
				//Thread.sleep(3000);
				driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
				//Thread.sleep(3000);
			} catch (Exception e) {
				System.out.println("No Confirmation Screen");
			}

			//Thread.sleep(3000);
			String orderId2 = driver.findElement(By.xpath("(//div[@class='col_secound'])[1]")).getText();
			System.out.println(orderId2);
			assertFalse(orderId1.equals(orderId2));
			//Thread.sleep(3000);
			/*
			 * if (!(orderId1.contains(orderId2))) {
			 * System.out.println("Valid Scenario Successfull"); } else {
			 * System.err.println("Valid Scenario Un-Successfull"); }
			 * 
			 */

			/*
			 * driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
			 * Thread.sleep(3000);
			 * 
			 * Actions acc = new Actions(driver); acc.moveToElement(driver.findElement(By.
			 * xpath("//a[contains(text(),'Log Out')]"))).click().build().perform();
			 * //driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"))
			 * Thread.sleep(3000); driver.switchTo().alert().accept();
			 * System.out.println("Test 1 Ends");
			 */

		} catch (Exception e) {

			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Report/" + user + ".png"));
			System.out.println("Successfully captured a screenshot");
			// logger.log(Status.FAIL, result.getThrowable());
			//logger.log(Status.FAIL, "Snapshot below: " + logger.addScreenCaptureFromPath(user + ".png"));

		}

		///////////////////
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		//logger.log(Status.PASS, "total excution time:" + totalTime);

	
	}
	 

	/*@Test
	public void test() throws Throwable {*/

		public static void main(String[] args) throws Throwable {
			
		
/*		int rowCount = BackendBaseClass.getRowCount("MV1");
		System.out.println("total order'count =" + rowCount);*/
		for (int i = 1; i <= 20; i++) {
			final int counter = i;
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						
						parallel_test(counter);					
					} catch (Throwable e) {						
						e.printStackTrace();
					}
				}
			}).start();
		}
		
	}

	
}
