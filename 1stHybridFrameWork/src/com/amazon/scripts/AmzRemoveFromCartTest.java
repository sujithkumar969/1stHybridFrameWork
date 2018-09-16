package com.amazon.scripts;

import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.genericlib.DataDriven;
import com.amazon.pages.AmazonShoppingCartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OnlineShoppingPage;

public class AmzRemoveFromCartTest extends BaseTest {
	
	@Test
	public void amzRemoveFromCartTest() {
	OnlineShoppingPage oSp = new OnlineShoppingPage(driver);
	oSp.SignInText(driver);
	oSp.SignInButton();
	
	LoginPage l = new LoginPage(driver);
	l.emailTextBox(DataDriven.getData("Login", 68, 4));
	l.continueButton();
	l.passwordTextBox(DataDriven.getData("Login", 70, 4));
	l.loginButton();
	
	HomePage hp = new HomePage(driver);
	hp.cartButton();
	
	AmazonShoppingCartPage cp = new AmazonShoppingCartPage(driver);
	cp.deleteButton();
	
//	String at = driver.findElement(By.xpath("(//span[@class='sc-product-title'])[1]")).getText();
//	String et = "Samsung Galaxy Note 8 (Midnight Black) was removed from Shopping Cart.";
//	Assert.assertEquals(at, et);

	}
}
