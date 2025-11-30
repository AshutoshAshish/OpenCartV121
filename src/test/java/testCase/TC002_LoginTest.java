package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTCs;

public class TC002_LoginTest extends BaseTCs {
	
	@Test(groups= {"Master","Sanity"})
	public void verifyLogin() {
		
		logger.info("**** Starting TC002_LoginTest...****");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			MyAccountPage ma = new MyAccountPage(driver);
			Assert.assertTrue(ma.getMyAccMsg());
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finished TC002_LoginTest...****");
	}

}
