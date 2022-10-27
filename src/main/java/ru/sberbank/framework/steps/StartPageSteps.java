package ru.sberbank.framework.steps;

import io.cucumber.java.ru.И;
import ru.sberbank.framework.managers.PageManager;

public class StartPageSteps {

    PageManager pageManager = PageManager.getInstance();


    @И("^Нажатие кнопки (.+)$")
    public void pressTopButton(String nameOfCategor) {
        pageManager.getStartPage().pressTopButton(nameOfCategor);
    }

    @И("^Нажатие кнопки (.+) в открывшимся фрейме$")
    public void pressFrameButton(String buttonName) {
        pageManager.getStartPage().pressFrameButton(buttonName);
    }

}
