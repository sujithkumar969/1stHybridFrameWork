package com.amazon.genericlib;

import java.io.File;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

public class LibraryUtils implements AutoConstants {
	
	/*
	 * method to take screen shot
	 */
    public static String getScreenShot(WebDriver driver, String directory, String fileName) {
		
		String screenShotPath = null;
		try {
		screenShotPath = directory+fileName+getCurrentDateAndTime()+".png";	
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(screenShotPath));	
		} 
		catch (Exception e) {
			Reporter.log("photo is not taken");
			}
		return screenShotPath;
	}
	
	/*
	 * method to return date & time 
	 */
	public static String getCurrentDateAndTime(){
		Date date = new Date();
	    // display date and time using toString()
		//date.toString();                                                              //  Wed Jul 11 04:34:40 IST 2018  //
		String date1 = date.toString().replaceAll(" ", "_").replaceAll(":", "_");     //  Wed_Jul_11_04_34_40_IST_2018  //
		//String date1 = date.toString().replaceAll(" ", "_");                            //  Wed_Jul_11_04:34:40_IST_2018  //
	    return date1;	    
	}

	 // method to send the email
	/**
	 * 
	 * @param hostName
	 * @param fromAddress
	 * @param fromPassword
	 * @param SSLOnConet
	 * @param smtpPortNo
	 * @param fromText
	 * @param emailSubject
	 * @param emailBody
	 * @param toAddress
	 * @throws EmailException
	 */
    public static void sendReportByGMail(String hostName, String fromAddress, 
    		String fromPassword, Boolean SSLOnConet, int smtpPortNo, String fromText, String emailSubject,
    		String emailBody, String... toAddress ) throws EmailException {
		
    	String ssName = null;

		// To setup "from - to" email address, email messages //
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(hostName);
	    email.setAuthenticator(new DefaultAuthenticator(fromAddress, fromPassword));
		email.setSSLOnConnect(SSLOnConet);
		email.setSmtpPort(smtpPortNo);
		email.setFrom(fromAddress, fromText);
		email.setSubject(emailSubject);
		email.setMsg(emailBody); 
		  if(toAddress.length==0){
			  email.addTo("aru03.info@gmail.com");
		  }else{
			  email.addTo(toAddress);
		  }
 
		// To setup attachment //
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(reportPath);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("TEST EXECUTION REPORT");
		attachment.setName("Automation Execution Report" + getCurrentDateAndTime() + ".html");
		
		// To add the attachment(extent report) //		
		email.attach(attachment);
		
		// To add the attachment(multiple screen shots) //
//		if(BaseTest.ssPath != null){
//			  Iterator<String>  it = BaseTest.ssPath.iterator();		  
//			  while(it.hasNext()){
//				  	ssName = it.next();
//				  	email.attach(new File(ssName));
//			  }
//		  }
		if(BaseTest.ssPath != null){
			for(int ix=0; ix<BaseTest.ssPath.size(); ix++) {
				email.attach(new File(BaseTest.ssPath.get(ix)));
			}
		}
	
		// To send email //
		email.send();
	}
  }