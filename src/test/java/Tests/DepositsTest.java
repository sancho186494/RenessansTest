package Tests;

import BaseTests.BaseTest;
import managers.PageManager;
import org.junit.jupiter.api.Test;

public class DepositsTest extends BaseTest {

    @Test
    public void runFirstCase() {
        PageManager.getPageManager().
                getStartPage().
                selectInStartMenu("Вклады").
                selectCurrency("Рубли").
                inputDepositSum("300000").
                selectDepositPeriod("6 месяцев").
                inputDepositReplenish("50000").
                selectAdditionalOptions("Ежемесячная капитализация").
                checkResults("7 422,56", "250 000", "557 422,56");
    }

    @Test
    public void runSecondCase() {
        PageManager.getPageManager().
                getStartPage().
                selectInStartMenu("Вклады").
                selectCurrency("Доллары США").
                inputDepositSum("500000").
                selectDepositPeriod("9 месяцев").
                inputDepositReplenish("30000").
                selectAdditionalOptions("Ежемесячная капитализация").
                checkResults("1 382,24", "240 000", "741 382,24");
    }
}
