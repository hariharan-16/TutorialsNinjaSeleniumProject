package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccount;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchField;
	
	@FindBy(xpath = "//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	public void clickOnMyAccount() {
		myAccount.click();
	}
	
	public void clickOnLoginOption() {
		loginOption.click();
	}

	public void clickOnRegisterOption() {
		registerOption.click();
	}
	
	public void enterOnSearchField(String text) {
		searchField.sendKeys(text);
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public void navigateToLoginPage() {
		myAccount.click();
		loginOption.click();
	}
	
	public void navigateToRegisterPage() {
		myAccount.click();
		registerOption.click();
	}
}
