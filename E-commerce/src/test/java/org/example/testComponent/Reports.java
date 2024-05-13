package org.example.testComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;

public class Reports {



    public static ExtentReports ReportObject(){
        String path = System.getProperty("user.dir") + "//Reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("bebo report");
        reporter.config().setDocumentTitle("Reports");
        ExtentReports extent = new ExtentReports();

        extent.attachReporter(reporter);
        extent.setSystemInfo("tester", "bebo");
        return extent;
    }











}
