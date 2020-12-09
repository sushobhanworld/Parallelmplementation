package pages;

import base.TestBase;
import factories.EventFiringFactory;
import org.openqa.selenium.By;
import utility.DateSelection;

public class HomePageYatra extends TestBase
{

    By closePopUp= By.id("webklipper-publisher-widget-container-notification-close-div");

    By round_trip= By.xpath("//a[@title='Round Trip']");
    By origin_place= By.id("BE_flight_origin_city");
    By arrival_place= By.id("BE_flight_arrival_city");
    //Select the first option
    By selectCityAirport= By.xpath("//div[@class='ac_airport']");

    By departure_date= By.id("BE_flight_origin_date");
    By closeCalendar= By.xpath("//i[@data-calendarclose='true']");
    By arrival_date= By.id("BE_flight_arrival_date");

    By travellers= By.xpath("//span[@class='txt-ellipses flight_passengerBox travellerPaxBox']");
    By adult_plus_icon= By.xpath("//span[@id='adultPax']/parent::span/following-sibling::div/div/span[@class='ddSpinnerPlus']");
    By child_plus_icon= By.xpath("//span[@id='childPax']/parent::span/following-sibling::div/div/span[@class='ddSpinnerPlus']");
    By infant_plus_icon= By.xpath("//span[@id='infantPax']/parent::span/following-sibling::div/div/span[@class='ddSpinnerPlus']");

    By premium_economy= By.xpath("//span[text()='Premium Economy']");
    By searchBtn= By.id("BE_flight_flsearch_btn");

    public void SearchFlights(String departCity, String arrivalCity, String departDay, String returnDay)
    {
        EventFiringFactory.GetInstance().getEventFiringFactory().switchTo().frame("webklipper-publisher-widget-container-notification-frame");
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(closePopUp).click();
        EventFiringFactory.GetInstance().getEventFiringFactory().switchTo().defaultContent();

        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(round_trip).click();

        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(origin_place).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(origin_place).sendKeys(departCity);
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(selectCityAirport).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(arrival_place).sendKeys(arrivalCity);
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(selectCityAirport).click();

        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(departure_date).click();
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(By.id(DateSelection.SelectDepartureDate(departDay))).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(closeCalendar).click();
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(arrival_date).click();
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(By.id(DateSelection.SelectDepartureDate(returnDay))).click();

        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(travellers).click();

        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(adult_plus_icon).click();
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(adult_plus_icon).click();

        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(child_plus_icon).click();
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(child_plus_icon).click();

        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(infant_plus_icon).click();
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(infant_plus_icon).click();

        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(premium_economy).click();
        EventFiringFactory.GetInstance().getEventFiringFactory().findElement(searchBtn).click();
    }
}
