package com.conduit.qa.listener;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.conduit.qa.baseclass.BaseClass;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends BaseClass implements ITestListener {

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentReports.attachReporter(sparkReporter);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentReports.attachReporter(sparkReporter);
        test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
        extentReports.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentReports.attachReporter(sparkReporter);
        test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());

        // Capture Screenshot
        try {
            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        extentReports.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentReports.attachReporter(sparkReporter);
        test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        extentReports.flush();
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onFinish(ITestContext context) {
        //extentReports.flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    private String captureScreenshot(String methodName) throws IOException {
        // Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        // Call getScreenshotAs method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        // Define the destination file path
        String destFilePath = "screenshots/" + methodName + "_screenshot.png";

        // Create destination directory if it doesn't exist
        File destFile = new File(destFilePath);
        FileUtils.copyFile(srcFile, destFile);

        return destFilePath;
    }

}
