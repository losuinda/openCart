package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageobject.LoginPage;
import pageobject.MyAccount;
import testbase.BaseClass;

public class TC_003_LoginDDT extends BaseClass {

	LoginPage loginpage;
	MyAccount myaccount;

	@Test(dataProvider = "LoginData",dataProviderClass = Utilites.DataProviders.class)
	public void test_loginDDT(String username, String password, String exp) {

		logger.info("Starting TC_002_LoginTest");
		loginpage = new LoginPage(driver);
		logger.info("Swt email ....");
		loginpage.setEmail(username);

		loginpage.setPassword(password);

		loginpage.clickButton();

		myaccount = new MyAccount(driver);

		boolean mytarget = myaccount.isMyAccountPageExists();
		if (exp.equalsIgnoreCase("valid")) {
			if (mytarget == true) {

				myaccount.clickLogout();
				Assert.assertTrue(true);

			} else {
				Assert.assertTrue(false);
			}

		}
		if (exp.equalsIgnoreCase("invalid")) {
			if (mytarget == true) {

				myaccount.clickLogout();
				Assert.assertTrue(false);

			} else {
				Assert.assertTrue(true);
			}

		}
		logger.info("finish ..................");
	}

}
