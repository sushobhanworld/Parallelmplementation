package listeners;

import factories.EventFiringFactory;
import factories.ExtentFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class ListenerDriver implements WebDriverEventListener
{
    WebDriver driver= EventFiringFactory.GetInstance().getEventFiringFactory();
    JavascriptExecutor javascriptExecutor= (JavascriptExecutor) EventFiringFactory.GetInstance().getEventFiringFactory();

    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {

    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("from after navigate to");
        System.out.println("Title is: "+EventFiringFactory.GetInstance().getEventFiringFactory().getTitle());
    }

    public void beforeNavigateBack(WebDriver webDriver) {

    }

    public void afterNavigateBack(WebDriver webDriver) {

    }

    public void beforeNavigateForward(WebDriver webDriver) {

    }

    public void afterNavigateForward(WebDriver webDriver) {

    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        ExtentFactory.GetInstance().getExtentTest().info("Searching the element "+by.toString());
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        ExtentFactory.GetInstance().getExtentTest().info("Element found "+by.toString());
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        //The web element where the exception is thrown, should be bordered with Red
        System.out.println("from on exception method in Event Listener");
        //javascriptExecutor.executeScript("arguments[0].style.border='3px solid red';", webElement);
    }

    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
