package PageObject;

import Utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(className = "product-box-add-to-cart-button")
    WebElement addToCartBttn;

    @FindBy(className = "add-to-wishlist-button")
    WebElement addToWishListBttn;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart () {
        SeleniumUtils.clickElement(addToCartBttn, wait);
    }

    public void addToWishList() {
        SeleniumUtils.clickElement(addToWishListBttn, wait);
    }

}
