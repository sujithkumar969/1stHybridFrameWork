package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.DataDriven;
import com.amazon.genericlib.LogUtils;

public class OHRMLoginPage {
	@FindBy(id="txtUsername")
	private WebElement eleUserNameTextBox;
	
	@FindBy(id="txtPassword")
	private WebElement elePasswordTextBox;
	
	@FindBy(id="btnLogin")
	private WebElement eleLoginButton;
	
	@FindBy(xpath="//span[text()='Invalid credentials']")
	private WebElement eleWarningMsg;
	
	public OHRMLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName() {
		eleUserNameTextBox.sendKeys(DataDriven.getData("OHRM", 4, 4));
		LogUtils.info("Entered the user name");
	}
	
	public void enterPassword() {
		elePasswordTextBox.sendKeys(DataDriven.getData("OHRM", 5, 4));
		LogUtils.info("Entered the password");
	}
	
	public void clickOnLoginButton() {
		eleLoginButton.click();
		LogUtils.info("Clicked on login button");
	}

}
