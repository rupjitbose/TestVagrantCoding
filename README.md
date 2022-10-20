The Project framework is created with Maven, TestNG, Java.
The tests can be run through CMD if you have already configured maven in your system if not please follow the link: https://mkyong.com/maven/how-to-install-maven-in-windows/
Once maven setup is done do the following steps to run the tests:
1.Open CMD
2.Navigate to the folder location of the projected you downloaded from github
3.Enter command :  mvn clean
4.Enter command :  mvn compile
5.Enter command :  mvn test -PMovie
This will trigger the tests and once tests are completed a report will be generated in "reports" folder within your project. 

