package ru.sberbank.framework.basetestsclass;

import org.junit.After;
import org.junit.Before;
import ru.sberbank.framework.managers.DriverManager;
import ru.sberbank.framework.managers.PageManager;


public class BaseTests {


    private DriverManager driverManager = DriverManager.getINSTANCE();
    protected PageManager pageManager = PageManager.getInstance();


//
//    @Before
//    public void before(){
//        driverManager.getDriver().get("http://www.sberbank.ru");
//    }
//
//    @After
//    public void after(){
//        driverManager.getDriver().quit();
//    }
}