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

public class Activity8 {
	WebDriver driver;
	WebDriverWait wait;

	@Test(dataProvider = "Authentication")

	public void loginTestCase(String user_name, String username_password) {

		WebElement usernameField = driver.findElement(By.id("user_name"));
		WebElement passwordField = driver.findElement(By.id("username_password"));
		usernameField.sendKeys(user_name);
		passwordField.sendKeys(username_password);
		driver.findElement(By.id("bigbutton")).click();

		WebElement salesbtn = driver.findElement(By.id("grouptab_0"));
		salesbtn.click();

		WebElement accounts = driver.findElement(By.xpath("//li/a[@id='moduleTab_9_Accounts']"));
		Actions action = new Actions(driver);
		action.moveToElement(salesbtn).click().build().perform();

		wait.until(ExpectedConditions.visibilityOf(accounts));

		action.moveToElement(accounts).click().build().perform();

		WebElement ACCOUNTS = driver.findElement(By.xpath("//div[@id='content']"));
		wait.until(ExpectedConditions.visibilityOf(ACCOUNTS));

		for (int i = 1; i < 10; i += 2) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[contains(@class, 'list view table-responsive')]/tbody/tr[" + i + "]/td[@field='name']")));

			WebElement name = driver.findElement(By.xpath("//table[contains(@class, 'list view table-responsive')]/tbody/tr[" + i + "]/td[@field='name']"));
			
			System.out.println("name: " + name.getText());
		}
	}

	@DataProvider(name = "Authentication")
	public Object[][] credentials() {
		return new Object[][] { { "admin", "pa$$w0rd" } };
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 50);
		driver.get("http://alchemy.hguy.co/crm");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
