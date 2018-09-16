package com.amazon.scripts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.genericlib.DataDriven;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.OnlineShoppingPage;
import com.amazon.pages.YourAccountPage;
import com.amazon.pages.YourAdressesPage;

public class AmzAddAddressTest extends BaseTest {
	
	@Test
	public void amzAddressTest() {
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
}
