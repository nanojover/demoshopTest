package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;
    By proceedtoCheckoutButton = By.xpath("//a[@href='http://demoshop.pagamastarde.com/wordpress/index.php/checkout/']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean itemExists(String item) {
        if (driver.getPageSource().contains(item)) {
            return true;
        }
        return false;
    }

    public boolean itemDoesNotExist(String item) {
        if (!driver.getPageSource().contains(item)) {
            return true;
        }
        return false;
    }

    public boolean cartIsEmpty() {
        if (driver.getPageSource().contains("Your cart is currently empty.")) {
            return true;
        }
        return false;
    }

    public void proceedtoCheckout (){
        driver.findElement(proceedtoCheckoutButton).click();
    }

}
