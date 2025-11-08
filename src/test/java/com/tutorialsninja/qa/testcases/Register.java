package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends Base{
	
	public WebDriver driver;
	RegisterPage rp;
	AccountSuccessPage asp;
	
	public Register() {
		super();
	}
	
	@Test(priority = 1)
	public void verifyAccountWithMandatoryField() {
		rp.enterFirstName(dataProp.getProperty("firstName"));
		rp.enterLastName(dataProp.getProperty("lastName"));
		rp.enterEmail(Utilities.generateEmailWithTimestamp());
		rp.enterTelephone(dataProp.getProperty("telephone"));
		rp.enterPassword(prop.getProperty("validPassword"));
		rp.enterConfirmPassword(prop.getProperty("validPassword"));
		rp.clickPrivacyPolicyCheckBox();
		rp.clickContinue();
		
		String message = asp.retriveAccountCreationSuccessMessage();
		Assert.assertEquals(message, dataProp.getProperty("accountCreationSuccessMessage"), "Expected success message is not displayed");
	}
	
	@Test(priority = 2)
	public void verifyAccountWithAllFields() {
		rp.enterFirstName(dataProp.getProperty("firstName"));
		rp.enterLastName(dataProp.getProperty("lastName"));
		rp.enterEmail(Utilities.generateEmailWithTimestamp());
		rp.enterTelephone(dataProp.getProperty("telephone"));
		rp.enterPassword(prop.getProperty("validPassword"));
		rp.enterConfirmPassword(prop.getProperty("validPassword"));
		rp.clickSubscribeYesButton();
		rp.clickPrivacyPolicyCheckBox();
		rp.clickContinue();
		
		String message = asp.retriveAccountCreationSuccessMessage();
		Assert.assertEquals(message, dataProp.getProperty("accountCreationSuccessMessage"), "Expected success message is not displayed");
	}
	
	@Test(priority = 3)
	public void verifyAccountWithExistingMail() {	
		rp.enterFirstName(dataProp.getProperty("firstName"));
		rp.enterLastName(dataProp.getProperty("lastName"));
		rp.enterEmail(prop.getProperty("validEmail"));
		rp.enterTelephone(dataProp.getProperty("telephone"));
		rp.enterPassword(prop.getProperty("validPassword"));
		rp.enterConfirmPassword(prop.getProperty("validPassword"));
		rp.clickSubscribeYesButton();
		rp.clickPrivacyPolicyCheckBox();
		rp.clickContinue();
		
		String message = rp.retriveDuplicateEmailWarningMessage();
		Assert.assertEquals(message, dataProp.getProperty("duplicateEmailWarning"), "Expected Duplicate Mail message is not displayed");
	}
	
	@Test(priority = 4)
	public void verifyAccountWithoutMandatoryFields() {
		rp.clickContinue();
		
		String actualPrivacyPolicyWarning = rp.retrivePrivacyPolicyWarningMessage();
		Assert.assertTrue(actualPrivacyPolicyWarning.equals(dataProp.getProperty("privacyPolicyWarning")), "Privacy policy warning not displayed");
		
		String actualFirstNameWarning = rp.retriveFirstNameWarningMessage();
		Assert.assertTrue(actualFirstNameWarning.equals(dataProp.getProperty("firstNameWarning")), "First name warning not displayed");
		
		String actualLastNameWarning = rp.retriveLastNameWarningMessage();
		Assert.assertTrue(actualLastNameWarning.equals(dataProp.getProperty("lastNameWarning")), "Lsst name warning not displayed");
		
		String actualEmailWarning = rp.retriveEmailWarningMessage();
		Assert.assertTrue(actualEmailWarning.equals(dataProp.getProperty("emailWarning")), "E-Mail warning not displayed");
		
		String actualTelephoneWarning = rp.retriveTelephoneWarningMessage();
		Assert.assertTrue(actualTelephoneWarning.equals(dataProp.getProperty("telephoneWarning")), "Telephone warning not displayed");
		
		String actualPasswordWarning = rp.retrivePasswordWarningMessage();
		Assert.assertTrue(actualPasswordWarning.equals(dataProp.getProperty("passwordWarning")), "Password warning not displayed");
	}
	
	@BeforeMethod
	public void setUp() {
		driver = initializeBrowserAndOpenAppURL(prop.getProperty("browser"));
		
		HomePage hp = new HomePage(driver);
		rp = new RegisterPage(driver);
		asp = new AccountSuccessPage(driver);
		hp.navigateToRegisterPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
