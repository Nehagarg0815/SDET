package AppiumPackage;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity3_1 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "emulator-5554");
        caps.setCapability("platformName", "android");
        caps.setCapability("noReset", true);
        // Use your own device's messaging app
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void smsTest() {
        // Locate the button to write a new message and click it
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Messages\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("text(\"Messages\")")).click();
        System.out.println("Message icon clicked");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@content-desc='Start chat']")));
        driver.findElement(MobileBy.xpath("//android.widget.Button[@content-desc='Start chat']")).click();
        System.out.println("start chat button clicked");

        // Enter the number to send message to
        String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(contactBoxLocator)));
        System.out.println("text box for number appears");
        // Enter your own phone number
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("8800440000");
        System.out.println("number appears");
       
        	String messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator(messageBoxLocator)));
       driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();
        System.out.println("Message box appears");
        MobileElement messageBoxLocator1= driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
        messageBoxLocator1.sendKeys("Hello from Appium");
        // Type in a message

       // messageBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/sms_edit_text\")";
      //  MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
       // composeMessageInput.sendKeys("Hello from Appium");

        // Send the message
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();

        // Wait for message to show
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text_view")));

        // Assertion
        String messageLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/message_text_view\")";
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
