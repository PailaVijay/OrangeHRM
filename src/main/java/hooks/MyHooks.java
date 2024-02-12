package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class MyHooks {
	Properties prop;
 public  WebDriver driver;
	@Before
	public void setUp()
	{
		prop = ConfigReader.initializeProperties();
		driver=DriverFactory.initializeBrowser("chrome");
		
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
