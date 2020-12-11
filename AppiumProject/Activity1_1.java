package AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


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

public class Activity1_1 {
	  WebDriverWait wait;
	    AppiumDriver<MobileElement> driver = null;

	    @BeforeClass
	    
	    public void setup() throws MalformedURLException {

	        // Set the Desired Capabilities
	        DesiredCapabilities caps = new DesiredCapabilities();
	        caps.setCapability("deviceId", "emulator-5554");
	        caps.setCapability("platformName", "android");
	        caps.setCapability("automationName", "UiAutomator2");
	        caps.setCapability("appPackage", "com.google.android.apps.tasks");
	        caps.setCapability("appActivity",".ui.TaskListsActivity");
	        caps.setCapability("noReset", true);

	        // Instantiate Appium Driver
	        
	        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
	        driver = new AndroidDriver<MobileElement>(appServer, caps);
	        wait = new WebDriverWait(driver, 5);
	    }

	    @Test
	    public void addtask1() {
	    	
	    	
	    	driver.findElementByAccessibilityId("Create new task").click();
	    	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.google.android.apps.tasks:id/add_task_title")));
	       
	        
	         // Find the new task fields
	         
	        MobileElement newTask = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
	         	
	         
	         // Enter the text in the fields
	         newTask.sendKeys("Complete Activity with Google Tasks");
	     
	         // Save the contact
	         driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	         
	         // Wait for contact card to appear
	         wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("task_name")));

	         // Assertion
	         MobileElement taskOne = driver.findElementById("task_name");
	         Assert.assertTrue(taskOne.isDisplayed());
	         
	         String contactName = driver.findElementById("task_name").getText();
	         Assert.assertEquals(contactName, "Complete Activity with Google Tasks");
	     }
	    
	    @Test
	    public void addtask2() {
	    	// driver.findElementByAccessibilityId("Create new task").click();
	    	  driver.findElementByAccessibilityId("Create new task").click();
	    	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.google.android.apps.tasks:id/add_task_title")));
	       
	        
	         // Find the new task fields
	         
	        MobileElement newTask = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
	         	
	         
	         // Enter the text in the fields
	         newTask.sendKeys("Complete Activity with Google Keep");
	     
	         // Save the contact
	         driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	         
	         // Wait for contact card to appear
	         wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("task_name")));

	         // Assertion
	         MobileElement taskOne = driver.findElementById("task_name");
	         Assert.assertTrue(taskOne.isDisplayed());
	         
	         String contactName = driver.findElementById("task_name").getText();
	         Assert.assertEquals(contactName, "Complete Activity with Google Keep");
	     }
	    @Test
	    public void addtask3() {
	    	 //driver.findElementByAccessibilityId("Create new task").click();
	    	  driver.findElementByAccessibilityId("Create new task").click();
	    	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("com.google.android.apps.tasks:id/add_task_title")));
	        
	         // Find the new task fields
	         
	        MobileElement newTask = driver.findElementByXPath("//android.widget.EditText[@text='New task']");
	         	
	         
	         // Enter the text in the fields
	         newTask.sendKeys("Complete the second Activity Google Keep");
	     
	         // Save the contact
	         driver.findElementById("com.google.android.apps.tasks:id/add_task_done").click();
	         
	         // Wait for contact card to appear
	         wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("task_name")));

	         // Assertion
	         MobileElement taskOne = driver.findElementById("task_name");
	         Assert.assertTrue(taskOne.isDisplayed());
	         
	         String contactName = driver.findElementById("task_name").getText();
	         Assert.assertEquals(contactName, "Complete the second Activity Google Keep");
	     }

	    @Test
	    public void checkTasksAdded() {
	  	  List<MobileElement> tasks = driver.findElements(By.id("com.google.android.apps.tasks:id/task_name"));
	  	  int taskNum = 0;
	  	  for (MobileElement i:tasks) {
	  		 System.out.println(i.getText()); 
	  		 taskNum +=1;
	  	  }
	  	  Assert.assertEquals(taskNum,3);
	  	  
	  	  System.out.println("All 3 tasks added successfully");
	    }

	    @AfterClass
	    public void tearDown() {
	        //driver.quit();
	    }
	}



