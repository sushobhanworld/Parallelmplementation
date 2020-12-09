package pages;

import base.TestBase;
import factories.DriverFactory;
import factories.EventFiringFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import utility.SelectChoice;

public class DetailsPage extends TestBase
{
    By url= By.id("Form_submitForm_subdomain");
    By firstName= By.id("Form_submitForm_FirstName");
    By lastName= By.id("Form_submitForm_LastName");
    By email= By.id("Form_submitForm_Email");
    By jobTitle= By.id("Form_submitForm_JobTitle");
    By numberOfEmployees= By.id("Form_submitForm_NoOfEmployees"); //dropdown
    By companyName= By.id("Form_submitForm_CompanyName");
    By industry= By.id("Form_submitForm_Industry"); //dropdown
    By contactNumber= By.id("Form_submitForm_Contact1");
    By country= By.id("Form_submitForm_Country"); //dropdown

    By captcha= By.xpath("//*[@id='recaptcha-anchor']/div[1]");

    public void EnterDetails()
    {
        EnterText(EventFiringFactory.GetInstance().getEventFiringFactory().findElement(url), "sushobhanworld");
        EnterText(EventFiringFactory.GetInstance().getEventFiringFactory().findElement(firstName), "Kumar");
        EnterText(EventFiringFactory.GetInstance().getEventFiringFactory().findElement(lastName), "Sushobhan");
        EnterText(EventFiringFactory.GetInstance().getEventFiringFactory().findElement(email), "sushobhanworld@gmail.com");
        EnterText(EventFiringFactory.GetInstance().getEventFiringFactory().findElement(jobTitle), "Software Engg");
        SelectOptionFromDropdown(SelectChoice.VISIBLE_TEXT.toString(), EventFiringFactory.GetInstance().getEventFiringFactory().findElement(numberOfEmployees), "11 - 15");
        EnterText(EventFiringFactory.GetInstance().getEventFiringFactory().findElement(companyName), "Wells Fargo");
        SelectOptionFromDropdown(SelectChoice.VISIBLE_TEXT.toString(), EventFiringFactory.GetInstance().getEventFiringFactory().findElement(industry), "Electronics");
        EnterText(EventFiringFactory.GetInstance().getEventFiringFactory().findElement(contactNumber), "9731950640");
        SelectOptionFromDropdown(SelectChoice.VISIBLE_TEXT.toString(), EventFiringFactory.GetInstance().getEventFiringFactory().findElement(country), "India");
    }

    public void ValidateDetailsPage()
    {
        Assert.assertEquals("Free Human Resource Management Software | 30 Day Trial Creation", EventFiringFactory.GetInstance().getEventFiringFactory().getTitle());
    }
}
