package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.Basetest;

public class SignUp  extends Basetest {

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
	
	 @Test(priority = 1, retryAnalyzer = Retry.class)
	    public void click_actions() throws InterruptedException {
	        Thread.sleep(1500);
	        driver.findElement(By.linkText(prop.getProperty("Pricing"))).click();
	        Thread.sleep(500);
	        driver.findElement(By.linkText(prop.getProperty("Resources"))).click();
	        driver.findElement(By.linkText(prop.getProperty("SuperjApp"))).click();
	    }

	 @Test(priority = 2, retryAnalyzer = Retry.class)
	    public void clickon_signup() throws InterruptedException {
	        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
	        Thread.sleep(500);
	        WebElement signup = driver.findElement(By.xpath(prop.getProperty("Signup01")));
	        String actualElementText = signup.getText();
	        String expectedElementText = "Sign Up";
	        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
	    }
	 
	 @Test(priority = 3, retryAnalyzer = Retry.class,enabled = true)
	    public void login_signup() throws InterruptedException {
	    	
	        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
	        WebElement signup = driver.findElement(By.xpath(prop.getProperty("Signup01")));
	        String actualElementText = signup.getText();
	        String expectedElementText = "Sign Up";
	        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
	    }

	 @Test(priority = 4, retryAnalyzer = Retry.class,enabled = false)
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
	 
	 @Test(priority = 5, retryAnalyzer = Retry.class,enabled = true)
	    public void signup_Invalidemail() throws InterruptedException {
	    	
	        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
	        driver.findElement(By.xpath(prop.getProperty("Useryouremail"))).click();
	        driver.findElement(By.xpath(prop.getProperty("Signupemailtextfiled"))).sendKeys("rajeshkancha.com");
	        driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
	 
	        WebElement errormessage = driver.findElement(By.xpath(prop.getProperty("signup-Email-errormessage")));
		    String actualelement = errormessage.getText();
	        String expectedelement = "This Email is invalid. Try again!";
	        Assert.assertEquals(actualelement, expectedelement, "both should be same");
	 }
	 
	 @Test(priority = 6, retryAnalyzer = Retry.class,enabled = true)
	    public void signup_Invalid_OTP() throws InterruptedException {
	    	
	        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
	        driver.findElement(By.xpath(prop.getProperty("Useryouremail"))).click();
	        driver.findElement(By.xpath(prop.getProperty("Signupemailtextfiled"))).sendKeys("rajeshkancha@gmail.com");
	        driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
	        Thread.sleep(5000);
	        
	        driver.findElement(By.xpath(prop.getProperty("signupotp"))).sendKeys("1234");	        
	        driver.findElement(By.xpath(prop.getProperty("signupsubmit"))).click();
	       	        
	        WebElement errormessage = driver.findElement(By.xpath(prop.getProperty("signupotperrormessage")));
		    String actualelement = errormessage.getText();
	        String expectedelement = "Please enter a valid code";
	        Assert.assertEquals(actualelement, expectedelement, "both should be same");
	 }
	 
	 @Test(priority = 7, retryAnalyzer = Retry.class,enabled = true)
	 public void Login_signup() throws InterruptedException {
		
		 driver.findElement(By.xpath(prop.getProperty("Login"))).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath(prop.getProperty("Logintostrrt"))).click();
	     driver.findElement(By.xpath(prop.getProperty("Useryouremail"))).click();
	     driver.findElement(By.xpath(prop.getProperty("Signupemailtextfiled"))).sendKeys("rajeshkancha41@gmail.com");
	     driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
	     Thread.sleep(15000);
		 
	}
	 
	 @Test(priority = 8, retryAnalyzer = Retry.class,enabled = true)
	 public void existing_emailid() throws InterruptedException {
		
		  driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
	        driver.findElement(By.xpath(prop.getProperty("Useryouremail"))).click();
	        driver.findElement(By.xpath(prop.getProperty("Signupemailtextfiled"))).sendKeys("rajesh@jupitermeta.io");
	        driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
	        Thread.sleep(2000);
	       	       	        
	        WebElement errormessage = driver.findElement(By.xpath(prop.getProperty("existinguser")));
		    String actualelement = errormessage.getText();
	        String expectedelement = "You have a registered account! Just Log in";
	        Assert.assertEquals(actualelement, expectedelement, "both should be same");
	 
	}
}
