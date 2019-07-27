package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterCompletePage extends BasePage{

    public RegisterCompletePage(WebDriver driver) {
        super(driver);
    }

//
//    @FindBy(how = How.CLASS_NAME, using = "page-body")
//    WebElement registerConfirmation;
//
//    @FindBy(how = How.CLASS_NAME, using = "ico-account")
//    WebElement myAccountIcon;
//

    public boolean registerConfirm() {
        return driver.findElement(By.className("page-body")).getText().contains("Your registration completed");
    }


    public WebElement logOutIconDisplayed () {
        return driver.findElement(By.className("ico-logout"));
    }

    }


