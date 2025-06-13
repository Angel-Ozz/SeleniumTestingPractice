package testng;

//ITestListener which implements testng listeners


import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED: " + result.getName());
    }
}
