package stepDefinitions_JobBoard;

import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

public class AddMultipleEmployees {
	
	WebDriver driver;

    WebDriverWait wait;

    @Given("^User is on Welcome page$")

    public void loginPage() {

        //Setup instances
    	System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");

        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 10);

        

        //Open browser

        driver.get("http://alchemy.hguy.co/orangehrm");

    } 

    @When("^user enter\"(.*)\"and\"(.*)\"$")	

    public void user_enter_and(String username, String password) throws Throwable {	

        //Enter username from Feature file	

        driver.findElement(By.id("txtUsername")).sendKeys(username);	

        //Enter password from Feature file	

        driver.findElement(By.id("txtPassword")).sendKeys(password);	

        //Click Login	

        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

    @And("^Navigate to PIM option$")

    public void NavigatetoPIM(){

    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Welcome")));        

        //Read the page title and heading

        String pageTitle = driver.getTitle();        

        //Print the page title and heading

        System.out.println("Page title is: " + pageTitle);

        //Navigate to PIM

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));

        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();

        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();

    }

    @And("^Click on the add button to add new employee$")

    public void ClickonAdd(){

    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAdd")));

         driver.findElement(By.xpath("//input[@id='btnAdd']")).click();	

    }

    @And("^Fill out the necessary details\"(.*)\"and\"(.*)\"$")

    public void Fill_out_the_necessary_detailsand(String Firstname, String Lastname) throws Throwable{

    	// Entering Firstname

	    WebElement First_Name = driver.findElement(By.xpath("//input[@id = 'firstName']"));	    

	    First_Name.sendKeys(Firstname);

	    // Entering Lastname

        WebElement  Last_Name= driver.findElement(By.xpath("//input[@id='lastName']"));

        Last_Name.sendKeys(Lastname);

   

    }

    @Then("^Save and Verify that the employees have been created\"(.*)\"$")

    public void Save_and_Verify_that_the_employees_have_been_createdand(String employeeID) throws Throwable{

    	driver.findElement(By.xpath("//input[@id='btnSave']")).click();

    	driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click();	

    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn")));    	

    	WebElement ID= driver.findElement(By.xpath("//input[@id='empsearch_id']"));

        ID.sendKeys(employeeID);

        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

        String employee_id = driver.findElement(By.linkText(employeeID)).getText();

    	Assert.assertEquals(employee_id,employeeID);

    	driver.close();

    }    

    
	
	

}