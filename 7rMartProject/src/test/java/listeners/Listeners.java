package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;   
import automationcore.Base;
import utilities.ExtentReportUtility;

public class Listeners extends Base implements ITestListener
{
	ExtentTest test;
	ExtentReports extent = ExtentReportUtility.createExtentReports();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	// Triggered when a test starts
	public void onTestStart(ITestResult result) // before executonn fetch name
	{
		ITestListener.super.onTestStart(result);// report life cycle monitoring
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	// called when test case executes successfully
	public void onTestSuccess(ITestResult result) // test method success
	{
		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	// Called when a test method fails
	public void onTestFailure(ITestResult result) {
		// calls the default implementation from ITestListner
		ITestListener.super.onTestFailure(result);
		// logs the test status as 'FAIL'in the extent report
		extentTest.get().log(Status.FAIL, "Test Failed");
		// Captures and logs the exception message that caused the test to fail
		extentTest.get().fail(result.getThrowable());
		driver = null;
		// Retrieves the name of the failed method
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}
	}

	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		extentTest.get().log(Status.SKIP, "Test Skipped");
		String testMethodName = result.getMethod().getMethodName();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		extent.flush();// log into report
	}

}
