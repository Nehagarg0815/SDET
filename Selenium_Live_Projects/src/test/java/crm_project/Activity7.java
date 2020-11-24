package crm_project;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;
  @Test(dataProvider = "Authentication")
  public void tableInfo(String user_name, String username_password) throws InterruptedException {
	  driver.get("http://alchemy.hguy.co/crm");
	  WebElement usernameField = driver.findElement(By.id("user_name"));
  	  WebElement passwordField = driver.findElement(By.id("username_password"));
	 usernameField.sendKeys(user_name);
	  passwordField.sendKeys(username_password);  
	 driver.findElement(By.id("bigbutton")).click();
	 WebElement sales = driver.findElement(By.xpath("//a[@id='grouptab_0']"));	
	  WebDriverWait wait = new WebDriverWait(driver, 50);
	  wait.until(ExpectedConditions.visibilityOf(sales));
	  WebElement Leads = driver.findElement(By.xpath("//li/a[@id='moduleTab_9_Leads']"));
	  Actions action = new Actions(driver);
	  action.moveToElement(sales).click().build().perform();
	 
	 
	  wait.until(ExpectedConditions.visibilityOf(Leads));
	 
	  action.moveToElement(Leads).click().build().perform();
	 
	  Thread.sleep(5000);
	  WebElement Additionalcell = driver.findElement(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr[1]/td[10]//following-sibling::span"));
	  wait.until(ExpectedConditions.elementToBeClickable(Additionalcell));
	  Additionalcell.click();
		 Thread.sleep(6000);
		//Get the Mobile No and print
		 WebElement MobileNo = driver.findElement(By.xpath("//*[@id='content']//span[@class='phone']"));
		
		
		if(MobileNo.isEnabled()){
			
			 System.out.println("Mobile No is : " + MobileNo.getText());
		}
		
		else{
		
			 System.out.println("Mobile No is not present for the lead");
	}
		 	
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
