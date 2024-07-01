package Testcases;

import java.util.List;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import java.io.FileOutputStream;
import Baseclass.Basetest;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import Baseclass.Basetest;
import io.appium.java_client.functions.ExpectedCondition;



public class Create_an_account extends Basetest {
	 
 // Method to save logs to a PDF file
	   	
	private void login() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("Login"))).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@jupitermeta.io");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(prop.getProperty("Loginotpbutton"))).sendKeys("2020");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(prop.getProperty("Loginotpsubmit"))).click();
	    Thread.sleep(1500);

    }
	
	
	private void Sign_up() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Useryouremail"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Signupemailtextfiled"))).sendKeys("rajeshkancha29@gmail.com");
	    driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
	    Thread.sleep(25000);
	    driver.findElement(By.xpath(prop.getProperty("signupsubmit"))).click();

		
	}

    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void click_actions() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.linkText(prop.getProperty("Pricing"))).click();
        Thread.sleep(500);
        driver.findElement(By.linkText(prop.getProperty("Resources"))).click();
        driver.findElement(By.linkText(prop.getProperty("SuperjApp"))).click();
    }

    @Test(priority = 2, retryAnalyzer = Retry.class)
    public void clickon_login() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
        Thread.sleep(500);
        WebElement disBoolean = driver.findElement(By.xpath(prop.getProperty("login01")));
        System.out.println("Log in: " + disBoolean);
    }

    @Test(priority = 3, retryAnalyzer = Retry.class)
    public void clickon_signup() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
        Thread.sleep(500);
        WebElement signup = driver.findElement(By.xpath(prop.getProperty("Signup01")));
        String actualElementText = signup.getText();
        String expectedElementText = "Sign Up";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
    }

    @Test(priority = 4, retryAnalyzer = Retry.class, enabled = true)
    public void Login_Dashboard() throws InterruptedException {
    	
        login();
               
        Thread.sleep(2500);
        WebElement e = driver.findElement(By.xpath(prop.getProperty("Dashboardmainscreen")));
        String actualElementText = e.getText();
        String expectedElementText = "Jupiter Meta’s Dashboard";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
        System.out.println(e);
    }

    @Test(priority = 5, retryAnalyzer = Retry.class)
    public void Resend_OTP() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@jupitermeta.io");
        driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
        Thread.sleep(35000);
        driver.findElement(By.xpath(prop.getProperty("Loginotpresend"))).click();
        Thread.sleep(5000);
    }

    @Test(priority = 6, retryAnalyzer = Retry.class)
    public void Invalid_Email() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("123");
        driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
        WebElement e = driver.findElement(By.xpath(prop.getProperty("emailinvalidmessage")));
        String actualElementText = e.getText();
        String expectedElementText = "This Email is invalid. Try again!";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
    }

    @Test(priority = 7, retryAnalyzer = Retry.class)
    public void email_error_message() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput")));
        driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
        WebElement e = driver.findElement(By.xpath(prop.getProperty("emailinvalidmessage")));
        String actualElementText = e.getText();
        String expectedElementText = "This Email is invalid. Try again!";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
    }

    @Test(priority = 8, retryAnalyzer = Retry.class)
    public void OTP_error() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@jupitermeta.io");
        driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
        Thread.sleep(4500);
      //driver.findElement(By.xpath(prop.getProperty("LoginOTP"))).sendKeys("2020");
        driver.findElement(By.xpath(prop.getProperty("Loginotpsubmit"))).click();
        WebElement e = driver.findElement(By.xpath(prop.getProperty("loginotperrormessage")));
        String actualElementText = e.getText();
        String expectedElementText = "Please enter a valid code";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
    }

    @Test(priority = 9, retryAnalyzer = Retry.class,enabled = false)
    public void login_signup() throws InterruptedException {
    	
        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
        WebElement signup = driver.findElement(By.xpath(prop.getProperty("Signup01")));
        String actualElementText = signup.getText();
        String expectedElementText = "Sign Up";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
    }

    @Test(priority = 10, retryAnalyzer = Retry.class,enabled = false)
    public void signup_Welcome() throws InterruptedException {
    	
        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
        driver.findElement(By.xpath(prop.getProperty("Useryouremail"))).click();
        driver.findElement(By.xpath(prop.getProperty("Signupemailtextfiled"))).sendKeys("rajeshkancha41@gmail.com");
        driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
        Thread.sleep(15000);
        driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
        driver.findElement(By.xpath(prop.getProperty("signupsubmit"))).click();
        WebElement wel = driver.findElement(By.xpath(prop.getProperty("welcome")));
        String actualelement = wel.getText();
        String expectedelement = "Welcome";
        Assert.assertEquals(actualelement, expectedelement, "both are should be same");
        Thread.sleep(2500);
    }

    @Test(priority = 11, retryAnalyzer = Retry.class)
    public void signup_login() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
        driver.findElement(By.xpath(prop.getProperty("signup-login"))).click();
    }

    @Test(priority = 12, retryAnalyzer = Retry.class, enabled = true)
    public void after_login_changeto_filter() throws InterruptedException {
        
    	login();
        driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
        driver.findElement(By.xpath(prop.getProperty("Scheduled"))).click();
        Thread.sleep(5000);
    }

    @Test(priority = 13, retryAnalyzer = Retry.class)
    public void Surveycard_back_navigation() throws InterruptedException {
        login();
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,350)", "");
        driver.findElement(By.xpath(prop.getProperty("surveycards"))).click();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2500);
        driver.navigate().back();
        Thread.sleep(5000);
    }

    @Test(priority = 14, retryAnalyzer = Retry.class)
    public void printing_survey_title() throws InterruptedException {
        login();
        Thread.sleep(1500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)", "");
        List<WebElement> title = driver.findElements(By.xpath(prop.getProperty("surveycards")));
        for (int i = 0; i < title.size(); i++) {
            System.out.println(title.get(i).getText());
        }
    }

    // New tests for survey cards
    @Test(priority = 15, retryAnalyzer = Retry.class)
    public void allsurveys_cardLIST() throws InterruptedException {
        login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,350)", "");
        Thread.sleep(1500);
        List<WebElement> element = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
        int elementcount = element.size();
        System.out.println("Total All number of cards : " + elementcount);
    }

    @Test(priority = 16, retryAnalyzer = Retry.class)
    public void Scheduled_surveys_cardNumber() throws InterruptedException {
        login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,350)", "");
        Thread.sleep(1500);
        driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
        driver.findElement(By.xpath(prop.getProperty("Scheduled"))).click();
        Thread.sleep(3500);
        List<WebElement> element = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
        int elementcount = element.size();
        System.out.println("Total Scheduled number of cards : " + elementcount);
    }

    @Test(priority = 17, retryAnalyzer = Retry.class)
    public void Completed_survey_list() throws InterruptedException {
        login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,350)", "");
        Thread.sleep(1500);
        driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
        driver.findElement(By.xpath(prop.getProperty("Completed"))).click();
        Thread.sleep(3500);
        List<WebElement> element = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
        int elementcount = element.size();
        System.out.println("Total Completed number of cards : " + elementcount);
    }

    @Test(priority = 18, retryAnalyzer = Retry.class)
    public void LIVE_surveycard_Numbers() throws InterruptedException {
        login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,350)", "");
        Thread.sleep(1500);
        driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
        driver.findElement(By.xpath(prop.getProperty("Live"))).click();
        Thread.sleep(3500);
        List<WebElement> element = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
        int elementcount = element.size();
        System.out.println("Total Live number of cards : " + elementcount);
    }

    @Test(priority = 19, retryAnalyzer = Retry.class)
    public void Overview() throws InterruptedException {
        login();
        String br = driver.findElement(By.xpath(prop.getProperty("Overview"))).getText();
        System.out.println(br);
    }

    @Test(priority = 20, retryAnalyzer = Retry.class)
    public void allsurveys_Heading() throws InterruptedException {
        login();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(250,350)", "");
        Thread.sleep(1500);
        List<WebElement> elements = driver.findElements(By.xpath(prop.getProperty("Allsurveyscardsname")));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
       
        List<WebElement> element = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
        int elementcount = element.size();
        System.out.println("Total Live number of cards : " + elementcount);
    }
    
    @Test(priority = 21,enabled = false)
    public void Surveycard_response() throws InterruptedException {
		
    	login();
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(250,350)", "");
         Thread.sleep(1500);
         driver.findElement(By.xpath(prop.getProperty("surveycards"))).click();
         Thread.sleep(2000);
         
         JavascriptExecutor jss = (JavascriptExecutor) driver;
         jss.executeScript("window.scrollBy(250,350)", "");
         Thread.sleep(1500);
         
         driver.findElement(By.xpath(prop.getProperty("ClickonDropdown"))).click();

         // Initialize WebDriverWait with a timeout of 30 seconds
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

         
         // Wait for the dropdown to be visible and retrieve the elements
         WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='dropdown-container question_dropdown__QwjON'])")));
         
         // Get all items in the dropdown
         List<WebElement> dropdownItems = dropdownElement.findElements(By.tagName("li"));
         
         // Print each item in the dropdown
         for (WebElement item : dropdownItems) {
             System.out.println(item.getText());
         }
           
    }

    @Test(priority = 22,retryAnalyzer = Retry.class) 
    public void print_the_sureyfirstquestion_response() throws InterruptedException {
		
    	login();
    	
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(250,350)", "");
         Thread.sleep(1500);
         driver.findElement(By.xpath(prop.getProperty("surveycards"))).click();
         Thread.sleep(2000);
         
         JavascriptExecutor jss = (JavascriptExecutor) driver;
         jss.executeScript("window.scrollBy(250,1050)", "");
         Thread.sleep(3500);
        
        
    
    List<WebElement> elements = driver.findElements(By.xpath(prop.getProperty("surveycardquestion")));
    for (WebElement element : elements) {
        System.out.println(element.getText());
    }
    
 }
    
    @Test(priority = 23, retryAnalyzer = Retry.class,enabled = false)
    public void Print_Location_errormessage() throws InterruptedException {
		    	
    	Sign_up();
    	
    	//Welcome screen.
    	driver.findElement(By.xpath(prop.getProperty("Enterinsightengine"))).click();
    	Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Consumer-Profiling"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Choosecampaign-nextbutton"))).click();
	    Thread.sleep(1500);
	    
	    //Audience screen.
	    driver.findElement(By.xpath(prop.getProperty("Audience-Nextbutton"))).click();
	    
	    WebElement errormessage = driver.findElement(By.xpath(prop.getProperty("Location-errormessage")));
	    String actualelement = errormessage.getText();
        String expectedelement = "Please select a location";
        Assert.assertEquals(actualelement, expectedelement, "both should be same");
}
		
	
    
    @Test(enabled = false)
    public void name() throws InterruptedException {
		
    	
    	login();
    	
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(250,350)", "");
         Thread.sleep(1500);
         driver.findElement(By.xpath(prop.getProperty("surveycards"))).click();
         Thread.sleep(2000);
         
         JavascriptExecutor jss = (JavascriptExecutor) driver;
         jss.executeScript("window.scrollBy(250,350)", "");
         Thread.sleep(3500);
        
    	
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

         // Click on the dropdown to make the items visible
         WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'dropdown-toggle')]")));
         dropdownButton.click();

         // Wait for the dropdown items to be visible
         WebElement dropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'dropdown-menu')]")));
         
         // Get all items in the dropdown
         List<WebElement> dropdownItems = dropdownList.findElements(By.tagName("li"));

         // Print each item in the dropdown
         for (WebElement item : dropdownItems) {
             System.out.println(item.getText());
         }     
 
	}
    
    @Test(enabled = false)
    public void cc() throws InterruptedException {
		
	Sign_up();
    	
    	//Welcome screen.
    	driver.findElement(By.xpath(prop.getProperty("Enterinsightengine"))).click();
    	Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Consumer-Profiling"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Choosecampaign-nextbutton"))).click();
	    Thread.sleep(1500);
	
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Click on the location dropdown to make the items visible
        WebElement locationDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("ClickonDropdown"))));
        locationDropdown.click();
        Thread.sleep(3500);

        // Wait for the dropdown items to be visible
        WebElement dropdownList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'dropdown-menu')]")));
        
        // Select "Delhi" from the dropdown
        WebElement delhiOption = dropdownList.findElement(By.xpath("//li[contains(text(), 'Delhi')]"));
        delhiOption.click();
        
        // Optionally print confirmation
        System.out.println("Delhi selected from the dropdown");

    }

 
}

    
    
    
    
    
    