package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.graphbuilder.curve.Point;

public class RegisterationPage extends BasePage {
	

	public RegisterationPage(WebDriver driver) {
		super(driver);
		

	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstNameTexTBox;

	public void setfirstNameTexTBox(String firstName) {
		firstNameTexTBox.sendKeys(firstName);
	}

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastNameTexTBox;

	public void setlastNameTexTBox(String lastname) {
		lastNameTexTBox.sendKeys(lastname);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement eMailTexTBox;

	public void setEmailTexTBox(String email) {
		eMailTexTBox.sendKeys(email);
	}

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passwordTexTBox;

	public void setpasswordTexTBox(String password) {
		passwordTexTBox.sendKeys(password);
	}

	@FindBy(xpath = "//input[@id='input-newsletter-yes']")
	WebElement yescheckBOx;

	

	@FindBy(name = "agree")
	WebElement chkdPolicy;

	public void clickprivacyPolicycheckBox() {
		
		chkdPolicy.click();
		
		}
	

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submiteButton;

	public void clicksubmiteButton() {
		submiteButton.click();
	}

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public String getConfirmationMsg() {
		try {

			return (msgConfirmation.getText());
		}

		catch (Exception e) {
			return (e.getMessage());

		}
	}
	
	
}
