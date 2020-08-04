package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;

public class StartPage extends BasePage {

    private String startMenu = "//div[@class='service']//div";

    @Step("Выбор раздела 'Вклады'")
    public DepositPage selectInStartMenu(String select) {
        $$x(startMenu).findBy(Condition.text(select)).click();
        return pageManager.getDepositPage();
    }
}
