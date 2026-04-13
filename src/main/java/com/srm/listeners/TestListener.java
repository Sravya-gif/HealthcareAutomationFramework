package com.srm.listeners;

import org.testng.*;

import com.aventstack.extentreports.*;
import com.srm.utils.*;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
        System.out.println(" STARTED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed ");
        System.out.println("PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String path = ScreenshotUtil.capture(result.getName());

        test.fail("Test Failed");
        test.fail(result.getThrowable());

        System.out.println(" FAILED: " + result.getName());

        try {
            test.addScreenCaptureFromPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();

        System.out.println("ALL TESTS EXECUTED");
         
    }
}