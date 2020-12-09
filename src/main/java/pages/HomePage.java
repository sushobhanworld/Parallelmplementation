package pages;

import base.TestBase;
import factories.EventFiringFactory;
import org.openqa.selenium.By;

public class HomePage extends TestBase
{
//    //By sidebarMenu_Dashboard = By.xpath("//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='Dashboard']");
//
//
//    //click on menu bar - by passing name of menu
//    public void clickOnSideMenu(String menu) {
//        String MenuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
//        driver.findElement(By.xpath(MenuXpath)).click();
//    }
//
//    //click on sub menu bar - by passing name of menu
//    public void clickOnSideSubMenu(String menu, String submenu) {
//        String MenuXpath = "//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']";
//        driver.findElement(By.xpath(MenuXpath)).click();
//        String submenuXpath="//ul[@class='page-sidebar-menu']//i/following-sibling::span[text()='"+menu+"']/ancestor::a/following-sibling::ul//span[text()='"+submenu+"']";
//        driver.findElement(By.xpath(submenuXpath)).click();
//    }
//
//    //check if the Dashboard is opened
////    public void checkIfDashBoardPageIsOpened() {
////        Assert.assertTrue(isElementPresent_custom(driver.findElement(sidebarMenu_Dashboard), "DashBoardMenu"));
////    }
//
//    public void CheckDetailsPageIsOpened()
//    {
//        Assert.assertTrue(isElementPresent_custom(driver.findElement(trialBtn), "FREE 30 DAY TRIAL"));
//    }

    By trialBtn= By.xpath("//a[text()='Contact Sales']/parent::li/following-sibling::li/a[text()='FREE 30 Day Trial']");
    public DetailsPage NavigateToDetailsPage()
    {
        ClickOnElement(EventFiringFactory.GetInstance().getEventFiringFactory().findElement(trialBtn), "Free 30 day trial");
        return new DetailsPage();
    }
}
