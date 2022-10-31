package ru.sberbank.framework.managers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import ru.sberbank.framework.utils.PropConst;
import java.time.Duration;

public class DriverManager {

    private static DriverManager INSTANCE = null;

    private WebDriver driver;
    private TestPropManager propManager = TestPropManager.getInstance();

    FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver())
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(NoSuchElementException.class);


    private DriverManager() {
    }

    public static DriverManager getINSTANCE(){
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver(){
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", propManager.getProperty(PropConst.PATH_CHROME_DRIVER_WINDOWS));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }
}
