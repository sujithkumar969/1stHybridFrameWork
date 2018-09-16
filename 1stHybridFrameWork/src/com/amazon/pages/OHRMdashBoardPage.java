package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.genericlib.DataDriven;
import com.amazon.genericlib.LogUtils;

public class OHRMdashBoardPage {
	@FindBy(id="welcome")
	WebElement eleWelcomeLink;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement eleLogoutLink;
	
	@FindBy(xpath="//h1[text()='Dashboard']")
	WebElement eleDashboardText;
	
	public OHRMdashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnWelcomeLink() {
		eleWelcomeLink.click();
		LogUtils.info("Clicked on welcome link");
	}
	
	public void validateDashboardText() {
		String actualText = eleDashboardText.getText();
		String expectedText = DataDriven.getData("OHRM", 7, 4);
		Assert.assertEquals(actualText, expectedText);
		LogUtils.info("validated the dashboard text");
	}
	
	public void clickOnLogoutLink() {
		eleLogoutLink.click();
		LogUtils.info("Clicked on logout link");
	}

}
