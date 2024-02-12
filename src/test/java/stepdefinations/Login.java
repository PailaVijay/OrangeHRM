package stepdefinations;



import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;

import pages.LoginPage;
import utils.ConfigReader;

public class Login {

	public WebDriver driver;
	public LoginPage loginPage;
	
	Properties prop;
	
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		driver=DriverFactory.getDriver();
		prop=ConfigReader.initializeProperties();
		//driver.get(prop.getProperty("url"));
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("User enters valid username {string} into username field")
	public void user_enters_valid_username_into_username_field(String userName) {
		loginPage= new LoginPage(driver);
		loginPage.getUserName(userName);
		
		
	}

	@When("User enters valid password {string} into passsword field")
	public void user_enters_valid_password_into_passsword_field(String password) {
		
		loginPage.getPassword(password);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage= new LoginPage(driver);
	    loginPage.clickOnLogin();
	}

	@Then("User should navigate to Dashboard page")
	public void user_should_navigate_to_dashboard_page() {
	   
		Assert.assertEquals("Dashboard", loginPage.getLoginConfirmation());
	}

	@When("User do not enter any credentials")
	public void user_do_not_enter_any_credentials() {
	   
	}

	@Then("User should not get into dashboard")
	public void user_should_not_get_into_dashboard() {
		Assert.assertEquals( "Required",loginPage.getRequiredWarning());
	}

	@When("User enters invalid password {string} into passsword field")
	public void user_enters_invalid_password_into_passsword_field(String invalidPswd) {
		loginPage.getPassword(invalidPswd);
	}

	@Then("User should get warning message")
	public void user_should_get_warning_message() {
	    Assert.assertEquals("Invalid credentials", loginPage.getWarningMessage());
	}

	@When("User enters invalid username {string} into username field")
	public void user_enters_invalid_username_into_username_field(String invalidUser) {
		loginPage= new LoginPage(driver);
		loginPage.getUserName(invalidUser);
	}

	
}
