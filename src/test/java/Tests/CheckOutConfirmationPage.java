package Tests;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckOutConfirmationPage extends BasePage {

//    @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
//    WebElement succesfullyProcessed;

    public CheckOutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOrderConfirmed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")));
        WebElement orderConfirmation = driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        return orderConfirmation.getText().contains("Your order has been successfully processed!");

    }
}
