package com.amazon.genericlib;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Function;

public class DriverUtils implements AutoConstants {
		
		// method to validate text on screen > text comparison on screen //
		/**
		 * 
		 * @param element
		 * @param expectedTextOnScreen
		 */
		public static void validateTextOnScreen(WebDriver driver, WebElement targetElement, String expectedTextOnScreen) {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.visibilityOf(targetElement));
			String actualTextOnScreen = targetElement.getText();
			if(expectedTextOnScreen == actualTextOnScreen) {
				System.out.println("PASS : Text on the screen is matched");
			}
			else{
				System.out.println("FAILED : Text on the screen is not matched");
			}		
		}
	
	// method to get clickable element //
	/**
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement getClickableElementOnScreen(WebDriver driver, WebElement element) {
		try {
		    WebDriverWait wait = new WebDriverWait(driver, 120);
            wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e) {
			System.out.println("Get clickable Element -- "+e.getMessage());
	//		Log.writeToFailFile(e.toString());
		}
		return element;
	}
	
	// method to get web element on screen using - webdriver wait //
	/**
	 * 
	 * @param element
	 */
	public static WebElement getvisibilityOfElementOnScreen(WebDriver driver, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 160);
            wait.until(ExpectedConditions.visibilityOf(element));
		} 
		catch (Exception e) {
			System.out.println("Get Element on Screen -- "+e.getMessage());
	//		Log.writeToFailFile(e.toString());			
		}
		return element;
	}
	
	// method to get web element on screen using - fluent wait //
	/**
	 * 
	 * @param element
	 */
	public static void getFluentVisibleElementOnScreen(WebElement element){

		FluentWait<WebElement> fWait = new FluentWait<WebElement>(element)
				
				.withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofMillis(100))
				.ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);
		
		fWait.until(new Function<WebElement, Boolean>() {
			
			public Boolean apply(WebElement element) {
				System.out.println("****waiting for element - " + element.getText());
				
				if(element.isDisplayed()) {
					System.out.println("element found...");
						return true;
				}
				else
					System.out.println("element not found...");
					return false;
			    }			
		});		
		System.out.println("wait ended");		
	}
	
//-----------------------------------------------------------------------------------------------------------------//

	// function to perform mouse over action over the elements //
	/**
	 * 
	 * @param driver
	 * @param targetElement
	 */
    public static void action(WebDriver driver, WebElement targetElement) {
		
		try {
		Actions a = new Actions(driver);
		a.moveToElement(targetElement).perform();
		}
		catch (Exception e) {
			Reporter.log("action not performed");
		}
	}
	
	// function to get web page title //
    /**
     * 
     * @param driver
     * @return
     */
	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	// function to press enter button in keyboard //
	/**
	 * 
	 * @param targetElement
	 */
	public static void pressEnterButton(WebElement targetElement) {
		targetElement.sendKeys(Keys.ENTER);
	}

	// function to switch to alert popup & perform actions //
	/**
	 * 
	 * @param driver
	 * @param keyAction
	 */
	public static void actionsOnAlertPopUp(WebDriver driver, String keyAction) {
		
		switch (keyAction) {
		
		case "getTextMsg":
			driver.switchTo().alert().getText();
			break;
	
		case "Ok":
			driver.switchTo().alert().accept();
			break;
			
		case "Cancel":
			driver.switchTo().alert().dismiss();
			break;

		default:
			System.out.println("no action performed on alert popup");
			break;
		}
	}

	 // function to send text message to textbox field of alert popup //
	/**
	 * 
	 * @param driver
	 * @param textMsg
	 */
	public static void sendTextToAlertPopUp(WebDriver driver, String textMsg) {
		
		driver.switchTo().alert().sendKeys(textMsg);
	}

	// function to return respective browser driver //
	/**
	 * 
	 * @param type
	 * @return
	 */
	public static WebDriver getWebDriver(String type) {
		
		WebDriver driver = null;

		System.out.println("Creating a Driver with " + type);
		
		switch(type) {
		
		case "ff" :
			System.out.println("Creating Firefox driver..");
			System.setProperty(ff_key, ff_value);
			driver = new FirefoxDriver();
			break;
		case "ie" :   // IE driver will not work //
			System.out.println("Creating IE Driver ...");
			System.setProperty("webdriver.ie.driver", "C:\\seleniumBatch15\\drivers\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "chrome" :
			System.out.println("Creating chrome Driver...");
			System.setProperty(ch_key, ch_value);
			driver = new ChromeDriver();
			break;
		
			default :
				System.out.println("No matching driver available..");
				driver = null;		
		}
		System.out.println("****Maximizing the driver/Browser ");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("returning webdriver to test");
		return driver;		
	}
	
	// method to handle the drop down //
	/**
	 * 
	 * @param element
	 * @param type
	 * @param value
	 */
	public static void dropDownWebElement(WebElement targetElement, String type, String value) {
		Select sel = new Select(targetElement);
		
		switch (type) {
		
		case "byValue" :
			sel.selectByValue(value);
			break;
			
		case "byIndex" :
			sel.selectByIndex(Integer.valueOf(value));
			break;
			
		case "byVisibleText" :
			sel.selectByVisibleText(value);
			break;

		}
	}
	
	// method to select or deselect the checkbox //
	/**
	 * 
	 * @param element
	 * @param flag -- if flag is "true" -> selecting checkbox.
	 *                if flag is "false" -> deselecting checkbox.
	 */
	public static void checkBoxWebElement(WebDriver driver, WebElement targetElement, String flag) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(targetElement));
		
		switch (flag) {
		case "true":
			if(targetElement.isSelected()) {
				System.out.println("checkbox is already selected");
			}
			else {
				System.out.println("****selecting checkbox");
				targetElement.click();
			}
			break;
			
		case "false":
			if(targetElement.isSelected()) {
				System.out.println("****deselecting checkbox");
				targetElement.click();
			}
			else {
				System.out.println("checkbox is already not selected");
			}
			
			break;
		default:
			System.out.println("on action performed on check box");
		}
	}
}