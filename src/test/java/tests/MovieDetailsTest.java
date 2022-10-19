package tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import common.Retry;
import pages.ImdbPage;
import pages.WikiPage;


public class MovieDetailsTest extends Base{
	
	@Test(dataProvider="getdata",retryAnalyzer=Retry.class)
	public void movieReleaseDateCheck(String movie) throws Exception {
		
		imdbPages.goToImdb();
		imdbPages.imdbSearchMovie(movie);
		WikiPage wikiPages=imdbPages.goToMovieDetails();
		String imdbReleaseDate=imdbPages.imdbGetReleaseDate();
		
		
		wikiPages.goToWiki();
		wikiPages.wikiSearchMovie(movie);
		wikiPages.goToMovieDetails();
		List<String>wikiReleaseDateList=wikiPages.wikiGetReleaseDate();
		
		
		Assert.assertTrue(wikiReleaseDateList.contains(imdbReleaseDate));
		
	}
	
	@Test(dataProvider="getdata",retryAnalyzer=Retry.class)
	public void movieCountryCheck(String movie) throws Exception {
		
		imdbPages.goToImdb();
		imdbPages.imdbSearchMovie(movie);
		WikiPage wikiPages=imdbPages.goToMovieDetails();
		String imdbCountry=imdbPages.imdbGetCountry();
		
		
		wikiPages.goToWiki();
		wikiPages.wikiSearchMovie(movie);
		wikiPages.goToMovieDetails();
		String wikiCountry=wikiPages.wikiGetCountry();
		
		
		Assert.assertTrue(imdbCountry.equalsIgnoreCase(wikiCountry));
		
	}
	
	
	@DataProvider
	public Object[] getdata() {
		List<String> data=new ArrayList<String>();
		data.add("Pushpa: The Rise - Part 1");
		//K.G.F: Chapter 1
		//Pushpa: The Rise - Part 1
		
		return new Object[] {data.get(0)};
		
	}

}
