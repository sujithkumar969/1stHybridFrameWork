package com.amazon.scripts;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.genericlib.DataDriven;
import com.amazon.pages.AmazonShoppingCartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OnlineShoppingPage;
import com.amazon.pages.PhonePage;
import com.amazon.pages.SamsungGalaxyNote8Page;

public class AmzAddToCartTest extends BaseTest {
	
	@Test
	public void amzAddToCartTest() {
		
		String userName = DataDriven.getData("Login", 51, 4);
		String passWord = DataDriven.getData("Login", 53, 4);
		String product = DataDriven.getData("Login", 55, 4);
		
	OnlineShoppingPage oSp = new OnlineShoppingPage(driver);
	oSp.SignInText(driver);
	oSp.SignInButton();
	
	LoginPage l = new LoginPage(driver);
	l.emailTextBox(userName);
	l.continueButton();
	l.passwordTextBox(passWord);
	l.loginButton();
	
	HomePage h = new HomePage(driver);
	h.SearchTextBox(product);
	h.SearchButton();
	
	PhonePage ph = new PhonePage(driver);
	ph.phoneImage();
	
    String mainWindow = driver.getWindowHandle();   //Doubt: how to create function for switching b/w windows //
    Set<String> wlist = driver.getWindowHandles();
    Iterator<String> s1 = wlist.iterator(); 
    while(s1.hasNext()) {
    	String childWindow = s1.next();
    	if(!childWindow.equalsIgnoreCase(mainWindow)) {   		
    		driver.switchTo().window(childWindow);
    	}	
    }
	
	SamsungGalaxyNote8Page note8 = new SamsungGalaxyNote8Page(driver);
	note8.addToCartButton();
	
	AmazonShoppingCartPage cart = new AmazonShoppingCartPage(driver);
	String actualMsg = cart.addedToCartMsg();
	String expectedMsg = DataDriven.getData("Login", 59, 4);
	Assert.assertEquals(actualMsg, expectedMsg);
	cart.cartButton(driver);
	String actualProductName = cart.phoneText();
	String expectedProductName = DataDriven.getData("Login", 61, 4);;
	Assert.assertEquals(actualProductName, expectedProductName);

	SamsungGalaxyNote8Page gn8 = new SamsungGalaxyNote8Page(driver);
	gn8.signText(driver);
	gn8.signOutLink();
	
	driver.close();                       // close child window //
	
	driver.switchTo().window(mainWindow);
//	driver.switchTo().defaultContent();
	gn8.signText(driver);
	gn8.signOutLink();
  }
}