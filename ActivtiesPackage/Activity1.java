package ActivtiesPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

    public static void main(String[] args) {
	// Create a new instance of the Firefox driver
    System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	

		
	//Open the browser
	driver.get("https://www.training-support.net");
		
	//Close the browser
	driver.close();
    }

}
