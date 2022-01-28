package com.siemens.TGA.automation.factory;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class TestInitilizer extends TestBase {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports report;
	public ExtentTest testExtentTest;
	
	@BeforeTest
	public void testInitialize() throws IOException {
		//System.out.println("Inside testinitializer");
		
		report = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/Report.html");
		report.attachReporter(htmlReporter);
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("TGA Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		
		//driver.get("https://www.google.co.in");
		if (DataProviderFactory.getConfigDataProvider().getValue("PlatformName").equals("Android"))
		{
		driver = new AndroidDriver(new URL(DataProviderFactory.getConfigDataProvider().getValue("appiumURL")),cap);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		
		else
		{
			/*
			 * driver2 = new IOSDriver(new
			 * URL(DataProviderFactory.getConfigDataProvider().getValue("appiumURL")),cap);
			 */
			driver2= new IOSDriver(new URL("http://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), cap);
			driver2.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);


		    driver.quit();
		  }
		}

			
	
	
	
	@AfterTest
	public void testClosure() {
		report.flush();
	}

	



}
