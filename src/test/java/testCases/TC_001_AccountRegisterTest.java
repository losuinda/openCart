package testCases;

import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.RegisterationPage;
import testbase.BaseClass;

public class TC_001_AccountRegisterTest extends BaseClass {
	HomePage hp;

	RegisterationPage regpage;

	@Test(groups = {"Regration","Master"})
	public void test_account_Registration() throws InterruptedException {
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		
			HomePage hp = new HomePage(driver);
			hp.myaccountMethod();
			logger.info("Clicked on My account link");

			hp.registerMethod();
			logger.info("Clicked on register link");
			
			regpage = new RegisterationPage(driver);

			logger.info("Providing customer data");

			regpage.setfirstNameTexTBox(randomAlpha().toUpperCase());

			regpage.setlastNameTexTBox(randomAlpha().toUpperCase());

			regpage.setEmailTexTBox(randomAlpha() + "@gmail.com");// randomly generated the email

			regpage.setpasswordTexTBox(rb.getString("password"));
			
			regpage.clicksubmiteButton();
			logger.info("Clicked on continue");

			String confmsg = regpage.getConfirmationMsg();

			logger.info("Validating expected message");
			

		
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");
	

}
}
