package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.BasePage;
import com.amazon.genericlib.DriverUtils;
import com.amazon.genericlib.LogUtils;

public class WishListPage extends BasePage {
	
	@FindBy(id="WLHUC_viewlist")
	private WebElement eleViewWishListButton;
	
	@FindBy(xpath="(//a[@title='Samsung Galaxy Note 8 (Midnight Black)'])[2]")
	private WebElement elePhoneImageText;
	
	@FindBy(xpath="Remove item")
	private WebElement eleRemoveitemLinkText;
	
	@FindBy(xpath="//a[@id='nav-link-wishlist']")
	private WebElement eleYourListsLink;
	
	@FindBy(id="itemSearchTextInput")
	private WebElement eleSearchTextField;
	
    @FindBy(xpath="//a[.='Remove item']")
    private WebElement eleRemoveItem;
	
	@FindBy(xpath="(//div[.='Deleted'])[3]")
	private WebElement eleDeletedMsg;
	
	@FindBy(xpath="(//span[.='0 items in this view'])[2]")
	private WebElement ele0ItemsTextMsg;

	@FindBy(xpath="//span[contains(text(),'Hello, sujith')]")
	private WebElement eleSignInText;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement eleSignOutLink;
	
	public WishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void viewWishListButton(WebDriver driver) {
		DriverUtils.getvisibilityOfElementOnScreen(driver, eleViewWishListButton);
		eleViewWishListButton.click();
		LogUtils.info("Clicked on view WishList Button");
	}
	
	public String phoneImageText() {
		String t = elePhoneImageText.getText();
		LogUtils.info("Got the phone image text");
		return t;
	}
	
	public void yourListsLink() {
		eleYourListsLink.click();
		LogUtils.info("Clicked on your List link");
	}
	
	public void searchTextField(String productName) {
		eleSearchTextField.sendKeys(productName);
		DriverUtils.pressEnterButton(eleSearchTextField);
		LogUtils.info("Entered product and Clicked on enter button");
	}
	
	public void removeItem() {
		eleRemoveItem.click();
		LogUtils.info("Clicked on removeItem link");
	}
	
	public String deletedMsg() {
		String del = eleDeletedMsg.getText();
		LogUtils.info("Got Delete Confirmation Message");
		return del;
	}
	
	public String ele0ItemsTextMsg() {
		String msg = ele0ItemsTextMsg.getText();
		LogUtils.info("Got 0 Items Text message");
		return msg;
	}
	
	// mouse over to signIn text //
	public void signText(WebDriver driver) {
		DriverUtils.action(driver, eleSignInText);
		LogUtils.info("Mouse Cursor moved to signin text");
	}
	
	public void signOutLink() {	
		eleSignOutLink.click();
		LogUtils.info("Clicked on signin Button");
	}

}

