package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class ProductsPage {
    private AppiumDriver driver;

    public ProductsPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]")
    private WebElement productTitle;

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private WebElement addToCartBtn;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]")
    private WebElement cartIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"1\"]")
    private WebElement cartItemCount;

    public boolean isProductListVisible() {
        return productTitle.isDisplayed();
    }

    public void selectProduct(String productName) {
        String xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='" + productName + "']";
        WebElement product = driver.findElement(By.xpath(xpath));
        product.click();
    }

    public void addToCart() {
        try {
            // Wait briefly to ensure the page has fully loaded
            Thread.sleep(1000);

            // Get dynamic screen size for swipe
            Dimension size = driver.manage().window().getSize();
            int startX = size.width / 2;
            int startY = (int) (size.height * 0.9);
            int endY = (int) (size.height * 0.1);

            // Log screen dimensions
            System.out.println("Screen dimensions: " + size);

            // Perform swipe using PointerInput (modern way)
            final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(800), PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(Arrays.asList(swipe));

            // Optionally wait a bit after the swipe
            Thread.sleep(1000);

            // Wait for the "Add to Cart" button to become clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

            // Validate visibility before clicking
            if (addToCartBtn.isDisplayed()) {
                System.out.println("Add to Cart button is visible");
                addToCartBtn.click();
            } else {
                System.out.println("Add to Cart button is not visible after swipe");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean verifyCartCount(String expectedCount) {
        return cartItemCount.getText().equals(expectedCount);
    }

    public void openCart() {
        cartIcon.click();
    }
}
