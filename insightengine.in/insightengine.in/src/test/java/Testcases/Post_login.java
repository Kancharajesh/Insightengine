package Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.Basetest;

public class Post_login extends Basetest {

	private void login() throws InterruptedException { 
		driver.findElement(By.xpath(prop.getProperty("Login"))).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@jupitermeta.io");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
	    Thread.sleep(6000);
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
			
	@Test(priority = 1, retryAnalyzer = Retry.class, enabled = true)
	public void Login_Dashboard() throws InterruptedException {
	    login();
	    Thread.sleep(2500);
	    WebElement e = driver.findElement(By.xpath(prop.getProperty("Dashboardmainscreen")));
	    String actualElementText = e.getText();
	    String expectedElementText = "Jupiter Meta’s Dashboard";
	    
	    // Assertion to check if the dashboard main screen element text matches the expected text
	    Assert.assertEquals(actualElementText, expectedElementText, "Dashboard screen text mismatch");
	    
	    // Example of printing additional information
	    System.out.println("Dashboard Element: " + actualElementText);
	}

	
	@Test(priority = 2, retryAnalyzer = Retry.class)
	public void signup_login() throws InterruptedException {
	    driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
	    driver.findElement(By.xpath(prop.getProperty("signup-login"))).click();

	    // Enter email and send verification code
	    driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@jupitermeta.io");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
	    Thread.sleep(8000);
	    
	    // Enter OTP and submit
	    driver.findElement(By.xpath(prop.getProperty("Loginotpbutton"))).sendKeys("2020");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(prop.getProperty("Loginotpsubmit"))).click();
	    Thread.sleep(1500);
	    
	    // Example of assertion to verify successful login and presence of dashboard
	    WebElement dashboardTitle = driver.findElement(By.xpath(prop.getProperty("Dashboardmainscreen")));
	    Assert.assertTrue(dashboardTitle.isDisplayed(), "Dashboard main screen not displayed after login");

	    System.out.println("User logged in and dashboard displayed successfully");
	}

	 @Test(priority = 3, retryAnalyzer = Retry.class, enabled = true)
	 public void after_login_changeto_filter() throws InterruptedException {
	     login();
	     
	     // Click on the filter icon or element
	     WebElement filterIcon = driver.findElement(By.xpath(prop.getProperty("clickonfilter")));
	     filterIcon.click();
	     
	     // Apply the Scheduled filter
	     WebElement scheduledFilter = driver.findElement(By.xpath(prop.getProperty("Scheduled")));
	     scheduledFilter.click();
	     Thread.sleep(5000);
	     
	     // Example of assertion to verify filter application and expected UI change
	     List<WebElement> filteredElements = driver.findElements(By.xpath(prop.getProperty("clickonfilter")));
	     Assert.assertFalse(filteredElements.isEmpty(), "No elements found after applying Scheduled filter");

	     System.out.println("Applied Scheduled filter successfully");
	 }


	 
	 @Test(priority = 4, retryAnalyzer = Retry.class)
	 public void Surveycard_back_navigation() throws InterruptedException {
	     login();
	     Thread.sleep(1500);
	     
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(250,350)", "");
	     
	     // Click on a survey card to open it
	     WebElement surveyCard = driver.findElement(By.xpath(prop.getProperty("surveycards")));
	     surveyCard.click();
	     Thread.sleep(2000);
	     
	     // Scroll to the bottom of the page
	     js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	     Thread.sleep(2000);
	     
	     // Navigate back to the previous page
	     driver.navigate().back();
	     Thread.sleep(2000);
	     
	     // Example of assertion to verify navigation back to the main page or dashboard
	     WebElement dashboardTitle = driver.findElement(By.xpath(prop.getProperty("Dashboardmainscreen")));
	     Assert.assertTrue(dashboardTitle.isDisplayed(), "Expected dashboard screen after navigating back");

	     System.out.println("Navigated back to the dashboard successfully");
	 }


