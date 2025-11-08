package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Login extends Base{
	
	public WebDriver driver;
	LoginPage lp;
	AccountPage ap;
	
	public Login() {
		super();
	}

	@Test(priority = 1, dataProvider = "validCredentialSupplier")
	public void loginWithValidCredentials(String email, String password) {
		lp.enterCredentialsAndClickLogin(email, password);
		Assert.assertTrue(ap.getDisplayStatusOfAccountInfo(), "Edit your account information not displayed");
	}
	@DataProvider(name = "validCredentialSupplier")
	public Object[][] supplyData() {
		Object [][] data = Utilities.getTestDataFromExcel("Sheet1");
		return data;
	}
	
	@Test(priority = 2)
	public void loginWithInvalidCredentials() {
		lp.enterEmail(Utilities.generateEmailWithTimestamp());
		lp.enterPassword(dataProp.getProperty("invalidPassword"));
		lp.clickLoginButton();
		
		String message = lp.retriveEmailPasswordWarningMessage();
		Assert.assertTrue(message.contains(dataProp.getProperty("expectedWarningMessage")), "Expected warning message not displayed");
	}
	
	@Test(priority = 3)
	public void loginWithInvalidEmailAndValidPassword() {
		lp.enterEmail(Utilities.generateEmailWithTimestamp());
		lp.enterPassword(prop.getProperty("validPasswords"));
		lp.clickLoginButton();
		
		String message = lp.retriveEmailPasswordWarningMessage();
		Assert.assertTrue(message.contains(dataProp.getProperty("expectedWarningMessage")), "Expected warning message not displayed");
	}
	
	@Test(priority = 4)
	public void loginWithValidEmailAndInvalidPassword() {
		lp.enterEmail(prop.getProperty("validEmail"));
		lp.enterPassword(dataProp.getProperty("invalidPassword"));
		lp.clickLoginButton();
		
		String message = lp.retriveEmailPasswordWarningMessage();
		Assert.assertTrue(message.contains(dataProp.getProperty("expectedWarningMessage")), "Expected warning message not displayed");
	}
	
	@Test(priority = 5)
	public void loginWithoutCredentials() {
		lp.clickLoginButton();
		
		String message = lp.retriveEmailPasswordWarningMessage();
		Assert.assertTrue(message.contains(dataProp.getProperty("expectedWarningMessage")), "Expected warning message not displayed");
	}
	
	@BeforeMethod
	public void setUp(){
		driver = initializeBrowserAndOpenAppURL(prop.getProperty("browser"));
		
		HomePage hp = new HomePage(driver);
		lp = new LoginPage(driver);
		ap = new AccountPage(driver);
		hp.navigateToLoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
