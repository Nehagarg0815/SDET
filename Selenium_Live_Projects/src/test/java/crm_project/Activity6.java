package crm_project;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity6 {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test(dataProvider = "Authentication")
  public void activities(String user_name, String username_password) {
	  driver.get("http://alchemy.hguy.co/crm");
	  WebElement usernameField = driver.findElement(By.id("user_name"));
  	  WebElement passwordField = driver.findElement(By.id("username_password"));
	 usernameField.sendKeys(user_name);
	 passwordField.sendKeys(username_password);  
	 driver.findElement(By.id("bigbutton")).click();
	 WebElement acti = driver.findElement(By.cssSelector("#grouptab_3"));
	 boolean status = acti.isDisplayed();
	 System.out.println("Activities webelemt is present : " +status);	  
  }

  @DataProvider(name = "Authentication")
  public Object[][] credentials() {
	     return new Object[][] {{"admin", "pa$$w0rd"}};
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");
      driver = new FirefoxDriver();
      wait = new WebDriverWait(driver,10);
	  driver.get("http://alchemy.hguy.co/crm");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
