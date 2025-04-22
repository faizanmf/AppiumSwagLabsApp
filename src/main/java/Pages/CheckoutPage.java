package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private AppiumDriver driver;

    @AndroidFindBy(accessibility = "test-First Name")
    private WebElement firstName;

    @AndroidFindBy(accessibility = "test-Last Name")
    private WebElement lastName;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private WebElement postalCode;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    private WebElement continueBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CHECKOUT: INFORMATION\"]")
    private WebElement checkoutTitle;

    public CheckoutPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isCheckoutVisible() {
        return checkoutTitle.isDisplayed();
    }

    public void enterFirstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enterPostalCode(String zip) {
        postalCode.sendKeys(zip);
    }

    public void clickContinue() {
        if (((AndroidDriver) driver).isKeyboardShown()) {
            driver.executeScript("mobile: hideKeyboard");
        }
        continueBtn.click();
    }
}
