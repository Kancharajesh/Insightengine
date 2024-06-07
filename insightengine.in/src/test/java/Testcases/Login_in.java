package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.Basetest;

public class Login_in extends Basetest {
	
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
		    public void clickon_login() throws InterruptedException {
		        Thread.sleep(1000);
		        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
		        Thread.sleep(500);
		        WebElement disBoolean = driver.findElement(By.xpath(prop.getProperty("login01")));
		        System.out.println("Log in: " + disBoolean);
		    }

		 @Test(priority = 2, retryAnalyzer = Retry.class)
		    public void Resend_OTP() throws InterruptedException {
		        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
		        Thread.sleep(500);
		        driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@jupitermeta.io");
		        driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
		        Thread.sleep(35000);
		        driver.findElement(By.xpath(prop.getProperty("Loginotpresend"))).click();
		        Thread.sleep(5000);
		    
		 }
		 
		 @Test(priority = 3, retryAnalyzer = Retry.class)
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
		 
		 @Test(priority = 4, retryAnalyzer = Retry.class)
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

		 @Test(priority = 5, retryAnalyzer = Retry.class)
		    public void OTP_error() throws InterruptedException {
			 
		        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
		        Thread.sleep(500);
		        driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@jupitermeta.io");
		        driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
		        Thread.sleep(4500);
		      
		        driver.findElement(By.xpath(prop.getProperty("Loginotpsubmit"))).click();
		        WebElement e = driver.findElement(By.xpath(prop.getProperty("loginotperrormessage")));
		        String actualElementText = e.getText();
		        String expectedElementText = "Please enter a valid code";
		        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
		    }

		 @Test(priority = 6, retryAnalyzer = Retry.class,enabled = false)
		    public void login_signup() throws InterruptedException {
		    	
		        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
		        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
		        
		        WebElement signup = driver.findElement(By.xpath(prop.getProperty("Signup01")));
		        String actualElementText = signup.getText();
		        String expectedElementText = "Sign Up";
		        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
		    }
		 
		 @Test(priority = 7, retryAnalyzer = Retry.class)
		 public void New_eamilid() throws InterruptedException {
			
			   	driver.findElement(By.xpath(prop.getProperty("Login"))).click();
			   	Thread.sleep(500);
		        driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@hmail.io");
		        driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
		        Thread.sleep(4500);
		     
		        
		        WebElement e = driver.findElement(By.xpath(prop.getProperty("new-email")));
		        String actualElementText = e.getText();
		        String expectedElementText = "This Email is new to us. Please Sign Up to get started!";
		        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
		    
		}

		 @Test(priority = 8, retryAnalyzer = Retry.class)
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
		 
		
		 
}
