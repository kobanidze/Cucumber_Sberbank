package ru.sberbank.framework.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.sberbank.framework.managers.InitManager;

public class Hooks {




    @Before
    public void before(){
        InitManager.initFramework();
    }


    @After
    public void after() {
        InitManager.quitFramework();
    }

}
