package Tryagin.target.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Tryagain.target.HomepageTest;

public class BaseTest {

	 public Properties prop;
	 public WebDriver driver;
	 public HomepageTest homescreen;

	 public static ExtentSparkReporter extentSparkReporter;
		public static ExtentReports extentReports;
		public static ExtentTest extentTest;
		  
	 
	    

	public WebDriver initialise() throws IOException {
		/*
		 * prop = new Properties(); FileInputStream fis = new FileInputStream(
		 * "C:\\Users\\theer\\eclipse-workspace-Shivani\\demoproject\\src\\main\\java\\target\\demoproject\\resources\\Data.properties"
		 * ); prop.load(fis);
		 * 
		 * String Browser=prop.getProperty("browser"); if(Browser.contains("chrome")) {
		 */      
		driver=new ChromeDriver();
		
		
	//	driver.manage().window().setSize(new Dimension(1440,900));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		return driver;
	}
	 
	 @BeforeTest
	 public HomepageTest LaunchApp() throws IOException
	 {
		 driver=initialise();
		 homescreen=new HomepageTest(driver);
		 homescreen.LandOn();	
		 return homescreen;
	 }
	 
	 
	 public String getscreenshot(String testcasename , WebDriver driver) throws IOException
	 {
		 TakesScreenshot ts= ((TakesScreenshot)driver);
		 File src=ts.getScreenshotAs(OutputType.FILE);
		 File dest=new File("C:\\Users\\theer\\eclipse-workspace-Shivani\\demoproject\\"+testcasename+".png");
		 FileHandler.copy(src, dest);
		 return "C:\\Users\\theer\\eclipse-workspace-Shivani\\demoproject\\"+testcasename+".png";
	 }	 
}
