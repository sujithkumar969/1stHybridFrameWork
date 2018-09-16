package com.amazon.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest implements AutoConstants {
	
	public WebDriver driver;
	public static ExtentReports extentReport;
	public static ExtentTest test;
	public static List<String> ssPath = null;
	public static FileInputStream fs;
	public static Properties props;
	public static Logger loggerObject = Logger.getLogger(BaseTest.class);    // configure :- log4j //
//	public EventFiringWebDriver eventDriver;
//	public WebEventListener eventListener;
		
	@BeforeSuite
	public void initialisation() {
		
		ssPath = new ArrayList<String>();
		extentReport = new ExtentReports(reportPath);
	    
	    try {
	    	fs = new FileInputStream(propfilePath);
			props = new Properties();
			try {
				props.load(fs);
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propfilePath);
		}
//	    eventDriver = new EventFiringWebDriver(driver);
//	    eventListener = new WebEventListener();
//	    eventDriver.register(eventListener);
//	    driver = eventDriver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void preCondition(Method testName, XmlTest xmlTest) {
		
		String driverType = xmlTest.getParameter("browser");
		driver = DriverUtils.getWebDriver(driverType);
		String name = testName.getName();
		
		String url = DataDriven.getData("OHRM", 3, 4);
		driver.get(url);
		test = LogUtils.startTestCase(name, "Test Suite Execution Started");
	}
	
	@AfterMethod(alwaysRun=true)
	public void postCondition(ITestResult testResult) {
		
		String testName = testResult.getName();
		int testStatus = testResult.getStatus();
		
		if(testStatus == 2) {                          // 2 is failure, 1 is success, 3 is skip //
			String Path = LibraryUtils.getScreenShot(driver, screenShotDirectory, testName);	
			ssPath.add(Path);
			String imagePath = test.addScreenCapture(Path);
            LogUtils.testFail("Test is Failed", imagePath);
		}
		else if (testStatus == 1) {
			LogUtils.testPass("Test is Passed");
		}
		else if (testStatus == 3) {
			LogUtils.testSkip("Test is Skipped");
		}		
		LogUtils.endTestCase("TestCase Execution Completed for : "+testName);
//	    eventDriver.unregister(eventListener);
		driver.quit();
	}
	 
	@AfterSuite
	public void tearDown() {
		
		int smtpPortNo = Integer.parseInt(props.getProperty("smtpPortNo"));
		Boolean SSLOnConet = Boolean.parseBoolean(props.getProperty("SSLOnConet"));		
		extentReport.flush();
		try{			
			LibraryUtils.sendReportByGMail(props.getProperty("hostName"), props.getProperty("fromAddress"), 
			props.getProperty("fromPassword"), SSLOnConet, smtpPortNo, props.getProperty("fromText"), props.getProperty("emailSubject"), 
			props.getProperty("emailBody"), props.getProperty("toAddress1"));
			
			LogUtils.info("Email Successfully Sent with Attachments");
		//	System.out.println("Email Successfully Sent with Attachments");
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}
