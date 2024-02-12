package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
   public LoginPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath="//input[@name='username']")
   private WebElement userNameField;
   
   @FindBy(xpath="//input[@name='password']")
   private WebElement passwordfield;
   
   @FindBy(xpath="//button[@type='submit']")
   private WebElement loginButton;
   
   @FindBy(xpath="//p[text()='Invalid credentials']")
   private WebElement warningMessage;
   
   @FindBy(xpath="//span[text()='Required']")
   private WebElement requiredMessage;
   
   @FindBy(xpath="//h6[text()='Dashboard']")
   private WebElement loginConfirmation;
   
   public void getUserName(String userName)
   {
	   userNameField.sendKeys(userName);
   }
   
   public void getPassword(String password)
   {
	   passwordfield.sendKeys(password);
   }
   
   public void clickOnLogin()
   {
	   loginButton.click();
   }
   
   public String getWarningMessage()
   {
	   return warningMessage.getText();
   }
   public String getRequiredWarning()
   {
	   return requiredMessage.getText(); 
   }
   public String getLoginConfirmation()
   {
	   return loginConfirmation.getText();
   }
}
