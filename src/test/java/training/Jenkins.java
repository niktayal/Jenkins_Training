package training;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import functions.BaseClass;

public class Jenkins {
	

	
		public static WebDriver driver;

		// Description : To launch the application under test

		@Parameters({ "browser", "env" })
		@BeforeMethod
		public void beforelogin(String browser) throws InterruptedException, FileNotFoundException, IOException

		{
			driver = BaseClass.SetupBrowser(browser); 
			BaseClass.wait(driver);
			BaseClass.BrowserMaximize(driver);
			BaseClass.navigateUrl(driver);

		}

		// Description : To test login functionality with valid test data
		@Test
		public void Test1_Login_Site() throws InterruptedException, IOException

		{
			
				
				Thread.sleep(500); 
				
				WebDriverWait wait = new WebDriverWait(driver, 15);

				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(BaseClass.GetPropertyFileData(driver, "signin"))));
				 
				driver.get("https://www.saucedemo.com/");
				
				driver.wait();
				
				driver.findElement(By.id("user-name")).sendKeys("standard_user");
				
				driver.wait();
				
				driver.findElement(By.id("password")).sendKeys("secret_sauce");
				
				driver.wait();
				
				driver.findElement(By.id("login-button")).click();
				
				driver.wait();
				
				String title = driver.getTitle();
				
				System.out.println("The title is" + title);
				

		}
		
		// Description : To logout the application in case of error handling
			@AfterMethod
			public void logOut() {
				
				 
				  driver.quit();
			}


}