	   @Test(priority = 5, retryAnalyzer = Retry.class)
	   public void printing_survey_title() throws InterruptedException {
	       login();
	       Thread.sleep(1500);
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,2000)", "");
	       List<WebElement> title = driver.findElements(By.xpath(prop.getProperty("surveycards")));
	       
	       // Example of condition to ensure survey titles are printed
	       Assert.assertFalse(title.isEmpty(), "No survey titles found");
	       
	       for (int i = 0; i < title.size(); i++) {
	           System.out.println("Survey Title " + (i + 1) + ": " + title.get(i).getText());
	       }
	   }

	   
	   @Test(priority = 6, retryAnalyzer = Retry.class)
	    public void allsurveys_cardLIST() throws InterruptedException {
	        login(); // Assuming this method logs in and navigates to the desired page
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(250,350)", "");
	        Thread.sleep(1500);

	        List<WebElement> elements = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));

	        // Exclude the first card from counting
	        int elementCount = elements.size() - 1;

	        // Example of condition to check the count of all survey cards
	        Assert.assertTrue(elementCount > 0, "No survey cards found");

	        System.out.println("Total All number of cards (excluding first card): " + elementCount);
	    }


	
	   @Test(priority = 7, retryAnalyzer = Retry.class)
	    public void Scheduled_surveys_cardNumber() throws InterruptedException {
	        login(); // Assuming this method logs in and navigates to the desired page
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(250,350)", "");
	        Thread.sleep(1500);
	        driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
	        driver.findElement(By.xpath(prop.getProperty("Scheduled"))).click();
	        Thread.sleep(3500);

	        List<WebElement> elements = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));

	        // Exclude the first card from counting
	        int elementCount = elements.size() - 1;

	        // Example of condition to check the count of scheduled survey cards
	        Assert.assertTrue(elementCount > 0, "No scheduled survey cards found");

	        System.out.println("Total Scheduled number of cards (excluding first card): " + elementCount);
	    }

	   
	   
	   @Test(priority = 8, retryAnalyzer = Retry.class)
	   public void Completed_survey_list() throws InterruptedException {
	       login();
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(250,350)", "");
	       Thread.sleep(1500);
	       driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
	       driver.findElement(By.xpath(prop.getProperty("Completed"))).click();
	       Thread.sleep(3500);
	       List<WebElement> element = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
	       int elementcount = element.size() - 1;
	       
	       // Example of condition to check the count of completed survey cards
	       Assert.assertTrue(elementcount > 0, "No completed survey cards found");
	       
	       System.out.println("Total Completed number of cards (excluding first card): " + elementcount);
	   }

	
	   @Test(priority = 9, retryAnalyzer = Retry.class)
	   public void LIVE_surveycard_Numbers() throws InterruptedException {
	       login();
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(250,350)", "");
	       Thread.sleep(1500);
	       driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
	       driver.findElement(By.xpath(prop.getProperty("Live"))).click();
	       Thread.sleep(3500);
	       List<WebElement> element = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
	       int elementcount = element.size() - 1;
	       
	       // Example of condition to check the count of live survey cards
	       Assert.assertTrue(elementcount > 0, "No live survey cards found");
	       
	       System.out.println("Total Live number of cards : " + elementcount);
	   }


	   @Test(priority = 10, retryAnalyzer = Retry.class)
	   public void Overview() throws InterruptedException {
	       login();
	       String overviewText = driver.findElement(By.xpath(prop.getProperty("Overview"))).getText();
	       
	       // Example of condition to verify if overview text is present
	       Assert.assertNotNull(overviewText, "Overview text not found");
	       
	       System.out.println("Overview: " + overviewText);
	   }

	    
	   @Test(priority = 11, retryAnalyzer = Retry.class)
	   public void allsurveys_Heading() throws InterruptedException {
	       login();
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(250,350)", "");
	       Thread.sleep(1500);
	       
	       // Example of condition to verify all surveys heading
	       List<WebElement> elements = driver.findElements(By.xpath(prop.getProperty("Allsurveyscardsname")));
	       for (WebElement element : elements) {
	           System.out.println("Survey Heading: " + element.getText());
	       }
	       
	       List<WebElement> element = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
	       int elementcount = element.size() - 1;
	       System.out.println("Total Live number of cards : " + elementcount);
	   }

	    
	   @Test(priority = 12, retryAnalyzer = Retry.class)
	   public void print_the_firstsurvey_response() throws InterruptedException {
	       login();
	       
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(250,350)", "");
	       Thread.sleep(1500);
	       driver.findElement(By.xpath(prop.getProperty("surveycards"))).click();
	       Thread.sleep(2000);
	       
	       JavascriptExecutor jss = (JavascriptExecutor) driver;
	       jss.executeScript("window.scrollBy(250,1050)", "");
	       Thread.sleep(3500);
	       
	       // Example of condition to verify survey first question response
	       List<WebElement> elements = driver.findElements(By.xpath(prop.getProperty("surveycardquestion")));
	       for (WebElement element : elements) {
	           System.out.println("Survey Question: " + element.getText());
	       }
	   }
	   
	  
	   @Test (priority = 13, retryAnalyzer = Retry.class)
	   public void change_filters() throws InterruptedException {
	       login();
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(250,350)", "");
	       Thread.sleep(1500);

	       // Filter and count live surveys
	       driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
	       driver.findElement(By.xpath(prop.getProperty("Live"))).click();
	       Thread.sleep(1500);
	       List<WebElement> liveSurveys = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
	       int liveSurveyCount = liveSurveys.size() - 1;
	       Assert.assertTrue(liveSurveyCount > 0, "No live survey cards found");
	       System.out.println("Total Live number of cards : " + liveSurveyCount);
	       Thread.sleep(1000);

	       // Filter and count completed surveys
	       driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
	       Thread.sleep(1000);
	       driver.findElement(By.xpath(prop.getProperty("ALL"))).click();
	       Thread.sleep(1500);
	       List<WebElement> completedSurveys = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
	       int completedSurveyCount = completedSurveys.size() - 1;
	       Assert.assertTrue(completedSurveyCount > 0, "No completed survey cards found");
	       System.out.println("Total All number of cards : " + completedSurveyCount);
	       Thread.sleep(1000);

	       // Filter and count scheduled surveys
	       driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
	       Thread.sleep(1000);
	       driver.findElement(By.xpath(prop.getProperty("Scheduled"))).click();
	       Thread.sleep(1500);
	       List<WebElement> scheduledSurveys = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
	       int scheduledSurveyCount = scheduledSurveys.size() - 1;
	       Assert.assertTrue(scheduledSurveyCount > 0, "No scheduled survey cards found");
	       System.out.println("Total Scheduled number of cards : " + scheduledSurveyCount);
	   }
	   
	   
	   @Test (priority = 14, retryAnalyzer = Retry.class)
	   public void login_switch_home() throws InterruptedException {
	       // Log in to the application
	       login();
	       
	       // Click on the Dashboard Insight link
	       driver.findElement(By.xpath(prop.getProperty("Dashboardinsight"))).click();
	       Thread.sleep(3000);
	       
	       // Refresh the page
	       driver.navigate().refresh();
	       Thread.sleep(2000); // Adding a delay to ensure the page loads completely
	       
	       // Click on the Login link (or button)
	       driver.findElement(By.xpath(prop.getProperty("Login"))).click();
	       Thread.sleep(2000); // Adding a delay to ensure the page loads completely
	       
	       // Verify that the dashboard screen is displayed
	       WebElement dashboardTitle = driver.findElement(By.xpath(prop.getProperty("Dashboardmainscreen")));
	       Assert.assertTrue(dashboardTitle.isDisplayed(), "Expected dashboard screen after navigating back");
	       Thread.sleep(3000);
	       
	       // Print confirmation message
	       System.out.println("Navigated back to the dashboard successfully"); 
	   }
	   
	   @Test(priority = 15, retryAnalyzer = Retry.class)
	   public void getstarted_login() throws InterruptedException{
		   
		// Log in to the application
	       login();
	       
	       // Click on the Dashboard Insight link
	       driver.findElement(By.xpath(prop.getProperty("Dashboardinsight"))).click();
	       Thread.sleep(3000);
	       
	       // Refresh the page
	       int numberOfRefreshes = 5; 
	       for (int i = 0; i < numberOfRefreshes; i++) {
	           // Refresh the page
	           driver.navigate().refresh();
	           Thread.sleep(500); 
	       }
	       
	       Thread.sleep(3000); 
	       
	       // Click on the Login link (or button)
	       driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
	       Thread.sleep(2000); // Adding a delay to ensure the page loads completely
	       driver.findElement(By.xpath(prop.getProperty("signup-login"))).click();
	       
	       // Verify that the dashboard screen is displayed
	       WebElement dashboardTitle = driver.findElement(By.xpath(prop.getProperty("Dashboardmainscreen")));
	       Assert.assertTrue(dashboardTitle.isDisplayed(), "Expected dashboard screen after navigating back");
	       Thread.sleep(3000);

	       // Print confirmation message
	       System.out.println("Navigated back to the dashboard successfully"); 
	   }
	   
	   
	   @Test(priority = 16, retryAnalyzer = Retry.class)
	   public void verifySignupNotDisplayedAfterNavigation() throws InterruptedException {
	       // Click on Get Started and Signup/Login button
	       driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
	       driver.findElement(By.xpath(prop.getProperty("signup-login"))).click();

	       // Enter email and send verification code
	       driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@jupitermeta.io");
	       Thread.sleep(1000);
	       driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
	       Thread.sleep(8000);

	       // Enter OTP and submit
	       driver.findElement(By.xpath(prop.getProperty("Loginotpbutton"))).sendKeys("2020");
	       Thread.sleep(1000);
	       driver.findElement(By.xpath(prop.getProperty("Loginotpsubmit"))).click();
	       Thread.sleep(1500);

	       // Verify successful login and presence of dashboard.
	       WebElement dashboardTitle = driver.findElement(By.xpath(prop.getProperty("Dashboardmainscreen")));
	       Assert.assertTrue(dashboardTitle.isDisplayed(), "Dashboard main screen not displayed after login");
	       System.out.println("User logged in and dashboard displayed successfully");

	       // Navigate back to the previous page
	       driver.navigate().back();
	       Thread.sleep(3000);  

	       // Example of assertion to verify that Signup01 element is not displayed
	       boolean isSignupDisplayed = driver.findElement(By.xpath(prop.getProperty("Signup01"))).isDisplayed();
	       Assert.assertFalse(isSignupDisplayed, "Signup screen is still displayed after navigating back");
	   }
	   
	 	   
		   @Test(priority = 17, retryAnalyzer = Retry.class)
		    public void Delete_cookies() throws InterruptedException {
		        login(); // Assuming this method logs in and navigates to the desired page
		        Thread.sleep(2000);
		        
		        driver.navigate().back(); // Navigate back to simulate returning to the login screen
		        
		        // Clear cookies
		        driver.manage().deleteAllCookies();
		        Thread.sleep(1000);

		        // Refresh the page after clearing cookies
		        driver.navigate().refresh();
		        Thread.sleep(1000);

		        // Click on the Login button to trigger the login process
		        driver.findElement(By.xpath(prop.getProperty("Login"))).click();

		        // Verify if the Login with Google button is displayed
		        WebElement loginWithGoogleButton = driver.findElement(By.xpath(prop.getProperty("Loginwithgoogle")));
		        boolean isLoginDisplayed = loginWithGoogleButton.isDisplayed();
		        
		        // Assert that the login screen is displayed correctly
		        Assert.assertTrue(isLoginDisplayed, "Login screen with Google button is not displayed");

		        // Optional: Print a confirmation message
		        System.out.println("Login screen with Google button is displayed successfully");
		    }

		   
		   

}
