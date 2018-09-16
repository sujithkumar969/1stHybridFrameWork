package com.amazon.scripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.genericlib.DataDriven;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OnlineShoppingPage;
import com.amazon.pages.YourAccountPage;
import com.amazon.pages.YourAdressesPage;

public class AmzDeleteAddressTest extends BaseTest {
	
	@Test
	public void amzDeleteAddressTest() {
	OnlineShoppingPage oSp = new OnlineShoppingPage(driver);
	oSp.SignInText(driver);
	oSp.SignInButton();
	
	LoginPage l = new LoginPage(driver);
	l.emailTextBox(DataDriven.getData("Login", 125, 4));
	l.continueButton();
	l.passwordTextBox(DataDriven.getData("Login", 127, 4));
	l.loginButton();
	
	HomePage hm = new HomePage(driver);
	hm.signInText(driver);
	hm.yourAccountLink();
	
	YourAccountPage acnt = new YourAccountPage(driver);
	acnt.yourAddressesButton();
	
	YourAdressesPage yadp = new YourAdressesPage(driver);
	yadp.deleteLinkOfAddress();
	yadp.yesButtonOfAlertPopUp();
	
	String actualText = yadp.addressDeletedTextMsg();
	String expectedText = DataDriven.getData("Login", 132, 4);
	Assert.assertEquals(actualText, expectedText);

}
}
