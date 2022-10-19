package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ImdbPage;
import pages.WikiPage;

public class Base {

	
	public WebDriver driver;
	
	public ImdbPage imdbPages;
	
	public WebDriver startTest() throws IOException {
		
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\common\\data.properties");
		p.load(fis);
			
		String s=System.getProperty("browser")!=null ?System.getProperty("browser"):p.getProperty("browser");
	
		
		if(s.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(s.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}
		else if(s.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver", "C:\\Users\\Rupjit\\eclipse-workspace\\edgedriver_win64\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
}
	
	public String takeScreenShot(String tcname, WebDriver driver) throws IOException {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\reports\\screenshot\\"+tcname+".png"));
		return System.getProperty("user.dir")+"\\reports\\"+tcname+".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	public ImdbPage launchImdbApplication() throws IOException {
		driver=startTest();
		imdbPages=new ImdbPage(driver);
		imdbPages.goToImdb();
		return imdbPages;
	}

	@AfterMethod(alwaysRun=true)
	public void closeWindow() {
		driver.quit();
	}

	
	
}
