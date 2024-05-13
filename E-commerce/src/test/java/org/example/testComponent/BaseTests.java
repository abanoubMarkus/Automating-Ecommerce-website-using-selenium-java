package org.example.testComponent;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseTests {


    public WebDriver InitializeBrowser(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }


    public WebDriver driver = InitializeBrowser();





    public String TakeScreenShot(String TestCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+ "//reports//"+TestCaseName+ ".png");

        FileUtils.copyFile(source, file);

        return System.getProperty("user.dir")+ "//reports//"+TestCaseName+ ".png";

    }





}
