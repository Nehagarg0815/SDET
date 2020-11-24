package crm_project;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Activity3 {
	WebDriver driver;
	
  @Test(dataProvider = "Authentication")
  public void copyColorIdentification (String user_name, String username_password) {
      driver.get("http://alchemy.hguy.co/crm");
      WebElement usernameField = driver.findElement(By.id("user_name"));
  	  WebElement passwordField = driver.findElement(By.id("username_password"));
	 usernameField.sendKeys(user_name);
	 passwordField.sendKeys(username_password);  
	 driver.findElement(By.id("bigbutton")).click();
	 String Color =  driver.findElement(By.cssSelector("#admin_options")).getCssValue("color");
	// .ColorRGB.WebElement copytext = driver.findElement(By.cssSelector("#admin_options"));
	 //String cssValue = driver.getCssValue(copytext);
	 System.out.println("First Copyright element color is : " + Color);
  }
  @DataProvider(name = "Authentication")
  public Object[][] credentials() {
	     return new Object[][] {{"admin", "pa$$w0rd"}};
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");
	   driver = new FirefoxDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
