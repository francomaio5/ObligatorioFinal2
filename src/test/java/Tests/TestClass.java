package Tests;

import PageObject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver;
    WebDriverWait wait;
    BasePage basePage;
    HomePage homePage;
    NavigationBar navigationBar;
    TopBar topBar;
    RegisterPage registerPage;
    RegisterCompletePage registerCompletePage;
    LogInPage logInPage;
    SearchPage searchPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    CheckOutConfirmationPage checkOutConfirmationPage;


    @BeforeClass
    public void  setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
    }


    @Test
    public void testRegistro(){
        registerPage = homePage.goRegisterPage();
        registerCompletePage = registerPage.registerNewUser("Juan", "Gonzales",
                "maildetest9@gmail.com", "lacontrasenia1234");
        Assert.assertTrue(registerCompletePage.registerConfirm());
        Assert.assertTrue(registerCompletePage.logOutIconDisplayed().isDisplayed());
    }

    @Test
    public void checkOutEefectivo() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia1234");
        searchPage = homePage.searchElement("nokia");
        searchPage.addToCart();
        cartPage = searchPage.goCartPage();
        checkOutPage = cartPage.goCheckOutPage();
        checkOutConfirmationPage = checkOutPage.doCheckOut("Tata", "Uruguay", "Montevideo",
                "Zapican 2507", "Santa Fe", "2507", "094778188",
                "094778188", "Next Day Air", "Not Credit Card", "Master card",
                "Mario Perez", "15341846135", "05", "2020", "758");
        Assert.assertTrue(checkOutConfirmationPage.isOrderConfirmed());
    }

    @Test
    public void checkOutCreditCard() {
        logInPage = homePage.goLoginPage();
        homePage = logInPage.loginUser("maildetest8@gmail.com", "lacontrasenia1234");
        searchPage = homePage.searchElement("nokia");
        searchPage.addToCart();
        cartPage = searchPage.goCartPage();
        checkOutPage = cartPage.goCheckOutPage();
        checkOutConfirmationPage = checkOutPage.doCheckOut("Tata", "Uruguay", "Montevideo",
                "Zapican 2507", "Santa Fe", "2507", "094778188",
                "094778188", "Next Day Air", "Credit Card", "Visa",
                "Mario Perez", "15341846135", "05", "2020", "758");
    }


}
