package api.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(ExtentListener.class);

    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

        logger.info("Test Suite Started : {}", context.getName());

        extent = ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {

        logger.info("Test Started : {}", result.getMethod().getMethodName());

        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("Test Passed : {}", result.getMethod().getMethodName());

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("Test Failed : {}", result.getMethod().getMethodName());

        logger.error("Failure Reason", result.getThrowable());

        test.fail(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {

        logger.info("Test Suite Finished : {}", context.getName());

        extent.flush();
    }
}