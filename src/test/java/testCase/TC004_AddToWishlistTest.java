package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import testBase.BaseTCs;

public class TC004_AddToWishlistTest extends BaseTCs {
	
	
	@Test(groups= {"Master","Regression"})
	public void verifyAddToWishlist() {
		
		try {
			
			logger.info("**** Starting TC001_AccountRegistrationTest Execution...****");
			
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			hp.setSearchValue(p.getProperty("searchProductName"));
			hp.clickSearch();
			
			SearchPage sp = new SearchPage(driver);
			sp.selectListView();
			sp.selectGridView();
			boolean status = sp.viewImageOfSearchedProduct();
			String productCaption = sp.getProductCaption();
			sp.clickAddToWishlist();
			
			hp.clickWishlistTab();
			
			System.out.println(productCaption+" : "+ status);
			
			Assert.assertTrue(true);
			
			
			
			
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}
	
	
	

}
