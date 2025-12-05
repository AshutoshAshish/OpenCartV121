package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseTCs;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-search']") WebElement txt_searchKeyword;
	@FindBy(xpath="//select[@name='category_id']") WebElement dd_AllCategories;
	@FindBy(xpath="//input[@name='sub_category']") WebElement cBox_searchBySubCategory;
	@FindBy(xpath="//input[@id='description']") WebElement cBox_searchByProductDiscription;
	@FindBy(xpath="//input[@id='button-search']") WebElement tab_searchbox;
	@FindBy(xpath="//i[@class='fa fa-th']") WebElement tab_gridView;
	@FindBy(xpath="//i[@class='fa fa-th-list']") WebElement tab_listView;
	@FindBy(xpath="//img[@class='img-responsive']") WebElement img_searchedProduct;
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'iPhone')]") WebElement tab_productCaption;
	@FindBy(xpath="//span[normalize-space()='Add to Cart']") WebElement tab_addToCart;
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-heart']") WebElement tab_addToWishlist;
	@FindBy(xpath="//i[@class='fa fa-exchange']") WebElement tab_compareProduct;
	
	
	
	public void setSearchKeyword(String productName) {
		txt_searchKeyword.sendKeys(productName);
	}
	
	public void setAllCategoriesDD(String ddValue) {
		BaseTCs.selectValueFromSelectDD(dd_AllCategories, ddValue);
	}
	
	public void selectSubCategoryCBox() {
		cBox_searchBySubCategory.click();
	}
	
	public void selectProductDiscriptionCBox() {
		cBox_searchByProductDiscription.click();
	}
	
	public void selectGridView() {
		tab_gridView.click();
	}
	
	public void selectListView() {
		tab_listView.click();
	}
	
	public boolean viewImageOfSearchedProduct() {
		boolean viewImageStatus = img_searchedProduct.isDisplayed();
		
		return viewImageStatus;
	}
	
	public String getProductCaption() {
		String productCaption = tab_productCaption.getText();
		
		return productCaption;
	}
	
	public void clickAddToWishlist() {
		tab_addToWishlist.click();
	}
	
	
	
	
	


}
