package crm_project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	
	WebDriver driver;
  @Test(dataProvider = "Authentication")
  public void titleVerification (String user_name, String username_password) {
	      driver.get("http://alchemy.hguy.co/crm");
	      WebElement usernameField = driver.findElement(By.id("user_name"));
	  	  WebElement passwordField = driver.findElement(By.id("username_password"));
		 usernameField.sendKeys(user_name);
		 passwordField.sendKeys(username_password);  
		 driver.findElement(By.id("bigbutton")).click();
	 
	  String title = driver.getTitle();
	  System.out.println(title);
	 
	Assert.assertEquals(title, "SuiteCRM");
		
	if (title.matches("SuiteCRM") ) {
		
		System.out.println("Title is matching hence test case pass.");
	}
  }
  @BeforeMethod
  public void beforeMethod() {
	   System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");
	   driver = new FirefoxDriver();
	 
  }
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  @DataProvider(name = "Authentication")
  public Object[][] credentials() {
     return new Object[][] {{"admin", "pa$$w0rd"}};
  }
 
}
