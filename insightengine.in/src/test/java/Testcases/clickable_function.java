package Testcases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Baseclass.Basetest;

public class clickable_function  extends Basetest {

	
	@Test(priority = 1,retryAnalyzer = Retry.class)
	public void TC_01() throws Exception
	{
			
		// scroll to Get started.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(1500);
		
		// Click on Get started.
		driver.findElement(By.xpath(insight.getProperty("Getstarteds"))).click();
		Thread.sleep(1500);
		
		// Get started close.
		//driver.findElement(By.cssSelector(prop.getProperty("Getstartedclose"))).click();	
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
	
	
	@Test(priority = 3,retryAnalyzer = Retry.class)
	public void TC_03() throws Exception
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,3550)");
		Thread.sleep(1000);
		driver.findElement(By.xpath(insight.getProperty("Solution1"))).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(insight.getProperty("Solution2"))).click();
		driver.findElement(By.xpath(insight.getProperty("Solution3"))).click();
		driver.findElement(By.xpath(insight.getProperty("Solution4"))).click();
		driver.findElement(By.xpath(insight.getProperty("Solution5"))).click();
		
	}
	
	@Test(priority = 4,retryAnalyzer = Retry.class)
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
	
	
	
	
}
