package com.siemens.TGA.automation.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.siemens.TGA.automation.factory.DataProviderFactory;
import com.siemens.TGA.automation.factory.TestInitilizer;
import com.siemens.TGA.automation.pages.LandingPage;
import com.siemens.TGA.automation.utils.Utility;


@Listeners(com.siemens.TGA.automation.factory.TestListeners.class)
public class AllTests extends TestInitilizer {
	
	ExtentTest extentTest;

	@BeforeMethod
	public void extentLoggerInitializer(Method method) {
		extentTest = report.createTest(method.getName());
	}
	
    @Test(enabled=true, priority=0)
   
    public void testLogin() throws IOException {
		loginTGA();
		extentTest.log(Status.PASS, "Login done successfully"); 
		LandingPage landingPage= new LandingPage(driver);
		landingPage.validateSiemensLogo();
		extentTest.log(Status.PASS, "Siemens Logo is displaying on Home Page"); 
		
}
    
    
    @Test(enabled=false, priority=0)
    public void test2() throws IOException {
    	
    	driver.findElementById("io.selendroid.testapp:id/my_text_field").sendKeys("abcd");
		driver.findElementById("io.selendroid.testapp:id/waitingButtonTest").click();
    	
    	
    }
    
    
    
    
    @AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
			//System.out.println("Failed test method is " + result.getName());
			extentTest.log(Status.FAIL, "Test " + result.getName() + " has been failed");
			extentTest.log(Status.DEBUG, result.getThrowable());
			extentTest.addScreenCaptureFromPath(Utility.takeScreenshot(driver));
		}
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

    
    

	private void loginTGA() {
		LandingPage landingPage= new LandingPage(driver);
		landingPage.getUsername(DataProviderFactory.getConfigDataProvider().getValue("username"));
		landingPage.getPassword(DataProviderFactory.getConfigDataProvider().getValue("password"));
		landingPage.getLogin();
		
		
		
	}}
