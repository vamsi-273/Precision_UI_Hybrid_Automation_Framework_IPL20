package com.ipl.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    public void onTestStart(ITestResult result){
        test = extent.createTest(result.getName());
    }
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed...");
    }

    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed...");
        test.fail(result.getThrowable());
    }

    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped...");
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
