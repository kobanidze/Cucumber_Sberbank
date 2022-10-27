package ru.sberbank.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StartPage extends BasePage {


    @FindBy(xpath = "//nav//a[@role='button']")
    private List<WebElement> topButtons;

    @FindBy(xpath = "//div[@class='kitt-top-menu__dropdown ']")
    private List<WebElement> dropDownMenus;

    @FindBy(xpath = "//div[@class='kitt-top-menu__dropdown kitt-top-menu__dropdown_icons']//div[contains(@class, ' kitt-top-menu__column')]//li//a")
    private List<WebElement> buttonsOfDropDownMenus;


    public StartPage pressTopButton(String nameOfCategory){
        chooseButtonFromTopBlock(topButtons, dropDownMenus, nameOfCategory);
        return pageManager.getStartPage();
    }

    public StartPage pressFrameButton(String buttonName){
        pressDropDownMenuButton(buttonsOfDropDownMenus, buttonName);
        return pageManager.getStartPage();
    }



}
