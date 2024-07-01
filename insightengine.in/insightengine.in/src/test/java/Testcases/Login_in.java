package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Baseclass.Basetest;




public class Login_in extends Basetest { 
    // Method to perform login
    private void login(String email, String otp) throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath(prop.getProperty("Loginotpbutton"))).sendKeys(otp);
        Thread.sleep(1000);
        driver.findElement(By.xpath(prop.getProperty("Loginotpsubmit"))).click();
        Thread.sleep(1500);
    }

    // Method to perform sign-up
    private void signUp(String email) throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(prop.getProperty("Useryouremail"))).click();
        driver.findElement(By.xpath(prop.getProperty("Signupemailtextfiled"))).sendKeys(email);
        driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
        Thread.sleep(25000);
        driver.findElement(By.xpath(prop.getProperty("signupsubmit"))).click();
    } 

    
    
    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void clickon_login() throws InterruptedException {
        test = extent.createTest("Click on Login Test");
        test.log(Status.INFO, "Starting clickon_login test");

        login("rajesh@jupitermeta.io", "2020");
        test.log(Status.INFO, "Entered email and OTP");

        // Additional test steps if needed
        test.log(Status.PASS, "clickon_login test completed successfully");
    }

    @Test(priority = 2, retryAnalyzer = Retry.class)
    public void Resend_OTP() throws InterruptedException {
        test = extent.createTest("Resend OTP Test");
        test.log(Status.INFO, "Starting Resend_OTP test");

        login("rajesh@jupitermeta.io", ""); // Assuming resend OTP action
        test.log(Status.INFO, "Clicked on login and sent code");

        Thread.sleep(35000);
        driver.findElement(By.xpath(prop.getProperty("Loginotpresend"))).click();
        Thread.sleep(5000);
        test.log(Status.INFO, "Clicked on Resend OTP");

        // Additional test steps if needed
        test.log(Status.PASS, "Resend_OTP test completed successfully");
    }

    @Test(priority = 3, retryAnalyzer = Retry.class)
    public void Invalid_Email() throws InterruptedException {
        test = extent.createTest("Invalid Email Test");
        test.log(Status.INFO, "Starting Invalid_Email test");

        login("123", ""); // Invalid email scenario
        test.log(Status.INFO, "Entered invalid email");

        WebElement e = driver.findElement(By.xpath(prop.getProperty("emailinvalidmessage")));
        String actualElementText = e.getText();
        String expectedElementText = "This Email is invalid. Try again!";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
        test.log(Status.INFO, "Validated error message for invalid email");

        // Additional test steps if needed
        test.log(Status.PASS, "Invalid_Email test completed successfully");
    }

    @Test(priority = 4, retryAnalyzer = Retry.class)
    public void email_error_message() throws InterruptedException {
        test = extent.createTest("Email Error Message Test");
        test.log(Status.INFO, "Starting email_error_message test");

        login("", ""); // No email provided
        test.log(Status.INFO, "No email provided");

        WebElement e = driver.findElement(By.xpath(prop.getProperty("emailinvalidmessage")));
        String actualElementText = e.getText();
        String expectedElementText = "This Email is invalid. Try again!";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
        test.log(Status.INFO, "Validated error message for no email");

        // Additional test steps if needed
        test.log(Status.PASS, "email_error_message test completed successfully");
    }

    @Test(priority = 5, retryAnalyzer = Retry.class)
    public void OTP_error() throws InterruptedException {
        test = extent.createTest("OTP Error Test");
        test.log(Status.INFO, "Starting OTP_error test");

        login("rajesh@jupitermeta.io", "");
        test.log(Status.INFO, "Entered email but no OTP");

        Thread.sleep(4500);
        driver.findElement(By.xpath(prop.getProperty("Loginotpsubmit"))).click();
        WebElement e = driver.findElement(By.xpath(prop.getProperty("loginotperrormessage")));
        String actualElementText = e.getText();
        String expectedElementText = "Please enter a valid code";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
        test.log(Status.INFO, "Validated error message for invalid OTP");

        // Additional test steps if needed
        test.log(Status.PASS, "OTP_error test completed successfully");
    }

    @Test(priority = 6, retryAnalyzer = Retry.class, enabled = true)
    public void login_signup() throws InterruptedException {
        test = extent.createTest("Login Sign-Up Test");
        test.log(Status.INFO, "Starting login_signup test");

        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
        Thread.sleep(1500);
        WebElement signup = driver.findElement(By.xpath(prop.getProperty("Signup01")));
        String actualElementText = signup.getText();
        String expectedElementText = "Sign Up";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
        test.log(Status.INFO, "Navigated to Sign-Up page");

        // Additional test steps if needed

        test.log(Status.PASS, "login_signup test completed successfully");
    }


    @Test(priority = 7, retryAnalyzer = Retry.class)
    public void New_emailid() throws InterruptedException {
        test = extent.createTest("New Email ID Test");
        test.log(Status.INFO, "Starting New_emailid test");

        login("rajesh@gmail.io", "");
        test.log(Status.INFO, "Entered a new email");

        WebElement e = driver.findElement(By.xpath(prop.getProperty("new-email")));
        String actualElementText = e.getText();
        String expectedElementText = "This Email is new to us. Please Sign Up to get started!";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
        test.log(Status.INFO, "Validated message for new email");

        // Additional test steps if needed
        test.log(Status.PASS, "New_emailid test completed successfully");
    }

    @Test(priority = 8, retryAnalyzer = Retry.class)
    public void signup_login() throws InterruptedException {
        test = extent.createTest("Sign-Up Login Test");
        test.log(Status.INFO, "Starting signup_login test");

        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
        driver.findElement(By.xpath(prop.getProperty("signup-login"))).click();
        test.log(Status.INFO, "Navigated to login from Sign-Up page");

        driver.findElement(By.xpath(prop.getProperty("Loginemailtextinput"))).sendKeys("rajesh@jupitermeta.io");
        Thread.sleep(1000);
        driver.findElement(By.xpath(prop.getProperty("Loginsendcode"))).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath(prop.getProperty("Loginotpbutton"))).sendKeys("2020");
        Thread.sleep(1000);
        driver.findElement(By.xpath(prop.getProperty("Loginotpsubmit"))).click();
        Thread.sleep(1500);
        test.log(Status.INFO, "Logged in using email and OTP");

        // Additional test steps if needed
        test.log(Status.PASS, "signup_login test completed successfully");
    }

    @Test(priority = 9, retryAnalyzer = Retry.class)
    public void New_emailid_clickon_get_started() throws InterruptedException {
        test = extent.createTest("New Email ID Click on Get Started Test");
        test.log(Status.INFO, "Starting New_emailid_clickon_get_started test");

        login("rajesh@gmail.io", "");
        test.log(Status.INFO, "Entered a new email");

        WebElement e = driver.findElement(By.xpath(prop.getProperty("new-email")));
        String actualElementText = e.getText();
        String expectedElementText = "This Email is new to us. Please Sign Up to get started!";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
        test.log(Status.INFO, "Validated message for new email");

        // Additional test steps if needed
        test.log(Status.PASS, "New_emailid_clickon_get_started test completed successfully");
    }

    @Test(priority = 10, retryAnalyzer = Retry.class)
    public void New_emailidclickon_get_started() throws InterruptedException {
        test = extent.createTest("New Email ID Click on Get Started Test");
        test.log(Status.INFO, "Starting New_emailidclickon_get_started test");

        login("rajesh@gmail.io", "");
        test.log(Status.INFO, "Entered a new email");

        WebElement e = driver.findElement(By.xpath(prop.getProperty("new-email")));
        String actualElementText = e.getText();
        String expectedElementText = "This Email is new to us. Please Sign Up to get started!";
        Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
        test.log(Status.INFO, "Validated message for new email");

        // Additional test steps if needed
        test.log(Status.PASS, "New_emailidclickon_get_started test completed successfully");
    }
}
