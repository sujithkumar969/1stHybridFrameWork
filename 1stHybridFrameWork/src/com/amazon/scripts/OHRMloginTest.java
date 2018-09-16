package com.amazon.scripts;

import org.testng.annotations.Test;

import com.amazon.genericlib.BaseTest;
import com.amazon.pages.OHRMLoginPage;
import com.amazon.pages.OHRMdashBoardPage;

public class OHRMloginTest extends BaseTest {
	
	@Test
	public void ohrmloginTest() {
		
		OHRMLoginPage lp = new OHRMLoginPage(driver);
		lp.enterUserName();
		lp.enterPassword();
		lp.clickOnLoginButton();
		
		OHRMdashBoardPage dbp = new OHRMdashBoardPage(driver);
		dbp.validateDashboardText();
		dbp.clickOnWelcomeLink();
		dbp.clickOnLogoutLink();
	}

}
