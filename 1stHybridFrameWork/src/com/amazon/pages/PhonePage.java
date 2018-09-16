package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.BasePage;
import com.amazon.genericlib.LogUtils;

public class PhonePage extends BasePage {
	
	@FindBy(xpath="(//h2[contains(text(),'Samsung Galaxy Note 8 (Midnight Black)')])[1]")
	private WebElement phone;
	
	public PhonePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void phoneImage() {
		phone.click();
		LogUtils.info("Clicked on product image");
	}

}
