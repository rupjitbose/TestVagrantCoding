package common;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

public static ExtentReports getReportObject() {
	
	SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	String rep=sdf3.format(timestamp).toString().replace(":", "-");
	
	
	String path=System.getProperty("user.dir")+"\\reports\\"+rep+".html";
	
	ExtentSparkReporter spark=new ExtentSparkReporter(path);
	spark.config().setTheme(Theme.DARK);
	spark.config().setDocumentTitle("Movie Details Check");
	spark.config().setReportName("Test Report");
	ExtentReports extent = new ExtentReports();
	extent.setSystemInfo("Tester", "Rupjit");
	extent.attachReporter(spark);
	return extent;
	

	}

}
