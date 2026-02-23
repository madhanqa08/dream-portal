package Testcomponents;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.utilities.Extended;
import java.io.IOException;
public class Listenersclass extends Baseclass implements ITestListener
{

    ExtentTest extentTest;
    public ExtentReports reports = Extended.getReport();
    ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result)
    {
        extentTest = reports.createTest(result.getMethod().getMethodName());
        threadLocal.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        extentTest = extentTest.log(Status.PASS,result.getMethod().getMethodName()+"-✅");
        threadLocal.set(extentTest);
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        extentTest = extentTest.log(Status.FAIL,result.getMethod().getMethodName()+"-❌");
        threadLocal.get().fail(result.getThrowable());
        try
        {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        String location;
        try
        {
            location = takeScreenShoot(result.getMethod().getMethodName(),driver);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        threadLocal.get().addScreenCaptureFromPath(location,result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context)
    {
        reports.flush();
    }

}
