package com.salesforce.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(id = "username")
	WebElement usernameElement;
	@FindBy(id = "password")
	WebElement passwordElement;
	@FindBy(id = "Login")
	WebElement loginButtonElement;
	@FindBy(id = "error")
	WebElement errorMessageElement;
	@FindBy(id = "rememberUn")
	WebElement chkbxRememberMeElement;
	
	@FindBy(xpath="//a[@id='forgot_password_link']")
	WebElement forgotPwdElement;


	public LoginPage(WebDriver driver) {

		super(driver);
	}

	public void enterUserName(String data) {

		enterText(usernameElement, data, "Username textbox");

	}

	public void enterPassword(String data) {
		enterText(passwordElement, data, "password textbox");
	}

	public WebDriver clickLoginButton() {
		clickElement(loginButtonElement, "login button");
		return driver;

	}
	public WebDriver clickOnLink() {
		clickElement(forgotPwdElement, "Forgot Your Password?");
		return driver;

	}

	
	public String getTitleOfThePage() {
		
		return getPageTitle(driver, "Login Page");
	}

	public String getTextFromElement() {

		return getTextFromElement(errorMessageElement, "Error Message");
	}

	public void selectCheckBox() {

		checkElement(chkbxRememberMeElement, "RememberMe");

	}

	public boolean isSelectedCheckBox() {

		return isSelected(chkbxRememberMeElement, "RememberMe");

	}

	public String getValueFrmTextbox() {

		return getAttributeValue(usernameElement, "Username textbox");

	}

}
