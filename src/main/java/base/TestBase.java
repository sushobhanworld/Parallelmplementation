package base;

import factories.BrowserFactory;
import factories.DriverFactory;
import factories.EventFiringFactory;
import listeners.ListenerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utility.ActionEngine;
import utility.ReadPropertyFile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase extends ActionEngine
{
    public BrowserFactory browserFactory= new BrowserFactory();
    public final ListenerDriver listenerDriver= new ListenerDriver();

    public TestBase() {
    }


    @BeforeMethod(alwaysRun = true)
    public void LaunchApplication()
    {
        try {
            Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String browser= ReadPropertyFile.ReadFile("browser");
        String url= ReadPropertyFile.ReadFile("url");


        /*listenerDriver= new ListenerDriver();
        eventFiringWebDriver= new EventFiringWebDriver(DriverFactory.GetInstance().getDriver());
        eventFiringWebDriver.register(listenerDriver);

        //set the Driver
        DriverFactory.GetInstance().setDriver(browserFactory.CreateBrowserInstance(browser));

        //Get the Driver
        DriverFactory.GetInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverFactory.GetInstance().getDriver().manage().deleteAllCookies();
        DriverFactory.GetInstance().getDriver().manage().window().maximize();
        DriverFactory.GetInstance().getDriver().get(url);*/



        final EventFiringWebDriver eventFiringWebDriver= new EventFiringWebDriver(browserFactory.CreateBrowserInstance(browser));
        eventFiringWebDriver.register(listenerDriver);

        EventFiringFactory.GetInstance().setEventFiringFactory(eventFiringWebDriver);
        EventFiringFactory.GetInstance().getEventFiringFactory().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        EventFiringFactory.GetInstance().getEventFiringFactory().manage().deleteAllCookies();
        EventFiringFactory.GetInstance().getEventFiringFactory().manage().window().maximize();
        EventFiringFactory.GetInstance().getEventFiringFactory().get(url);
    }

    @AfterMethod
    public void tearDown()
    {
        //DriverFactory.GetInstance().getDriver().close();
        //EventFiringFactory.GetInstance().getEventFiringFactory().close();
    }
}
