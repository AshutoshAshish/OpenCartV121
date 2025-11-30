package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-email']") WebElement txt_Email;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_Pwd;
	@FindBy(xpath="//input[@value='Login']") WebElement tab_Login;
	
	public void setEmail(String loginEmail) {
		txt_Email.sendKeys(loginEmail);
	}
	
	public void setPassword(String loginPwd) {
		txt_Pwd.sendKeys(loginPwd);
	}
	
	public void clickLogin() {
		tab_Login.click();
	}

}
