package AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity1_3 {
	  WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;

	    @BeforeClass
	    public void setup() throws MalformedURLException {

	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceId", "emulator-5554");
	        caps.setCapability("platformName", "android");
	        caps.setCapability("automationName", "UiAutomator2");
	        caps.setCapability("appPackage", "com.google.android.keep");
	        caps.setCapability("appActivity",".activities.BrowseActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 5);
	    }
	    
	 @Test   
	    public void reminderNote() {
	    	
	    	
	    	  driver.findElementByAccessibilityId("New text note").click();
	    	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.google.android.keep:id/new_note_button")));
	       
	        
	         // find the Title of task and note
	         
	        MobileElement newTitle = driver.findElementById("com.google.android.keep:id/editable_title");
	        newTitle.sendKeys("SDET AppiumNote");
	         
		    MobileElement newNote =  driver.findElementById("com.google.android.keep:id/edit_note_text");
		    newNote.sendKeys("Please find SDET Appium Details");
	         
		    //Add Reminder
		    

	    	  driver.findElementByAccessibilityId("Reminder").click();
	    	  
	    	  //check if reminder appeared
	    	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.keep:id/dialog_title")));
	    	  
	    	  
	    	  //driver.findElement(By.id("com.google.android.keep:id/reminder_time_afternoon")).click();
	    	  
	    	  //Click save
	    	  driver.findElement(By.id("com.google.android.keep:id/save")).click();
	    	  
	    	  //Go back
	    	  driver.findElementByAccessibilityId("Open navigation drawer").click();
	    	  
	    	  
		    
		    // Wait for Note to Display
	         wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/browse_note_interior_content")));
	         
	         

	         //Assertion
	        MobileElement noteDisplay = driver.findElementById("com.google.android.keep:id/browse_note_interior_content");
	        Assert.assertTrue(noteDisplay.isDisplayed());
	        System.out.println("Note added successfully");
	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.keep:id/browse_reminder_chip")));
	        //Assertion
	        MobileElement noteReminder=driver.findElementById("com.google.android.keep:id/browse_reminder_chip");
	        Assert.assertTrue(noteReminder.isDisplayed());
	        System.out.println("Reminder added successfully");
	     }
	 @AfterClass
	    public void tearDown() {
	        //driver.quit();
	    }
}
