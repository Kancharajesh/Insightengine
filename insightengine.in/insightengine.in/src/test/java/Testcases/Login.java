package Testcases;

import java.security.PublicKey;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Baseclass.Basetest;

public class Login extends Basetest {

	
	@Test(priority =1,retryAnalyzer = Retry.class,enabled = true)
	public void TCtets2() throws Exception{
		
		String br = driver.findElement(By.xpath("/html/body/main/nav[1]/div[2]/div[1]/ul")).getText();
		System.out.println(br);	

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
        //Locating element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds")));

        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		// enter the Email id.
		driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds"))).sendKeys(prop.getProperty("ValidEmail"));
		driver.findElement(By.cssSelector(prop.getProperty("EmailSubmit"))).click();
		
		Thread.sleep(3000);
	
	}

	
	@Test(priority = 1,retryAnalyzer = Retry.class,enabled = true)
	public void TC_01() throws Exception 
	{
	
		driver.findElement(By.xpath(prop.getProperty("GetStarted"))).click();
		
		Boolean Visible = driver.findElement(By.xpath(prop.getProperty("Submit"))).isDisplayed();
		System.out.print(true);
		
	
	}
	
	
	@Test(priority = 2,retryAnalyzer = Retry.class,enabled = true)
	public void TC_02() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(250,350)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Getstarteds"))).click();
		Thread.sleep(1000);
		
