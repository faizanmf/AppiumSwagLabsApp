package stepDefinitions;

import Pages.*;
import Utils.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class PurchaseFlowTest {

    AppiumDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;
    ConfirmationPage confirmationPage;

    @Given("the app is launched")
    public void the_app_is_launched() throws Exception {
        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
        confirmationPage = new ConfirmationPage(driver);
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        loginPage.enterUsername(username);
    }

    @And("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @And("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.tapLogin();
    }

    @Then("the user should see the product title")
    public void the_user_should_see_the_product_title() {
        Assert.assertTrue(productsPage.isProductListVisible(), "Product title not visible.");
    }

    @And("the user should see the product list")
    public void the_user_should_see_the_product_list() {
        Assert.assertTrue(productsPage.isProductListVisible(), "Product list not visible.");
    }

    @When("the user selects a product")
    public void the_user_selects_a_product() {
        productsPage.selectProduct("Sauce Labs Backpack"); // Pass product name if required
    }

    @And("the user adds the product to the cart")
    public void the_user_adds_the_product_to_the_cart() {
        productsPage.addToCart();
    }

    @Then("the user should see the cart icon with the correct number of items")
    public void the_user_should_see_the_cart_icon_with_the_correct_number_of_items() {
        Assert.assertTrue(productsPage.verifyCartCount("1"), "Cart count is incorrect.");
    }

    @When("the user clicks on the cart icon")
    public void the_user_clicks_on_the_cart_icon() {
        productsPage.openCart();
    }

    @Then("the user should be navigated to the cart screen")
    public void the_user_should_be_navigated_to_the_cart_screen() {
        Assert.assertTrue(cartPage.isCartVisible(), "Cart screen not visible.");
    }

    @When("the user clicks on the checkout button")
    public void the_user_clicks_on_the_checkout_button() {
        cartPage.clickCheckout();
    }

    @Then("the user should be navigated to the checkout screen")
    public void the_user_should_be_navigated_to_the_checkout_screen() {
        Assert.assertTrue(checkoutPage.isCheckoutVisible(), "Checkout screen not visible.");
    }

    @When("the user enters first name {string}")
    public void the_user_enters_first_name(String fname) {
        checkoutPage.enterFirstName(fname);
    }

    @And("the user enters last name {string}")
    public void the_user_enters_last_name(String lname) {
        checkoutPage.enterLastName(lname);
    }

    @And("the user enters postal code {string}")
    public void the_user_enters_postal_code(String zip) {
        checkoutPage.enterPostalCode(zip);
    }

    @And("the user clicks the continue button")
    public void the_user_clicks_the_continue_button() {
        checkoutPage.clickContinue();
    }

    @Then("the user should be navigated to the overview screen")
    public void the_user_should_be_navigated_to_the_overview_screen() {
        Assert.assertTrue(overviewPage.isOverviewPageVisible(), "Overview screen not visible.");
    }

    @And("the user should see the total price")
    public void the_user_should_see_the_total_price() {
        Assert.assertTrue(overviewPage.isTotalPriceVisible(), "Total price not visible.");
    }

    @When("the user clicks on the finish button")
    public void the_user_clicks_on_the_finish_button() {
        overviewPage.clickFinish();
    }

    @Then("the user should be navigated to the confirmation screen")
    public void the_user_should_be_navigated_to_the_confirmation_screen() {
        Assert.assertTrue(confirmationPage.isConfirmationDisplayed(), "Confirmation screen not visible.");
    }

    @And("the user should see the confirmation message")
    public void the_user_should_see_the_confirmation_message() {
        Assert.assertTrue(confirmationPage.isConfirmationDisplayed(), "Confirmation message not visible.");
    }

    @When("the user clicks on the back home button")
    public void the_user_clicks_on_the_back_home_button() {
        confirmationPage.clickBackHome();
    }

    @Then("the user should be navigated to the home screen")
    public void the_user_should_be_navigated_to_the_home_screen() {
        Assert.assertTrue(productsPage.isProductListVisible(), "Home screen not displayed.");
        DriverFactory.quitDriver();
    }
}
