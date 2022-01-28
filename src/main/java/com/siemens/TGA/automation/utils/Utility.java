package com.siemens.TGA.automation.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.support.ui.Wait;

import com.google.common.io.Files;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Utility {
	
	static MobileElement element;
	
	public static String takeScreenshot(AndroidDriver driver) throws IOException {
		String snapshotPath = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";

		File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(src, new File(snapshotPath));
		} catch (IOException e) {
		}
		return snapshotPath;
	}

	public static void sleep(int tSeconds) {
		try {
			Thread.sleep(tSeconds * 1000);
		} catch (InterruptedException e) {
		}
	}

	public static MobileElement checkElement(AndroidDriver driver, MobileElement element) {
		Wait<AndroidDriver> wait = new FluentWait<AndroidDriver>(driver).withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		/*
		 * element = wait.until(new Function<WebDriver, WebElement>(){ public WebElement
		 * apply(WebDriver driver) { return element; } });
		 */
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public static void clickAction(AndroidDriver driver, MobileElement element) {
		checkElement(driver, element).click();
	}

	public static void sendKeysAction(AndroidDriver driver, MobileElement element, String stringToSend) {
		checkElement(driver, element).sendKeys(stringToSend);
	}
}
