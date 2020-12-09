package utility;

import com.aventstack.extentreports.Status;
import factories.EventFiringFactory;
import factories.ExtentFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionEngine
{
    JavascriptExecutor javascriptExecutor= (JavascriptExecutor) EventFiringFactory.GetInstance().getEventFiringFactory();
    public boolean isElementPresent_custom(WebElement element, String fieldName)
    {
        boolean flag= false;
        try
        {
            flag= element.isDisplayed();
            ExtentFactory.GetInstance().getExtentTest().log(Status.PASS, fieldName+" ===> presence is "+flag);
            return flag;
        }
        catch (Exception e)
        {
            ExtentFactory.GetInstance().getExtentTest().log(Status.FAIL, fieldName+" ===> presence is "+flag);
            return flag;
        }
    }

    public void SelectOptionFromDropdown(String options, WebElement element, String value) {
        try{
            Select select= new Select(element);
            javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
            Thread.sleep(1000);
            switch (options)
            {
                case "index":
                    select.selectByIndex(Integer.parseInt(value));
                    break;
                case "value":
                    select.selectByValue(value);
                    break;
                case "visibleText":
                    select.selectByVisibleText(value);
                    break;
                default:
                    try {
                        throw new Exception("Invalid selection type");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
            Thread.sleep(1000);
            javascriptExecutor.executeScript("arguments[0].setAttribute('style','');", element);
            javascriptExecutor.executeScript("arguments[0].removeAttribute('style','');", element);
            ExtentFactory.GetInstance().getExtentTest().log(Status.PASS, "Dropdown "+element.getAttribute("name")+" selected successfully");
        }
        catch (Exception e)
        {

        }
    }

    public void EnterText(WebElement element, String text)
    {
        try
        {
            //javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
            javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
            Thread.sleep(1000);
            element.sendKeys(text);
            Thread.sleep(1000);
            javascriptExecutor.executeScript("arguments[0].setAttribute('style','');", element);
            javascriptExecutor.executeScript("arguments[0].removeAttribute('style','');", element);
            ExtentFactory.GetInstance().getExtentTest().log(Status.PASS, text+" entered successfully in "+element.getAttribute("placeholder"));
        }
        catch (Exception e)
        {
            System.out.println("in catch block");
            ExtentFactory.GetInstance().getExtentTest().log(Status.FAIL, text+" is NOT entered in "+element.getAttribute("placeholder"));
            javascriptExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
            e.printStackTrace();
        }
    }

    public void ClickOnElement(WebElement element, String fieldName)
    {
        try
        {
            element.click();
            ExtentFactory.GetInstance().getExtentTest().log(Status.PASS, fieldName+" is clicked");
        }
        catch (Exception e)
        {
            ExtentFactory.GetInstance().getExtentTest().log(Status.FAIL, fieldName+" is NOT clicked");
            e.printStackTrace();
        }
    }
}
