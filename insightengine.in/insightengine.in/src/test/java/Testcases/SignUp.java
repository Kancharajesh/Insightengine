package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Baseclass.Basetest;

public class SignUp extends Basetest {

    private void navigateToGetStarted() throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Getstarted01"))).click();
        Thread.sleep(1000);
    }

    private void clickOnSignUpButton() throws InterruptedException {
        WebElement signUpButton = driver.findElement(By.xpath(prop.getProperty("Signup01")));
        signUpButton.click();
        Thread.sleep(500);
    }

    private void enterEmailAndSendCode(String email) throws InterruptedException {
        driver.findElement(By.xpath(prop.getProperty("Useryouremail"))).click();
        driver.findElement(By.xpath(prop.getProperty("Signupemailtextfiled"))).sendKeys(email);
        driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
        Thread.sleep(25000); // Replace with explicit wait based on OTP completion
        driver.findElement(By.xpath(prop.getProperty("signupsubmit"))).click();
    }

    private void assertElementText(String xpath, String expectedText, String errorMessage) {
        WebElement element = driver.findElement(By.xpath(xpath));
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, errorMessage);
    }

    @Test(priority = 1, retryAnalyzer = Retry.class)
    public void click_actions() throws InterruptedException {
        test = extent.createTest("Click Actions Test");
        test.log(Status.INFO, "Starting click_actions test");

        Thread.sleep(1500);
        driver.findElement(By.linkText(prop.getProperty("Pricing"))).click();
        test.log(Status.INFO, "Clicked on Pricing");

        Thread.sleep(500);
        driver.findElement(By.linkText(prop.getProperty("Resources"))).click();
        test.log(Status.INFO, "Clicked on Resources");

        driver.findElement(By.linkText(prop.getProperty("SuperjApp"))).click();
        test.log(Status.INFO, "Clicked on SuperJ App");

        test.log(Status.PASS, "click_actions test completed successfully");
    }

    @Test(priority = 2, retryAnalyzer = Retry.class)
    public void clickon_signup() throws InterruptedException {
        test = extent.createTest("Click on Sign-Up Test");
        test.log(Status.INFO, "Starting clickon_signup test");

        navigateToGetStarted();
        clickOnSignUpButton();

        String expectedElementText = "Sign Up";
        assertElementText(prop.getProperty("Signup01"), expectedElementText, "Expected and Actual text should be the same");

        test.log(Status.PASS, "clickon_signup test completed successfully");
    }

    @Test(priority = 3, retryAnalyzer = Retry.class, enabled = true)
    public void login_signup() throws InterruptedException {
        test = extent.createTest("Login Sign-Up Test");
        test.log(Status.INFO, "Starting login_signup test");

        navigateToGetStarted();
        clickOnSignUpButton();

        String expectedElementText = "Sign Up";
        assertElementText(prop.getProperty("Signup01"), expectedElementText, "Expected and Actual text should be the same");

        test.log(Status.PASS, "login_signup test completed successfully");
    }

    @Test(priority = 4, retryAnalyzer = Retry.class, enabled = false)
    public void signup_Welcome() throws InterruptedException {
        test = extent.createTest("Sign-Up Welcome Test");
        test.log(Status.INFO, "Starting signup_Welcome test");

        navigateToGetStarted();
        enterEmailAndSendCode("rajeshkancha29@gmail.com");
        // Replace with appropriate wait for OTP
        Thread.sleep(15000);
        driver.findElement(By.xpath(prop.getProperty("signupsubmit"))).click();

        assertElementText(prop.getProperty("welcome"), "Welcome", "Expected and Actual text should be the same");

        test.log(Status.PASS, "signup_Welcome test completed successfully");
    }

    @Test(priority = 5, retryAnalyzer = Retry.class, enabled = true)
    public void signup_Invalidemail() throws InterruptedException {
        test = extent.createTest("Sign-Up Invalid Email Test");
        test.log(Status.INFO, "Starting signup_Invalidemail test");

        navigateToGetStarted();
        enterEmailAndSendCode("rajeshkancha.com");

        assertElementText(prop.getProperty("signup-Email-errormessage"),
                "This Email is invalid. Try again!", "Expected and Actual text should be the same");

        test.log(Status.PASS, "signup_Invalidemail test completed successfully");
    }

    @Test(priority = 6, retryAnalyzer = Retry.class, enabled = true)
    public void signup_Invalid_OTP() throws InterruptedException {
        test = extent.createTest("Sign-Up Invalid OTP Test");
        test.log(Status.INFO, "Starting signup_Invalid_OTP test");

        navigateToGetStarted();
        enterEmailAndSendCode("rajeshkancha@gmail.com");
        Thread.sleep(5000);

        driver.findElement(By.xpath(prop.getProperty("signupotp"))).sendKeys("1234");
        driver.findElement(By.xpath(prop.getProperty("signupsubmit"))).click();

        assertElementText(prop.getProperty("signupotperrormessage"),
                "Please enter a valid code", "Expected and Actual text should be the same");

        test.log(Status.PASS, "signup_Invalid_OTP test completed successfully");
    }

    @Test(priority = 7, retryAnalyzer = Retry.class, enabled = true)
    public void Login_signup() throws InterruptedException {
        test = extent.createTest("Login Sign-Up Test");
        test.log(Status.INFO, "Starting Login_signup test");

        driver.findElement(By.xpath(prop.getProperty("Login"))).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(prop.getProperty("Logintostart"))).click();
        driver.findElement(By.xpath(prop.getProperty("Signupemailtextfiled"))).sendKeys("rajeshkancha29@gmail.com");
        driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
        Thread.sleep(2000);

        test.log(Status.PASS, "Login_signup test completed successfully");
    }

    @Test(priority = 8, retryAnalyzer = Retry.class, enabled = true)
    public void existing_emailid() throws InterruptedException {
        test = extent.createTest("Existing Email ID Test");
        test.log(Status.INFO, "Starting existing_emailid test");

        navigateToGetStarted();
        driver.findElement(By.xpath(prop.getProperty("Useryouremail"))).click();
        driver.findElement(By.xpath(prop.getProperty("Signupemailtextfiled"))).sendKeys("rajesh@jupitermeta.io");
        driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();
        Thread.sleep(2000);

        assertElementText(prop.getProperty("existinguser"),
                "You have a registered account! Just Log in", "Expected and Actual text should be the same");

        test.log(Status.PASS, "existing_emailid test completed successfully");
    }

    @Test(priority = 9, retryAnalyzer = Retry.class, enabled = true)
    public void signup_resendcode() throws InterruptedException { 
        test = extent.createTest("Sign-Up Resend OTP Test");
        test.log(Status.INFO, "Starting signup_resendcode test");

        navigateToGetStarted();
        enterEmailAndSendCode("rajeshkancha29@gmail.com");

        // Wait for 35 seconds for OTP to expire or for resend option to appear
        Thread.sleep(10000);

        // Resend OTP by clicking on Resend OTP button
        driver.findElement(By.xpath(prop.getProperty("signupresendotp"))).click();
        test.log(Status.INFO, "Clicked on Resend OTP");
    }
    
    @Test(priority = 10, retryAnalyzer = Retry.class, enabled = false)
    public void signup_EmptyEmail() throws InterruptedException {
        test = extent.createTest("Sign-Up Empty Email Test");
        test.log(Status.INFO, "Starting signup_EmptyEmail test");

        navigateToGetStarted();
        driver.findElement(By.xpath(prop.getProperty("signupsendcode"))).click();

        assertElementText(prop.getProperty("signup-Email-errormessage"),
                "Email field cannot be empty", "Expected and Actual text should be the same");

        test.log(Status.PASS, "signup_EmptyEmail test completed successfully");
    }
    
    @Test(priority = 11, retryAnalyzer = Retry.class, enabled = true)
    public void signup_MultipleInvalidOtps() throws InterruptedException {
        test = extent.createTest("Sign-Up Multiple Invalid OTPs Test");
        test.log(Status.INFO, "Starting signup_MultipleInvalidOtps test");

        navigateToGetStarted();
        enterEmailAndSendCode("rajeshkancha@gmail.com");
        Thread.sleep(8000); // Wait for OTP input field to be ready

        String[] invalidOtps = {"0000", "1111", "2222"}; // Array of invalid OTPs

        for (String otp : invalidOtps) {
            WebElement otpInput = driver.findElement(By.xpath(prop.getProperty("signupotp")));
            Thread.sleep(1000);
            otpInput.clear(); // Clear the OTP field before entering a new OTP
            Thread.sleep(500); // Add a short wait to ensure the field is cleared
            otpInput.sendKeys(otp);
            driver.findElement(By.xpath(prop.getProperty("signupsubmit"))).click();
            Thread.sleep(1000); // Add a short wait to allow for error message display

            // Validate the error message for each invalid OTP
            assertElementText(prop.getProperty("signupotperrormessage"),
                    "Please enter a valid code", "Expected and Actual text should be the same");
        }

        test.log(Status.PASS, "signup_MultipleInvalidOtps test completed successfully");
    }

    
}
