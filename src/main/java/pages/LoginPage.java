package pages;

import base.TestBase;
import org.openqa.selenium.By;

public class LoginPage extends TestBase
{
    By EMAIL = By.name("login[email]");
    By PASSWORD = By.name("login[password]");
    By LOGIN_BTN = By.xpath("//button[@type='submit' and text()='Login ']");


    //login to App
    public void login(String email, String password) {
        //sendKeys_custom(driver.findElement(EMAIL), "LoginEmailFIeld", email);
        //sendKeys_custom(driver.findElement(PASSWORD), "LoginPasswordFIeld", password);

        //click_custom(driver.findElement(LOGIN_BTN), "LoginButton");

    }
}
