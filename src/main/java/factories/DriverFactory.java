package factories;

import org.openqa.selenium.WebDriver;

public class DriverFactory
{
    //Singleton pattern
    //Create a private constructor to restrict the object creation
    private DriverFactory()
    {
        System.out.println("from private constructor of Driver Factory");
    }

    private static DriverFactory driverFactory= new DriverFactory();
    public static DriverFactory GetInstance()
    {
        return driverFactory;
    }

    //Now, define factory pattern, that is create setter and getter methods
    ThreadLocal<WebDriver> ldriver= new ThreadLocal<>();

    public void setDriver(WebDriver driver)
    {
        ldriver.set(driver);
    }

    public WebDriver getDriver()
    {
        return ldriver.get();
    }
}
