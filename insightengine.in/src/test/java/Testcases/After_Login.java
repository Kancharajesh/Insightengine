package Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.Basetest;

public class After_Login extends Basetest {

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
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
        System.out.println(e);
    }
	
	 @Test(priority = 2, retryAnalyzer = Retry.class)
	    public void signup_login() throws InterruptedException {
	        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
	        driver.findElement(By.xpath(prop.getProperty("signup-login"))).click();

	        driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@jupitermeta.io");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
		    Thread.sleep(8000);
		    driver.findElement(By.xpath(prop.getProperty("Loginotpbutton"))).sendKeys("2020");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath(prop.getProperty("Loginotpsubmit"))).click();
		    Thread.sleep(1500);

	 }
	 
	   @Test(priority = 3, retryAnalyzer = Retry.class, enabled = true)
	    public void after_login_changeto_filter() throws InterruptedException {
	        
	    	login();
	        driver.findElement(By.xpath(prop.getProperty("clickonfilter"))).click();
	        driver.findElement(By.xpath(prop.getProperty("Scheduled"))).click();
	        Thread.sleep(5000);
	    }
	 
	   @Test(priority = 4, retryAnalyzer = Retry.class)
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

	   @Test(priority = 5, retryAnalyzer = Retry.class)
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
	   
	   @Test(priority = 6, retryAnalyzer = Retry.class)
	    public void allsurveys_cardLIST() throws InterruptedException {
	        login();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(250,350)", "");
	        Thread.sleep(1500);
	        List<WebElement> element = driver.findElements(By.xpath(prop.getProperty("Totalsurveycards")));
	        int elementcount = element.size();
	        System.out.println("Total All number of cards : " + elementcount);
	    }

	
	   @Test(priority = 7, retryAnalyzer = Retry.class)
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
	        int elementcount = element.size();
	        System.out.println("Total Completed number of cards : " + elementcount);
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
	        int elementcount = element.size();
	        System.out.println("Total Live number of cards : " + elementcount);
	    }

	    @Test(priority = 10, retryAnalyzer = Retry.class)
	    public void Overview() throws InterruptedException {
	        login();
	        String br = driver.findElement(By.xpath(prop.getProperty("Overview"))).getText();
	        System.out.println(br);
	    }
	    
	    @Test(priority = 11, retryAnalyzer = Retry.class)
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
	    
	    @Test(priority = 12,retryAnalyzer = Retry.class) 
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
}
