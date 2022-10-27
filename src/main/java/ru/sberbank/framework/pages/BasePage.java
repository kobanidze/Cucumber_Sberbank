package ru.sberbank.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sberbank.framework.managers.DriverManager;
import ru.sberbank.framework.managers.PageManager;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getINSTANCE();
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10), Duration.ofMillis(1000));
    protected PageManager pageManager = PageManager.getInstance();


    public void chooseButtonFromTopBlock(List<WebElement> buttons, List<WebElement> frames, String nameOfCategory){
        for (WebElement tagOfTopBlock : buttons) {
            if (tagOfTopBlock.getText().contains(nameOfCategory)) {
                tagOfTopBlock.click();
                return;
            }
        }
        WebElement currentFrame = null;
        for (WebElement frame: frames) {
            if (frame.getText().contains(nameOfCategory)){
                currentFrame = frame;
            }
        }
        Assert.fail("Вкладка с именем " + "'" + nameOfCategory + "'" + " не найден в списке товаров");
        wait.until(ExpectedConditions.visibilityOf(currentFrame));
    }

    public void pressDropDownMenuButton(List<WebElement> xpath, String buttonName) {
        for (WebElement button: xpath) {
            if (button.getText().contains(buttonName)) {
                button.click();
                return;
            }
        }
        Assert.fail("Кнопка с именем " + "'" + buttonName + "'" + " не найден в списке товаров");
    }
}
