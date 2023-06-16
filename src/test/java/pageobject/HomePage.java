package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myaccount;

	public void myaccountMethod() {
		myaccount.click();
	}

	@FindBy(linkText ="Register")
	WebElement register;

	public void registerMethod() {
		register.click();
	}
}
