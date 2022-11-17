package ru.sberbank.framework.steps;

import io.cucumber.java.ru.И;
import ru.sberbank.framework.managers.PageManager;

public class MortgagePageStep {

    PageManager pageManager = PageManager.getInstance();

    @И("^Скрол страницы до элементов заполнения$")
    public void crhjk() {
        pageManager.getMortgagePage().scrollToCalculator();
    }

    @И("^Открытия окна выбора вариантов ипотеки$")
    public void openFieldsOfMortgages() {
        pageManager.getMortgagePage().openFieldsOfMortgages();
    }

    @И("^Ожидание загрузки фрейма калькулятора и переключение на него$")
    public void waitUntilFrameIsVisible() {
        pageManager.getMortgagePage().waitUntilFrameIsVisible();
    }

    @И("^Выбор цели ипотеки с название (.+)$")
    public void chooseMortgage(String nameOfMortgage){
        pageManager.getMortgagePage().chooseMortgage(nameOfMortgage);
    }

    @И("^Выбор вида ипотеки с название (.+)$")
    public void chooseKindOfMortgage(String nameOfKind) {
        pageManager.getMortgagePage().chooseKindOfMortgage(nameOfKind);
    }

    @И("^Заполнение поля стоимости 'Стоимость недвижимости' данными (\\d*)$")
    public void fulfillCostOfHouseInputField(String costOfHouse) throws InterruptedException {
        pageManager.getMortgagePage().fulfillCostOfHouseInputField(costOfHouse);
    }

    @И("^Заполнения поля 'Первоначальный взнос'  данными (\\d*)$")
    public void fuldillInitialPaymentInputField(String payment) throws InterruptedException {
        pageManager.getMortgagePage().fuldillInitialPaymentInputField(payment);
    }

    @И("^Заполнения поля 'Срок кредита'  данными (\\d*)$")
    public void fulfillLoanTermInputField(String loanTerm) {
        pageManager.getMortgagePage().fulfillLoanTermInputField(loanTerm);
    }

    @И("Сравнение результатов")
    public void showingResults() {
        pageManager.getMortgagePage().showingResults();
    }


}
