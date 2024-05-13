package org.example.testComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    int count = 0;
    int MaxCount = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {

        if(count<MaxCount){
            count++;
            return true;
        }

        return false;
    }
}
