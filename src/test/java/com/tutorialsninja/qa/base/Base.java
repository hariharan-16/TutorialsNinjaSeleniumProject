package com.tutorialsninja.qa.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop, dataProp;
	
	public Base(){
		prop = new Properties();
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/tutorialsninja/qa/config/config.properties");
			prop.load(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dataProp = new Properties();
		try {
			FileInputStream file = new FileInputStream("src/main/java/com/tutorialsninja/qa/testdata/testdata.properties");
			dataProp.load(file);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndOpenAppURL(String browserName) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");               // run in new headless mode
		options.addArguments("--no-sandbox");                 // required for Jenkins and Docker
		options.addArguments("--disable-dev-shm-usage");      // avoid /dev/shm issues
		options.addArguments("--disable-gpu");                // stabilize headless mode
		options.addArguments("--remote-allow-origins=*");     // prevent origin errors
		options.addArguments("--window-size=1920,1080");      // ensure consistent layout
		options.addArguments("--start-maximized");            // optional but helpful
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
