
package testCases;


import org.testng.annotations.Test;

import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MyAccount;
import testbase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	HomePage hp;
	LoginPage loginpage;
	MyAccount myaccount;

	@Test(groups = {"Sanity","Master"})
	public void test_Login() {
		logger.info("Starting TC_002_LoginTest");
		loginpage = new LoginPage(driver);
		logger.info("Swt email ....");
		loginpage.setEmail(rb.getString("Username"));

		loginpage.setPassword(rb.getString("password"));
		
		loginpage.clickButton();
		
		 myaccount=new MyAccount(driver);
		 
		myaccount.isMyAccountPageExists();
			
			
		
		 
	

	}

}
