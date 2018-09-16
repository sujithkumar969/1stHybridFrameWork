package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.BasePage;
import com.amazon.genericlib.LogUtils;

public class LoginPage extends BasePage {
	
	@FindBy(id="ap_email")
	private WebElement eleEmailTextBox;
	
	@FindBy(id="continue")
	private WebElement eleContinueButton;
	
	@FindBy(id="ap_password")
	private WebElement elePasswordTextBox;
	
	@FindBy(id="signInSubmit")
	private WebElement eleLoginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void emailTextBox(String email) {
		eleEmailTextBox.sendKeys(email);
		LogUtils.info("Email Entered");
	}
	
	public void continueButton() {
		eleContinueButton.click();
		LogUtils.info("Clicked on Continue Button");
	}
	
	public void passwordTextBox(String password) {
		elePasswordTextBox.sendKeys(password);
		LogUtils.info("Password Entered");
	}
	
	public void loginButton() {
		eleLoginButton.click();
		LogUtils.info("Clicked on Login Button");
	}

}
