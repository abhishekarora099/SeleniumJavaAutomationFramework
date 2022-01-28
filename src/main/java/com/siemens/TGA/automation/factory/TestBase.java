package com.siemens.TGA.automation.factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.siemens.TGA.automation.utils.Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class TestBase {
	
	public static AndroidDriver driver;
	public static DesiredCapabilities cap;
	public static IOSDriver driver2;
	
	public static String accessKey = "zRioBx47aWanyXP7sq9x";
	  public static String userName = "abhishekarora5";

	
	 public AppiumDriverLocalService getAppiumServiceDefault() {
		
		return AppiumDriverLocalService.buildDefaultService();
		
	}
		
	 AppiumDriverLocalService server = getAppiumServiceDefault();	
	
	
	
	
	@BeforeSuite
	public AndroidDriver initializeDriver() throws MalformedURLException, InterruptedException
	{server.start();
	server.clearOutPutStreams();
	Utility.sleep(5);
	cap = new DesiredCapabilities(); 
	File f = new File("C:/Users/hites/eclipse-workspace3/TGA.automation/src/test/resources/app/app-debug.apk");
	
	switch (DataProviderFactory.getConfigDataProvider().getValue("PlatformName")) {
	case "Android":
	
		/*
		 * cap.setCapability("deviceName", "VirtualDevice"); cap.setCapability("udid",
		 * "192.168.167.101:5555");
		 */
	cap.setCapability("no",true);
	cap.setCapability("newCommandTimeout", 100000);
	cap.setCapability("noRest", true);
	cap.setCapability("automationName", DataProviderFactory.getConfigDataProvider().getValue("androidAutomationName"));
	cap.setCapability("platformName", DataProviderFactory.getConfigDataProvider().getValue("PlatformName"));
	/* cap.setCapability("platformVersion","5.0"); */
	cap.setCapability("platformVersion","7.1.1");
	cap.setCapability("app",f.getAbsolutePath());
	cap.setCapability("avd","Pixel_2_API_25");
	cap.setCapability("avdLaunchTimeout", 300000);
	cap.setCapability("avdReadyTimeout", 300000);
	
	cap.setCapability("clearSystemFiles", true);
	//cap.setCapability("appPackage","com.example.work.thetestingworld");
	cap.setCapability("appPackage", DataProviderFactory.getConfigDataProvider().getValue("androidAppPackage"));
	//cap.setCapability("appActivity","com.example.work.thetestingworld.Splash");
	cap.setCapability("appActivity",DataProviderFactory.getConfigDataProvider().getValue("androidAppActivity"));
	
	cap.setCapability("-session-override", true);
	break;
	
	case "iOS":
		/*
		 * cap.setCapability("deviceName", "VirtualDevice"); cap.setCapability("udid",
		 * "192.168.167.101:5555"); cap.setCapability("no",true);
		 * cap.setCapability("newCommandTimeout", 100000); cap.setCapability("noRest",
		 * true); cap.setCapability("automationName",
		 * DataProviderFactory.getConfigDataProvider().getValue("iOSAutomationName"));
		 * cap.setCapability("platformName",
		 * DataProviderFactory.getConfigDataProvider().getValue("PlatformName"));
		 * cap.setCapability("platformVersion","5.0");
		 * cap.setCapability("app",f.getAbsolutePath());
		 * cap.setCapability("clearSystemFiles", true);
		 */
		/*
		 * //cap.setCapability("appPackage","com.example.work.thetestingworld");
		 * cap.setCapability("appPackage",
		 * DataProviderFactory.getConfigDataProvider().getValue("iOSAppPackage"));
		 * //cap.setCapability("appActivity","com.example.work.thetestingworld.Splash");
		 * cap.setCapability("appActivity",DataProviderFactory.getConfigDataProvider().
		 * getValue("iOSAppActivity"));
		 */
		
		/* cap.setCapability("-session-override", true); */
		
		/* cap.setCapability("appiumVersion", "1.17.1"); */
		
		
		cap.setCapability("deviceName","iPhone 11 Pro");
		cap.setCapability("deviceOrientation", "portrait");
		cap.setCapability("platformVersion","13");
		cap.setCapability("platformName", DataProviderFactory.getConfigDataProvider().getValue("PlatformName"));
		/* cap.setCapability("browserName", ""); */
		cap.setCapability("app","bs://eb9e48ea5963908c723b63f135b84df8cf7112d1");
		
		
		
		
		break;
		
		default:
			System.out.println("Platform name is provided wrong");
			System.exit(0);
	}
		
		
	
	
	return null;
}
	
	@AfterSuite
	public void teardown() {
		driver.quit();
		server.stop();
		
	}
	

}