package com.salesforce.pages.ForgotYourPassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class ForgotYourPasswordPage extends BasePage{
	
	@FindBy(id="un") WebElement usernameElement;
	@FindBy(id="continue") WebElement btnContinueElement;

	
	public ForgotYourPasswordPage(WebDriver driver) {

		super(driver);
	}
	
	public void enterUserName(String data) {

		enterText(usernameElement, data, "Username textbox");

	}

	public WebDriver clickContinueButton() {
		clickElement(btnContinueElement, "Continue button");
		return driver;

	}
	
	
}
