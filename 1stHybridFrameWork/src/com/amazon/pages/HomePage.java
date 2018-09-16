package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.BasePage;
import com.amazon.genericlib.DriverUtils;
import com.amazon.genericlib.LogUtils;

public class HomePage extends BasePage {
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement eleSearchTextBox;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement eleSearchButton;
	
	@FindBy(xpath="//span[contains(text(),'Hello, sujith')]")
	private WebElement eleSignInText;
	
	@FindBy(xpath="//span[.='Your Account']")
	private WebElement eleYourAccountLink;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	private WebElement eleCartButton;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement eleSignOutLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void SearchTextBox(String product) {
		eleSearchTextBox.sendKeys(product);
		LogUtils.info("Enter Product in search field");
	}
	
	public void SearchButton() {
		eleSearchButton.click();
		LogUtils.info("Clicked on search button");
	}
	
	public void signInText(WebDriver driver) {
		DriverUtils.action(driver, eleSignInText);
		LogUtils.info("Mouse Cursor moved to signin text");
	}
	
	public void yourAccountLink() {
		eleYourAccountLink.click();
		LogUtils.info("Clicked on your account link");
	}
	
	public void cartButton() {
		eleCartButton.click();
		LogUtils.info("Clicked on cart button");
	}
	
	public void signOutLink() {
		eleSignOutLink.click();
		LogUtils.info("Clicked on signout Button");
	}
}
