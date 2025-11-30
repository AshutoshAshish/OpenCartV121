package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTCs;
import utilities.DataProviders;

public class TC003_LoginTest_DDT extends BaseTCs{
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")
	public void verify_LoginDDT(String email, String pwd, String exp) {
		
		logger.info("******Started TC003_LoginTest_DDT*******");
		
		
		try {
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			//MyAccountPage
			MyAccountPage ap = new MyAccountPage(driver);
			boolean targetPage = ap.getMyAccMsg();
			
			if(exp.equalsIgnoreCase("Valid")) {
				if(targetPage==true) {
					ap.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.fail();
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid")) {
				if(targetPage==true) {
					ap.clickLogout();
					Assert.fail();
				}
				else {
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******Finished TC003_LoginTest_DDT******");
		
	}
	
}
