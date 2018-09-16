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

public class SamsungGalaxyNote8Page extends BasePage {
	
	@FindBy(id="add-to-cart-button")
	private WebElement eleAddToCartButton;
	
	@FindBy(xpath="//input[@id='add-to-wishlist-button-submit']")
	private WebElement eleAddToWishListButton;
	
	@FindBy(xpath="//span[contains(text(),'Hello, sujith')]")
	private WebElement eleSignInText;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement eleSignOutLink;
	
	public SamsungGalaxyNote8Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addToCartButton() {
		eleAddToCartButton.click();
		LogUtils.info("Clicked on Add to Cart Button");
	}
	
	public void addToWishListButton(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='add-to-wishlist-button-submit']"))).click();
		DriverUtils.getvisibilityOfElementOnScreen(driver, eleAddToWishListButton);
		eleAddToWishListButton.click();
		LogUtils.info("Clicked on Add to whistList Button");
	}

	// mouse over to signIn text //
	public void signText(WebDriver driver) {
		DriverUtils.action(driver, eleSignInText);
		LogUtils.info("Mouse Cursor moved to signin text");
	}
	
	public void signOutLink() {	
		eleSignOutLink.click();
		LogUtils.info("Clicked on signout Button");
	}

}

