package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.PageGeneratorManager;
import pageObject.RegisterPageObject;

public class User_01_Register extends BaseTest {
	WebDriver driver;
	String emailAddress;
	String projectPath = System.getProperty("user.dir");
	
	@Parameters ("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = getBrowserDriver(browserName);
		emailAddress = "duy" + generateFakeNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/register");

	}

	@Test
	public void TC_01_Register_Empty_Data() {
		registerPage = PageGeneratorManager.getPage(RegisterPageObject.class, driver);
		//homePage = (HomePageObject) BaseTest.getPage(driver, "HomePage");
		//homePage = new HomePageObject(driver);
		//homePage.clickToHeaderRegister();
		
		//registerPage = new RegisterPageObject(driver);
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getInvalidTextFromFirstName(), "First name is required.");
		Assert.assertEquals(registerPage.getInvalidTextFromLastName(), "Last name is required.");
		Assert.assertEquals(registerPage.getInvalidTextFromEmail(), "Email is required.");
		Assert.assertEquals(registerPage.getInvalidTextFromComfirmPassword(), "Password is required.");
	}

//	@Test
//	public void TC_02_Register_Invalid_Email() {
//		registerPage.refreshPage();
//		registerPage.senkeyToFirstNameTextBox();
//		registerPage.senkeyToLastNameTextBox();
//		registerPage.senkeyToEmailTextBox();
//		registerPage.senkeyToPasswordTextBox();
//		registerPage.senkeyToConfirmPasswordTextBox();
//		registerPage.clickToRegisterButton();
//		Assert.assertTrue(registerPage.isVisibleWrongMailText());
//	}
//
//	@Test
//	public void TC_03_Register_Success() {
//		driver.findElement(By.cssSelector("a.ico-register")).click();
//
//		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Duy");
//		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nguyen");
//		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
//		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
//		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
//		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
//
//		driver.findElement(By.cssSelector(".button-1.register-next-step-button")).click();
//		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
//		driver.findElement(By.cssSelector("a.ico-logout")).click();
//	}
//
//	@Test
//	public void TC_04_Register_Existing_Email() {
//		driver.findElement(By.cssSelector("a.ico-register")).click();
//
//		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Duy");
//		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nguyen");
//		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
//		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
//		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
//
//		driver.findElement(By.cssSelector(".button-1.register-next-step-button")).click();
//		Assert.assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(),
//				"The specified email already exists");
//	}
//
//	@Test
//	public void TC_05_Register_Password_Less_Than_6_Chars() {
//		driver.findElement(By.cssSelector("a.ico-register")).click();
//
//		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Duy");
//		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nguyen");
//		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
//		driver.findElement(By.cssSelector("input#Password")).sendKeys("12345");
//		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345");
//
//		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
//				"Password must meet the following rules:  must have at least 6 characters and not greater than 64 characters");
//
//	}
//
//	@Test
//	public void TC_06_Register_Invalid_Confirm_Password() {
//		driver.findElement(By.cssSelector("a.ico-register")).click();
//
//		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Duy");
//		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Nguyen");
//		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
//		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
//		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("654321");
//		
//		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword")).getText(),
//				"The password and confirmation password do not match.");
//
//	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;	
}
