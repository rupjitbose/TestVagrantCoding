package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusable.Reuse;

public class WikiPage extends Reuse{
	
	WebDriver driver;
	public WikiPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="searchInput")
	WebElement wikiSearchBox;
	@FindBy(id="searchButton")
	WebElement wikiSearchButton;
	@FindBy(xpath="//th[text()='Country']/following-sibling::td")
	WebElement wikiMovieDetails;
	@FindBy(xpath="//div[contains(text(),'Release date')]/parent::th/following-sibling::td//li")
	List<WebElement> wikiReleaseRaw;
	@FindBy(xpath="//th[text()='Country']/following-sibling::td")
	WebElement wikiCountry;
	
	

	public void goToWiki() {
		driver.get("https://en.wikipedia.org/");
	}
public void wikiSearchMovie(String movie) {
		wikiSearchBox.sendKeys(movie);
		wikiSearchButton.click();
	}

public void goToMovieDetails() {
	moveToElement(wikiMovieDetails);
	}

public List<String> wikiGetReleaseDate() {
	List<String> wikiReleaseDateList=new ArrayList<String>();
	for(WebElement e: wikiReleaseRaw) {
		String date1=e.getText().trim().split(" ")[0];
		String month1=e.getText().trim().split(" ")[1];
		String year1=e.getText().trim().split(" ")[2];
		String wikiReleaseDate=date1+" "+month1+" "+year1;
		wikiReleaseDateList.add(wikiReleaseDate);
	}
	for(String s: wikiReleaseDateList) {
		System.out.println(s);
	}
	
	return wikiReleaseDateList;
	
}

public String wikiGetCountry() {
	String wikiOriginCountry=wikiCountry.getText().trim();
	System.out.println(wikiOriginCountry);
	return wikiOriginCountry;
}


}
