package ru.sberbank.framework.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

public class MortgagePage extends BasePage{

    @FindBy(xpath = "//div[@id='calculator-root']//div[contains(@class, 'dc-input__input-container')]//label[contains(., 'Срок кредита')]")
    private WebElement bottomOfCalculator;

    @FindBy(xpath = "//div[@id='calculator-root']//div[@data-test-id='product-selector']")
    private WebElement filedToChooseMortgage;

    @FindBy(xpath = "//div[@role='listbox']")
    private WebElement mortgagesDropDown;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
    private List<WebElement> listOfMortgages;

    @FindBy(xpath = "//button[@type='button']//span[contains(@class, 'button-root__text')]")
    private List<WebElement> kindsOfMortgages;

    @FindBy(xpath = "//div[@data-e2e-id='mland-calculator/realty-cost-input-input']//input[contains(@class, 'dc-input')]")
    private WebElement costOfHouseInputField;

    @FindBy(xpath = "//div[@data-e2e-id='mland-calculator/initial-fee-input-input']//input[contains(@class, 'dc-input')]")
    private WebElement initialPaymentInputField;

    @FindBy(xpath = "//div[@data-e2e-id='mland-calculator/credit-term-input-input']//input[contains(@class, 'dc-input')]")
    private WebElement loanTermInputField;

    @FindBy(xpath = "//div[@data-e2e-id='mland-calculator/medium-conditions-list']//li[@data-e2e-id='mland-calculator/result-monthly-payment']//span")
    private WebElement monthlyPaymentResult;

    @FindBy(xpath = "//div[@data-e2e-id='mland-calculator/medium-conditions-list']//li[@data-e2e-id='mland-calculator/result-credit-rate']//span")
    private WebElement interestRateResult;

    @FindBy(xpath = "//div[@data-e2e-id='mland-calculator/medium-conditions-list']//li[@data-e2e-id='mland-calculator/result-credit-sum']//span")
    private WebElement creditSumResult;

    @FindBy(xpath = "//div[@data-test-id='main-results-block']//div[@data-e2e-id='mland-calculator/medium-conditions-list']//li[@data-e2e-id='mland-calculator/result-tax-deduction']//span/*[not(button)]")
    private WebElement taxDeductionResult;

    @FindBy(xpath = "//div[@data-e2e-id='mland-calculator/result-bottom-line']//div[@data-test-id='required-income-block']//span[contains(@class, '_26BvotuEdfUqvHxVLFI4HM')]")
    private WebElement requiredIncomeResult;



    public MortgagePage(){
        PageFactory.initElements(driverManager.getDriver(), this);
    }

    public MortgagePage scrollToCalculator(){
        ((JavascriptExecutor) driverManager.getDriver()).
                executeScript("arguments[0].scrollIntoView(true);", bottomOfCalculator);
        return pageManager.getMortgagePage();
    }

    public MortgagePage openFieldsOfMortgages(){
        filedToChooseMortgage.click();
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
        costOfHouseInputField.click();
        costOfHouseInputField.clear();
        costOfHouseInputField.sendKeys(costOfHouse);
        Assert.assertEquals("Вводимые данные '" + costOfHouse + "' не соответвуют данным в поле '" + costOfHouseInputField.getAttribute("value") + "'", costOfHouseInputField.getAttribute("value"), costOfHouse);
        return pageManager.getMortgagePage();
    }

    public MortgagePage fuldillInitialPaymentInputField(String payment){
        initialPaymentInputField.click();
        initialPaymentInputField.clear();
        initialPaymentInputField.sendKeys(payment);
        Assert.assertEquals("Вводимые данные '" + payment + "' не соответвуют данным в поле '" + initialPaymentInputField.getAttribute("value") + "'", initialPaymentInputField.getAttribute("value"), payment);
        return pageManager.getMortgagePage();
    }

    public MortgagePage fulfillLoanTermInputField(String loanTerm) {
        loanTermInputField.click();
        loanTermInputField.clear();
        loanTermInputField.sendKeys(loanTerm);
        Assert.assertEquals("Вводимые данные '" + loanTerm + "' не соответвуют данным в поле '" + loanTermInputField.getAttribute("value") + "'", loanTermInputField.getAttribute("value"), loanTerm);
        return pageManager.getMortgagePage();
    }

    public MortgagePage showingResults() {
        System.out.println(monthlyPaymentResult.getText());
        System.out.println(interestRateResult.getText());
        System.out.println(creditSumResult.getText());
        System.out.println(taxDeductionResult.getText());
        System.out.println(requiredIncomeResult.getText());
        return pageManager.getMortgagePage();
    }

}
