package org.example.testComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class listeners extends BaseTests implements ITestListener {


    ExtentReports extent = Reports.ReportObject();
    ExtentTest test ;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "passed");
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        String filePath;



        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        try {
            filePath = TakeScreenShot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
        System.out.println("Test Failed: " + result.getName());
        
        



        
    }

    //@Override
    public void onTestSkip(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This method is relevant if you're using successPercentage in your test configuration.
        // Handle failures within the allowed percentage here (optional).
    }

    //@Override
    public void onTestStart(ITestContext context) {
        System.out.println("Suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        System.out.println("Suite finished: " + context.getName());
    }








}
