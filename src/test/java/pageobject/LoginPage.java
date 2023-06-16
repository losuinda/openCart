package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement eMailAddressTextBox;

	public void setEmail(String email) {
		eMailAddressTextBox.sendKeys(email);

	}

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passwordTextBox;

	public void setPassword(String password) {
		passwordTextBox.sendKeys(password);

	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	public void clickButton() {
	loginButton.click();
	

	}

}
