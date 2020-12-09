package factories;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory
{
    private ExtentFactory()
    {
        System.out.println("private method of extent factory");
    }

    private static ExtentFactory instance= new ExtentFactory();
    public static ExtentFactory GetInstance()
    {
        return instance;
    }

    ThreadLocal<ExtentTest> lExtentTest= new ThreadLocal<ExtentTest>();

    public void setExtentTest(ExtentTest extentTest)
    {
        lExtentTest.set(extentTest);
    }

    public ExtentTest getExtentTest()
    {
        return lExtentTest.get();
    }

    public void getRemoveExtentTestObject() {
        lExtentTest.remove();
    }
}
