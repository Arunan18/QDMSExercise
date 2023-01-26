package Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	public static WebDriver driver;
	public static String URL = "http://192.168.1.35:8083/#/login";
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentTest testCase;
	 
@BeforeSuite
	public  void main() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		System.out.println("QDMS");
		ExtentReport();
	}
      
@AfterSuite
public void closeChrome() {
	driver.close();
	extent.flush();
}

public static void ExtentReport() throws IOException {
	extent = new ExtentReports();
	htmlreporter = new ExtentHtmlReporter(
			System.getProperty("user.dir") + "\\src\\test\\java\\reports\\extentreport.html");
	
	extent.attachReporter(htmlreporter);
}


}
