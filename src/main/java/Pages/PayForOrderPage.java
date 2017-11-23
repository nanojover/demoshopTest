package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class PayForOrderPage {
    WebDriver driver;

//    By submitPaymentButton = By.xpath("//*[@id='submit_vme_payment_form']");


    By submitPaymentButton = By.id("submit_vme_payment_form");

    public PayForOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(String title) throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            if (title.equals(driver.getTitle())){
                return driver.getTitle();
            }
            sleep(1000);
        }
        return "error";
    }

    public boolean isSubmtiButton() {
        return driver.findElement(submitPaymentButton).isDisplayed();
    }
}
