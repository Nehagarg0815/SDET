package stepDefinitions_JobBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class JobBoardSite {
    WebDriver driver;
    WebDriverWait wait;
    
    @Before ("@createuser or @jobapply or @jobpost or @examplepost")
    public void openBrowser(){
        //Setup instances
    	System.setProperty("webdriver.gecko.driver", "C:\\Automation Work\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
    	
    }
    
    @Given("^User logs on to Jobboard admin page$")
    public void adminPage() {       
        //Navigate to
        driver.get("https://alchemy.hguy.co/jobs/wp-admin/");
    }
    
    @Given("^User navigates to job board page$")
    public void jobboardPage() {       
        //Navigate to
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    
    @When("^User proceeds to add new user$")
    public void enterCredentials() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='login']")));
    	
        //Enter username
        driver.findElement(By.id("user_login")).sendKeys("root");
        //Enter password
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        //Click Login
        driver.findElement(By.id("wp-submit")).click();
        
        // Proceed to add new user
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
        driver.findElement(By.xpath("//div[text()='Users']")).click(); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='wp-heading-inline']")));
        driver.findElement(By.xpath("//div[@class='wrap']//a[text()='Add New']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-new-user")));
        
    }
    
    @When("^User searches for a specific job$")
    public void searchJob() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[text()='Jobs']")));
        
    	driver.findElement(By.xpath("//li//a[text()='Jobs']")).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='search_submit']")));
    	
    	driver.findElement(By.id("search_keywords")).sendKeys("Automation");
    	driver.findElement(By.xpath("//input[@value='freelance']")).click();
    	driver.findElement(By.xpath("//input[@value='internship']")).click();
    	driver.findElement(By.xpath("//input[@value='part-time']")).click();
    	driver.findElement(By.xpath("//input[@value='temporary']")).click();
    	
    	driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        
    }
    
    @When("^User clicks on post job button$")
    public void gotoPostJob() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[text()='Post a Job']")));
        
    	driver.findElement(By.xpath("//li//a[text()='Post a Job']")).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Post a Job']")));
 
    }
    
    @Then("^User enters the new user info$")
    public void adduserInfo() {
    	 // Insert new user details
        driver.findElement(By.id("user_login")).sendKeys("Neha_garg");
        driver.findElement(By.id("email")).sendKeys("sdetbatch4@gmail.com");
        driver.findElement(By.id("createusersub")).click();
    }
    
    @Then("^User gets the job details using xpath$")
    public void getJobDetails() {
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Search completed')]")));
        driver.findElement(By.xpath("(//h3[text()='Automation test Specialist'])[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='entry-title']")));
        String jobTitle = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
        System.out.println(jobTitle);
        Assert.assertEquals("Automation test Specialist", jobTitle);
    }
    
    @Then("^User fills in job details with email \"(.*)\" title \"(.*)\" location \"(.*)\" jd \"(.*)\" url \"(.*)\"$")
    public void addjobDetails(String email, String title, String location, String jd, String url) {
    	 // Insert new user details
    	driver.findElement(By.id("create_account_email")).sendKeys(email);
        driver.findElement(By.id("job_title")).sendKeys(title);
        driver.findElement(By.id("job_location")).sendKeys(location);
        driver.findElement(By.xpath("//iframe[@id='job_description_ifr']")).sendKeys(jd);
        driver.findElement(By.xpath("//input[@id='application']")).sendKeys(url);
        driver.findElement(By.xpath("//input[@id='company_name']")).sendKeys("IBM India Pvt Ltd");
        
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        driver.findElement(By.name("submit_job")).click();

    }
    
    @And("^Verify the new user has been created$")
    public void verifyUser() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='message']/p")));
        String cnfrmTxt = driver.findElement(By.xpath("//div[@id='message']/p")).getText().substring(0, 17);
        
        Assert.assertEquals("New user created.", cnfrmTxt);
    }
    
    @And("^Submit the new job posting$")
    public void submitJob() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Preview']")));
        driver.findElement(By.id("job_preview_submit_button")).click();
        
    }
    
    @And("^Verify the new job is visible in Job listing page$")
    public void verifyPosting() {       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Job listed successfully')]")));
        driver.findElement(By.xpath("//a[text()='click here']")).click();
        
        String titleXpath = "//h1[contains(text(), 'SDET Automation 9+ years')]";
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(titleXpath)));
        
        String postTitle = driver.findElement(By.xpath(titleXpath)).getText();
        Assert.assertEquals("SDET Automation 9+ years", postTitle);
        
    }
    
    
    @And("^Close the browser for jobboard activity$")
    public void closeBrowser() {
        //Close browser
        driver.quit();
    }
}
