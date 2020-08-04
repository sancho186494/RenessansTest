package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class DepositPage extends BasePage {

    private String mainHeader = "//h1";
    private String currencySelectors = "//label[@class='calculator__currency-field']//span";
    private String inputFields = "//div[@class='calculator__slide-input-field']//input";
    private String periodsListOpenTrigger = "//div[@class='jq-selectbox__trigger']";
    private String depositPeriods = "//div[@id='period-styler']//li";
    private String additionalOptions = "//div[@class='calculator__check-row']//span";
    private String endCalculationResultsCheck = "//b[@class='m-fade-out']";
    private String earnedResult = "//span[@class='js-calc-earned']";
    private String replenishResult = "//span[@class='js-calc-replenish']";
    private String amountResult = "//span[@class='js-calc-result']";

    @Step("Выбор валюты")
    public DepositPage selectCurrency(String currency) {
        $x(mainHeader).scrollTo();
        $$x(currencySelectors).findBy(Condition.text(currency)).click();
        return this;
    }

    @Step("Заполнение поля 'Сумма вклада'")
    public DepositPage inputDepositSum(String sum) {
        $$x(inputFields).findBy(Condition.attribute("name", "amount")).
                sendKeys(sum);
        return this;
    }

    @Step("Указание срока вклада")
    public DepositPage selectDepositPeriod(String period) {
        $x(periodsListOpenTrigger).click();
        $$x(depositPeriods).findBy(Condition.text(period)).click();
        return this;
    }

    @Step("Заполнение поля 'Ежемесячное пополнение'")
    public DepositPage inputDepositReplenish(String replenish) {
        $$x(inputFields).findBy(Condition.attribute("name", "replenish")).
                sendKeys(replenish);
        return this;
    }

    @Step("Выбор дополнительных опций")
    public DepositPage selectAdditionalOptions(String option) {
        $$x(additionalOptions).findBy(Condition.text(option)).click();
        return this;
    }

    @Step("Выбор дополнительных опций")
    public DepositPage selectAdditionalOptions(String option1, String option2) {
        $$x(additionalOptions).findBy(Condition.text(option1)).click();
        $$x(additionalOptions).findBy(Condition.text(option2)).click();
        return this;
    }

    @Step("Проверка результатов")
    public DepositPage checkResults(String earned, String replenish, String amount) {
        $x(endCalculationResultsCheck).shouldBe(Condition.appear).shouldBe(Condition.disappear);
        Assertions.assertAll(
                () -> Assertions.assertEquals(earned,
                        $x(earnedResult).text(),
                        "Результат 'Начислено %:' не соответствует ожидаемому"),
                () -> Assertions.assertEquals(replenish,
                        $x(replenishResult).text(),
                        "Результат 'Пополнение за указанный период' не соответствует ожидаемому"),
                () -> Assertions.assertEquals(amount,
                        $x(amountResult).text(),
                        "Результат 'К снятию через 6 месяцев' не соответствует ожидаемому")
        );
        return this;
    }

}
