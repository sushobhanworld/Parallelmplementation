package factories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserFactory
{
    public WebDriver CreateBrowserInstance(String browser)
    {
        WebDriver driver= null;
        if(browser.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions= new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            driver= new ChromeDriver(chromeOptions);
        }
        else
        {
            WebDriverManager.iedriver().setup();
            InternetExplorerOptions iOptions = new InternetExplorerOptions();
            iOptions.addCommandSwitches("-private");

            driver = new InternetExplorerDriver(iOptions);
        }
        return driver;
    }
}
