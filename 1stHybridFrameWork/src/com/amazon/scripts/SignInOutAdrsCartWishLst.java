package com.amazon.scripts;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.genericlib.DataDriven;
import com.amazon.pages.AmazonShoppingCartPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OnlineShoppingPage;
import com.amazon.pages.PhonePage;
import com.amazon.pages.SamsungGalaxyNote8Page;
import com.amazon.pages.WishListPage;
import com.amazon.pages.YourAccountPage;
import com.amazon.pages.YourAdressesPage;

public class SignInOutAdrsCartWishLst extends BaseTest {        // Grouping in testNG //
	
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
	
	@Test(groups="add")
	public void amzAddAddressTest() {
	OnlineShoppingPage oSp = new OnlineShoppingPage(driver);
	oSp.SignInText(driver);
	oSp.SignInButton();
	
	LoginPage l = new LoginPage(driver);
	l.emailTextBox(DataDriven.getData("Login", 25, 4));
	l.continueButton();
	l.passwordTextBox(DataDriven.getData("Login", 27, 4));
	l.loginButton();
	
	HomePage hm = new HomePage(driver);
	hm.signInText(driver);
	hm.yourAccountLink();
	
	YourAccountPage acnt = new YourAccountPage(driver);
	acnt.yourAddressesButton();
	
	YourAdressesPage addr = new YourAdressesPage(driver);
	addr.addAddressesButton();
	addr.countryRegionDropDown(DataDriven.getData("Login", 34, 4));
	addr.fullNameTextField(DataDriven.getData("Login", 35, 4));
	addr.mobileNumberTextField(DataDriven.getData("Login", 36, 4));
	addr.pincodeTextField(DataDriven.getData("Login", 37, 4));
	addr.streetAddressTextField1(DataDriven.getData("Login", 38, 4));
	addr.streetAddressTextField2(DataDriven.getData("Login", 39, 4));
	addr.landmarkTextField(DataDriven.getData("Login", 40, 4));
	addr.cityTextField(DataDriven.getData("Login", 41, 4));
	addr.stateDropDown(DataDriven.getData("Login", 42, 4));
	addr.anAddressTypeDropDown(DataDriven.getData("Login", 43, 4));
	addr.addAddressButton();
	String expConfirmMessage = DataDriven.getData("Login", 45, 4);
	assertEquals(addr.addressSavedTextMsg(), expConfirmMessage);
}
	@Test (groups="delete")
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
	@Test(groups="add")
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
	
	@Test(groups="delete")
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
	
	@Test(groups="add")
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
	
	@Test(groups="delete")
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
	}

}
