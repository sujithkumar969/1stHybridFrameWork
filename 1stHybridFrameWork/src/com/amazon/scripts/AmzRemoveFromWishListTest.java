package com.amazon.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.genericlib.DataDriven;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OnlineShoppingPage;
import com.amazon.pages.WishListPage;

public class AmzRemoveFromWishListTest extends BaseTest {
	
	@Test
	public void amzRemoveFromWishListTest() {
		
		OnlineShoppingPage oSp = new OnlineShoppingPage(driver);
		oSp.SignInText(driver);
		oSp.SignInButton();
		
		LoginPage l = new LoginPage(driver);
		l.emailTextBox(DataDriven.getData("Login", 98, 4));
		l.continueButton();
		l.passwordTextBox(DataDriven.getData("Login", 100, 4));
		l.loginButton();
		
		WishListPage wis = new WishListPage(driver);
		wis.yourListsLink();
		wis.searchTextField(DataDriven.getData("Login", 103, 4));
		wis.removeItem();
		String actualText = wis.deletedMsg();
		String expectedText = DataDriven.getData("Login", 104, 4);
		Assert.assertEquals(actualText, expectedText);
		wis.yourListsLink();
		wis.searchTextField(DataDriven.getData("Login", 106, 4));
		String actualText2 = wis.ele0ItemsTextMsg();
		String expectedText2 = DataDriven.getData("Login", 107, 4);
		Assert.assertEquals(actualText2, expectedText2);
		wis.signText(driver);
		wis.signOutLink();
	}

}