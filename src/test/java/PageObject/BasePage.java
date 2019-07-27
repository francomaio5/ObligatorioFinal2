package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected TopBar topBar;
    protected NavigationBar navigationBar;
    protected LogInPage logInPage;
    protected CartPage cartPage;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        topBar = new TopBar(driver);
        navigationBar = new NavigationBar(driver);
    }

    //Tengo que hacer el metodo aca de todas las cosas con las que hago interaccion en la top bar
    // y en la navigation bar

    public RegisterPage goRegisterPage () {
        return topBar.goRegisterPage();
    }

    public LogInPage goLoginPage() {
        return topBar.goLoginPage();
    }

    public SearchPage searchElement(String objeto) {
        return navigationBar.buscarObjeto(objeto);
    }

    public CartPage goCartPage() {
        return topBar.goCartPage();
    }
}
