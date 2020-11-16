package ActivtiesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity9_2 {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        
        //Open browser
        driver.get("https://www.training-support.net/selenium/dynamic-attributes");
        
        //Find username and password fields
        WebElement userName = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        userName.sendKeys("NewUser");
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        password.sendKeys("Password");
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input"));
        confirmPassword.sendKeys("Password");
        
        WebElement email = driver.findElement(By.xpath("//label[contains(text(), 'Email')]/following-sibling::input"));
        email.sendKeys("real_email@xyz.com");
        //Click Sign Up
        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
        
        //Print login message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);
        
        //Close browser
        driver.close();

    }
}