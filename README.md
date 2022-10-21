The Project framework is created with Maven, TestNG, Java.
The tests can be run through CMD if you have already configured maven in your system if not please follow the link: https://mkyong.com/maven/how-to-install-maven-in-windows/
Once maven setup is done do the following steps to run the tests:
1.Open CMD
2.Navigate to the folder location of the projected you downloaded from github
3.Enter command :  mvn clean
4.Enter command :  mvn compile
5.Enter command :  mvn test -PMovie
6.Enter command :  mvn test -PMovie -Dbrowser=<browser name>    //edge or chrome or firefox// this command will run the tests in browser of your choice.
This will trigger the tests and once tests are completed a report will be generated in "reports" folder within your project. 
The suite is designed in such a way if there is any unexpected failure of any testcase that testcase will run one additional time to make sure that the failure or the issue was a temporary issue or it is a proper failure. In case of testcase failure a screenshot will be attached to the generated report 

Project Folder Structure:
src/main/java/common:
1.ExtentReport.java --> This used to create the the ExtentReport reports.
2.Retry.java -->  This used to rerun the testcase in case of a failure.
3.data.properties --> If the project is ran from IDE we can change the browser value in this file to run the test in different browser eg. chrome/edge/firefox.
wikiurl to contain wikipedia url.
imdburl to contail imdb url.

src/main/java/pages:
Here we have the page objects along with web element locators used in different java classes one for imdb and one for wikipedia.

src/test/java/base:
Base.java --> We have the Base class here which has the functions like triggering of driver and closing the driver.
Listener.java --> Contains testng listeners.

src/test/java/tests:
MovieDetailsTest.java --> contains the testcases for movie details checking 1.movieReleaseDateCheck 2.movieCountryCheck.
Within the test you will find @DataProvider.Wehre you can change the movie name and run the test for differnt movie. For example do the below change to check for "K.G.F: Chapter 1"
String movie="K.G.F: Chapter 1";

run using testNG from IDE:
1.Open project in IDE
2.Find the "testng.xml" right click and run as testNG Suite




