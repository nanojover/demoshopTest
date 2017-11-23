package com.demoshop.Steps;

import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.PayForOrderPage;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.BillingDetailsDTO;
import utils.ItemsCatalog;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddItemsToTheCartSteps {
    private final String url = "http://demoshop.pagamastarde.com/wordpress/";
    private WebDriver driver;
    private HomePage homePage;
    private CartPage cartPage;
    private CheckOutPage checkOutPage;
    private PayForOrderPage payForOrderPage;
//    private String item;

    @Before()
    public void before() throws Throwable {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @After()
    public void after() throws Throwable {
        driver.quit();
    }

    @Given("^customer is in Home page$")
    public void customer_is_in_Home_page() throws Throwable {
        homePage = new HomePage(driver);
    }

    @When("^click on Add to cart button for '(.*)' item$")
    public void click_on_Add_to_cart_button(String item) throws Throwable {
//        this.item = item;
        homePage.clickAddToCartButton(By.xpath("//a[@data-product_id='" + ItemsCatalog.getProductId(item) + "']"));
    }

    @Then("^the item '(.*)' is (|not )added to the cart$")
    public void the_item_is_added_to_the_cart(String item, String selector) throws Throwable {
        homePage.goToCart();
        cartPage = new CartPage(driver);

        if ("not ".equals(selector)) {
            assertTrue("The item " + item + " is on the cart", cartPage.itemDoesNotExist(item));
        } else {
            assertTrue("The item " + item + " is not on the cart", cartPage.itemExists(item));
        }
    }

    @Then("^the cart is empty$")
    public void the_cart_is_empty() throws Throwable {
        homePage.goToCart();
        cartPage = new CartPage(driver);
        assertTrue("The cart is not empty", cartPage.cartIsEmpty());
    }

    @Given("^customer Proceed to Checkout$")
    public void customer_Proceed_to_Checkout() throws Throwable {
        cartPage.proceedtoCheckout();
        checkOutPage = new CheckOutPage(driver);
    }

    @Given("^customer information is entered$")
    public void customer_information_is_entered(List<BillingDetailsDTO> information) throws Throwable {
        checkOutPage.fillForm(information.get(0));
    }

    @Given("^customer click on Place order button$")
    public void customer_click_on_Place_order_button() throws Throwable {
        checkOutPage.placeOrder();
    }

    @Then("^'(.*)' page is displayed$")
    public void pago_mas_tarde_page_is_displayed(String title) throws Throwable {
        payForOrderPage = new PayForOrderPage(driver);
        assertEquals("Page is not the expected", title, payForOrderPage.getTitle(title));
    }
}
