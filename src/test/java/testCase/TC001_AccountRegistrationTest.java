package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTCs;

public class TC001_AccountRegistrationTest extends BaseTCs {
	
	@Test(groups= {"Master","Regression"})
	public void verifyAccReg() {
		
		try {
			logger.info("**** Starting TC001_AccountRegistrationTest Execution...****");
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account tab...");
			hp.clickRegister();
			logger.info("Clicked on Register tab...");
			
			AccountRegistrationPage accReg = new AccountRegistrationPage(driver);
			logger.info("Providing customer details...");
			accReg.setFisrtName(randomAlphabates().toUpperCase());
			accReg.setLastName(randomAlphabates().toUpperCase());
			accReg.setEmail(randomAlphanumerics()+"@gmail.com");
			accReg.setTelephone(randomNumbers());
			String pwd = randomAlphaNums();
			System.out.println("Password is: "+pwd);
			accReg.setPassword(pwd);
			accReg.setConfirmPassword(pwd);
			accReg.clickNewsletter();
			accReg.clickAgreeCheckbox();
			accReg.clickContinue();
			
			logger.info("Validating expected results...");
			
			if(accReg.getConfMsg()) {
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test Failed...");
				logger.debug("Debug logs");
				Assert.fail();
			}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("Finished TC001_AccountRegistrationTest Execution");
		
	}

}
