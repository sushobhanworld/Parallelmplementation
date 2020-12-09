package smoke;

import base.TestBase;
import factories.ExtentFactory;
import org.testng.annotations.Test;
import pages.DetailsPage;
import pages.HomePage;

public class SmokeTesting extends TestBase
{
    HomePage homePage= new HomePage();
    DetailsPage detailsPage;

    @Test
    public void test1()
    {
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        ExtentFactory.GetInstance().getExtentTest().info("Test case 1 started in smoke testing");
        detailsPage= homePage.NavigateToDetailsPage();
        detailsPage.ValidateDetailsPage();
        detailsPage.EnterDetails();
    }

    @Test
    public void test2()
    {
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        ExtentFactory.GetInstance().getExtentTest().info("Test case 2 started in smoke testing");
        System.out.println("from test case 2");
    }
}
