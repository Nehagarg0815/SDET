package crm_project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Activity4 {
	WebDriver driver;
	WebDriverWait wait;
  @Test(dataProvider = "Authentication")
  public void loginTestCase(String user_name, String username_password) {
	  
      WebElement usernameField = driver.findElement(By.id("user_name"));
  	
      WebElement passwordField = driver.findElement(By.id("username_password"));
	 usernameField.sendKeys(user_name);
	 passwordField.sendKeys(username_password);  
	 driver.findElement(By.id("bigbutton")).click();
	 
	 //Assert Message
	  String ColorRGB =  driver.findElement(By.xpath("//*[@id='toolbar']/ul")).getCssValue("color");
		//String hexColorCode = Color.fromString(ColorRGB).asHex();
		
		System.out.println("Color1"+ColorRGB);
	//	System.out.println("Color2"+hexColorCode);
		Assert.assertEquals(ColorRGB, "rgb(83, 77, 100)");
  }
  @BeforeMethod (alwaysRun = true)
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");
      driver = new FirefoxDriver();
      wait = new WebDriverWait(driver,10);
	  driver.get("http://alchemy.hguy.co/crm");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }


  @DataProvider (name = "Authentication")
  public Object[][] credentials() {
    return new Object[][] {{"admin", "pa$$w0rd"}};
  }
}
