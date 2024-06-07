package Baseclass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import Filereadres.proper;
import Testcases.Extentreports;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest extends ExtentReports
{


	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;
	
	public static Properties insight = new Properties();
	public static FileReader pr;
	
	
	
	@BeforeMethod
	public void setup() throws IOException{
		 if (driver==null) {
			FileReader fr = new FileReader("C:\\Users\\Rajes\\eclipse-workspace\\insightengine.in\\src\\test\\java\\Filereadres\\DataFile");
			 prop.load(fr);
			 
			 FileReader pr = new FileReader("C:\\Users\\Rajes\\eclipse-workspace\\insightengine.in\\src\\test\\java\\Filereadres\\insights");
			 insight.load(pr);

			 
	
			 
		 }
			
		 if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup(); // base
				driver = new ChromeDriver(); // base
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.get(prop.getProperty("Website"));
			
		 }	
		 else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
					WebDriverManager.edgedriver().setup(); // base
					driver = new EdgeDriver(); // base
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
					driver.get(prop.getProperty("Website"));
				}
		 
		}
	
	
	
		
		
		@AfterMethod
		public void closeser () {
			
			driver.quit();
			
			System.out.println("Basetest.close");
			
		}
		
}
