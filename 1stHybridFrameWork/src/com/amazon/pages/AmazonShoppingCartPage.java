package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.genericlib.BasePage;
import com.amazon.genericlib.DriverUtils;
import com.amazon.genericlib.LogUtils;

public class AmazonShoppingCartPage extends BasePage {
	
	@FindBy(xpath="//div[@id='huc-v2-order-row-confirm-text']")
	private WebElement eleAddedToCartMsg;
	
	@FindBy(id="hlb-view-cart-announce")
	private WebElement eleCartButton;
	
	@FindBy(xpath="//span[@class='a-size-medium sc-product-title a-text-bold']")
	private WebElement elePhoneText;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement eleDeleteButton;
	
	@FindBy(xpath="//span[contains(text(),'Hello, sujith')]")
	private WebElement eleSignInText;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement eleSignOutLink;
	
	public AmazonShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String addedToCartMsg() {
		String msg = eleAddedToCartMsg.getText();
		LogUtils.info("Got added to cart text message");
		return msg;
	}
	
	public void cartButton(WebDriver driver) {
		String cartButton = "//a[@href='https://www.amazon.in/gp/cart/view.html?ref=nav_cart']";
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartButton)));
		eleCartButton.click();
		LogUtils.info("Clicked on Cart button");
	}
	
	public String phoneText() {
		String text = elePhoneText.getText();
		LogUtils.info("Got phone text");
		return text;
	}
	
	public void deleteButton() {
		eleDeleteButton.click();
		LogUtils.info("Clicked on Delete Button");
	}
	
	// mouse over to signIn text //
	public void signText(WebDriver driver) {
		DriverUtils.action(driver, eleSignInText);
		LogUtils.info("Mouse Cursor moved to signin text");
	}
	
	public void signOutLink() {	
		eleSignOutLink.click();
		LogUtils.info("Clicked on signout button");
	}

}
