package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath = "(//div[@id='content']//p)[2]")
	private WebElement noProductMessage;
	
	public boolean validHPProductDisplayed() {
		return validHPProduct.isDisplayed();
	}
	
	public String retriveNoProductMessage() {
		return noProductMessage.getText();
	}
	
}
