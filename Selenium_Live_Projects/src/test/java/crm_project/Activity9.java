package crm_project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity9 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	 
	  driver.get("https://alchemy.hguy.co/crm");
	  driver.findElement(By.xpath("//div/input[@id='user_name']")).sendKeys("admin");
	  driver.findElement(By.xpath("//div/input[@id='username_password']")).sendKeys("pa$$w0rd");
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
	 
	  WebElement LEADS = driver.findElement(By.xpath("//div[@id='content']"));
	wait.until(ExpectedConditions.visibilityOf(LEADS));
	 
	// for (int i=1; i<11; i++) {
	
	
	  List <WebElement> name = driver.findElements(By.xpath("//tr[position()<11]/td[@field='name']"));
	  for (WebElement naam : name) {
		 
	  System.out.println("name: " + naam.getText());
	
	 	 }
	  List <WebElement> user = driver.findElements(By.xpath("//tr[position()<11]/td[@field='assigned_user_name']"));
	  for (WebElement usr : user) {
		 
	  System.out.println("user name: " + usr.getText());
	
	 
	 }
	 
	  
	 
	 
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