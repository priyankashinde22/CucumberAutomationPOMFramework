package com.salesforce.pages.base;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.salesforce.utilities.Log4JUtility;



public class BasePage  {
	
	protected  WebDriver driver;
	protected  WebDriverWait wait;
	protected Log4JUtility logObject=Log4JUtility.getInstance();
	protected Logger log;
	
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		log=logObject.getLogger();
		
	}
	

	
	
	public void enterText(WebElement ele, String data, String objectName) {
		if (ele.isDisplayed()) {
			ele.clear();
			ele.sendKeys(data);
			log.info("username data is entered in " + objectName);
			//extentReport.logTestInfo("username data is entered in " + objectName);
		
		}
		else
		{
			log.error(objectName + " element is not displayed");
		}
	}
	
	public String getAttributeValue(WebElement ele, String objectName) {
		
		return ele.getAttribute("value");
		
		
	}

	public void clickElement(WebElement ele, String objectName) {
		if (ele.isEnabled()) {
			ele.click();
			log.info(objectName + "element is clicked");
			//extentReport.logTestInfo(objectName + "element is clicked");
			

		} else {
			log.error(objectName + " element is not enabled");

		}
	}

	public void checkElement(WebElement ele, String objectName) {
		if (!ele.isSelected()) {
			ele.click();
			log.info(objectName + "element is cheked");
			//extentReport.logTestInfo(objectName + "element is checked");

		} else {
			log.error(objectName + " element is already selected/cheked");

		}
	}
	
	public boolean isSelected(WebElement ele, String objectName) {
		if (ele.isSelected()) {
			
			log.info(objectName + "element is cheked");
		//	extentReport.logTestInfo(objectName + "element is checked");
			return true;

		} else {
			
			log.error(objectName + " element is not selected/cheked");
			
			return false;

		}
	}
	
	

	public String getTextFromElement(WebElement ele, String objectName) {
		String data = ele.getText();
		log.info("text is extracted from " + objectName);
		//extentReport.logTestInfo("text is extracted from " + objectName);
		return data;
	}

	public void clearTextFromElement(WebElement ele, String objectName) {
		ele.clear();
		log.info("text is cleared " + objectName);
		//extentReport.logTestInfo("text is cleared " + objectName);
	}
	
	public String getPageTitle(WebDriver driver, String objectName) {
		String title = driver.getTitle();
		log.info(objectName + "title=" + title);
	//	extentReport.logTestInfo(objectName + "title=" + title);
		return title;

	}


	public String getPageTitle() 
	{
		return driver.getTitle();
	}

	
	public void selectDropdownByValue(WebElement ele, String value, String objectName) {
		Select select = new Select(ele);
		select.selectByValue(value);
		log.info(objectName);
		//extentReport.logTestInfo(objectName);
		

	}

	public void selectDropdownByVisibleText(WebElement ele, String text, String objectName) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
		log.info(objectName);
		//extentReport.logTestInfo(objectName);

	}
	public boolean selectOptionFromDropdownByVisibleText(WebElement ele, String text, String objectName) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
		log.info(objectName);
	//	extentReport.logTestInfo(objectName);
		return true;

	}
	
	public void checkOptionFromDropdown(WebElement ele, String value, String objectName) {
		Select select = new Select(ele);
		List<WebElement> options = select.getOptions();

		for (WebElement optionele : options) {
			String option = optionele.getText();
			log.info(option);
			if (option.equals(value)) {
				log.info("Option is available");
				//extentReport.logTestInfo("Option is available");
				break;
			} else {
				log.error("Option is not available");
				break;
			}

		}

	}

	public boolean verifyOptionFromDropdown(WebElement ele, String value, String objectName) {
		Select select = new Select(ele);
		List<WebElement> options = select.getOptions();
		boolean flag = false;
		for (WebElement optionele : options) {

			if (optionele.getText().equals(value)) {

				flag = true;

			}

		}
		return flag;

	}

	public boolean verifyOptionFromDropdownIsDisplayed(WebElement ele, String value, String objectName) {
		Select select = new Select(ele);
		List<WebElement> options = select.getOptions();
		boolean flag = false;
		for (WebElement optionele : options) {
			
			if (optionele.isSelected())
			{
				if(optionele.getText().equals(value))
				flag = true;

			}

		}
		return flag;

	}
	
	
	
	public boolean checkSelectDropdownList(WebElement ele, String expList[], String objectName) {

		Select drpdwnView = new Select(ele);
		List<WebElement> drpdwnList = drpdwnView.getOptions();
		boolean match = false;
		for (WebElement view : drpdwnList) {

			for (int i = 0; i < drpdwnList.size(); i++) {

				if (expList[i].equals(view.getText())) {
					match = true;
				}

			}

		}
		return match;

	}
	
	public void selectOptionFromDropdownList(List<WebElement> list, String text, String objectName) {
		
	
		for (WebElement ele : list) {

			for (int i = 0; i < list.size(); i++) {

				if (text.equals(ele.getText())) {
					
					clickElement(ele, objectName);
					
				}

			}

		}
	
		

	}
	
	
	
	//;;;

	public boolean checkDropdownList(List<WebElement> list, String expList[], String objectName) {

	
		boolean match = false;
		for (WebElement ele : list) {

			for (int i = 0; i < list.size(); i++) {

				if (expList[i].equals(ele.getText())) {
					match = true;
				}

			}

		}
		return match;

	}
	
	public boolean isDisplayDropDownList(List<WebElement> list, String expList[], String objectName) {

		
		boolean match = false;
		
		for (WebElement ele : list) {

			if (ele.isDisplayed())
			{

				for (int i = 0; i < expList.length; i++) {

					if (expList[i].equals(ele.getText())) {
						match = true;
					}

				}
			}

		}
		return match;

	}
	
	public String switchToWindow(WebDriver driver,String objectName) {
		
		String parent = driver.getWindowHandle();
		log.info(parent);
		Set<String> s = driver.getWindowHandles();
		String actTitle=null;

		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				
				 actTitle = driver.switchTo().window(child_window).getTitle();

				driver.close();
			}

		}
		driver.switchTo().window(parent);
		return actTitle;
		
	}

	public Alert switchToAlert(WebDriver driver, String objectName) {
		Alert al = driver.switchTo().alert();
		log.info(objectName);
		//extentReport.logTestInfo(objectName);

		return al;

	}

	public String getTextFromAlert(WebDriver driver, String objectName) {
		Alert alert = switchToAlert(driver, objectName);
		String actualError = alert.getText();
		log.info("Getting text from alert" + actualError);
		//extentReport.logTestInfo("Getting text from alert" + actualError);
		acceptAlert(driver, objectName);
		return actualError;

	}

	public void acceptAlert(WebDriver driver, String objectName) {
		Alert alert = switchToAlert(driver, objectName);
		alert.accept();

	}

	public void dismissAlert(WebDriver driver, String objectName) {
		Alert alert = switchToAlert(driver, objectName);
		alert.dismiss();

	}
	
	

	

}
