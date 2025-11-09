package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getInvalidTextFromFirstName() {
		return getElementText(driver, RegisterPageUI.INVALID_TEXT_FIRST_NAME_TEXTBOX);
	}

	public String getInvalidTextFromLastName() {
		return getElementText(driver, RegisterPageUI.INVALID_TEXT_LAST_NAME_TEXTBOX);
	}

	public String getInvalidTextFromEmail() {
		return getElementText(driver, RegisterPageUI.INVALID_TEXT_EMAIL_TEXTBOX);
	}

	public String getInvalidTextFromComfirmPassword() {
		return getElementText(driver, RegisterPageUI.INVALID_TEXT_CONFIRM_PASSWORD_TEXTBOX);
	}

	public void refreshPage() {
		refreshCurrentPage(driver);
	}

	public void senkeyToFirstNameTextBox() {
		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, "Duy");
	}

	public void senkeyToLastNameTextBox() {
		senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, "Nguyen");
	}

	public void senkeyToEmailTextBox() {
		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, "123@456");
	}

	public void senkeyToPasswordTextBox() {
		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, "123456");
	}

	public void senkeyToConfirmPasswordTextBox() {
		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, "123456");
	}

	public boolean isVisibleWrongMailText() {
		return isElementDisplayed(driver, "//span[@id='Email-error' and text()='Wrong email']");
	}

}
