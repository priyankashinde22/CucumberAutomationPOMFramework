package com.salesforce.pages.ForgotYourPassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class CheckYourEmailPage extends BasePage {
	
	@FindBy(xpath="(//p)[1]") WebElement paragraphElement;
	
	public CheckYourEmailPage(WebDriver driver) {

		super(driver);
	}
	
	public String getTitleOfThePage() {

		return getPageTitle(driver, "Check Your Page");
	}
	
	public String getTextFromElement() {

		return getTextFromElement(paragraphElement, "Email Sent Message");
	}
	

}
