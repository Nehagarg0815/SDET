package TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity4 {
	WebDriver driver;
	WebDriverWait wait;
	
	
  @Test
  @Parameters({"username","password"})
  public void loginTestCase(String username, String password) {
	  WebElement usernamefield = driver.findElement(By.id("username"));
	  WebElement passwordfield = driver.findElement(By.id("password"));
	  usernamefield.sendKeys(username);
	  passwordfield.sendKeys(password);
	  driver.findElement(By.cssSelector("button[type='submit']")).click();
	  String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	  Assert.assertEquals(loginMessage, "Welcome Back, admin");
	  	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  wait = new WebDriverWait(driver,10);
	  driver.get("https://www.training-support.net/selenium/login-form");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
