package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.BasePage;
import com.amazon.genericlib.LogUtils;

public class YourAccountPage extends BasePage {
	
	@FindBy(xpath="//span[.='Edit addresses for orders and gifts']")
	private WebElement eleYourAddressesButton;
	
	public YourAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void yourAddressesButton() {
		eleYourAddressesButton.click();
		LogUtils.info("Clicked on your Addresses Button");
	}
	

}
