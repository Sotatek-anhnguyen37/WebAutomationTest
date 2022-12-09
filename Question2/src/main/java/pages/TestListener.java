package pages;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        System.out.println("testcase test filed but within success percentage");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test FAILED: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test SKIPPER");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test STARTED: " + result.getName());
        System.out.println("Test class STARTED: " + result.getTestClass().getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test stop with SUCCESS: " + result.getName());
    }
}


