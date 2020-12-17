package stepDefinitions_JobBoard;

import java.io.File;



import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;



import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

public class AddNewCandidate {
	
	WebDriver driver;

    WebDriverWait wait;

    File file = new File("src/test/resources/Resume.docx");

    @Given("^User is on Welcome page.$")

    public void loginPage() {

        //Setup instances
    	System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");

        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 10);

        

        //Open browser

        driver.get("http://alchemy.hguy.co/orangehrm");

    } 

    @When("^User enter\"(.*)\"and\"(.*)\"$")	

    public void user_enter_and(String username, String password) throws Throwable {	

        //Enter username from Feature file	

        driver.findElement(By.id("txtUsername")).sendKeys(username);	

        //Enter password from Feature file	

        driver.findElement(By.id("txtPassword")).sendKeys(password);	

        //Click Login	

        driver.findElement(By.xpath("//input[@type='submit']")).click();

	

    }

    @And("^Navigate to recruitment page.$")

    public void RecruitmentPage() {

    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Welcome")));        

        //Read the page title and heading

        String pageTitle = driver.getTitle();        

        //Print the page title and heading

        System.out.println("Page title is: " + pageTitle);

        //Navigate to Recruitment page

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));

        driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']")).click();

        driver.findElement(By.xpath("//a[@id='menu_recruitment_viewRecruitmentModule']")).click();

    }

    @And("^Click on the add button to add candidate information$")

    public void AddButton() {

    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnAdd")));

    	driver.findElement(By.id("btnAdd")).click();

    }

    @And("^Fill out the necessary details$")

    public void CandidateInformation() {

    	driver.findElement(By.id("addCandidate_firstName")).sendKeys("Daniel");

    	driver.findElement(By.id("addCandidate_lastName")).sendKeys("Russo");

    	driver.findElement(By.id("addCandidate_email")).sendKeys("Example123@test.com");

    	//Select job title

    	WebElement JobVacancy=driver.findElement(By.id("addCandidate_vacancy"));

    	Select dropdown = new Select(JobVacancy);

    	dropdown.selectByVisibleText("Automation Test Engineer");



    }

    @And("^Upload a resume to the form and save$")

     public void UploadCV() {	

        //Find upload field    	

        WebElement uploadInput = driver.findElement(By.id("addCandidate_resume"));    	

        uploadInput.sendKeys(file.getAbsolutePath());

        //Click button to Save

        driver.findElement(By.id("btnSave")).click();

    	

    }

    @Then("^Verify that the candidate entry was created$")

    public void Verfication() {	

    	//go to main page

    	driver.findElement(By.id("btnBack")).click();

    	WebElement JobVacancy1=driver.findElement(By.id("candidateSearch_jobVacancy"));

    	Select dropdown1 = new Select(JobVacancy1);

    	dropdown1.selectByVisibleText("Automation Test Engineer");

    	WebElement HiringManager=driver.findElement(By.id("candidateSearch_hiringManager"));

    	Select dropdown2 = new Select(HiringManager);

    	dropdown2.selectByVisibleText("Tony Stark");

    	WebElement Status=driver.findElement(By.id("candidateSearch_status"));

    	Select dropdown3 = new Select(Status);

    	dropdown3.selectByVisibleText("Application Initiated");

    	WebElement Name=driver.findElement(By.id("candidateSearch_candidateName"));

    	Name.sendKeys("Daniel Russo");

    	driver.findElement(By.id("btnSrch")).click();    	    	

    	String JobTitle1 = driver.findElement(By.linkText("Daniel Russo")).getText();

    	Assert.assertEquals(JobTitle1, "Daniel Russo"); 

    }

    @And("^Close windows.$")

    public void closeBrowser() {

        //Close browser

        driver.close();

    }

}
