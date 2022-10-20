package reusable;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reuse {

	
	WebDriver driver;
	public Reuse(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String wikiUrl() throws IOException {
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\common\\data.properties");
		p.load(fis);
		return p.getProperty("wikiurl");
	}
	
	public String imdbUrl() throws IOException {
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\common\\data.properties");
		p.load(fis);
		return p.getProperty("imdburl");
		}
		
	
	
	
	
	public void waitForWebElementVisible(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void moveToElement(WebElement element) {
		Actions a= new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	
	
}