		Boolean visible = driver.findElement(By.xpath(prop.getProperty("MainTitle"))).isDisplayed();
		System.out.println(true);
	}
	
	
	@Test(priority = 3,retryAnalyzer = Retry.class,enabled = true)
	public void TC_04() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(250,2500)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Solution1"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Solution2"))).click();
		driver.findElement(By.xpath(prop.getProperty("Solution3"))).click();
		driver.findElement(By.xpath(prop.getProperty("Solution4"))).click();
		driver.findElement(By.xpath(prop.getProperty("Solution5"))).click();
		
		
	}
	
	
	
	@Test(priority = 5,retryAnalyzer = Retry.class,enabled = true)
	public void TC_05() throws Exception
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(250,3500)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Testmon3"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("Testmon2"))).click();
		driver.findElement(By.xpath(prop.getProperty("Testmon4"))).click();
		driver.findElement(By.xpath(prop.getProperty("Testmon1"))).click();
			
	}
	
	

	@Test(priority = 6,retryAnalyzer = Retry.class,enabled = true)
	public void TC_06() throws Exception
	{
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
        //Locating element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds")));

        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		// enter the Email id.
		driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds"))).sendKeys(prop.getProperty("ValidEmail"));
		driver.findElement(By.cssSelector(prop.getProperty("EmailSubmit"))).click();
		Thread.sleep(2500);
		
	    boolean message =	driver.findElement(By.xpath(prop.getProperty("emailmessage"))).isDisplayed(); 
	    Assert.assertEquals(message,true, "Thanks for sharing! Our team will reach out to you shortly.");
	    		
	}
	
	
	@Test(priority = 7,retryAnalyzer = Retry.class,enabled = true)
	public void TC_07() throws Exception
	{
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
        //Locating element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds")));

        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		// enter the InValidEmail id.
		driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds"))).sendKeys(prop.getProperty("InvalidEmail"));
		driver.findElement(By.cssSelector(prop.getProperty("EmailSubmit"))).click();
		
	    boolean message =	driver.findElement(By.xpath(prop.getProperty("emailerrormessage"))).isDisplayed(); 
			
		WebElement e = driver.findElement(By.xpath(prop.getProperty("emailerrormessage")));
		System.out.println(e.getText());
	    		
	}
	
	
	@Test(priority = 8,retryAnalyzer = Retry.class,enabled = true)
	public void TC_08() throws Exception
	{
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
        //Locating element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.linkText("Privacy Policy"));

        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
		driver.findElement(By.xpath(prop.getProperty("instagram"))).click();
		driver.findElement(By.xpath(prop.getProperty("twitter"))).click();
		driver.findElement(By.xpath(prop.getProperty("linkdin"))).click();
		
		Thread.sleep(9000);
	}


	@Test(priority = 9,retryAnalyzer = Retry.class,enabled = true)
	public void TC_09() throws Exception
	{
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
        //Locating element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.linkText("Privacy Policy"));

        // Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
		
        driver.findElement(By.xpath(prop.getProperty("PrivacyPolicy"))).click();
        driver.navigate().back();

        driver.findElement(By.xpath(prop.getProperty("Terms&Conditions"))).click();
        driver.navigate().back();
        
        driver.findElement(By.xpath(prop.getProperty("Disclaimer"))).click();
        driver.navigate().back();
		
		Thread.sleep(9000);
	}
	
	
	@Test(priority = 10,retryAnalyzer = Retry.class,enabled = true)
	public void Tc_10()  throws Exception
	{
	
		driver.findElement(By.linkText(prop.getProperty("Pricing"))).click();
		
		driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds"))).sendKeys(prop.getProperty("ValidEmail"));
		driver.findElement(By.cssSelector(prop.getProperty("EmailSubmit"))).click();
		Thread.sleep(5500);
		
	    Boolean message = driver.findElement(By.xpath(prop.getProperty("Emailmsgsucess"))).isDisplayed();
	    
	}
	
	
	@Test(priority = 11,retryAnalyzer = Retry.class,enabled = true)
	public void Tc_11()  throws Exception
	{
	
		driver.findElement(By.linkText(prop.getProperty("Pricing"))).click();
		
		driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds"))).sendKeys(prop.getProperty("InvalidEmail"));
		driver.findElement(By.cssSelector(prop.getProperty("EmailSubmit"))).click();

		
	    Boolean message = driver.findElement(By.xpath(prop.getProperty("emailmsgerror"))).isDisplayed();
	    System.out.println(true);
	    
	}
	
	
	@Test(priority = 12,retryAnalyzer = Retry.class,enabled = true)
	public void Tc_12()  throws Exception
	{
	
		driver.findElement(By.linkText(prop.getProperty("Resources"))).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("DownloadReport"))).click();
		
		driver.findElement(By.cssSelector(prop.getProperty("ReportName"))).sendKeys(prop.getProperty("validName"));
		driver.findElement(By.cssSelector(prop.getProperty("ReportEmail"))).sendKeys(prop.getProperty("ValidCompanyName"));
		driver.findElement(By.cssSelector(prop.getProperty("ReoprtDesignation"))).sendKeys(prop.getProperty("ValidDesinatio"));
		driver.findElement(By.cssSelector(prop.getProperty("ReportCompany"))).sendKeys(prop.getProperty("ValidCompanyName"));
		
		driver.findElement(By.xpath(prop.getProperty("ReportDownloadReport"))).click();
		
		
		
		driver.findElement(By.cssSelector(prop.getProperty("EmailSubmit"))).click();
		Thread.sleep(5500);
		
	  //  Boolean message = driver.findElement(By.xpath(prop.getProperty("Emailmsgsucess"))).isDisplayed();
	    
	}
	
	@Test(priority = 13,retryAnalyzer = Retry.class,enabled = true)
	public void TC_13() throws Exception 
	{
		
		driver.findElement(By.linkText(prop.getProperty("Resources"))).click();	
		
		Thread.sleep(700);
		driver.findElement(By.xpath(prop.getProperty("DownloadReport"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(prop.getProperty("ReportDownloadReport1"))).click();
		
//		driver.findElement(By.cssSelector(prop.getProperty("ReportName"))).sendKeys(prop.getProperty("INValidName"));
//		driver.findElement(By.cssSelector(prop.getProperty("ReportEmail"))).sendKeys(prop.getProperty("InvalidCompanyName"));
//		driver.findElement(By.cssSelector(prop.getProperty("ReoprtDesignation"))).sendKeys(prop.getProperty("InvalidDesignation"));
//		driver.findElement(By.cssSelector(prop.getProperty("ReportCompany"))).sendKeys(prop.getProperty("InvalidCompanyName"));
		
		Boolean name =  driver .findElement(By.xpath(prop.getProperty("NameValidtion1"))).isDisplayed();
		
		Boolean email = driver.findElement(By.xpath(prop.getProperty("EmailValidtion1"))).isDisplayed();
		
		Boolean Designation =	driver.findElement(By.xpath(prop.getProperty("DesignationValidation1"))).isDisplayed();
		
		Boolean companyname =  driver.findElement(By.xpath(prop.getProperty("CompanynameValidation1"))).isDisplayed();
		
		
		 Assert.assertEquals(true, name);
		 Assert.assertEquals(true, email);
		 Assert.assertEquals(true, Designation);
		 Assert.assertEquals(true, companyname);
	//	driver.findElement(By.cssSelector(prop.getProperty("EmailSubmit"))).click();
		Thread.sleep(5500);
		
	}
	
	
		@Test(priority = 14,retryAnalyzer = Retry.class,enabled = true)
    	public void TC_14() throws Exception 
		{
		
			driver.findElement(By.linkText(prop.getProperty("Resources"))).click();
			
			Thread.sleep(700);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
	        //Locating element by link text and store in variable "Element"        		
	        WebElement Element = driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds")));

	        // Scrolling down the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Element);
			
			// enter the Email id.
			driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds"))).sendKeys(prop.getProperty("ValidEmail"));
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(prop.getProperty("EmailSubmit"))).click();
			Thread.sleep(4000);

		    Boolean emailmessage =	 driver.findElement(By.xpath(prop.getProperty("emailsucessmessage01"))).isDisplayed();
			    
		    Assert.assertEquals(true, emailmessage);
		}
	
		@Test(priority = 15,retryAnalyzer = Retry.class,enabled = true)
		public void TC_15() throws Exception 
		{
			
			driver.findElement(By.linkText(prop.getProperty("Resources"))).click();
		
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
	        //Locating element by link text and store in variable "Element"        		
	        WebElement Element = driver.findElement(By.cssSelector(prop.getProperty("EmailtextFileds")));

	        // Scrolling down the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Element);
			
			// enter the INEmail id.
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(prop.getProperty("EmailSubmit"))).click();
			Thread.sleep(1000);

		    Boolean emailerrormessage =	 driver.findElement(By.xpath(prop.getProperty("resourcesemailerrormsg"))).isDisplayed();
			    
		    Assert.assertEquals(true, emailerrormessage);

			
		}
	
		
		
	
}
