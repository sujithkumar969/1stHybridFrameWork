package com.amazon.scripts;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.genericlib.DataDriven;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OnlineShoppingPage;
import com.amazon.pages.PhonePage;
import com.amazon.pages.SamsungGalaxyNote8Page;
import com.amazon.pages.WishListPage;

public class AmzAddToWishListTest extends BaseTest {
	
	@Test
	public void amzAddToWishListTest() throws InterruptedException {
	OnlineShoppingPage oSp = new OnlineShoppingPage(driver);
	oSp.SignInText(driver);
	oSp.SignInButton();
	
	LoginPage l = new LoginPage(driver);
	l.emailTextBox(DataDriven.getData("Login", 82, 4));
	l.continueButton();
	l.passwordTextBox(DataDriven.getData("Login", 84, 4));
	l.loginButton();
	
	HomePage h = new HomePage(driver);
	h.SearchTextBox(DataDriven.getData("Login", 86, 4));
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
    note8.addToWishListButton(driver);                                        // sometime works //
    
    WishListPage wis = new WishListPage(driver);
    wis.viewWishListButton(driver);
    String actualText = wis.phoneImageText();
    String expectedText = DataDriven.getData("Login", 91, 4);
    Assert.assertEquals(actualText, expectedText);
    wis.signText(driver);
    wis.signOutLink();
    driver.close();
    
    driver.switchTo().window(mainWindow);
    
    note8.signText(driver);
    note8.signOutLink();
    
	}
}
