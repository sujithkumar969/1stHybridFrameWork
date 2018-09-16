package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.BasePage;
import com.amazon.genericlib.DriverUtils;
import com.amazon.genericlib.LogUtils;

public class OnlineShoppingPage extends BasePage {
	
	@FindBy(xpath="//span[text()='Hello. Sign in']")
	private WebElement eleSignInText;
	
	@FindBy(xpath="(//span[@class='nav-action-inner'])[1]")
	private WebElement eleSignInButton;
	
	public OnlineShoppingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// mouse over to signIn text //
	public void SignInText(WebDriver driver) {
		DriverUtils.action(driver, eleSignInText);
		LogUtils.info("Mouse Cursor moved to signin text");
	}
	
	public void SignInButton() {
		eleSignInButton.click();
		LogUtils.info("Clicked on signin Button");
	}

}