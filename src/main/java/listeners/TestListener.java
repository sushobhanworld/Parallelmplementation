package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import factories.ExtentFactory;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReporting;
import utility.TakeSnapshot;

public class TestListener implements ITestListener
{
    static ExtentReports reports;
    ExtentTest extentTest;
    TakeSnapshot takeSnapshot= new TakeSnapshot();
    @Override
    public void onTestStart(ITestResult result) {
        extentTest= reports.createTest(result.getMethod().getMethodName());
        //we need to set the extent test for parallel
        ExtentFactory.GetInstance().setExtentTest(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentFactory.GetInstance().getExtentTest().log(Status.PASS, "Test case name :"+result.getMethod().getMethodName());
        ExtentFactory.GetInstance().getRemoveExtentTestObject();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //take screenshot
        //takeSnapshot.snap();
        //attach screenshot
        System.out.println("from on test failure method in TEST-NG listener");
        ExtentFactory.GetInstance().getExtentTest().log(Status.FAIL, result.getThrowable());
        //ExtentFactory.GetInstance().getExtentTest().fail("<b><font color=red"+"Screenshot of failure"+"</font></b>",
               // MediaEntityBuilder.createScreenCaptureFromPath(takeSnapshot.snap()).build());
        ExtentFactory.GetInstance().getExtentTest().addScreenCaptureFromPath(takeSnapshot.snap(), "Test case failure screenshot :"+result.getMethod().getMethodName());
        ExtentFactory.GetInstance().getExtentTest().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
        ExtentFactory.GetInstance().getRemoveExtentTestObject();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        //first we need to create a blank report with config defined in set-up
        reports= ExtentReporting.SetUpExtentReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        IResultMap f = context.getFailedTests();
        System.out.println("Number of failed test cases: "+f.size());
        reports.flush();
    }
}
