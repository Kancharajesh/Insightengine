package Testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Baseclass.Basetest;

public class clickable_function  extends Basetest {

	 
	@Test(priority = 1, retryAnalyzer = Retry.class)
	public void TC_01() throws Exception {
	    // Scroll to Get started.
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,350)");

	    // Click on Get started.
	    driver.findElement(By.xpath(insight.getProperty("Getstarteds"))).click();

	    // Log additional information
	    String pageTitle = driver.getTitle();
	    System.out.println("Page Title: " + pageTitle);

	    Thread.sleep(1500);
	}


	
	@Test(priority = 2,retryAnalyzer = Retry.class)
	public void TC_02() throws Exception
	{
		
		// scroll to How it works.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(1500);
		
		// Click on How it works.
		driver.findElement(By.xpath(insight.getProperty("Howitworks"))).click();
		
	}
	
	
	@Test(priority = 3,retryAnalyzer = Retry.class,enabled = true)
	public void TC_03() throws Exception
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2550)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(insight.getProperty("Solution1"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(insight.getProperty("Solution2"))).click();
		driver.findElement(By.xpath(insight.getProperty("Solution3"))).click();
		driver.findElement(By.xpath(insight.getProperty("Solution4"))).click();
		driver.findElement(By.xpath(insight.getProperty("Solution5"))).click();
		
	}
	
	@Test(priority = 4,retryAnalyzer = Retry.class,enabled = false)
	public void TC_04() throws Exception
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3500)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(insight.getProperty("Testmon3"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(insight.getProperty("Testmon2"))).click();
		driver.findElement(By.xpath(insight.getProperty("Testmon4"))).click();
		driver.findElement(By.xpath(insight.getProperty("Testmon1"))).click();
			
	}
	
	@Test(priority = 5,retryAnalyzer = Retry.class)
	public void TC_05() throws Exception
	{
	
		// click on Pricing.
		driver.findElement(By.linkText(insight.getProperty("Pricing"))).click();
		Thread.sleep(1000);
		
		// click on Resources.
		driver.findElement(By.linkText(insight.getProperty("Resources"))).click();
		Thread.sleep(1000);
		
		// click on InsightEngine.
		driver.findElement(By.linkText(insight.getProperty("InsightEngine"))).click();
		Thread.sleep(1000);
		
		// click on SuperJ App.
		driver.findElement(By.linkText(insight.getProperty("SuperJApp"))).click();
		Thread.sleep(1000);
		
		// switching to other tab.
		 ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		 
	      driver.switchTo().window(tabs.get(1));
	      Thread.sleep(1000); 
	      
	      // Return to main Tab.
	      driver.switchTo().window(tabs.get(0));

	      Thread.sleep(1500);
	      
	   // click on Get Started.
		driver.findElement(By.xpath(insight.getProperty("GetStarted"))).click();
		
		
	}
	
	// Resources screen.
	@Test(priority = 6,retryAnalyzer = Retry.class)
	public void TC_06() throws Exception
	{
		
		driver.findElement(By.linkText(insight.getProperty("Resources"))).click();
		Thread.sleep(1500);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1500);
		
		
		driver.findElement(By.xpath(insight.getProperty("InsightReport1"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		
		
		driver.findElement(By.xpath(insight.getProperty("Bitesizesnippets1"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		
		
		driver.findElement(By.xpath(insight.getProperty("Blogs1"))).click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		
		driver.findElement(By.xpath(insight.getProperty("Casestudy1"))).click(); 
		
		
	}
	
	@Test(priority = 7,retryAnalyzer = Retry.class)
	public void TC_07() throws Exception
	{
	
		driver.findElement(By.linkText(insight.getProperty("Resources"))).click();
		Thread.sleep(1500);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1500);
		
		
		driver.findElement(By.xpath(insight.getProperty("CaseStudyFood&beverages"))).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(insight.getProperty("BlogsBack"))).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(insight.getProperty("CaseStdyFMCG"))).click();
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(insight.getProperty("BlogsBack"))).click();
		Thread.sleep(1000);
		
		
	}
	
	@Test(priority = 8,retryAnalyzer = Retry.class)
	public void TC_08() throws Exception
	{
	
		driver.findElement(By.linkText(insight.getProperty("Resources"))).click();
		Thread.sleep(1500);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(insight.getProperty("Blogs1"))).click();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(insight.getProperty("Blogspart1"))).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(insight.getProperty("BlogsBack"))).click();
		
		
		driver.findElement(By.xpath(insight.getProperty("Blogspart2"))).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(insight.getProperty("BlogsBack"))).click();
		
		
		driver.findElement(By.xpath(insight.getProperty("Blogspart3"))).click();
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(insight.getProperty("BlogsBack"))).click();
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 8, retryAnalyzer = Retry.class,enabled = false)
	public void TC_09() throws Exception {
	    // Navigate to Resources page
	    driver.findElement(By.linkText(insight.getProperty("Resources"))).click();
	    Thread.sleep(1500);

	    // Scroll down to the blog section
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
	    Thread.sleep(1000);

	    // Click on the Blogs section
	    driver.findElement(By.xpath(insight.getProperty("Blogs1"))).click();
	    js.executeScript("window.scrollBy(0,500)");
	    Thread.sleep(1000);

	    // Locate the blog container first
	    WebElement blogContainer = driver.findElement(By.xpath(insight.getProperty("Allblogs")));
	    System.out.println("Blog container found: " + (blogContainer != null));

	    // Locate individual blog elements within the container
	    List<WebElement> blogElements = blogContainer.findElements(By.xpath(".//div[contains(@class, 'blog-post-class')]"));
	    System.out.println("Total number of blogs: " + blogElements.size());

	    // Print titles of each blog
	    for (WebElement blogElement : blogElements) {
	        String blogTitle = blogElement.getText(); // Adjust if title is in a specific child element
	        System.out.println("Blog Title: " + blogTitle);
	    }
	}

// Pricing.
	
	@Test(priority = 10, retryAnalyzer = Retry.class)
	public void TC_10() throws Exception {
	    // Navigate to Pricing page
	    driver.findElement(By.linkText(insight.getProperty("Pricing"))).click();
	    Thread.sleep(1000);

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Scroll to the first pricing element and click
	    js.executeScript("window.scrollBy(0,500)");
	    driver.findElement(By.xpath(insight.getProperty("pricingstarted01"))).click();
	    Thread.sleep(2000);

	    // Verify the sign-up page
	    WebElement signup = driver.findElement(By.xpath(prop.getProperty("Signup01")));
	    String actualElementText = signup.getText();
	    String expectedElementText = "Sign Up";
	    Assert.assertEquals(actualElementText, expectedElementText, "Expected and Actual both are same");
	    
	    driver.navigate().back();
	    Thread.sleep(1000);  // Wait for the page to load completely before interacting with it

	}
	
}



