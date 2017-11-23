package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementWaiter;

public class HomePage {

    WebDriver driver;
//    By addToCartButton = By.xpath("//a[@data-product_id='70']");
    By viewCartTab = By.xpath("//a[@href='http://demoshop.pagamastarde.com/wordpress/index.php/cart/']");
    By viewCartButton = By.xpath("//a[@title='View Cart']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButton(By item){
        driver.findElement(item).click();
        ElementWaiter.waitForElement(driver, viewCartButton);
    }

    public void goToCart(){
        driver.findElement(viewCartTab).click();
    }

}
