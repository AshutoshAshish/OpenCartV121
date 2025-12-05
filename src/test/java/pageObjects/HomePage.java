package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement tabMyaccount;
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement tabRegister;
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement tabLogin;
	@FindBy(xpath = "//a[normalize-space()='Qafox.com']") WebElement tab_Qafox;
	@FindBy(xpath = "//input[@placeholder='Search']") WebElement txt_Searchbox;
	@FindBy(xpath = "//i[@class='fa fa-search']") WebElement tab_Search;
	@FindBy(xpath="//a[@id='wishlist-total']//i[@class='fa fa-heart']") WebElement tab_goToWishlist;
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']") WebElement tab_goToCart;
	
	
	public void clickMyAccount() {
		tabMyaccount.click();
	}
	
	public void clickRegister() {
		tabRegister.click();
	}
	
	public void clickLogin() {
		tabLogin.click();
	}
	
	public void clickHome() {
		tab_Qafox.click();
	}
	
	public void setSearchValue(String productName) {
		txt_Searchbox.sendKeys(productName);
	}
	
	public void clickSearch() {
		tab_Search.click();
	}
	
	public void clickWishlistTab() {
		tab_goToWishlist.click();
	}
	

}
