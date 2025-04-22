package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private AppiumDriver driver;

    public CartPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"CHECKOUT\"]")
    private WebElement checkoutBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"YOUR CART\"]")
    private WebElement cartTitle;

    public void clickCheckout() {
        checkoutBtn.click();
    }

    public boolean isCartVisible() {
        return cartTitle.isDisplayed();
    }
}
