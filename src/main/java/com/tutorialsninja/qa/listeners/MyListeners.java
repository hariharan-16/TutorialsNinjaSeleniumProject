package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.Utilities;

public class MyListeners implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;
	String testName;

	@Override
	public void onStart(ITestContext context) {
		report = ExtentReporter.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		test = report.createTest(testName);
		test.info(testName+" exectuion started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(testName+" executed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		String screenshotLocation = Utilities.getScreenshot(driver, testName);
		test.addScreenCaptureFromPath(screenshotLocation);
		test.info(result.getThrowable());
		test.fail(testName+" execution failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.info(result.getThrowable());
		test.skip(testName+" execution skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		test.info("Execution finished");
		report.flush();
		
//		String reportPath = System.getProperty("user.dir")+"\\test-output\\extentReports\\report.html";
//		File file = new File(reportPath);
//		try {
//			Desktop.getDesktop().browse(file.toURI());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
}
