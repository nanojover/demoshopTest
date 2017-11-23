package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.BillingDetailsDTO;
import utils.ElementWaiter;

import static java.lang.Thread.sleep;

public class CheckOutPage {
    WebDriver driver;

    By firstName = By.name("billing_first_name");
    By lastName = By.name("billing_last_name");
    By email = By.name("billing_email");
    By phone = By.name("billing_phone");
    By country = By.xpath("//*[@id='select2-chosen-1']");
    By countryBox = By.xpath("//*[@id='s2id_autogen1_search']");
    By address1 = By.name("billing_address_1");
    By postcode = By.name("billing_postcode");
    By city = By.name("billing_city");
    By province = By.xpath("//*[@id='select2-chosen-2']");
    By provinceBox = By.xpath("//*[@id='s2id_autogen2_search']");
    By placeOrderButton = By.id("place_order");

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(BillingDetailsDTO information) {
        driver.findElement(firstName).sendKeys(information.getFirstName());
        driver.findElement(lastName).sendKeys(information.getLastName());
        driver.findElement(email).sendKeys(information.getEmail());
        driver.findElement(phone).sendKeys(information.getPhone());
        driver.findElement(country).click();
        driver.findElement(countryBox).sendKeys(information.getCountry()+Keys.RETURN);
        driver.findElement(address1).sendKeys(information.getAddress());
        driver.findElement(postcode).sendKeys(information.getPostalCode());
        driver.findElement(city).sendKeys(information.getTownCity());
        driver.findElement(province).click();
        driver.findElement(province).sendKeys(information.getProvince()+Keys.RETURN);
    }

    public void placeOrder () throws InterruptedException {
        sleep(1000);
        driver.findElement(placeOrderButton).click();
    }
}
