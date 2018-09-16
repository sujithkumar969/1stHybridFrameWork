package com.amazon.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.genericlib.DataDriven;
import com.amazon.genericlib.DriverUtils;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OnlineShoppingPage;

public class AmzSearchEmptyProductTest extends BaseTest {
	
	@Test
	public void amzSearchEmptyProductTest() {
		
		OnlineShoppingPage oSp = new OnlineShoppingPage(driver);
		oSp.SignInText(driver);
		oSp.SignInButton();
		
		LoginPage l = new LoginPage(driver);
		l.emailTextBox(DataDriven.getData("Login", 113, 4));
		l.continueButton();
		l.passwordTextBox(DataDriven.getData("Login", 115, 4));
		l.loginButton();
		
		HomePage hp = new HomePage(driver);
		hp.SearchTextBox("");
		hp.SearchButton();
		
		String actualText = DriverUtils.getPageTitle(driver);
		String expectedText = DataDriven.getData("Login", 119, 4);
		Assert.assertNotSame(actualText, expectedText);
		
		hp.signInText(driver);
		hp.signOutLink();
	}
}
