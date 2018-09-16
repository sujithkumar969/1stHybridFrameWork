package com.amazon.genericlib;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
/*
public class WebEventListener extends BaseTest  implements WebDriverEventListener {

	@Override // called after accept.accept() //
	public void afterAlertAccept(WebDriver driver) {
		System.out.println("Alert is Accepted ");
		
	}

	@Override // called after accept.dismiss() //
	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("Alert is Cancelled ");
		
	}

	@Override  // called after webelement.clear or webelement.sendkeys() methods //
	public void afterChangeValueOf(WebElement targetElement, WebDriver driver, CharSequence[] data) {
		System.out.println("Entered "+data+" into the WebElement : " + targetElement);
		
	}

	@Override // called after webelement.click() //
	public void afterClickOn(WebElement targetElement, WebDriver driver) {
		System.out.println("Clicked on WebElement : " + targetElement);
		
	}

	@Override // called after webelement.findElement() or webelement.findElements() //
	public void afterFindBy(By by, WebElement targetElement, WebDriver driver) {
		System.out.println("Found the WebElement : " + targetElement + "By : " + by);
		
	}

	@Override // Called after TakesScreenshot.getScreenshotAs(OutputType) //
	public <X> void afterGetScreenshotAs(OutputType<X> Type, X arg1) {
		System.out.println("took screenshot as :"+Type);
		
	}

	@Override // Called right after WebElement.getText() //
	public void afterGetText(WebElement tagretElement, WebDriver driver, String text) {
		System.out.println("Found "+text+" from "+tagretElement);
		
	}

	@Override // called after navigate().back() //
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Successfully Navigated Back");
		
	}

	@Override // called after navigate().forward() //
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Successfully Navigated Forward");
		
	}

	@Override // called after navigate().refresh() //
	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("Successfully Refreshed");
		
	}

	@Override // called after driver.get(url) or navigate().to() // 
	public void afterNavigateTo(String URL, WebDriver driver) {
		System.out.println("Successfully Navigated to : " + URL);
		
	}

	@Override // Called after RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[]) //
	public void afterScript(String script, WebDriver driver) {
		System.out.println("Script Executed Successfully " + script);
		
	}

	@Override // This action will be performed each time after WebDriver.TargetLocator.window(java.lang.String) //
	public void afterSwitchToWindow(String window, WebDriver driver) {
		System.out.println("Successfully Switched to " + window);
		
	}

	@Override // action will be performed each time before Alert.accept() //
	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Trying to Accept Alert");
		
	}

	@Override // action will be performed each time after Alert.dismiss() //
	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Trying to Cancel Alert");
		
	}

	@Override // Called before WebElement.clear(), WebElement.sendKeys(...) //
	public void beforeChangeValueOf(WebElement targetElement, WebDriver driver, CharSequence[] text) {
		System.out.println("Trying to Enter " + text + " at " + targetElement);
		
	}

	@Override // Called before WebElement.click() //
	public void beforeClickOn(WebElement targetElement, WebDriver driver) {
		System.out.println("Trying to Click on " + targetElement);
		
	}

	@Override // Called before WebDriver.findElement(...), or WebDriver.findElements(...) //
	public void beforeFindBy(By by, WebElement targetElement, WebDriver driver) {
		System.out.println("Trying to Find : " + targetElement + " By :" + by);
		
	}

	@Override // Called before TakesScreenshot.getScreenshotAs(OutputType) //
	public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
		System.out.println("Trying to take screenshot type as " + outputType);
		
	}

	@Override // Called before WebElement.getText() //
	public void beforeGetText(WebElement targetElement, WebDriver driver) {
		System.out.println("Trying to get Text from webElement : "+targetElement);
		
	}

	@Override // Called before navigate().back() //
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Trying to Navigate Back");
		
	}

	@Override // Called before navigate().forward() //
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Trying to Navigate Forward");
		
	}

	@Override // Called before navigate().refresh() //
	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Trying to Refresh");
		
	}

	@Override // Called before get(String url) respectively navigate().to(String url) //
	public void beforeNavigateTo(String URL, WebDriver driver) {
		System.out.println("Trying to Navigate at : " + URL);
		
	}

	@Override // Called before RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[]) //
	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Trying to excute script : " + script);
		
	}

	@Override // action will be performed each time before WebDriver.TargetLocator.window(java.lang.String) //
	public void beforeSwitchToWindow(String window, WebDriver driver) {
		System.out.println("Trying to switch to window : " + window);
		
	}

	@Override // for all exceptions, this method will be called // 
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception Occured Like: " + error);
		
	}
} */
