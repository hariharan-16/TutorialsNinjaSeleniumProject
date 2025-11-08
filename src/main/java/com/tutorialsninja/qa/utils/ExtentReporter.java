package com.tutorialsninja.qa.utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	public static ExtentReports generateExtentReport(){
		
		Properties prop = new Properties();
		
		try {		
			FileInputStream file = new FileInputStream("src/main/java/com/tutorialsninja/qa/config/config.properties");
			prop.load(file);	
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output/extentReports/report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Tutorialsninja test result");
		spark.config().setDocumentTitle("TN automation result");
		spark.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		
		report.setSystemInfo("App URL", prop.getProperty("url"));
		report.setSystemInfo("Browser Name", prop.getProperty("browser"));
		report.setSystemInfo("Email", prop.getProperty("validEmail"));
		report.setSystemInfo("Password", prop.getProperty("validPassword"));
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
		report.setSystemInfo("Username", System.getProperty("user.name"));
		report.setSystemInfo("Java version", System.getProperty("java.version"));
		
		return report;
	}
}
