package ru.sberbank.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.sberbank.framework.managers.DriverManager;

public class Hooks {

    private DriverManager driverManager = DriverManager.getINSTANCE();


    @Before
    public void before(){
        driverManager.getDriver().get("http://www.sberbank.ru");
    }

    @After
    public void after() {
        driverManager.quitDriver();
    }

}
