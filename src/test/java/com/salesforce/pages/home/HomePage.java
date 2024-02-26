package com.salesforce.pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.pages.base.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath="//span[@id='userNavLabel']") WebElement userLoginNameElement;
	@FindBy(id="userNav-arrow") WebElement userNavArrowElement;
	@FindBy(linkText="Logout") WebElement logOutElement;


	public HomePage(WebDriver driver) {

		super(driver);
	}

	public String getTitleOfThePage() {
		
		return getPageTitle(driver, "Home Page");
	}
	
	
	
	public String getTextFromElement()
	{
		
		return getTextFromElement(userLoginNameElement,"Logged UserName");
	}
	
	public WebDriver clickUserNavArrowElement() {
		clickElement(userNavArrowElement,"Arrow button");
		return driver;
		
	}
	 
	public WebDriver clickOnLogOut() {
		clickElement(logOutElement,"LogOut link");
		return driver;
		
	}

}
