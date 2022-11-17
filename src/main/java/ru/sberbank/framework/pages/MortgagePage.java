package ru.sberbank.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.swing.*;
import java.security.Key;
import java.util.List;
import java.util.Objects;

public class MortgagePage extends BasePage{

    @FindBy(xpath = "//div[@class='kitt-cookie-warning__content']//button[@class='kitt-cookie-warning__close']")
    private WebElement closeCookieButton;

    @FindBy(xpath = "//div[@id = 'calculator-root']")
    private WebElement bottomOfCalculator;

    @FindBy(xpath = "//div[@id='calculator-root']//div[@data-test-id='product-selector']//div[@data-e2e-id='mland-calculator/products-dropdown']")
    private WebElement filedToChooseMortgage;

    @FindBy(xpath = "//div[@role='listbox']")
    private WebElement mortgagesDropDown;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
    private List<WebElement> listOfMortgages;

    @FindBy(xpath = "//button[@type='button']//span[contains(@class, 'button-root__text')]")
    private List<WebElement> kindsOfMortgages;

    @FindBy(xpath = "//div[@data-test-id='realty-cost-input']//div[contains(@class, 'container')]//input")
    private WebElement costOfHouseInputField;

    @FindBy(xpath = "//div[contains(@data-e2e-id, 'initial-fee')]//input[contains(@class, 'dc-input')]")
    private WebElement initialPaymentInputField;

    @FindBy(xpath = "(//div[contains(@class, 'slider-input')]//input[contains(@class, 'dc-input')])[3]")
    private WebElement loanTermInputField;

    @FindBy(xpath = "(//div[@data-test-id='main-results-block']//li//div[@class='_3gNM-Vy-F04mXdV3m7eDa5']//span[contains(@class, '_19zitcoxuphOm2IGRCrUgj ')])[4]")
    private WebElement monthlyPaymentResult;

    @FindBy(xpath = "(//div[@data-test-id='main-results-block']//li//div[@class='_3gNM-Vy-F04mXdV3m7eDa5']//span[contains(@class, '_19zitcoxuphOm2IGRCrUgj ')])[5]")
    private WebElement interestRateResult;

    @FindBy(xpath = "(//div[@data-test-id='main-results-block']//li//div[@class='_3gNM-Vy-F04mXdV3m7eDa5']//span[contains(@class, '_19zitcoxuphOm2IGRCrUgj')])[10]")
    private WebElement creditSumResult;

    @FindBy(xpath = "(//div[@data-test-id='main-results-block']//li//div[@class='_3gNM-Vy-F04mXdV3m7eDa5']//span[contains(@class, '_19zitcoxuphOm2IGRCrUgj')])[11]")
    private WebElement taxDeductionResult;

    @FindBy(xpath = "(//li//div[@class='_3gNM-Vy-F04mXdV3m7eDa5']//span[contains(@class, '_19zitcoxuphOm2IGRCrUgj')])[13]")
    private WebElement requiredIncomeResult;


    @FindBy(xpath = "//div[contains(@class, 'kitt-row')]//div[contains(@class, 'bp-widget')]//div[@class='iframe-resizer']//iframe")
    private WebElement calculatorFrame;



    public MortgagePage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public MortgagePage closeCookie() {
        closeCookieButton.click();
        return pageManager.getMortgagePage();
    }

    public MortgagePage scrollToCalculator(){
//        Actions action = new Actions(driverManager.getDriver());
//        action.moveToElement(bottomOfCalculator).perform();
        ((JavascriptExecutor) driverManager.getDriver()).
                executeScript("window.scrollTo(0, 1600)");
        return pageManager.getMortgagePage();
    }

    public MortgagePage waitUntilFrameIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(calculatorFrame));
        driverManager.getDriver().switchTo().frame(calculatorFrame);
        return pageManager.getMortgagePage();
    }

    public MortgagePage openFieldsOfMortgages(){
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(filedToChooseMortgage));
        field.click();
        wait.until(ExpectedConditions.visibilityOf(mortgagesDropDown));
        return pageManager.getMortgagePage();
    }

    public MortgagePage chooseMortgage(String nameOfMortgage){
        for (WebElement mortgageOption: listOfMortgages) {
            if (mortgageOption.getText().contains(nameOfMortgage)) {
                mortgageOption.click();
                return pageManager.getMortgagePage();
            }
        }
        wait.until(ExpectedConditions.visibilityOf(driverManager.getDriver().findElement(By.xpath("//div[@class='ZFpSaFdiIj-_vWv7Q_jAV']"))));
        Assert.fail("После с названием '" + nameOfMortgage + "' не найдено");
        return pageManager.getMortgagePage();
    }

    public MortgagePage chooseKindOfMortgage(String nameOfKind) {
        for (WebElement kind: kindsOfMortgages) {
            if (kind.getText().contains(nameOfKind)) {
                kind.click();
                return pageManager.getMortgagePage();
            }
        }
        Assert.fail("Кнопки с именем '" + nameOfKind + "' не найдено");
        return pageManager.getMortgagePage();
    }

    public MortgagePage fulfillCostOfHouseInputField(String costOfHouse) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(costOfHouseInputField));
        while (!(Objects.equals(field.getAttribute("value"), ""))) {
            field.sendKeys(Keys.BACK_SPACE);
        }
        JavascriptExecutor jse = (JavascriptExecutor) driverManager.getDriver();
        jse.executeScript("arguments[0].value = '5180000'", field);
//        field.sendKeys(costOfHouse);
        Assert.assertEquals("Вводимые данные " + costOfHouse + " не соответвуют данным в поле " + costOfHouseInputField.getAttribute("value"), costOfHouse, costOfHouseInputField.getAttribute("value"));
        return pageManager.getMortgagePage();
    }

    public MortgagePage fuldillInitialPaymentInputField(String payment) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(initialPaymentInputField));
        while (!(Objects.equals(field.getAttribute("value"), ""))) {
            field.sendKeys(Keys.BACK_SPACE);
        }
        JavascriptExecutor jse = (JavascriptExecutor) driverManager.getDriver();
        jse.executeScript("arguments[0].value = '3058000'", field);
        Assert.assertEquals("Вводимые данные '" +
                payment + "' не соответвуют данным в поле '" + initialPaymentInputField.getAttribute("value") + "'",
                    payment, initialPaymentInputField.getAttribute("value"));
        return pageManager.getMortgagePage();
    }

    public MortgagePage fulfillLoanTermInputField(String loanTerm) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(loanTermInputField));
        while (!(Objects.equals(field.getAttribute("value"), ""))) {
            field.sendKeys(Keys.BACK_SPACE);
        }
        JavascriptExecutor jse = (JavascriptExecutor) driverManager.getDriver();
        jse.executeScript("arguments[0].value = '30'", field);
        Assert.assertEquals("Вводимые данные '" + loanTerm + "' не соответвуют данным в поле '" + loanTermInputField.getAttribute("value") + "'", loanTerm, loanTermInputField.getAttribute("value"));
        return pageManager.getMortgagePage();
    }

    public MortgagePage showingResults() {
        System.out.println(monthlyPaymentResult.getText());
        System.out.println(interestRateResult.getText());
        System.out.println(creditSumResult.getText());
        System.out.println(taxDeductionResult.getText());
//        System.out.println(requiredIncomeResult.getText());
        return pageManager.getMortgagePage();
    }

}
