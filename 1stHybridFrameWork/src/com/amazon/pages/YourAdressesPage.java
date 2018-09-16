package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.genericlib.BasePage;
import com.amazon.genericlib.DataDriven;
import com.amazon.genericlib.DriverUtils;
import com.amazon.genericlib.LogUtils;

public class YourAdressesPage extends BasePage {
	
	@FindBy(xpath="//div[@class='a-box-inner a-padding-extra-large']")
	private WebElement eleAddAddressesButton;
	
	@FindBy(id="address-ui-widgets-countryCode-dropdown-nativeId")
	private WebElement eleCountryRegionDropDown;
	
	@FindBy(id="address-ui-widgets-enterAddressFullName")
	private WebElement eleFullNameTextField;
	
	@FindBy(id="address-ui-widgets-enterAddressPhoneNumber")
	private WebElement eleMobileNumberTextField;
	
	@FindBy(id="address-ui-widgets-enterAddressPostalCode")
	private WebElement elePincodeTextField;
	
	@FindBy(id="address-ui-widgets-enterAddressLine1")
	private WebElement eleStreetAddressTextField1;
	
	@FindBy(id="address-ui-widgets-enterAddressLine2")
	private WebElement eleStreetAddressTextField2;
	
	@FindBy(id="address-ui-widgets-landmark")
	private WebElement eleLandmarkTextField;
	
	@FindBy(id="address-ui-widgets-enterAddressCity")
	private WebElement eleCityTextField;
	
	@FindBy(id="address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")
	private WebElement eleStateDropDown;
	
	@FindBy(name="address-ui-widgets-addr-details-address-type")
	private WebElement eleSelectAnAddressTypeDropDown;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	private WebElement eleAddAddressButton;
	
	@FindBy(xpath="//h4[.='Address saved']")
	private WebElement eleAddressSavedTextMsg;
	
	@FindBy(id="ya-myab-address-delete-btn-1")
	private WebElement eleDeleteLinkOfAddress;
	
	@FindBy(xpath="//h4[.='Address deleted']")
	private WebElement eleAddressDeletedTextMsg;
	
	@FindBy(id="deleteAddressModal-1-submit-btn")
	private WebElement eleYesButtonOfAlertPopUp;
	
	public YourAdressesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addAddressesButton() {
		eleAddAddressesButton.click();
		LogUtils.info("Clicked on Add Address button");
	}
	
	public void countryRegionDropDown(String option){
		DriverUtils.dropDownWebElement(eleCountryRegionDropDown, "byVisibleText", option);
		LogUtils.info("Selected Country from drop down");
	}
	
	public void fullNameTextField(String fullName) {
		eleFullNameTextField.sendKeys(fullName);
		LogUtils.info("Entered full name");
	}
	
	public void mobileNumberTextField(String mobileNo) {
		eleMobileNumberTextField.sendKeys(DataDriven.toIntegerFormat(mobileNo));
		LogUtils.info("Entered phone number");
	}
	
	public void pincodeTextField(String pinCode) {
		elePincodeTextField.sendKeys(DataDriven.toIntegerFormat(pinCode));
		LogUtils.info("Entered pin code");
	}
	
	public void streetAddressTextField1(String address1) {
		eleStreetAddressTextField1.sendKeys(address1);
		LogUtils.info("Entered address1");
	}
	
	public void streetAddressTextField2(String address2) {
		eleStreetAddressTextField2.sendKeys(address2);
		LogUtils.info("Entered address2");
	}
	
	public void landmarkTextField(String landMark) {
		eleLandmarkTextField.sendKeys(landMark);
		LogUtils.info("Entered land mark");
	}
	
	public void cityTextField(String city) {
		eleCityTextField.sendKeys(city);
		LogUtils.info("Selected City from drop down");
	}
	
	public void stateDropDown(String state) {
		DriverUtils.dropDownWebElement(eleStateDropDown, "byVisibleText", state);
		LogUtils.info("Selected State from drop down");
	}
	
	public void anAddressTypeDropDown(String addressType) {
		DriverUtils.dropDownWebElement(eleSelectAnAddressTypeDropDown, "byVisibleText", addressType);
		LogUtils.info("Selected address type");
	}
	
	public void addAddressButton() {
		eleAddAddressButton.click();
		LogUtils.info("Clicked on add address button");
	}
	
	public String addressSavedTextMsg() {
		String text = eleAddressSavedTextMsg.getText();
		LogUtils.info("Got address saved text message");
		return text;
	}
	
	public void deleteLinkOfAddress() {
		eleDeleteLinkOfAddress.click();
		LogUtils.info("Clicked on delete link of address");
	}
	
	public void yesButtonOfAlertPopUp() {
		eleYesButtonOfAlertPopUp.click();
		LogUtils.info("Clicked on yes button of alert popup");
	}
	
	public String addressDeletedTextMsg() {
		String del = eleAddressDeletedTextMsg.getText();
		LogUtils.info("Got Address Deleted Text message");
		return del;
		
	}

}
