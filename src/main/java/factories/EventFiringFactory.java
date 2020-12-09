package factories;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class EventFiringFactory
{
    private EventFiringFactory()
    {
        System.out.println("from private constructor of EventFiringFatory class");
    }

    private static EventFiringFactory eventFiringFactory= new EventFiringFactory();
    public static EventFiringFactory GetInstance()
    {
        return eventFiringFactory;
    }

    ThreadLocal<EventFiringWebDriver> leventFiring= new ThreadLocal<>();
    public void setEventFiringFactory(EventFiringWebDriver eventFiringFactory)
    {
        leventFiring.set(eventFiringFactory);
    }

    public EventFiringWebDriver getEventFiringFactory()
    {
        return leventFiring.get();
    }
}
