package com.salesforce.steps;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.salesforce.utilities.PropertiesUtility;
import com.salesforce.pages.ForgotYourPassword.CheckYourEmailPage;
import com.salesforce.pages.ForgotYourPassword.ForgotYourPasswordPage;
import com.salesforce.pages.home.HomePage;
import com.salesforce.pages.login.LoginPage;
import com.salesforce.utilities.Log4JUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SFDCLoginStepDef {
	
	protected static Logger log;
	public  WebDriver driver;
	protected static Log4JUtility logObject=Log4JUtility.getInstance();
	LoginPage login;
	HomePage home;
	ForgotYourPasswordPage forgotpwd;
	CheckYourEmailPage chkemail;
	
	public  void launchBrowser(String browserName) {
		switch(browserName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
			break;
		case "chrome":
		 WebDriverManager.chromedriver().setup();
		
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			break;
		}
		System.out.println(browserName+" browser opened");
	}
	
	public  void goToUrl(String url) {
		driver.get(url);
		log.info(url+ "is entered");
	}

	public  void closeBrowser() {
		driver.close();
		log.info("current browser closed");
	}
	
	@BeforeAll
	public static void setUpBeforeAllScenarios() {
		log=logObject.getLogger();
	}
	@Before
	public void setUpEachScenario() {
		
		launchBrowser("chrome");
		
	}
	@After
	public void tearDown() {
		closeBrowser();
	}
	@AfterStep
	public void after_each_step(Scenario sc) {
		if(sc.isFailed()){
			
		}
	}
	
	@Given("user open salesforce application")
	public void user_open_salesforce_application() {
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("salesforceapp");
		String url= appProp.getProperty("url");
		goToUrl(url);
		System.out.println("driver in baseTest="+driver);
		
	}

	@When("user on {string}")
	public void user_on(String page) {
		if(page.equalsIgnoreCase("loginpage"))
	    	login=new LoginPage(driver);
	    else if(page.equalsIgnoreCase("homepage"))
	    	home=new HomePage(driver);
	    else if(page.equalsIgnoreCase("ForgotYourPasswordPage"))
	    	forgotpwd = new ForgotYourPasswordPage(driver);
	    else if(page.equalsIgnoreCase("CheckYourEmailPage"))
	    	chkemail = new CheckYourEmailPage(driver);
	    	
		
	}

	@When("user enter valid username as {string}")
	public void user_enter_valid_username_as(String username) {
		login.enterUserName(username);
		
		
	}

	@When("user clear and enter the password field as {string}")
	public void user_clear_and_enter_the_password_field_as(String password) {
		login.enterPassword(password);
	}

	@When("user click on the Login button")
	public void user_click_on_the_login_button() {
	    driver=login.clickLoginButton();
		
	}
	
	@Then("Verify we can see the error message {string}")
	public void verify_we_can_see_the_error_message(String expErrMsg) {
		String actErrMsg = login.getTextFromElement();
		Assert.assertEquals(actErrMsg, expErrMsg);
	   
	}
	
	@When("user enter valid password as {string}")
	public void user_enter_valid_password_as(String password) {
	    login.enterPassword(password);
	}

	@Then("user should see the Home Page {string};")
	public void user_should_see_the_home_page(String expHomePageTitle) {
		String actHomePageTitle = home.getPageTitle();
		Assert.assertEquals(actHomePageTitle, expHomePageTitle);
		
	}
	
	@When("user selet the remember user name check box")
	public void user_selet_the_remember_user_name_check_box() {
		login.selectCheckBox();
		
	   
	}

	@When("user Click on user menu drop down")
	public void user_click_on_user_menu_drop_down() {
		home.clickUserNavArrowElement();
	   
	}

	@When("user Select log out link")
	public void user_select_log_out_link() {
		driver=home.clickOnLogOut();
	    
	}

	@Then("Verify user should see username populated in textbox and remember user name chekbox checked")
	public void verify_user_should_see_username_populated_in_textbox_and_remember_user_name_chekbox_checked() throws InterruptedException {
		String expTitle = "Login | Salesforce";
		Thread.sleep(3000);
		String actTitle = login.getPageTitle();
		
		log.info(actTitle);
		Assert.assertEquals(actTitle, expTitle);
		
		Thread.sleep(3000);
		String actuserName = login.getValueFrmTextbox();
		log.info(actuserName);
		Assert.assertEquals(actuserName, "priyanka@house.com");
		log.info("Username is populated");
		
		Assert.assertTrue(login.isSelectedCheckBox());
		log.info("CheckBox rememberme is checked");
		
	}
	
	@When("user click on Forgot password")
	public void user_click_on_forgot_password() throws InterruptedException {
		
		Thread.sleep(5000);
		driver= login.clickOnLink();
		
		
	}

	@When("user enter username in Salesforce forgot password page")
	public void user_enter_username_in_salesforce_forgot_password_page() throws InterruptedException {
		Thread.sleep(3000);
		String exptitle = "Forgot Your Password | Salesforce";
		String acttitle = forgotpwd.getPageTitle();
		
		Assert.assertEquals(acttitle, exptitle);
		log.info("Forgot Your Password Page");
		
		forgotpwd.enterUserName("priyanka@house.com");
		
		Thread.sleep(3000);
		
		
	}

	@When("user click on continue button")
	public void user_click_on_continue_button() throws InterruptedException {
		
		driver = forgotpwd.clickContinueButton();
		
		Thread.sleep(3000);
		
		
	}


	@Then("user should see Password reset message page {string}")
	public void user_should_see_password_reset_message_page(String experrmsg) throws InterruptedException {
		
		Thread.sleep(3000);
		String acterrmsg = chkemail.getTextFromElement();
		

		Assert.assertEquals(acterrmsg, experrmsg);
		log.info("Password reset message page is displayed.");
		
	}

	@When("user enter wrong username as {string}")
	public void user_enter_wrong_username_as(String username) {
	   login.enterUserName(username);
	}

	@When("user enter wrong password as {string}")
	public void user_enter_wrong_password_as(String password) {
	   login.enterPassword(password);
	}

	@Then("Verify a error message {string};")
	public void verify_a_error_message(String expErrorMsg) {
		String actErroMsg = login.getTextFromElement();
		Assert.assertEquals(actErroMsg, expErrorMsg);
		log.info(actErroMsg);
	    
	}
	

}
