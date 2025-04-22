package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverFactory {
    private static AppiumDriver driver;

    public static void initDriver() throws Exception {
        Properties prop = new Properties();

        // Load properties file
        FileInputStream file = new FileInputStream("src/main/resources/appium-config/config.properties");
        prop.load(file);

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("deviceName"));
        options.setPlatformName(prop.getProperty("platformName"));
        options.setPlatformVersion(prop.getProperty("platformVersion"));
        options.setUdid(prop.getProperty("udid"));
        options.setApp(prop.getProperty("app"));

        options.setAppPackage("com.swaglabsmobileapp");
        options.setAppActivity("com.swaglabsmobileapp.MainActivity");
        options.setAppWaitActivity("*");
        options.setAppWaitDuration(Duration.ofSeconds(30));
        options.setAutoGrantPermissions(true);

        URL url = new URL(prop.getProperty("appiumServerURL"));
        driver = new AndroidDriver(url, options);

        System.out.println("✅ App launched successfully");
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
