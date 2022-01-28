package com.siemens.TGA.automation.factory;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListeners extends TestBase implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("onStart -->> " + context.getName());
	}
	
	public void onTestStart(ITestResult result) {
		 System.out.println("onTestStart -->> " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		 System.out.println("onTestSuccess -->> " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		/*
		 * result.getName(); try { Utility.takeScreenshot(result.getName()); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
		 System.out.println("onTestFailure -->> " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped -->> " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage -->> " + result.getName());
	}

	

	public void onFinish(ITestContext context) {
		System.out.println("onFinish -->> " + context.getName());
	}

}
