package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class BaseTest {
	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");

	public WebDriver getBrowserDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Please enter correct browser name!");
		}
		return driver;
	}
	
	public static Object getPage(WebDriver driver, String pageName) {
		switch (pageName) {
		case "HomePage":
			return new HomePageObject(driver);
		case "LoginPage":
			return new LoginPageObject(driver);
		case "RegisterPage":
			return new RegisterPageObject(driver);
		default:
			throw new IllegalArgumentException("Page name is not valid");
		}
	}
	
}
