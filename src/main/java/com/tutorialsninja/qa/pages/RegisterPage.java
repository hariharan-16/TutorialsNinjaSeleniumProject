package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//label[text()='Yes']")
	private WebElement subscribeYesRadioButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarningMessage;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath = "(//input[@class='form-control']/following-sibling::div)[1]")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div[1]")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div[1]")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div[1]")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div[1]")
	private WebElement passwordWarningMessage;
	
	public void enterFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterTelephone(String telephone) {
		telephoneField.sendKeys(telephone);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordField.sendKeys(confirmPassword);
	}
	
	public void clickPrivacyPolicyCheckBox() {
		privacyPolicyCheckBox.click();
	}
	
	public void clickContinue() {
		continueButton.click();
	}
	
	public void clickSubscribeYesButton() {
		subscribeYesRadioButton.click();
	}
	
	public String retriveDuplicateEmailWarningMessage() {
		return duplicateEmailWarningMessage.getText();
	}
	
	public String retrivePrivacyPolicyWarningMessage() {
		return privacyPolicyWarningMessage.getText();
	}
	
	public String retriveFirstNameWarningMessage() {
		return firstNameWarningMessage.getText();
	}
	
	public String retriveLastNameWarningMessage() {
		return lastNameWarningMessage.getText();
	}
	
	public String retriveEmailWarningMessage() {
		return emailWarningMessage.getText();
	}
	
	public String retriveTelephoneWarningMessage() {
		return telephoneWarningMessage.getText();
	}
	
	public String retrivePasswordWarningMessage() {
		return passwordWarningMessage.getText();
	}

}
