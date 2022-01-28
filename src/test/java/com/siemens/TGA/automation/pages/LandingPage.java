package com.siemens.TGA.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.siemens.TGA.automation.utils.Utility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;

import org.apache.commons.*;

public class LandingPage {
	
	public AndroidDriver driver;
	public ExtentTest logger;
	
	@AndroidFindBy(className ="android.widget.Image")
	private MobileElement SiemensLogo;

	@AndroidFindBy(className ="android.widget.EditText")
	private MobileElement Username;

	/*
	 * @AndroidFindBy(xpath=
	 * "//android.widget.EditText[@package='com.siemens.tms.truckguidance'][2]")
	 * private MobileElement Password;
	 */

	@AndroidFindBy(className = "android.widget.Button")
	private MobileElement SignIn;
	
	public LandingPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void validateSiemensLogo() {
		Utility.sleep(10);
		Assert.assertTrue(SiemensLogo.isDisplayed());
		
		
	}
	
	public void getUsername(String stringToSend) {
		Utility.sleep(10);
		Utility.sendKeysAction(driver, Username, stringToSend);
	}

	public void getPassword(String stringToSend) {
	List <MobileElement> mylist=driver.findElementsByClassName("android.widget.EditText");
	mylist.get(1).sendKeys("TruckDriver");
	/*
	 * Utility.sleep(10); Utility.sendKeysAction(driver, Password, stringToSend);
	 * driver.fin
	 */
	}

	public void getLogin() {
		Utility.clickAction(driver, SignIn);
		Utility.sleep(10);
	}

}

	
	


