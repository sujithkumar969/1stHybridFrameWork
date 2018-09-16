package com.amazon.scripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.genericlib.DataDriven;
import com.amazon.genericlib.Log;
import com.amazon.genericlib.LogUtils;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OnlineShoppingPage;

//@Listeners(com.amazon.genericlib.Log.class)
public class AmzSignInAndSignOutTest extends BaseTest {
	
	@Test
	public void amzSignInAndSignOutTest() {
		
		OnlineShoppingPage osp = new OnlineShoppingPage(driver);
		osp.SignInText(driver);
		osp.SignInButton();
		
		LoginPage lp = new LoginPage(driver);
		lp.emailTextBox(DataDriven.getData("Login", 5, 4));	
		lp.continueButton();
		lp.passwordTextBox(DataDriven.getData("Login", 7, 4));
		lp.loginButton();
		
		
		HomePage hp = new HomePage(driver);
		hp.signInText(driver);
		hp.signOutLink();
		
	}
}