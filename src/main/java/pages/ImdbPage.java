package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import reusable.Reuse;




public class ImdbPage extends Reuse{

	
	WebDriver driver;
	public ImdbPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="suggestion-search")
	WebElement imdbSearch;
	@FindBy(xpath="//li[@data-testid='title-details-origin']")
	WebElement imdbMovieDetails;
	@FindBy(xpath="//a[text()='Release date']/following-sibling::div//a")
	WebElement imdbReleaseDate;
	@FindBy(xpath = "//a[contains(@href, 'country')]")
	WebElement imdbCountry;



	
	public void goToImdb() throws IOException {
		//driver.get("https://www.imdb.com/");
		driver.get(imdbUrl());
	}
	
	
	public void imdbSearchMovie(String movie) {
		
		imdbSearch.sendKeys(movie);
		WebElement movieResult=driver.findElement(By.xpath("//div[text()='"+movie+"']/ancestor::a"));
		waitForWebElementVisible(movieResult);
		movieResult.click();
	}
	
	public WikiPage goToMovieDetails() {
		moveToElement(imdbMovieDetails);
		WikiPage wikiPages=new WikiPage(driver);
		return wikiPages;
	}
	
	public String imdbGetReleaseDate() {
		String imdbReleaseRaw=imdbReleaseDate.getText().replace(",", "");
		String month=imdbReleaseRaw.split(" ")[0];
		String date=imdbReleaseRaw.split(" ")[1];
		String year=imdbReleaseRaw.split(" ")[2];
		String imdbReleaseDate=date+" "+month+" "+year;
		System.out.println(imdbReleaseDate);
		return imdbReleaseDate;
	}
	
	
	public String imdbGetCountry() {
		String imdbOriginCountry=imdbCountry.getText().trim();
		System.out.println(imdbOriginCountry);
		return imdbOriginCountry;
	}
	
}
