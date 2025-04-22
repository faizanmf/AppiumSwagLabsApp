package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    private AppiumDriver driver;

    public ConfirmationPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]")
    private WebElement confirmationMsg;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"BACK HOME\"]")
    private WebElement backHomeBtn;

    public boolean isConfirmationDisplayed() {
        return confirmationMsg.isDisplayed();
    }

    public void clickBackHome() {
        backHomeBtn.click();
    }
}
