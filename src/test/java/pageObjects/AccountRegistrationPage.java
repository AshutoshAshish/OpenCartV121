package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastName;
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_eMail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_passwordConfirm;
	@FindBy(xpath="//label[normalize-space()='Yes']") WebElement rdb_newsletter;
	@FindBy(xpath="//input[@name='agree']") WebElement chk_agree;
	@FindBy(xpath="//input[@value='Continue']") WebElement btn_continue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confMsg;

	
	public void setFisrtName(String firstName) {
		txt_firstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		txt_lastName.sendKeys(lastName);
	}
	
	public void setEmail(String email) {
		txt_eMail.sendKeys(email);
	}
	
	public void setTelephone(String telephone) {
		txt_telephone.sendKeys(telephone);
	}
	
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String confPwd) {
		txt_passwordConfirm.sendKeys(confPwd);
	}
	
	public void clickNewsletter() {
		rdb_newsletter.click();
	}
	
	public void clickAgreeCheckbox() {
		chk_agree.click();
	}
	
	public void clickContinue() {
		btn_continue.click();
	}
	
	public boolean getConfMsg() {
		try {
			return confMsg.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
