package ru.sberbank.framework.managers;

import ru.sberbank.framework.utils.PropConst;
import ru.sberbank.framework.utils.PropConst.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static ru.sberbank.framework.utils.PropConst.*;


public class InitManager {

    private static final TestPropManager props = TestPropManager.getInstance();

    private static final DriverManager driverManager = DriverManager.getINSTANCE();

    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().get(props.getProperty(PropConst.BASE_URL));
        driverManager.getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT))));
        driverManager.getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT))));
    }

    public static void quitFramework() {
        driverManager.quitDriver();
    }
}
