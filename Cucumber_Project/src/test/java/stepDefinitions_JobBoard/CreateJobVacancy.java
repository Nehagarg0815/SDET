package stepDefinitions_JobBoard;

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

public class CreateJobVacancy {
	
	WebDriver driver;

    WebDriverWait wait;

    @Given("^User is on Login page.$")

    public void loginPage() {

        //Setup instances
    	System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");

        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 10);

        

        //Open browser

        driver.get("http://alchemy.hguy.co/orangehrm");

    } 

    @When("^User enters\"(.*)\"and\"(.*)\"$")	

    public void user_enters_and(String username, String password) throws Throwable {	

        //Enter username from Feature file	

        driver.findElement(By.id("txtUsername")).sendKeys(username);	

        //Enter password from Feature file	

        driver.findElement(By.id("txtPassword")).sendKeys(password);	

        //Click Login	

        driver.findElement(By.xpath("//input[@type='submit']")).click();

	

    }

    @And("^Navigate to recruitment page$")

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

    @And("^Click on the Vacancies menu item to navigate to the vacancies page$")

    public void VacanciesPage() {

    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Vacancies")));

    	driver.findElement(By.linkText("Vacancies")).click();

    	

    	

    }

    @And("^Click on the Add button to navigate to the Add Job Vacancy form$")

    public void AddButton() {

    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("btnAdd")));

    	driver.findElement(By.id("btnAdd")).click();

    }

    @And("^Fill out the necessary details and Click the Save button to save the vacancy$")

    public void AddVacancies() {

    	//Select job title

    	WebElement JobTile=driver.findElement(By.id("addJobVacancy_jobTitle"));

    	Select dropdown = new Select(JobTile);

    	dropdown.selectByVisibleText("DevOps Engineer");

    	driver.findElement(By.id("addJobVacancy_name")).sendKeys("Vacancy_Project_CRM_2");

    	driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("Test Employee");

    	driver.findElement(By.id("btnSave")).click(); 	

    	   	

    }

    @And("^Fill the necessary details\"(.*)\"and\"(.*)\"and\"(.*)\"$")

    public void Fill_the_necessary_detailsand(String Jobtitle, String JobVacancy, String HiringManager) throws Throwable{

    	//Select job title

    	WebElement JobTile=driver.findElement(By.id("addJobVacancy_jobTitle"));

    	Select dropdown = new Select(JobTile);

    	dropdown.selectByVisibleText(Jobtitle);

    	driver.findElement(By.id("addJobVacancy_name")).sendKeys(JobVacancy);

    	driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(HiringManager);

    	driver.findElement(By.id("btnSave")).click(); 	

    	   	

    }

	@Then("^Verify that the vacancy was created$")

    public void VerifyVacancies() {

    	//Select job title

    	driver.findElement(By.id("btnBack")).click();

    	WebElement JobTile1=driver.findElement(By.id("vacancySearch_jobTitle"));

    	Select dropdown1 = new Select(JobTile1);

    	dropdown1.selectByVisibleText("DevOps Engineer");

    	WebElement JobVacancy=driver.findElement(By.id("vacancySearch_jobVacancy"));

    	Select dropdown2 = new Select(JobVacancy);

    	dropdown2.selectByVisibleText("Vacancy_Project_CRM_2");

    	WebElement Manager=driver.findElement(By.id("vacancySearch_hiringManager"));

    	Select dropdown3 = new Select(Manager);

    	dropdown3.selectByVisibleText("Test Employee");

    	driver.findElement(By.id("btnSrch")).click();    	    	

    	String JobTitle1 = driver.findElement(By.linkText("Vacancy_Project_CRM_2")).getText();

    	Assert.assertEquals(JobTitle1, "Vacancy_Project_CRM_2");  	    

	}

	 @Then("^Verify that the vacancy was created\"(.*)\"$")

	    public void Verify_that_the_vacancy_was_createdand(String vacancyname) throws Throwable{

		 driver.findElement(By.id("btnBack")).click();

		 Thread.sleep(1000);

		 WebElement JobVacancy1=driver.findElement(By.id("vacancySearch_jobVacancy"));

	    	Select dropdown3 = new Select(JobVacancy1);

	    	dropdown3.selectByVisibleText(vacancyname);

	    	driver.findElement(By.id("btnSrch")).click();

	    	String vacancyname1 = driver.findElement(By.linkText(vacancyname)).getText();

	    	Assert.assertEquals(vacancyname1, vacancyname);

	    	

	    } 

	 @And("^Close browser.$")

	    public void closeBrowser() {

	        //Close browser

	        driver.close();

	    }

}