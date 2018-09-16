package com.amazon.scripts;

import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.genericlib.DataDriven;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OnlineShoppingPage;
import com.amazon.pages.SamsungGalaxyNote8Page;

public class AmzSearchProductTest extends BaseTest{
	
	@Test
	public void amzSearchProductTest() {

	OnlineShoppingPage oSp = new OnlineShoppingPage(driver);
	oSp.SignInText(driver);
	oSp.SignInButton();
	
	LoginPage l = new LoginPage(driver);
	l.emailTextBox(DataDriven.getData("Login", 14, 4));
	l.continueButton();
	l.passwordTextBox(DataDriven.getData("Login", 16, 4));
	l.loginButton();
	
	HomePage h = new HomePage(driver);
	h.SearchTextBox(DataDriven.getData("Login", 18, 4));
	h.SearchButton();
	
	SamsungGalaxyNote8Page pro = new SamsungGalaxyNote8Page(driver);
	pro.signText(driver);
	pro.signOutLink();
	
	}
}
