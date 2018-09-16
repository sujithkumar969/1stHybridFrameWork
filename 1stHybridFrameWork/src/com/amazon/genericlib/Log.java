package com.amazon.genericlib;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;


public class Log implements ITestListener {
	
	public WebDriver driver;
	
	@Override                                     // don't use extent reports methods ex: test.log(), test.addscreenCapture() //
	public void onFinish(ITestContext arg0) {}    // don't put Assert.assertfail(); //
	@Override
	public void onStart(ITestContext arg0) {}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {}
	
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getName();
		Reporter.log("Executing "+"'"+name+"'"+"....", true);	
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		Reporter.log("'"+name+"'"+" is Passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		Reporter.log("'"+testName+"'"+" is Failed", true);
//		test.log(LogStatus.FAIL, "Test is Failed");
//		String path = getScreenShot(driver, screenShotDirectory, testName);
//		test.addScreenCapture(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		Reporter.log("'"+name+"'"+" is Skipped", true);
	}

}
