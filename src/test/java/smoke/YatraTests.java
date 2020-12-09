package smoke;

import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePageYatra;
import utility.ReadExcelSheet;

import java.util.HashMap;

public class YatraTests extends TestBase
{
    HomePageYatra homePageYatra= new HomePageYatra();
    ReadExcelSheet readExcelSheet= new ReadExcelSheet("data");
    @Test
    public void SearchFlight1()
    {
        HashMap<String, String> map= readExcelSheet.GetTestDataFromExcel(2);
        //homePageYatra.SearchFlights("Kolkata", "Bangalore", 3, 9);
        homePageYatra.SearchFlights(map.get("DepartCity"), map.get("ArrivalCity"), map.get("DepartDay"), map.get("ReturnDay"));
    }

    @Test
    public void SearchFlight2()
    {
        HashMap<String, String> map= readExcelSheet.GetTestDataFromExcel(3);
        homePageYatra.SearchFlights(map.get("DepartCity"), map.get("ArrivalCity"), map.get("DepartDay"), map.get("ReturnDay"));
    }
}
