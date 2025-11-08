package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class Search extends Base{
	
	public WebDriver driver;
	HomePage hp;
	SearchPage sp;

	public Search() {
		super();
	}
	
	@Test(priority = 1)
	public void searchWithValidProduct() {
		hp.enterOnSearchField(dataProp.getProperty("validProduct"));
		hp.clickSearchButton();
		Assert.assertTrue(sp.validHPProductDisplayed(), "Product not displayed");
	}
	
	@Test(priority = 2)
	public void searchWithInvalidProduct() {
		hp.enterOnSearchField(dataProp.getProperty("invalidProduct"));
		hp.clickSearchButton();
		String message = sp.retriveNoProductMessage();
		Assert.assertEquals(message, dataProp.getProperty("noProductMessage"), "No product message not displayed");
	}
	
	@Test(priority = 3)
	public void searchWithoutProduct() {
		hp.clickSearchButton();
		String message = sp.retriveNoProductMessage();
		Assert.assertEquals(message, dataProp.getProperty("noProductMessage"), "No product message not displayed");
	}
	
	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenAppURL(prop.getProperty("browser"));
		hp = new HomePage(driver);
		sp = new SearchPage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
